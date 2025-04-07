/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filtroIA;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.Loader;
import java.text.Normalizer;

/**
 *
 * @author chris
 */
public class Negocios_FiltroIA {

    //Tuve que utilizar esto ya que si en el CV cierts palabras llevan tilde, no se detectan normalmente :P
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

    public static boolean aceptarCV(String contenidoCV) {
        contenidoCV = normalizar(contenidoCV);
        return contenidoCV.contains("java") || contenidoCV.contains("javascript")
                && contenidoCV.contains("github")
                && contenidoCV.contains("ingles");
    }

    public static String resultadosFiltro(String contenidoCV) {
        StringBuilder resultado = new StringBuilder();
        contenidoCV = normalizar(contenidoCV);
        contenidoCV = contenidoCV.toLowerCase();
        boolean cumpleRequisitos = false;

        if (contenidoCV.contains("java")) {
            resultado.append("El candidato tiene conocimiento con JAVA.\n");
            cumpleRequisitos = true;
        }
        if (contenidoCV.contains("php")) {
            resultado.append("El candidato tiene conocimiento con PHP.\n");
            cumpleRequisitos = true;
        }
        if (contenidoCV.contains("c++")) {
            resultado.append("El candidato tiene conocimiento con C++.\n");
            cumpleRequisitos = true;
        }
        if (contenidoCV.contains("html")) {
            resultado.append("El candidato tiene conocimiento con HTML.\n");
            cumpleRequisitos = true;
        }
        if (contenidoCV.contains("javascript")) {
            resultado.append("El candidato conocimiento con JavaScript.\n");
            cumpleRequisitos = true;
        }
        if (contenidoCV.contains("python")) {
            resultado.append("El candidato conocimiento con Python.\n");
            cumpleRequisitos = true;
        }
        if (contenidoCV.contains("react")) {
            resultado.append("El candidato conocimiento con React.\n");
            cumpleRequisitos = true;
        }
        if (contenidoCV.contains("mysql")) {
            resultado.append("El candidato conocimiento con MySQL.\n");
            cumpleRequisitos = true;
        }
        if (contenidoCV.contains("frontend")) {
            resultado.append("El candidato esta especializado en la programacion de Frontend.\n");
            cumpleRequisitos = true;
        }
        if (contenidoCV.contains("backend")) {
            resultado.append("El candidato esta especializado en la programacion de Backend.\n");
            cumpleRequisitos = true;
        }
        if (contenidoCV.contains("experiencia laboral")) {
            resultado.append("El candidato ha tenido experiencia laboral.\n");
            cumpleRequisitos = true;
        }

        if (!cumpleRequisitos) {
            resultado.append("El candidato no cuenta con ninguno de los requisitos que necesitados para el puesto.");
        }

        return resultado.toString();
    }

    public static boolean filtrarCV(String rutaPDF) {
        try {
            File archivo = corregirRutaPDF(rutaPDF);
            String contenido = extraerTextoPDF(archivo);
            return aceptarCV(contenido);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el CV:\n" + e.getMessage());
            return false;
        }
    }

    public static String obtenerResultados(String rutaPDF) {
        try {
            File archivo = corregirRutaPDF(rutaPDF);
            String contenido = extraerTextoPDF(archivo);
            return resultadosFiltro(contenido);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el CV:\n" + e.getMessage());
            return "No se pudo procesar el archivo.";
        }
    }

    public void abrirPDF(String rutaPDF) {
        try {
            File archivo = corregirRutaPDF(rutaPDF);

            if (!archivo.exists()) {
                JOptionPane.showMessageDialog(null, "El archivo no existe: " + archivo.getAbsolutePath());
                return;
            }

            java.awt.Desktop.getDesktop().open(archivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo PDF:\n" + e.getMessage());
        }
    }

    private static File corregirRutaPDF(String rutaOriginal) {
        File archivo = new File(rutaOriginal);

        if (archivo.getAbsolutePath().contains("presentacion_RH")) {
            String nuevoPath = archivo.getAbsolutePath().replace("presentacion_RH", "objetos_negocios/src");
            archivo = new File(nuevoPath);
        }

        System.out.println("Ruta final del archivo PDF: " + archivo.getAbsolutePath());
        return archivo;
    }
}
