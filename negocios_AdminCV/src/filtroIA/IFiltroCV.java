/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package filtroIA;

import dto.CandidatoDTO;
import java.io.File;
import java.util.List;

/**
 *
 * @author Ragzard
 */
public interface IFiltroCV {

    public List<CandidatoDTO> filtrarPorPalabrasClave(List<CandidatoDTO> candidatos, List<String> palabrasClave);
    
}
