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
import mx.sep.sesi.datos.vo.FirmantesVO;
import mx.sep.sesi.modelo.Tses020Firmantes;
import mx.sep.sesi.servicios.CatFirmantesService;
import mx.sep.sesi.servicios.PersonaService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author angel.adame
 */
@Controller
@RequestMapping(value = "/firmantes")
public class FirmantesController {

    private static final Logger LOGGER = Logger.getLogger(FirmantesController.class);

    @Autowired
    CatFirmantesService firmantesService;
    
    @Autowired
    private PersonaService personaService;

    @RequestMapping(value = "/listFirmantes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> obtenerCatFirmante(@RequestParam Integer idUr) {

        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "Roles " + us.getRoles());

        List<FirmantesVO> lstFirmantes = null;

        try {

            lstFirmantes = firmantesService.obtenerCatFirmante(idUr);

            return new ResponseEntity<List<FirmantesVO>>(lstFirmantes, HttpStatus.OK);
        } catch (Exception exc) {
            exc.printStackTrace();
            return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
        }

    }

 @RequestMapping(value = "/insertaFirmante", method = RequestMethod.POST)
    @ResponseBody
    //public String insertaFirmante(@RequestParam BigDecimal idFirmante, @RequestParam BigDecimal idUr, @RequestParam String nombreAutoriza,@RequestParam String puestoAutoriza) throws Exception {
    public String insertaFirmante(@RequestParam Integer idFirmante, @RequestParam Integer idURFirm, @RequestParam String nombreAutoriza, @RequestParam String puestoAutoriza,
            @RequestParam("file") MultipartFile file) throws Exception {
        System.out.println("entrando a controller");
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        /*System.out.println("Nombre es " + new String(nombreAutoriza.getBytes("ISO-8859-1"), "UTF-8"));
        LoggerUtil.debug(this, "USERNAME " + us.getUsername());*/
        String nombreAutorizaUTF = new String(nombreAutoriza.getBytes("ISO-8859-1"), "UTF-8");
        String puestoAutorizaUTF = new String(puestoAutoriza.getBytes("ISO-8859-1"), "UTF-8");     
        FirmantesVO firmantesVO = new FirmantesVO();
        firmantesVO.setIdFirmante(idFirmante);
        firmantesVO.setIdUr(idURFirm);
        firmantesVO.setNombreAutoriza(nombreAutorizaUTF);
        firmantesVO.setPuestoAutoriza(puestoAutorizaUTF);
        firmantesVO.setImagen(file.getBytes());
        String response = firmantesService.insertaFirmante(firmantesVO);
        return "{\"msg\":\"" + response + "\"}";
    }
    
  /* @RequestMapping(value = "/insertaFirmante", method = RequestMethod.POST)
    @ResponseBody
    public String insertaFirmante(@RequestBody FirmantesVO cfirmanteVO) throws Exception {
         String mensajeUrNoValida = "UR No Valida";
         
        int bnd = 0;
        System.out.println("entrando a controller");
   
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        
       Tses020Firmantes tses020Firmantes = new Tses020Firmantes();
        tses020Firmantes.setIdUr(cfirmanteVO.getIdUr());
        List<Tses020Firmantes> listFirmantes = firmantesService.verificaUR(tses020Firmantes);
            System.out.println("listFirmantes-" + listFirmantes.size());
            System.out.println("listFirmantes-" + listFirmantes.isEmpty());
            System.out.println("NidUr" + cfirmanteVO.getIdUr());
         FirmantesVO firmantesVO = new FirmantesVO();
        firmantesVO.setIdFirmante(cfirmanteVO.getIdFirmante());
        firmantesVO.setIdUr(cfirmanteVO.getIdUr());
        firmantesVO.setNombreAutoriza(cfirmanteVO.getNombreAutoriza());
        firmantesVO.setPuestoAutoriza(cfirmanteVO.getPuestoAutoriza());    
        if (listFirmantes.isEmpty()){
        String response = firmantesService.insertaFirmante(firmantesVO);
        return "{\"msg\":\"" + response + "\"}";
        }else{
            for(Tses020Firmantes tses020firm : listFirmantes){
                System.out.println("listFirmantes-" + listFirmantes.size());
            System.out.println("listFirmantes-" + listFirmantes.isEmpty());
            System.out.println("NidUr" + cfirmanteVO.getIdUr());
            if(tses020firm.getIdUr() != cfirmanteVO.getIdUr()){
              bnd = 1;
               throw new Exception(mensajeUrNoValida);
               //return(mensajeUrNoValida);
            }
            }
        }
        if (bnd==0){
             String response = firmantesService.insertaFirmante(firmantesVO);
        return "{\"msg\":\"" + response + "\"}";
        }
       
    }*/ 
    
    
    
     @RequestMapping(value = "/obtieneFirmante/{idFirmante}", method = RequestMethod.POST)
    @ResponseBody
    public Tses020Firmantes obtieneFirmante(@PathVariable Integer idFirmante) throws Exception {
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "USERNAME " + us.getUsername());
        Tses020Firmantes tses020Firmantes = new Tses020Firmantes();
        tses020Firmantes = firmantesService.obtenerFirmante(idFirmante);
        return tses020Firmantes;
    }
   /* @RequestMapping(value = "/insertaFirmante", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> insertaFirmante(@RequestBody FirmantesVO cfirmanteVO){
        
          String success = "OK";
        FirmantesVO firmanteCreado = null;
        System.out.println("entrando a controller");

        try {
            LOGGER.info(cfirmanteVO.toString());
            firmanteCreado =  firmantesService.insertaFirmante(cfirmanteVO);

            return new ResponseEntity<FirmantesVO>(firmanteCreado , HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

        }
    }*/
    
     @RequestMapping(value = "/verificaUR/{ur}", method = RequestMethod.POST)
    @ResponseBody
    public String verificaFirmante(@PathVariable Integer ur) throws Exception {
        String response = personaService.verificaFirmante(ur);
        return "{\"respuesta\":\"" + response + "\"}";
    }
    
}
