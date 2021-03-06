/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios;

import java.math.BigDecimal;
import java.util.Optional;
import mx.sep.sesi.datos.vo.OperacionVO;
import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.modelo.Tses011Visitantes;

/**
 *
 * @author pedro.flores
 */
public interface ControlAccesoServicio {
    
    public Tses004Personas obtenerInformacion(Integer idPersona);   
    
    public Tses011Visitantes obtenerVisitantePorEtiqueta( Integer idInmueble, Long idEtiqueta );   
    
    public Optional<Long>  registrarEntrada(OperacionVO operacionVO)  throws Exception;
    
    public String  registrarEntradaSalidaEquipos(OperacionVO operacionVO)  throws Exception;
    
    public void registrarSalida(OperacionVO operacionVO);
    
    public String verificaCredenciales(String usuario, String pass)  throws Exception;
    
}
