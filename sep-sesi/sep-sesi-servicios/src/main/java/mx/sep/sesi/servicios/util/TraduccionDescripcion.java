/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author angel.adame
 */
public class TraduccionDescripcion {
    
     private static final Map<String, String> MENU_MAP;
    
     static {
        MENU_MAP = new HashMap<String, String>();
        
         MENU_MAP.put("PersonaService.insertaEmpleado(..)", "Registrar o modificar empleado");
         MENU_MAP.put("PersonaService.insertaProveedor(..)", "Registrar o modificar proveedor");
         MENU_MAP.put("PersonaService.insertaVisitante(..)", "Registrar o modificar visitante");
         
         MENU_MAP.put("ConfiguracionServicio.cambioContrasena(..)", "Cambiar contrase&ntilde;a");
         
         MENU_MAP.put("EtiquetaServicio.registrarEtiquetas(..)", "Registrar etiquetas");
         MENU_MAP.put("EtiquetaServicio.reimprimirEtiquetas(..)", "Reimprimir etiquetas");
         
         MENU_MAP.put("ControlAccesoServicio.registrarEntrada(..)", "Registrar entrada");
         MENU_MAP.put("ControlAccesoServicio.registrarSalida(..)", "Registrar salida");
         
         MENU_MAP.put("CatUsuarioService.crearUsuarioCat(..)", "Registrar o modificar usuario");
         
         MENU_MAP.put("CatInmuebleService.crearInmuebleCat(..)", "Registrar o modificar inmueble");
         
         MENU_MAP.put("CatAccesoService.crearAccesoCat(..)", "Registrar o modificar acceso");
         MENU_MAP.put("CatAccesoService.eliminaAccesoCat(..)", "Eliminar acceso");
         
         MENU_MAP.put("CatFirmantesService.insertaFirmante(..)", "Registrar o modificar firmante");
         
         MENU_MAP.put("CatalogosServicio.insertaCuadrante(..)", "Registrar o modificar cuadrante");
         MENU_MAP.put("CatalogosServicio.eliminaCuadranteCat(..)", "Eliminar cuadrante");  
                 
     }
    
     public static String traduceNombreCorto(String nombreCorto) {
        if (MENU_MAP.containsKey(nombreCorto)) {
            return MENU_MAP.get(nombreCorto);
        } else {
            return null;
        }
    }
    
}
