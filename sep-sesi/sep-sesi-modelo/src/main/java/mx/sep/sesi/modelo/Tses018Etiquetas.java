package mx.sep.sesi.modelo;

public class Tses018Etiquetas {
    private Long idEtiqueta;

    private Integer idInmueble;

    private Short estatus;

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
        Tses018Etiquetas other = (Tses018Etiquetas) that;
        return (this.getIdEtiqueta() == null ? other.getIdEtiqueta() == null : this.getIdEtiqueta().equals(other.getIdEtiqueta()))
            && (this.getIdInmueble() == null ? other.getIdInmueble() == null : this.getIdInmueble().equals(other.getIdInmueble()))
            && (this.getEstatus() == null ? other.getEstatus() == null : this.getEstatus().equals(other.getEstatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdEtiqueta() == null) ? 0 : getIdEtiqueta().hashCode());
        result = prime * result + ((getIdInmueble() == null) ? 0 : getIdInmueble().hashCode());
        result = prime * result + ((getEstatus() == null) ? 0 : getEstatus().hashCode());
        return result;
    }
}