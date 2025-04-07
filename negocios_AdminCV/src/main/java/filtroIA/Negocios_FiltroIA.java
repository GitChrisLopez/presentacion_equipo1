/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package filtroIA;

import java.awt.Component;
import java.awt.Desktop;
import java.io.*;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author chris
 */
public class Negocios_FiltroIA {

    public static String extraerTextoPDF(File archivo) throws IOException {
        try (PDDocument documento = PDDocument.load(archivo)) {
            return new PDFTextStripper().getText(documento);
        }
    }

    public static boolean aceptarCV(String contenidoCV) {
        if (!contenidoCV.toLowerCase().contains("Java")) {
            return false;
        }
        if (!contenidoCV.toLowerCase().contains("Github")) {
            return false;
        }
        if (contenidoCV.toLowerCase().contains("Tlaxcala")) {
            return false;
        }
        return true;
    }

    public static boolean filtrarCV(File archivo) throws IOException {
        String contenidoCV = extraerTextoPDF(archivo);
        return aceptarCV(contenidoCV);
    }

    public void abrirPDF(String rutaPDF) {
        try {
            File archivo = new File(rutaPDF);

            // verifica si el archivo está en la carpeta 'presentacion_RH' y ajusta la ruta
            if (archivo.getAbsolutePath().contains("presentacion_RH")) {
                String nuevoPath = archivo.getAbsolutePath().replace("presentacion_RH", "objetos_negocios/src");
                archivo = new File(nuevoPath);
            }

            System.out.println("ruta: " + archivo.getAbsolutePath());

            if (!archivo.exists()) {
                JOptionPane.showMessageDialog(null, "El archivo no existe: " + archivo.getAbsolutePath());
                return;
            }

            java.awt.Desktop.getDesktop().open(archivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo PDF:\n" + e.getMessage());
        }
    }

}
