/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.dao.join;

/**
 *
 * @author HeribertoGonzálezPér
 */

import java.sql.SQLException;
import mx.sep.sesi.datos.vo.DatosEquipoVO;
import mx.sep.sesi.modelo.Tses027OperacionEquipos;
import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.UncategorizedSQLException;

public interface DatosEquipoJoinMapper {
    
    public DatosEquipoVO cunsultaDatosEquipo(DatosEquipoVO datosEquipoVO) throws UncategorizedSQLException, SQLException, Exception;
    
    public Tses027OperacionEquipos consultaUltimaOperacion(@Param("idEquipo") Integer idEquipo, @Param("idInmueble") Integer idInmueble) throws UncategorizedSQLException, SQLException, Exception;
    
}
