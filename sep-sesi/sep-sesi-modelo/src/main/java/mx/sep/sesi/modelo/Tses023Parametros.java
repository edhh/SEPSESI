package mx.sep.sesi.modelo;

public class Tses023Parametros {
    private Integer idParam;

    private String valor;

    private String descripcion;

    public Integer getIdParam() {
        return idParam;
    }

    public void setIdParam(Integer idParam) {
        this.idParam = idParam;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor == null ? null : valor.trim();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
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
        Tses023Parametros other = (Tses023Parametros) that;
        return (this.getIdParam() == null ? other.getIdParam() == null : this.getIdParam().equals(other.getIdParam()))
            && (this.getValor() == null ? other.getValor() == null : this.getValor().equals(other.getValor()))
            && (this.getDescripcion() == null ? other.getDescripcion() == null : this.getDescripcion().equals(other.getDescripcion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdParam() == null) ? 0 : getIdParam().hashCode());
        result = prime * result + ((getValor() == null) ? 0 : getValor().hashCode());
        result = prime * result + ((getDescripcion() == null) ? 0 : getDescripcion().hashCode());
        return result;
    }
}