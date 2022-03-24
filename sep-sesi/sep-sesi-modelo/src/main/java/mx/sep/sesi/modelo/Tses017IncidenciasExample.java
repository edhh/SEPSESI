package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tses017IncidenciasExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses017IncidenciasExample() {
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

        public Criteria andIdIncidenciaIsNull() {
            addCriterion("ID_INCIDENCIA is null");
            return (Criteria) this;
        }

        public Criteria andIdIncidenciaIsNotNull() {
            addCriterion("ID_INCIDENCIA is not null");
            return (Criteria) this;
        }

        public Criteria andIdIncidenciaEqualTo(Long value) {
            addCriterion("ID_INCIDENCIA =", value, "idIncidencia");
            return (Criteria) this;
        }

        public Criteria andIdIncidenciaNotEqualTo(Long value) {
            addCriterion("ID_INCIDENCIA <>", value, "idIncidencia");
            return (Criteria) this;
        }

        public Criteria andIdIncidenciaGreaterThan(Long value) {
            addCriterion("ID_INCIDENCIA >", value, "idIncidencia");
            return (Criteria) this;
        }

        public Criteria andIdIncidenciaGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_INCIDENCIA >=", value, "idIncidencia");
            return (Criteria) this;
        }

        public Criteria andIdIncidenciaLessThan(Long value) {
            addCriterion("ID_INCIDENCIA <", value, "idIncidencia");
            return (Criteria) this;
        }

        public Criteria andIdIncidenciaLessThanOrEqualTo(Long value) {
            addCriterion("ID_INCIDENCIA <=", value, "idIncidencia");
            return (Criteria) this;
        }

        public Criteria andIdIncidenciaIn(List<Long> values) {
            addCriterion("ID_INCIDENCIA in", values, "idIncidencia");
            return (Criteria) this;
        }

        public Criteria andIdIncidenciaNotIn(List<Long> values) {
            addCriterion("ID_INCIDENCIA not in", values, "idIncidencia");
            return (Criteria) this;
        }

        public Criteria andIdIncidenciaBetween(Long value1, Long value2) {
            addCriterion("ID_INCIDENCIA between", value1, value2, "idIncidencia");
            return (Criteria) this;
        }

        public Criteria andIdIncidenciaNotBetween(Long value1, Long value2) {
            addCriterion("ID_INCIDENCIA not between", value1, value2, "idIncidencia");
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

        public Criteria andTemperaturaIsNull() {
            addCriterion("TEMPERATURA is null");
            return (Criteria) this;
        }

        public Criteria andTemperaturaIsNotNull() {
            addCriterion("TEMPERATURA is not null");
            return (Criteria) this;
        }

        public Criteria andTemperaturaEqualTo(Short value) {
            addCriterion("TEMPERATURA =", value, "temperatura");
            return (Criteria) this;
        }

        public Criteria andTemperaturaNotEqualTo(Short value) {
            addCriterion("TEMPERATURA <>", value, "temperatura");
            return (Criteria) this;
        }

        public Criteria andTemperaturaGreaterThan(Short value) {
            addCriterion("TEMPERATURA >", value, "temperatura");
            return (Criteria) this;
        }

        public Criteria andTemperaturaGreaterThanOrEqualTo(Short value) {
            addCriterion("TEMPERATURA >=", value, "temperatura");
            return (Criteria) this;
        }

        public Criteria andTemperaturaLessThan(Short value) {
            addCriterion("TEMPERATURA <", value, "temperatura");
            return (Criteria) this;
        }

        public Criteria andTemperaturaLessThanOrEqualTo(Short value) {
            addCriterion("TEMPERATURA <=", value, "temperatura");
            return (Criteria) this;
        }

        public Criteria andTemperaturaIn(List<Short> values) {
            addCriterion("TEMPERATURA in", values, "temperatura");
            return (Criteria) this;
        }

        public Criteria andTemperaturaNotIn(List<Short> values) {
            addCriterion("TEMPERATURA not in", values, "temperatura");
            return (Criteria) this;
        }

        public Criteria andTemperaturaBetween(Short value1, Short value2) {
            addCriterion("TEMPERATURA between", value1, value2, "temperatura");
            return (Criteria) this;
        }

        public Criteria andTemperaturaNotBetween(Short value1, Short value2) {
            addCriterion("TEMPERATURA not between", value1, value2, "temperatura");
            return (Criteria) this;
        }

        public Criteria andFechaIsNull() {
            addCriterion("FECHA is null");
            return (Criteria) this;
        }

        public Criteria andFechaIsNotNull() {
            addCriterion("FECHA is not null");
            return (Criteria) this;
        }

        public Criteria andFechaEqualTo(Date value) {
            addCriterion("FECHA =", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaNotEqualTo(Date value) {
            addCriterion("FECHA <>", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaGreaterThan(Date value) {
            addCriterion("FECHA >", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaGreaterThanOrEqualTo(Date value) {
            addCriterion("FECHA >=", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaLessThan(Date value) {
            addCriterion("FECHA <", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaLessThanOrEqualTo(Date value) {
            addCriterion("FECHA <=", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaIn(List<Date> values) {
            addCriterion("FECHA in", values, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaNotIn(List<Date> values) {
            addCriterion("FECHA not in", values, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaBetween(Date value1, Date value2) {
            addCriterion("FECHA between", value1, value2, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaNotBetween(Date value1, Date value2) {
            addCriterion("FECHA not between", value1, value2, "fecha");
            return (Criteria) this;
        }

        public Criteria andHoraIsNull() {
            addCriterion("HORA is null");
            return (Criteria) this;
        }

        public Criteria andHoraIsNotNull() {
            addCriterion("HORA is not null");
            return (Criteria) this;
        }

        public Criteria andHoraEqualTo(Date value) {
            addCriterion("HORA =", value, "hora");
            return (Criteria) this;
        }

        public Criteria andHoraNotEqualTo(Date value) {
            addCriterion("HORA <>", value, "hora");
            return (Criteria) this;
        }

        public Criteria andHoraGreaterThan(Date value) {
            addCriterion("HORA >", value, "hora");
            return (Criteria) this;
        }

        public Criteria andHoraGreaterThanOrEqualTo(Date value) {
            addCriterion("HORA >=", value, "hora");
            return (Criteria) this;
        }

        public Criteria andHoraLessThan(Date value) {
            addCriterion("HORA <", value, "hora");
            return (Criteria) this;
        }

        public Criteria andHoraLessThanOrEqualTo(Date value) {
            addCriterion("HORA <=", value, "hora");
            return (Criteria) this;
        }

        public Criteria andHoraIn(List<Date> values) {
            addCriterion("HORA in", values, "hora");
            return (Criteria) this;
        }

        public Criteria andHoraNotIn(List<Date> values) {
            addCriterion("HORA not in", values, "hora");
            return (Criteria) this;
        }

        public Criteria andHoraBetween(Date value1, Date value2) {
            addCriterion("HORA between", value1, value2, "hora");
            return (Criteria) this;
        }

        public Criteria andHoraNotBetween(Date value1, Date value2) {
            addCriterion("HORA not between", value1, value2, "hora");
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