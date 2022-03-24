/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.dao.join;

import java.util.List;
import mx.sep.sesi.datos.vo.CuadranteVO;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author heriberto.perez
 */
public interface CuadranteJoinMapper {
    
    List<CuadranteVO> obtenerCuadrante(@Param("inmueble") Integer inmueble);
    
}
