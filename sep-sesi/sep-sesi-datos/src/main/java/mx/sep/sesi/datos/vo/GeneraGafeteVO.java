/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.sep.sesi.datos.vo;

import java.math.BigDecimal;

/**
 *
 * @author angel.adame
 */
public class GeneraGafeteVO {
    
    private Integer idPersona;
    
    private Integer idUr;
    
    private String apellido1;

    private String apellido2;

    private String nombre;
    
    private String puesto;
    
    private byte[] fotografia;
    
    private String unidadResponsable;
    
     private Integer idFirmante;

    private String nombreAutoriza;

    private String puestoAutoriza;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdUr() {
        return idUr;
    }

    public void setIdUr(Integer idUr) {
        this.idUr = idUr;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
    }

    public String getUnidadResponsable() {
        return unidadResponsable;
    }

    public void setUnidadResponsable(String unidadResponsable) {
        this.unidadResponsable = unidadResponsable;
    }

    public Integer getIdFirmante() {
        return idFirmante;
    }

    public void setIdFirmante(Integer idFirmante) {
        this.idFirmante = idFirmante;
    }

    public String getNombreAutoriza() {
        return nombreAutoriza;
    }

    public void setNombreAutoriza(String nombreAutoriza) {
        this.nombreAutoriza = nombreAutoriza;
    }

    public String getPuestoAutoriza() {
        return puestoAutoriza;
    }

    public void setPuestoAutoriza(String puestoAutoriza) {
        this.puestoAutoriza = puestoAutoriza;
    }
    

  
    
    
}
