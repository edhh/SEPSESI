<%-- 
    Document   : ValidacionCredencial
    Created on : 18/03/2021, 18:15:17
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

<t:validacionQR>
    <jsp:attribute name="paginaTitulo">
        Datos del empleado / Prestador de servicios
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body>    
        <div class="container">
		<!--<div class="row small-bottom-buffer">-->
                <br>
                    <div class="row">
                        <div class="col-md-12">
                            <h4>Datos del empleado / Prestador de servicios</h4>
                            <hr class="red">
			</div>
                    </div>
                <div class="row" id="divImagen">            
                            <center>
                                <div id="file-preview-zone"></div>
                            </center>
                            <center>
                                <div id="imageBase"><img id="ItemPreview" src=""></div>
                            </center>
                                        
                        </div>
                <br>
                <div class="col-md-6" id="nombreDiv">
                            <label class="control-label" for="nombre">Nombre:</label>
                            <input class="form-control" id="nombre" placeholder="Nombre" name="Nombre" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="18" disabled/>
                            <span id="errorCurp" class="help-block"></span>
                        </div>
                <div class="col-md-6" id="puestoDiv">
                            <label class="control-label" for="puesto">Puesto:</label>
                            <input class="form-control" id="puesto" placeholder="Puesto" name="Puesto" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="18" disabled/>
                            <span id="errorCurp" class="help-block"></span>
                        </div>
		<div class="col-md-6" id="urDiv">
                            <label class="control-label" for="ur">UR:</label>
                            <input class="form-control" id="ur" placeholder="UR" name="UR" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="18" disabled/>
                            <span id="errorCurp" class="help-block"></span>
                        </div>
                <div class="col-md-6" id="estatusDiv">
                            <label class="control-label" for="estatus">Estatus:</label>
                            <input class="form-control" id="estatus" placeholder="estatus" name="estatus" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="18" disabled/>
                            <span id="errorCurp" class="help-block"></span>
                        </div>

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
</t:validacionQR>   
             

<script type="text/javascript" src="https://b.scorecardresearch.com/c2/17183199/ct.js"></script>
<!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>-->
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';</script>
<script src="<c:url value="/static/js/app/validacionCredencial/validacionCredencial.js" />" rel="text/javascript"></script>	
<script src="<c:url value="/static/js/libs/jquery/jquery.table2excel.js" />" rel="text/javascript"></script>
<script src="<c:url value="/static/js/libs/jquery/xls.core.min.js" />" rel="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.4.0/bootstrap-table.min.js"></script>