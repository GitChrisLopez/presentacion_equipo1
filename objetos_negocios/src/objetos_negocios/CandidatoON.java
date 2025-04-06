/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos_negocios;

/**
 *
 * @author chris
 */
import dto_negocios.CVDTO;
import java.util.*;

public class CandidatoON {

    private static CandidatoON instancia;
    List<CVDTO> listaCandidatos = new ArrayList<>();

    private CandidatoON() {

        listaCandidatos.add(new CVDTO("Francisco", "Mercado", "(55) 1234-5678", "francisco@hotmail.com", "Contador Senior", true));
        listaCandidatos.add(new CVDTO("Julian", "Alonso", "(55) 1244-4678", "julian@yop.mail.com", "Abogado Asociado", true));
        listaCandidatos.add(new CVDTO("Jacqueline", "Thompson", "123-456-7890", "jacqueline@gmail.com", "Desarrollador de Software Junior", true));
        listaCandidatos.add(new CVDTO("Carlos", "Gómez", "+52 987 654 3210", "carlos.gomez@email.com", "Desarrollador Backend", true));
    }
    
    public static synchronized CandidatoON getInstance() { 
        if (instancia == null) { 
            instancia = new CandidatoON(); 
        } 
        return instancia; 
    } 
    
    public synchronized void agregarCandidato(CVDTO candidato) { 
        listaCandidatos.add(candidato); 
    } 
    public synchronized List<CVDTO> obtenerCandidatos() { 
        return listaCandidatos; 
    }

}
