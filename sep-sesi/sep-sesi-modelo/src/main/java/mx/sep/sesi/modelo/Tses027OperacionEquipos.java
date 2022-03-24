package mx.sep.sesi.modelo;

import java.util.Date;

public class Tses027OperacionEquipos {
    private Long idOperacionEquipos;

    private Long idUsuario;

    private Long idInmueble;

    private Long idEquipo;

    private Long idEquipoVis;

    private Date fechaOperacion;

    private Short entradaSalida;

    public Long getIdOperacionEquipos() {
        return idOperacionEquipos;
    }

    public void setIdOperacionEquipos(Long idOperacionEquipos) {
        this.idOperacionEquipos = idOperacionEquipos;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Long idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Long getIdEquipoVis() {
        return idEquipoVis;
    }

    public void setIdEquipoVis(Long idEquipoVis) {
        this.idEquipoVis = idEquipoVis;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Short getEntradaSalida() {
        return entradaSalida;
    }

    public void setEntradaSalida(Short entradaSalida) {
        this.entradaSalida = entradaSalida;
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
        Tses027OperacionEquipos other = (Tses027OperacionEquipos) that;
        return (this.getIdOperacionEquipos() == null ? other.getIdOperacionEquipos() == null : this.getIdOperacionEquipos().equals(other.getIdOperacionEquipos()))
            && (this.getIdUsuario() == null ? other.getIdUsuario() == null : this.getIdUsuario().equals(other.getIdUsuario()))
            && (this.getIdInmueble() == null ? other.getIdInmueble() == null : this.getIdInmueble().equals(other.getIdInmueble()))
            && (this.getIdEquipo() == null ? other.getIdEquipo() == null : this.getIdEquipo().equals(other.getIdEquipo()))
            && (this.getIdEquipoVis() == null ? other.getIdEquipoVis() == null : this.getIdEquipoVis().equals(other.getIdEquipoVis()))
            && (this.getFechaOperacion() == null ? other.getFechaOperacion() == null : this.getFechaOperacion().equals(other.getFechaOperacion()))
            && (this.getEntradaSalida() == null ? other.getEntradaSalida() == null : this.getEntradaSalida().equals(other.getEntradaSalida()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdOperacionEquipos() == null) ? 0 : getIdOperacionEquipos().hashCode());
        result = prime * result + ((getIdUsuario() == null) ? 0 : getIdUsuario().hashCode());
        result = prime * result + ((getIdInmueble() == null) ? 0 : getIdInmueble().hashCode());
        result = prime * result + ((getIdEquipo() == null) ? 0 : getIdEquipo().hashCode());
        result = prime * result + ((getIdEquipoVis() == null) ? 0 : getIdEquipoVis().hashCode());
        result = prime * result + ((getFechaOperacion() == null) ? 0 : getFechaOperacion().hashCode());
        result = prime * result + ((getEntradaSalida() == null) ? 0 : getEntradaSalida().hashCode());
        return result;
    }
}