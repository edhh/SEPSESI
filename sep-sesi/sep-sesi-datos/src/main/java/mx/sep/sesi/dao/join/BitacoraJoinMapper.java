/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.dao.join;


import java.util.Date;
import java.util.List;
import mx.sep.sesi.datos.vo.BitacoraVO;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author angel.adame
 */
public interface BitacoraJoinMapper {
    
    //List <BitacoraVO> obtenerUsuarioConsulta(BitacoraVO bitacora);
    List <BitacoraVO> obtenerUsuarioConsulta(@Param("idTradServicio") Integer idTradServicio, @Param("nombreUsu") String nombreUsu, @Param("fechaOpIni") Date fechaOpIni,  @Param("fechaOpFin") Date fechaOpFin);
    
}
