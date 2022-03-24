/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios;

import java.math.BigDecimal;
import java.util.List;
import mx.sep.sesi.datos.vo.CuadranteVO;
import mx.sep.sesi.modelo.Tses002Roles;
import mx.sep.sesi.modelo.Tses006UnidadResponsable;
import mx.sep.sesi.modelo.Tses007TipoSangre;
import mx.sep.sesi.modelo.Tses009Inmuebles;
import mx.sep.sesi.modelo.Tses010CuadranteArea;
import mx.sep.sesi.modelo.Tses005TipoPersona;
import mx.sep.sesi.modelo.Tses013Accesos;
import mx.sep.sesi.modelo.Tses014Colonia;
import mx.sep.sesi.modelo.Tses015AlcaldiaMun;
import mx.sep.sesi.modelo.Tses016Entidad;
import mx.sep.sesi.modelo.Tses028Area;

/**
 *
 * @author heriberto.perez
 */
public interface CatalogosServicio {
    
    List<Tses009Inmuebles> obtenerInmueble();
    
    List<Tses006UnidadResponsable> obtenerUR();
    
    List<Tses007TipoSangre> obtenertipoSangre();
    
    List<Tses010CuadranteArea> obtenerCuadrante(Integer idInmueble);
    
    List<Tses028Area> obtenerArea(Integer idUr);
    
    List<CuadranteVO> obtenerCuadrantes(Integer idInmueble);
    
    List<Tses010CuadranteArea> obtenerCuadranteTodos();
    
    List<Tses010CuadranteArea> obtenerCuadrante10(Integer idCuadrante);
    
    List<Tses005TipoPersona> obtenerTipoPersona();   
    
    List<Tses002Roles> obtenerRol();
    
    List<Tses013Accesos> obtenerAcceso(Integer idInmueble);
    
    String insertaCuadrante(Integer idCuadranteCat,Integer idInmueble, String cuadrante);
    
    public String eliminaCuadranteCat(Tses010CuadranteArea tses010CuadranteArea);
    
    List<Tses016Entidad> obtenerEntidad();
    
    List<Tses015AlcaldiaMun> obtenerAlcaldiaMun(Integer idEntidad);
    
    List<Tses014Colonia> obtenerColonia(Integer idEntidad, Integer idAlcaldiaMun);
    
}
