/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.sep.sesi.servicios;

import java.math.BigDecimal;
import java.util.List;
import mx.sep.sesi.datos.vo.FirmantesVO;
import mx.sep.sesi.modelo.Tses020Firmantes;

/**
 *
 * @author angel.adame
 */
public interface CatFirmantesService {
    
    List<FirmantesVO> obtenerCatFirmante(Integer idUr);
    
    //FirmantesVO insertaFirmante(FirmantesVO cfirmanteVO);
    String insertaFirmante(FirmantesVO cfirmanteVO);
    
    Tses020Firmantes obtenerFirmante(Integer idFirmante);
    
    List<Tses020Firmantes> verificaUR(Tses020Firmantes tses020Firmantes);
    
}
