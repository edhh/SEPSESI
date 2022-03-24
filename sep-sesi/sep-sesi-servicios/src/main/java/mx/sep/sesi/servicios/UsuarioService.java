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
 * @author pedro.flores
 */
public interface UsuarioService {
    
    UsuarioVO consultarPorNombreUsu(String nombreUsu);
    
    List<Tses001Usuarios> consultarPorUsuario(Tses001Usuarios tses001Usuarios) throws Exception;
      
    String obtieneSegundosSesion() throws Exception;
    
}
