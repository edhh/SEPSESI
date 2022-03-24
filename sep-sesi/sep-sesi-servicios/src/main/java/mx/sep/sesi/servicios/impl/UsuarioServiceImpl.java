/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.impl;

import java.util.List;
import mx.sep.sesi.dao.Tses001UsuariosMapper;
import mx.sep.sesi.dao.Tses023ParametrosMapper;
import mx.sep.sesi.dao.join.UsuariosJoinMapper;
import mx.sep.sesi.datos.vo.UsuarioVO;
import mx.sep.sesi.modelo.Tses001Usuarios;
import mx.sep.sesi.modelo.Tses001UsuariosExample;
import mx.sep.sesi.modelo.Tses023Parametros;
import mx.sep.sesi.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro.flores
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuariosJoinMapper usuariosJoinMapper;
    
    @Autowired
    Tses001UsuariosMapper  tses001UsuariosMapper;
     
    @Autowired
    private Tses023ParametrosMapper tses023ParametrosMapper;
    
    
    public UsuarioVO consultarPorNombreUsu(String nombreUsu) {        
        UsuarioVO usuarioVO = usuariosJoinMapper.consultarPorNombreUsu(nombreUsu);
        return usuarioVO;
    }    
    
        
   public List<Tses001Usuarios> consultarPorUsuario(Tses001Usuarios tses001Usuarios) throws Exception {
       
        Tses001UsuariosExample tses001Example = new Tses001UsuariosExample();
        tses001Example.createCriteria().andNombreUsuEqualTo(tses001Usuarios.getNombreUsu());
        return tses001UsuariosMapper.selectByExample(tses001Example);
    }
   
   /**
     * Función que obtiene los segundos disponibles para la sesión
     */
    public String obtieneSegundosSesion(){
        Tses023Parametros tses023Parametros = new Tses023Parametros();
        tses023Parametros = tses023ParametrosMapper.selectByPrimaryKey(new Integer(3));
        String url = tses023Parametros.getValor();
        return url;

    }
    
}
