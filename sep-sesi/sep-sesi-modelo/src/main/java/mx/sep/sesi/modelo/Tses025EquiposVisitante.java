package mx.sep.sesi.modelo;

public class Tses025EquiposVisitante {
    private Long idEquipoVis;

    private Long idVisitante;

    private String descripcionEquipoVis;

    private String marcaVis;

    private String numeroSerieVis;

    private Short estatus;
    
    private String estatusS;

    public Long getIdEquipoVis() {
        return idEquipoVis;
    }

    public void setIdEquipoVis(Long idEquipoVis) {
        this.idEquipoVis = idEquipoVis;
    }

    public Long getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Long idVisitante) {
        this.idVisitante = idVisitante;
    }

    public String getDescripcionEquipoVis() {
        return descripcionEquipoVis;
    }

    public void setDescripcionEquipoVis(String descripcionEquipoVis) {
        this.descripcionEquipoVis = descripcionEquipoVis == null ? null : descripcionEquipoVis.trim();
    }

    public String getMarcaVis() {
        return marcaVis;
    }

    public void setMarcaVis(String marcaVis) {
        this.marcaVis = marcaVis == null ? null : marcaVis.trim();
    }

    public String getNumeroSerieVis() {
        return numeroSerieVis;
    }

    public void setNumeroSerieVis(String numeroSerieVis) {
        this.numeroSerieVis = numeroSerieVis == null ? null : numeroSerieVis.trim();
    }

    public Short getEstatus() {
        return estatus;
    }

    public void setEstatus(Short estatus) {
        this.estatus = estatus;
    }

    public String getEstatusS() {
        return estatusS;
    }

    public void setEstatusS(String estatusS) {
        this.estatusS = estatusS;
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
        Tses025EquiposVisitante other = (Tses025EquiposVisitante) that;
        return (this.getIdEquipoVis() == null ? other.getIdEquipoVis() == null : this.getIdEquipoVis().equals(other.getIdEquipoVis()))
            && (this.getIdVisitante() == null ? other.getIdVisitante() == null : this.getIdVisitante().equals(other.getIdVisitante()))
            && (this.getDescripcionEquipoVis() == null ? other.getDescripcionEquipoVis() == null : this.getDescripcionEquipoVis().equals(other.getDescripcionEquipoVis()))
            && (this.getMarcaVis() == null ? other.getMarcaVis() == null : this.getMarcaVis().equals(other.getMarcaVis()))
            && (this.getNumeroSerieVis() == null ? other.getNumeroSerieVis() == null : this.getNumeroSerieVis().equals(other.getNumeroSerieVis()))
            && (this.getEstatus() == null ? other.getEstatus() == null : this.getEstatus().equals(other.getEstatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdEquipoVis() == null) ? 0 : getIdEquipoVis().hashCode());
        result = prime * result + ((getIdVisitante() == null) ? 0 : getIdVisitante().hashCode());
        result = prime * result + ((getDescripcionEquipoVis() == null) ? 0 : getDescripcionEquipoVis().hashCode());
        result = prime * result + ((getMarcaVis() == null) ? 0 : getMarcaVis().hashCode());
        result = prime * result + ((getNumeroSerieVis() == null) ? 0 : getNumeroSerieVis().hashCode());
        result = prime * result + ((getEstatus() == null) ? 0 : getEstatus().hashCode());
        return result;
    }
}