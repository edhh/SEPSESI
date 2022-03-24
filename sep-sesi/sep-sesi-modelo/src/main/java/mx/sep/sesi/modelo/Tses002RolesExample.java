package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tses002RolesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses002RolesExample() {
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

        public Criteria andIdRolIsNull() {
            addCriterion("ID_ROL is null");
            return (Criteria) this;
        }

        public Criteria andIdRolIsNotNull() {
            addCriterion("ID_ROL is not null");
            return (Criteria) this;
        }

        public Criteria andIdRolEqualTo(Integer value) {
            addCriterion("ID_ROL =", value, "idRol");
            return (Criteria) this;
        }

        public Criteria andIdRolNotEqualTo(Integer value) {
            addCriterion("ID_ROL <>", value, "idRol");
            return (Criteria) this;
        }

        public Criteria andIdRolGreaterThan(Integer value) {
            addCriterion("ID_ROL >", value, "idRol");
            return (Criteria) this;
        }

        public Criteria andIdRolGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_ROL >=", value, "idRol");
            return (Criteria) this;
        }

        public Criteria andIdRolLessThan(Integer value) {
            addCriterion("ID_ROL <", value, "idRol");
            return (Criteria) this;
        }

        public Criteria andIdRolLessThanOrEqualTo(Integer value) {
            addCriterion("ID_ROL <=", value, "idRol");
            return (Criteria) this;
        }

        public Criteria andIdRolIn(List<Integer> values) {
            addCriterion("ID_ROL in", values, "idRol");
            return (Criteria) this;
        }

        public Criteria andIdRolNotIn(List<Integer> values) {
            addCriterion("ID_ROL not in", values, "idRol");
            return (Criteria) this;
        }

        public Criteria andIdRolBetween(Integer value1, Integer value2) {
            addCriterion("ID_ROL between", value1, value2, "idRol");
            return (Criteria) this;
        }

        public Criteria andIdRolNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_ROL not between", value1, value2, "idRol");
            return (Criteria) this;
        }

        public Criteria andDescRolIsNull() {
            addCriterion("DESC_ROL is null");
            return (Criteria) this;
        }

        public Criteria andDescRolIsNotNull() {
            addCriterion("DESC_ROL is not null");
            return (Criteria) this;
        }

        public Criteria andDescRolEqualTo(String value) {
            addCriterion("DESC_ROL =", value, "descRol");
            return (Criteria) this;
        }

        public Criteria andDescRolNotEqualTo(String value) {
            addCriterion("DESC_ROL <>", value, "descRol");
            return (Criteria) this;
        }

        public Criteria andDescRolGreaterThan(String value) {
            addCriterion("DESC_ROL >", value, "descRol");
            return (Criteria) this;
        }

        public Criteria andDescRolGreaterThanOrEqualTo(String value) {
            addCriterion("DESC_ROL >=", value, "descRol");
            return (Criteria) this;
        }

        public Criteria andDescRolLessThan(String value) {
            addCriterion("DESC_ROL <", value, "descRol");
            return (Criteria) this;
        }

        public Criteria andDescRolLessThanOrEqualTo(String value) {
            addCriterion("DESC_ROL <=", value, "descRol");
            return (Criteria) this;
        }

        public Criteria andDescRolLike(String value) {
            addCriterion("DESC_ROL like", value, "descRol");
            return (Criteria) this;
        }

        public Criteria andDescRolNotLike(String value) {
            addCriterion("DESC_ROL not like", value, "descRol");
            return (Criteria) this;
        }

        public Criteria andDescRolIn(List<String> values) {
            addCriterion("DESC_ROL in", values, "descRol");
            return (Criteria) this;
        }

        public Criteria andDescRolNotIn(List<String> values) {
            addCriterion("DESC_ROL not in", values, "descRol");
            return (Criteria) this;
        }

        public Criteria andDescRolBetween(String value1, String value2) {
            addCriterion("DESC_ROL between", value1, value2, "descRol");
            return (Criteria) this;
        }

        public Criteria andDescRolNotBetween(String value1, String value2) {
            addCriterion("DESC_ROL not between", value1, value2, "descRol");
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