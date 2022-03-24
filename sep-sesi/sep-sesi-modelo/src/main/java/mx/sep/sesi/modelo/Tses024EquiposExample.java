package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tses024EquiposExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses024EquiposExample() {
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

        public Criteria andIdEquipoIsNull() {
            addCriterion("ID_EQUIPO is null");
            return (Criteria) this;
        }

        public Criteria andIdEquipoIsNotNull() {
            addCriterion("ID_EQUIPO is not null");
            return (Criteria) this;
        }

        public Criteria andIdEquipoEqualTo(Long value) {
            addCriterion("ID_EQUIPO =", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoNotEqualTo(Long value) {
            addCriterion("ID_EQUIPO <>", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoGreaterThan(Long value) {
            addCriterion("ID_EQUIPO >", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_EQUIPO >=", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoLessThan(Long value) {
            addCriterion("ID_EQUIPO <", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoLessThanOrEqualTo(Long value) {
            addCriterion("ID_EQUIPO <=", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoIn(List<Long> values) {
            addCriterion("ID_EQUIPO in", values, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoNotIn(List<Long> values) {
            addCriterion("ID_EQUIPO not in", values, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoBetween(Long value1, Long value2) {
            addCriterion("ID_EQUIPO between", value1, value2, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoNotBetween(Long value1, Long value2) {
            addCriterion("ID_EQUIPO not between", value1, value2, "idEquipo");
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

        public Criteria andIdPersonaEqualTo(Long value) {
            addCriterion("ID_PERSONA =", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaNotEqualTo(Long value) {
            addCriterion("ID_PERSONA <>", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaGreaterThan(Long value) {
            addCriterion("ID_PERSONA >", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_PERSONA >=", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaLessThan(Long value) {
            addCriterion("ID_PERSONA <", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaLessThanOrEqualTo(Long value) {
            addCriterion("ID_PERSONA <=", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaIn(List<Long> values) {
            addCriterion("ID_PERSONA in", values, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaNotIn(List<Long> values) {
            addCriterion("ID_PERSONA not in", values, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaBetween(Long value1, Long value2) {
            addCriterion("ID_PERSONA between", value1, value2, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaNotBetween(Long value1, Long value2) {
            addCriterion("ID_PERSONA not between", value1, value2, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPartidaIsNull() {
            addCriterion("ID_PARTIDA is null");
            return (Criteria) this;
        }

        public Criteria andIdPartidaIsNotNull() {
            addCriterion("ID_PARTIDA is not null");
            return (Criteria) this;
        }

        public Criteria andIdPartidaEqualTo(Long value) {
            addCriterion("ID_PARTIDA =", value, "idPartida");
            return (Criteria) this;
        }

        public Criteria andIdPartidaNotEqualTo(Long value) {
            addCriterion("ID_PARTIDA <>", value, "idPartida");
            return (Criteria) this;
        }

        public Criteria andIdPartidaGreaterThan(Long value) {
            addCriterion("ID_PARTIDA >", value, "idPartida");
            return (Criteria) this;
        }

        public Criteria andIdPartidaGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_PARTIDA >=", value, "idPartida");
            return (Criteria) this;
        }

        public Criteria andIdPartidaLessThan(Long value) {
            addCriterion("ID_PARTIDA <", value, "idPartida");
            return (Criteria) this;
        }

        public Criteria andIdPartidaLessThanOrEqualTo(Long value) {
            addCriterion("ID_PARTIDA <=", value, "idPartida");
            return (Criteria) this;
        }

        public Criteria andIdPartidaIn(List<Long> values) {
            addCriterion("ID_PARTIDA in", values, "idPartida");
            return (Criteria) this;
        }

        public Criteria andIdPartidaNotIn(List<Long> values) {
            addCriterion("ID_PARTIDA not in", values, "idPartida");
            return (Criteria) this;
        }

        public Criteria andIdPartidaBetween(Long value1, Long value2) {
            addCriterion("ID_PARTIDA between", value1, value2, "idPartida");
            return (Criteria) this;
        }

        public Criteria andIdPartidaNotBetween(Long value1, Long value2) {
            addCriterion("ID_PARTIDA not between", value1, value2, "idPartida");
            return (Criteria) this;
        }

        public Criteria andNumSerieIsNull() {
            addCriterion("NUM_SERIE is null");
            return (Criteria) this;
        }

        public Criteria andNumSerieIsNotNull() {
            addCriterion("NUM_SERIE is not null");
            return (Criteria) this;
        }

        public Criteria andNumSerieEqualTo(String value) {
            addCriterion("NUM_SERIE =", value, "numSerie");
            return (Criteria) this;
        }

        public Criteria andNumSerieNotEqualTo(String value) {
            addCriterion("NUM_SERIE <>", value, "numSerie");
            return (Criteria) this;
        }

        public Criteria andNumSerieGreaterThan(String value) {
            addCriterion("NUM_SERIE >", value, "numSerie");
            return (Criteria) this;
        }

        public Criteria andNumSerieGreaterThanOrEqualTo(String value) {
            addCriterion("NUM_SERIE >=", value, "numSerie");
            return (Criteria) this;
        }

        public Criteria andNumSerieLessThan(String value) {
            addCriterion("NUM_SERIE <", value, "numSerie");
            return (Criteria) this;
        }

        public Criteria andNumSerieLessThanOrEqualTo(String value) {
            addCriterion("NUM_SERIE <=", value, "numSerie");
            return (Criteria) this;
        }

        public Criteria andNumSerieLike(String value) {
            addCriterion("NUM_SERIE like", value, "numSerie");
            return (Criteria) this;
        }

        public Criteria andNumSerieNotLike(String value) {
            addCriterion("NUM_SERIE not like", value, "numSerie");
            return (Criteria) this;
        }

        public Criteria andNumSerieIn(List<String> values) {
            addCriterion("NUM_SERIE in", values, "numSerie");
            return (Criteria) this;
        }

        public Criteria andNumSerieNotIn(List<String> values) {
            addCriterion("NUM_SERIE not in", values, "numSerie");
            return (Criteria) this;
        }

        public Criteria andNumSerieBetween(String value1, String value2) {
            addCriterion("NUM_SERIE between", value1, value2, "numSerie");
            return (Criteria) this;
        }

        public Criteria andNumSerieNotBetween(String value1, String value2) {
            addCriterion("NUM_SERIE not between", value1, value2, "numSerie");
            return (Criteria) this;
        }

        public Criteria andFechaAsignacionIsNull() {
            addCriterion("FECHA_ASIGNACION is null");
            return (Criteria) this;
        }

        public Criteria andFechaAsignacionIsNotNull() {
            addCriterion("FECHA_ASIGNACION is not null");
            return (Criteria) this;
        }

        public Criteria andFechaAsignacionEqualTo(Date value) {
            addCriterion("FECHA_ASIGNACION =", value, "fechaAsignacion");
            return (Criteria) this;
        }

        public Criteria andFechaAsignacionNotEqualTo(Date value) {
            addCriterion("FECHA_ASIGNACION <>", value, "fechaAsignacion");
            return (Criteria) this;
        }

        public Criteria andFechaAsignacionGreaterThan(Date value) {
            addCriterion("FECHA_ASIGNACION >", value, "fechaAsignacion");
            return (Criteria) this;
        }

        public Criteria andFechaAsignacionGreaterThanOrEqualTo(Date value) {
            addCriterion("FECHA_ASIGNACION >=", value, "fechaAsignacion");
            return (Criteria) this;
        }

        public Criteria andFechaAsignacionLessThan(Date value) {
            addCriterion("FECHA_ASIGNACION <", value, "fechaAsignacion");
            return (Criteria) this;
        }

        public Criteria andFechaAsignacionLessThanOrEqualTo(Date value) {
            addCriterion("FECHA_ASIGNACION <=", value, "fechaAsignacion");
            return (Criteria) this;
        }

        public Criteria andFechaAsignacionIn(List<Date> values) {
            addCriterion("FECHA_ASIGNACION in", values, "fechaAsignacion");
            return (Criteria) this;
        }

        public Criteria andFechaAsignacionNotIn(List<Date> values) {
            addCriterion("FECHA_ASIGNACION not in", values, "fechaAsignacion");
            return (Criteria) this;
        }

        public Criteria andFechaAsignacionBetween(Date value1, Date value2) {
            addCriterion("FECHA_ASIGNACION between", value1, value2, "fechaAsignacion");
            return (Criteria) this;
        }

        public Criteria andFechaAsignacionNotBetween(Date value1, Date value2) {
            addCriterion("FECHA_ASIGNACION not between", value1, value2, "fechaAsignacion");
            return (Criteria) this;
        }

        public Criteria andTipooperacionIsNull() {
            addCriterion("TIPOOPERACION is null");
            return (Criteria) this;
        }

        public Criteria andTipooperacionIsNotNull() {
            addCriterion("TIPOOPERACION is not null");
            return (Criteria) this;
        }

        public Criteria andTipooperacionEqualTo(Long value) {
            addCriterion("TIPOOPERACION =", value, "tipooperacion");
            return (Criteria) this;
        }

        public Criteria andTipooperacionNotEqualTo(Long value) {
            addCriterion("TIPOOPERACION <>", value, "tipooperacion");
            return (Criteria) this;
        }

        public Criteria andTipooperacionGreaterThan(Long value) {
            addCriterion("TIPOOPERACION >", value, "tipooperacion");
            return (Criteria) this;
        }

        public Criteria andTipooperacionGreaterThanOrEqualTo(Long value) {
            addCriterion("TIPOOPERACION >=", value, "tipooperacion");
            return (Criteria) this;
        }

        public Criteria andTipooperacionLessThan(Long value) {
            addCriterion("TIPOOPERACION <", value, "tipooperacion");
            return (Criteria) this;
        }

        public Criteria andTipooperacionLessThanOrEqualTo(Long value) {
            addCriterion("TIPOOPERACION <=", value, "tipooperacion");
            return (Criteria) this;
        }

        public Criteria andTipooperacionIn(List<Long> values) {
            addCriterion("TIPOOPERACION in", values, "tipooperacion");
            return (Criteria) this;
        }

        public Criteria andTipooperacionNotIn(List<Long> values) {
            addCriterion("TIPOOPERACION not in", values, "tipooperacion");
            return (Criteria) this;
        }

        public Criteria andTipooperacionBetween(Long value1, Long value2) {
            addCriterion("TIPOOPERACION between", value1, value2, "tipooperacion");
            return (Criteria) this;
        }

        public Criteria andTipooperacionNotBetween(Long value1, Long value2) {
            addCriterion("TIPOOPERACION not between", value1, value2, "tipooperacion");
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