
package mx.sep.sesi.datos.vo;

import java.math.BigDecimal;

/**
 *
 * @author angel.adame
 */
public class InmuebleVO {
    
    private Integer idInmueble;

    private Long idColonia;
    
     private String colonia;

    private Integer idAlcaldiaMun;
    
    private String alcaldiaMun;

    private Integer idEntidad;
    
    private String entidad;

    private String claveInmueble;

    private String denominacion;

    private String calle;

    private String numero;

    private String cp;

    private Short numAccesos;

    private Short estatus;

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Long getIdColonia() {
        return idColonia;
    }

    public void setIdColonia(Long idColonia) {
        this.idColonia = idColonia;
    }

   
    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public Integer getIdAlcaldiaMun() {
        return idAlcaldiaMun;
    }

    public void setIdAlcaldiaMun(Integer idAlcaldiaMun) {
        this.idAlcaldiaMun = idAlcaldiaMun;
    }

    public String getAlcaldiaMun() {
        return alcaldiaMun;
    }

    public void setAlcaldiaMun(String alcaldiaMun) {
        this.alcaldiaMun = alcaldiaMun;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getClaveInmueble() {
        return claveInmueble;
    }

    public void setClaveInmueble(String claveInmueble) {
        this.claveInmueble = claveInmueble;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Short getNumAccesos() {
        return numAccesos;
    }

    public void setNumAccesos(Short numAccesos) {
        this.numAccesos = numAccesos;
    }

    public Short getEstatus() {
        return estatus;
    }

    public void setEstatus(Short estatus) {
        this.estatus = estatus;
    }

   
    
    
}
