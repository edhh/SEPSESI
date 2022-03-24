/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.sep.sesi.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.util.SeguridadUtil;
import mx.sep.sesi.datos.vo.UsuarioVO;
import mx.sep.sesi.modelo.Tses001Usuarios;
import mx.sep.sesi.servicios.CatUsuarioService;
import mx.sep.sesi.servicios.util.LoggerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author angel.adame
 */

@Controller
@RequestMapping(value = "/admin")
public class CatUsusariosController {
    
    private static final Logger LOGGER = Logger.getLogger(CatUsusariosController.class);
    
    @Autowired
    CatUsuarioService usuarioService;
    
    @RequestMapping(value = "/obtenerCatUsuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     //public @ResponseBody ResponseEntity<?> obtenerCatUsuario (@RequestParam Integer idRol, @RequestParam Integer idUr, @RequestParam Integer idInmueble){
     public @ResponseBody ResponseEntity<?> obtenerCatUsuario (@RequestParam Integer idRol, @RequestParam Integer idUr, @RequestParam Integer idInmueble){
         
           UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "Roles " + us.getRoles());

        List<UsuarioVO> lstUsuarios = null;

        try {

            lstUsuarios = usuarioService.obtenerCatUsuario(idRol, idUr, idInmueble);

            return new ResponseEntity<List<UsuarioVO>>(lstUsuarios, HttpStatus.OK);
        } catch (Exception exc) {
            exc.printStackTrace();
            return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
        }

    }
         
         
    
   
    /*@RequestMapping(value = "/obtenerCatUsuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ModelAndView obtenerCatUsuario(){
        LOGGER.info("obtenerCatUsuario");
        ModelAndView modelAndView = new ModelAndView("admin/catUsuarios");
        cargarCatUsuario(modelAndView);
        modelAndView.addObject("usuarioVO", new UsuarioVO());
        return modelAndView;
        
    }*/
    
    
   /*@RequestMapping(value = "/crearUsuarioCat", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> crearUsuarioCat(@RequestBody UsuarioVO cusuarioVO) {

        String success = "OK";
        UsuarioVO usuarioCatCreado = null;
        System.out.println("entrando a controller");

        try {
            LOGGER.info(cusuarioVO.toString());
            usuarioCatCreado = usuarioService.crearUsuarioCat(cusuarioVO);

            return new ResponseEntity<UsuarioVO>(usuarioCatCreado , HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

        }

    }*/
    
    
   /* @RequestMapping(value = "/crearUsuarioCat", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)        
        public @ResponseBody ResponseEntity<?>crearUsuarioCat(MultipartHttpServletRequest request)
        {

            String nombre = String.valueOf(request.getParameter("nombre"));
            String apPaterno = String.valueOf(request.getParameter("apellido1"));
            String apMaterno = String.valueOf(request.getParameter("apellido2"));
            String usernameU = String.valueOf(request.getParameter("nombreUsu"));
            String password = String.valueOf(request.getParameter("contrasena"));
            String inmueble = String.valueOf(request.getParameter("idInmueble"));
            String acceso = String.valueOf(request.getParameter("idAcceso"));
            String ur = String.valueOf(request.getParameter("idUr"));    
            String rol = String.valueOf(request.getParameter("idRol"));
            String estatus = String.valueOf(request.getParameter("activo"));  
            
            UsuarioVO usuario = new UsuarioVO();
            usuario.setNombre(nombre);
            usuario.setApellido1(apPaterno);
            usuario.setApellido2(apMaterno);
            usuario.setIdRol(Short.parseShort(rol));          
            usuario.setIdUr(new BigDecimal(ur));
            usuario.setNombreUsu(usernameU);
            usuario.setContrasena(password);   
            usuario.setIdInmueble(new BigDecimal(inmueble));
            usuario.setIdAcceso(new BigDecimal(acceso));
            usuario.setActivo(Short.parseShort(estatus));
            
             

            String success;

            try {
                //int usuariosActivos = administrarUsuariosDelegate.validacionUsuariosActivos(usuario.getRol(),usuario.getSubsistema(),ConstantesRvoe.ACTIVO);
                //if(usuariosActivos==0){
                    usuarioService.crearUsuarioCat(usuario);
                    success="OK";
    //                System.out.println(success);
                    return new ResponseEntity<String>(success, HttpStatus.OK);
//                }else{
//                    success="verificar";
//                    return new ResponseEntity<String>(success, HttpStatus.OK);
//                }
            }catch (Exception e) {
                LOGGER.info("Error crearUsuario " + e.getMessage());
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            }
     }      */ 
        
       /* private void cargarCatUsuario(ModelAndView modelAndView) {

        List<UsuarioVO> usuarioSelect = usuarioService.obtenerCatUsuario();
        String json = new Gson().toJson(usuarioSelect);
        modelAndView.addObject("json", json);
    }*/
        
   //@RequestMapping(value = "/crearUsuarioCat", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   @RequestMapping(value = "/crearUsuarioCat", method = RequestMethod.POST)
   @ResponseBody
    public String crearUsuarioCat(@RequestBody UsuarioVO cusuarioVO) throws Exception {
        System.out.println("entrando a controller");
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        UsuarioVO usuarVO = new UsuarioVO();
        usuarVO.setIdUsuario(cusuarioVO.getIdUsuario());
        usuarVO.setIdRol(cusuarioVO.getIdRol());
        usuarVO.setIdUr(cusuarioVO.getIdUr());
        usuarVO.setIdInmueble(cusuarioVO.getIdInmueble());
        usuarVO.setIdAcceso(cusuarioVO.getIdAcceso());
        usuarVO.setNombre(cusuarioVO.getNombre());
        usuarVO.setApellido1(cusuarioVO.getApellido1());
        usuarVO.setApellido2(cusuarioVO.getApellido2());
        usuarVO.setNombreUsu(cusuarioVO.getNombreUsu());
        usuarVO.setContrasena(cusuarioVO.getContrasena());
        usuarVO.setActivo(cusuarioVO.getActivo());
        usuarVO.setCurp(cusuarioVO.getCurp());
        String response = usuarioService.crearUsuarioCat(cusuarioVO);
        return "{\"msg\":\"" + response + "\"}";
    }
     
   @RequestMapping(value = "/obtieneUsuario/{idUsuario}", method = RequestMethod.POST)
    @ResponseBody
    public UsuarioVO obtieneUsuario(@PathVariable Integer idUsuario) throws Exception {
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "USERNAME " + us.getUsername());
        UsuarioVO nusuarioVO = new UsuarioVO();
        nusuarioVO = usuarioService.obtenerUsuario(idUsuario);
        return nusuarioVO;
    }  
    
    @RequestMapping(value = "/verificaCurp/{curp}", method = RequestMethod.POST)
    @ResponseBody
    public String verificaCurp(@PathVariable String curp) throws Exception {
        String response = usuarioService.verificaCurp(curp);
        return "{\"respuesta\":\"" + response + "\"}";
    }
    
}
