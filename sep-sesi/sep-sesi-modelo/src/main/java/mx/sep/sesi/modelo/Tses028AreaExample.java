package mx.sep.sesi.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Tses028AreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses028AreaExample() {
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

        public Criteria andIdAreaIsNull() {
            addCriterion("ID_AREA is null");
            return (Criteria) this;
        }

        public Criteria andIdAreaIsNotNull() {
            addCriterion("ID_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andIdAreaEqualTo(BigDecimal value) {
            addCriterion("ID_AREA =", value, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaNotEqualTo(BigDecimal value) {
            addCriterion("ID_AREA <>", value, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaGreaterThan(BigDecimal value) {
            addCriterion("ID_AREA >", value, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID_AREA >=", value, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaLessThan(BigDecimal value) {
            addCriterion("ID_AREA <", value, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID_AREA <=", value, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaIn(List<BigDecimal> values) {
            addCriterion("ID_AREA in", values, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaNotIn(List<BigDecimal> values) {
            addCriterion("ID_AREA not in", values, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID_AREA between", value1, value2, "idArea");
            return (Criteria) this;
        }

        public Criteria andIdAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID_AREA not between", value1, value2, "idArea");
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

        public Criteria andClaveAreaIsNull() {
            addCriterion("CLAVE_AREA is null");
            return (Criteria) this;
        }

        public Criteria andClaveAreaIsNotNull() {
            addCriterion("CLAVE_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andClaveAreaEqualTo(String value) {
            addCriterion("CLAVE_AREA =", value, "claveArea");
            return (Criteria) this;
        }

        public Criteria andClaveAreaNotEqualTo(String value) {
            addCriterion("CLAVE_AREA <>", value, "claveArea");
            return (Criteria) this;
        }

        public Criteria andClaveAreaGreaterThan(String value) {
            addCriterion("CLAVE_AREA >", value, "claveArea");
            return (Criteria) this;
        }

        public Criteria andClaveAreaGreaterThanOrEqualTo(String value) {
            addCriterion("CLAVE_AREA >=", value, "claveArea");
            return (Criteria) this;
        }

        public Criteria andClaveAreaLessThan(String value) {
            addCriterion("CLAVE_AREA <", value, "claveArea");
            return (Criteria) this;
        }

        public Criteria andClaveAreaLessThanOrEqualTo(String value) {
            addCriterion("CLAVE_AREA <=", value, "claveArea");
            return (Criteria) this;
        }

        public Criteria andClaveAreaLike(String value) {
            addCriterion("CLAVE_AREA like", value, "claveArea");
            return (Criteria) this;
        }

        public Criteria andClaveAreaNotLike(String value) {
            addCriterion("CLAVE_AREA not like", value, "claveArea");
            return (Criteria) this;
        }

        public Criteria andClaveAreaIn(List<String> values) {
            addCriterion("CLAVE_AREA in", values, "claveArea");
            return (Criteria) this;
        }

        public Criteria andClaveAreaNotIn(List<String> values) {
            addCriterion("CLAVE_AREA not in", values, "claveArea");
            return (Criteria) this;
        }

        public Criteria andClaveAreaBetween(String value1, String value2) {
            addCriterion("CLAVE_AREA between", value1, value2, "claveArea");
            return (Criteria) this;
        }

        public Criteria andClaveAreaNotBetween(String value1, String value2) {
            addCriterion("CLAVE_AREA not between", value1, value2, "claveArea");
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