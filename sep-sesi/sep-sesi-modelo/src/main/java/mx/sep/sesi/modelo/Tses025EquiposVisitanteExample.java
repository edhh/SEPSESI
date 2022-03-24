package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tses025EquiposVisitanteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses025EquiposVisitanteExample() {
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

        public Criteria andIdEquipoVisIsNull() {
            addCriterion("ID_EQUIPO_VIS is null");
            return (Criteria) this;
        }

        public Criteria andIdEquipoVisIsNotNull() {
            addCriterion("ID_EQUIPO_VIS is not null");
            return (Criteria) this;
        }

        public Criteria andIdEquipoVisEqualTo(Long value) {
            addCriterion("ID_EQUIPO_VIS =", value, "idEquipoVis");
            return (Criteria) this;
        }

        public Criteria andIdEquipoVisNotEqualTo(Long value) {
            addCriterion("ID_EQUIPO_VIS <>", value, "idEquipoVis");
            return (Criteria) this;
        }

        public Criteria andIdEquipoVisGreaterThan(Long value) {
            addCriterion("ID_EQUIPO_VIS >", value, "idEquipoVis");
            return (Criteria) this;
        }

        public Criteria andIdEquipoVisGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_EQUIPO_VIS >=", value, "idEquipoVis");
            return (Criteria) this;
        }

        public Criteria andIdEquipoVisLessThan(Long value) {
            addCriterion("ID_EQUIPO_VIS <", value, "idEquipoVis");
            return (Criteria) this;
        }

        public Criteria andIdEquipoVisLessThanOrEqualTo(Long value) {
            addCriterion("ID_EQUIPO_VIS <=", value, "idEquipoVis");
            return (Criteria) this;
        }

        public Criteria andIdEquipoVisIn(List<Long> values) {
            addCriterion("ID_EQUIPO_VIS in", values, "idEquipoVis");
            return (Criteria) this;
        }

        public Criteria andIdEquipoVisNotIn(List<Long> values) {
            addCriterion("ID_EQUIPO_VIS not in", values, "idEquipoVis");
            return (Criteria) this;
        }

        public Criteria andIdEquipoVisBetween(Long value1, Long value2) {
            addCriterion("ID_EQUIPO_VIS between", value1, value2, "idEquipoVis");
            return (Criteria) this;
        }

        public Criteria andIdEquipoVisNotBetween(Long value1, Long value2) {
            addCriterion("ID_EQUIPO_VIS not between", value1, value2, "idEquipoVis");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteIsNull() {
            addCriterion("ID_VISITANTE is null");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteIsNotNull() {
            addCriterion("ID_VISITANTE is not null");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteEqualTo(Long value) {
            addCriterion("ID_VISITANTE =", value, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteNotEqualTo(Long value) {
            addCriterion("ID_VISITANTE <>", value, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteGreaterThan(Long value) {
            addCriterion("ID_VISITANTE >", value, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_VISITANTE >=", value, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteLessThan(Long value) {
            addCriterion("ID_VISITANTE <", value, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteLessThanOrEqualTo(Long value) {
            addCriterion("ID_VISITANTE <=", value, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteIn(List<Long> values) {
            addCriterion("ID_VISITANTE in", values, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteNotIn(List<Long> values) {
            addCriterion("ID_VISITANTE not in", values, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteBetween(Long value1, Long value2) {
            addCriterion("ID_VISITANTE between", value1, value2, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andIdVisitanteNotBetween(Long value1, Long value2) {
            addCriterion("ID_VISITANTE not between", value1, value2, "idVisitante");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisIsNull() {
            addCriterion("DESCRIPCION_EQUIPO_VIS is null");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisIsNotNull() {
            addCriterion("DESCRIPCION_EQUIPO_VIS is not null");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisEqualTo(String value) {
            addCriterion("DESCRIPCION_EQUIPO_VIS =", value, "descripcionEquipoVis");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisNotEqualTo(String value) {
            addCriterion("DESCRIPCION_EQUIPO_VIS <>", value, "descripcionEquipoVis");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisGreaterThan(String value) {
            addCriterion("DESCRIPCION_EQUIPO_VIS >", value, "descripcionEquipoVis");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPCION_EQUIPO_VIS >=", value, "descripcionEquipoVis");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisLessThan(String value) {
            addCriterion("DESCRIPCION_EQUIPO_VIS <", value, "descripcionEquipoVis");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPCION_EQUIPO_VIS <=", value, "descripcionEquipoVis");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisLike(String value) {
            addCriterion("DESCRIPCION_EQUIPO_VIS like", value, "descripcionEquipoVis");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisNotLike(String value) {
            addCriterion("DESCRIPCION_EQUIPO_VIS not like", value, "descripcionEquipoVis");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisIn(List<String> values) {
            addCriterion("DESCRIPCION_EQUIPO_VIS in", values, "descripcionEquipoVis");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisNotIn(List<String> values) {
            addCriterion("DESCRIPCION_EQUIPO_VIS not in", values, "descripcionEquipoVis");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisBetween(String value1, String value2) {
            addCriterion("DESCRIPCION_EQUIPO_VIS between", value1, value2, "descripcionEquipoVis");
            return (Criteria) this;
        }

        public Criteria andDescripcionEquipoVisNotBetween(String value1, String value2) {
            addCriterion("DESCRIPCION_EQUIPO_VIS not between", value1, value2, "descripcionEquipoVis");
            return (Criteria) this;
        }

        public Criteria andMarcaVisIsNull() {
            addCriterion("MARCA_VIS is null");
            return (Criteria) this;
        }

        public Criteria andMarcaVisIsNotNull() {
            addCriterion("MARCA_VIS is not null");
            return (Criteria) this;
        }

        public Criteria andMarcaVisEqualTo(String value) {
            addCriterion("MARCA_VIS =", value, "marcaVis");
            return (Criteria) this;
        }

        public Criteria andMarcaVisNotEqualTo(String value) {
            addCriterion("MARCA_VIS <>", value, "marcaVis");
            return (Criteria) this;
        }

        public Criteria andMarcaVisGreaterThan(String value) {
            addCriterion("MARCA_VIS >", value, "marcaVis");
            return (Criteria) this;
        }

        public Criteria andMarcaVisGreaterThanOrEqualTo(String value) {
            addCriterion("MARCA_VIS >=", value, "marcaVis");
            return (Criteria) this;
        }

        public Criteria andMarcaVisLessThan(String value) {
            addCriterion("MARCA_VIS <", value, "marcaVis");
            return (Criteria) this;
        }

        public Criteria andMarcaVisLessThanOrEqualTo(String value) {
            addCriterion("MARCA_VIS <=", value, "marcaVis");
            return (Criteria) this;
        }

        public Criteria andMarcaVisLike(String value) {
            addCriterion("MARCA_VIS like", value, "marcaVis");
            return (Criteria) this;
        }

        public Criteria andMarcaVisNotLike(String value) {
            addCriterion("MARCA_VIS not like", value, "marcaVis");
            return (Criteria) this;
        }

        public Criteria andMarcaVisIn(List<String> values) {
            addCriterion("MARCA_VIS in", values, "marcaVis");
            return (Criteria) this;
        }

        public Criteria andMarcaVisNotIn(List<String> values) {
            addCriterion("MARCA_VIS not in", values, "marcaVis");
            return (Criteria) this;
        }

        public Criteria andMarcaVisBetween(String value1, String value2) {
            addCriterion("MARCA_VIS between", value1, value2, "marcaVis");
            return (Criteria) this;
        }

        public Criteria andMarcaVisNotBetween(String value1, String value2) {
            addCriterion("MARCA_VIS not between", value1, value2, "marcaVis");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisIsNull() {
            addCriterion("NUMERO_SERIE_VIS is null");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisIsNotNull() {
            addCriterion("NUMERO_SERIE_VIS is not null");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisEqualTo(String value) {
            addCriterion("NUMERO_SERIE_VIS =", value, "numeroSerieVis");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisNotEqualTo(String value) {
            addCriterion("NUMERO_SERIE_VIS <>", value, "numeroSerieVis");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisGreaterThan(String value) {
            addCriterion("NUMERO_SERIE_VIS >", value, "numeroSerieVis");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisGreaterThanOrEqualTo(String value) {
            addCriterion("NUMERO_SERIE_VIS >=", value, "numeroSerieVis");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisLessThan(String value) {
            addCriterion("NUMERO_SERIE_VIS <", value, "numeroSerieVis");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisLessThanOrEqualTo(String value) {
            addCriterion("NUMERO_SERIE_VIS <=", value, "numeroSerieVis");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisLike(String value) {
            addCriterion("NUMERO_SERIE_VIS like", value, "numeroSerieVis");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisNotLike(String value) {
            addCriterion("NUMERO_SERIE_VIS not like", value, "numeroSerieVis");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisIn(List<String> values) {
            addCriterion("NUMERO_SERIE_VIS in", values, "numeroSerieVis");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisNotIn(List<String> values) {
            addCriterion("NUMERO_SERIE_VIS not in", values, "numeroSerieVis");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisBetween(String value1, String value2) {
            addCriterion("NUMERO_SERIE_VIS between", value1, value2, "numeroSerieVis");
            return (Criteria) this;
        }

        public Criteria andNumeroSerieVisNotBetween(String value1, String value2) {
            addCriterion("NUMERO_SERIE_VIS not between", value1, value2, "numeroSerieVis");
            return (Criteria) this;
        }

        public Criteria andEstatusIsNull() {
            addCriterion("ESTATUS is null");
            return (Criteria) this;
        }

        public Criteria andEstatusIsNotNull() {
            addCriterion("ESTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andEstatusEqualTo(Short value) {
            addCriterion("ESTATUS =", value, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusNotEqualTo(Short value) {
            addCriterion("ESTATUS <>", value, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusGreaterThan(Short value) {
            addCriterion("ESTATUS >", value, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusGreaterThanOrEqualTo(Short value) {
            addCriterion("ESTATUS >=", value, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusLessThan(Short value) {
            addCriterion("ESTATUS <", value, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusLessThanOrEqualTo(Short value) {
            addCriterion("ESTATUS <=", value, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusIn(List<Short> values) {
            addCriterion("ESTATUS in", values, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusNotIn(List<Short> values) {
            addCriterion("ESTATUS not in", values, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusBetween(Short value1, Short value2) {
            addCriterion("ESTATUS between", value1, value2, "estatus");
            return (Criteria) this;
        }

        public Criteria andEstatusNotBetween(Short value1, Short value2) {
            addCriterion("ESTATUS not between", value1, value2, "estatus");
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