package mx.sep.sesi.modelo;

import java.util.Date;

public class Tses004Personas {
    private Integer idPersona;

    private Integer idTipoPersona;

    private Integer idUr;

    private Integer idTipoSangre;

    private Integer idInmueble;

    private Integer idCuadranteArea;

    private String curp;

    private String apellido1;

    private String apellido2;

    private String nombre;

    private String puesto;

    private String alergias;

    private String telEmergencia;

    private String enfermedad;

    private Date fechaActualizacion;

    private Short estatus;

    private String correo;

    private String rfc;

    private Integer idArea;

    private byte[] fotografia;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public Integer getIdUr() {
        return idUr;
    }

    public void setIdUr(Integer idUr) {
        this.idUr = idUr;
    }

    public Integer getIdTipoSangre() {
        return idTipoSangre;
    }

    public void setIdTipoSangre(Integer idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Integer getIdCuadranteArea() {
        return idCuadranteArea;
    }

    public void setIdCuadranteArea(Integer idCuadranteArea) {
        this.idCuadranteArea = idCuadranteArea;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp == null ? null : curp.trim();
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1 == null ? null : apellido1.trim();
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2 == null ? null : apellido2.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre == null ? null : nombre.trim();
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto == null ? null : puesto.trim();
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias == null ? null : alergias.trim();
    }

    public String getTelEmergencia() {
        return telEmergencia;
    }

    public void setTelEmergencia(String telEmergencia) {
        this.telEmergencia = telEmergencia == null ? null : telEmergencia.trim();
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad == null ? null : enfermedad.trim();
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Short getEstatus() {
        return estatus;
    }

    public void setEstatus(Short estatus) {
        this.estatus = estatus;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo == null ? null : correo.trim();
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc == null ? null : rfc.trim();
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
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
        Tses004Personas other = (Tses004Personas) that;
        return (this.getIdPersona() == null ? other.getIdPersona() == null : this.getIdPersona().equals(other.getIdPersona()))
            && (this.getIdTipoPersona() == null ? other.getIdTipoPersona() == null : this.getIdTipoPersona().equals(other.getIdTipoPersona()))
            && (this.getIdUr() == null ? other.getIdUr() == null : this.getIdUr().equals(other.getIdUr()))
            && (this.getIdTipoSangre() == null ? other.getIdTipoSangre() == null : this.getIdTipoSangre().equals(other.getIdTipoSangre()))
            && (this.getIdInmueble() == null ? other.getIdInmueble() == null : this.getIdInmueble().equals(other.getIdInmueble()))
            && (this.getIdCuadranteArea() == null ? other.getIdCuadranteArea() == null : this.getIdCuadranteArea().equals(other.getIdCuadranteArea()))
            && (this.getCurp() == null ? other.getCurp() == null : this.getCurp().equals(other.getCurp()))
            && (this.getApellido1() == null ? other.getApellido1() == null : this.getApellido1().equals(other.getApellido1()))
            && (this.getApellido2() == null ? other.getApellido2() == null : this.getApellido2().equals(other.getApellido2()))
            && (this.getNombre() == null ? other.getNombre() == null : this.getNombre().equals(other.getNombre()))
            && (this.getPuesto() == null ? other.getPuesto() == null : this.getPuesto().equals(other.getPuesto()))
            && (this.getAlergias() == null ? other.getAlergias() == null : this.getAlergias().equals(other.getAlergias()))
            && (this.getTelEmergencia() == null ? other.getTelEmergencia() == null : this.getTelEmergencia().equals(other.getTelEmergencia()))
            && (this.getEnfermedad() == null ? other.getEnfermedad() == null : this.getEnfermedad().equals(other.getEnfermedad()))
            && (this.getFechaActualizacion() == null ? other.getFechaActualizacion() == null : this.getFechaActualizacion().equals(other.getFechaActualizacion()))
            && (this.getEstatus() == null ? other.getEstatus() == null : this.getEstatus().equals(other.getEstatus()))
            && (this.getCorreo() == null ? other.getCorreo() == null : this.getCorreo().equals(other.getCorreo()))
            && (this.getRfc() == null ? other.getRfc() == null : this.getRfc().equals(other.getRfc()))
            && (this.getIdArea() == null ? other.getIdArea() == null : this.getIdArea().equals(other.getIdArea()))
            && (this.getFotografia() == null ? other.getFotografia() == null : this.getFotografia().equals(other.getFotografia()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdPersona() == null) ? 0 : getIdPersona().hashCode());
        result = prime * result + ((getIdTipoPersona() == null) ? 0 : getIdTipoPersona().hashCode());
        result = prime * result + ((getIdUr() == null) ? 0 : getIdUr().hashCode());
        result = prime * result + ((getIdTipoSangre() == null) ? 0 : getIdTipoSangre().hashCode());
        result = prime * result + ((getIdInmueble() == null) ? 0 : getIdInmueble().hashCode());
        result = prime * result + ((getIdCuadranteArea() == null) ? 0 : getIdCuadranteArea().hashCode());
        result = prime * result + ((getCurp() == null) ? 0 : getCurp().hashCode());
        result = prime * result + ((getApellido1() == null) ? 0 : getApellido1().hashCode());
        result = prime * result + ((getApellido2() == null) ? 0 : getApellido2().hashCode());
        result = prime * result + ((getNombre() == null) ? 0 : getNombre().hashCode());
        result = prime * result + ((getPuesto() == null) ? 0 : getPuesto().hashCode());
        result = prime * result + ((getAlergias() == null) ? 0 : getAlergias().hashCode());
        result = prime * result + ((getTelEmergencia() == null) ? 0 : getTelEmergencia().hashCode());
        result = prime * result + ((getEnfermedad() == null) ? 0 : getEnfermedad().hashCode());
        result = prime * result + ((getFechaActualizacion() == null) ? 0 : getFechaActualizacion().hashCode());
        result = prime * result + ((getEstatus() == null) ? 0 : getEstatus().hashCode());
        result = prime * result + ((getCorreo() == null) ? 0 : getCorreo().hashCode());
        result = prime * result + ((getRfc() == null) ? 0 : getRfc().hashCode());
        result = prime * result + ((getIdArea() == null) ? 0 : getIdArea().hashCode());
        result = prime * result + ((getFotografia() == null) ? 0 : getFotografia().hashCode());
        return result;
    }
}