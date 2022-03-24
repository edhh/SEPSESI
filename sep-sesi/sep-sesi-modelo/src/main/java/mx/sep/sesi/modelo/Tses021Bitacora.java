package mx.sep.sesi.modelo;

import java.util.Date;

public class Tses021Bitacora {
    private Long idBitacora;

    private Integer idUsuario;

    private Integer idTradServicio;

    private String proceso;

    private String descripcion;

    private String detalle;

    private Date fechaOperacion;

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

    public Integer getIdTradServicio() {
        return idTradServicio;
    }

    public void setIdTradServicio(Integer idTradServicio) {
        this.idTradServicio = idTradServicio;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso == null ? null : proceso.trim();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle == null ? null : detalle.trim();
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
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
        Tses021Bitacora other = (Tses021Bitacora) that;
        return (this.getIdBitacora() == null ? other.getIdBitacora() == null : this.getIdBitacora().equals(other.getIdBitacora()))
            && (this.getIdUsuario() == null ? other.getIdUsuario() == null : this.getIdUsuario().equals(other.getIdUsuario()))
            && (this.getIdTradServicio() == null ? other.getIdTradServicio() == null : this.getIdTradServicio().equals(other.getIdTradServicio()))
            && (this.getProceso() == null ? other.getProceso() == null : this.getProceso().equals(other.getProceso()))
            && (this.getDescripcion() == null ? other.getDescripcion() == null : this.getDescripcion().equals(other.getDescripcion()))
            && (this.getDetalle() == null ? other.getDetalle() == null : this.getDetalle().equals(other.getDetalle()))
            && (this.getFechaOperacion() == null ? other.getFechaOperacion() == null : this.getFechaOperacion().equals(other.getFechaOperacion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdBitacora() == null) ? 0 : getIdBitacora().hashCode());
        result = prime * result + ((getIdUsuario() == null) ? 0 : getIdUsuario().hashCode());
        result = prime * result + ((getIdTradServicio() == null) ? 0 : getIdTradServicio().hashCode());
        result = prime * result + ((getProceso() == null) ? 0 : getProceso().hashCode());
        result = prime * result + ((getDescripcion() == null) ? 0 : getDescripcion().hashCode());
        result = prime * result + ((getDetalle() == null) ? 0 : getDetalle().hashCode());
        result = prime * result + ((getFechaOperacion() == null) ? 0 : getFechaOperacion().hashCode());
        return result;
    }
}