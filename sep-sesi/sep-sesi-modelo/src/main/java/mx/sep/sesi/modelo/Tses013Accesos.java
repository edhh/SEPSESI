package mx.sep.sesi.modelo;

public class Tses013Accesos {
    private Integer idAcceso;

    private Integer idInmueble;

    private String desAcceso;

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

    public String getDesAcceso() {
        return desAcceso;
    }

    public void setDesAcceso(String desAcceso) {
        this.desAcceso = desAcceso == null ? null : desAcceso.trim();
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
        Tses013Accesos other = (Tses013Accesos) that;
        return (this.getIdAcceso() == null ? other.getIdAcceso() == null : this.getIdAcceso().equals(other.getIdAcceso()))
            && (this.getIdInmueble() == null ? other.getIdInmueble() == null : this.getIdInmueble().equals(other.getIdInmueble()))
            && (this.getDesAcceso() == null ? other.getDesAcceso() == null : this.getDesAcceso().equals(other.getDesAcceso()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdAcceso() == null) ? 0 : getIdAcceso().hashCode());
        result = prime * result + ((getIdInmueble() == null) ? 0 : getIdInmueble().hashCode());
        result = prime * result + ((getDesAcceso() == null) ? 0 : getDesAcceso().hashCode());
        return result;
    }
}