/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.web.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.util.SeguridadUtil;
import mx.sep.sesi.datos.vo.BitacoraVO;
import mx.sep.sesi.modelo.Tses021Bitacora;
import mx.sep.sesi.modelo.Tses022TraduccionServicio;
import mx.sep.sesi.servicios.util.BitacoraService;
import mx.sep.sesi.servicios.util.LoggerUtil;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author angel.adame
 */
@Controller
@RequestMapping(value = "/bitacora")
public class BitacoraController {

    @Autowired
    private BitacoraService bitacoraService;

//     @RequestMapping(value = "/consultaBitacora", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public List<BitacoraVO> obtenerBitacoraConsulta(
//            @RequestBody BitacoraVO bitacoraConsultaVO) throws Exception {
//
//        Map<String, String> respuesta = new HashMap<String, String>();
//        List<BitacoraVO> lstBitaVO = new ArrayList<BitacoraVO>();
//        try {
//            System.out.println("idTradServicio----" + bitacoraConsultaVO.getIdTradServicio() );
//            System.out.println("descripcion---" + bitacoraConsultaVO.getDescripcion());
//            System.out.println("username-" + bitacoraConsultaVO.getNombreUsu());
//            System.out.println("fechaOperacion-" + bitacoraConsultaVO.getFechaOperacion());
//            System.out.println("fechaOperacionDesde-" + bitacoraConsultaVO.getFechaOpIni());
//            System.out.println("fechaOperacionHasta-" + bitacoraConsultaVO.getFechaOpFin());
//            lstBitaVO = bitacoraService.consultarBitacora(bitacoraConsultaVO);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            respuesta.put("codigo", "1");
//            respuesta.put("mensaje", e.getMessage());
//        }
//        return lstBitaVO;
//    }
//    
    @RequestMapping(value = "/consultaBitacora", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> obtenerBitacoraConsulta(@RequestParam Integer idTradServicio,
            @RequestParam String nombreUsu,
            @RequestParam Date fechaOpIni,
            @RequestParam Date fechaOpFin) {
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "Roles " + us.getRoles());
        System.out.println("Desde " + fechaOpIni);
        System.out.println("hasta " + fechaOpFin);
        //desde = desde + "00:00:00.000000000";
        //fechaOpFin = fechaOpFin + " 23:59:59";
        System.out.println("hasta D " + fechaOpFin);
        //Date convertido = null;
//        try {
//            DateFormat fechaHora = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//            //convertido = fechaHora.parse(fechaOpFin);
//            System.out.println(fechaHora);
//            //} catch (ParseException e) {
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
        List<BitacoraVO> lstBitacora = null;
        try {
            lstBitacora = bitacoraService.consultarBitacora(idTradServicio, nombreUsu, fechaOpIni, fechaOpFin);
         for(BitacoraVO bitacoraFor : lstBitacora){
                System.out.print("fecha: " + bitacoraFor.getFechaOperacion());
            }
            
            return new ResponseEntity<List<BitacoraVO>>(lstBitacora, HttpStatus.OK);
            
           
            
        } catch (Exception exc) {
            exc.printStackTrace();
            return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
        }

    }

//    @RequestMapping(value= "/initBitacora", method = RequestMethod.GET)
//    public ModelAndView initBitacora(){
//        System.out.println("Entrando a Bitacora");
//        List<Tses022TraduccionServicio> lstProcesosBitacora = null;
//        ModelAndView modelAndView = new ModelAndView("bitacora/initBitacora");
//        try{
//            lstProcesosBitacora =  bitacoraService.consultarProcesos();
//            modelAndView.addObject("lstProcesosBitacora",lstProcesosBitacora);
//        }catch(Exception exc){
//                exc.printStackTrace();
//        }        
//        modelAndView.addObject("bitacoraVO",new BitacoraVO());
//        return modelAndView;
//    }
//    
//      @RequestMapping(value = "/procesos/{aleatorio}", method = RequestMethod.GET)
//    @ResponseBody
//    public List<BitacoraVO> consultaProcesos(@PathVariable Integer aleatorio) throws Exception {
//        return bitacoraService.consultaProcesos();
//    }
    @RequestMapping(value = "/obtenerProcesos", method = RequestMethod.GET)
    @ResponseBody
    public List<Tses022TraduccionServicio> obtenerProcesos() throws Exception {
        List<Tses022TraduccionServicio> procesoSelect = new ArrayList<Tses022TraduccionServicio>();
        procesoSelect = bitacoraService.obtenerProcesos();
        return procesoSelect;
    }
    
    
     @RequestMapping(value = "/obtieneDetalle/{idBitacora}", method = RequestMethod.POST)
    @ResponseBody
    public Tses021Bitacora obtenerDetalle(@PathVariable Long idBitacora) throws Exception {
         Tses021Bitacora tses021Bitacora = new Tses021Bitacora();
        tses021Bitacora = bitacoraService.obtenerDetalle(idBitacora);
        return tses021Bitacora;    
    }

}
