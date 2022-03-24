package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tses023ParametrosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses023ParametrosExample() {
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

        public Criteria andIdParamIsNull() {
            addCriterion("ID_PARAM is null");
            return (Criteria) this;
        }

        public Criteria andIdParamIsNotNull() {
            addCriterion("ID_PARAM is not null");
            return (Criteria) this;
        }

        public Criteria andIdParamEqualTo(Integer value) {
            addCriterion("ID_PARAM =", value, "idParam");
            return (Criteria) this;
        }

        public Criteria andIdParamNotEqualTo(Integer value) {
            addCriterion("ID_PARAM <>", value, "idParam");
            return (Criteria) this;
        }

        public Criteria andIdParamGreaterThan(Integer value) {
            addCriterion("ID_PARAM >", value, "idParam");
            return (Criteria) this;
        }

        public Criteria andIdParamGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_PARAM >=", value, "idParam");
            return (Criteria) this;
        }

        public Criteria andIdParamLessThan(Integer value) {
            addCriterion("ID_PARAM <", value, "idParam");
            return (Criteria) this;
        }

        public Criteria andIdParamLessThanOrEqualTo(Integer value) {
            addCriterion("ID_PARAM <=", value, "idParam");
            return (Criteria) this;
        }

        public Criteria andIdParamIn(List<Integer> values) {
            addCriterion("ID_PARAM in", values, "idParam");
            return (Criteria) this;
        }

        public Criteria andIdParamNotIn(List<Integer> values) {
            addCriterion("ID_PARAM not in", values, "idParam");
            return (Criteria) this;
        }

        public Criteria andIdParamBetween(Integer value1, Integer value2) {
            addCriterion("ID_PARAM between", value1, value2, "idParam");
            return (Criteria) this;
        }

        public Criteria andIdParamNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_PARAM not between", value1, value2, "idParam");
            return (Criteria) this;
        }

        public Criteria andValorIsNull() {
            addCriterion("VALOR is null");
            return (Criteria) this;
        }

        public Criteria andValorIsNotNull() {
            addCriterion("VALOR is not null");
            return (Criteria) this;
        }

        public Criteria andValorEqualTo(String value) {
            addCriterion("VALOR =", value, "valor");
            return (Criteria) this;
        }

        public Criteria andValorNotEqualTo(String value) {
            addCriterion("VALOR <>", value, "valor");
            return (Criteria) this;
        }

        public Criteria andValorGreaterThan(String value) {
            addCriterion("VALOR >", value, "valor");
            return (Criteria) this;
        }

        public Criteria andValorGreaterThanOrEqualTo(String value) {
            addCriterion("VALOR >=", value, "valor");
            return (Criteria) this;
        }

        public Criteria andValorLessThan(String value) {
            addCriterion("VALOR <", value, "valor");
            return (Criteria) this;
        }

        public Criteria andValorLessThanOrEqualTo(String value) {
            addCriterion("VALOR <=", value, "valor");
            return (Criteria) this;
        }

        public Criteria andValorLike(String value) {
            addCriterion("VALOR like", value, "valor");
            return (Criteria) this;
        }

        public Criteria andValorNotLike(String value) {
            addCriterion("VALOR not like", value, "valor");
            return (Criteria) this;
        }

        public Criteria andValorIn(List<String> values) {
            addCriterion("VALOR in", values, "valor");
            return (Criteria) this;
        }

        public Criteria andValorNotIn(List<String> values) {
            addCriterion("VALOR not in", values, "valor");
            return (Criteria) this;
        }

        public Criteria andValorBetween(String value1, String value2) {
            addCriterion("VALOR between", value1, value2, "valor");
            return (Criteria) this;
        }

        public Criteria andValorNotBetween(String value1, String value2) {
            addCriterion("VALOR not between", value1, value2, "valor");
            return (Criteria) this;
        }

        public Criteria andDescripcionIsNull() {
            addCriterion("DESCRIPCION is null");
            return (Criteria) this;
        }

        public Criteria andDescripcionIsNotNull() {
            addCriterion("DESCRIPCION is not null");
            return (Criteria) this;
        }

        public Criteria andDescripcionEqualTo(String value) {
            addCriterion("DESCRIPCION =", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotEqualTo(String value) {
            addCriterion("DESCRIPCION <>", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionGreaterThan(String value) {
            addCriterion("DESCRIPCION >", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPCION >=", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLessThan(String value) {
            addCriterion("DESCRIPCION <", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPCION <=", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLike(String value) {
            addCriterion("DESCRIPCION like", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotLike(String value) {
            addCriterion("DESCRIPCION not like", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionIn(List<String> values) {
            addCriterion("DESCRIPCION in", values, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotIn(List<String> values) {
            addCriterion("DESCRIPCION not in", values, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionBetween(String value1, String value2) {
            addCriterion("DESCRIPCION between", value1, value2, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPCION not between", value1, value2, "descripcion");
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