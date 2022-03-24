/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.modelo.join;

import java.util.Date;
import mx.sep.sesi.modelo.Tses004Personas;

/**
 *
 * @author oscar.ruiz
 */
public class TSES004PersonasJoin extends Tses004Personas{
    private Tses004Personas persona;
    private String denominacion;
    private String unidadResponsable;
    private String tipoPersona;
    private Date fecha;
    private int entradaSalida;
    private String operacion;
    private String estatusDes;
    private String fechaDate;
    private String alergias;
    private String telEmergencia;
    private String enfermedad;
    private String tipoSangre;
    private byte[] fotografia;
    private String numSerie;
    private String curp;
    private String personaRegistro;
    private String acceso;
    

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getUnidadResponsable() {
        return unidadResponsable;
    }

    public void setUnidadResponsable(String unidadResponsable) {
        this.unidadResponsable = unidadResponsable;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEntradaSalida() {
        return entradaSalida;
    }

    public void setEntradaSalida(int entradaSalida) {
        this.entradaSalida = entradaSalida;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getEstatusDes() {
        return estatusDes;
    }

    public void setEstatusDes(String estatusDes) {
        this.estatusDes = estatusDes;
    }

    public String getFechaDate() {
        return fechaDate;
    }

    public void setFechaDate(String fechaDate) {
        this.fechaDate = fechaDate;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getTelEmergencia() {
        return telEmergencia;
    }

    public void setTelEmergencia(String telEmergencia) {
        this.telEmergencia = telEmergencia;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getPersonaRegistro() {
        return personaRegistro;
    }

    public void setPersonaRegistro(String personaRegistro) {
        this.personaRegistro = personaRegistro;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }
    
    
    
}
