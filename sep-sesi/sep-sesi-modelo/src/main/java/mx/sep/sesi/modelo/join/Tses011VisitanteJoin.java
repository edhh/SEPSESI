/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.modelo.join;

import java.util.Date;
import mx.sep.sesi.modelo.Tses011Visitantes;

/**
 *
 * @author heriberto.perez
 */
public class Tses011VisitanteJoin extends Tses011Visitantes {

    private String denominacion;
    private String unidadResponsable;
    private String tipoPersona;
    private Date fecha;
    private int entradaSalida;
    private String operacion;
    private String fechaDate;
    private String numSerie;

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

    public String getFechaDate() {
        return fechaDate;
    }

    public void setFechaDate(String fechaDate) {
        this.fechaDate = fechaDate;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    
    
}
