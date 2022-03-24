package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tses011VisitantesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses011VisitantesExample() {
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

        public Criteria andIdVisitanteIsNull() {
            addCriterion("ID_VISITANTE is null");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteIsNotNull() {
            addCriterion("ID_VISITANTE is not null");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteEqualTo(Long value) {
            addCriterion("ID_VISITANTE =", value, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteNotEqualTo(Long value) {
            addCriterion("ID_VISITANTE <>", value, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteGreaterThan(Long value) {
            addCriterion("ID_VISITANTE >", value, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_VISITANTE >=", value, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteLessThan(Long value) {
            addCriterion("ID_VISITANTE <", value, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteLessThanOrEqualTo(Long value) {
            addCriterion("ID_VISITANTE <=", value, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteIn(List<Long> values) {
            addCriterion("ID_VISITANTE in", values, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteNotIn(List<Long> values) {
            addCriterion("ID_VISITANTE not in", values, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteBetween(Long value1, Long value2) {
            addCriterion("ID_VISITANTE between", value1, value2, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteNotBetween(Long value1, Long value2) {
            addCriterion("ID_VISITANTE not between", value1, value2, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdEtiquetaIsNull() {
            addCriterion("ID_ETIQUETA is null");
            return (Criteria) this;
        }

        public Criteria andIdEtiquetaIsNotNull() {
            addCriterion("ID_ETIQUETA is not null");
            return (Criteria) this;
        }

        public Criteria andIdEtiquetaEqualTo(Long value) {
            addCriterion("ID_ETIQUETA =", value, "idEtiqueta");
            return (Criteria) this;
        }

        public Criteria andIdEtiquetaNotEqualTo(Long value) {
            addCriterion("ID_ETIQUETA <>", value, "idEtiqueta");
            return (Criteria) this;
        }

        public Criteria andIdEtiquetaGreaterThan(Long value) {
            addCriterion("ID_ETIQUETA >", value, "idEtiqueta");
            return (Criteria) this;
        }

        public Criteria andIdEtiquetaGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_ETIQUETA >=", value, "idEtiqueta");
            return (Criteria) this;
        }

        public Criteria andIdEtiquetaLessThan(Long value) {
            addCriterion("ID_ETIQUETA <", value, "idEtiqueta");
            return (Criteria) this;
        }

        public Criteria andIdEtiquetaLessThanOrEqualTo(Long value) {
            addCriterion("ID_ETIQUETA <=", value, "idEtiqueta");
            return (Criteria) this;
        }

        public Criteria andIdEtiquetaIn(List<Long> values) {
            addCriterion("ID_ETIQUETA in", values, "idEtiqueta");
            return (Criteria) this;
        }

        public Criteria andIdEtiquetaNotIn(List<Long> values) {
            addCriterion("ID_ETIQUETA not in", values, "idEtiqueta");
            return (Criteria) this;
        }

        public Criteria andIdEtiquetaBetween(Long value1, Long value2) {
            addCriterion("ID_ETIQUETA between", value1, value2, "idEtiqueta");
            return (Criteria) this;
        }

        public Criteria andIdEtiquetaNotBetween(Long value1, Long value2) {
            addCriterion("ID_ETIQUETA not between", value1, value2, "idEtiqueta");
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

        public Criteria andPersonaVisitaIsNull() {
            addCriterion("PERSONA_VISITA is null");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaIsNotNull() {
            addCriterion("PERSONA_VISITA is not null");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaEqualTo(String value) {
            addCriterion("PERSONA_VISITA =", value, "personaVisita");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaNotEqualTo(String value) {
            addCriterion("PERSONA_VISITA <>", value, "personaVisita");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaGreaterThan(String value) {
            addCriterion("PERSONA_VISITA >", value, "personaVisita");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaGreaterThanOrEqualTo(String value) {
            addCriterion("PERSONA_VISITA >=", value, "personaVisita");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaLessThan(String value) {
            addCriterion("PERSONA_VISITA <", value, "personaVisita");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaLessThanOrEqualTo(String value) {
            addCriterion("PERSONA_VISITA <=", value, "personaVisita");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaLike(String value) {
            addCriterion("PERSONA_VISITA like", value, "personaVisita");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaNotLike(String value) {
            addCriterion("PERSONA_VISITA not like", value, "personaVisita");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaIn(List<String> values) {
            addCriterion("PERSONA_VISITA in", values, "personaVisita");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaNotIn(List<String> values) {
            addCriterion("PERSONA_VISITA not in", values, "personaVisita");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaBetween(String value1, String value2) {
            addCriterion("PERSONA_VISITA between", value1, value2, "personaVisita");
            return (Criteria) this;
        }

        public Criteria andPersonaVisitaNotBetween(String value1, String value2) {
            addCriterion("PERSONA_VISITA not between", value1, value2, "personaVisita");
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