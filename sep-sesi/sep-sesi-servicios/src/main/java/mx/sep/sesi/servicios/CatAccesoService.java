/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios;

import java.math.BigDecimal;
import java.util.List;
import mx.sep.sesi.datos.vo.AccesoVO;
import mx.sep.sesi.modelo.Tses013Accesos;

/**
 *
 * @author angel.adame
 */
public interface CatAccesoService {
    
     List<AccesoVO> obtenerCatAcceso (Integer idInmueble);
     
     String crearAccesoCat(AccesoVO caccesoVO);
     
     Tses013Accesos obtenerAcceso (Integer idAcceso);
     
     public String eliminaAccesoCat(AccesoVO daccesoVO);
    
}
