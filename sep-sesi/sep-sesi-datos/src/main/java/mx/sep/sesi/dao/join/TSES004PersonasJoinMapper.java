package mx.sep.sesi.dao.join;

import java.util.Date;
import java.util.List;
import mx.sep.sesi.datos.vo.EquiposVO;


import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.modelo.join.TSES004PersonasJoin;
import mx.sep.sesi.modelo.join.Tses011VisitanteJoin;
import org.apache.ibatis.annotations.Param;



public interface TSES004PersonasJoinMapper {
    	List<TSES004PersonasJoin> selecPersonas(@Param("idTipoPersona") Integer idTipoPersona,@Param("idUr") Integer idUr,@Param("curp") String curp,@Param("nombre") String nombre,@Param("primerApellido") String primerApellido,@Param("segundoApellido") String segundoApellido);
        List<Tses011VisitanteJoin> selectVisitantes(@Param("curp") String curp,@Param("nombre") String nombre, @Param("idUr") Integer idUr);
        List<Tses011VisitanteJoin> consultaVisitantes(@Param("idTipoPersona") Integer idTipoPersona,@Param("idUr") Integer idUr,@Param("curp") String curp,@Param("idInmueble") Integer idInmueble);
        List<TSES004PersonasJoin> consultaPersonas(@Param("idTipoPersona") Integer idTipoPersona,@Param("idUr") Integer idUr,@Param("curp") String curp,@Param("idInmueble") Integer idInmueble);
        List<TSES004PersonasJoin> consultaPersonasPC(@Param("idTipoPersona") Integer idTipoPersona,@Param("idUr") Integer idUr,@Param("curp") String curp,@Param("idInmueble") Integer idInmueble);
        List<TSES004PersonasJoin> consultaOperacion(@Param("idOperacion") Integer idOperacion,@Param("idTipoPersona") Integer idTipoPersona,@Param("idUr") Integer idUr,@Param("idInmueble") Integer idInmueble, @Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2);
        List<Tses011VisitanteJoin> consultaOperacionVisitante(@Param("idOperacion") Integer idOperacion,@Param("idTipoPersona") Integer idTipoPersona,@Param("idUr") Integer idUr,@Param("idInmueble") Integer idInmueble, @Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2);
        List<TSES004PersonasJoin> consultaEquipos(@Param("idOperacion") Integer idOperacion,@Param("idTipoPersona") Integer idTipoPersona,@Param("idUr") Integer idUr,@Param("idInmueble") Integer idInmueble, @Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2, @Param("curp") String curp, @Param("serie") String serie);
        List<Tses011VisitanteJoin> consultaEquiposVisitante(@Param("idOperacion") Integer idOperacion,@Param("idTipoPersona") Integer idTipoPersona,@Param("idUr") Integer idUr,@Param("idInmueble") Integer idInmueble, @Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2, @Param("curp") String curp, @Param("serie") String serie);
        List<TSES004PersonasJoin> obtenerListaPersonas(@Param ("criterios") String criterios);
        TSES004PersonasJoin consultaPersonasQR(@Param("idPersona") Integer idPersona);
        TSES004PersonasJoin consultaPersonasQREquipos(@Param("curp") String curp);
        List<EquiposVO> obtenerPersonasEquipoQR(@Param("curp") String curp, @Param("numSerie") String numSerie);
}
