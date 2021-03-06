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
import mx.sep.sesi.datos.vo.CuadranteVO;
import mx.sep.sesi.datos.vo.PersonaVO;
import mx.sep.sesi.modelo.Tses002Roles;
import mx.sep.sesi.modelo.Tses005TipoPersona;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.sep.sesi.modelo.Tses009Inmuebles;
import mx.sep.sesi.modelo.Tses010CuadranteArea;
import mx.sep.sesi.modelo.Tses028Area;
import mx.sep.sesi.modelo.Tses006UnidadResponsable;
import mx.sep.sesi.modelo.Tses007TipoSangre;
import mx.sep.sesi.modelo.Tses013Accesos;
import mx.sep.sesi.modelo.Tses014Colonia;
import mx.sep.sesi.modelo.Tses015AlcaldiaMun;
import mx.sep.sesi.modelo.Tses016Entidad;
import mx.sep.sesi.servicios.CatalogosServicio;
import mx.sep.sesi.servicios.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author heriberto.perez
 */
@Controller
@RequestMapping(value = "/catalogos")
public class CatalogosController {

    @Autowired
    private CatalogosServicio catalogosServicio;

    @RequestMapping(value = "/obtenerInmueble", method = RequestMethod.GET)
    @ResponseBody
    public List<Tses009Inmuebles> obtenerInmueble() throws Exception {
        List<Tses009Inmuebles> inmuebleSelect = new ArrayList<Tses009Inmuebles>();
        inmuebleSelect = catalogosServicio.obtenerInmueble();
        return inmuebleSelect;
    }

    @RequestMapping(value = "/obtenerUR", method = RequestMethod.GET)
    @ResponseBody
    public List<Tses006UnidadResponsable> obtenerUR() throws Exception {
        List<Tses006UnidadResponsable> urSelect = new ArrayList<Tses006UnidadResponsable>();
        urSelect = catalogosServicio.obtenerUR();
        return urSelect;
    }

    @RequestMapping(value = "/obtenertipoSangre", method = RequestMethod.GET)
    @ResponseBody
    public List<Tses007TipoSangre> obtenertipoSangre() throws Exception {
        List<Tses007TipoSangre> sangreSelect = new ArrayList<Tses007TipoSangre>();
        sangreSelect = catalogosServicio.obtenertipoSangre();
        return sangreSelect;
    }

    @RequestMapping(value = "/obtenerCuadrante/{idInmueble}", method = RequestMethod.POST)
    @ResponseBody
    public List<Tses010CuadranteArea> obtenerCuadrante(@PathVariable Integer idInmueble) throws Exception {
        List<Tses010CuadranteArea> cuadranteSelect = new ArrayList<Tses010CuadranteArea>();
        cuadranteSelect = catalogosServicio.obtenerCuadrante(idInmueble);
        return cuadranteSelect;
    }
    
    @RequestMapping(value = "/obtenerArea/{idUr}", method = RequestMethod.POST)
    @ResponseBody
    public List<Tses028Area> obtenerArea(@PathVariable Integer idUr) throws Exception {
        List<Tses028Area> areaSelect = new ArrayList<Tses028Area>();
        areaSelect = catalogosServicio.obtenerArea(idUr);
        return areaSelect;
    }

    @RequestMapping(value = "/obtenerCuadranteTodos", method = RequestMethod.GET)
    @ResponseBody
    public List<Tses010CuadranteArea> obtenerCuadranteTodos() throws Exception {
        List<Tses010CuadranteArea> cuadranteSelect = new ArrayList<Tses010CuadranteArea>();
        cuadranteSelect = catalogosServicio.obtenerCuadranteTodos();
        return cuadranteSelect;
    }

    @RequestMapping(value = "/obtenerCuadrante10/{idCuadrante}", method = RequestMethod.POST)
    @ResponseBody
    public List<Tses010CuadranteArea> obtenerCuadrante10(@PathVariable Integer idCuadrante) throws Exception {
        List<Tses010CuadranteArea> cuadranteSelect = new ArrayList<Tses010CuadranteArea>();
        cuadranteSelect = catalogosServicio.obtenerCuadrante10(idCuadrante);
        return cuadranteSelect;
    }

    @RequestMapping(value = "/obtenerTipoPersona", method = RequestMethod.GET)
    @ResponseBody
    public List<Tses005TipoPersona> obtenerTipoPersona() throws Exception {
        List<Tses005TipoPersona> tipoPersonaSelect = new ArrayList<Tses005TipoPersona>();
        tipoPersonaSelect = catalogosServicio.obtenerTipoPersona();
        return tipoPersonaSelect;
    }

    @RequestMapping(value = "/obtenerRol", method = RequestMethod.GET)
    @ResponseBody
    public List<Tses002Roles> obtenerRol() throws Exception {
        List<Tses002Roles> tses002RolesSelect = new ArrayList<Tses002Roles>();
        tses002RolesSelect = catalogosServicio.obtenerRol();
        return tses002RolesSelect;
    }

    @RequestMapping(value = "/obtenerAcceso/{idInmueble}", method = RequestMethod.POST)
    @ResponseBody
    public List<Tses013Accesos> obtenerAcceso(@PathVariable Integer idInmueble) throws Exception {
        List<Tses013Accesos> tses013AccesosSelect = new ArrayList<Tses013Accesos>();
        tses013AccesosSelect = catalogosServicio.obtenerAcceso(idInmueble);
        return tses013AccesosSelect;
    }

    @RequestMapping(value = "/consultaCuadrantes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> consultaCuadrantes(
            @RequestParam Integer idInmueble) {
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "Roles " + us.getRoles());
        List<CuadranteVO> cuadranteSelect = new ArrayList<CuadranteVO>();
        short inmueble = idInmueble.shortValue();
        if (idInmueble == 1000) {
            idInmueble = null;
            try {

                cuadranteSelect = catalogosServicio.obtenerCuadrantes(idInmueble);

                return new ResponseEntity<List<CuadranteVO>>(cuadranteSelect, HttpStatus.OK);
            } catch (Exception exc) {
                exc.printStackTrace();
                return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
            }

        } else {

            try {

                cuadranteSelect = catalogosServicio.obtenerCuadrantes(idInmueble);

                return new ResponseEntity<List<CuadranteVO>>(cuadranteSelect, HttpStatus.OK);
            } catch (Exception exc) {
                exc.printStackTrace();
                return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
            }
        }

    }

    @RequestMapping(value = "/insertaCuadrante", method = RequestMethod.POST)
    @ResponseBody
    public String insertaCuadrante(@RequestParam Integer idCuadranteCat, @RequestParam Integer inmuebleMod, @RequestParam String nombreCuadrante) throws Exception {
        System.out.println("Vamos al servicio");
        String response = catalogosServicio.insertaCuadrante(idCuadranteCat, inmuebleMod, nombreCuadrante);
        return "{\"msg\":\"" + response + "\"}";
    }

    @RequestMapping(value = "/eliminaCuadranteCat", method = RequestMethod.POST)
    @ResponseBody
    public String eliminaCuadranteCat(@RequestParam Integer idCuadrante) throws Exception {
        System.out.println("Entrando a controller");
        Tses010CuadranteArea tses010CuadranteArea = new Tses010CuadranteArea();
        tses010CuadranteArea.setIdCuadranteArea(idCuadrante);
        System.out.println("idCuadrante" + idCuadrante);
        String resp = catalogosServicio.eliminaCuadranteCat(tses010CuadranteArea);
        return "{\"msg\":\"" + resp + "\"}";
    }

    @RequestMapping(value = "/obtenerEntidad", method = RequestMethod.GET)
    @ResponseBody
    public List<Tses016Entidad> obtenerEntidad() throws Exception {
        List<Tses016Entidad> tses016Entidad = new ArrayList<Tses016Entidad>();
        tses016Entidad = catalogosServicio.obtenerEntidad();
        return tses016Entidad;
    }

    @RequestMapping(value = "/obtenerAlcaldiaMun/{idEntidad}", method = RequestMethod.POST)
    @ResponseBody
    public List<Tses015AlcaldiaMun> obtenerAlcaldiaMun(@PathVariable Integer idEntidad) throws Exception {
        List<Tses015AlcaldiaMun> alcaldiaSelect = new ArrayList<Tses015AlcaldiaMun>();
        alcaldiaSelect = catalogosServicio.obtenerAlcaldiaMun(idEntidad);
        return alcaldiaSelect;
    }

    @RequestMapping(value = "/obtenerColonia/{idEntidad}/{idAlcaldiaMun}", method = RequestMethod.POST)
    @ResponseBody
    public List<Tses014Colonia> obtenerColonia(@PathVariable Integer idEntidad, @PathVariable Integer idAlcaldiaMun) throws Exception {
        List<Tses014Colonia> coloniaSelect = new ArrayList<Tses014Colonia>();
        coloniaSelect = catalogosServicio.obtenerColonia(idEntidad, idAlcaldiaMun);
        return coloniaSelect;
    }

}
