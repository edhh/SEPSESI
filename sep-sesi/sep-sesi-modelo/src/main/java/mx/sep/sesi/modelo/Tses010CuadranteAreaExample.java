package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tses010CuadranteAreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses010CuadranteAreaExample() {
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

        public Criteria andIdCuadranteAreaIsNull() {
            addCriterion("ID_CUADRANTE_AREA is null");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaIsNotNull() {
            addCriterion("ID_CUADRANTE_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaEqualTo(Integer value) {
            addCriterion("ID_CUADRANTE_AREA =", value, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaNotEqualTo(Integer value) {
            addCriterion("ID_CUADRANTE_AREA <>", value, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaGreaterThan(Integer value) {
            addCriterion("ID_CUADRANTE_AREA >", value, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_CUADRANTE_AREA >=", value, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaLessThan(Integer value) {
            addCriterion("ID_CUADRANTE_AREA <", value, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaLessThanOrEqualTo(Integer value) {
            addCriterion("ID_CUADRANTE_AREA <=", value, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaIn(List<Integer> values) {
            addCriterion("ID_CUADRANTE_AREA in", values, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaNotIn(List<Integer> values) {
            addCriterion("ID_CUADRANTE_AREA not in", values, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaBetween(Integer value1, Integer value2) {
            addCriterion("ID_CUADRANTE_AREA between", value1, value2, "idCuadranteArea");
            return (Criteria) this;
        }

        public Criteria andIdCuadranteAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_CUADRANTE_AREA not between", value1, value2, "idCuadranteArea");
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

        public Criteria andCuadranteAreaIsNull() {
            addCriterion("CUADRANTE_AREA is null");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaIsNotNull() {
            addCriterion("CUADRANTE_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaEqualTo(String value) {
            addCriterion("CUADRANTE_AREA =", value, "cuadranteArea");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaNotEqualTo(String value) {
            addCriterion("CUADRANTE_AREA <>", value, "cuadranteArea");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaGreaterThan(String value) {
            addCriterion("CUADRANTE_AREA >", value, "cuadranteArea");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaGreaterThanOrEqualTo(String value) {
            addCriterion("CUADRANTE_AREA >=", value, "cuadranteArea");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaLessThan(String value) {
            addCriterion("CUADRANTE_AREA <", value, "cuadranteArea");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaLessThanOrEqualTo(String value) {
            addCriterion("CUADRANTE_AREA <=", value, "cuadranteArea");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaLike(String value) {
            addCriterion("CUADRANTE_AREA like", value, "cuadranteArea");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaNotLike(String value) {
            addCriterion("CUADRANTE_AREA not like", value, "cuadranteArea");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaIn(List<String> values) {
            addCriterion("CUADRANTE_AREA in", values, "cuadranteArea");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaNotIn(List<String> values) {
            addCriterion("CUADRANTE_AREA not in", values, "cuadranteArea");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaBetween(String value1, String value2) {
            addCriterion("CUADRANTE_AREA between", value1, value2, "cuadranteArea");
            return (Criteria) this;
        }

        public Criteria andCuadranteAreaNotBetween(String value1, String value2) {
            addCriterion("CUADRANTE_AREA not between", value1, value2, "cuadranteArea");
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