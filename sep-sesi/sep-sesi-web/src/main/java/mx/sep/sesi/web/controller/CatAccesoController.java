/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.web.controller;

import java.math.BigDecimal;
import java.util.List;
import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.util.SeguridadUtil;
import mx.sep.sesi.datos.vo.AccesoVO;
import mx.sep.sesi.modelo.Tses013Accesos;
import mx.sep.sesi.servicios.CatAccesoService;
import mx.sep.sesi.servicios.util.LoggerUtil;
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

/**
 *
 * @author angel.adame
 */
@Controller
@RequestMapping(value = "/catAcceso")
public class CatAccesoController {
    
     private static final Logger LOGGER = Logger.getLogger(CatAccesoController.class);

    @Autowired
    CatAccesoService catAccesoService;
    
      @RequestMapping(value = "/obtenerCatAcceso", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

    public @ResponseBody
    ResponseEntity<?> obtenerCatAcceso(@RequestParam Integer idInmueble) {

        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "Roles " + us.getRoles());
    
         List<AccesoVO> listAcceso = null;
         
         try{
            
             listAcceso = catAccesoService.obtenerCatAcceso(idInmueble);
                return new ResponseEntity<List<AccesoVO>>(listAcceso, HttpStatus.OK);

        } catch (Exception exc) {
            exc.printStackTrace();
            return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
             
         }
    }
    
      @RequestMapping(value = "/crearAccesoCat", method = RequestMethod.POST)
   @ResponseBody
    public String crearAccesoCat(@RequestBody AccesoVO caccesoVO) throws Exception {
         System.out.println("entrando a controller");
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        Tses013Accesos tses013 = new Tses013Accesos();
        tses013.setIdAcceso(caccesoVO.getIdAcceso());
        tses013.setIdInmueble(caccesoVO.getIdInmueble());
        tses013.setDesAcceso(caccesoVO.getDesAcceso());
        String response = catAccesoService.crearAccesoCat(caccesoVO);
        return "{\"msg\":\"" + response + "\"}";
    }
    
    
     @RequestMapping(value = "/obtenerAcceso/{idAcceso}", method = RequestMethod.POST)
    @ResponseBody
    public Tses013Accesos obtieneAcceso(@PathVariable Integer idAcceso) throws Exception {      
        Tses013Accesos tses013Accesos = new Tses013Accesos();
        tses013Accesos = catAccesoService.obtenerAcceso(idAcceso);  
        return tses013Accesos;
    }
    
@RequestMapping(value = "/eliminarAccesoCat", method = RequestMethod.POST)
    @ResponseBody
    public String eliminarAccesoCat(@RequestParam Integer idAcceso) throws Exception {
        System.out.println("Entrando a controller");
        AccesoVO accesoVO = new AccesoVO();
        accesoVO.setIdAcceso(idAcceso);
         System.out.println("idAcceso" + idAcceso);
        String resp = catAccesoService.eliminaAccesoCat(accesoVO);
        return "{\"msg\":\""+resp+"\"}"; 
    }
    
    
    
    
}
