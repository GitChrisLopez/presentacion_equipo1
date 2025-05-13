/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

/**
 *
 * @author chris
 */
import dto.CandidatoDTO;
import java.util.*;

public class CandidatoON {

    private static CandidatoON instancia;
    List<CandidatoDTO> listaCandidatos = new ArrayList<>();

    private CandidatoON() {

        listaCandidatos.add(new CandidatoDTO("Francisco", "Mercado", "Mendivil", "(55) 1234-5678", "francisco@hotmail.com", "Contador Senior", false, "CVs/Francisco.pdf"));
        listaCandidatos.add(new CandidatoDTO("Julian", "Alonso", "Meneses" , "(55) 1244-4678", "julian@yop.mail.com", "Abogado Asociado", false, "CVs/Julian.pdf"));
        listaCandidatos.add(new CandidatoDTO("Jacqueline", "Thompson", "", "123-456-7890", "jacqueline@gmail.com", "Desarrollador de Software Junior", false, "CVs/Jacqueline.pdf"));
        listaCandidatos.add(new CandidatoDTO("Carlos", "Gómez","Gomez", "+52 987 654 3210", "carlos.gomez@email.com", "Desarrollador Backend", false, "CVs/Carlos.pdf"));
    }

    public static synchronized CandidatoON getInstance() {
        if (instancia == null) {
            instancia = new CandidatoON();
        }
        return instancia;
    }

    public synchronized void agregarCandidato(CandidatoDTO candidato) {
        listaCandidatos.add(candidato);
    }

    public synchronized List<CandidatoDTO> obtenerCandidatos() {
        return listaCandidatos;
    }

}
