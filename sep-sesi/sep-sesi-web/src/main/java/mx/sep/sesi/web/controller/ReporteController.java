/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.sep.sesi.web.controller;


import com.google.zxing.WriterException;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.modelo.Tses018Etiquetas;
import mx.sep.sesi.modelo.join.TSES004PersonasJoin;
import mx.sep.sesi.servicios.ConsultaService;
import mx.sep.sesi.servicios.PersonaService;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import mx.sep.sesi.web.util.QRGenerator;
import mx.sep.sesi.web.util.Codifica;
import mx.sep.sesi.servicios.util.Constants;


/**
 *
 * @author eduardo.hernandez
 */
@Controller
@RequestMapping("/jasper")
public class ReporteController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private ConsultaService consultaService;
    
    @Autowired
    private PersonaService personaService;

    @RequestMapping(value = "/repCredencial", method = RequestMethod.GET)
    public ModelAndView reporte(ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) throws WriterException, IOException, Exception {
        modelMap.put("dataSourceKey", jdbcTemplate.getDataSource());
        String lstId = request.getParameter("lstId");
        System.out.println("lstId"+lstId);
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for (String field : lstId.split(",")){
            lst.add(Integer.parseInt(field));  
        }
        List <Tses004Personas> obtenerLista = personaService.obtenerListaPersonas(lst);
        String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
        Codifica codifica = new Codifica();
        String claveEncriptacion = Constants.CLAVE_SECRETA;
        for (int i = 0; i< obtenerLista.size(); i++){
            
            String pCodSeguridad = obtenerLista.get(i).getIdPersona()+ "-" + obtenerLista.get(i).getIdTipoPersona() + "-" + obtenerLista.get(i).getCurp() + "-" + obtenerLista.get(i).getIdUr();
            String encriptado = codifica.encriptar(pCodSeguridad, claveEncriptacion);
            String desencriptado = codifica.desencriptar(encriptado, claveEncriptacion);
            
            String datosQr = encriptado;
            System.out.println("Encriptado " + encriptado);
            QRGenerator qr = new QRGenerator();
            qr.QRGeneratorData(datosQr, rutaSer, obtenerLista.get(i).getIdPersona());
        }
        

        modelMap.put("PATH_JASPER", rutaSer + "WEB-INF/classes/");
        modelMap.put("PATH_WEB", rutaSer);
        modelMap.put("pCriterio", lstId);
        //pdfReport bean has ben declared in the jasper-views.xml file
        ModelAndView modelAndView = new ModelAndView("repCredencial", modelMap);

        return modelAndView;
    }
    
    @RequestMapping(value = "/repCredencialTrabajador", method = RequestMethod.GET)
    public ModelAndView repCredencialTrabajador (ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) throws WriterException, IOException, Exception {
        modelMap.put("dataSourceKey", jdbcTemplate.getDataSource());
        String lstId = request.getParameter("lstId");
        System.out.println("lstId"+lstId);
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for (String field : lstId.split(",")){
            lst.add(Integer.parseInt(field));  
        }
        
        List <Tses004Personas> obtenerLista = personaService.obtenerListaPersonas(lst);
        String url = personaService.obtieneURLQr();
        String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
        Codifica codifica = new Codifica();
        String claveEncriptacion = Constants.CLAVE_SECRETA;
        for (int i = 0; i< obtenerLista.size(); i++){
            
            String pCodSeguridad = obtenerLista.get(i).getIdPersona()+ "-" + obtenerLista.get(i).getIdTipoPersona() + "-" + obtenerLista.get(i).getCurp() + "-" + obtenerLista.get(i).getIdUr();
            String encriptado = codifica.encriptar(pCodSeguridad, claveEncriptacion);
            System.out.println("Encriptado " + encriptado);
            String desencriptado = codifica.desencriptar(encriptado, claveEncriptacion);
            String datosQr = url + encriptado;
            QRGenerator qr = new QRGenerator();
            qr.QRGeneratorData(datosQr, rutaSer, obtenerLista.get(i).getIdPersona());
        }
        modelMap.put("PATH_JASPER", rutaSer + "WEB-INF/classes/");
        modelMap.put("PATH_WEB", rutaSer);
        modelMap.put("pCriterio", lstId);
        //pdfReport bean has ben declared in the jasper-views.xml file
        ModelAndView modelAndView = new ModelAndView("repCredencialTrabajadores", modelMap);

        return modelAndView;
    }
    
    @RequestMapping(value = "/repCredencialTrabajadoresPVC", method = RequestMethod.GET)
    public ModelAndView repCredencialTrabajadoresPVC (ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) throws WriterException, IOException, Exception {
        modelMap.put("dataSourceKey", jdbcTemplate.getDataSource());
        String lstId = request.getParameter("lstId");
        System.out.println("lstId"+lstId);
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for (String field : lstId.split(",")){
            lst.add(Integer.parseInt(field));  
        }
        
        List <Tses004Personas> obtenerLista = personaService.obtenerListaPersonas(lst);
        String url = personaService.obtieneURLQr();
        String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
        Codifica codifica = new Codifica();
        String claveEncriptacion = Constants.CLAVE_SECRETA;
        for (int i = 0; i< obtenerLista.size(); i++){
            
            String pCodSeguridad = obtenerLista.get(i).getIdPersona()+ "-" + obtenerLista.get(i).getIdTipoPersona() + "-" + obtenerLista.get(i).getCurp() + "-" + obtenerLista.get(i).getIdUr();
            String encriptado = codifica.encriptar(pCodSeguridad, claveEncriptacion);
            System.out.println("Encriptado " + encriptado);
            String desencriptado = codifica.desencriptar(encriptado, claveEncriptacion);
            
            String datosQr = url + encriptado;
            System.out.println("URL QR" + datosQr);
            QRGenerator qr = new QRGenerator();
            qr.QRGeneratorData(datosQr, rutaSer, obtenerLista.get(i).getIdPersona());
        }
        modelMap.put("PATH_JASPER", rutaSer + "WEB-INF/classes/");
        modelMap.put("PATH_WEB", rutaSer);
        modelMap.put("pCriterio", lstId);
        //pdfReport bean has ben declared in the jasper-views.xml file
        ModelAndView modelAndView = new ModelAndView("repCredencialTrabajadoresPVC", modelMap);

        return modelAndView;
    }
    
    @RequestMapping(value = "/repCredencialEtiqueta", method = RequestMethod.GET)
    public ModelAndView reporteCredencialEtiqueta(ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) throws WriterException, IOException, Exception {
        modelMap.put("dataSourceKey", jdbcTemplate.getDataSource());
        String lstId = request.getParameter("lstId");
        System.out.println("lstId"+lstId);
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for (String field : lstId.split(",")){
            lst.add(Integer.parseInt(field));  
        }
        List <Tses004Personas> obtenerLista = personaService.obtenerListaPersonas(lst);
        String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
        Codifica codifica = new Codifica();
        String claveEncriptacion = Constants.CLAVE_SECRETA;
        for (int i = 0; i< obtenerLista.size(); i++){
            String pCodSeguridad = obtenerLista.get(i).getIdPersona()+ "-" + obtenerLista.get(i).getIdTipoPersona() + "-" + obtenerLista.get(i).getCurp() + "-" + obtenerLista.get(i).getIdUr();
            String encriptado = codifica.encriptar(pCodSeguridad, claveEncriptacion);
            String desencriptado = codifica.desencriptar(encriptado, claveEncriptacion);
            
            String datosQr = encriptado;
            System.out.println("Encriptado " + encriptado);
            QRGenerator qr = new QRGenerator();
            qr.QRGeneratorData(datosQr, rutaSer, obtenerLista.get(i).getIdPersona());
        }
        

        modelMap.put("PATH_JASPER", rutaSer + "WEB-INF/classes/");
        modelMap.put("PATH_WEB", rutaSer);
        modelMap.put("pCriterio", lstId);
        //pdfReport bean has ben declared in the jasper-views.xml file
        ModelAndView modelAndView = new ModelAndView("repCredencialEtiqueta", modelMap);

        return modelAndView;
    }
    
    private byte[] rotateImage(byte[] originalImageAsBytes , double radians) throws InternalException {
        ByteArrayOutputStream rotatedImageStream = null;

    try {
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(originalImageAsBytes)); // read the original image
        AffineTransform rotationTransform = new AffineTransform();
        rotationTransform.rotate(radians, originalImage.getWidth() / 2.0 , originalImage.getHeight() / 2.0);
        AffineTransformOp rotationTransformOp = 
          new AffineTransformOp(rotationTransform , AffineTransformOp.TYPE_NEAREST_NEIGHBOR); 
        BufferedImage rotatedImage = rotationTransformOp.filter(originalImage,null); 

        rotatedImageStream = new ByteArrayOutputStream();
        ImageIO.write(rotatedImage, "jpg" , rotatedImageStream); 
        } catch (IOException e) {
         
        }
        return rotatedImageStream.toByteArray();
}
    
    @RequestMapping(value = "/repEtiqueta", method = RequestMethod.GET)
    public ModelAndView repEtiqueta(ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) throws WriterException, IOException, Exception{
        modelMap.put("dataSourceKey", jdbcTemplate.getDataSource());
        String lstId = request.getParameter("lstId");
        int idInmueble = Integer.parseInt (request.getParameter("idInmueble"));        
         ArrayList<Long> lst = new ArrayList<Long>();
        for (String field : lstId.split(",")){
            lst.add(Long.parseLong(field));  
        }
        List <Tses018Etiquetas> obtenerLista = personaService.obtenerListaVisitantes(lst,idInmueble);
        String url = personaService.obtieneURLQr();
        String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
        Codifica codifica = new Codifica();
        String claveEncriptacion = Constants.CLAVE_SECRETA;
        for (int i = 0; i< obtenerLista.size(); i++){
            
            String pCodSeguridad = obtenerLista.get(i).getIdEtiqueta() + "-" + "3" + "-" + obtenerLista.get(i).getIdInmueble();
            String encriptado = codifica.encriptar(pCodSeguridad, claveEncriptacion);
            String desencriptado = codifica.desencriptar(encriptado, claveEncriptacion);
            System.out.println("encriptado " + encriptado);
            System.out.println("desenciptado " + desencriptado);
            String datosQr = encriptado;
            QRGenerator qr = new QRGenerator();
            qr.QRGeneratorData(datosQr, rutaSer, obtenerLista.get(i).getIdEtiqueta().intValue());
        }
        modelMap.put("PATH_JASPER", rutaSer + "WEB-INF/classes/");
        modelMap.put("PATH_WEB", rutaSer);
        modelMap.put("pCriterio", lstId);
        modelMap.put("idInmueble", idInmueble);
        //pdfReport bean has ben declared in the jasper-views.xml file
        ModelAndView modelAndView = new ModelAndView("repEtiqueta", modelMap);

        return modelAndView;
    }
    
    /*@RequestMapping(value = "/repUsuarios", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView repUsuarios(HttpServletRequest request, HttpServletResponse response, @RequestParam Integer idTipoPersona,
            @RequestParam Integer idUr,
            @RequestParam String curp,
            @RequestParam Integer idInmueble) throws Exception {
        ModelMap modelMap = null;
        modelMap.put("dataSourceKey", jdbcTemplate.getDataSource());
        String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
        long token = new Date().getTime();
        token.
        Map model = new HashMap();
        List<TSES004PersonasJoin> lstTSES004PersonasJoin = null;
        lstTSES004PersonasJoin = consultaService.obtenerPersonas(idTipoPersona, idUr, curp, idInmueble);

        JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(lstTSES004PersonasJoin);
        model.put("lista", jrbean);
        modelMap.put("PATH_WEB", rutaSer);
        String tmpFolder = System.getProperty("java.io.tmpdir");
        JRFileVirtualizer virtualizer = new JRFileVirtualizer(1, tmpFolder);
        model.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);

        Cookie cookie = new Cookie("downloadRepUsuarios", token);
        cookie.setPath("/");
        response.addCookie(cookie);

        return new ModelAndView("repUsuarios", model);
    }*/
    
    @RequestMapping(value = "/repUsuarios", method = RequestMethod.GET)
    public ModelAndView repUsuarios(ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) {
        modelMap.put("dataSourceKey", jdbcTemplate.getDataSource());
  
        String Inmueble = request.getParameter("idInmueble");
        String persona = request.getParameter("idTipoPersona");
        String ur = request.getParameter("idUr");
        String curp = request.getParameter("curp");
        System.out.println("UR " + ur);
        System.out.println("Inmueble " + Inmueble);
        System.out.println("Persona " + persona);
        System.out.println("Curp " + curp);
        String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
        modelMap.put("PATH_JASPER", rutaSer + "WEB-INF/classes/");
        modelMap.put("PATH_WEB", rutaSer);
        modelMap.put("ID_TIPO_PERSONA", persona);
        modelMap.put("IDINMUEBLE", Inmueble);
        modelMap.put("curp", curp);
        modelMap.put("IDUR", ur);
        ModelAndView modelAndView = new ModelAndView("repUsuarios", modelMap);

        return modelAndView;
    }
    
    
     @RequestMapping(value = "/repUsuariosVisitante", method = RequestMethod.GET)
    public ModelAndView repUsuariosVisitante(ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) {
        modelMap.put("dataSourceKey", jdbcTemplate.getDataSource());
  
        String Inmueble = request.getParameter("idInmueble");
        String persona = request.getParameter("idTipoPersona");
        String ur = request.getParameter("idUr");
        String curp = request.getParameter("curp");
        System.out.println("UR " + ur);
        System.out.println("Inmueble " + Inmueble);
        System.out.println("Persona " + persona);
        System.out.println("Curp " + curp);
        String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
        modelMap.put("PATH_JASPER", rutaSer + "WEB-INF/classes/");
        modelMap.put("PATH_WEB", rutaSer);
        modelMap.put("ID_TIPO_PERSONA", persona);
        modelMap.put("IDINMUEBLE", Inmueble);
        modelMap.put("curp", curp);
        modelMap.put("IDUR", ur);
        ModelAndView modelAndView = new ModelAndView("repUsuariosVisitante", modelMap);

        return modelAndView;
    }
    
    @RequestMapping(value = "/repUsuariosPC", method = RequestMethod.GET)
    public ModelAndView repUsuariosPC(ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) {
        modelMap.put("dataSourceKey", jdbcTemplate.getDataSource());
  
        String Inmueble = request.getParameter("idInmueble");
        String persona = request.getParameter("idTipoPersona");
        String ur = request.getParameter("idUr");
        String curp = request.getParameter("curp");
        System.out.println("UR " + ur);
        System.out.println("Inmueble " + Inmueble);
        System.out.println("Persona " + persona);
        System.out.println("Curp " + curp);
        String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
        modelMap.put("PATH_JASPER", rutaSer + "WEB-INF/classes/");
        modelMap.put("PATH_WEB", rutaSer);
        modelMap.put("ID_TIPO_PERSONA", persona);
        modelMap.put("IDINMUEBLE", Inmueble);
        modelMap.put("curp", curp);
        modelMap.put("IDUR", ur);
        ModelAndView modelAndView = new ModelAndView("repUsuariosPC", modelMap);

        return modelAndView;
    }
   
    @RequestMapping(value = "/repControl", method = RequestMethod.GET)
    public ModelAndView repControl(ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) throws ParseException {
        modelMap.put("dataSourceKey", jdbcTemplate.getDataSource());
  
        String entradaSalida = request.getParameter("entradaSalida");
        String tipoPersona = request.getParameter("tipoPersona");
        String idUr = request.getParameter("idUr");
        String idInmueble = request.getParameter("idInmueble");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Date fecha1 = formatter.parse(request.getParameter("fecha1"));
        //Date fecha2 = formatter.parse(request.getParameter("fecha2"));
        String fecha1 = request.getParameter("fecha1");
        String fecha2 = request.getParameter("fecha2");
        String fecha3 = fecha2 + " 23:59:59";
        System.out.println("fecha1 " + fecha1);
        System.out.println("fecha2 " + fecha2);
        System.out.println("fecha3 " + fecha3);
        String operacion = "";
        if (entradaSalida.equals("1")){
            operacion = "Entrada";
        }
        else if (entradaSalida.equals("2")){
            operacion = "Salida";
        }
        String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
        modelMap.put("PATH_JASPER", rutaSer + "WEB-INF/classes/");
        modelMap.put("PATH_WEB", rutaSer);
        modelMap.put("entradaSalida", operacion);
        modelMap.put("tipoPersona", tipoPersona);
        modelMap.put("idUr", idUr);
        modelMap.put("idInmueble", idInmueble);
        modelMap.put("fecha1", fecha1);
        modelMap.put("fecha2", fecha2);
        modelMap.put("fecha3", fecha3);
        ModelAndView modelAndView = new ModelAndView("repControl", modelMap);

        return modelAndView;
    }
    
    @RequestMapping(value = "/repEquipos", method = RequestMethod.GET)
    public ModelAndView repEquipos(ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) throws ParseException {
        modelMap.put("dataSourceKey", jdbcTemplate.getDataSource());
  
        String entradaSalida = request.getParameter("entradaSalida");
        String tipoPersona = request.getParameter("tipoPersona");
        String idUr = request.getParameter("idUr");
        String idInmueble = request.getParameter("idInmueble");
        String curp = request.getParameter("curp");
        String serie = request.getParameter("serie");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Date fecha1 = formatter.parse(request.getParameter("fecha1"));
        //Date fecha2 = formatter.parse(request.getParameter("fecha2"));
        String fecha1 = request.getParameter("fecha1");
        String fecha2 = request.getParameter("fecha2");
        String fecha3 = fecha2 + " 23:59:59";
        System.out.println("fecha1 " + fecha1);
        System.out.println("fecha2 " + fecha2);
        System.out.println("fecha3 " + fecha3);
        String operacion = "";
        if (entradaSalida.equals("1")){
            operacion = "Entrada";
        }
        else if (entradaSalida.equals("2")){
            operacion = "Salida";
        }
        String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
        modelMap.put("PATH_JASPER", rutaSer + "WEB-INF/classes/");
        modelMap.put("PATH_WEB", rutaSer);
        modelMap.put("entradaSalida", operacion);
        modelMap.put("tipoPersona", tipoPersona);
        modelMap.put("idUr", idUr);
        modelMap.put("idInmueble", idInmueble);
        modelMap.put("fecha1", fecha1);
        modelMap.put("fecha2", fecha2);
        modelMap.put("fecha3", fecha3);
        ModelAndView modelAndView = new ModelAndView("repEquipos", modelMap);

        return modelAndView;
    }
    
    @RequestMapping(value = "/repControlVisitante", method = RequestMethod.GET)
    public ModelAndView repControlVisitante(ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) throws ParseException {
        modelMap.put("dataSourceKey", jdbcTemplate.getDataSource());
  
        String entradaSalida = request.getParameter("entradaSalida");
        String tipoPersona = request.getParameter("tipoPersona");
        String idUr = request.getParameter("idUr");
        String idInmueble = request.getParameter("idInmueble");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Date fecha1 = formatter.parse(request.getParameter("fecha1"));
        //Date fecha2 = formatter.parse(request.getParameter("fecha2"));
        String fecha1 = request.getParameter("fecha1");
        String fecha2 = request.getParameter("fecha2");
        String fecha3 = fecha2 + " 23:59:59";
        System.out.println("fecha1 " + fecha1);
        System.out.println("fecha2 " + fecha2);
        String rutaSer = request.getSession().getServletContext()
                .getRealPath("/");
        String operacion = "";
        if (entradaSalida.equals("1")){
            operacion = "Entrada";
        }
        else if (entradaSalida.equals("2")){
            operacion = "Salida";
        }
        modelMap.put("PATH_JASPER", rutaSer + "WEB-INF/classes/");
        modelMap.put("PATH_WEB", rutaSer);
        modelMap.put("entradaSalida", operacion);
        modelMap.put("tipoPersona", tipoPersona);
        modelMap.put("idUr", idUr);
        modelMap.put("idInmueble", idInmueble);
        modelMap.put("fecha1", fecha1);
        modelMap.put("fecha2", fecha2);
        modelMap.put("fecha3", fecha3);
        ModelAndView modelAndView = new ModelAndView("repControlVisitante", modelMap);

        return modelAndView;
    }
    
    @RequestMapping(value = "/generarQREquipos", method = RequestMethod.GET)
    public String generarQREquipos (ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) throws WriterException, IOException, Exception {
            
        Codifica codifica = new Codifica();
        String pCodSeguridad = "CAMV931010MDFMRV00"+ "-" + "5CD119LJ18";
        //String claveEncriptacion = Constants.CLAVE_SECRETA_EQUIPOS;
        String claveEncriptacion = Constants.CLAVE_SECRETA;
        String encriptado = codifica.encriptar(pCodSeguridad, claveEncriptacion);
        System.out.println("Encriptado " + encriptado);

        return encriptado;
    }
    
    
}
