/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios;

import java.util.List;
import mx.sep.sesi.datos.vo.PersonaVO;
import mx.sep.sesi.datos.vo.VisitanteVO;
import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.modelo.Tses011Visitantes;
import mx.sep.sesi.modelo.Tses018Etiquetas;
import mx.sep.sesi.modelo.join.TSES004PersonasJoin;
import mx.sep.sesi.modelo.join.Tses011VisitanteJoin;

/**
 *
 * @author heriberto.perez
 */
public interface PersonaService {
    
    String insertaEmpleado(PersonaVO persona);
    List<TSES004PersonasJoin> obtenerAllPersonaRol(Integer idTipoPersona,Integer idUr,String curp,String nombre,String primerApellido,String segundoApellido);
    List<Tses011VisitanteJoin> obtenerVisitantes(String curp,String nombre,Integer idUr);
    String insertaProveedor(PersonaVO persona);
    String insertaVisitante(PersonaVO persona);
    String insertaEquipos(PersonaVO persona);
    String verificaCurp(String curp);
    String verificaCurpVisitante(String curp);
    String verificaFirmante(Integer ur);
    Tses004Personas obtenerPersona (Integer idPersona);
    VisitanteVO obtenerVisitante (Long idVisitante);
    List<Tses004Personas> obtenerListaPersonas (List<Integer> criterios);
    List <Tses018Etiquetas> obtenerListaVisitantes (List<Long> criterios, Integer idInmueble);
    String obtieneURLQr ();
    String obtieneValorSecreto ();
            
}
