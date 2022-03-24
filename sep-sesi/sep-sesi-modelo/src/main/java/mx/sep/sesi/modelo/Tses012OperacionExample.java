package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tses012OperacionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses012OperacionExample() {
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

        public Criteria andIdRegistroIsNull() {
            addCriterion("ID_REGISTRO is null");
            return (Criteria) this;
        }

        public Criteria andIdRegistroIsNotNull() {
            addCriterion("ID_REGISTRO is not null");
            return (Criteria) this;
        }

        public Criteria andIdRegistroEqualTo(Long value) {
            addCriterion("ID_REGISTRO =", value, "idRegistro");
            return (Criteria) this;
        }

        public Criteria andIdRegistroNotEqualTo(Long value) {
            addCriterion("ID_REGISTRO <>", value, "idRegistro");
            return (Criteria) this;
        }

        public Criteria andIdRegistroGreaterThan(Long value) {
            addCriterion("ID_REGISTRO >", value, "idRegistro");
            return (Criteria) this;
        }

        public Criteria andIdRegistroGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_REGISTRO >=", value, "idRegistro");
            return (Criteria) this;
        }

        public Criteria andIdRegistroLessThan(Long value) {
            addCriterion("ID_REGISTRO <", value, "idRegistro");
            return (Criteria) this;
        }

        public Criteria andIdRegistroLessThanOrEqualTo(Long value) {
            addCriterion("ID_REGISTRO <=", value, "idRegistro");
            return (Criteria) this;
        }

        public Criteria andIdRegistroIn(List<Long> values) {
            addCriterion("ID_REGISTRO in", values, "idRegistro");
            return (Criteria) this;
        }

        public Criteria andIdRegistroNotIn(List<Long> values) {
            addCriterion("ID_REGISTRO not in", values, "idRegistro");
            return (Criteria) this;
        }

        public Criteria andIdRegistroBetween(Long value1, Long value2) {
            addCriterion("ID_REGISTRO between", value1, value2, "idRegistro");
            return (Criteria) this;
        }

        public Criteria andIdRegistroNotBetween(Long value1, Long value2) {
            addCriterion("ID_REGISTRO not between", value1, value2, "idRegistro");
            return (Criteria) this;
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

        public Criteria andFechaOperacionIsNull() {
            addCriterion("FECHA_OPERACION is null");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionIsNotNull() {
            addCriterion("FECHA_OPERACION is not null");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionEqualTo(Date value) {
            addCriterion("FECHA_OPERACION =", value, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionNotEqualTo(Date value) {
            addCriterion("FECHA_OPERACION <>", value, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionGreaterThan(Date value) {
            addCriterion("FECHA_OPERACION >", value, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionGreaterThanOrEqualTo(Date value) {
            addCriterion("FECHA_OPERACION >=", value, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionLessThan(Date value) {
            addCriterion("FECHA_OPERACION <", value, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionLessThanOrEqualTo(Date value) {
            addCriterion("FECHA_OPERACION <=", value, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionIn(List<Date> values) {
            addCriterion("FECHA_OPERACION in", values, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionNotIn(List<Date> values) {
            addCriterion("FECHA_OPERACION not in", values, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionBetween(Date value1, Date value2) {
            addCriterion("FECHA_OPERACION between", value1, value2, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionNotBetween(Date value1, Date value2) {
            addCriterion("FECHA_OPERACION not between", value1, value2, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaIsNull() {
            addCriterion("ENTRADA_SALIDA is null");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaIsNotNull() {
            addCriterion("ENTRADA_SALIDA is not null");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaEqualTo(Short value) {
            addCriterion("ENTRADA_SALIDA =", value, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaNotEqualTo(Short value) {
            addCriterion("ENTRADA_SALIDA <>", value, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaGreaterThan(Short value) {
            addCriterion("ENTRADA_SALIDA >", value, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaGreaterThanOrEqualTo(Short value) {
            addCriterion("ENTRADA_SALIDA >=", value, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaLessThan(Short value) {
            addCriterion("ENTRADA_SALIDA <", value, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaLessThanOrEqualTo(Short value) {
            addCriterion("ENTRADA_SALIDA <=", value, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaIn(List<Short> values) {
            addCriterion("ENTRADA_SALIDA in", values, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaNotIn(List<Short> values) {
            addCriterion("ENTRADA_SALIDA not in", values, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaBetween(Short value1, Short value2) {
            addCriterion("ENTRADA_SALIDA between", value1, value2, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaNotBetween(Short value1, Short value2) {
            addCriterion("ENTRADA_SALIDA not between", value1, value2, "entradaSalida");
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