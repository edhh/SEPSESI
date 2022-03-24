package mx.sep.sesi.modelo;

import java.util.Date;

public class Tses011Visitantes {
    private Long idVisitante;

    private Long idEtiqueta;

    private Integer idTipoPersona;

    private Integer idInmueble;

    private Integer idCuadranteArea;

    private Integer idUr;

    private String curp;

    private String apellido1;

    private String apellido2;

    private String nombre;

    private String personaVisita;

    private Date fechaActualizacion;

    private byte[] fotografia;

    public Long getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Long idVisitante) {
        this.idVisitante = idVisitante;
    }

    public Long getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(Long idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
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

    public Integer getIdUr() {
        return idUr;
    }

    public void setIdUr(Integer idUr) {
        this.idUr = idUr;
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

    public String getPersonaVisita() {
        return personaVisita;
    }

    public void setPersonaVisita(String personaVisita) {
        this.personaVisita = personaVisita == null ? null : personaVisita.trim();
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
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
        Tses011Visitantes other = (Tses011Visitantes) that;
        return (this.getIdVisitante() == null ? other.getIdVisitante() == null : this.getIdVisitante().equals(other.getIdVisitante()))
            && (this.getIdEtiqueta() == null ? other.getIdEtiqueta() == null : this.getIdEtiqueta().equals(other.getIdEtiqueta()))
            && (this.getIdTipoPersona() == null ? other.getIdTipoPersona() == null : this.getIdTipoPersona().equals(other.getIdTipoPersona()))
            && (this.getIdInmueble() == null ? other.getIdInmueble() == null : this.getIdInmueble().equals(other.getIdInmueble()))
            && (this.getIdCuadranteArea() == null ? other.getIdCuadranteArea() == null : this.getIdCuadranteArea().equals(other.getIdCuadranteArea()))
            && (this.getIdUr() == null ? other.getIdUr() == null : this.getIdUr().equals(other.getIdUr()))
            && (this.getCurp() == null ? other.getCurp() == null : this.getCurp().equals(other.getCurp()))
            && (this.getApellido1() == null ? other.getApellido1() == null : this.getApellido1().equals(other.getApellido1()))
            && (this.getApellido2() == null ? other.getApellido2() == null : this.getApellido2().equals(other.getApellido2()))
            && (this.getNombre() == null ? other.getNombre() == null : this.getNombre().equals(other.getNombre()))
            && (this.getPersonaVisita() == null ? other.getPersonaVisita() == null : this.getPersonaVisita().equals(other.getPersonaVisita()))
            && (this.getFechaActualizacion() == null ? other.getFechaActualizacion() == null : this.getFechaActualizacion().equals(other.getFechaActualizacion()))
            && (this.getFotografia() == null ? other.getFotografia() == null : this.getFotografia().equals(other.getFotografia()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdVisitante() == null) ? 0 : getIdVisitante().hashCode());
        result = prime * result + ((getIdEtiqueta() == null) ? 0 : getIdEtiqueta().hashCode());
        result = prime * result + ((getIdTipoPersona() == null) ? 0 : getIdTipoPersona().hashCode());
        result = prime * result + ((getIdInmueble() == null) ? 0 : getIdInmueble().hashCode());
        result = prime * result + ((getIdCuadranteArea() == null) ? 0 : getIdCuadranteArea().hashCode());
        result = prime * result + ((getIdUr() == null) ? 0 : getIdUr().hashCode());
        result = prime * result + ((getCurp() == null) ? 0 : getCurp().hashCode());
        result = prime * result + ((getApellido1() == null) ? 0 : getApellido1().hashCode());
        result = prime * result + ((getApellido2() == null) ? 0 : getApellido2().hashCode());
        result = prime * result + ((getNombre() == null) ? 0 : getNombre().hashCode());
        result = prime * result + ((getPersonaVisita() == null) ? 0 : getPersonaVisita().hashCode());
        result = prime * result + ((getFechaActualizacion() == null) ? 0 : getFechaActualizacion().hashCode());
        result = prime * result + ((getFotografia() == null) ? 0 : getFotografia().hashCode());
        return result;
    }
}