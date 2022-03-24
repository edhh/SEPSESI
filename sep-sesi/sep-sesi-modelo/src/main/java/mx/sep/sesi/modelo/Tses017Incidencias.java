package mx.sep.sesi.modelo;

import java.util.Date;

public class Tses017Incidencias {
    private Long idIncidencia;

    private Integer idPersona;

    private Long idVisitante;

    private Short temperatura;

    private Date fecha;

    private Date hora;

    public Long getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(Long idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Long idVisitante) {
        this.idVisitante = idVisitante;
    }

    public Short getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Short temperatura) {
        this.temperatura = temperatura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
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
        Tses017Incidencias other = (Tses017Incidencias) that;
        return (this.getIdIncidencia() == null ? other.getIdIncidencia() == null : this.getIdIncidencia().equals(other.getIdIncidencia()))
            && (this.getIdPersona() == null ? other.getIdPersona() == null : this.getIdPersona().equals(other.getIdPersona()))
            && (this.getIdVisitante() == null ? other.getIdVisitante() == null : this.getIdVisitante().equals(other.getIdVisitante()))
            && (this.getTemperatura() == null ? other.getTemperatura() == null : this.getTemperatura().equals(other.getTemperatura()))
            && (this.getFecha() == null ? other.getFecha() == null : this.getFecha().equals(other.getFecha()))
            && (this.getHora() == null ? other.getHora() == null : this.getHora().equals(other.getHora()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdIncidencia() == null) ? 0 : getIdIncidencia().hashCode());
        result = prime * result + ((getIdPersona() == null) ? 0 : getIdPersona().hashCode());
        result = prime * result + ((getIdVisitante() == null) ? 0 : getIdVisitante().hashCode());
        result = prime * result + ((getTemperatura() == null) ? 0 : getTemperatura().hashCode());
        result = prime * result + ((getFecha() == null) ? 0 : getFecha().hashCode());
        result = prime * result + ((getHora() == null) ? 0 : getHora().hashCode());
        return result;
    }
}