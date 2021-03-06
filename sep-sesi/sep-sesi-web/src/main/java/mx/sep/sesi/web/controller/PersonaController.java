/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.web.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.util.SeguridadUtil;
import mx.sep.sesi.datos.vo.EquiposVO;
import mx.sep.sesi.datos.vo.PersonaVO;
import mx.sep.sesi.datos.vo.EquiposVisitanteVO;
import mx.sep.sesi.datos.vo.UsuarioVO;
import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.modelo.Tses011Visitantes;
import mx.sep.sesi.modelo.join.TSES004PersonasJoin;
import mx.sep.sesi.datos.vo.VisitanteVO;
import mx.sep.sesi.modelo.join.Tses011VisitanteJoin;
import mx.sep.sesi.servicios.PersonaService;
import mx.sep.sesi.servicios.util.LoggerUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * @author heriberto.perez
 */
@Controller
@RequestMapping(value = "/persona")
public class PersonaController {
    
    private static final Logger logger = Logger.getLogger(PersonaController.class);

    @Autowired
    private PersonaService personaService;

    
     @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;
    


    @RequestMapping(value = "/insertaEmpleado", method = RequestMethod.POST)
    @ResponseBody
    public String insertaEmpleado(@RequestParam Integer idPersona, @RequestParam String curp, @RequestParam String nombre, @RequestParam String primerApellido, @RequestParam String segundoApellido, @RequestParam String correoModal, @RequestParam Integer inmuebleID, @RequestParam Integer urModal, @RequestParam Integer cuadrante, @RequestParam String puesto, @RequestParam Integer tipoSangre,
            @RequestParam String emergencia, @RequestParam String alergias, @RequestParam String enfermedad, @RequestParam("file") MultipartFile file, @RequestParam Short estatus, @RequestParam String areaId) throws Exception {
        System.out.println("entrando a controller");
        System.out.println("File:" + file.getOriginalFilename());
        System.out.println("Tama?o:" + file.getSize());
        System.out.println("ContentType:" + file.getContentType());
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        System.out.println("Nombre es " +  new String(nombre.getBytes("ISO-8859-1"),"UTF-8"));
        LoggerUtil.debug(this, "USERNAME " + us.getUsername());
        String nombreUtf = new String(nombre.getBytes("ISO-8859-1"),"UTF-8");
        String primerApellidoUTF = new String(primerApellido.getBytes("ISO-8859-1"),"UTF-8");
        String segundoApellidoUTF = new String(segundoApellido.getBytes("ISO-8859-1"),"UTF-8");
        String puestoUTF = new String(puesto.getBytes("ISO-8859-1"),"UTF-8");
        String alergiasUTF = new String(alergias.getBytes("ISO-8859-1"),"UTF-8");
        String enfermedadUTF = new String(enfermedad.getBytes("ISO-8859-1"),"UTF-8");
        PersonaVO personaVO = new PersonaVO();
        personaVO.setIdPersona(idPersona);
        personaVO.setCurp(curp);
        personaVO.setNombre(nombreUtf);
        personaVO.setPrimerApellido(primerApellidoUTF);
        personaVO.setSegundoApellido(segundoApellidoUTF);
        personaVO.setIdInmueble(inmuebleID);
        personaVO.setIdUR(urModal);
        personaVO.setCuadrante(cuadrante);
        personaVO.setPuesto(puestoUTF);
        personaVO.setTipoSangre(tipoSangre);
        personaVO.setEmergencia(emergencia);
        personaVO.setIdAlergia(alergiasUTF);
        personaVO.setEnfermedad(enfermedadUTF);
        personaVO.setImagen(file.getBytes());
        personaVO.setEstatus(estatus);
        personaVO.setCorreo(correoModal);
        if(!areaId.contains("SELECCIONA")){
           personaVO.setIdArea(Integer.parseInt(areaId)); 
        }
        System.out.println("Vamos al servicio");
        String response = personaService.insertaEmpleado(personaVO);
        return "{\"msg\":\"" + response + "\"}";
    }

    @RequestMapping(value = "/insertaProveedor", method = RequestMethod.POST)
    @ResponseBody
    public String insertaProveedor(@RequestParam Integer idPersona, @RequestParam String curp, @RequestParam String nombre, @RequestParam String primerApellido, @RequestParam String segundoApellido, @RequestParam String correoModal, @RequestParam Integer inmuebleID, @RequestParam Integer urModal, @RequestParam Integer cuadrante, @RequestParam (value="puesto", defaultValue="PROVEEDOR") String puesto, @RequestParam Integer tipoSangre,
            @RequestParam String emergencia, @RequestParam String alergias, @RequestParam String enfermedad, @RequestParam("file") MultipartFile file, @RequestParam Short estatus) throws Exception {
        System.out.println("entrando a controller");
        System.out.println("File:" + file.getOriginalFilename());
        System.out.println("Tama?o:" + file.getSize());
        System.out.println("ContentType:" + file.getContentType());
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "USERNAME " + us.getUsername());
        String nombreUtf = new String(nombre.getBytes("ISO-8859-1"),"UTF-8");
        String primerApellidoUTF = new String(primerApellido.getBytes("ISO-8859-1"),"UTF-8");
        String segundoApellidoUTF = new String(segundoApellido.getBytes("ISO-8859-1"),"UTF-8");
        String puestoUTF = new String(puesto.getBytes("ISO-8859-1"),"UTF-8");
        String alergiasUTF = new String(alergias.getBytes("ISO-8859-1"),"UTF-8");
        String enfermedadUTF = new String(enfermedad.getBytes("ISO-8859-1"),"UTF-8");
        PersonaVO personaVO = new PersonaVO();
        personaVO.setIdPersona(idPersona);
        personaVO.setCurp(curp);
        personaVO.setNombre(nombreUtf);
        personaVO.setPrimerApellido(primerApellidoUTF);
        personaVO.setSegundoApellido(segundoApellidoUTF);
        personaVO.setIdInmueble(inmuebleID);
        personaVO.setIdUR(urModal);
        personaVO.setCuadrante(cuadrante);
        personaVO.setPuesto(puestoUTF);
        personaVO.setTipoSangre(tipoSangre);
        personaVO.setEmergencia(emergencia);
        personaVO.setIdAlergia(alergiasUTF);
        personaVO.setEnfermedad(enfermedadUTF);
        personaVO.setImagen(file.getBytes());
        personaVO.setEstatus(estatus);
        personaVO.setCorreo(correoModal);
        String response = personaService.insertaProveedor(personaVO);
        return "{\"msg\":\"" + response + "\"}";
    }
    
    @RequestMapping(value = "/insertaVisitante", method = RequestMethod.POST)
    @ResponseBody
    public String insertaVisitante(@RequestParam Integer idVisitante, @RequestParam String curp, @RequestParam String nombre, @RequestParam String primerApellido, @RequestParam String segundoApellido, @RequestParam Integer inmuebleID, @RequestParam Integer idUR, @RequestParam Integer cuadrante, 
            @RequestParam String personaV, @RequestParam  Long numEtiqueta,@RequestParam("file") MultipartFile file,@RequestParam("listaEquipos") String[] listaEquipos) throws Exception {
        System.out.println("entrando a controller");
        System.out.println("File:" + file.getOriginalFilename());
        System.out.println("Tama?o:" + file.getSize());
        System.out.println("ContentType:" + file.getContentType());
        System.out.println("Nombre es " + nombre);
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        String nombreUtf = new String(nombre.getBytes("ISO-8859-1"),"UTF-8");
        String primerApellidoUTF = new String(primerApellido.getBytes("ISO-8859-1"),"UTF-8");
        String segundoApellidoUTF = new String(segundoApellido.getBytes("ISO-8859-1"),"UTF-8");
        String personaVisitaUTF = new String(personaV.getBytes("ISO-8859-1"),"UTF-8");
        LoggerUtil.debug(this, "USERNAME " + us.getUsername());
        PersonaVO personaVO = new PersonaVO();
        personaVO.setIdPersona(idVisitante);
        personaVO.setCurp(curp);
        personaVO.setNombre(nombreUtf);
        personaVO.setPrimerApellido(primerApellidoUTF);
        personaVO.setSegundoApellido(segundoApellidoUTF);
        personaVO.setIdInmueble(inmuebleID);
        personaVO.setIdUR(idUR);
        personaVO.setCuadrante(cuadrante);
        personaVO.setPersonaVisita(personaVisitaUTF);
        personaVO.setImagen(file.getBytes());
        personaVO.setNumEtiqueta(numEtiqueta);
        List <EquiposVisitanteVO> equiposVisitanteLista =  new ArrayList<EquiposVisitanteVO>();
        EquiposVisitanteVO equiposVisitanteVO = new EquiposVisitanteVO();
        for (int i = 0; i< listaEquipos.length; i++){
            if (i== 0 || i == 4 || i == 8 || i == 12){
                equiposVisitanteVO.setEstatus(listaEquipos[i]);
            }
            if (i== 1 || i == 5 || i == 9 || i == 13){
                equiposVisitanteVO.setMarca(new String (listaEquipos[i].getBytes("ISO-8859-1"),"UTF-8"));
            }
            if (i== 2 || i == 6 || i == 10 || i == 14){
                equiposVisitanteVO.setNumeroSerie(listaEquipos[i]);
            }
            if (i== 3 || i == 7 || i == 11 || i == 15){
                equiposVisitanteVO.setDescripcion(new String (listaEquipos[i].getBytes("ISO-8859-1"),"UTF-8"));
            }
            equiposVisitanteLista.add(equiposVisitanteVO);
        }
        personaVO.setEquiposVisitante(equiposVisitanteLista);
        String response = personaService.insertaVisitante(personaVO);
        if (personaVO.getIdPersona()==null){
            personaService.insertaEquipos(personaVO);
        }
        return "{\"msg\":\"" + response + "\"}";
    }
    
    @RequestMapping(value = "/insertaEquipoVisitante", method = RequestMethod.POST)
    @ResponseBody
    public String insertaEquipoVisitante(@RequestParam Integer idVisitante, @RequestParam String curp, @RequestParam String nombre, @RequestParam String primerApellido, @RequestParam String segundoApellido, @RequestParam Integer inmuebleID, @RequestParam Integer idUR, @RequestParam Integer cuadrante, 
            @RequestParam String personaV, @RequestParam  Long numEtiqueta,@RequestParam("file") MultipartFile file,@RequestParam("listaEquipos") String[] listaEquipos) throws Exception {
        System.out.println("entrando a controller");
        System.out.println("File:" + file.getOriginalFilename());
        System.out.println("Tama?o:" + file.getSize());
        System.out.println("ContentType:" + file.getContentType());
        System.out.println("Nombre es " + nombre);
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        PersonaVO personaVO = new PersonaVO();
        List <EquiposVisitanteVO> equiposVisitanteLista =  new ArrayList<EquiposVisitanteVO>();
        EquiposVisitanteVO equiposVisitanteVO = new EquiposVisitanteVO();
        for (int i = 0; i< listaEquipos.length; i++){
            if (i== 0 || i == 4 || i == 8 || i == 12){
                equiposVisitanteVO.setEstatus(listaEquipos[i]);
            }
            if (i== 1 || i == 5 || i == 9 || i == 13){
                equiposVisitanteVO.setMarca(new String (listaEquipos[i].getBytes("ISO-8859-1"),"UTF-8"));
            }
            if (i== 2 || i == 6 || i == 10 || i == 14){
                equiposVisitanteVO.setNumeroSerie(listaEquipos[i]);
            }
            if (i== 3 || i == 7 || i == 11 || i == 15){
                equiposVisitanteVO.setDescripcion(new String (listaEquipos[i].getBytes("ISO-8859-1"),"UTF-8"));
            }
            equiposVisitanteLista.add(equiposVisitanteVO);
        }
        personaVO.setEquiposVisitante(equiposVisitanteLista);
        String response = null;
        if (personaVO.getIdPersona()==null){
            response = personaService.insertaEquipos(personaVO);
        }
        return "{\"msg\":\"" + response + "\"}";
    }

    @RequestMapping(value = "/obtieneEmpleado/{idPersona}", method = RequestMethod.POST)
    @ResponseBody
    public Tses004Personas obtieneEmpleado(@PathVariable Integer idPersona) throws Exception {
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "USERNAME " + us.getUsername());
        Tses004Personas tses004Personas = new Tses004Personas();
        tses004Personas = personaService.obtenerPersona(idPersona);
        //String s = new String(tses004Personas.getFotografia(), StandardCharsets.UTF_8);
        //Base64 codec = new Base64();
        //Object encoded = codec.encode(s);
        //System.out.println(encoded);
        //tses004Personas.setFotografia(encoded);
        return tses004Personas;
    }
    
    @RequestMapping(value = "/verificaCurp/{curp}", method = RequestMethod.POST)
    @ResponseBody
    public String verificaCurp(@PathVariable String curp) throws Exception {
        String response = personaService.verificaCurp(curp);
        return "{\"respuesta\":\"" + response + "\"}";
    }
    
    @RequestMapping(value = "/verificaCurpVisitante/{curp}", method = RequestMethod.POST)
    @ResponseBody
    public String verificaCurpVisitante(@PathVariable String curp) throws Exception {
        String response = personaService.verificaCurpVisitante(curp);
        return "{\"respuesta\":\"" + response + "\"}";
    }
    
    @RequestMapping(value = "/verificaFirmante/{ur}", method = RequestMethod.POST)
    @ResponseBody
    public String verificaFirmante(@PathVariable String ur) throws Exception {
        String response = personaService.verificaFirmante(Integer.valueOf(ur));
        return "{\"respuesta\":\"" + response + "\"}";
    }
    
    @RequestMapping(value = "/obtieneVisitante/{idVisitante}", method = RequestMethod.POST)
    @ResponseBody
    public VisitanteVO obtieneVisitante(@PathVariable Long idVisitante) throws Exception {
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "USERNAME " + us.getUsername());
        VisitanteVO tses011Visitantes = new VisitanteVO();
        tses011Visitantes = personaService.obtenerVisitante(idVisitante);
        return tses011Visitantes;
    }

    @RequestMapping(value = "/listEmpleado", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> obtieneListaEmpleados(@RequestParam Integer idTipoPersona,
            @RequestParam String idUr, 
            @RequestParam String curp,
            @RequestParam String nombre,
            @RequestParam String primerApellido,
            @RequestParam String segundoApellido) {
        //System.out.println("lista"+idRol+idInmueble+idUr);
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "Roles " + us.getRoles());

        List<TSES004PersonasJoin> lstEmpleados = null;
        
        Integer Ur =  Integer.parseInt(idUr);
        if (Ur==1000){
            Ur=null;
        }

        try {

            lstEmpleados = personaService.obtenerAllPersonaRol(idTipoPersona,Ur,curp,nombre,primerApellido,segundoApellido);

            return new ResponseEntity<List<TSES004PersonasJoin>>(lstEmpleados, HttpStatus.OK);
        } catch (Exception exc) {
            exc.printStackTrace();
            return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
        }

    }
    
    @RequestMapping(value = "/listVisitante", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> obtieneListaVisitantes( 
            @RequestParam Integer idUr,
            @RequestParam String curp,
            @RequestParam String nombre) {
        //System.out.println("lista"+idRol+idInmueble+idUr);
        UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
        LoggerUtil.debug(this, "Roles " + us.getRoles());

        List<Tses011VisitanteJoin> lstVisitantes = null;

        try {

            lstVisitantes = personaService.obtenerVisitantes(curp,nombre,idUr);

            return new ResponseEntity<List<Tses011VisitanteJoin>>(lstVisitantes, HttpStatus.OK);
        } catch (Exception exc) {
            exc.printStackTrace();
            return new ResponseEntity<String>(exc.getMessage(), HttpStatus.CONFLICT);
        }

    }
        
    
    @RequestMapping(value = "/nuevoEmpleado", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView agregarEmpleado() {        
        ModelAndView modelAndView = new ModelAndView("Usuarios/empleados");
        return modelAndView;
    }
    
    @RequestMapping(value = "/nuevoProveedor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView agregarProveedor() {        
        ModelAndView modelAndView = new ModelAndView("Usuarios/proveedores");
        return modelAndView;
    }
    
    @RequestMapping(value = "/nuevoVisitante", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView agregarVisitante() {        
        ModelAndView modelAndView = new ModelAndView("Usuarios/visitantes");
        return modelAndView;
    }
    
    @RequestMapping(value = "/modificaEmpleado", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView modificaEmpleados(
            @RequestParam Integer idPersona
    ) {

        ModelAndView modelAndView = new ModelAndView("Usuarios/empleados");
        modelAndView.addObject("idPersona", idPersona);

        return modelAndView;

    }
    
    @RequestMapping(value = "/modificaProveedor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView modificaProveedor(
            @RequestParam Integer idPersona
    ) {

        ModelAndView modelAndView = new ModelAndView("Usuarios/proveedores");
        modelAndView.addObject("idPersona", idPersona);

        return modelAndView;

    }
    
    @RequestMapping(value = "/modificaVisitantes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView modificaVisitantes(
            @RequestParam Integer idVisitante
    ) {

        ModelAndView modelAndView = new ModelAndView("Usuarios/visitantes");
        modelAndView.addObject("idVisitante", idVisitante);

        return modelAndView;

    }
    
    @RequestMapping(value = "/consultaEmpleado", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView consultaEmpleado(
            @RequestParam Integer idUR
    ) {

        ModelAndView modelAndView = new ModelAndView("Usuarios/consultaEmpleados");
        modelAndView.addObject("idUR", idUR);
        return modelAndView;

    }
    
    @RequestMapping(value = "/consultaEmpleados", method = RequestMethod.GET)
    public ModelAndView consultaEmpleados(
    ) {

        ModelAndView modelAndView = new ModelAndView("Usuarios/consultaEmpleados");
        return modelAndView;

    }
    
    @RequestMapping(value = "/consultaProveedor", method = RequestMethod.GET)
    public ModelAndView consultaProveedor(
    ) {

        ModelAndView modelAndView = new ModelAndView("Usuarios/consultaProveedores");
        return modelAndView;

    }
    
    @RequestMapping(value = "/consultaVisitante", method = RequestMethod.GET)
    public ModelAndView consultaVisitante(
    ) {

        ModelAndView modelAndView = new ModelAndView("Usuarios/consultaVisitantes");
        return modelAndView;

    }

   @RequestMapping(value = "/imprimirGafete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> imprimirGafete(HttpServletResponse response, HttpServletRequest request,@RequestBody String[] arrayUsuarios) throws IOException {
        String mensaje = "";
        
         Map<String, Object> parametros = new HashMap<String, Object>();
         StringBuilder personas = new StringBuilder();
        try{
            List<String> lstUsuarios = Arrays.asList(arrayUsuarios);
            int i = 0;
            for(String id : lstUsuarios){
                if (i==0)
                personas.append(id);
                else 
                  personas.append("," + id);  
                ++i;
                System.out.println("controller seleccionados ==> " + id);
            }
            String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
            parametros.put("pCriterio", personas.toString());
            parametros.put("PATH_WEB",rutaSer);
             //InputStream jasperStream = this.getClass().getResourceAsStream("/mx/sep/sesi/reportes/credencial.jrxml");
             InputStream jasperStream =  this.getClass().getResourceAsStream("/mx/sep/sesi/reportes/credencial.jasper");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport, parametros,
                    dataSource.getConnection());

            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename=Gafete_" + arrayUsuarios + ".pdf");

            final OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
            
            mensaje = "Proceso correcto...";
        }catch(Exception e){
            mensaje = "?currio un error...";
            return new ResponseEntity<String>(mensaje, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>(mensaje, HttpStatus.OK);    
    }
    
    
    }
    
    
