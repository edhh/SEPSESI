/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.datos.vo;

import java.util.Date;
import java.util.List;
import mx.sep.sesi.modelo.Tses025EquiposVisitante;

/**
 *
 * @author heriberto.perez
 */
public class VisitanteVO {
    
    private Long idVisitante;

    private Long idEtiqueta;

    private Integer idTipoPersona;

    private Integer idInmueble;

    private Integer idCuadranteArea;

    private Integer idUr;

    private String curp;

    private String apellido1;

    private String apellido2;

    private String nombre;

    private String personaVisita;

    private Date fechaActualizacion;

    private byte[] fotografia;
        
    private List <Tses025EquiposVisitante> equiposVisitante;

    public Long getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Long idVisitante) {
        this.idVisitante = idVisitante;
    }

    public Long getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(Long idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Integer getIdCuadranteArea() {
        return idCuadranteArea;
    }

    public void setIdCuadranteArea(Integer idCuadranteArea) {
        this.idCuadranteArea = idCuadranteArea;
    }

    public Integer getIdUr() {
        return idUr;
    }

    public void setIdUr(Integer idUr) {
        this.idUr = idUr;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPersonaVisita() {
        return personaVisita;
    }

    public void setPersonaVisita(String personaVisita) {
        this.personaVisita = personaVisita;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
    }

    public List<Tses025EquiposVisitante> getEquiposVisitante() {
        return equiposVisitante;
    }

    public void setEquiposVisitante(List<Tses025EquiposVisitante> equiposVisitante) {
        this.equiposVisitante = equiposVisitante;
    }
    
    
    
}
