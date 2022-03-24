<%-- 
    Document   : usuariosPC
    Created on : 16/10/2020, 14:48:50
    Author     : heriberto.perez
--%>

<%@page language="java" 
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page import="mx.sep.seguridad.util.SeguridadUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<script src="/libs/jquery.min.js"></script>
<script src="/libs/jquery.plugin.js"></script>

<script type="text/javascript">
</script>

<t:particularTemplate>
    <jsp:attribute name="paginaTitulo">
        Búsqueda de usuarios
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body>    
        <div class="container">
		<!--<div class="row small-bottom-buffer">-->
                    <div class="row">
                        <div class="col-md-12">
                            <h4>Búsqueda de usuarios</h4>
                            <hr class="red">
			</div>
                    </div>
		<!--</div>-->
<!--		<div class="row small-bottom-buffer">-->
                    <div class="row">
                        <div class="col-md-12" align="center">
                            <h3>Criterios de búsqueda</h3>
			</div>
                    </div>
		<!--</div>-->	
		<div class="form-group">
                    <div class="row">
			<div class="col-md-6" id="rolDiv">
                            <label class="control-label" for="rol" >Tipo de persona*:</label>
                            <select class="form-control" id="rol">
                                <option>Selecciona </option>
                            </select>
                            <span id="errorRol" class="help-block"></span>
			</div>
                        <div class="col-md-6" id="curpDiv">
                            <label class="control-label" for="curp">CURP:</label>
                            <input class="form-control" id="curp" placeholder="CURP" name="curp" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="18"/>
                            <span id="errorCurp" class="help-block"></span>
                        </div>
                    </div>
		</div>
		
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-6" id="inmuebleDiv">
                            <label class="control-label" for="inmuebleID">Inmueble:</label>
                            <select class="form-control" id="inmuebleID">
                                <option>Selecciona </option>
                            </select>
                            <span id="errorInmueble" class="help-block"></span>
                        </div>
                        <div class="col-md-6" id="urDiv">
                            <label class="control-label" for="ur">Unidad Responsable:</label>
                                <select class="form-control"  id="ur" >
                                    <option>Selecciona </option>
                                </select>
                                <span id="ur" class="help-block"></span>
                        </div>                                                                                                                              
                    </div>
                </div>
                <div class="form-group">
                    <p>(*) Campos obligatorios </p>
                </div>
                <br/>   
		<div class="row">
                    <center>
                        <button id="buscar" class="btn btn-primary" type="submit" style="margin-left: 30px;">Buscar</button>
<!--                        <button class="btn btn-primary" type="submit" style="margin-left: 30px;">Exportar datos a excel</button>-->
                        <button id="limpiar" class="btn btn-primary" type="submit" style="margin-left: 30px;">Limpiar</button>	
                        <button id="exportar" class="btn btn-primary" type="submit" style="margin-left: 30px;">Exportar datos a excel</button>			
                    </center>
		</div><br><br><br>
		<div class="table-responsive">
                    <table id="resultadosResumenTable"></table>
                </div>
<!--                <center>
                    <button id="nuevoEmpleado" class="btn btn-primary">
                        <span class="glyphicon glyphicon-plus"></span>
                        Nuevo empleado
                    </button>
                </center><br><br><br>-->
            </div>                                
    </jsp:body>
</t:particularTemplate>   
             

<script type="text/javascript" src="http://b.scorecardresearch.com/c2/17183199/ct.js"></script>
<!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>-->
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';</script>
<script src="<c:url value="/static/js/app/Consulta/usuariosPC.js" />" rel="text/javascript"></script>	
<script src="<c:url value="/static/js/libs/jquery/jquery.table2excel.js" />" rel="text/javascript"></script>
<script src="<c:url value="/static/js/libs/jquery/xls.core.min.js" />" rel="text/javascript"></script>
<script src="<c:url value="/static/js/libs/bootstrap-datepicker/bootstrap-datepicker.js" />" rel="text/javascript"></script>
<link rel="stylesheet" href="<c:url value="/static/js/libs/bootstrap-datepicker/css/datepicker.js" />" rel="text/javascript"></script>