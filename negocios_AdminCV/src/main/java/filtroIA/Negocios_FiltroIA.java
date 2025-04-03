/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package filtroIA;

import java.io.*;
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

}
