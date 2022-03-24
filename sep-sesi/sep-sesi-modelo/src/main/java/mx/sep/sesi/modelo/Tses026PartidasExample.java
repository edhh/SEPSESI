package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tses026PartidasExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses026PartidasExample() {
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

        public Criteria andProductoIsNull() {
            addCriterion("PRODUCTO is null");
            return (Criteria) this;
        }

        public Criteria andProductoIsNotNull() {
            addCriterion("PRODUCTO is not null");
            return (Criteria) this;
        }

        public Criteria andProductoEqualTo(String value) {
            addCriterion("PRODUCTO =", value, "producto");
            return (Criteria) this;
        }

        public Criteria andProductoNotEqualTo(String value) {
            addCriterion("PRODUCTO <>", value, "producto");
            return (Criteria) this;
        }

        public Criteria andProductoGreaterThan(String value) {
            addCriterion("PRODUCTO >", value, "producto");
            return (Criteria) this;
        }

        public Criteria andProductoGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCTO >=", value, "producto");
            return (Criteria) this;
        }

        public Criteria andProductoLessThan(String value) {
            addCriterion("PRODUCTO <", value, "producto");
            return (Criteria) this;
        }

        public Criteria andProductoLessThanOrEqualTo(String value) {
            addCriterion("PRODUCTO <=", value, "producto");
            return (Criteria) this;
        }

        public Criteria andProductoLike(String value) {
            addCriterion("PRODUCTO like", value, "producto");
            return (Criteria) this;
        }

        public Criteria andProductoNotLike(String value) {
            addCriterion("PRODUCTO not like", value, "producto");
            return (Criteria) this;
        }

        public Criteria andProductoIn(List<String> values) {
            addCriterion("PRODUCTO in", values, "producto");
            return (Criteria) this;
        }

        public Criteria andProductoNotIn(List<String> values) {
            addCriterion("PRODUCTO not in", values, "producto");
            return (Criteria) this;
        }

        public Criteria andProductoBetween(String value1, String value2) {
            addCriterion("PRODUCTO between", value1, value2, "producto");
            return (Criteria) this;
        }

        public Criteria andProductoNotBetween(String value1, String value2) {
            addCriterion("PRODUCTO not between", value1, value2, "producto");
            return (Criteria) this;
        }

        public Criteria andMarcaIsNull() {
            addCriterion("MARCA is null");
            return (Criteria) this;
        }

        public Criteria andMarcaIsNotNull() {
            addCriterion("MARCA is not null");
            return (Criteria) this;
        }

        public Criteria andMarcaEqualTo(String value) {
            addCriterion("MARCA =", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaNotEqualTo(String value) {
            addCriterion("MARCA <>", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaGreaterThan(String value) {
            addCriterion("MARCA >", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaGreaterThanOrEqualTo(String value) {
            addCriterion("MARCA >=", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaLessThan(String value) {
            addCriterion("MARCA <", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaLessThanOrEqualTo(String value) {
            addCriterion("MARCA <=", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaLike(String value) {
            addCriterion("MARCA like", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaNotLike(String value) {
            addCriterion("MARCA not like", value, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaIn(List<String> values) {
            addCriterion("MARCA in", values, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaNotIn(List<String> values) {
            addCriterion("MARCA not in", values, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaBetween(String value1, String value2) {
            addCriterion("MARCA between", value1, value2, "marca");
            return (Criteria) this;
        }

        public Criteria andMarcaNotBetween(String value1, String value2) {
            addCriterion("MARCA not between", value1, value2, "marca");
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