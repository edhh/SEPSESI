package mx.sep.sesi.modelo;

public class Tses007TipoSangre {
    private Integer idTipo;

    private String tipoSangre;

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre == null ? null : tipoSangre.trim();
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
        Tses007TipoSangre other = (Tses007TipoSangre) that;
        return (this.getIdTipo() == null ? other.getIdTipo() == null : this.getIdTipo().equals(other.getIdTipo()))
            && (this.getTipoSangre() == null ? other.getTipoSangre() == null : this.getTipoSangre().equals(other.getTipoSangre()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTipo() == null) ? 0 : getIdTipo().hashCode());
        result = prime * result + ((getTipoSangre() == null) ? 0 : getTipoSangre().hashCode());
        return result;
    }
}