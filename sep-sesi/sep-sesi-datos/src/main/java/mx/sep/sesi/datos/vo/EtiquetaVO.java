/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.datos.vo;

import java.math.BigDecimal;

/**
 *
 * @author pedro.flores
 */
public class EtiquetaVO {
    
    private Long idEtiqueta;

    private Integer idInmueble;

    private Short estatus;
    
    private Integer etiquetaInicial;
    
    private Integer etiquetaFinal;    
    
    private String validos;
    
    private String invalidos;
    
    private Short tipoOperacion;
    
    private Integer cantidad;

    public Long getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(Long idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }
    
    public Short getEstatus() {
        return estatus;
    }

    public void setEstatus(Short estatus) {
        this.estatus = estatus;
    }

    public Integer getEtiquetaInicial() {
        return etiquetaInicial;
    }

    public void setEtiquetaInicial(Integer etiquetaInicial) {
        this.etiquetaInicial = etiquetaInicial;
    }   

    public Integer getEtiquetaFinal() {
        return etiquetaFinal;
    }

    public void setEtiquetaFinal(Integer etiquetaFinal) {
        this.etiquetaFinal = etiquetaFinal;
    }       

    public Short getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(Short tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getValidos() {
        return validos;
    }

    public void setValidos(String validos) {
        this.validos = validos;
    }

    public String getInvalidos() {
        return invalidos;
    }

    public void setInvalidos(String invalidos) {
        this.invalidos = invalidos;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }    

}
