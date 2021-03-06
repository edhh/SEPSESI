/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import mx.sep.sesi.dao.Tses002RolesMapper;
import mx.sep.sesi.modelo.Tses009Inmuebles;
import mx.sep.sesi.dao.Tses009InmueblesMapper;
import mx.sep.sesi.dao.Tses006UnidadResponsableMapper;
import mx.sep.sesi.dao.Tses007TipoSangreMapper;
import mx.sep.sesi.dao.Tses010CuadranteAreaMapper;
import mx.sep.sesi.dao.Tses028AreaMapper;
import mx.sep.sesi.modelo.Tses006UnidadResponsable;
import mx.sep.sesi.modelo.Tses006UnidadResponsableExample;
import mx.sep.sesi.modelo.Tses009InmueblesExample;
import mx.sep.sesi.modelo.Tses007TipoSangre;
import mx.sep.sesi.modelo.Tses007TipoSangreExample;
import mx.sep.sesi.modelo.Tses010CuadranteArea;
import mx.sep.sesi.modelo.Tses010CuadranteAreaExample;
import mx.sep.sesi.servicios.CatalogosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.sep.sesi.dao.Tses005TipoPersonaMapper;
import mx.sep.sesi.dao.Tses013AccesosMapper;
import mx.sep.sesi.dao.Tses014ColoniaMapper;
import mx.sep.sesi.dao.Tses015AlcaldiaMunMapper;
import mx.sep.sesi.dao.Tses016EntidadMapper;
import mx.sep.sesi.dao.Tses028AreaMapper;
import mx.sep.sesi.dao.join.CuadranteJoinMapper;
import mx.sep.sesi.datos.vo.CuadranteVO;
import mx.sep.sesi.modelo.Tses002Roles;
import mx.sep.sesi.modelo.Tses002RolesExample;
import mx.sep.sesi.modelo.Tses005TipoPersona;
import mx.sep.sesi.modelo.Tses010CuadranteArea;
import mx.sep.sesi.modelo.Tses005TipoPersonaExample;
import mx.sep.sesi.modelo.Tses013Accesos;
import mx.sep.sesi.modelo.Tses013AccesosExample;
import mx.sep.sesi.modelo.Tses014Colonia;
import mx.sep.sesi.modelo.Tses014ColoniaExample;
import mx.sep.sesi.modelo.Tses015AlcaldiaMun;
import mx.sep.sesi.modelo.Tses015AlcaldiaMunExample;
import mx.sep.sesi.modelo.Tses016Entidad;
import mx.sep.sesi.modelo.Tses016EntidadExample;
import mx.sep.sesi.modelo.Tses028Area;
import mx.sep.sesi.modelo.Tses028AreaExample;

/**
 *
 * @author heriberto.perez
 */
@Service
public class CatalogosServicioImpl implements CatalogosServicio {

    @Autowired
    private Tses009InmueblesMapper tses009InmueblesMapper;

    @Autowired
    private Tses006UnidadResponsableMapper tses006UnidadResponsableMapper;

    @Autowired
    private Tses007TipoSangreMapper tses007TipoSangreMapper;

    @Autowired
    private Tses010CuadranteAreaMapper tses010CuadranteAreaMapper;

    @Autowired
    private Tses005TipoPersonaMapper tses005TipoPersonaMapperr;

    @Autowired
    private Tses002RolesMapper tses002RolesMapper;

    @Autowired
    private Tses013AccesosMapper tses013AccesosMapper;

    @Autowired
    private CuadranteJoinMapper cuadranteJoinMapper;
    
    @Autowired
    Tses016EntidadMapper tses016EntidadMapper;
    
    @Autowired
    Tses015AlcaldiaMunMapper tses015AlcaldiaMunMapper;
    
     @Autowired
     Tses014ColoniaMapper tses014ColoniaMapper;
     
     @Autowired
     Tses028AreaMapper tses028AreaMapper;
    
    
    public List<Tses009Inmuebles> obtenerInmueble() {
        Short numero = 1;
        List<Tses009Inmuebles> tses009Inmuebles = new ArrayList<Tses009Inmuebles>();
        Tses009InmueblesExample tses009InmueblesExample = new Tses009InmueblesExample();
        tses009InmueblesExample.createCriteria().andEstatusEqualTo(numero);
        tses009Inmuebles = tses009InmueblesMapper.selectByExample(tses009InmueblesExample);
        return tses009Inmuebles;
    }

    public List<Tses006UnidadResponsable> obtenerUR() {
        List<Tses006UnidadResponsable> tses006UnidadResponsable = new ArrayList<Tses006UnidadResponsable>();
        Tses006UnidadResponsableExample tses006UnidadResponsableExample = new Tses006UnidadResponsableExample();
        tses006UnidadResponsableExample.setOrderByClause("unidad_responsable");
        tses006UnidadResponsable = tses006UnidadResponsableMapper.selectByExample(tses006UnidadResponsableExample);
        return tses006UnidadResponsable;
    }

    public List<Tses007TipoSangre> obtenertipoSangre() {
        List<Tses007TipoSangre> tses007TipoSangre = new ArrayList<Tses007TipoSangre>();
        Tses007TipoSangreExample tses007TipoSangreExample = new Tses007TipoSangreExample();
        tses007TipoSangre = tses007TipoSangreMapper.selectByExample(tses007TipoSangreExample);
        return tses007TipoSangre;
    }

    public List<Tses010CuadranteArea> obtenerCuadrante(Integer idInmueble) {
        List<Tses010CuadranteArea> tses010CuadranteArea = new ArrayList<Tses010CuadranteArea>();
        Tses010CuadranteAreaExample tses010CuadranteAreaExample = new Tses010CuadranteAreaExample();
        tses010CuadranteAreaExample.createCriteria().andIdInmuebleEqualTo(idInmueble);
        tses010CuadranteArea = tses010CuadranteAreaMapper.selectByExample(tses010CuadranteAreaExample);
        return tses010CuadranteArea;
    }
    
    public List<Tses028Area> obtenerArea(Integer idUr) {
        List<Tses028Area> tses028Area = new ArrayList<Tses028Area>();
        Tses028AreaExample tses028AreaExample = new Tses028AreaExample();
        tses028AreaExample.createCriteria().andIdUrEqualTo(idUr);
        tses028Area = tses028AreaMapper.selectByExample(tses028AreaExample);
        return tses028Area;
    }

    public List<Tses010CuadranteArea> obtenerCuadrante10(Integer idCuadrante) {
        List<Tses010CuadranteArea> tses010CuadranteArea = new ArrayList<Tses010CuadranteArea>();
        Tses010CuadranteAreaExample tses010CuadranteAreaExample = new Tses010CuadranteAreaExample();
        tses010CuadranteAreaExample.createCriteria().andIdCuadranteAreaEqualTo(idCuadrante);
        tses010CuadranteArea = tses010CuadranteAreaMapper.selectByExample(tses010CuadranteAreaExample);
        return tses010CuadranteArea;
    }

    public List<Tses010CuadranteArea> obtenerCuadranteTodos() {
        List<Tses010CuadranteArea> tses010CuadranteArea = new ArrayList<Tses010CuadranteArea>();
        Tses010CuadranteAreaExample tses010CuadranteAreaExample = new Tses010CuadranteAreaExample();
        tses010CuadranteArea = tses010CuadranteAreaMapper.selectByExample(tses010CuadranteAreaExample);
        return tses010CuadranteArea;
    }

    public List<CuadranteVO> obtenerCuadrantes(Integer idInmueble) {
        List<CuadranteVO> tses010CuadranteArea = new ArrayList<CuadranteVO>();
        tses010CuadranteArea = cuadranteJoinMapper.obtenerCuadrante(idInmueble);
        return tses010CuadranteArea;
    }

    public List<Tses005TipoPersona> obtenerTipoPersona() {
        List<Tses005TipoPersona> tses005TipoPersona = new ArrayList<Tses005TipoPersona>();
        Tses005TipoPersonaExample tses005TipoPersonaExample = new Tses005TipoPersonaExample();
        tses005TipoPersona = tses005TipoPersonaMapperr.selectByExample(tses005TipoPersonaExample);
        return tses005TipoPersona;
    }

    public List<Tses002Roles> obtenerRol() {
        List<Tses002Roles> tses002Roles = new ArrayList<Tses002Roles>();
        Tses002RolesExample tses002RolesExample = new Tses002RolesExample();
        tses002Roles = tses002RolesMapper.selectByExample(tses002RolesExample);
        return tses002Roles;
    }

    public List<Tses013Accesos> obtenerAcceso(Integer idInmueble) {
        List<Tses013Accesos> tses013Accesos = new ArrayList<Tses013Accesos>();
        Tses013AccesosExample tses013AccesosExample = new Tses013AccesosExample();
        tses013AccesosExample.createCriteria().andIdInmuebleEqualTo(idInmueble);
        tses013Accesos = tses013AccesosMapper.selectByExample(tses013AccesosExample);
        return tses013Accesos;
    }

    public String insertaCuadrante(Integer idCuadranteCat, Integer idInmueble, String cuadrante) {

        Tses010CuadranteArea tses010CuadranteArea = new Tses010CuadranteArea();
        tses010CuadranteArea.setIdInmueble(idInmueble);
        tses010CuadranteArea.setCuadranteArea(cuadrante);
        try {
            if (idCuadranteCat != null) {
                System.out.println("Entramos en un update");
                tses010CuadranteArea.setIdCuadranteArea(idCuadranteCat);
                tses010CuadranteAreaMapper.updateByPrimaryKeySelective(tses010CuadranteArea);
                return "Se han registrado los datos correctamente";
            } else {
                Tses010CuadranteAreaExample tses010CuadranteAreaExample = new Tses010CuadranteAreaExample();
                tses010CuadranteAreaExample.createCriteria().andIdInmuebleEqualTo(idInmueble).andCuadranteAreaEqualTo(cuadrante);
                List<Tses010CuadranteArea> registrado = tses010CuadranteAreaMapper.selectByExample(tses010CuadranteAreaExample);
                if (registrado.isEmpty()) {
                    tses010CuadranteAreaMapper.insert(tses010CuadranteArea);
                    return "Se han registrado los datos correctamente";
                } else {
                    return "Ya se encuentra registrado el cuadrante.";
                }

            }
        } catch (Exception exc) {
            System.out.println("Error " + exc);
            return ("Error al insertar");
        }
    }
    
    
       public String eliminaCuadranteCat(Tses010CuadranteArea tses010CuadranteArea){
        try {
            
            Integer idCuadrante = tses010CuadranteArea.getIdCuadranteArea();
            System.out.println("idCuadrante" + idCuadrante);
            tses010CuadranteAreaMapper.deleteByPrimaryKey(idCuadrante);            
            return "El registro se ha eliminado correctamente";
        }
        catch (Exception exc){
            return "Ocurri?? un error al eliminar el registro";
        }
    }
    
    
    
    public List<Tses016Entidad> obtenerEntidad(){
          List<Tses016Entidad> tses016Entidad = new ArrayList<Tses016Entidad>();
        Tses016EntidadExample tses016EntidadExample = new Tses016EntidadExample();
        tses016Entidad = tses016EntidadMapper.selectByExample(tses016EntidadExample);           
        return tses016Entidad;
    }
    
    
     public List<Tses015AlcaldiaMun> obtenerAlcaldiaMun(Integer idEntidad) {
        List<Tses015AlcaldiaMun> tses015AlcaldiaMun = new ArrayList<Tses015AlcaldiaMun>();
        Tses015AlcaldiaMunExample tses015AlcaldiaMunExample = new Tses015AlcaldiaMunExample();
        tses015AlcaldiaMunExample.createCriteria().andIdEntidadEqualTo(idEntidad);
        tses015AlcaldiaMun = tses015AlcaldiaMunMapper.selectByExample(tses015AlcaldiaMunExample);
        return tses015AlcaldiaMun;
    }
     
     public List<Tses014Colonia> obtenerColonia(Integer idEntidad, Integer idAlcaldiaMun){
         System.out.println("entrando a Servicio");
         System.out.println("idEntidad-----" + idEntidad);
         System.out.println("idAlcaldiaMun-----" + idAlcaldiaMun);
         List<Tses014Colonia> tses014Colonia = new ArrayList<Tses014Colonia>();
         Tses014ColoniaExample tses014ColoniaExample  = new Tses014ColoniaExample();
         tses014ColoniaExample.createCriteria().andIdEntidadEqualTo(idEntidad).andIdAlcaldiaMunEqualTo(idAlcaldiaMun);
         tses014Colonia = tses014ColoniaMapper.selectByExample(tses014ColoniaExample);
         return tses014Colonia;
     }

}
