package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tses004PersonasExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses004PersonasExample() {
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

        public Criteria andIdPersonaIsNull() {
            addCriterion("ID_PERSONA is null");
            return (Criteria) this;
        }

        public Criteria andIdPersonaIsNotNull() {
            addCriterion("ID_PERSONA is not null");
            return (Criteria) this;
        }

        public Criteria andIdPersonaEqualTo(Integer value) {
            addCriterion("ID_PERSONA =", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaNotEqualTo(Integer value) {
            addCriterion("ID_PERSONA <>", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaGreaterThan(Integer value) {
            addCriterion("ID_PERSONA >", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_PERSONA >=", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaLessThan(Integer value) {
            addCriterion("ID_PERSONA <", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaLessThanOrEqualTo(Integer value) {
            addCriterion("ID_PERSONA <=", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaIn(List<Integer> values) {
            addCriterion("ID_PERSONA in", values, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaNotIn(List<Integer> values) {
            addCriterion("ID_PERSONA not in", values, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaBetween(Integer value1, Integer value2) {
            addCriterion("ID_PERSONA between", value1, value2, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_PERSONA not between", value1, value2, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdTipoPersonaIsNull() {
            addCriterion("ID_TIPO_PERSONA is null");
            return (Criteria) this;
        }

        public Criteria andIdTipoPersonaIsNotNull() {
            addCriterion("ID_TIPO_PERSONA is not null");
            return (Criteria) this;
        }

        public Criteria andIdTipoPersonaEqualTo(Integer value) {
            addCriterion("ID_TIPO_PERSONA =", value, "idTipoPersona");
            return (Criteria) this;
        }

        public Criteria andIdTipoPersonaNotEqualTo(Integer value) {
            addCriterion("ID_TIPO_PERSONA <>", value, "idTipoPersona");
            return (Criteria) this;
        }

        public Criteria andIdTipoPersonaGreaterThan(Integer value) {
            addCriterion("ID_TIPO_PERSONA >", value, "idTipoPersona");
            return (Criteria) this;
        }

        public Criteria andIdTipoPersonaGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_TIPO_PERSONA >=", value, "idTipoPersona");
            return (Criteria) this;
        }

        public Criteria andIdTipoPersonaLessThan(Integer value) {
            addCriterion("ID_TIPO_PERSONA <", value, "idTipoPersona");
            return (Criteria) this;
        }

        public Criteria andIdTipoPersonaLessThanOrEqualTo(Integer value) {
            addCriterion("ID_TIPO_PERSONA <=", value, "idTipoPersona");
            return (Criteria) this;
        }

        public Criteria andIdTipoPersonaIn(List<Integer> values) {
            addCriterion("ID_TIPO_PERSONA in", values, "idTipoPersona");
            return (Criteria) this;
        }

        public Criteria andIdTipoPersonaNotIn(List<Integer> values) {
            addCriterion("ID_TIPO_PERSONA not in", values, "idTipoPersona");
            return (Criteria) this;
        }

        public Criteria andIdTipoPersonaBetween(Integer value1, Integer value2) {
            addCriterion("ID_TIPO_PERSONA between", value1, value2, "idTipoPersona");
            return (Criteria) this;
        }

        public Criteria andIdTipoPersonaNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_TIPO_PERSONA not between", value1, value2, "idTipoPersona");
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

        public Criteria andIdTipoSangreIsNull() {
            addCriterion("ID_TIPO_SANGRE is null");
            return (Criteria) this;
        }

        public Criteria andIdTipoSangreIsNotNull() {
            addCriterion("ID_TIPO_SANGRE is not null");
            return (Criteria) this;
        }

        public Criteria andIdTipoSangreEqualTo(Integer value) {
            addCriterion("ID_TIPO_SANGRE =", value, "idTipoSangre");
            return (Criteria) this;
        }

        public Criteria andIdTipoSangreNotEqualTo(Integer value) {
            addCriterion("ID_TIPO_SANGRE <>", value, "idTipoSangre");
            return (Criteria) this;
        }

        public Criteria andIdTipoSangreGreaterThan(Integer value) {
            addCriterion("ID_TIPO_SANGRE >", value, "idTipoSangre");
            return (Criteria) this;
        }

        public Criteria andIdTipoSangreGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_TIPO_SANGRE >=", value, "idTipoSangre");
            return (Criteria) this;
        }

        public Criteria andIdTipoSangreLessThan(Integer value) {
            addCriterion("ID_TIPO_SANGRE <", value, "idTipoSangre");
            return (Criteria) this;
        }

        public Criteria andIdTipoSangreLessThanOrEqualTo(Integer value) {
            addCriterion("ID_TIPO_SANGRE <=", value, "idTipoSangre");
            return (Criteria) this;
        }

        public Criteria andIdTipoSangreIn(List<Integer> values) {
            addCriterion("ID_TIPO_SANGRE in", values, "idTipoSangre");
            return (Criteria) this;
        }

        public Criteria andIdTipoSangreNotIn(List<Integer> values) {
            addCriterion("ID_TIPO_SANGRE not in", values, "idTipoSangre");
            return (Criteria) this;
        }

        public Criteria andIdTipoSangreBetween(Integer value1, Integer value2) {
            addCriterion("ID_TIPO_SANGRE between", value1, value2, "idTipoSangre");
            return (Criteria) this;
        }

        public Criteria andIdTipoSangreNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_TIPO_SANGRE not between", value1, value2, "idTipoSangre");
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

        public Criteria andIdCuadranteAreaIsNull() {
            addCriterion("ID_CUADRANTE_AREA is null");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaIsNotNull() {
            addCriterion("ID_CUADRANTE_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaEqualTo(Integer value) {
            addCriterion("ID_CUADRANTE_AREA =", value, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaNotEqualTo(Integer value) {
            addCriterion("ID_CUADRANTE_AREA <>", value, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaGreaterThan(Integer value) {
            addCriterion("ID_CUADRANTE_AREA >", value, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_CUADRANTE_AREA >=", value, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaLessThan(Integer value) {
            addCriterion("ID_CUADRANTE_AREA <", value, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaLessThanOrEqualTo(Integer value) {
            addCriterion("ID_CUADRANTE_AREA <=", value, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaIn(List<Integer> values) {
            addCriterion("ID_CUADRANTE_AREA in", values, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaNotIn(List<Integer> values) {
            addCriterion("ID_CUADRANTE_AREA not in", values, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaBetween(Integer value1, Integer value2) {
            addCriterion("ID_CUADRANTE_AREA between", value1, value2, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_CUADRANTE_AREA not between", value1, value2, "idCuadranteArea");
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

        public Criteria andPuestoIsNull() {
            addCriterion("PUESTO is null");
            return (Criteria) this;
        }

        public Criteria andPuestoIsNotNull() {
            addCriterion("PUESTO is not null");
            return (Criteria) this;
        }

        public Criteria andPuestoEqualTo(String value) {
            addCriterion("PUESTO =", value, "puesto");
            return (Criteria) this;
        }

        public Criteria andPuestoNotEqualTo(String value) {
            addCriterion("PUESTO <>", value, "puesto");
            return (Criteria) this;
        }

        public Criteria andPuestoGreaterThan(String value) {
            addCriterion("PUESTO >", value, "puesto");
            return (Criteria) this;
        }

        public Criteria andPuestoGreaterThanOrEqualTo(String value) {
            addCriterion("PUESTO >=", value, "puesto");
            return (Criteria) this;
        }

        public Criteria andPuestoLessThan(String value) {
            addCriterion("PUESTO <", value, "puesto");
            return (Criteria) this;
        }

        public Criteria andPuestoLessThanOrEqualTo(String value) {
            addCriterion("PUESTO <=", value, "puesto");
            return (Criteria) this;
        }

        public Criteria andPuestoLike(String value) {
            addCriterion("PUESTO like", value, "puesto");
            return (Criteria) this;
        }

        public Criteria andPuestoNotLike(String value) {
            addCriterion("PUESTO not like", value, "puesto");
            return (Criteria) this;
        }

        public Criteria andPuestoIn(List<String> values) {
            addCriterion("PUESTO in", values, "puesto");
            return (Criteria) this;
        }

        public Criteria andPuestoNotIn(List<String> values) {
            addCriterion("PUESTO not in", values, "puesto");
            return (Criteria) this;
        }

        public Criteria andPuestoBetween(String value1, String value2) {
            addCriterion("PUESTO between", value1, value2, "puesto");
            return (Criteria) this;
        }

        public Criteria andPuestoNotBetween(String value1, String value2) {
            addCriterion("PUESTO not between", value1, value2, "puesto");
            return (Criteria) this;
        }

        public Criteria andAlergiasIsNull() {
            addCriterion("ALERGIAS is null");
            return (Criteria) this;
        }

        public Criteria andAlergiasIsNotNull() {
            addCriterion("ALERGIAS is not null");
            return (Criteria) this;
        }

        public Criteria andAlergiasEqualTo(String value) {
            addCriterion("ALERGIAS =", value, "alergias");
            return (Criteria) this;
        }

        public Criteria andAlergiasNotEqualTo(String value) {
            addCriterion("ALERGIAS <>", value, "alergias");
            return (Criteria) this;
        }

        public Criteria andAlergiasGreaterThan(String value) {
            addCriterion("ALERGIAS >", value, "alergias");
            return (Criteria) this;
        }

        public Criteria andAlergiasGreaterThanOrEqualTo(String value) {
            addCriterion("ALERGIAS >=", value, "alergias");
            return (Criteria) this;
        }

        public Criteria andAlergiasLessThan(String value) {
            addCriterion("ALERGIAS <", value, "alergias");
            return (Criteria) this;
        }

        public Criteria andAlergiasLessThanOrEqualTo(String value) {
            addCriterion("ALERGIAS <=", value, "alergias");
            return (Criteria) this;
        }

        public Criteria andAlergiasLike(String value) {
            addCriterion("ALERGIAS like", value, "alergias");
            return (Criteria) this;
        }

        public Criteria andAlergiasNotLike(String value) {
            addCriterion("ALERGIAS not like", value, "alergias");
            return (Criteria) this;
        }

        public Criteria andAlergiasIn(List<String> values) {
            addCriterion("ALERGIAS in", values, "alergias");
            return (Criteria) this;
        }

        public Criteria andAlergiasNotIn(List<String> values) {
            addCriterion("ALERGIAS not in", values, "alergias");
            return (Criteria) this;
        }

        public Criteria andAlergiasBetween(String value1, String value2) {
            addCriterion("ALERGIAS between", value1, value2, "alergias");
            return (Criteria) this;
        }

        public Criteria andAlergiasNotBetween(String value1, String value2) {
            addCriterion("ALERGIAS not between", value1, value2, "alergias");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaIsNull() {
            addCriterion("TEL_EMERGENCIA is null");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaIsNotNull() {
            addCriterion("TEL_EMERGENCIA is not null");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaEqualTo(String value) {
            addCriterion("TEL_EMERGENCIA =", value, "telEmergencia");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaNotEqualTo(String value) {
            addCriterion("TEL_EMERGENCIA <>", value, "telEmergencia");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaGreaterThan(String value) {
            addCriterion("TEL_EMERGENCIA >", value, "telEmergencia");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaGreaterThanOrEqualTo(String value) {
            addCriterion("TEL_EMERGENCIA >=", value, "telEmergencia");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaLessThan(String value) {
            addCriterion("TEL_EMERGENCIA <", value, "telEmergencia");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaLessThanOrEqualTo(String value) {
            addCriterion("TEL_EMERGENCIA <=", value, "telEmergencia");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaLike(String value) {
            addCriterion("TEL_EMERGENCIA like", value, "telEmergencia");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaNotLike(String value) {
            addCriterion("TEL_EMERGENCIA not like", value, "telEmergencia");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaIn(List<String> values) {
            addCriterion("TEL_EMERGENCIA in", values, "telEmergencia");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaNotIn(List<String> values) {
            addCriterion("TEL_EMERGENCIA not in", values, "telEmergencia");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaBetween(String value1, String value2) {
            addCriterion("TEL_EMERGENCIA between", value1, value2, "telEmergencia");
            return (Criteria) this;
        }

        public Criteria andTelEmergenciaNotBetween(String value1, String value2) {
            addCriterion("TEL_EMERGENCIA not between", value1, value2, "telEmergencia");
            return (Criteria) this;
        }

        public Criteria andEnfermedadIsNull() {
            addCriterion("ENFERMEDAD is null");
            return (Criteria) this;
        }

        public Criteria andEnfermedadIsNotNull() {
            addCriterion("ENFERMEDAD is not null");
            return (Criteria) this;
        }

        public Criteria andEnfermedadEqualTo(String value) {
            addCriterion("ENFERMEDAD =", value, "enfermedad");
            return (Criteria) this;
        }

        public Criteria andEnfermedadNotEqualTo(String value) {
            addCriterion("ENFERMEDAD <>", value, "enfermedad");
            return (Criteria) this;
        }

        public Criteria andEnfermedadGreaterThan(String value) {
            addCriterion("ENFERMEDAD >", value, "enfermedad");
            return (Criteria) this;
        }

        public Criteria andEnfermedadGreaterThanOrEqualTo(String value) {
            addCriterion("ENFERMEDAD >=", value, "enfermedad");
            return (Criteria) this;
        }

        public Criteria andEnfermedadLessThan(String value) {
            addCriterion("ENFERMEDAD <", value, "enfermedad");
            return (Criteria) this;
        }

        public Criteria andEnfermedadLessThanOrEqualTo(String value) {
            addCriterion("ENFERMEDAD <=", value, "enfermedad");
            return (Criteria) this;
        }

        public Criteria andEnfermedadLike(String value) {
            addCriterion("ENFERMEDAD like", value, "enfermedad");
            return (Criteria) this;
        }

        public Criteria andEnfermedadNotLike(String value) {
            addCriterion("ENFERMEDAD not like", value, "enfermedad");
            return (Criteria) this;
        }

        public Criteria andEnfermedadIn(List<String> values) {
            addCriterion("ENFERMEDAD in", values, "enfermedad");
            return (Criteria) this;
        }

        public Criteria andEnfermedadNotIn(List<String> values) {
            addCriterion("ENFERMEDAD not in", values, "enfermedad");
            return (Criteria) this;
        }

        public Criteria andEnfermedadBetween(String value1, String value2) {
            addCriterion("ENFERMEDAD between", value1, value2, "enfermedad");
            return (Criteria) this;
        }

        public Criteria andEnfermedadNotBetween(String value1, String value2) {
            addCriterion("ENFERMEDAD not between", value1, value2, "enfermedad");
            return (Criteria) this;
        }

        public Criteria andFechaActualizacionIsNull() {
            addCriterion("FECHA_ACTUALIZACION is null");
            return (Criteria) this;
        }

        public Criteria andFechaActualizacionIsNotNull() {
            addCriterion("FECHA_ACTUALIZACION is not null");
            return (Criteria) this;
        }

        public Criteria andFechaActualizacionEqualTo(Date value) {
            addCriterion("FECHA_ACTUALIZACION =", value, "fechaActualizacion");
            return (Criteria) this;
        }

        public Criteria andFechaActualizacionNotEqualTo(Date value) {
            addCriterion("FECHA_ACTUALIZACION <>", value, "fechaActualizacion");
            return (Criteria) this;
        }

        public Criteria andFechaActualizacionGreaterThan(Date value) {
            addCriterion("FECHA_ACTUALIZACION >", value, "fechaActualizacion");
            return (Criteria) this;
        }

        public Criteria andFechaActualizacionGreaterThanOrEqualTo(Date value) {
            addCriterion("FECHA_ACTUALIZACION >=", value, "fechaActualizacion");
            return (Criteria) this;
        }

        public Criteria andFechaActualizacionLessThan(Date value) {
            addCriterion("FECHA_ACTUALIZACION <", value, "fechaActualizacion");
            return (Criteria) this;
        }

        public Criteria andFechaActualizacionLessThanOrEqualTo(Date value) {
            addCriterion("FECHA_ACTUALIZACION <=", value, "fechaActualizacion");
            return (Criteria) this;
        }

        public Criteria andFechaActualizacionIn(List<Date> values) {
            addCriterion("FECHA_ACTUALIZACION in", values, "fechaActualizacion");
            return (Criteria) this;
        }

        public Criteria andFechaActualizacionNotIn(List<Date> values) {
            addCriterion("FECHA_ACTUALIZACION not in", values, "fechaActualizacion");
            return (Criteria) this;
        }

        public Criteria andFechaActualizacionBetween(Date value1, Date value2) {
            addCriterion("FECHA_ACTUALIZACION between", value1, value2, "fechaActualizacion");
            return (Criteria) this;
        }

        public Criteria andFechaActualizacionNotBetween(Date value1, Date value2) {
            addCriterion("FECHA_ACTUALIZACION not between", value1, value2, "fechaActualizacion");
            return (Criteria) this;
        }

        public Criteria andEstatusIsNull() {
            addCriterion("ESTATUS is null");
            return (Criteria) this;
        }

        public Criteria andEstatusIsNotNull() {
            addCriterion("ESTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andEstatusEqualTo(Short value) {
            addCriterion("ESTATUS =", value, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusNotEqualTo(Short value) {
            addCriterion("ESTATUS <>", value, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusGreaterThan(Short value) {
            addCriterion("ESTATUS >", value, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusGreaterThanOrEqualTo(Short value) {
            addCriterion("ESTATUS >=", value, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusLessThan(Short value) {
            addCriterion("ESTATUS <", value, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusLessThanOrEqualTo(Short value) {
            addCriterion("ESTATUS <=", value, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusIn(List<Short> values) {
            addCriterion("ESTATUS in", values, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusNotIn(List<Short> values) {
            addCriterion("ESTATUS not in", values, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusBetween(Short value1, Short value2) {
            addCriterion("ESTATUS between", value1, value2, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusNotBetween(Short value1, Short value2) {
            addCriterion("ESTATUS not between", value1, value2, "estatus");
            return (Criteria) this;
        }

        public Criteria andCorreoIsNull() {
            addCriterion("CORREO is null");
            return (Criteria) this;
        }

        public Criteria andCorreoIsNotNull() {
            addCriterion("CORREO is not null");
            return (Criteria) this;
        }

        public Criteria andCorreoEqualTo(String value) {
            addCriterion("CORREO =", value, "correo");
            return (Criteria) this;
        }

        public Criteria andCorreoNotEqualTo(String value) {
            addCriterion("CORREO <>", value, "correo");
            return (Criteria) this;
        }

        public Criteria andCorreoGreaterThan(String value) {
            addCriterion("CORREO >", value, "correo");
            return (Criteria) this;
        }

        public Criteria andCorreoGreaterThanOrEqualTo(String value) {
            addCriterion("CORREO >=", value, "correo");
            return (Criteria) this;
        }

        public Criteria andCorreoLessThan(String value) {
            addCriterion("CORREO <", value, "correo");
            return (Criteria) this;
        }

        public Criteria andCorreoLessThanOrEqualTo(String value) {
            addCriterion("CORREO <=", value, "correo");
            return (Criteria) this;
        }

        public Criteria andCorreoLike(String value) {
            addCriterion("CORREO like", value, "correo");
            return (Criteria) this;
        }

        public Criteria andCorreoNotLike(String value) {
            addCriterion("CORREO not like", value, "correo");
            return (Criteria) this;
        }

        public Criteria andCorreoIn(List<String> values) {
            addCriterion("CORREO in", values, "correo");
            return (Criteria) this;
        }

        public Criteria andCorreoNotIn(List<String> values) {
            addCriterion("CORREO not in", values, "correo");
            return (Criteria) this;
        }

        public Criteria andCorreoBetween(String value1, String value2) {
            addCriterion("CORREO between", value1, value2, "correo");
            return (Criteria) this;
        }

        public Criteria andCorreoNotBetween(String value1, String value2) {
            addCriterion("CORREO not between", value1, value2, "correo");
            return (Criteria) this;
        }

        public Criteria andRfcIsNull() {
            addCriterion("RFC is null");
            return (Criteria) this;
        }

        public Criteria andRfcIsNotNull() {
            addCriterion("RFC is not null");
            return (Criteria) this;
        }

        public Criteria andRfcEqualTo(String value) {
            addCriterion("RFC =", value, "rfc");
            return (Criteria) this;
        }

        public Criteria andRfcNotEqualTo(String value) {
            addCriterion("RFC <>", value, "rfc");
            return (Criteria) this;
        }

        public Criteria andRfcGreaterThan(String value) {
            addCriterion("RFC >", value, "rfc");
            return (Criteria) this;
        }

        public Criteria andRfcGreaterThanOrEqualTo(String value) {
            addCriterion("RFC >=", value, "rfc");
            return (Criteria) this;
        }

        public Criteria andRfcLessThan(String value) {
            addCriterion("RFC <", value, "rfc");
            return (Criteria) this;
        }

        public Criteria andRfcLessThanOrEqualTo(String value) {
            addCriterion("RFC <=", value, "rfc");
            return (Criteria) this;
        }

        public Criteria andRfcLike(String value) {
            addCriterion("RFC like", value, "rfc");
            return (Criteria) this;
        }

        public Criteria andRfcNotLike(String value) {
            addCriterion("RFC not like", value, "rfc");
            return (Criteria) this;
        }

        public Criteria andRfcIn(List<String> values) {
            addCriterion("RFC in", values, "rfc");
            return (Criteria) this;
        }

        public Criteria andRfcNotIn(List<String> values) {
            addCriterion("RFC not in", values, "rfc");
            return (Criteria) this;
        }

        public Criteria andRfcBetween(String value1, String value2) {
            addCriterion("RFC between", value1, value2, "rfc");
            return (Criteria) this;
        }

        public Criteria andRfcNotBetween(String value1, String value2) {
            addCriterion("RFC not between", value1, value2, "rfc");
            return (Criteria) this;
        }

        public Criteria andIdAreaIsNull() {
            addCriterion("ID_AREA is null");
            return (Criteria) this;
        }

        public Criteria andIdAreaIsNotNull() {
            addCriterion("ID_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andIdAreaEqualTo(Integer value) {
            addCriterion("ID_AREA =", value, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaNotEqualTo(Integer value) {
            addCriterion("ID_AREA <>", value, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaGreaterThan(Integer value) {
            addCriterion("ID_AREA >", value, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_AREA >=", value, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaLessThan(Integer value) {
            addCriterion("ID_AREA <", value, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaLessThanOrEqualTo(Integer value) {
            addCriterion("ID_AREA <=", value, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaIn(List<Integer> values) {
            addCriterion("ID_AREA in", values, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaNotIn(List<Integer> values) {
            addCriterion("ID_AREA not in", values, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaBetween(Integer value1, Integer value2) {
            addCriterion("ID_AREA between", value1, value2, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_AREA not between", value1, value2, "idArea");
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