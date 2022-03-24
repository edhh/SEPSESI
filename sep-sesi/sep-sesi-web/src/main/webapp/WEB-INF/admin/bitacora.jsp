<%-- 
    Document   : bitacora
    Created on : 15/01/2021, 12:59:11 PM
    Author     : angel.adame
--%>

<%@page language="java" 
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page import="mx.sep.seguridad.util.SeguridadUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<link rel="shortcut icon" href="https://framework-gb.cdn.gob.mx/favicon.ico">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> 
<link rel="stylesheet" type="text/css" href="https://framework-gb.cdn.gob.mx/assets/styles/main.css">

<script type="text/javascript">


</script>


<style>
    #myModal1{
        width: 70% !important;
    }
</style>


<t:particularTemplate>
    <jsp:attribute name="paginaTitulo">      
        Consulta de bitácora      
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body> 

        <div class="container">



            <div ><div class="row">
                    <h4> Consulta de bitácora</h4>
                    <hr class="red">
                </div>
            </div>

            <div class="row">
                <div class="col-md-12" align="center">
                    <h3>Criterios de búsqueda</h3>
                </div>
            </div>

            <div class="row">
                <div id="divErrorPaginaAcces" class="col-md-12"></div>
                <div id="divExitoPaginaAcces" class="col-md-12"></div>
            </div>

            <div class="form-group">
                <div class="row">
                    <div class="col-md-10" id="procesoDiv">
                        <input id="idProceso" name="idProceso" type="hidden">
                        <label class="control-label" for="selecProceso">Proceso:</label>
                        <select class="form-control"  id="selecProceso" name="ur" onClick="asignaProceso()">
                            <option>SELECCIONA </option>
                        </select>
                        <span id="errorProceso" class="help-block"></span>
                    </div>                   
                </div>
            </div>

            <div class="form-group">
                <div class="row">
                    <div class="col-md-10" id="userBitDiv">
                        <label class="control-label" for="userBit">Nombre de usuario:</label>
                        <input class="form-control" id="userBit" placeholder="Nombre de usuario" name="Nombre de Usuario" path="nombreUsuario" 
                               type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="50"/>
                        <span id="errorUserBit" class="help-block"></span>
                    </div>
                </div>
            </div>


            <div class="form-group">
                <div class="row">
                    <div class="col-md-6" id="desdeBitDiv">
                        <label class="control-label" for="fechaDesde">Desde*:</label>
                        <input class="form-control" type="text" id="fechaDesde" name="fechaDesde" placeholder="Selecciona la fecha" readonly=true/>
                        <span id="errorDesdeBit" class="help-block"></span>
                    </div>
                    <div class="col-md-6" id="hastaBitDiv">
                        <label class="control-label" for="fechaHasta">Hasta*:</label>
                        <input class="form-control" type="text" id="fechaHasta" name="fechaHasta" placeholder="Selecciona la fecha" readonly=true/>
                        <span id="errorHastaBit" class="help-block"></span>
                    </div>
                </div>
                <br>
            </div>

            <div class="form-group">
                <p>(*) Campos obligatorios </p>
            </div>

            <div class="row">
                <center>
                    <button id="buscarBit" class="btn btn-primary" type="submit" style="margin-left: 30px;">Buscar</button>
                    <button id="limpiarBit" class="btn btn-primary" type="submit" style="margin-left: 30px;">Limpiar</button>				
                </center>
            </div><br><br><br>
            <div class="table-responsive">
                <table id="resultadosBitacoraTable"></table>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="modalMostrarDetalle" data-backdrop="static" data-keyboard="false" style="overflow-y: scroll;">
                <div class="modal-dialog" id="myModal1">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">
                                Detalle de proceso
                            </h4>
                        </div>
                        <div class="modal-body">

                            <div id="divMensajeAct" style="display: none"></div>
                            <div id="divErrorAct" style="display: none"></div>

                            <form:form id="formDetalleProceso"
                                       method="POST">  
                                <input id="idBitacoraDet"
                                       type="hidden"/>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <textarea id="areaDetalle"
                                                  rows='10'      
                                                  type="text"
                                                  class="form-control" 
                                                  readonly   
                                                  ></textarea>
                                    </div>
                                </div>         

                            </form:form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" id="cerrarModal" 
                                    class="btn btn-primary"
                                    data-dismiss="modal">
                                Cerrar
                            </button>

                        </div>
                    </div>
                </div>
            </div>

            <!-- ----- -->

        </div>

    </jsp:body>
</t:particularTemplate>


<script type="text/javascript" src="http://b.scorecardresearch.com/c2/17183199/ct.js"></script>
<script src="https://framework-gb.cdn.gob.mx/assets/scripts/jquery-ui-datepicker.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/locales/bootstrap-datepicker.es.min.js"></script>
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';</script>
<script src="<c:url value="/static/js/app/admin/bitacora.js" />" rel="text/javascript"></script>		