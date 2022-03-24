package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tses001UsuariosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses001UsuariosExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdUsuarioIsNull() {
            addCriterion("ID_USUARIO is null");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioIsNotNull() {
            addCriterion("ID_USUARIO is not null");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioEqualTo(Integer value) {
            addCriterion("ID_USUARIO =", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotEqualTo(Integer value) {
            addCriterion("ID_USUARIO <>", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioGreaterThan(Integer value) {
            addCriterion("ID_USUARIO >", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_USUARIO >=", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioLessThan(Integer value) {
            addCriterion("ID_USUARIO <", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioLessThanOrEqualTo(Integer value) {
            addCriterion("ID_USUARIO <=", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioIn(List<Integer> values) {
            addCriterion("ID_USUARIO in", values, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotIn(List<Integer> values) {
            addCriterion("ID_USUARIO not in", values, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioBetween(Integer value1, Integer value2) {
            addCriterion("ID_USUARIO between", value1, value2, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_USUARIO not between", value1, value2, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleIsNull() {
            addCriterion("ID_INMUEBLE is null");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleIsNotNull() {
            addCriterion("ID_INMUEBLE is not null");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleEqualTo(Integer value) {
            addCriterion("ID_INMUEBLE =", value, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleNotEqualTo(Integer value) {
            addCriterion("ID_INMUEBLE <>", value, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleGreaterThan(Integer value) {
            addCriterion("ID_INMUEBLE >", value, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_INMUEBLE >=", value, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleLessThan(Integer value) {
            addCriterion("ID_INMUEBLE <", value, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleLessThanOrEqualTo(Integer value) {
            addCriterion("ID_INMUEBLE <=", value, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleIn(List<Integer> values) {
            addCriterion("ID_INMUEBLE in", values, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleNotIn(List<Integer> values) {
            addCriterion("ID_INMUEBLE not in", values, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleBetween(Integer value1, Integer value2) {
            addCriterion("ID_INMUEBLE between", value1, value2, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_INMUEBLE not between", value1, value2, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdAccesoIsNull() {
            addCriterion("ID_ACCESO is null");
            return (Criteria) this;
        }

        public Criteria andIdAccesoIsNotNull() {
            addCriterion("ID_ACCESO is not null");
            return (Criteria) this;
        }

        public Criteria andIdAccesoEqualTo(Integer value) {
            addCriterion("ID_ACCESO =", value, "idAcceso");
            return (Criteria) this;
        }

        public Criteria andIdAccesoNotEqualTo(Integer value) {
            addCriterion("ID_ACCESO <>", value, "idAcceso");
            return (Criteria) this;
        }

        public Criteria andIdAccesoGreaterThan(Integer value) {
            addCriterion("ID_ACCESO >", value, "idAcceso");
            return (Criteria) this;
        }

        public Criteria andIdAccesoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_ACCESO >=", value, "idAcceso");
            return (Criteria) this;
        }

        public Criteria andIdAccesoLessThan(Integer value) {
            addCriterion("ID_ACCESO <", value, "idAcceso");
            return (Criteria) this;
        }

        public Criteria andIdAccesoLessThanOrEqualTo(Integer value) {
            addCriterion("ID_ACCESO <=", value, "idAcceso");
            return (Criteria) this;
        }

        public Criteria andIdAccesoIn(List<Integer> values) {
            addCriterion("ID_ACCESO in", values, "idAcceso");
            return (Criteria) this;
        }

        public Criteria andIdAccesoNotIn(List<Integer> values) {
            addCriterion("ID_ACCESO not in", values, "idAcceso");
            return (Criteria) this;
        }

        public Criteria andIdAccesoBetween(Integer value1, Integer value2) {
            addCriterion("ID_ACCESO between", value1, value2, "idAcceso");
            return (Criteria) this;
        }

        public Criteria andIdAccesoNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_ACCESO not between", value1, value2, "idAcceso");
            return (Criteria) this;
        }

        public Criteria andIdUrIsNull() {
            addCriterion("ID_UR is null");
            return (Criteria) this;
        }

        public Criteria andIdUrIsNotNull() {
            addCriterion("ID_UR is not null");
            return (Criteria) this;
        }

        public Criteria andIdUrEqualTo(Integer value) {
            addCriterion("ID_UR =", value, "idUr");
            return (Criteria) this;
        }

        public Criteria andIdUrNotEqualTo(Integer value) {
            addCriterion("ID_UR <>", value, "idUr");
            return (Criteria) this;
        }

        public Criteria andIdUrGreaterThan(Integer value) {
            addCriterion("ID_UR >", value, "idUr");
            return (Criteria) this;
        }

        public Criteria andIdUrGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_UR >=", value, "idUr");
            return (Criteria) this;
        }

        public Criteria andIdUrLessThan(Integer value) {
            addCriterion("ID_UR <", value, "idUr");
            return (Criteria) this;
        }

        public Criteria andIdUrLessThanOrEqualTo(Integer value) {
            addCriterion("ID_UR <=", value, "idUr");
            return (Criteria) this;
        }

        public Criteria andIdUrIn(List<Integer> values) {
            addCriterion("ID_UR in", values, "idUr");
            return (Criteria) this;
        }

        public Criteria andIdUrNotIn(List<Integer> values) {
            addCriterion("ID_UR not in", values, "idUr");
            return (Criteria) this;
        }

        public Criteria andIdUrBetween(Integer value1, Integer value2) {
            addCriterion("ID_UR between", value1, value2, "idUr");
            return (Criteria) this;
        }

        public Criteria andIdUrNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_UR not between", value1, value2, "idUr");
            return (Criteria) this;
        }

        public Criteria andApellido1IsNull() {
            addCriterion("APELLIDO1 is null");
            return (Criteria) this;
        }

        public Criteria andApellido1IsNotNull() {
            addCriterion("APELLIDO1 is not null");
            return (Criteria) this;
        }

        public Criteria andApellido1EqualTo(String value) {
            addCriterion("APELLIDO1 =", value, "apellido1");
            return (Criteria) this;
        }

        public Criteria andApellido1NotEqualTo(String value) {
            addCriterion("APELLIDO1 <>", value, "apellido1");
            return (Criteria) this;
        }

        public Criteria andApellido1GreaterThan(String value) {
            addCriterion("APELLIDO1 >", value, "apellido1");
            return (Criteria) this;
        }

        public Criteria andApellido1GreaterThanOrEqualTo(String value) {
            addCriterion("APELLIDO1 >=", value, "apellido1");
            return (Criteria) this;
        }

        public Criteria andApellido1LessThan(String value) {
            addCriterion("APELLIDO1 <", value, "apellido1");
            return (Criteria) this;
        }

        public Criteria andApellido1LessThanOrEqualTo(String value) {
            addCriterion("APELLIDO1 <=", value, "apellido1");
            return (Criteria) this;
        }

        public Criteria andApellido1Like(String value) {
            addCriterion("APELLIDO1 like", value, "apellido1");
            return (Criteria) this;
        }

        public Criteria andApellido1NotLike(String value) {
            addCriterion("APELLIDO1 not like", value, "apellido1");
            return (Criteria) this;
        }

        public Criteria andApellido1In(List<String> values) {
            addCriterion("APELLIDO1 in", values, "apellido1");
            return (Criteria) this;
        }

        public Criteria andApellido1NotIn(List<String> values) {
            addCriterion("APELLIDO1 not in", values, "apellido1");
            return (Criteria) this;
        }

        public Criteria andApellido1Between(String value1, String value2) {
            addCriterion("APELLIDO1 between", value1, value2, "apellido1");
            return (Criteria) this;
        }

        public Criteria andApellido1NotBetween(String value1, String value2) {
            addCriterion("APELLIDO1 not between", value1, value2, "apellido1");
            return (Criteria) this;
        }

        public Criteria andApellido2IsNull() {
            addCriterion("APELLIDO2 is null");
            return (Criteria) this;
        }

        public Criteria andApellido2IsNotNull() {
            addCriterion("APELLIDO2 is not null");
            return (Criteria) this;
        }

        public Criteria andApellido2EqualTo(String value) {
            addCriterion("APELLIDO2 =", value, "apellido2");
            return (Criteria) this;
        }

        public Criteria andApellido2NotEqualTo(String value) {
            addCriterion("APELLIDO2 <>", value, "apellido2");
            return (Criteria) this;
        }

        public Criteria andApellido2GreaterThan(String value) {
            addCriterion("APELLIDO2 >", value, "apellido2");
            return (Criteria) this;
        }

        public Criteria andApellido2GreaterThanOrEqualTo(String value) {
            addCriterion("APELLIDO2 >=", value, "apellido2");
            return (Criteria) this;
        }

        public Criteria andApellido2LessThan(String value) {
            addCriterion("APELLIDO2 <", value, "apellido2");
            return (Criteria) this;
        }

        public Criteria andApellido2LessThanOrEqualTo(String value) {
            addCriterion("APELLIDO2 <=", value, "apellido2");
            return (Criteria) this;
        }

        public Criteria andApellido2Like(String value) {
            addCriterion("APELLIDO2 like", value, "apellido2");
            return (Criteria) this;
        }

        public Criteria andApellido2NotLike(String value) {
            addCriterion("APELLIDO2 not like", value, "apellido2");
            return (Criteria) this;
        }

        public Criteria andApellido2In(List<String> values) {
            addCriterion("APELLIDO2 in", values, "apellido2");
            return (Criteria) this;
        }

        public Criteria andApellido2NotIn(List<String> values) {
            addCriterion("APELLIDO2 not in", values, "apellido2");
            return (Criteria) this;
        }

        public Criteria andApellido2Between(String value1, String value2) {
            addCriterion("APELLIDO2 between", value1, value2, "apellido2");
            return (Criteria) this;
        }

        public Criteria andApellido2NotBetween(String value1, String value2) {
            addCriterion("APELLIDO2 not between", value1, value2, "apellido2");
            return (Criteria) this;
        }

        public Criteria andNombreIsNull() {
            addCriterion("NOMBRE is null");
            return (Criteria) this;
        }

        public Criteria andNombreIsNotNull() {
            addCriterion("NOMBRE is not null");
            return (Criteria) this;
        }

        public Criteria andNombreEqualTo(String value) {
            addCriterion("NOMBRE =", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotEqualTo(String value) {
            addCriterion("NOMBRE <>", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThan(String value) {
            addCriterion("NOMBRE >", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThanOrEqualTo(String value) {
            addCriterion("NOMBRE >=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThan(String value) {
            addCriterion("NOMBRE <", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThanOrEqualTo(String value) {
            addCriterion("NOMBRE <=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLike(String value) {
            addCriterion("NOMBRE like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotLike(String value) {
            addCriterion("NOMBRE not like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreIn(List<String> values) {
            addCriterion("NOMBRE in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotIn(List<String> values) {
            addCriterion("NOMBRE not in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreBetween(String value1, String value2) {
            addCriterion("NOMBRE between", value1, value2, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotBetween(String value1, String value2) {
            addCriterion("NOMBRE not between", value1, value2, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreUsuIsNull() {
            addCriterion("NOMBRE_USU is null");
            return (Criteria) this;
        }

        public Criteria andNombreUsuIsNotNull() {
            addCriterion("NOMBRE_USU is not null");
            return (Criteria) this;
        }

        public Criteria andNombreUsuEqualTo(String value) {
            addCriterion("NOMBRE_USU =", value, "nombreUsu");
            return (Criteria) this;
        }

        public Criteria andNombreUsuNotEqualTo(String value) {
            addCriterion("NOMBRE_USU <>", value, "nombreUsu");
            return (Criteria) this;
        }

        public Criteria andNombreUsuGreaterThan(String value) {
            addCriterion("NOMBRE_USU >", value, "nombreUsu");
            return (Criteria) this;
        }

        public Criteria andNombreUsuGreaterThanOrEqualTo(String value) {
            addCriterion("NOMBRE_USU >=", value, "nombreUsu");
            return (Criteria) this;
        }

        public Criteria andNombreUsuLessThan(String value) {
            addCriterion("NOMBRE_USU <", value, "nombreUsu");
            return (Criteria) this;
        }

        public Criteria andNombreUsuLessThanOrEqualTo(String value) {
            addCriterion("NOMBRE_USU <=", value, "nombreUsu");
            return (Criteria) this;
        }

        public Criteria andNombreUsuLike(String value) {
            addCriterion("NOMBRE_USU like", value, "nombreUsu");
            return (Criteria) this;
        }

        public Criteria andNombreUsuNotLike(String value) {
            addCriterion("NOMBRE_USU not like", value, "nombreUsu");
            return (Criteria) this;
        }

        public Criteria andNombreUsuIn(List<String> values) {
            addCriterion("NOMBRE_USU in", values, "nombreUsu");
            return (Criteria) this;
        }

        public Criteria andNombreUsuNotIn(List<String> values) {
            addCriterion("NOMBRE_USU not in", values, "nombreUsu");
            return (Criteria) this;
        }

        public Criteria andNombreUsuBetween(String value1, String value2) {
            addCriterion("NOMBRE_USU between", value1, value2, "nombreUsu");
            return (Criteria) this;
        }

        public Criteria andNombreUsuNotBetween(String value1, String value2) {
            addCriterion("NOMBRE_USU not between", value1, value2, "nombreUsu");
            return (Criteria) this;
        }

        public Criteria andContrasenaIsNull() {
            addCriterion("CONTRASENA is null");
            return (Criteria) this;
        }

        public Criteria andContrasenaIsNotNull() {
            addCriterion("CONTRASENA is not null");
            return (Criteria) this;
        }

        public Criteria andContrasenaEqualTo(String value) {
            addCriterion("CONTRASENA =", value, "contrasena");
            return (Criteria) this;
        }

        public Criteria andContrasenaNotEqualTo(String value) {
            addCriterion("CONTRASENA <>", value, "contrasena");
            return (Criteria) this;
        }

        public Criteria andContrasenaGreaterThan(String value) {
            addCriterion("CONTRASENA >", value, "contrasena");
            return (Criteria) this;
        }

        public Criteria andContrasenaGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRASENA >=", value, "contrasena");
            return (Criteria) this;
        }

        public Criteria andContrasenaLessThan(String value) {
            addCriterion("CONTRASENA <", value, "contrasena");
            return (Criteria) this;
        }

        public Criteria andContrasenaLessThanOrEqualTo(String value) {
            addCriterion("CONTRASENA <=", value, "contrasena");
            return (Criteria) this;
        }

        public Criteria andContrasenaLike(String value) {
            addCriterion("CONTRASENA like", value, "contrasena");
            return (Criteria) this;
        }

        public Criteria andContrasenaNotLike(String value) {
            addCriterion("CONTRASENA not like", value, "contrasena");
            return (Criteria) this;
        }

        public Criteria andContrasenaIn(List<String> values) {
            addCriterion("CONTRASENA in", values, "contrasena");
            return (Criteria) this;
        }

        public Criteria andContrasenaNotIn(List<String> values) {
            addCriterion("CONTRASENA not in", values, "contrasena");
            return (Criteria) this;
        }

        public Criteria andContrasenaBetween(String value1, String value2) {
            addCriterion("CONTRASENA between", value1, value2, "contrasena");
            return (Criteria) this;
        }

        public Criteria andContrasenaNotBetween(String value1, String value2) {
            addCriterion("CONTRASENA not between", value1, value2, "contrasena");
            return (Criteria) this;
        }

        public Criteria andActivoIsNull() {
            addCriterion("ACTIVO is null");
            return (Criteria) this;
        }

        public Criteria andActivoIsNotNull() {
            addCriterion("ACTIVO is not null");
            return (Criteria) this;
        }

        public Criteria andActivoEqualTo(Short value) {
            addCriterion("ACTIVO =", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoNotEqualTo(Short value) {
            addCriterion("ACTIVO <>", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoGreaterThan(Short value) {
            addCriterion("ACTIVO >", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoGreaterThanOrEqualTo(Short value) {
            addCriterion("ACTIVO >=", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoLessThan(Short value) {
            addCriterion("ACTIVO <", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoLessThanOrEqualTo(Short value) {
            addCriterion("ACTIVO <=", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoIn(List<Short> values) {
            addCriterion("ACTIVO in", values, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoNotIn(List<Short> values) {
            addCriterion("ACTIVO not in", values, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoBetween(Short value1, Short value2) {
            addCriterion("ACTIVO between", value1, value2, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoNotBetween(Short value1, Short value2) {
            addCriterion("ACTIVO not between", value1, value2, "activo");
            return (Criteria) this;
        }

        public Criteria andCurpIsNull() {
            addCriterion("CURP is null");
            return (Criteria) this;
        }

        public Criteria andCurpIsNotNull() {
            addCriterion("CURP is not null");
            return (Criteria) this;
        }

        public Criteria andCurpEqualTo(String value) {
            addCriterion("CURP =", value, "curp");
            return (Criteria) this;
        }

        public Criteria andCurpNotEqualTo(String value) {
            addCriterion("CURP <>", value, "curp");
            return (Criteria) this;
        }

        public Criteria andCurpGreaterThan(String value) {
            addCriterion("CURP >", value, "curp");
            return (Criteria) this;
        }

        public Criteria andCurpGreaterThanOrEqualTo(String value) {
            addCriterion("CURP >=", value, "curp");
            return (Criteria) this;
        }

        public Criteria andCurpLessThan(String value) {
            addCriterion("CURP <", value, "curp");
            return (Criteria) this;
        }

        public Criteria andCurpLessThanOrEqualTo(String value) {
            addCriterion("CURP <=", value, "curp");
            return (Criteria) this;
        }

        public Criteria andCurpLike(String value) {
            addCriterion("CURP like", value, "curp");
            return (Criteria) this;
        }

        public Criteria andCurpNotLike(String value) {
            addCriterion("CURP not like", value, "curp");
            return (Criteria) this;
        }

        public Criteria andCurpIn(List<String> values) {
            addCriterion("CURP in", values, "curp");
            return (Criteria) this;
        }

        public Criteria andCurpNotIn(List<String> values) {
            addCriterion("CURP not in", values, "curp");
            return (Criteria) this;
        }

        public Criteria andCurpBetween(String value1, String value2) {
            addCriterion("CURP between", value1, value2, "curp");
            return (Criteria) this;
        }

        public Criteria andCurpNotBetween(String value1, String value2) {
            addCriterion("CURP not between", value1, value2, "curp");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}