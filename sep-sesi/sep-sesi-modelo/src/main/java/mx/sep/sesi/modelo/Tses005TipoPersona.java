package mx.sep.sesi.modelo;

public class Tses005TipoPersona {
    private Integer idTipoPersona;

    private String tipoPersona;

    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona == null ? null : tipoPersona.trim();
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
        Tses005TipoPersona other = (Tses005TipoPersona) that;
        return (this.getIdTipoPersona() == null ? other.getIdTipoPersona() == null : this.getIdTipoPersona().equals(other.getIdTipoPersona()))
            && (this.getTipoPersona() == null ? other.getTipoPersona() == null : this.getTipoPersona().equals(other.getTipoPersona()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTipoPersona() == null) ? 0 : getIdTipoPersona().hashCode());
        result = prime * result + ((getTipoPersona() == null) ? 0 : getTipoPersona().hashCode());
        return result;
    }
}