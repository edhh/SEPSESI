/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios;

import java.util.Date;
import java.util.List;
import mx.sep.sesi.datos.vo.EquiposVO;
import mx.sep.sesi.modelo.Tses024Equipos;
import mx.sep.sesi.modelo.join.TSES004PersonasJoin;
import mx.sep.sesi.modelo.join.Tses011VisitanteJoin;

/**
 *
 * @author heriberto.perez
 */
public interface ConsultaService {
    
   List<TSES004PersonasJoin> obtenerPersonas(Integer idTipoPersona,Integer idUr,String curp,Integer idInmueble);
   List<TSES004PersonasJoin> obtenerPersonasPC(Integer idTipoPersona,Integer idUr,String curp,Integer idInmueble);
   List<Tses011VisitanteJoin> obtenerVisitantes(Integer idTipoPersona,Integer idUr,String curp,Integer idInmueble);
   List<TSES004PersonasJoin> consultaOperacion(Integer idOperacion, Integer idTipoPersona,Integer idUr,Integer idInmueble, Date fecha1, Date fecha2);
   List<Tses011VisitanteJoin> consultaOperacionVisitante(Integer idOperacion, Integer idTipoPersona,Integer idUr,Integer idInmueble, Date fecha1, Date fecha2);
   List<TSES004PersonasJoin> consultaEquipos(Integer idOperacion, Integer idTipoPersona,Integer idUr,Integer idInmueble, Date fecha1, Date fecha2, String curp, String serie);
   List<Tses011VisitanteJoin> consultaEquiposVisitante(Integer idOperacion, Integer idTipoPersona,Integer idUr,Integer idInmueble, Date fecha1, Date fecha2, String curp, String serie);
   TSES004PersonasJoin obtenerPersonasQR(Integer idPersona); 
   TSES004PersonasJoin obtenerPersonasQREquipo(String curp); 
   List<EquiposVO> obtenerPersonasEquipo(String curp, String numSerie); 
}
