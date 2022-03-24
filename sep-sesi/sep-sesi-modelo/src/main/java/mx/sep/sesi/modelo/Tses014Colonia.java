package mx.sep.sesi.modelo;

public class Tses014Colonia {
    private Long idColonia;

    private Integer idEntidad;

    private Integer idAlcaldiaMun;

    private String colonia;

    public Long getIdColonia() {
        return idColonia;
    }

    public void setIdColonia(Long idColonia) {
        this.idColonia = idColonia;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Integer getIdAlcaldiaMun() {
        return idAlcaldiaMun;
    }

    public void setIdAlcaldiaMun(Integer idAlcaldiaMun) {
        this.idAlcaldiaMun = idAlcaldiaMun;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia == null ? null : colonia.trim();
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
        Tses014Colonia other = (Tses014Colonia) that;
        return (this.getIdColonia() == null ? other.getIdColonia() == null : this.getIdColonia().equals(other.getIdColonia()))
            && (this.getIdEntidad() == null ? other.getIdEntidad() == null : this.getIdEntidad().equals(other.getIdEntidad()))
            && (this.getIdAlcaldiaMun() == null ? other.getIdAlcaldiaMun() == null : this.getIdAlcaldiaMun().equals(other.getIdAlcaldiaMun()))
            && (this.getColonia() == null ? other.getColonia() == null : this.getColonia().equals(other.getColonia()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdColonia() == null) ? 0 : getIdColonia().hashCode());
        result = prime * result + ((getIdEntidad() == null) ? 0 : getIdEntidad().hashCode());
        result = prime * result + ((getIdAlcaldiaMun() == null) ? 0 : getIdAlcaldiaMun().hashCode());
        result = prime * result + ((getColonia() == null) ? 0 : getColonia().hashCode());
        return result;
    }
}