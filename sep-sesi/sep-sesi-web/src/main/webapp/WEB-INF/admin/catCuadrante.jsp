<%-- 
    Document   : catCuadrante
    Created on : 05/11/2020, 11:39:45
    Author     : heriberto.perez
--%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page import="mx.sep.seguridad.util.SeguridadUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<script src="/libs/jquery.min.js"></script>
<script src="/libs/jquery.plugin.js"></script>

<script type="text/javascript">
</script>

<style>
    #myModal1{
        width: 95% !important;
    }
</style>

<t:particularTemplate>
    <jsp:attribute name="paginaTitulo">      
        Catálogo cuadrante / área       
    </jsp:attribute>

    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body> 

        <div class="container">

          

            <div ><div class="row">
                    <h4>Catálogo Cuadrante / Área</h4>
                    <hr class="red">
                </div>
            </div>

            <div class="row">
                <div class="col-md-12" align="center">
                    <h3>Criterios de búsqueda</h3>
                </div>
            </div>
            
              <div class="row">
                <div id="divErrorPaginaCuad" class="col-md-12"></div>
                <div id="divExitoPaginaCuad" class="col-md-12"></div>
            </div>

            <div class="form-group">
                <div class="row">

                    <div class="col-md-6" id="inmuebleDiv">
                        <label class="control-label" for="inmuebleID">Inmueble:</label>
                        <select class="form-control"  id="inmuebleID" name="inmuebleID">
                            <option>SELECCIONA </option>
                        </select>
                        <span id="errorInmueble" class="help-block"></span>
                    </div>
                </div>
            </div>

            <div class="row">
                <center>
                    <button id="buscarCatCuadrante" class="btn btn-primary" type="submit" style="margin-left: 30px;">Buscar</button>
                    <button id="limpiarCatCuadrante" class="btn btn-primary" type="submit" style="margin-left: 30px;">Limpiar</button>
                    <button id="nuevoCuadrante" class="btn btn-primary" style="margin-left: 30px;">
                        <span class="glyphicon glyphicon-plus"></span>
                        Nuevo cuadrante</button>		
                </center>
            </div><br><br><br>
            <div class="table-responsive">
                <table id="resultadosResumenTable"></table>
            </div>

            <div id="divMensaje" 
                 style="display: none">
            </div>
            <div class="modal fade" id="ModalCuadrante" data-backdrop="static" data-keyboard="false" style="overflow-y: scroll;">
                <div class="modal-dialog" id="myModal1">
                    <div class="modal-content" id="myModal2">
                        <div class="modal-header" id="myModal3">
                            <h4 class="modal-title">SESI</h4>

                        </div>
                        <div class="modal-body">
                            <div id="registroCuadranteCorrecto" class="alert alert-success alert-dismissible" style="opacity: 500; display: none;" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                Se agregó el registro exitosamente.
                            </div>

                            <div class="container">
                                <div class="row">
                                    <div id="divErrorPagina" class="col-md-12"></div>
                                    <div id="divExitoPagina" class="col-md-12"></div>
                                </div>
                                <form role="form" enctype="multipart/form-data" target="dummyframe" id="formCarga">
                                    <h3>Datos generales</h3>
                                    <hr class="red">
                                    <input id="idCuadranteCat" name="idCuadranteCat" type="hidden">



                                    <div class="form-group">

                                        <div class="row">

                                            <div class="col-md-6" id="inmuebleModDiv">
                                                <label class="control-label" for="inmuebleMod">Inmueble*:</label>
                                                <select class="form-control"  id="inmuebleMod" name="inmuebleMod">
                                                    <option>SELECCIONA </option>
                                                </select>
                                                <span id="errorInmuebleMod" class="help-block"></span>
                                            </div>

                                            <div class="col-md-6" id="nombreCuadranteDiv">
                                                <label class="control-label" for="nombreCuadrante">Nombre del cuadrante/área*:</label>
                                                <input class="form-control" id="nombreCuadrante" placeholder="Nombre del cuadrante/área" name="nombreCuadrante" 
                                                       type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="20">
                                                <span id="errorNombreCuadrante" class="help-block" ></span>
                                            </div>

                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <p>(*) Campos obligatorios </p>
                                    </div>
                                    <div class="row">
                                        <div class="form-group">
                                            <button class="btn btn-primary pull-right" type="button" onclick="insertaCuadrante()" id="btnGuardar">Guardar</button>
                                            <button class="btn btn-default" type="button" data-dismiss="modal">Cerrar</button>                             
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="alertActualizarPass" data-backdrop="static" data-keyboard="false" style="overflow-y: scroll;">
                <div class="modal-dialog" id="myModal4">
                    <div class="modal-content" id="myModal6">
                        <div class="modal-header" id="myModal7">
                            <h4 class="modal-title">SESI</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <div class="row">     
                                    <p> ¿Est&aacute; seguro de actualizar contrase&ntilde;a?</p>
                                    <p> Si su respuesta es "S&iacute;" deber&aacute; actualizar la contrase&ntilde;a obligatoriamente</p>
                                </div>
                                <div class="row">     
                                    <button class="btn btn-primary pull-right" type="button" onclick="f_pass()" id="btnAlertPass">S&iacute;</button>
                                    <button class="btn btn-default" type="button" data-dismiss="modal" onclick="noUpdate()">Cerrar</button> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:particularTemplate>

<script type="text/javascript" src="http://b.scorecardresearch.com/c2/17183199/ct.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';</script>
<script src="<c:url value="/static/js/app/admin/catCuadrante.js" />" rel="text/javascript"></script>