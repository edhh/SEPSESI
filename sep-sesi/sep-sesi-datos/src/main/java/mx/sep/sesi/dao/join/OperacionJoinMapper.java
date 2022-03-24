/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.dao.join;

import java.math.BigDecimal;
import java.util.Date;
import mx.sep.sesi.modelo.Tses012Operacion;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author sonia.ortiz
 */
public interface OperacionJoinMapper {
    
    Tses012Operacion consultarAcceso (@Param("idPersona") BigDecimal idPersona, @Param("idInmueble") BigDecimal idInmueble, @Param("fechaOperacion") Date fechaOperacion);
    
}
