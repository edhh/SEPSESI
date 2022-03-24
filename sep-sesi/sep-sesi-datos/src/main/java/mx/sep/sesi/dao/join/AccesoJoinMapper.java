/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.dao.join;

import java.math.BigDecimal;
import java.util.List;
import mx.sep.sesi.datos.vo.AccesoVO;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author angel.adame
 */
public interface AccesoJoinMapper {
    
     List<AccesoVO> obtenerCatAcceso (@Param("idInmueble") Integer idInmueble);
    
}
