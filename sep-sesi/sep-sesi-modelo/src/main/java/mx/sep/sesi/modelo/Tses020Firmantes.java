package mx.sep.sesi.modelo;

public class Tses020Firmantes {
    private Integer idFirmante;

    private Integer idUr;

    private String nombreAutoriza;

    private String puestoAutoriza;

    private byte[] fotografia;

    public Integer getIdFirmante() {
        return idFirmante;
    }

    public void setIdFirmante(Integer idFirmante) {
        this.idFirmante = idFirmante;
    }

    public Integer getIdUr() {
        return idUr;
    }

    public void setIdUr(Integer idUr) {
        this.idUr = idUr;
    }

    public String getNombreAutoriza() {
        return nombreAutoriza;
    }

    public void setNombreAutoriza(String nombreAutoriza) {
        this.nombreAutoriza = nombreAutoriza == null ? null : nombreAutoriza.trim();
    }

    public String getPuestoAutoriza() {
        return puestoAutoriza;
    }

    public void setPuestoAutoriza(String puestoAutoriza) {
        this.puestoAutoriza = puestoAutoriza == null ? null : puestoAutoriza.trim();
    }

    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
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
        Tses020Firmantes other = (Tses020Firmantes) that;
        return (this.getIdFirmante() == null ? other.getIdFirmante() == null : this.getIdFirmante().equals(other.getIdFirmante()))
            && (this.getIdUr() == null ? other.getIdUr() == null : this.getIdUr().equals(other.getIdUr()))
            && (this.getNombreAutoriza() == null ? other.getNombreAutoriza() == null : this.getNombreAutoriza().equals(other.getNombreAutoriza()))
            && (this.getPuestoAutoriza() == null ? other.getPuestoAutoriza() == null : this.getPuestoAutoriza().equals(other.getPuestoAutoriza()))
            && (this.getFotografia() == null ? other.getFotografia() == null : this.getFotografia().equals(other.getFotografia()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdFirmante() == null) ? 0 : getIdFirmante().hashCode());
        result = prime * result + ((getIdUr() == null) ? 0 : getIdUr().hashCode());
        result = prime * result + ((getNombreAutoriza() == null) ? 0 : getNombreAutoriza().hashCode());
        result = prime * result + ((getPuestoAutoriza() == null) ? 0 : getPuestoAutoriza().hashCode());
        result = prime * result + ((getFotografia() == null) ? 0 : getFotografia().hashCode());
        return result;
    }
}