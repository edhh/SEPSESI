package mx.sep.sesi.modelo;

public class Tses003RolUsuario {
    private Integer idRolUsuario;

    private Integer idUsuario;

    private Integer idRol;

    public Integer getIdRolUsuario() {
        return idRolUsuario;
    }

    public void setIdRolUsuario(Integer idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
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
        Tses003RolUsuario other = (Tses003RolUsuario) that;
        return (this.getIdRolUsuario() == null ? other.getIdRolUsuario() == null : this.getIdRolUsuario().equals(other.getIdRolUsuario()))
            && (this.getIdUsuario() == null ? other.getIdUsuario() == null : this.getIdUsuario().equals(other.getIdUsuario()))
            && (this.getIdRol() == null ? other.getIdRol() == null : this.getIdRol().equals(other.getIdRol()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdRolUsuario() == null) ? 0 : getIdRolUsuario().hashCode());
        result = prime * result + ((getIdUsuario() == null) ? 0 : getIdUsuario().hashCode());
        result = prime * result + ((getIdRol() == null) ? 0 : getIdRol().hashCode());
        return result;
    }
}