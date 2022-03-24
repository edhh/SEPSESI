/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import mx.sep.sesi.modelo.Tses021Bitacora;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 *
 * @author angel.adame
 */
@Aspect
@Component
@Profile({"produccion", "testing", "dev", "desarrollo"})
public class BitacoraAspect {
    
   private static final String INSERTAR_DESC = "Inserción";
     //private static final String REGISTRAR_DESC = "Registro";
     private static final String REIMPRIMIR_DESC = "Reimpresión";
     private static final String CAMBIAR_DESC = "Cambiar";
     private static final String BORRAR_DESC = "Borrado";
     
      private static final String PARAM_NAME = "  parámetro ";
      private static final String NEW_LINE = "\n";
      private static final int MAX_LENGTH = 1200;
    
    private static final Logger logger = Logger.getLogger(BitacoraAspect.class);

    @Autowired
    private BitacoraService bitacoraService;
    
      @AfterReturning(
            pointcut = "execution(* mx.sep.sesi.servicios..*.guarda*(..)) ||"
            + "execution(* mx.sep.sesi.servicios..*.agrega*(..)) ||"
            + "execution(* mx.sep.sesi.servicios..*.crea*(..)) ||"
            + "execution(* mx.sep.sesi.servicios..*.inserta*(..)) ||"
            + "execution(* mx.sep.sesi.servicios..*.save*(..))",
            returning = "result")
    public void agregarAdvice(JoinPoint joinPoint, Object result) {
        procesa(INSERTAR_DESC, joinPoint);
    }
    
//    @AfterReturning(
//            pointcut = "execution(* mx.sep.sesi.servicios..*.registra*(..))",
//      returning = "result")
//    public void registrarAdvice(JoinPoint joinPoint, Object result) {
//        procesa(REGISTRAR_DESC, joinPoint);
//    }
    
     @AfterReturning(
            pointcut = "execution(* mx.sep.sesi.servicios..*.reimprimir*(..))",
      returning = "result")
    public void reimprimirAdvice(JoinPoint joinPoint, Object result) {
        procesa(REIMPRIMIR_DESC, joinPoint);
    }
    
     @AfterReturning(
            pointcut = "execution(* mx.sep.sesi.servicios..*.cambio*(..))",
      returning = "result")
    public void cambiarAdvice(JoinPoint joinPoint, Object result) {
        procesa(CAMBIAR_DESC, joinPoint);
    }
    
     @AfterReturning(pointcut = "execution(* mx.sep.sesi.servicios..*.elimina*(..)) ||"
            + "execution(* mx.sep.sesi.servicios..*.baja*(..)) ||"
            + "execution(* mx.sep.sesi.servicios..*.delete*(..))",
            returning = "result")
    public void eliminarAdvice(JoinPoint joinPoint, Object result) {
        procesa(BORRAR_DESC, joinPoint);
    }
    
    private void procesa(String tipoOper, JoinPoint joinPoint) {
        
        Integer idUsuario = bitacoraService.obtenIdUsuarioSession();
        
        if (idUsuario != null) {//Si se recupero de BD el id del usuario en sesión
            try {
                String nombreCorto = joinPoint.getSignature().toShortString();
                logger.debug("++++++++++++++++++++++++++++++++++++++++++++++++++++++++Registrando en bitacora ");
                logger.debug("Id Usuario  :" + idUsuario);
                logger.debug("Proceso     :" + tipoOper);
                logger.debug("Descripcion :" + nombreCorto);

                if (nombreCorto.startsWith(BitacoraService.class.getSimpleName())) {
                	logger.debug("El aspecto no se aplicará¡ para los métodos del servicio de la bitácora");
                } else {
                    // Se agrega la consulta a TraduServ para evitar usar la clase TraduccionDescripcion
                    logger.error("No se encontró la traducción en bitácora");
                    Tses021Bitacora bitacora = new Tses021Bitacora();
                    String descripcion = TraduccionDescripcion.traduceNombreCorto(nombreCorto);
                    bitacora.setIdUsuario(idUsuario);
                    bitacora.setProceso(tipoOper);             
                    bitacora.setDescripcion(nombreCorto);                    
                    if (joinPoint.getArgs() == null || joinPoint.getArgs().length == 0) {
                        bitacora.setDetalle(joinPoint.getSignature().toLongString());
                    } else {
                        bitacora.setDetalle(generaDetalle(joinPoint, descripcion != null));
                    }                    
                    bitacora.setFechaOperacion(new Date());
                    bitacoraService.guardar(bitacora);
                } 
            } catch (Exception ex) {
            	logger.error("Error al insertar en la bitacora del sistema");
            }
        }
    }
    
    
     private String generaDetalle(JoinPoint joinPoint, boolean usaNombreCorto) {
        StringBuilder stbd = new StringBuilder();
        List<String> arrayFields;
        Object obj;
        if (usaNombreCorto) {
            stbd.append(joinPoint.getSignature().toShortString());
            
        } else {
            stbd.append(joinPoint.getSignature().toLongString());
        }

        stbd.append("\n Parámetros enviados:\n");

        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            obj = joinPoint.getArgs()[i];
            if(obj!=null){
                stbd.append(PARAM_NAME).append(i + 1).append(": ");

                if (escribirDirectamente(obj)) {
                    stbd.append(obj);
                } else if (isArray(obj)) {
                    stbd.append("array o lista (no se imprime)");
                } else {
                    arrayFields = findArrayFields(obj.getClass());

                    if (arrayFields.isEmpty()) {
                        stbd.append(ReflectionToStringBuilder.toString(obj));
                    } else {
                        stbd.append(ReflectionToStringBuilder.toStringExclude(obj, arrayFields));
                    }
                }
                stbd.append(NEW_LINE);
            }
        }

        if (stbd.length() > MAX_LENGTH) {
        	logger.debug("El contenido del detalle es mayor de lo esperado, se truncará¡");
        	logger.debug("Contenido original del detalle: " + stbd.toString());
            stbd.delete(MAX_LENGTH - 5, stbd.length()).append("...");
        }        
        return stbd.toString();
    }
     
     
      private boolean escribirDirectamente(Object obj) {
        Class c = obj.getClass();

        return c.isEnum()
                || c.isPrimitive()
                || obj instanceof String
                || obj instanceof Boolean
                || obj instanceof Byte
                || obj instanceof Short
                || obj instanceof Character
                || obj instanceof Integer
                || obj instanceof Long
                || obj instanceof Float
                || obj instanceof Date
                || obj instanceof BigDecimal
                || obj instanceof Double;
    }
      
       private boolean isArray(Object obj) {
        return obj instanceof boolean[]
                || obj instanceof byte[]
                || obj instanceof short[]
                || obj instanceof char[]
                || obj instanceof int[]
                || obj instanceof long[]
                || obj instanceof float[]
                || obj instanceof double[]
                || obj instanceof Object[]
                || obj instanceof Collection
                || obj instanceof Map;
    }

 private List<String> findArrayFields(Class c) {
        if (c.isPrimitive()) {
            return new ArrayList<String>(0);
        } else {
            List<String> res = new ArrayList<String>();
            findArrayFields(c, res);
            return res;
        }
    }
 
   private void findArrayFields(Class c, List<String> list) {
        if (!c.equals(Object.class)) {
            for (Field field : c.getDeclaredFields()) {
                if (field.getType().isArray()) {
                    list.add(field.getName());
                }
            }
            findArrayFields(c.getSuperclass(), list);
        }
    }   
    
}
