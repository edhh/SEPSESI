package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tses016EntidadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses016EntidadExample() {
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

        public Criteria andIdEntidadIsNull() {
            addCriterion("ID_ENTIDAD is null");
            return (Criteria) this;
        }

        public Criteria andIdEntidadIsNotNull() {
            addCriterion("ID_ENTIDAD is not null");
            return (Criteria) this;
        }

        public Criteria andIdEntidadEqualTo(Integer value) {
            addCriterion("ID_ENTIDAD =", value, "idEntidad");
            return (Criteria) this;
        }

        public Criteria andIdEntidadNotEqualTo(Integer value) {
            addCriterion("ID_ENTIDAD <>", value, "idEntidad");
            return (Criteria) this;
        }

        public Criteria andIdEntidadGreaterThan(Integer value) {
            addCriterion("ID_ENTIDAD >", value, "idEntidad");
            return (Criteria) this;
        }

        public Criteria andIdEntidadGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_ENTIDAD >=", value, "idEntidad");
            return (Criteria) this;
        }

        public Criteria andIdEntidadLessThan(Integer value) {
            addCriterion("ID_ENTIDAD <", value, "idEntidad");
            return (Criteria) this;
        }

        public Criteria andIdEntidadLessThanOrEqualTo(Integer value) {
            addCriterion("ID_ENTIDAD <=", value, "idEntidad");
            return (Criteria) this;
        }

        public Criteria andIdEntidadIn(List<Integer> values) {
            addCriterion("ID_ENTIDAD in", values, "idEntidad");
            return (Criteria) this;
        }

        public Criteria andIdEntidadNotIn(List<Integer> values) {
            addCriterion("ID_ENTIDAD not in", values, "idEntidad");
            return (Criteria) this;
        }

        public Criteria andIdEntidadBetween(Integer value1, Integer value2) {
            addCriterion("ID_ENTIDAD between", value1, value2, "idEntidad");
            return (Criteria) this;
        }

        public Criteria andIdEntidadNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_ENTIDAD not between", value1, value2, "idEntidad");
            return (Criteria) this;
        }

        public Criteria andEntidadIsNull() {
            addCriterion("ENTIDAD is null");
            return (Criteria) this;
        }

        public Criteria andEntidadIsNotNull() {
            addCriterion("ENTIDAD is not null");
            return (Criteria) this;
        }

        public Criteria andEntidadEqualTo(String value) {
            addCriterion("ENTIDAD =", value, "entidad");
            return (Criteria) this;
        }

        public Criteria andEntidadNotEqualTo(String value) {
            addCriterion("ENTIDAD <>", value, "entidad");
            return (Criteria) this;
        }

        public Criteria andEntidadGreaterThan(String value) {
            addCriterion("ENTIDAD >", value, "entidad");
            return (Criteria) this;
        }

        public Criteria andEntidadGreaterThanOrEqualTo(String value) {
            addCriterion("ENTIDAD >=", value, "entidad");
            return (Criteria) this;
        }

        public Criteria andEntidadLessThan(String value) {
            addCriterion("ENTIDAD <", value, "entidad");
            return (Criteria) this;
        }

        public Criteria andEntidadLessThanOrEqualTo(String value) {
            addCriterion("ENTIDAD <=", value, "entidad");
            return (Criteria) this;
        }

        public Criteria andEntidadLike(String value) {
            addCriterion("ENTIDAD like", value, "entidad");
            return (Criteria) this;
        }

        public Criteria andEntidadNotLike(String value) {
            addCriterion("ENTIDAD not like", value, "entidad");
            return (Criteria) this;
        }

        public Criteria andEntidadIn(List<String> values) {
            addCriterion("ENTIDAD in", values, "entidad");
            return (Criteria) this;
        }

        public Criteria andEntidadNotIn(List<String> values) {
            addCriterion("ENTIDAD not in", values, "entidad");
            return (Criteria) this;
        }

        public Criteria andEntidadBetween(String value1, String value2) {
            addCriterion("ENTIDAD between", value1, value2, "entidad");
            return (Criteria) this;
        }

        public Criteria andEntidadNotBetween(String value1, String value2) {
            addCriterion("ENTIDAD not between", value1, value2, "entidad");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadIsNull() {
            addCriterion("CLAVE_ENTIDAD is null");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadIsNotNull() {
            addCriterion("CLAVE_ENTIDAD is not null");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadEqualTo(String value) {
            addCriterion("CLAVE_ENTIDAD =", value, "claveEntidad");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadNotEqualTo(String value) {
            addCriterion("CLAVE_ENTIDAD <>", value, "claveEntidad");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadGreaterThan(String value) {
            addCriterion("CLAVE_ENTIDAD >", value, "claveEntidad");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadGreaterThanOrEqualTo(String value) {
            addCriterion("CLAVE_ENTIDAD >=", value, "claveEntidad");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadLessThan(String value) {
            addCriterion("CLAVE_ENTIDAD <", value, "claveEntidad");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadLessThanOrEqualTo(String value) {
            addCriterion("CLAVE_ENTIDAD <=", value, "claveEntidad");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadLike(String value) {
            addCriterion("CLAVE_ENTIDAD like", value, "claveEntidad");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadNotLike(String value) {
            addCriterion("CLAVE_ENTIDAD not like", value, "claveEntidad");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadIn(List<String> values) {
            addCriterion("CLAVE_ENTIDAD in", values, "claveEntidad");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadNotIn(List<String> values) {
            addCriterion("CLAVE_ENTIDAD not in", values, "claveEntidad");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadBetween(String value1, String value2) {
            addCriterion("CLAVE_ENTIDAD between", value1, value2, "claveEntidad");
            return (Criteria) this;
        }

        public Criteria andClaveEntidadNotBetween(String value1, String value2) {
            addCriterion("CLAVE_ENTIDAD not between", value1, value2, "claveEntidad");
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