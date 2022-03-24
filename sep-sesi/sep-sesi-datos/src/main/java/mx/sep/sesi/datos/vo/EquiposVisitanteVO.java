/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.datos.vo;

/**
 *
 * @author heriberto.perez
 */
public class EquiposVisitanteVO {
    
    private String estatus;
    private String marca;
    private String numeroSerie;
    private String descripcion;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
