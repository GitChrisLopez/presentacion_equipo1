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

        for (CandidatoDTO candidato : candidatos) {
            File archivo = new File(rutaBase + "/../objetos_negocios/src/" + candidato.getRutaPDF());

            if (!archivo.exists()) {
                System.err.println("El archivo no existe: " + archivo.getAbsolutePath());
                continue;
            }

            try (PDDocument documento = Loader.loadPDF(archivo)) {
                PDFTextStripper stripper = new PDFTextStripper();
                String texto = stripper.getText(documento).toLowerCase();

                for (String palabra : palabrasClave) {
                    if (texto.contains(palabra.toLowerCase())) {
                        filtrados.add(candidato);
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo PDF: " + archivo.getAbsolutePath());
                e.printStackTrace();
            }
        }

        return filtrados;
    }

    public static String evaluarCVConIA(String contenidoCV, List<String> palabrasClave) throws Exception {
        String apiKey = "hugging token"; //token de Hugging Face

        //hacer una lista de requisitos a partir de las palabras clave que ponga el reclutadoor
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

        String prompt = String.format("""
                                      Eres un empleado de RRHH. INSTRUCCIONES IMPORTANTES:
                                      1. Lee el CV del candidato y evalua si cumple con %s.
                                      2. NO repitas informacion del CV original.
                                      3. Responde SOLO con un analisis breve y conciso (maximo 120 palabras).
                                      4. Enfocate en mencionar solo las habilidades relevantes para el puesto.
                                      5. Concluye claramente si el candidato es apto o no para el puesto.
                                      
                                      %s""", 
                requisitos.toString(), contenidoCV);

        String requestBody = "{\"inputs\": " + escapeJsonString(prompt) + "}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-inference.huggingface.co/models/mistralai/Mistral-Nemo-Instruct-2407"))
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
        return arr.getJSONObject(0).getString("generated_text");
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
            return evaluarCVConIA(contenido, palabrasClave);

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