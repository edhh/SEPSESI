/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.impl;

import mx.sep.sesi.dao.Tses001UsuariosMapper;
import mx.sep.sesi.datos.vo.ConfigUsuarioVO;
import mx.sep.sesi.modelo.Tses001Usuarios;
import mx.sep.sesi.servicios.ConfiguracionServicio;
import mx.sep.sesi.servicios.util.ErrorInfraestructura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel.adame
 */
@Service
public class ConfiguracionServicioImpl implements ConfiguracionServicio {
    
     @Autowired
    private ShaPasswordEncoder passwordEncoder;
     
     @Autowired
    private Tses001UsuariosMapper tses001UsuariosMapper;
    
    public void cambioContrasena(ConfigUsuarioVO configUsuarioVO) throws Exception{
        
         Tses001Usuarios tses001Usuarios = new Tses001Usuarios();
         try {
         String encodedPassword = passwordEncoder.encodePassword(configUsuarioVO.getContrasena(), null);
         tses001Usuarios.setIdUsuario(configUsuarioVO.getIdUsuario());
         tses001Usuarios.setNombreUsu(configUsuarioVO.getNombreUsu());
         tses001Usuarios.setContrasena(encodedPassword);
         tses001UsuariosMapper.updateByPrimaryKeySelective(tses001Usuarios);
         
         } catch (Exception exc) {
            throw new ErrorInfraestructura("No se pudo efectuar la modificación de contraseña", exc);
        }
     }
    
}
