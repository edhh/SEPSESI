/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios;

import java.util.List;
import mx.sep.sesi.datos.vo.InmuebleVO;
import mx.sep.sesi.modelo.Tses009Inmuebles;

/**
 *
 * @author angel.adame
 */
public interface CatInmuebleService {
    
      List<InmuebleVO> obtenerCatInmueble (Integer idInmueble);
      
      String crearInmuebleCat(InmuebleVO cinmuebleVO);
      
      Tses009Inmuebles obtenerInmueble(Integer idInmueble);
    
}
