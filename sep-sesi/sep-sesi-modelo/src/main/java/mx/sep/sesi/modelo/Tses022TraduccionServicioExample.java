package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tses022TraduccionServicioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses022TraduccionServicioExample() {
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

        public Criteria andIdTradServicioIsNull() {
            addCriterion("ID_TRAD_SERVICIO is null");
            return (Criteria) this;
        }

        public Criteria andIdTradServicioIsNotNull() {
            addCriterion("ID_TRAD_SERVICIO is not null");
            return (Criteria) this;
        }

        public Criteria andIdTradServicioEqualTo(Integer value) {
            addCriterion("ID_TRAD_SERVICIO =", value, "idTradServicio");
            return (Criteria) this;
        }

        public Criteria andIdTradServicioNotEqualTo(Integer value) {
            addCriterion("ID_TRAD_SERVICIO <>", value, "idTradServicio");
            return (Criteria) this;
        }

        public Criteria andIdTradServicioGreaterThan(Integer value) {
            addCriterion("ID_TRAD_SERVICIO >", value, "idTradServicio");
            return (Criteria) this;
        }

        public Criteria andIdTradServicioGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_TRAD_SERVICIO >=", value, "idTradServicio");
            return (Criteria) this;
        }

        public Criteria andIdTradServicioLessThan(Integer value) {
            addCriterion("ID_TRAD_SERVICIO <", value, "idTradServicio");
            return (Criteria) this;
        }

        public Criteria andIdTradServicioLessThanOrEqualTo(Integer value) {
            addCriterion("ID_TRAD_SERVICIO <=", value, "idTradServicio");
            return (Criteria) this;
        }

        public Criteria andIdTradServicioIn(List<Integer> values) {
            addCriterion("ID_TRAD_SERVICIO in", values, "idTradServicio");
            return (Criteria) this;
        }

        public Criteria andIdTradServicioNotIn(List<Integer> values) {
            addCriterion("ID_TRAD_SERVICIO not in", values, "idTradServicio");
            return (Criteria) this;
        }

        public Criteria andIdTradServicioBetween(Integer value1, Integer value2) {
            addCriterion("ID_TRAD_SERVICIO between", value1, value2, "idTradServicio");
            return (Criteria) this;
        }

        public Criteria andIdTradServicioNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_TRAD_SERVICIO not between", value1, value2, "idTradServicio");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoIsNull() {
            addCriterion("NOMBRE_METODO is null");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoIsNotNull() {
            addCriterion("NOMBRE_METODO is not null");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoEqualTo(String value) {
            addCriterion("NOMBRE_METODO =", value, "nombreMetodo");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoNotEqualTo(String value) {
            addCriterion("NOMBRE_METODO <>", value, "nombreMetodo");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoGreaterThan(String value) {
            addCriterion("NOMBRE_METODO >", value, "nombreMetodo");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoGreaterThanOrEqualTo(String value) {
            addCriterion("NOMBRE_METODO >=", value, "nombreMetodo");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoLessThan(String value) {
            addCriterion("NOMBRE_METODO <", value, "nombreMetodo");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoLessThanOrEqualTo(String value) {
            addCriterion("NOMBRE_METODO <=", value, "nombreMetodo");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoLike(String value) {
            addCriterion("NOMBRE_METODO like", value, "nombreMetodo");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoNotLike(String value) {
            addCriterion("NOMBRE_METODO not like", value, "nombreMetodo");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoIn(List<String> values) {
            addCriterion("NOMBRE_METODO in", values, "nombreMetodo");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoNotIn(List<String> values) {
            addCriterion("NOMBRE_METODO not in", values, "nombreMetodo");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoBetween(String value1, String value2) {
            addCriterion("NOMBRE_METODO between", value1, value2, "nombreMetodo");
            return (Criteria) this;
        }

        public Criteria andNombreMetodoNotBetween(String value1, String value2) {
            addCriterion("NOMBRE_METODO not between", value1, value2, "nombreMetodo");
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