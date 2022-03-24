package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tses027OperacionEquiposExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses027OperacionEquiposExample() {
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

        public Criteria andIdOperacionEquiposIsNull() {
            addCriterion("ID_OPERACION_EQUIPOS is null");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEquiposIsNotNull() {
            addCriterion("ID_OPERACION_EQUIPOS is not null");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEquiposEqualTo(Long value) {
            addCriterion("ID_OPERACION_EQUIPOS =", value, "idOperacionEquipos");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEquiposNotEqualTo(Long value) {
            addCriterion("ID_OPERACION_EQUIPOS <>", value, "idOperacionEquipos");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEquiposGreaterThan(Long value) {
            addCriterion("ID_OPERACION_EQUIPOS >", value, "idOperacionEquipos");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEquiposGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_OPERACION_EQUIPOS >=", value, "idOperacionEquipos");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEquiposLessThan(Long value) {
            addCriterion("ID_OPERACION_EQUIPOS <", value, "idOperacionEquipos");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEquiposLessThanOrEqualTo(Long value) {
            addCriterion("ID_OPERACION_EQUIPOS <=", value, "idOperacionEquipos");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEquiposIn(List<Long> values) {
            addCriterion("ID_OPERACION_EQUIPOS in", values, "idOperacionEquipos");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEquiposNotIn(List<Long> values) {
            addCriterion("ID_OPERACION_EQUIPOS not in", values, "idOperacionEquipos");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEquiposBetween(Long value1, Long value2) {
            addCriterion("ID_OPERACION_EQUIPOS between", value1, value2, "idOperacionEquipos");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEquiposNotBetween(Long value1, Long value2) {
            addCriterion("ID_OPERACION_EQUIPOS not between", value1, value2, "idOperacionEquipos");
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

        public Criteria andIdUsuarioEqualTo(Long value) {
            addCriterion("ID_USUARIO =", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotEqualTo(Long value) {
            addCriterion("ID_USUARIO <>", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioGreaterThan(Long value) {
            addCriterion("ID_USUARIO >", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_USUARIO >=", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioLessThan(Long value) {
            addCriterion("ID_USUARIO <", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioLessThanOrEqualTo(Long value) {
            addCriterion("ID_USUARIO <=", value, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioIn(List<Long> values) {
            addCriterion("ID_USUARIO in", values, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotIn(List<Long> values) {
            addCriterion("ID_USUARIO not in", values, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioBetween(Long value1, Long value2) {
            addCriterion("ID_USUARIO between", value1, value2, "idUsuario");
            return (Criteria) this;
        }

        public Criteria andIdUsuarioNotBetween(Long value1, Long value2) {
            addCriterion("ID_USUARIO not between", value1, value2, "idUsuario");
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

        public Criteria andIdInmuebleEqualTo(Long value) {
            addCriterion("ID_INMUEBLE =", value, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleNotEqualTo(Long value) {
            addCriterion("ID_INMUEBLE <>", value, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleGreaterThan(Long value) {
            addCriterion("ID_INMUEBLE >", value, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_INMUEBLE >=", value, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleLessThan(Long value) {
            addCriterion("ID_INMUEBLE <", value, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleLessThanOrEqualTo(Long value) {
            addCriterion("ID_INMUEBLE <=", value, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleIn(List<Long> values) {
            addCriterion("ID_INMUEBLE in", values, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleNotIn(List<Long> values) {
            addCriterion("ID_INMUEBLE not in", values, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleBetween(Long value1, Long value2) {
            addCriterion("ID_INMUEBLE between", value1, value2, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdInmuebleNotBetween(Long value1, Long value2) {
            addCriterion("ID_INMUEBLE not between", value1, value2, "idInmueble");
            return (Criteria) this;
        }

        public Criteria andIdEquipoIsNull() {
            addCriterion("ID_EQUIPO is null");
            return (Criteria) this;
        }

        public Criteria andIdEquipoIsNotNull() {
            addCriterion("ID_EQUIPO is not null");
            return (Criteria) this;
        }

        public Criteria andIdEquipoEqualTo(Long value) {
            addCriterion("ID_EQUIPO =", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoNotEqualTo(Long value) {
            addCriterion("ID_EQUIPO <>", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoGreaterThan(Long value) {
            addCriterion("ID_EQUIPO >", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_EQUIPO >=", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoLessThan(Long value) {
            addCriterion("ID_EQUIPO <", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoLessThanOrEqualTo(Long value) {
            addCriterion("ID_EQUIPO <=", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoIn(List<Long> values) {
            addCriterion("ID_EQUIPO in", values, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoNotIn(List<Long> values) {
            addCriterion("ID_EQUIPO not in", values, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoBetween(Long value1, Long value2) {
            addCriterion("ID_EQUIPO between", value1, value2, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoNotBetween(Long value1, Long value2) {
            addCriterion("ID_EQUIPO not between", value1, value2, "idEquipo");
            return (Criteria) this;
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

        public Criteria andEntradaSalidaIsNull() {
            addCriterion("ENTRADA_SALIDA is null");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaIsNotNull() {
            addCriterion("ENTRADA_SALIDA is not null");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaEqualTo(Short value) {
            addCriterion("ENTRADA_SALIDA =", value, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaNotEqualTo(Short value) {
            addCriterion("ENTRADA_SALIDA <>", value, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaGreaterThan(Short value) {
            addCriterion("ENTRADA_SALIDA >", value, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaGreaterThanOrEqualTo(Short value) {
            addCriterion("ENTRADA_SALIDA >=", value, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaLessThan(Short value) {
            addCriterion("ENTRADA_SALIDA <", value, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaLessThanOrEqualTo(Short value) {
            addCriterion("ENTRADA_SALIDA <=", value, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaIn(List<Short> values) {
            addCriterion("ENTRADA_SALIDA in", values, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaNotIn(List<Short> values) {
            addCriterion("ENTRADA_SALIDA not in", values, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaBetween(Short value1, Short value2) {
            addCriterion("ENTRADA_SALIDA between", value1, value2, "entradaSalida");
            return (Criteria) this;
        }

        public Criteria andEntradaSalidaNotBetween(Short value1, Short value2) {
            addCriterion("ENTRADA_SALIDA not between", value1, value2, "entradaSalida");
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