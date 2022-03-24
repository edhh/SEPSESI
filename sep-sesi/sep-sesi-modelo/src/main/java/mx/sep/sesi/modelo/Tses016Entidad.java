package mx.sep.sesi.modelo;

public class Tses016Entidad {
    private Integer idEntidad;

    private String entidad;

    private String claveEntidad;

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad == null ? null : entidad.trim();
    }

    public String getClaveEntidad() {
        return claveEntidad;
    }

    public void setClaveEntidad(String claveEntidad) {
        this.claveEntidad = claveEntidad == null ? null : claveEntidad.trim();
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
        Tses016Entidad other = (Tses016Entidad) that;
        return (this.getIdEntidad() == null ? other.getIdEntidad() == null : this.getIdEntidad().equals(other.getIdEntidad()))
            && (this.getEntidad() == null ? other.getEntidad() == null : this.getEntidad().equals(other.getEntidad()))
            && (this.getClaveEntidad() == null ? other.getClaveEntidad() == null : this.getClaveEntidad().equals(other.getClaveEntidad()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdEntidad() == null) ? 0 : getIdEntidad().hashCode());
        result = prime * result + ((getEntidad() == null) ? 0 : getEntidad().hashCode());
        result = prime * result + ((getClaveEntidad() == null) ? 0 : getClaveEntidad().hashCode());
        return result;
    }
}