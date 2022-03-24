package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tses021BitacoraExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses021BitacoraExample() {
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

        public Criteria andIdBitacoraIsNull() {
            addCriterion("ID_BITACORA is null");
            return (Criteria) this;
        }

        public Criteria andIdBitacoraIsNotNull() {
            addCriterion("ID_BITACORA is not null");
            return (Criteria) this;
        }

        public Criteria andIdBitacoraEqualTo(Long value) {
            addCriterion("ID_BITACORA =", value, "idBitacora");
            return (Criteria) this;
        }

        public Criteria andIdBitacoraNotEqualTo(Long value) {
            addCriterion("ID_BITACORA <>", value, "idBitacora");
            return (Criteria) this;
        }

        public Criteria andIdBitacoraGreaterThan(Long value) {
            addCriterion("ID_BITACORA >", value, "idBitacora");
            return (Criteria) this;
        }

        public Criteria andIdBitacoraGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_BITACORA >=", value, "idBitacora");
            return (Criteria) this;
        }

        public Criteria andIdBitacoraLessThan(Long value) {
            addCriterion("ID_BITACORA <", value, "idBitacora");
            return (Criteria) this;
        }

        public Criteria andIdBitacoraLessThanOrEqualTo(Long value) {
            addCriterion("ID_BITACORA <=", value, "idBitacora");
            return (Criteria) this;
        }

        public Criteria andIdBitacoraIn(List<Long> values) {
            addCriterion("ID_BITACORA in", values, "idBitacora");
            return (Criteria) this;
        }

        public Criteria andIdBitacoraNotIn(List<Long> values) {
            addCriterion("ID_BITACORA not in", values, "idBitacora");
            return (Criteria) this;
        }

        public Criteria andIdBitacoraBetween(Long value1, Long value2) {
            addCriterion("ID_BITACORA between", value1, value2, "idBitacora");
            return (Criteria) this;
        }

        public Criteria andIdBitacoraNotBetween(Long value1, Long value2) {
            addCriterion("ID_BITACORA not between", value1, value2, "idBitacora");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioIsNull() {
            addCriterion("ID_USUARIO is null");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioIsNotNull() {
            addCriterion("ID_USUARIO is not null");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioEqualTo(Integer value) {
            addCriterion("ID_USUARIO =", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotEqualTo(Integer value) {
            addCriterion("ID_USUARIO <>", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioGreaterThan(Integer value) {
            addCriterion("ID_USUARIO >", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_USUARIO >=", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioLessThan(Integer value) {
            addCriterion("ID_USUARIO <", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioLessThanOrEqualTo(Integer value) {
            addCriterion("ID_USUARIO <=", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioIn(List<Integer> values) {
            addCriterion("ID_USUARIO in", values, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotIn(List<Integer> values) {
            addCriterion("ID_USUARIO not in", values, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioBetween(Integer value1, Integer value2) {
            addCriterion("ID_USUARIO between", value1, value2, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_USUARIO not between", value1, value2, "idUsuario");
            return (Criteria) this;
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

        public Criteria andProcesoIsNull() {
            addCriterion("PROCESO is null");
            return (Criteria) this;
        }

        public Criteria andProcesoIsNotNull() {
            addCriterion("PROCESO is not null");
            return (Criteria) this;
        }

        public Criteria andProcesoEqualTo(String value) {
            addCriterion("PROCESO =", value, "proceso");
            return (Criteria) this;
        }

        public Criteria andProcesoNotEqualTo(String value) {
            addCriterion("PROCESO <>", value, "proceso");
            return (Criteria) this;
        }

        public Criteria andProcesoGreaterThan(String value) {
            addCriterion("PROCESO >", value, "proceso");
            return (Criteria) this;
        }

        public Criteria andProcesoGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESO >=", value, "proceso");
            return (Criteria) this;
        }

        public Criteria andProcesoLessThan(String value) {
            addCriterion("PROCESO <", value, "proceso");
            return (Criteria) this;
        }

        public Criteria andProcesoLessThanOrEqualTo(String value) {
            addCriterion("PROCESO <=", value, "proceso");
            return (Criteria) this;
        }

        public Criteria andProcesoLike(String value) {
            addCriterion("PROCESO like", value, "proceso");
            return (Criteria) this;
        }

        public Criteria andProcesoNotLike(String value) {
            addCriterion("PROCESO not like", value, "proceso");
            return (Criteria) this;
        }

        public Criteria andProcesoIn(List<String> values) {
            addCriterion("PROCESO in", values, "proceso");
            return (Criteria) this;
        }

        public Criteria andProcesoNotIn(List<String> values) {
            addCriterion("PROCESO not in", values, "proceso");
            return (Criteria) this;
        }

        public Criteria andProcesoBetween(String value1, String value2) {
            addCriterion("PROCESO between", value1, value2, "proceso");
            return (Criteria) this;
        }

        public Criteria andProcesoNotBetween(String value1, String value2) {
            addCriterion("PROCESO not between", value1, value2, "proceso");
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

        public Criteria andDetalleIsNull() {
            addCriterion("DETALLE is null");
            return (Criteria) this;
        }

        public Criteria andDetalleIsNotNull() {
            addCriterion("DETALLE is not null");
            return (Criteria) this;
        }

        public Criteria andDetalleEqualTo(String value) {
            addCriterion("DETALLE =", value, "detalle");
            return (Criteria) this;
        }

        public Criteria andDetalleNotEqualTo(String value) {
            addCriterion("DETALLE <>", value, "detalle");
            return (Criteria) this;
        }

        public Criteria andDetalleGreaterThan(String value) {
            addCriterion("DETALLE >", value, "detalle");
            return (Criteria) this;
        }

        public Criteria andDetalleGreaterThanOrEqualTo(String value) {
            addCriterion("DETALLE >=", value, "detalle");
            return (Criteria) this;
        }

        public Criteria andDetalleLessThan(String value) {
            addCriterion("DETALLE <", value, "detalle");
            return (Criteria) this;
        }

        public Criteria andDetalleLessThanOrEqualTo(String value) {
            addCriterion("DETALLE <=", value, "detalle");
            return (Criteria) this;
        }

        public Criteria andDetalleLike(String value) {
            addCriterion("DETALLE like", value, "detalle");
            return (Criteria) this;
        }

        public Criteria andDetalleNotLike(String value) {
            addCriterion("DETALLE not like", value, "detalle");
            return (Criteria) this;
        }

        public Criteria andDetalleIn(List<String> values) {
            addCriterion("DETALLE in", values, "detalle");
            return (Criteria) this;
        }

        public Criteria andDetalleNotIn(List<String> values) {
            addCriterion("DETALLE not in", values, "detalle");
            return (Criteria) this;
        }

        public Criteria andDetalleBetween(String value1, String value2) {
            addCriterion("DETALLE between", value1, value2, "detalle");
            return (Criteria) this;
        }

        public Criteria andDetalleNotBetween(String value1, String value2) {
            addCriterion("DETALLE not between", value1, value2, "detalle");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionIsNull() {
            addCriterion("FECHA_OPERACION is null");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionIsNotNull() {
            addCriterion("FECHA_OPERACION is not null");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionEqualTo(Date value) {
            addCriterion("FECHA_OPERACION =", value, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionNotEqualTo(Date value) {
            addCriterion("FECHA_OPERACION <>", value, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionGreaterThan(Date value) {
            addCriterion("FECHA_OPERACION >", value, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionGreaterThanOrEqualTo(Date value) {
            addCriterion("FECHA_OPERACION >=", value, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionLessThan(Date value) {
            addCriterion("FECHA_OPERACION <", value, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionLessThanOrEqualTo(Date value) {
            addCriterion("FECHA_OPERACION <=", value, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionIn(List<Date> values) {
            addCriterion("FECHA_OPERACION in", values, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionNotIn(List<Date> values) {
            addCriterion("FECHA_OPERACION not in", values, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionBetween(Date value1, Date value2) {
            addCriterion("FECHA_OPERACION between", value1, value2, "fechaOperacion");
            return (Criteria) this;
        }

        public Criteria andFechaOperacionNotBetween(Date value1, Date value2) {
            addCriterion("FECHA_OPERACION not between", value1, value2, "fechaOperacion");
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