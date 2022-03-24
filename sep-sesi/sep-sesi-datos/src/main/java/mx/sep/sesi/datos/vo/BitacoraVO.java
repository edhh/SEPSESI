/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.datos.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author angel.adame
 */
public class BitacoraVO {
    
    
    private Long idBitacora;

    private Integer idUsuario;
    
    private Integer idRol;

    private String descRol;
    
    private String nombreUsu;
    
    private String nombreCompleto;

    private String proceso;
    
    private Integer idTradServicio;

    private String descripcion;

    private String detalle;

    private Date fechaOperacion;
    
    private Date fechaOpIni;
    
    private Date fechaOpFin;

    public Long getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Long idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

  
    

    public String getDescRol() {
        return descRol;
    }

    public void setDescRol(String descRol) {
        this.descRol = descRol;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public Integer getIdTradServicio() {
        return idTradServicio;
    }

    public void setIdTradServicio(Integer idTradServicio) {
        this.idTradServicio = idTradServicio;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Date getFechaOpIni() {
        return fechaOpIni;
    }

    public void setFechaOpIni(Date fechaOpIni) {
        this.fechaOpIni = fechaOpIni;
    }

    public Date getFechaOpFin() {
        return fechaOpFin;
    }

    public void setFechaOpFin(Date fechaOpFin) {
        this.fechaOpFin = fechaOpFin;
    }

    
    
    
}