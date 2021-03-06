/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.datos.vo;

import java.util.List;

/**
 *
 * @author heriberto.perez
 */
public class PersonaVO {
    
    private Integer idPersona;
    
    private String curp;
    
    private String nombre;
    
    private String primerApellido;
    
    private String segundoApellido;
    
    private String inmueble;
    
    private Integer idInmueble;
    
    private Integer idUR;
    
    private Integer cuadrante;
    
    private Integer tipoSangre;
    
    private Long numEtiqueta;
    
    private String emergencia;
    
    private String puesto;
    
    private String idAlergia;
    
    private Integer idTipoPersona;
    
    private String enfermedad;
    
    private byte[] imagen;
    
    private Short estatus;
    
    private String personaVisita;
    
    private String correo;
    
    private List<EquiposVisitanteVO> equiposVisitante;
    
    private Integer idArea;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getInmueble() {
        return inmueble;
    }

    public void setInmueble(String inmueble) {
        this.inmueble = inmueble;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Integer getIdUR() {
        return idUR;
    }

    public void setIdUR(Integer idUR) {
        this.idUR = idUR;
    }

    public Integer getCuadrante() {
        return cuadrante;
    }

    public void setCuadrante(Integer cuadrante) {
        this.cuadrante = cuadrante;
    }

    public Integer getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(Integer tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Long getNumEtiqueta() {
        return numEtiqueta;
    }

    public void setNumEtiqueta(Long numEtiqueta) {
        this.numEtiqueta = numEtiqueta;
    }

    public String getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(String emergencia) {
        this.emergencia = emergencia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(String idAlergia) {
        this.idAlergia = idAlergia;
    }

    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Short getEstatus() {
        return estatus;
    }

    public void setEstatus(Short estatus) {
        this.estatus = estatus;
    }

    public String getPersonaVisita() {
        return personaVisita;
    }

    public void setPersonaVisita(String personaVisita) {
        this.personaVisita = personaVisita;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<EquiposVisitanteVO> getEquiposVisitante() {
        return equiposVisitante;
    }

    public void setEquiposVisitante(List<EquiposVisitanteVO> equiposVisitante) {
        this.equiposVisitante = equiposVisitante;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }
    
    
}
