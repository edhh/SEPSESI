/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.web.controller.consulta;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.util.SeguridadUtil;
import mx.sep.sesi.modelo.join.TSES004PersonasJoin;
import mx.sep.sesi.modelo.join.Tses011VisitanteJoin;
import mx.sep.sesi.servicios.ConsultaService;
import mx.sep.sesi.servicios.util.LoggerUtil;
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
 * @author heriberto.perez
 */
@Controller
@RequestMapping(value = "/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @RequestMapping(value = "/consultaUsuarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> consultaUsuarios(@RequestParam Integer idTipoPersona,
            @RequestParam Integer idUr,
            @RequestParam String curp,
            @RequestParam Integer idInmueble) {
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "Roles " + us.getRoles());

        if (idTipoPersona == 3) {
            List<Tses011VisitanteJoin> lstVisitantes = null;
            try {

                lstVisitantes = consultaService.obtenerVisitantes(idTipoPersona, idUr, curp, idInmueble);

                return new ResponseEntity<List<Tses011VisitanteJoin>>(lstVisitantes, HttpStatus.OK);
            } catch (Exception exc) {
                exc.printStackTrace();
                return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
            }
        } else {

            List<TSES004PersonasJoin> lstEmpleados = null;

            try {

                lstEmpleados = consultaService.obtenerPersonas(idTipoPersona, idUr, curp, idInmueble);

                return new ResponseEntity<List<TSES004PersonasJoin>>(lstEmpleados, HttpStatus.OK);
            } catch (Exception exc) {
                exc.printStackTrace();
                return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
            }
        }

    }
    
    @RequestMapping(value = "/consultaUsuariosPC", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> consultaUsuariosPC(@RequestParam Integer idTipoPersona,
            @RequestParam Integer idUr,
            @RequestParam String curp,
            @RequestParam Integer idInmueble) {
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "Roles " + us.getRoles());

        
            List<TSES004PersonasJoin> lstEmpleados = null;

            try {

                lstEmpleados = consultaService.obtenerPersonasPC(idTipoPersona, idUr, curp, idInmueble);

                return new ResponseEntity<List<TSES004PersonasJoin>>(lstEmpleados, HttpStatus.OK);
            } catch (Exception exc) {
                exc.printStackTrace();
                return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
            }
        

    }

    @RequestMapping(value = "/consultaAcceso", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> consultaAcceso(@RequestParam Integer idTipoPersona,
            @RequestParam Integer idUr,
            @RequestParam Integer idInmueble,
            @RequestParam Integer idOperacion,
            @RequestParam Date desde,
            @RequestParam String hasta) {
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "Roles " + us.getRoles());
        System.out.println("Desde " + desde);
        System.out.println("hasta " + hasta);
        //desde = desde + "00:00:00.000000000";
        hasta = hasta + " 23:59:59";
        System.out.println("hasta D " + hasta);
        Date convertido = null;
        try {
            DateFormat fechaHora = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            convertido = fechaHora.parse(hasta);
            System.out.println(convertido);
        } catch (ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        List<TSES004PersonasJoin> lstEmpleados = null;
        if (idTipoPersona == 3) {
            List<Tses011VisitanteJoin> lstVisitantes = null;
            try {

                lstVisitantes = consultaService.consultaOperacionVisitante(idOperacion, idTipoPersona, idUr, idInmueble, desde, convertido);
                return new ResponseEntity<List<Tses011VisitanteJoin>>(lstVisitantes, HttpStatus.OK);
            } catch (Exception exc) {
                exc.printStackTrace();
                return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
            }
        } else {
            try {

                lstEmpleados = consultaService.consultaOperacion(idOperacion, idTipoPersona, idUr, idInmueble, desde, convertido);
                return new ResponseEntity<List<TSES004PersonasJoin>>(lstEmpleados, HttpStatus.OK);
            } catch (Exception exc) {
                exc.printStackTrace();
                return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
            }
        }

    }
    
    @RequestMapping(value = "/consultaEquipos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> consultaEquipos(@RequestParam Integer idTipoPersona,
            @RequestParam Integer idUr,
            @RequestParam Integer idInmueble,
            @RequestParam Integer idOperacion,
            @RequestParam String curp,
            @RequestParam String numSerie,
            @RequestParam Date desde,
            @RequestParam String hasta) {
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "Roles " + us.getRoles());
        System.out.println("Desde " + desde);
        System.out.println("hasta " + hasta);
        //desde = desde + "00:00:00.000000000";
        hasta = hasta + " 23:59:59";
        System.out.println("hasta D " + hasta);
        Date convertido = null;
        try {
            DateFormat fechaHora = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            convertido = fechaHora.parse(hasta);
            System.out.println(convertido);
        } catch (ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        List<TSES004PersonasJoin> lstEmpleados = null;
        if (idTipoPersona == 3) {
            List<Tses011VisitanteJoin> lstVisitantes = null;
            try {

                lstVisitantes = consultaService.consultaEquiposVisitante(idOperacion, idTipoPersona, idUr, idInmueble, desde, convertido, curp, numSerie);
                return new ResponseEntity<List<Tses011VisitanteJoin>>(lstVisitantes, HttpStatus.OK);
            } catch (Exception exc) {
                exc.printStackTrace();
                return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
            }
        } else {
            try {

                lstEmpleados = consultaService.consultaEquipos(idOperacion, idTipoPersona, idUr, idInmueble, desde, convertido, curp, numSerie);
                return new ResponseEntity<List<TSES004PersonasJoin>>(lstEmpleados, HttpStatus.OK);
            } catch (Exception exc) {
                exc.printStackTrace();
                return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
            }
        }

    }

}
