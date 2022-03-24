package mx.sep.sesi.modelo;

public class Tses002Roles {
    private Integer idRol;

    private String descRol;

    private Short activo;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescRol() {
        return descRol;
    }

    public void setDescRol(String descRol) {
        this.descRol = descRol == null ? null : descRol.trim();
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
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
        Tses002Roles other = (Tses002Roles) that;
        return (this.getIdRol() == null ? other.getIdRol() == null : this.getIdRol().equals(other.getIdRol()))
            && (this.getDescRol() == null ? other.getDescRol() == null : this.getDescRol().equals(other.getDescRol()))
            && (this.getActivo() == null ? other.getActivo() == null : this.getActivo().equals(other.getActivo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdRol() == null) ? 0 : getIdRol().hashCode());
        result = prime * result + ((getDescRol() == null) ? 0 : getDescRol().hashCode());
        result = prime * result + ((getActivo() == null) ? 0 : getActivo().hashCode());
        return result;
    }
}