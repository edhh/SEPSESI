/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.web.controller.consulta;

import com.google.zxing.WriterException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.util.SeguridadUtil;
import mx.sep.sesi.datos.vo.EquiposVO;
import mx.sep.sesi.datos.vo.OperacionVO;
import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.modelo.Tses011Visitantes;
import mx.sep.sesi.modelo.Tses024Equipos;
import mx.sep.sesi.modelo.join.TSES004PersonasJoin;
import mx.sep.sesi.servicios.ConsultaService;
import mx.sep.sesi.servicios.ControlAccesoServicio;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.sep.sesi.web.util.Codifica;
import mx.sep.sesi.servicios.util.Constants;
import mx.sep.sesi.web.util.ExpresionRegular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * @author heriberto.perez
 */
@Controller
@RequestMapping(value = "/consultaQR")
public class ConsultaQRController {
    
    @Autowired
    private ConsultaService consultaService;  
    @Autowired
    private ControlAccesoServicio controlAccesoServicio;
    
    @RequestMapping(value = "/datosPersona", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> datosPersona(@RequestParam String cadena) throws WriterException, IOException, Exception{
        String clave = Constants.CLAVE_SECRETA;
        Codifica codifica = new Codifica();
        String datosQR = codifica.desencriptar(cadena, clave);
        System.out.println("Datos qr " + datosQR);
        String[] datos = datosQR.split("-"); 
        Integer idPersona = Integer.valueOf( datos[0].toString() ); 
        Tses004Personas persona = new Tses004Personas();
        persona = consultaService.obtenerPersonasQR(idPersona );
        return new ResponseEntity<Tses004Personas>(persona, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/datosPersonaEquipos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> datosPersonaEquipos(@RequestParam String cadena) throws WriterException, IOException, Exception{
        String clave = Constants.CLAVE_SECRETA;
        Codifica codifica = new Codifica();
        String datosQR = codifica.desencriptar(cadena, clave);
        String[] datos = datosQR.split("-"); 
        String curp = datos[0]; 
        Tses004Personas persona = new Tses004Personas();
        persona = consultaService.obtenerPersonasQREquipo(curp );
        return new ResponseEntity<Tses004Personas>(persona, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/datosEquipo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> datosEquipo(@RequestParam String cadena) throws WriterException, IOException, Exception{
        String clave = Constants.CLAVE_SECRETA;
        Codifica codifica = new Codifica();
        String datosQR = codifica.desencriptar(cadena, clave);
        System.out.println("Datos qr " + datosQR);
        String[] datos = datosQR.split("-"); 
        System.out.println("datos "+ datos[1]);
        String curp = datos[0]; 
        String numSerie = datos[1];
        long startTime = System.currentTimeMillis();
        List<EquiposVO> equipos = consultaService.obtenerPersonasEquipo(curp, numSerie );
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("tiempo " + endTime);
        return new ResponseEntity<List<EquiposVO>>(equipos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/generarQREquipos", method = RequestMethod.GET)
    public String generarQREquipos (ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) throws WriterException, IOException, Exception {
            
        Codifica codifica = new Codifica();
        String pCodSeguridad = "AAMA740223MDFLRR06"+ "-" + "5DF334NTHY";
        String claveEncriptacion = Constants.CLAVE_SECRETA;
        String encriptado = codifica.encriptar(pCodSeguridad, claveEncriptacion);
        System.out.println("Encriptado " + encriptado);
        String datosQR = codifica.desencriptar(encriptado, claveEncriptacion);
        System.out.println("Datos qr " + datosQR);

        return encriptado;
    }
    
    /**
     * Método que permite recuperar los datos del proveedor
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
            if( datosEncriptados.substring(0, 6).equals( "httpsÑ" ) ){
                datosEncriptados = new ExpresionRegular().reemplazarCaracteresEspeciales( operacionVO.getCadenaQR() );
            } 
            //System.out.println("Datos encriptados despues " + datosEncriptados.substring(0, 6));
            if( datosEncriptados.substring(0, 4).equals( "http" ) ){
                String[] cadena = datosEncriptados.split( Constants.SEPARADOR_QR );    
                //System.out.println("Cadena :: " + cadena[cadena.length-1]);
                datosQR = codifica.desencriptar(cadena[cadena.length-1], Constants.CLAVE_SECRETA);
            } else{
                datosQR = codifica.desencriptar(datosEncriptados, Constants.CLAVE_SECRETA);
                System.out.println("datosQR " + datosQR);
            }   
            String[] datos = datosQR.split("-");            
            if( datos[1].equals("1") || datos[1].equals("2") ) {
                System.out.println("Aqrui");
                Tses004Personas persona = new Tses004Personas();
                Integer idPersona = Integer.valueOf( datos[0].toString() ); 
                persona = controlAccesoServicio.obtenerInformacion( idPersona ); 
                if( persona != null ){
                    if(persona.getEstatus() == 1){     
                        operacionVO.setIdPersona(idPersona);
                        //Optional<Long> idOperacion  =  controlAccesoServicio.registrarEntrada(operacionVO);
                    } else {
                        return new ResponseEntity<Tses004Personas>(persona, HttpStatus.LOCKED); 
                    }
                } else {
                    return new ResponseEntity<Tses004Personas>(persona, HttpStatus.NOT_FOUND); 
                }
                return new ResponseEntity<Tses004Personas>(persona, HttpStatus.OK);  
            }
        }catch(Exception exc){            
            System.out.println("ERROR_01 - Ocurrió un error en el método registrarEntrada() ");
            return new ResponseEntity<String>("Ocurrió un error", HttpStatus.CONFLICT);
        }
        //return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        return null;
    }
    
     /**
     * Método que registra la entrada o salida de los equipos de computo
     * @param operacionVO
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/registraOperacionEquipos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String registraOperacionEquipos(@RequestBody OperacionVO operacionVO ) throws Exception {
        if (operacionVO.getBandera().equals("1")){
            UsuarioSeguridad usuarioSeguridad = SeguridadUtil.getUsuarioActual(); 
            System.out.println("Username " + usuarioSeguridad.getUsername());
            System.out.println("Password " + usuarioSeguridad.getPassword());
            operacionVO.setUsuario(usuarioSeguridad.getUsername());
        } 
        String response = controlAccesoServicio.registrarEntradaSalidaEquipos(operacionVO);
        return "{\"msg\":\"" + response + "\"}";
    }
    
    /**
     * Método que verifica el usuario y password del usuario
     * @param usuario
     * @param pass
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/verificaCredenciales", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String verificaCredenciales(@RequestParam String usuario, @RequestParam String pass ) throws Exception {
        String response = controlAccesoServicio.verificaCredenciales(usuario,pass);
        return "{\"msg\":\"" + response + "\"}";
    }
  
}
