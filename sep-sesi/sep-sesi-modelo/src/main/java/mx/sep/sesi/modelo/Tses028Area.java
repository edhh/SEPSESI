package mx.sep.sesi.modelo;

import java.math.BigDecimal;

public class Tses028Area {
    private BigDecimal idArea;

    private Integer idUr;

    private String claveArea;

    public BigDecimal getIdArea() {
        return idArea;
    }

    public void setIdArea(BigDecimal idArea) {
        this.idArea = idArea;
    }

    public Integer getIdUr() {
        return idUr;
    }

    public void setIdUr(Integer idUr) {
        this.idUr = idUr;
    }

    public String getClaveArea() {
        return claveArea;
    }

    public void setClaveArea(String claveArea) {
        this.claveArea = claveArea == null ? null : claveArea.trim();
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
        Tses028Area other = (Tses028Area) that;
        return (this.getIdArea() == null ? other.getIdArea() == null : this.getIdArea().equals(other.getIdArea()))
            && (this.getIdUr() == null ? other.getIdUr() == null : this.getIdUr().equals(other.getIdUr()))
            && (this.getClaveArea() == null ? other.getClaveArea() == null : this.getClaveArea().equals(other.getClaveArea()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdArea() == null) ? 0 : getIdArea().hashCode());
        result = prime * result + ((getIdUr() == null) ? 0 : getIdUr().hashCode());
        result = prime * result + ((getClaveArea() == null) ? 0 : getClaveArea().hashCode());
        return result;
    }
}