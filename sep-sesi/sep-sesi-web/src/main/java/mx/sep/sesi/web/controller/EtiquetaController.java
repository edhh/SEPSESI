/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.web.controller;

import mx.sep.sesi.datos.vo.EtiquetaVO;
import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.servicios.EtiquetaServicio;
import mx.sep.sesi.servicios.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author pedro.flores
 */
@Controller
@RequestMapping("/etiqueta")
public class EtiquetaController {
    
    @Autowired
    private EtiquetaServicio etiquetaServicio;
    
    @RequestMapping(value = "/recuperarEtiqueta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Integer getUltimaEtiqueta(@RequestParam Integer idInmueble) throws Exception {
        Integer nextIdEtiqueta = 0;
        try{
            nextIdEtiqueta = etiquetaServicio.getUltimaEtiqueta( idInmueble );
        }catch(Exception exc){      
            LoggerUtil.error(this, exc.getMessage());
            return -1;        
        }
        return nextIdEtiqueta;
    }
    
    
    @RequestMapping(value = "/registrarEtiquetas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> registrarEtiquetas(@RequestBody EtiquetaVO etiquetaVO ) throws Exception {          
        EtiquetaVO response = new EtiquetaVO();
        try{
            if( etiquetaVO.getTipoOperacion() == 1 ){
                response = etiquetaServicio.crearEtiquetas(etiquetaVO);
            } else {
                response = etiquetaServicio.reimprimirEtiquetas(etiquetaVO);
            }
        }catch(Exception exc){
            LoggerUtil.error(this, exc.getMessage());
            return new ResponseEntity<String>("Ocurrió un error", HttpStatus.CONFLICT); 
        }
        return new ResponseEntity<EtiquetaVO>(response, HttpStatus.OK);  
    }
}


