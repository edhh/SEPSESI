package mx.sep.sesi.modelo;

import java.util.Date;

public class Tses024Equipos {
    private Long idEquipo;

    private Long idPersona;

    private Long idPartida;

    private String numSerie;

    private Date fechaAsignacion;

    private Long tipooperacion;

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie == null ? null : numSerie.trim();
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Long getTipooperacion() {
        return tipooperacion;
    }

    public void setTipooperacion(Long tipooperacion) {
        this.tipooperacion = tipooperacion;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Tses024Equipos other = (Tses024Equipos) that;
        return (this.getIdEquipo() == null ? other.getIdEquipo() == null : this.getIdEquipo().equals(other.getIdEquipo()))
            && (this.getIdPersona() == null ? other.getIdPersona() == null : this.getIdPersona().equals(other.getIdPersona()))
            && (this.getIdPartida() == null ? other.getIdPartida() == null : this.getIdPartida().equals(other.getIdPartida()))
            && (this.getNumSerie() == null ? other.getNumSerie() == null : this.getNumSerie().equals(other.getNumSerie()))
            && (this.getFechaAsignacion() == null ? other.getFechaAsignacion() == null : this.getFechaAsignacion().equals(other.getFechaAsignacion()))
            && (this.getTipooperacion() == null ? other.getTipooperacion() == null : this.getTipooperacion().equals(other.getTipooperacion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdEquipo() == null) ? 0 : getIdEquipo().hashCode());
        result = prime * result + ((getIdPersona() == null) ? 0 : getIdPersona().hashCode());
        result = prime * result + ((getIdPartida() == null) ? 0 : getIdPartida().hashCode());
        result = prime * result + ((getNumSerie() == null) ? 0 : getNumSerie().hashCode());
        result = prime * result + ((getFechaAsignacion() == null) ? 0 : getFechaAsignacion().hashCode());
        result = prime * result + ((getTipooperacion() == null) ? 0 : getTipooperacion().hashCode());
        return result;
    }
}