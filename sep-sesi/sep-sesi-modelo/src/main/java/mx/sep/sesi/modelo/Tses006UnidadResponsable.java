package mx.sep.sesi.modelo;

public class Tses006UnidadResponsable {
    private Integer idUr;

    private String unidadResponsable;

    private String claveUr;

    private String abreviatura;

    public Integer getIdUr() {
        return idUr;
    }

    public void setIdUr(Integer idUr) {
        this.idUr = idUr;
    }

    public String getUnidadResponsable() {
        return unidadResponsable;
    }

    public void setUnidadResponsable(String unidadResponsable) {
        this.unidadResponsable = unidadResponsable == null ? null : unidadResponsable.trim();
    }

    public String getClaveUr() {
        return claveUr;
    }

    public void setClaveUr(String claveUr) {
        this.claveUr = claveUr == null ? null : claveUr.trim();
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura == null ? null : abreviatura.trim();
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
        Tses006UnidadResponsable other = (Tses006UnidadResponsable) that;
        return (this.getIdUr() == null ? other.getIdUr() == null : this.getIdUr().equals(other.getIdUr()))
            && (this.getUnidadResponsable() == null ? other.getUnidadResponsable() == null : this.getUnidadResponsable().equals(other.getUnidadResponsable()))
            && (this.getClaveUr() == null ? other.getClaveUr() == null : this.getClaveUr().equals(other.getClaveUr()))
            && (this.getAbreviatura() == null ? other.getAbreviatura() == null : this.getAbreviatura().equals(other.getAbreviatura()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdUr() == null) ? 0 : getIdUr().hashCode());
        result = prime * result + ((getUnidadResponsable() == null) ? 0 : getUnidadResponsable().hashCode());
        result = prime * result + ((getClaveUr() == null) ? 0 : getClaveUr().hashCode());
        result = prime * result + ((getAbreviatura() == null) ? 0 : getAbreviatura().hashCode());
        return result;
    }
}