package mx.sep.sesi.modelo;

public class Tses026Partidas {
    private Long idPartida;

    private String producto;

    private String marca;

    public Long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto == null ? null : producto.trim();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca == null ? null : marca.trim();
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
        Tses026Partidas other = (Tses026Partidas) that;
        return (this.getIdPartida() == null ? other.getIdPartida() == null : this.getIdPartida().equals(other.getIdPartida()))
            && (this.getProducto() == null ? other.getProducto() == null : this.getProducto().equals(other.getProducto()))
            && (this.getMarca() == null ? other.getMarca() == null : this.getMarca().equals(other.getMarca()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdPartida() == null) ? 0 : getIdPartida().hashCode());
        result = prime * result + ((getProducto() == null) ? 0 : getProducto().hashCode());
        result = prime * result + ((getMarca() == null) ? 0 : getMarca().hashCode());
        return result;
    }
}