/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.modelo.Tses004PersonasExample;
import mx.sep.sesi.modelo.Tses024Equipos;
import mx.sep.sesi.modelo.Tses024EquiposExample;
import mx.sep.sesi.modelo.Tses026Partidas;
import mx.sep.sesi.modelo.Tses026PartidasExample;
import mx.sep.sesi.dao.join.TSES004PersonasJoinMapper;
import mx.sep.sesi.dao.Tses024EquiposMapper;
import mx.sep.sesi.dao.Tses026PartidasMapper;
import mx.sep.sesi.dao.Tses004PersonasMapper;
import mx.sep.sesi.modelo.join.TSES004PersonasJoin;
import mx.sep.sesi.modelo.join.Tses011VisitanteJoin;
import mx.sep.sesi.servicios.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.sep.sesi.datos.vo.EquiposVO;

/**
 *
 * @author heriberto.perez
 */
@Service
public class ConsultaServiceImpl implements ConsultaService{
    
    @Autowired
    TSES004PersonasJoinMapper daoPersonasJoin;
    
    @Autowired
    Tses024EquiposMapper tses024EquiposMapper;
    
    @Autowired
    Tses026PartidasMapper tses026PartidasMapper;
    
    @Autowired
    Tses004PersonasMapper tses004PersonasMapper;
    
    public List<TSES004PersonasJoin> obtenerPersonas(Integer idTipoPersona,Integer idUr,String curp,Integer idInmueble) {

        List<TSES004PersonasJoin> listPersonas= daoPersonasJoin.consultaPersonas(idTipoPersona, idUr, curp, idInmueble);
        return listPersonas;

    }
    
    public List<TSES004PersonasJoin> obtenerPersonasPC(Integer idTipoPersona,Integer idUr,String curp,Integer idInmueble) {

        List<TSES004PersonasJoin> listPersonas= daoPersonasJoin.consultaPersonasPC(idTipoPersona, idUr, curp, idInmueble);
        return listPersonas;

    }
    
    public List<Tses011VisitanteJoin> obtenerVisitantes(Integer idTipoPersona,Integer idUr,String curp,Integer idInmueble) {

        List<Tses011VisitanteJoin> listAllVisitantes = daoPersonasJoin.consultaVisitantes(idTipoPersona, idUr, curp, idInmueble);
        return listAllVisitantes;

    }
    
    public List<TSES004PersonasJoin> consultaOperacion(Integer idOperacion,Integer idTipoPersona,Integer idUr,Integer idInmueble, Date fecha1,  Date fecha2) {
        List<TSES004PersonasJoin> listPersonas= daoPersonasJoin.consultaOperacion(idOperacion,idTipoPersona, idUr, idInmueble, fecha1, fecha2);
        return listPersonas;

    }
    
    public List<Tses011VisitanteJoin> consultaOperacionVisitante(Integer idOperacion,Integer idTipoPersona,Integer idUr,Integer idInmueble, Date fecha1,  Date fecha2) {

        List<Tses011VisitanteJoin> listPersonas= daoPersonasJoin.consultaOperacionVisitante(idOperacion,idTipoPersona, idUr, idInmueble, fecha1, fecha2);
        return listPersonas;

    }
    
    public List<TSES004PersonasJoin> consultaEquipos(Integer idOperacion,Integer idTipoPersona,Integer idUr,Integer idInmueble, Date fecha1,  Date fecha2, String curp, String serie) {
        List<TSES004PersonasJoin> listPersonas= daoPersonasJoin.consultaEquipos(idOperacion,idTipoPersona, idUr, idInmueble, fecha1, fecha2, curp, serie);
        return listPersonas;

    }
    
    public List<Tses011VisitanteJoin> consultaEquiposVisitante(Integer idOperacion,Integer idTipoPersona,Integer idUr,Integer idInmueble, Date fecha1,  Date fecha2, String curp, String serie) {
        List<Tses011VisitanteJoin> listPersonas= daoPersonasJoin.consultaEquiposVisitante(idOperacion,idTipoPersona, idUr, idInmueble, fecha1, fecha2, curp, serie);
        return listPersonas;

    }
    
    
    /**
     * @param idPersona idPersona para obtener despues de leer el código QR
     */
    public TSES004PersonasJoin obtenerPersonasQR(Integer idPersona) {

        TSES004PersonasJoin Personas= daoPersonasJoin.consultaPersonasQR(idPersona);
        return Personas;

    }
    
    /**
     * @param curp para obtener despues de leer el código QR
     */
    public TSES004PersonasJoin obtenerPersonasQREquipo(String curp) {

        TSES004PersonasJoin Personas= daoPersonasJoin.consultaPersonasQREquipos(curp);
        return Personas;

    }
    
    /**
     * @param curp para obtener los datos del equipo despues de leer el código QR
     */
    public List<EquiposVO> obtenerPersonasEquipo(String curp, String numSerie) {
        
        /*List <Tses004Personas> tses004Personas = new ArrayList<Tses004Personas>();
        Tses004PersonasExample tses004PersonasExample = new Tses004PersonasExample();
        tses004PersonasExample.createCriteria().andCurpEqualTo(curp);
        tses004Personas = tses004PersonasMapper.selectByExample(tses004PersonasExample);
        
        List <Tses024Equipos> equipos;
        Tses024EquiposExample tses024EquiposExample = new Tses024EquiposExample();
        tses024EquiposExample.createCriteria().andIdPersonaEqualTo(new Long (tses004Personas.get(0).getIdPersona()));
        equipos = tses024EquiposMapper.selectByExample(tses024EquiposExample);
        List<EquiposVO> equiposVO = new ArrayList<EquiposVO>();
        EquiposVO equiposs = new EquiposVO();
        Long idPartida = null;
        for (int i = 0; i < equipos.size(); i++){
            equiposs.setId_equipo(equipos.get(i).getIdEquipo());
            equiposs.setNumSerie(equipos.get(i).getNumSerie());
            idPartida=equipos.get(i).getIdPartida();           
        }
        List <Tses026Partidas> t026partidas;
        Tses026PartidasExample tses026PartidasExample = new Tses026PartidasExample();
        tses026PartidasExample.createCriteria().andIdPartidaEqualTo( (idPartida));
        t026partidas = tses026PartidasMapper.selectByExample(tses026PartidasExample);
        for (int i = 0; i < t026partidas.size(); i++){
            equiposs.setPartida(t026partidas.get(i).getProducto());      
            equiposs.setMarca(t026partidas.get(i).getMarca());
        }
        equiposVO.add(equiposs);*/
        List<EquiposVO> equiposVO = new ArrayList<EquiposVO>();
        System.out.println("Entrando a obtener datos de equipo y persona");
        equiposVO = daoPersonasJoin.obtenerPersonasEquipoQR(curp, numSerie);
        System.out.println("Termino de obtener datos de equipo y persona");
        return equiposVO;

    }
}
