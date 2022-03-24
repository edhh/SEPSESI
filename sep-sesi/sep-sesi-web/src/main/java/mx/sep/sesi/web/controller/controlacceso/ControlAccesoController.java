/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.web.controller.controlacceso;


import java.util.Date;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.util.SeguridadUtil;
import mx.sep.sesi.datos.vo.OperacionVO;
import mx.sep.sesi.datos.vo.UsuarioVO;
import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.modelo.Tses011Visitantes;
import mx.sep.sesi.servicios.ControlAccesoServicio;
import mx.sep.sesi.servicios.UsuarioService;
import mx.sep.sesi.servicios.util.Constants;
import mx.sep.sesi.servicios.util.LoggerUtil;
import mx.sep.sesi.web.util.Codifica;
import mx.sep.sesi.web.util.ExpresionRegular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author pedro.flores
 */
@Controller
@RequestMapping(value = "/controlAcceso")
public class ControlAccesoController {
    
    @Autowired
    private ControlAccesoServicio controlAccesoServicio; 
    
    @Autowired
    private UsuarioService usuarioService;

        
    /**
     * M�todo que permite el registro de Empleados, Proveedores y Visitantes  mediante el datos encriptados
     * @param operacionVO
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/registrarEntrada", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> registrarEntrada(@RequestBody OperacionVO operacionVO, HttpServletRequest request ) throws Exception {
        Codifica codifica = new Codifica();
        HttpSession session = request.getSession();
        String datosEncriptados = operacionVO.getCadenaQR(); 
        UsuarioVO usuarioVO = new UsuarioVO();
        UsuarioSeguridad usuarioSeguridad;
        try{
            usuarioSeguridad = SeguridadUtil.getUsuarioActual();         
        }catch(Exception exc){            
            System.out.println("ERROR_02 - La sesi�n expiro ");
            return new ResponseEntity<String>("La sesi�n expiro, por favor autentificarse de nuevo", HttpStatus.REQUEST_TIMEOUT);
            
        }
            usuarioVO = usuarioService.consultarPorNombreUsu(usuarioSeguridad.getUsername());
        if (usuarioVO.getIdRol()==6){
            System.out.println("Obtener usuario segunods");
            String segundos = usuarioService.obtieneSegundosSesion();

            session.setMaxInactiveInterval(Integer.parseInt(segundos));
            }
        try{         
            String datosQR = "";
            //System.out.println("Cadena a registrar " + datosEncriptados);
            //System.out.println("Datos encriptados antes " + datosEncriptados.substring(0, 6));
            if( datosEncriptados.substring(0, 6).equals( "https�" ) ){
                datosEncriptados = new ExpresionRegular().reemplazarCaracteresEspeciales( operacionVO.getCadenaQR() );
            }
            else{
                datosEncriptados = new ExpresionRegular().reemplazarCaracteresEspeciales( operacionVO.getCadenaQR() );
            }
            //System.out.println("Datos encriptados despues " + datosEncriptados.substring(0, 6));
            if( datosEncriptados.substring(0, 4).equals( "http" ) ){
                String[] cadena = datosEncriptados.split( Constants.SEPARADOR_QR );    
                //System.out.println("Cadena :: " + cadena[cadena.length-1]);
                datosQR = codifica.desencriptar(cadena[cadena.length-1], Constants.CLAVE_SECRETA);
            } else{
                datosQR = codifica.desencriptar(datosEncriptados, Constants.CLAVE_SECRETA);
            }
            
            String[] datos = datosQR.split("-");            
            if( datos[1].equals("1") || datos[1].equals("2") ) {
                Tses004Personas persona = new Tses004Personas();
                Integer idPersona = Integer.valueOf( datos[0].toString() ); 
                persona = controlAccesoServicio.obtenerInformacion( idPersona ); 
                if( persona != null ){
                    if(persona.getEstatus() == 1){     
                        operacionVO.setIdPersona(idPersona);
                        Optional<Long> idOperacion  =  controlAccesoServicio.registrarEntrada(operacionVO);
                    } else {
                        return new ResponseEntity<Tses004Personas>(persona, HttpStatus.LOCKED); 
                    }
                } else {
                    return new ResponseEntity<Tses004Personas>(persona, HttpStatus.NOT_FOUND); 
                }
                return new ResponseEntity<Tses004Personas>(persona, HttpStatus.OK);  
            } else {
                Tses011Visitantes visitante = new Tses011Visitantes();                
                Long idEtiqueta = Long.valueOf( datos[0] ); //operacionVO.getIdEtiqueta();
                Integer idInmueble = operacionVO.getIdInmueble();
                visitante = controlAccesoServicio.obtenerVisitantePorEtiqueta( idInmueble, idEtiqueta ); 
                if( visitante != null ){ 
                    Date fecha1 = visitante.getFechaActualizacion();
                    Date fecha2 = new Date();
                    Integer dias = numeroDias(fecha1,fecha2);
                    if(dias <= 5){
                        operacionVO.setIdVisitante(visitante.getIdVisitante());
                        controlAccesoServicio.registrarEntrada(operacionVO);  
                    } else {
                        return new ResponseEntity<Tses011Visitantes>(visitante, HttpStatus.LOCKED); 
                    }
                } else {
                    return new ResponseEntity<Tses011Visitantes>(visitante, HttpStatus.NOT_FOUND); 
                }   
                return new ResponseEntity<Tses011Visitantes>(visitante, HttpStatus.OK);  
            }
        }catch(Exception exc){            
            System.out.println("ERROR_01 - Ocurri� un error en el m�todo registrarEntrada() ");
            return new ResponseEntity<String>("Ocurri� un error", HttpStatus.CONFLICT);
        }
        //return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
    }
    
    
    /**
     * M�todo que permite el registro de Empleados y Proveedores.
     * @param operacionVO
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/registrarEntradaPersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> registrarEntradaPersona(@RequestBody OperacionVO operacionVO ) throws Exception {
        Tses004Personas persona = new Tses004Personas();
        Integer idPersona = operacionVO.getIdPersona(); 
        //System.out.println("Controller - Solicitud de registro - idPersona: " + idPersona );
        try{
            //System.out.println("Paso 1: Consulta informaci�n persona... " + new Date());
            persona = controlAccesoServicio.obtenerInformacion(idPersona); 
            if( persona != null ){
                if(persona.getEstatus() == 1){ 
                    //System.out.println("Paso 2: Solicita registro de operaci�n - idPersona: " +  persona.getIdPersona() + " fecha:" +new Date());
                    Optional<Long> idOperacion  =  controlAccesoServicio.registrarEntrada(operacionVO);
                    //System.out.println("Controller - Respuesta de Registro - idPersona: " + idPersona );
                } else {
                    return new ResponseEntity<Tses004Personas>(persona, HttpStatus.LOCKED); 
                }
            } else {
                return new ResponseEntity<Tses004Personas>(persona, HttpStatus.NOT_FOUND); 
            }
        }catch(Exception exc){
            System.out.print("Error encontrado: " + exc.getMessage());
            return new ResponseEntity<String>("Ocurri� un error", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Tses004Personas>(persona, HttpStatus.OK);  
    }  
    
    /**
     * M�todo que permite el registro de visitantes.
     * @param operacionVO
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/registrarEntradaVisitante", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?>  registrarEntradaVisitante(@RequestBody OperacionVO operacionVO ) throws Exception {
        Tses011Visitantes visitante = new Tses011Visitantes();
        Integer idInmueble = operacionVO.getIdInmueble();
        Long idEtiqueta = operacionVO.getIdEtiqueta();  
        System.out.println("Visitante: " + idInmueble +" - " +idEtiqueta);
        System.out.println("Controller : " + new Date());
        try{
            visitante = controlAccesoServicio.obtenerVisitantePorEtiqueta( idInmueble, idEtiqueta ); 
            if( visitante != null ){ 
                Date fecha1 = visitante.getFechaActualizacion();
                Date fecha2 = new Date();
                Integer dias = numeroDias(fecha1,fecha2);
                if(dias <= 5){
                    System.out.print("Solicitud registroEntrada idVisitante: " + visitante.getIdVisitante() );
                    operacionVO.setIdVisitante(visitante.getIdVisitante());
                    controlAccesoServicio.registrarEntrada(operacionVO);  
                    System.out.print("Respuesta registroEntrada idVisitante: " + visitante.getIdVisitante() );
                } else {
                    return new ResponseEntity<Tses011Visitantes>(visitante, HttpStatus.LOCKED); 
                }
            } else {
                return new ResponseEntity<Tses011Visitantes>(visitante, HttpStatus.NOT_FOUND); 
            }
        }catch(Exception exc){
            System.out.println("Se produjo un error en controller registrarEntradaVisitante()");
            return new ResponseEntity<String>("Ocurri� un error", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Tses011Visitantes>(visitante, HttpStatus.OK);  
    } 
    
    
    @RequestMapping(value = "/registrarSalidaPersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> registrarSalidaPersona(@RequestBody OperacionVO operacionVO ) throws Exception {
        Tses004Personas persona = new Tses004Personas();
        Integer idPersona = operacionVO.getIdPersona(); 
        LoggerUtil.debug(this, "Registro de persona --> "+idPersona);
        try{
            persona = controlAccesoServicio.obtenerInformacion(idPersona); 
            if( persona != null ){
                    controlAccesoServicio.registrarSalida(operacionVO);                 
            } else {
                return new ResponseEntity<Tses004Personas>(persona, HttpStatus.NOT_FOUND); 
            }
        }catch(Exception exc){
            return new ResponseEntity<String>("Ocurri� un error", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Tses004Personas>(persona, HttpStatus.OK);  
    }
    
    
    @RequestMapping(value = "/registrarSalidaVisitante", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?>  registrarSalidaVisitante(@RequestBody OperacionVO operacionVO ) throws Exception {
        Tses011Visitantes visitante = new Tses011Visitantes();
        Integer idInmueble = operacionVO.getIdInmueble();
        Long idEtiqueta = operacionVO.getIdEtiqueta();  
        LoggerUtil.debug(this, "Registro de visitante --> "+idEtiqueta);
        try{
            visitante = controlAccesoServicio.obtenerVisitantePorEtiqueta( idInmueble, idEtiqueta ); 
            if( visitante != null ){ 
                /*Date fecha1 = visitante.getFechaActualizacion();
                Date fecha2 = new Date();
                Integer dias = numeroDias(fecha1,fecha2);
                if(dias <= 5){*/
                    operacionVO.setIdVisitante(visitante.getIdVisitante());
                    controlAccesoServicio.registrarSalida(operacionVO);  
                /*} else {
                    return new ResponseEntity<Tses011Visitantes>(visitante, HttpStatus.LOCKED); 
                }*/
            } else {
                return new ResponseEntity<Tses011Visitantes>(visitante, HttpStatus.NOT_FOUND); 
            }
        }catch(Exception exc){
            return new ResponseEntity<String>("Ocurri� un error", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Tses011Visitantes>(visitante, HttpStatus.OK);  
    } 
    
    
    
    public int numeroDias(Date fecha1, Date fecha2){
        long startTime = fecha1.getTime();
        long endTime = fecha2.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        return (int)diffDays;
    }
    
    /**
     * M�todo que permite recuperar los datos del proveedor
     * @param operacionVO
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/recuperarDatosProveedor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> recuperarDatosProveedor(@RequestBody OperacionVO operacionVO ) throws Exception {
        Codifica codifica = new Codifica();
        String datosEncriptados = operacionVO.getCadenaQR(); 
        try{         
            String datosQR = "";
            System.out.println("Cadena a registrar " + datosEncriptados);
            //System.out.println("Datos encriptados antes " + datosEncriptados.substring(0, 6));
            if( datosEncriptados.substring(0, 6).equals( "https�" ) ){
                datosEncriptados = new ExpresionRegular().reemplazarCaracteresEspeciales( operacionVO.getCadenaQR() );
            } 
            //System.out.println("Datos encriptados despues " + datosEncriptados.substring(0, 6));
            if( datosEncriptados.substring(0, 4).equals( "http" ) ){
                String[] cadena = datosEncriptados.split( Constants.SEPARADOR_QR );    
                //System.out.println("Cadena :: " + cadena[cadena.length-1]);
                datosQR = codifica.desencriptar(cadena[cadena.length-1], Constants.CLAVE_SECRETA);
            } else{
                System.out.println("Aqui");
                System.out.println("datosEncriptados " + datosEncriptados);
                datosQR = codifica.desencriptar(datosEncriptados, Constants.CLAVE_SECRETA);
                System.out.println("datosQR " + datosQR);
            }
            System.out.println("datosQR " + datosQR);
            String[] datos = datosQR.split("-");            
            if( datos[1].equals("1") || datos[1].equals("2") ) {
                System.out.println("Aqrui");
                Tses004Personas persona = new Tses004Personas();
                Integer idPersona = Integer.valueOf( datos[0].toString() ); 
                persona = controlAccesoServicio.obtenerInformacion( idPersona ); 
                if( persona != null ){
                    if(persona.getEstatus() == 1){     
                        operacionVO.setIdPersona(idPersona);
                        Optional<Long> idOperacion  =  controlAccesoServicio.registrarEntrada(operacionVO);
                    } else {
                        return new ResponseEntity<Tses004Personas>(persona, HttpStatus.LOCKED); 
                    }
                } else {
                    return new ResponseEntity<Tses004Personas>(persona, HttpStatus.NOT_FOUND); 
                }
                return new ResponseEntity<Tses004Personas>(persona, HttpStatus.OK);  
            } else {
                Tses011Visitantes visitante = new Tses011Visitantes();                
                Long idEtiqueta = Long.valueOf( datos[0] ); //operacionVO.getIdEtiqueta();
                Integer idInmueble = operacionVO.getIdInmueble();
                visitante = controlAccesoServicio.obtenerVisitantePorEtiqueta( idInmueble, idEtiqueta ); 
                if( visitante != null ){ 
                    Date fecha1 = visitante.getFechaActualizacion();
                    Date fecha2 = new Date();
                    Integer dias = numeroDias(fecha1,fecha2);
                    if(dias <= 5){
                        operacionVO.setIdVisitante(visitante.getIdVisitante());
                        controlAccesoServicio.registrarEntrada(operacionVO);  
                    } else {
                        return new ResponseEntity<Tses011Visitantes>(visitante, HttpStatus.LOCKED); 
                    }
                } else {
                    return new ResponseEntity<Tses011Visitantes>(visitante, HttpStatus.NOT_FOUND); 
                }   
                return new ResponseEntity<Tses011Visitantes>(visitante, HttpStatus.OK);  
            }
        }catch(Exception exc){            
            System.out.println("ERROR_01 - Ocurri� un error en el m�todo registrarEntrada() ");
            return new ResponseEntity<String>("Ocurri� un error", HttpStatus.CONFLICT);
        }
        //return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
    }
    
}
