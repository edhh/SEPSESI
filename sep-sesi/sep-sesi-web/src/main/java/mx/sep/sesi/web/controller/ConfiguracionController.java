/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.web.controller;


import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.util.SeguridadUtil;
import mx.sep.sesi.datos.vo.ConfigUsuarioVO;
import mx.sep.sesi.datos.vo.UsuarioVO;
import mx.sep.sesi.servicios.ConfiguracionServicio;
import mx.sep.sesi.servicios.UsuarioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author angel.adame
 */
@Controller
@RequestMapping(value = "/configuracion")
public class ConfiguracionController {
    
    private static final Logger logger = Logger.getLogger(ConfiguracionController.class);

    @Autowired
    private ConfiguracionServicio configuracionServicio;

    @Autowired
    private UsuarioService usuarioService;
    
     @RequestMapping(value = "/obtenerUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> obtenerUsuario() {
		mx.sep.seguridad.modelo.UsuarioSeguridad usuario = new mx.sep.seguridad.modelo.UsuarioSeguridad();
		try {
			UsuarioSeguridad usuarioSeguridad = SeguridadUtil.getUsuarioActual();
                        usuario.setNombre(usuarioSeguridad.getNombre());
			usuario.setUsername(usuarioSeguridad.getUsername());
                            
		} catch (Exception ex) {
			logger.error("Error al obtener el usuario de seguridad.", ex);
			String mensaje = "No se pudo realizar la busqueda solicitada:" + " por favor intente más tarde";
			return new ResponseEntity<String>(mensaje, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<mx.sep.seguridad.modelo.UsuarioSeguridad>(usuario, HttpStatus.OK);

	}  

    
    
     @RequestMapping(value = "/cambioContrasena.htm", method = RequestMethod.POST)
    @ResponseBody               
    public String cambioContrasena( @RequestParam String nombreUsu, @RequestParam String contrasena) throws Exception {
         String result = "";
        System.out.println("userName --> " + nombreUsu);
        System.out.println("passWord --> " + contrasena);
        UsuarioVO usuarioSearch = new UsuarioVO();
        usuarioSearch.setNombreUsu(nombreUsu);
        
        UsuarioVO usuarioVO = usuarioService.consultarPorNombreUsu(nombreUsu);
        
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        /*String rol = us.getRoles().get(0).getRol();        
        BigDecimal idRol = usuarioService.obtieneIdRolUsuario(rol);*/
        
        if( usuarioVO == null ){
            result = "noUser";
        } else { 
                if( !nombreUsu.equals(us.getUsername())){
                return result = "noPermitido";
                }
        ConfigUsuarioVO configUsuarioVO = new ConfigUsuarioVO();
        configUsuarioVO.setIdUsuario(usuarioVO.getIdUsuario());
        configUsuarioVO.setNombreUsu(nombreUsu);
        configUsuarioVO.setContrasena(contrasena);
        configuracionServicio.cambioContrasena(configUsuarioVO);
       result = "exito";  
        }
        return result;
    }

}
