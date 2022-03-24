package mx.sep.sesi.modelo;

public class Tses001Usuarios {
    private Integer idUsuario;

    private Integer idInmueble;

    private Integer idAcceso;

    private Integer idUr;

    private String apellido1;

    private String apellido2;

    private String nombre;

    private String nombreUsu;

    private String contrasena;

    private Short activo;

    private String curp;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Integer getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(Integer idAcceso) {
        this.idAcceso = idAcceso;
    }

    public Integer getIdUr() {
        return idUr;
    }

    public void setIdUr(Integer idUr) {
        this.idUr = idUr;
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

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu == null ? null : nombreUsu.trim();
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena == null ? null : contrasena.trim();
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp == null ? null : curp.trim();
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
        Tses001Usuarios other = (Tses001Usuarios) that;
        return (this.getIdUsuario() == null ? other.getIdUsuario() == null : this.getIdUsuario().equals(other.getIdUsuario()))
            && (this.getIdInmueble() == null ? other.getIdInmueble() == null : this.getIdInmueble().equals(other.getIdInmueble()))
            && (this.getIdAcceso() == null ? other.getIdAcceso() == null : this.getIdAcceso().equals(other.getIdAcceso()))
            && (this.getIdUr() == null ? other.getIdUr() == null : this.getIdUr().equals(other.getIdUr()))
            && (this.getApellido1() == null ? other.getApellido1() == null : this.getApellido1().equals(other.getApellido1()))
            && (this.getApellido2() == null ? other.getApellido2() == null : this.getApellido2().equals(other.getApellido2()))
            && (this.getNombre() == null ? other.getNombre() == null : this.getNombre().equals(other.getNombre()))
            && (this.getNombreUsu() == null ? other.getNombreUsu() == null : this.getNombreUsu().equals(other.getNombreUsu()))
            && (this.getContrasena() == null ? other.getContrasena() == null : this.getContrasena().equals(other.getContrasena()))
            && (this.getActivo() == null ? other.getActivo() == null : this.getActivo().equals(other.getActivo()))
            && (this.getCurp() == null ? other.getCurp() == null : this.getCurp().equals(other.getCurp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdUsuario() == null) ? 0 : getIdUsuario().hashCode());
        result = prime * result + ((getIdInmueble() == null) ? 0 : getIdInmueble().hashCode());
        result = prime * result + ((getIdAcceso() == null) ? 0 : getIdAcceso().hashCode());
        result = prime * result + ((getIdUr() == null) ? 0 : getIdUr().hashCode());
        result = prime * result + ((getApellido1() == null) ? 0 : getApellido1().hashCode());
        result = prime * result + ((getApellido2() == null) ? 0 : getApellido2().hashCode());
        result = prime * result + ((getNombre() == null) ? 0 : getNombre().hashCode());
        result = prime * result + ((getNombreUsu() == null) ? 0 : getNombreUsu().hashCode());
        result = prime * result + ((getContrasena() == null) ? 0 : getContrasena().hashCode());
        result = prime * result + ((getActivo() == null) ? 0 : getActivo().hashCode());
        result = prime * result + ((getCurp() == null) ? 0 : getCurp().hashCode());
        return result;
    }
}