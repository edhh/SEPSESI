package mx.sep.sesi.modelo;

public class Tses010CuadranteArea {
    private Integer idCuadranteArea;

    private Integer idInmueble;

    private String cuadranteArea;

    public Integer getIdCuadranteArea() {
        return idCuadranteArea;
    }

    public void setIdCuadranteArea(Integer idCuadranteArea) {
        this.idCuadranteArea = idCuadranteArea;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getCuadranteArea() {
        return cuadranteArea;
    }

    public void setCuadranteArea(String cuadranteArea) {
        this.cuadranteArea = cuadranteArea == null ? null : cuadranteArea.trim();
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
        Tses010CuadranteArea other = (Tses010CuadranteArea) that;
        return (this.getIdCuadranteArea() == null ? other.getIdCuadranteArea() == null : this.getIdCuadranteArea().equals(other.getIdCuadranteArea()))
            && (this.getIdInmueble() == null ? other.getIdInmueble() == null : this.getIdInmueble().equals(other.getIdInmueble()))
            && (this.getCuadranteArea() == null ? other.getCuadranteArea() == null : this.getCuadranteArea().equals(other.getCuadranteArea()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdCuadranteArea() == null) ? 0 : getIdCuadranteArea().hashCode());
        result = prime * result + ((getIdInmueble() == null) ? 0 : getIdInmueble().hashCode());
        result = prime * result + ((getCuadranteArea() == null) ? 0 : getCuadranteArea().hashCode());
        return result;
    }
}