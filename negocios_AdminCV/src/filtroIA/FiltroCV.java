package filtroIA;

import dto.CandidatoDTO;
import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.pdfbox.Loader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;

public class FiltroCV implements IFiltroCV {

    @Override
    public List<CandidatoDTO> filtrarPorPalabrasClave(List<CandidatoDTO> candidatos, List<String> palabrasClave) {
        List<CandidatoDTO> filtrados = new ArrayList<>();
        String rutaBase = System.getProperty("user.dir");

        System.out.println("Filtrando " + candidatos.size() + " candidatos con " + palabrasClave.size() + " palabras clave");
        System.out.println("Ruta base: " + rutaBase);

        for (CandidatoDTO candidato : candidatos) {
            // Verificar que el candidato tenga una ruta de PDF válida
            if (candidato.getRutaPDF() == null || candidato.getRutaPDF().isEmpty()) {
                System.err.println("Candidato sin ruta PDF: " + candidato.getNombre());
                continue;
            }

            // Construir la ruta completa del archivo
            String rutaCompleta = rutaBase + "/../objetos_negocios/src/" + candidato.getRutaPDF();
            File archivo = new File(rutaCompleta);

            System.out.println("Verificando archivo: " + rutaCompleta);

            if (!archivo.exists()) {
                System.err.println("El archivo no existe: " + rutaCompleta);
                continue;
            }

            try (PDDocument documento = Loader.loadPDF(archivo)) {
                PDFTextStripper stripper = new PDFTextStripper();
                String texto = stripper.getText(documento).toLowerCase();

                boolean contienePalabra = false;
                for (String palabra : palabrasClave) {
                    if (texto.contains(palabra.toLowerCase())) {
                        contienePalabra = true;
                        System.out.println("Candidato: " + candidato.getNombre() + " contiene palabra: " + palabra);
                        break;
                    }
                }

                if (contienePalabra) {
                    filtrados.add(candidato);
                }

            } catch (IOException e) {
                System.err.println("Error al leer el archivo PDF: " + rutaCompleta);
                e.printStackTrace();
            }
        }

        System.out.println("Total candidatos filtrados: " + filtrados.size());
        return filtrados;
    }

    public static String evaluarCVConIA(String contenidoCV, List<String> palabrasClave) throws Exception {
        String apiKey = "HUGGING TOKEN"; //token de Hugging Face

        //hacer una lista de requisitos a partir de las palabras clave que ponga el reclutador
        StringBuilder requisitos = new StringBuilder();
        if (palabrasClave != null && !palabrasClave.isEmpty()) {
            requisitos.append("los siguientes requisitos: ");
            for (int i = 0; i < palabrasClave.size(); i++) {
                requisitos.append(palabrasClave.get(i));
                if (i < palabrasClave.size() - 1) {
                    requisitos.append(", ");
                }
            }
        } else {
            requisitos.append("los requisitos generales del puesto");
        }

        //usamos una palabara y signos especificos en el prompt poder eliminarlo
        String promptIdentifier = "###INSTRUCCIONES###";
        String promptContent = String.format("""
                      Eres un empleado de RRHH. INSTRUCCIONES IMPORTANTES:
                      1. Lee el CV del candidato y evalua si cumple con %s.
                      2. NO repitas información del CV original bajo ninguna circunstancia.
                      3. Tu respuesta debe comenzar DIRECTAMENTE con "ANÁLISIS:" seguido de tu evaluación.
                      4. Proporciona un análisis conciso en ESPAÑOL del candidato, usando **menos de 120 palabras exactas**.
                      5. Se estricto al evaluar, si el candidato **NO cumple con TODOS** los requisitos entonces NO es apto, se muy estricto, formal y critico. requisitos: %s.
                      6. Concluye con la palabra 'APTO' o 'NO APTO' en mayúsculas.
                      """,
                requisitos.toString().replace("%", "%%"),
                requisitos.toString().replace("%", "%%"));

        String prompt = promptIdentifier + "\n" + promptContent + "\n\n" + contenidoCV;

        String requestBody = "{\"inputs\": " + escapeJsonString(prompt) + "}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-inference.huggingface.co/models/mistralai/Mixtral-8x7B-Instruct-v0.1"))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //imprimimos completo en consola y solo 200 caracteres en el msj del usuario
        if (response.statusCode() != 200) {
            String body = response.body();
            System.err.println("API error " + response.statusCode() + ": " + body);
            String snippet = body.length() > 200 ? body.substring(0, 200) + "..." : body;
            throw new IOException("API error " + response.statusCode() + ": " + snippet);
        }

        //si todo está bien, se procesan los resultados
        JSONArray arr = new JSONArray(response.body());
        String respuestaCompleta = arr.getJSONObject(0).getString("generated_text");

        //filtrar para eliminar el prompt y cualquier contenido previo al análisis
        return filtrarRespuestaIA(respuestaCompleta, promptIdentifier, promptContent, contenidoCV);
    }

    private static String filtrarRespuestaIA(String respuestaCompleta, String promptIdentifier,
            String promptContent, String contenidoCV) {
        String respuestaLower = respuestaCompleta.toLowerCase();

        //eliminar el prompt de la respuesta
        int posIdentifier = respuestaLower.indexOf(promptIdentifier.toLowerCase());
        if (posIdentifier != -1) {
            //si encontramos el identificador, eliminamos desde ahi hasta el final
            respuestaCompleta = respuestaCompleta.substring(posIdentifier + promptIdentifier.length());
            respuestaLower = respuestaLower.substring(posIdentifier + promptIdentifier.length());
        }

        //buscamos fragmentosdel prompt que podrían estar en la respuesta
        String[] fragmentosPrompt = {
            "eres un empleado de rrhh",
            "instrucciones importantes",
            "lee el cv del candidato",
            "no repitas información",
            "tu respuesta debe comenzar",
            "proporciona un análisis breve",
            "concluye con la palabra"
        };

        for (String fragmento : fragmentosPrompt) {
            int posFragmento = respuestaLower.indexOf(fragmento);
            if (posFragmento != -1) {
                int finInstruccion = respuestaLower.indexOf("\n", posFragmento);
                if (finInstruccion != -1) {
                    //si hay un fin de línea después de este fragmento, continuamos buscando hasta que tengamos todo eliminado
                    respuestaLower = respuestaLower.substring(finInstruccion + 1);
                    respuestaCompleta = respuestaCompleta.substring(finInstruccion + 1);
                }
            }
        }

        //intentamos eliminar cualquier contenido del CV que haya sido repetido
        //esto es complejo pero se intenta con tomar las primeras líneas del CV para detectar si se repite
        String[] lineasCV = contenidoCV.split("\n", 5); //primeras 5 lineas como muestra
        for (String linea : lineasCV) {
            if (linea.trim().length() > 15) { //solo consideramos líneas con contenido sustancial
                int posLinea = respuestaLower.indexOf(linea.toLowerCase());
                if (posLinea != -1) {
                    //si encontramos una linea del CV, eliminamos todo hasta el final de esa línea
                    int finLinea = respuestaLower.indexOf("\n", posLinea);
                    if (finLinea != -1) {
                        respuestaLower = respuestaLower.substring(finLinea + 1);
                        respuestaCompleta = respuestaCompleta.substring(finLinea + 1);
                    }
                }
            }
        }

        //buscamos las palabras clave que indican el inicio del analisis real
        int posAnalisisPuntos = respuestaLower.indexOf("análisis:");
        int posAnalisisPuntosSinTilde = respuestaLower.indexOf("analisis:");
        int posResumen = respuestaLower.indexOf("resumen");
        int posAnalisis = respuestaLower.indexOf("análisis");
        int posAnalisisSinTilde = respuestaLower.indexOf("analisis");

        //encontramos la primera ocurrencia de cualquiera de estas palabras
        int posInicio = -1;

        //priorizamos las palabras con ":" que indican el formato que pedimos
        if (posAnalisisPuntos != -1) {
            posInicio = posAnalisisPuntos;
        }

        if (posAnalisisPuntosSinTilde != -1 && (posInicio == -1 || posAnalisisPuntosSinTilde < posInicio)) {
            posInicio = posAnalisisPuntosSinTilde;
        }

        if (posResumen != -1 && (posInicio == -1 || posResumen < posInicio)) {
            posInicio = posResumen;
        }

        if (posAnalisis != -1 && (posInicio == -1 || posAnalisis < posInicio)) {
            posInicio = posAnalisis;
        }

        if (posAnalisisSinTilde != -1 && (posInicio == -1 || posAnalisisSinTilde < posInicio)) {
            posInicio = posAnalisisSinTilde;
        }

        //si se encuentra alguna de las palabras se corta el texto
        if (posInicio != -1) {
            respuestaCompleta = respuestaCompleta.substring(posInicio);
        }

        //limpiamos
        respuestaCompleta = respuestaCompleta.trim();

        return respuestaCompleta;
    }

    private static String escapeJsonString(String input) {
        if (input == null) {
            return "null";
        }

        StringBuilder output = new StringBuilder("\"");
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '"':
                    output.append("\\\"");
                    break;
                case '\\':
                    output.append("\\\\");
                    break;
                case '\b':
                    output.append("\\b");
                    break;
                case '\f':
                    output.append("\\f");
                    break;
                case '\n':
                    output.append("\\n");
                    break;
                case '\r':
                    output.append("\\r");
                    break;
                case '\t':
                    output.append("\\t");
                    break;
                default:
                    if (ch < ' ') {
                        output.append(String.format("\\u%04x", (int) ch));
                    } else {
                        output.append(ch);
                    }
                    break;
            }
        }
        output.append("\"");
        return output.toString();
    }

    public static String normalizar(String texto) {
        texto = texto.toLowerCase();
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return texto;
    }

    public static String extraerTextoPDF(File archivo) throws IOException {
        try (PDDocument documento = Loader.loadPDF(archivo)) {
            return new PDFTextStripper().getText(documento);
        }
    }

    public static String obtenerResultados(CandidatoDTO candidato, List<String> palabrasClave) {
        try {
            //usamos la ruta del PDF del candidato seleccionado correcto
            String rutaCompleta = System.getProperty("user.dir") + "/../objetos_negocios/src/" + candidato.getRutaPDF();
            File archivo = new File(rutaCompleta);

            if (!archivo.exists()) {
                System.err.println("El archivo no existe: " + archivo.getAbsolutePath());
                return "No se encontró el archivo PDF del candidato.";
            }

            String contenido = extraerTextoPDF(archivo);
            //por si acaso aplicamos filtrado aquí también xd
            String respuestaIA = evaluarCVConIA(contenido, palabrasClave);

            //filtramos la respuesta nuevamente, devolvemos la respuesta que ya viene filtrada de evaluarCVConIA
            return respuestaIA;

        } catch (IOException e) {
            //imprimir el error completo en consola
            System.err.println("Error al leer o procesar el CV: " + e.getMessage());
            e.printStackTrace();

            //mostrar solo un mensaje conciso en el JOptionPane
            String msg = e.getMessage();
            if (msg != null && msg.length() > 200) {
                msg = msg.substring(0, 200) + "...";
            }
            JOptionPane.showMessageDialog(
                    null,
                    "Error al leer o procesar el CV:\n" + msg,
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return "No se pudo procesar el archivo.";

        } catch (Exception e) {
            //imprimir el error completo en consola
            System.err.println("Error con la IA: " + e.getMessage());
            e.printStackTrace();  // Esto imprime todo el stacktrace

            //mostrar solo un mensaje conciso en el JOptionPane
            String msg = e.getMessage();
            if (msg != null && msg.length() > 200) {
                msg = msg.substring(0, 200) + "...";
            }
            JOptionPane.showMessageDialog(
                    null,
                    "Error con la IA:\n" + msg,
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return "No se pudo procesar con IA.";
        }
    }
}
