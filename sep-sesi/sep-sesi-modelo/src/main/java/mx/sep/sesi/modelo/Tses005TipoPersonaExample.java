package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tses005TipoPersonaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses005TipoPersonaExample() {
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

        public Criteria andTipoPersonaIsNull() {
            addCriterion("TIPO_PERSONA is null");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaIsNotNull() {
            addCriterion("TIPO_PERSONA is not null");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaEqualTo(String value) {
            addCriterion("TIPO_PERSONA =", value, "tipoPersona");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaNotEqualTo(String value) {
            addCriterion("TIPO_PERSONA <>", value, "tipoPersona");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaGreaterThan(String value) {
            addCriterion("TIPO_PERSONA >", value, "tipoPersona");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaGreaterThanOrEqualTo(String value) {
            addCriterion("TIPO_PERSONA >=", value, "tipoPersona");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaLessThan(String value) {
            addCriterion("TIPO_PERSONA <", value, "tipoPersona");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaLessThanOrEqualTo(String value) {
            addCriterion("TIPO_PERSONA <=", value, "tipoPersona");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaLike(String value) {
            addCriterion("TIPO_PERSONA like", value, "tipoPersona");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaNotLike(String value) {
            addCriterion("TIPO_PERSONA not like", value, "tipoPersona");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaIn(List<String> values) {
            addCriterion("TIPO_PERSONA in", values, "tipoPersona");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaNotIn(List<String> values) {
            addCriterion("TIPO_PERSONA not in", values, "tipoPersona");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaBetween(String value1, String value2) {
            addCriterion("TIPO_PERSONA between", value1, value2, "tipoPersona");
            return (Criteria) this;
        }

        public Criteria andTipoPersonaNotBetween(String value1, String value2) {
            addCriterion("TIPO_PERSONA not between", value1, value2, "tipoPersona");
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