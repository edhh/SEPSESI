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
import mx.sep.sesi.datos.vo.InmuebleVO;
import mx.sep.sesi.modelo.Tses009Inmuebles;
import mx.sep.sesi.servicios.CatInmuebleService;
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
@RequestMapping(value = "/inmueble")
public class CatInmuebleController {

    private static final Logger LOGGER = Logger.getLogger(CatInmuebleController.class);

    @Autowired
    CatInmuebleService inmuebleService;

    @RequestMapping(value = "/obtenerCatInmueble", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

    public @ResponseBody
    ResponseEntity<?> obtenerCatInmueble(@RequestParam Integer idInmueble) {

        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "Roles " + us.getRoles());

        List<InmuebleVO> listInmueble = null;

        try {

            listInmueble = inmuebleService.obtenerCatInmueble(idInmueble);
            return new ResponseEntity<List<InmuebleVO>>(listInmueble, HttpStatus.OK);

        } catch (Exception exc) {
            exc.printStackTrace();
            return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
        }
    }
    
    
     @RequestMapping(value = "/crearInmuebleCat", method = RequestMethod.POST)
   @ResponseBody
    public String crearInmuebleCat(@RequestBody InmuebleVO cinmuebleVO) throws Exception {
        System.out.println("entrando a controller");
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        InmuebleVO inmuebVO = new InmuebleVO();
        inmuebVO.setIdInmueble(cinmuebleVO.getIdInmueble());
        inmuebVO.setDenominacion(cinmuebleVO.getDenominacion());
        inmuebVO.setIdEntidad(cinmuebleVO.getIdEntidad());
        inmuebVO.setIdAlcaldiaMun(cinmuebleVO.getIdAlcaldiaMun());
        inmuebVO.setIdColonia(cinmuebleVO.getIdColonia());
        inmuebVO.setCalle(cinmuebleVO.getCalle());
        inmuebVO.setNumero(cinmuebleVO.getNumero());
        inmuebVO.setCp(cinmuebleVO.getCp());
        inmuebVO.setClaveInmueble(cinmuebleVO.getClaveInmueble());
        inmuebVO.setNumAccesos(cinmuebleVO.getNumAccesos());
        inmuebVO.setEstatus(cinmuebleVO.getEstatus());
        String response = inmuebleService.crearInmuebleCat(cinmuebleVO);    
        return "{\"msg\":\"" + response + "\"}";
    }
    
    
    @RequestMapping(value = "/obtieneInmueble/{idInmueble}", method = RequestMethod.POST)
    @ResponseBody
    public Tses009Inmuebles obtieneInmueble(@PathVariable Integer idInmueble) throws Exception {      
        Tses009Inmuebles tses009Inmuebles = new Tses009Inmuebles();
        tses009Inmuebles = inmuebleService.obtenerInmueble(idInmueble);              
        return tses009Inmuebles;
    }
    
}
