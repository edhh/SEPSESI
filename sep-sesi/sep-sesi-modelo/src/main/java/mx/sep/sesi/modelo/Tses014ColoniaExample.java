package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tses014ColoniaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses014ColoniaExample() {
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

        public Criteria andIdColoniaIsNull() {
            addCriterion("ID_COLONIA is null");
            return (Criteria) this;
        }

        public Criteria andIdColoniaIsNotNull() {
            addCriterion("ID_COLONIA is not null");
            return (Criteria) this;
        }

        public Criteria andIdColoniaEqualTo(Long value) {
            addCriterion("ID_COLONIA =", value, "idColonia");
            return (Criteria) this;
        }

        public Criteria andIdColoniaNotEqualTo(Long value) {
            addCriterion("ID_COLONIA <>", value, "idColonia");
            return (Criteria) this;
        }

        public Criteria andIdColoniaGreaterThan(Long value) {
            addCriterion("ID_COLONIA >", value, "idColonia");
            return (Criteria) this;
        }

        public Criteria andIdColoniaGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_COLONIA >=", value, "idColonia");
            return (Criteria) this;
        }

        public Criteria andIdColoniaLessThan(Long value) {
            addCriterion("ID_COLONIA <", value, "idColonia");
            return (Criteria) this;
        }

        public Criteria andIdColoniaLessThanOrEqualTo(Long value) {
            addCriterion("ID_COLONIA <=", value, "idColonia");
            return (Criteria) this;
        }

        public Criteria andIdColoniaIn(List<Long> values) {
            addCriterion("ID_COLONIA in", values, "idColonia");
            return (Criteria) this;
        }

        public Criteria andIdColoniaNotIn(List<Long> values) {
            addCriterion("ID_COLONIA not in", values, "idColonia");
            return (Criteria) this;
        }

        public Criteria andIdColoniaBetween(Long value1, Long value2) {
            addCriterion("ID_COLONIA between", value1, value2, "idColonia");
            return (Criteria) this;
        }

        public Criteria andIdColoniaNotBetween(Long value1, Long value2) {
            addCriterion("ID_COLONIA not between", value1, value2, "idColonia");
            return (Criteria) this;
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

        public Criteria andIdAlcaldiaMunIsNull() {
            addCriterion("ID_ALCALDIA_MUN is null");
            return (Criteria) this;
        }

        public Criteria andIdAlcaldiaMunIsNotNull() {
            addCriterion("ID_ALCALDIA_MUN is not null");
            return (Criteria) this;
        }

        public Criteria andIdAlcaldiaMunEqualTo(Integer value) {
            addCriterion("ID_ALCALDIA_MUN =", value, "idAlcaldiaMun");
            return (Criteria) this;
        }

        public Criteria andIdAlcaldiaMunNotEqualTo(Integer value) {
            addCriterion("ID_ALCALDIA_MUN <>", value, "idAlcaldiaMun");
            return (Criteria) this;
        }

        public Criteria andIdAlcaldiaMunGreaterThan(Integer value) {
            addCriterion("ID_ALCALDIA_MUN >", value, "idAlcaldiaMun");
            return (Criteria) this;
        }

        public Criteria andIdAlcaldiaMunGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_ALCALDIA_MUN >=", value, "idAlcaldiaMun");
            return (Criteria) this;
        }

        public Criteria andIdAlcaldiaMunLessThan(Integer value) {
            addCriterion("ID_ALCALDIA_MUN <", value, "idAlcaldiaMun");
            return (Criteria) this;
        }

        public Criteria andIdAlcaldiaMunLessThanOrEqualTo(Integer value) {
            addCriterion("ID_ALCALDIA_MUN <=", value, "idAlcaldiaMun");
            return (Criteria) this;
        }

        public Criteria andIdAlcaldiaMunIn(List<Integer> values) {
            addCriterion("ID_ALCALDIA_MUN in", values, "idAlcaldiaMun");
            return (Criteria) this;
        }

        public Criteria andIdAlcaldiaMunNotIn(List<Integer> values) {
            addCriterion("ID_ALCALDIA_MUN not in", values, "idAlcaldiaMun");
            return (Criteria) this;
        }

        public Criteria andIdAlcaldiaMunBetween(Integer value1, Integer value2) {
            addCriterion("ID_ALCALDIA_MUN between", value1, value2, "idAlcaldiaMun");
            return (Criteria) this;
        }

        public Criteria andIdAlcaldiaMunNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_ALCALDIA_MUN not between", value1, value2, "idAlcaldiaMun");
            return (Criteria) this;
        }

        public Criteria andColoniaIsNull() {
            addCriterion("COLONIA is null");
            return (Criteria) this;
        }

        public Criteria andColoniaIsNotNull() {
            addCriterion("COLONIA is not null");
            return (Criteria) this;
        }

        public Criteria andColoniaEqualTo(String value) {
            addCriterion("COLONIA =", value, "colonia");
            return (Criteria) this;
        }

        public Criteria andColoniaNotEqualTo(String value) {
            addCriterion("COLONIA <>", value, "colonia");
            return (Criteria) this;
        }

        public Criteria andColoniaGreaterThan(String value) {
            addCriterion("COLONIA >", value, "colonia");
            return (Criteria) this;
        }

        public Criteria andColoniaGreaterThanOrEqualTo(String value) {
            addCriterion("COLONIA >=", value, "colonia");
            return (Criteria) this;
        }

        public Criteria andColoniaLessThan(String value) {
            addCriterion("COLONIA <", value, "colonia");
            return (Criteria) this;
        }

        public Criteria andColoniaLessThanOrEqualTo(String value) {
            addCriterion("COLONIA <=", value, "colonia");
            return (Criteria) this;
        }

        public Criteria andColoniaLike(String value) {
            addCriterion("COLONIA like", value, "colonia");
            return (Criteria) this;
        }

        public Criteria andColoniaNotLike(String value) {
            addCriterion("COLONIA not like", value, "colonia");
            return (Criteria) this;
        }

        public Criteria andColoniaIn(List<String> values) {
            addCriterion("COLONIA in", values, "colonia");
            return (Criteria) this;
        }

        public Criteria andColoniaNotIn(List<String> values) {
            addCriterion("COLONIA not in", values, "colonia");
            return (Criteria) this;
        }

        public Criteria andColoniaBetween(String value1, String value2) {
            addCriterion("COLONIA between", value1, value2, "colonia");
            return (Criteria) this;
        }

        public Criteria andColoniaNotBetween(String value1, String value2) {
            addCriterion("COLONIA not between", value1, value2, "colonia");
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