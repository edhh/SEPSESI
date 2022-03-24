/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.dao.join;


import mx.sep.sesi.datos.vo.UsuarioVO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *
 * @author pedro.flores
 */
public interface UsuariosJoinMapper {
    
    
    UsuarioVO consultarPorNombreUsu(@Param("nombreUsu") String nombreUsu);
    
    List<UsuarioVO> obtenerCatUsuario (@Param("idRol") Integer idRol, @Param("idUr") Integer idUr, @Param("idInmueble") Integer idInmueble);
    
    UsuarioVO obtenerUsuarioporID (@Param("idUsuario") Integer idUsuario);
}
