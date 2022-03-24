/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.datos.vo;

/**
 *
 * @author HeribertoGonzálezPér
 */
public class DatosEquipoVO {
    
    private Long tipoOperacion;
    private String curp;
    private String numSerie;
    private String correo;
    private Long idPartida;
    
    private Short statusOper;
    private String tipoError;

    public Long getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(Long tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Short getStatusOper() {
        return statusOper;
    }

    public void setStatusOper(Short statusOper) {
        this.statusOper = statusOper;
    }

    public String getTipoError() {
        return tipoError;
    }

    public void setTipoError(String tipoError) {
        this.tipoError = tipoError;
    }

    public Long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
    }

}
