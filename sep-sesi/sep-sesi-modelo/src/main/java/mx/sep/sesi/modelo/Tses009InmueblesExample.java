package mx.sep.sesi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tses009InmueblesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tses009InmueblesExample() {
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

        public Criteria andClaveInmuebleIsNull() {
            addCriterion("CLAVE_INMUEBLE is null");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleIsNotNull() {
            addCriterion("CLAVE_INMUEBLE is not null");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleEqualTo(String value) {
            addCriterion("CLAVE_INMUEBLE =", value, "claveInmueble");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleNotEqualTo(String value) {
            addCriterion("CLAVE_INMUEBLE <>", value, "claveInmueble");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleGreaterThan(String value) {
            addCriterion("CLAVE_INMUEBLE >", value, "claveInmueble");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleGreaterThanOrEqualTo(String value) {
            addCriterion("CLAVE_INMUEBLE >=", value, "claveInmueble");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleLessThan(String value) {
            addCriterion("CLAVE_INMUEBLE <", value, "claveInmueble");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleLessThanOrEqualTo(String value) {
            addCriterion("CLAVE_INMUEBLE <=", value, "claveInmueble");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleLike(String value) {
            addCriterion("CLAVE_INMUEBLE like", value, "claveInmueble");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleNotLike(String value) {
            addCriterion("CLAVE_INMUEBLE not like", value, "claveInmueble");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleIn(List<String> values) {
            addCriterion("CLAVE_INMUEBLE in", values, "claveInmueble");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleNotIn(List<String> values) {
            addCriterion("CLAVE_INMUEBLE not in", values, "claveInmueble");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleBetween(String value1, String value2) {
            addCriterion("CLAVE_INMUEBLE between", value1, value2, "claveInmueble");
            return (Criteria) this;
        }

        public Criteria andClaveInmuebleNotBetween(String value1, String value2) {
            addCriterion("CLAVE_INMUEBLE not between", value1, value2, "claveInmueble");
            return (Criteria) this;
        }

        public Criteria andDenominacionIsNull() {
            addCriterion("DENOMINACION is null");
            return (Criteria) this;
        }

        public Criteria andDenominacionIsNotNull() {
            addCriterion("DENOMINACION is not null");
            return (Criteria) this;
        }

        public Criteria andDenominacionEqualTo(String value) {
            addCriterion("DENOMINACION =", value, "denominacion");
            return (Criteria) this;
        }

        public Criteria andDenominacionNotEqualTo(String value) {
            addCriterion("DENOMINACION <>", value, "denominacion");
            return (Criteria) this;
        }

        public Criteria andDenominacionGreaterThan(String value) {
            addCriterion("DENOMINACION >", value, "denominacion");
            return (Criteria) this;
        }

        public Criteria andDenominacionGreaterThanOrEqualTo(String value) {
            addCriterion("DENOMINACION >=", value, "denominacion");
            return (Criteria) this;
        }

        public Criteria andDenominacionLessThan(String value) {
            addCriterion("DENOMINACION <", value, "denominacion");
            return (Criteria) this;
        }

        public Criteria andDenominacionLessThanOrEqualTo(String value) {
            addCriterion("DENOMINACION <=", value, "denominacion");
            return (Criteria) this;
        }

        public Criteria andDenominacionLike(String value) {
            addCriterion("DENOMINACION like", value, "denominacion");
            return (Criteria) this;
        }

        public Criteria andDenominacionNotLike(String value) {
            addCriterion("DENOMINACION not like", value, "denominacion");
            return (Criteria) this;
        }

        public Criteria andDenominacionIn(List<String> values) {
            addCriterion("DENOMINACION in", values, "denominacion");
            return (Criteria) this;
        }

        public Criteria andDenominacionNotIn(List<String> values) {
            addCriterion("DENOMINACION not in", values, "denominacion");
            return (Criteria) this;
        }

        public Criteria andDenominacionBetween(String value1, String value2) {
            addCriterion("DENOMINACION between", value1, value2, "denominacion");
            return (Criteria) this;
        }

        public Criteria andDenominacionNotBetween(String value1, String value2) {
            addCriterion("DENOMINACION not between", value1, value2, "denominacion");
            return (Criteria) this;
        }

        public Criteria andCalleIsNull() {
            addCriterion("CALLE is null");
            return (Criteria) this;
        }

        public Criteria andCalleIsNotNull() {
            addCriterion("CALLE is not null");
            return (Criteria) this;
        }

        public Criteria andCalleEqualTo(String value) {
            addCriterion("CALLE =", value, "calle");
            return (Criteria) this;
        }

        public Criteria andCalleNotEqualTo(String value) {
            addCriterion("CALLE <>", value, "calle");
            return (Criteria) this;
        }

        public Criteria andCalleGreaterThan(String value) {
            addCriterion("CALLE >", value, "calle");
            return (Criteria) this;
        }

        public Criteria andCalleGreaterThanOrEqualTo(String value) {
            addCriterion("CALLE >=", value, "calle");
            return (Criteria) this;
        }

        public Criteria andCalleLessThan(String value) {
            addCriterion("CALLE <", value, "calle");
            return (Criteria) this;
        }

        public Criteria andCalleLessThanOrEqualTo(String value) {
            addCriterion("CALLE <=", value, "calle");
            return (Criteria) this;
        }

        public Criteria andCalleLike(String value) {
            addCriterion("CALLE like", value, "calle");
            return (Criteria) this;
        }

        public Criteria andCalleNotLike(String value) {
            addCriterion("CALLE not like", value, "calle");
            return (Criteria) this;
        }

        public Criteria andCalleIn(List<String> values) {
            addCriterion("CALLE in", values, "calle");
            return (Criteria) this;
        }

        public Criteria andCalleNotIn(List<String> values) {
            addCriterion("CALLE not in", values, "calle");
            return (Criteria) this;
        }

        public Criteria andCalleBetween(String value1, String value2) {
            addCriterion("CALLE between", value1, value2, "calle");
            return (Criteria) this;
        }

        public Criteria andCalleNotBetween(String value1, String value2) {
            addCriterion("CALLE not between", value1, value2, "calle");
            return (Criteria) this;
        }

        public Criteria andNumeroIsNull() {
            addCriterion("NUMERO is null");
            return (Criteria) this;
        }

        public Criteria andNumeroIsNotNull() {
            addCriterion("NUMERO is not null");
            return (Criteria) this;
        }

        public Criteria andNumeroEqualTo(String value) {
            addCriterion("NUMERO =", value, "numero");
            return (Criteria) this;
        }

        public Criteria andNumeroNotEqualTo(String value) {
            addCriterion("NUMERO <>", value, "numero");
            return (Criteria) this;
        }

        public Criteria andNumeroGreaterThan(String value) {
            addCriterion("NUMERO >", value, "numero");
            return (Criteria) this;
        }

        public Criteria andNumeroGreaterThanOrEqualTo(String value) {
            addCriterion("NUMERO >=", value, "numero");
            return (Criteria) this;
        }

        public Criteria andNumeroLessThan(String value) {
            addCriterion("NUMERO <", value, "numero");
            return (Criteria) this;
        }

        public Criteria andNumeroLessThanOrEqualTo(String value) {
            addCriterion("NUMERO <=", value, "numero");
            return (Criteria) this;
        }

        public Criteria andNumeroLike(String value) {
            addCriterion("NUMERO like", value, "numero");
            return (Criteria) this;
        }

        public Criteria andNumeroNotLike(String value) {
            addCriterion("NUMERO not like", value, "numero");
            return (Criteria) this;
        }

        public Criteria andNumeroIn(List<String> values) {
            addCriterion("NUMERO in", values, "numero");
            return (Criteria) this;
        }

        public Criteria andNumeroNotIn(List<String> values) {
            addCriterion("NUMERO not in", values, "numero");
            return (Criteria) this;
        }

        public Criteria andNumeroBetween(String value1, String value2) {
            addCriterion("NUMERO between", value1, value2, "numero");
            return (Criteria) this;
        }

        public Criteria andNumeroNotBetween(String value1, String value2) {
            addCriterion("NUMERO not between", value1, value2, "numero");
            return (Criteria) this;
        }

        public Criteria andCpIsNull() {
            addCriterion("CP is null");
            return (Criteria) this;
        }

        public Criteria andCpIsNotNull() {
            addCriterion("CP is not null");
            return (Criteria) this;
        }

        public Criteria andCpEqualTo(String value) {
            addCriterion("CP =", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpNotEqualTo(String value) {
            addCriterion("CP <>", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpGreaterThan(String value) {
            addCriterion("CP >", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpGreaterThanOrEqualTo(String value) {
            addCriterion("CP >=", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpLessThan(String value) {
            addCriterion("CP <", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpLessThanOrEqualTo(String value) {
            addCriterion("CP <=", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpLike(String value) {
            addCriterion("CP like", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpNotLike(String value) {
            addCriterion("CP not like", value, "cp");
            return (Criteria) this;
        }

        public Criteria andCpIn(List<String> values) {
            addCriterion("CP in", values, "cp");
            return (Criteria) this;
        }

        public Criteria andCpNotIn(List<String> values) {
            addCriterion("CP not in", values, "cp");
            return (Criteria) this;
        }

        public Criteria andCpBetween(String value1, String value2) {
            addCriterion("CP between", value1, value2, "cp");
            return (Criteria) this;
        }

        public Criteria andCpNotBetween(String value1, String value2) {
            addCriterion("CP not between", value1, value2, "cp");
            return (Criteria) this;
        }

        public Criteria andNumAccesosIsNull() {
            addCriterion("NUM_ACCESOS is null");
            return (Criteria) this;
        }

        public Criteria andNumAccesosIsNotNull() {
            addCriterion("NUM_ACCESOS is not null");
            return (Criteria) this;
        }

        public Criteria andNumAccesosEqualTo(Short value) {
            addCriterion("NUM_ACCESOS =", value, "numAccesos");
            return (Criteria) this;
        }

        public Criteria andNumAccesosNotEqualTo(Short value) {
            addCriterion("NUM_ACCESOS <>", value, "numAccesos");
            return (Criteria) this;
        }

        public Criteria andNumAccesosGreaterThan(Short value) {
            addCriterion("NUM_ACCESOS >", value, "numAccesos");
            return (Criteria) this;
        }

        public Criteria andNumAccesosGreaterThanOrEqualTo(Short value) {
            addCriterion("NUM_ACCESOS >=", value, "numAccesos");
            return (Criteria) this;
        }

        public Criteria andNumAccesosLessThan(Short value) {
            addCriterion("NUM_ACCESOS <", value, "numAccesos");
            return (Criteria) this;
        }

        public Criteria andNumAccesosLessThanOrEqualTo(Short value) {
            addCriterion("NUM_ACCESOS <=", value, "numAccesos");
            return (Criteria) this;
        }

        public Criteria andNumAccesosIn(List<Short> values) {
            addCriterion("NUM_ACCESOS in", values, "numAccesos");
            return (Criteria) this;
        }

        public Criteria andNumAccesosNotIn(List<Short> values) {
            addCriterion("NUM_ACCESOS not in", values, "numAccesos");
            return (Criteria) this;
        }

        public Criteria andNumAccesosBetween(Short value1, Short value2) {
            addCriterion("NUM_ACCESOS between", value1, value2, "numAccesos");
            return (Criteria) this;
        }

        public Criteria andNumAccesosNotBetween(Short value1, Short value2) {
            addCriterion("NUM_ACCESOS not between", value1, value2, "numAccesos");
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