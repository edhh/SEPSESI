/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.sep.sesi.servicios;


import java.util.List;
import mx.sep.sesi.datos.vo.UsuarioVO;
import mx.sep.sesi.modelo.Tses001Usuarios;

/**
 *
 * @author angel.adame
 */
public interface CatUsuarioService {
    
     List<UsuarioVO> obtenerCatUsuario(Integer idRol, Integer idUr, Integer idInmueble);
     
     String crearUsuarioCat(UsuarioVO cusuarioVO);
     
     //Tses001Usuarios obtenerUsuario(BigDecimal idUsuario);
     
      UsuarioVO obtenerUsuario(Integer idUsuario);
      
      String verificaCurp(String curp);
     
     //UsuarioVO actualizarUsuarioCat(UsuarioVO nusuarioVO);
     
     //void eliminarUsuarioCat (UsuarioVO dusuarioVO);
    
}
