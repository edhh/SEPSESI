package mx.sep.sesi.modelo;

public class Tses015AlcaldiaMun {
    private Integer idAlcaldiaMun;

    private Integer idEntidad;

    private String alcaldiaMun;

    public Integer getIdAlcaldiaMun() {
        return idAlcaldiaMun;
    }

    public void setIdAlcaldiaMun(Integer idAlcaldiaMun) {
        this.idAlcaldiaMun = idAlcaldiaMun;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getAlcaldiaMun() {
        return alcaldiaMun;
    }

    public void setAlcaldiaMun(String alcaldiaMun) {
        this.alcaldiaMun = alcaldiaMun == null ? null : alcaldiaMun.trim();
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
        Tses015AlcaldiaMun other = (Tses015AlcaldiaMun) that;
        return (this.getIdAlcaldiaMun() == null ? other.getIdAlcaldiaMun() == null : this.getIdAlcaldiaMun().equals(other.getIdAlcaldiaMun()))
            && (this.getIdEntidad() == null ? other.getIdEntidad() == null : this.getIdEntidad().equals(other.getIdEntidad()))
            && (this.getAlcaldiaMun() == null ? other.getAlcaldiaMun() == null : this.getAlcaldiaMun().equals(other.getAlcaldiaMun()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdAlcaldiaMun() == null) ? 0 : getIdAlcaldiaMun().hashCode());
        result = prime * result + ((getIdEntidad() == null) ? 0 : getIdEntidad().hashCode());
        result = prime * result + ((getAlcaldiaMun() == null) ? 0 : getAlcaldiaMun().hashCode());
        return result;
    }
}