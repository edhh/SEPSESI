package mx.sep.sesi.modelo;

public class Tses022TraduccionServicio {
    private Integer idTradServicio;

    private String nombreMetodo;

    private String descripcion;

    public Integer getIdTradServicio() {
        return idTradServicio;
    }

    public void setIdTradServicio(Integer idTradServicio) {
        this.idTradServicio = idTradServicio;
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo == null ? null : nombreMetodo.trim();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
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
        Tses022TraduccionServicio other = (Tses022TraduccionServicio) that;
        return (this.getIdTradServicio() == null ? other.getIdTradServicio() == null : this.getIdTradServicio().equals(other.getIdTradServicio()))
            && (this.getNombreMetodo() == null ? other.getNombreMetodo() == null : this.getNombreMetodo().equals(other.getNombreMetodo()))
            && (this.getDescripcion() == null ? other.getDescripcion() == null : this.getDescripcion().equals(other.getDescripcion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTradServicio() == null) ? 0 : getIdTradServicio().hashCode());
        result = prime * result + ((getNombreMetodo() == null) ? 0 : getNombreMetodo().hashCode());
        result = prime * result + ((getDescripcion() == null) ? 0 : getDescripcion().hashCode());
        return result;
    }
}