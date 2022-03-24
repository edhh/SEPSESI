package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tses006UnidadResponsableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses006UnidadResponsableExample() {
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

        public Criteria andUnidadResponsableIsNull() {
            addCriterion("UNIDAD_RESPONSABLE is null");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableIsNotNull() {
            addCriterion("UNIDAD_RESPONSABLE is not null");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableEqualTo(String value) {
            addCriterion("UNIDAD_RESPONSABLE =", value, "unidadResponsable");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableNotEqualTo(String value) {
            addCriterion("UNIDAD_RESPONSABLE <>", value, "unidadResponsable");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableGreaterThan(String value) {
            addCriterion("UNIDAD_RESPONSABLE >", value, "unidadResponsable");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableGreaterThanOrEqualTo(String value) {
            addCriterion("UNIDAD_RESPONSABLE >=", value, "unidadResponsable");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableLessThan(String value) {
            addCriterion("UNIDAD_RESPONSABLE <", value, "unidadResponsable");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableLessThanOrEqualTo(String value) {
            addCriterion("UNIDAD_RESPONSABLE <=", value, "unidadResponsable");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableLike(String value) {
            addCriterion("UNIDAD_RESPONSABLE like", value, "unidadResponsable");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableNotLike(String value) {
            addCriterion("UNIDAD_RESPONSABLE not like", value, "unidadResponsable");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableIn(List<String> values) {
            addCriterion("UNIDAD_RESPONSABLE in", values, "unidadResponsable");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableNotIn(List<String> values) {
            addCriterion("UNIDAD_RESPONSABLE not in", values, "unidadResponsable");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableBetween(String value1, String value2) {
            addCriterion("UNIDAD_RESPONSABLE between", value1, value2, "unidadResponsable");
            return (Criteria) this;
        }

        public Criteria andUnidadResponsableNotBetween(String value1, String value2) {
            addCriterion("UNIDAD_RESPONSABLE not between", value1, value2, "unidadResponsable");
            return (Criteria) this;
        }

        public Criteria andClaveUrIsNull() {
            addCriterion("CLAVE_UR is null");
            return (Criteria) this;
        }

        public Criteria andClaveUrIsNotNull() {
            addCriterion("CLAVE_UR is not null");
            return (Criteria) this;
        }

        public Criteria andClaveUrEqualTo(String value) {
            addCriterion("CLAVE_UR =", value, "claveUr");
            return (Criteria) this;
        }

        public Criteria andClaveUrNotEqualTo(String value) {
            addCriterion("CLAVE_UR <>", value, "claveUr");
            return (Criteria) this;
        }

        public Criteria andClaveUrGreaterThan(String value) {
            addCriterion("CLAVE_UR >", value, "claveUr");
            return (Criteria) this;
        }

        public Criteria andClaveUrGreaterThanOrEqualTo(String value) {
            addCriterion("CLAVE_UR >=", value, "claveUr");
            return (Criteria) this;
        }

        public Criteria andClaveUrLessThan(String value) {
            addCriterion("CLAVE_UR <", value, "claveUr");
            return (Criteria) this;
        }

        public Criteria andClaveUrLessThanOrEqualTo(String value) {
            addCriterion("CLAVE_UR <=", value, "claveUr");
            return (Criteria) this;
        }

        public Criteria andClaveUrLike(String value) {
            addCriterion("CLAVE_UR like", value, "claveUr");
            return (Criteria) this;
        }

        public Criteria andClaveUrNotLike(String value) {
            addCriterion("CLAVE_UR not like", value, "claveUr");
            return (Criteria) this;
        }

        public Criteria andClaveUrIn(List<String> values) {
            addCriterion("CLAVE_UR in", values, "claveUr");
            return (Criteria) this;
        }

        public Criteria andClaveUrNotIn(List<String> values) {
            addCriterion("CLAVE_UR not in", values, "claveUr");
            return (Criteria) this;
        }

        public Criteria andClaveUrBetween(String value1, String value2) {
            addCriterion("CLAVE_UR between", value1, value2, "claveUr");
            return (Criteria) this;
        }

        public Criteria andClaveUrNotBetween(String value1, String value2) {
            addCriterion("CLAVE_UR not between", value1, value2, "claveUr");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaIsNull() {
            addCriterion("ABREVIATURA is null");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaIsNotNull() {
            addCriterion("ABREVIATURA is not null");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaEqualTo(String value) {
            addCriterion("ABREVIATURA =", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaNotEqualTo(String value) {
            addCriterion("ABREVIATURA <>", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaGreaterThan(String value) {
            addCriterion("ABREVIATURA >", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaGreaterThanOrEqualTo(String value) {
            addCriterion("ABREVIATURA >=", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaLessThan(String value) {
            addCriterion("ABREVIATURA <", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaLessThanOrEqualTo(String value) {
            addCriterion("ABREVIATURA <=", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaLike(String value) {
            addCriterion("ABREVIATURA like", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaNotLike(String value) {
            addCriterion("ABREVIATURA not like", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaIn(List<String> values) {
            addCriterion("ABREVIATURA in", values, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaNotIn(List<String> values) {
            addCriterion("ABREVIATURA not in", values, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaBetween(String value1, String value2) {
            addCriterion("ABREVIATURA between", value1, value2, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaNotBetween(String value1, String value2) {
            addCriterion("ABREVIATURA not between", value1, value2, "abreviatura");
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