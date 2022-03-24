package mx.sep.sesi.modelo;

public class Tses009Inmuebles {
    private Integer idInmueble;

    private Long idColonia;

    private Integer idAlcaldiaMun;

    private Integer idEntidad;

    private String claveInmueble;

    private String denominacion;

    private String calle;

    private String numero;

    private String cp;

    private Short numAccesos;

    private Short estatus;

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Long getIdColonia() {
        return idColonia;
    }

    public void setIdColonia(Long idColonia) {
        this.idColonia = idColonia;
    }

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

    public String getClaveInmueble() {
        return claveInmueble;
    }

    public void setClaveInmueble(String claveInmueble) {
        this.claveInmueble = claveInmueble == null ? null : claveInmueble.trim();
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion == null ? null : denominacion.trim();
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle == null ? null : calle.trim();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero == null ? null : numero.trim();
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp == null ? null : cp.trim();
    }

    public Short getNumAccesos() {
        return numAccesos;
    }

    public void setNumAccesos(Short numAccesos) {
        this.numAccesos = numAccesos;
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
        Tses009Inmuebles other = (Tses009Inmuebles) that;
        return (this.getIdInmueble() == null ? other.getIdInmueble() == null : this.getIdInmueble().equals(other.getIdInmueble()))
            && (this.getIdColonia() == null ? other.getIdColonia() == null : this.getIdColonia().equals(other.getIdColonia()))
            && (this.getIdAlcaldiaMun() == null ? other.getIdAlcaldiaMun() == null : this.getIdAlcaldiaMun().equals(other.getIdAlcaldiaMun()))
            && (this.getIdEntidad() == null ? other.getIdEntidad() == null : this.getIdEntidad().equals(other.getIdEntidad()))
            && (this.getClaveInmueble() == null ? other.getClaveInmueble() == null : this.getClaveInmueble().equals(other.getClaveInmueble()))
            && (this.getDenominacion() == null ? other.getDenominacion() == null : this.getDenominacion().equals(other.getDenominacion()))
            && (this.getCalle() == null ? other.getCalle() == null : this.getCalle().equals(other.getCalle()))
            && (this.getNumero() == null ? other.getNumero() == null : this.getNumero().equals(other.getNumero()))
            && (this.getCp() == null ? other.getCp() == null : this.getCp().equals(other.getCp()))
            && (this.getNumAccesos() == null ? other.getNumAccesos() == null : this.getNumAccesos().equals(other.getNumAccesos()))
            && (this.getEstatus() == null ? other.getEstatus() == null : this.getEstatus().equals(other.getEstatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdInmueble() == null) ? 0 : getIdInmueble().hashCode());
        result = prime * result + ((getIdColonia() == null) ? 0 : getIdColonia().hashCode());
        result = prime * result + ((getIdAlcaldiaMun() == null) ? 0 : getIdAlcaldiaMun().hashCode());
        result = prime * result + ((getIdEntidad() == null) ? 0 : getIdEntidad().hashCode());
        result = prime * result + ((getClaveInmueble() == null) ? 0 : getClaveInmueble().hashCode());
        result = prime * result + ((getDenominacion() == null) ? 0 : getDenominacion().hashCode());
        result = prime * result + ((getCalle() == null) ? 0 : getCalle().hashCode());
        result = prime * result + ((getNumero() == null) ? 0 : getNumero().hashCode());
        result = prime * result + ((getCp() == null) ? 0 : getCp().hashCode());
        result = prime * result + ((getNumAccesos() == null) ? 0 : getNumAccesos().hashCode());
        result = prime * result + ((getEstatus() == null) ? 0 : getEstatus().hashCode());
        return result;
    }
}