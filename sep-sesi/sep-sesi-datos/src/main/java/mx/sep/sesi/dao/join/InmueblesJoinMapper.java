/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.dao.join;

import java.util.List;
import mx.sep.sesi.datos.vo.InmuebleVO;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author angel.adame
 */
public interface InmueblesJoinMapper {
    
    List<InmuebleVO> obtenerCatInmueble (@Param("idInmueble") Integer idInmueble);
    
}
