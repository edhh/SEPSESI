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
public class EquiposVO {
    
    private Long id_equipo;
    private String numSerie;
    private String partida;
    private String marca;

    public Long getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Long id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }
    
}
