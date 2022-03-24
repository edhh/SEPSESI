package mx.sep.sesi.modelo;

import java.util.Date;

public class Tses012Operacion {
    private Long idRegistro;

    private Integer idUsuario;

    private Integer idPersona;

    private Long idVisitante;

    private Integer idAcceso;

    private Integer idInmueble;

    private Date fechaOperacion;

    private Short entradaSalida;

    public Long getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Long idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public Integer getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(Integer idAcceso) {
        this.idAcceso = idAcceso;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
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
        Tses012Operacion other = (Tses012Operacion) that;
        return (this.getIdRegistro() == null ? other.getIdRegistro() == null : this.getIdRegistro().equals(other.getIdRegistro()))
            && (this.getIdUsuario() == null ? other.getIdUsuario() == null : this.getIdUsuario().equals(other.getIdUsuario()))
            && (this.getIdPersona() == null ? other.getIdPersona() == null : this.getIdPersona().equals(other.getIdPersona()))
            && (this.getIdVisitante() == null ? other.getIdVisitante() == null : this.getIdVisitante().equals(other.getIdVisitante()))
            && (this.getIdAcceso() == null ? other.getIdAcceso() == null : this.getIdAcceso().equals(other.getIdAcceso()))
            && (this.getIdInmueble() == null ? other.getIdInmueble() == null : this.getIdInmueble().equals(other.getIdInmueble()))
            && (this.getFechaOperacion() == null ? other.getFechaOperacion() == null : this.getFechaOperacion().equals(other.getFechaOperacion()))
            && (this.getEntradaSalida() == null ? other.getEntradaSalida() == null : this.getEntradaSalida().equals(other.getEntradaSalida()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdRegistro() == null) ? 0 : getIdRegistro().hashCode());
        result = prime * result + ((getIdUsuario() == null) ? 0 : getIdUsuario().hashCode());
        result = prime * result + ((getIdPersona() == null) ? 0 : getIdPersona().hashCode());
        result = prime * result + ((getIdVisitante() == null) ? 0 : getIdVisitante().hashCode());
        result = prime * result + ((getIdAcceso() == null) ? 0 : getIdAcceso().hashCode());
        result = prime * result + ((getIdInmueble() == null) ? 0 : getIdInmueble().hashCode());
        result = prime * result + ((getFechaOperacion() == null) ? 0 : getFechaOperacion().hashCode());
        result = prime * result + ((getEntradaSalida() == null) ? 0 : getEntradaSalida().hashCode());
        return result;
    }
}