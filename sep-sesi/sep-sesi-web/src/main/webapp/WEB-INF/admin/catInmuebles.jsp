<%-- 
    Document   : catInmuebles
    Created on : 5/11/2020, 12:17:10 PM
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
        width: 95% !important;
    }
</style>


<t:particularTemplate>
    <jsp:attribute name="paginaTitulo">      
        Catálogo de inmuebles       
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body> 

        <div class="container">

            <div ><div class="row">
                    <h4>Catálogo de inmuebles</h4>
                    <hr class="red">
                </div>
            </div>

            <div class="row">
                <div class="col-md-12" align="center">
                    <h3>Criterios de búsqueda</h3>
                </div>
            </div>

            <div class="form-group">
                <div class="row">
                    <div class="col-md-6" id="inmuebleCatInmuebDiv">
                        <input id="idInmuebleCatInmue" name="idInmuebleCatInmue" type="hidden">
                        <label class="control-label" for="inmuebleCatInmueb">Inmueble:</label>
                        <select class="form-control"  id="inmuebleCatInmueb" name="inmuebleCatInmueb" onChange="asignarInmueble()">
                            <option>SELECCIONA </option>
                        </select>
                        <span id="errorInmuebleCatInmueb" class="help-block"></span>
                    </div>
                </div>
            </div>

            <div class="row">
                <center>
                    <button id="buscarCatInmueble" class="btn btn-primary" type="submit" style="margin-left: 30px;">Buscar</button>
                    <button id="limpiarCatInmueble" class="btn btn-primary" type="submit" style="margin-left: 30px;">Limpiar</button>
                    <button id="nuevoInmueble" class="btn btn-primary" style="margin-left: 30px;">
                        <span class="glyphicon glyphicon-plus"></span>
                        Nuevo inmueble</button>		
                </center>
            </div><br><br><br>
            <div class="table-responsive">
                <table id="resultadosInmuebleTable"></table>
            </div>

            <div id="divMensaje" 
                 style="display: none">
            </div>

            <!----Modal----->

            <div class="modal fade" id="ModalInmuebles" data-backdrop="static" data-keyboard="false" style="overflow-y: scroll;">
                <div class="modal-dialog" id="myModal1">
                    <div class="modal-content" id="myModal2">
                        <div class="modal-header" id="myModal3">
                            <h4 class="modal-title">SESI</h4>

                        </div>

                        <div class="container">
                            <div class="row">
                                <div id="divErrorPagina" class="col-md-12"></div>
                                <div id="divExitoPagina" class="col-md-12"></div>
                            </div>
                            <h3>Datos del inmueble</h3>
                            <hr class="red">
                            <input id="idInmuebleCat" name="idInmuebleCat" type="hidden">
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-md-6" id="denominacionDiv">
                                        <label class="control-label" for="denominacionInm">Denominaci&oacute;n*:</label>
                                        <input class="form-control" id="denominacionInm" placeholder="Denominaci&oacute;n" name="denominacion" path="denominacion" 
                                               type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="50"/>
                                        <span id="errorDenominacion" class="help-block"></span>
                                    </div>

                                    <div class="col-md-6" id="entidadFedDiv">
                                        <!--input id="idEntidadFed" name="idEntidadFed" type="hidden"-->
                                        <label class="control-label" for="entidadFed">Entidad Federativa*:</label>
                                        <select class="form-control"  id="entidadFed" name="entidadFed" onChange="obtenerAlcaldiaMun()">
                                            <option>SELECCIONA </option>
                                        </select>
                                        <span id="errorEntidad" class="help-block" ></span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col-md-6" id="alcaldiaDiv">
                                        <!--input id="idAlcaldiaInm" name="idAlcaldiaInm" type="hidden"-->
                                        <label class="control-label" for="alcaldia">Alcald&iacute;a o Municipio*:</label>
                                        <select class="form-control"  id="alcaldiaInm" name="alcaldia" onChange="obtenerColonia()">
                                            <option>SELECCIONA </option>
                                        </select>
                                        <span id="errorAlcaldia" class="help-block" ></span>
                                    </div>                                   

                                    <div class="col-md-6" id="coloniaDiv">
                                        <input id="idColonia" name="idColonia" type="hidden">
                                        <label class="control-label" for="coloniaInm">Colonia*:</label>
                                        <select class="form-control"  id="coloniaInm" name="colonia" onClick="asignaColonia()">
                                            <option>SELECCIONA </option>
                                        </select>
                                        <span id="errorColonia" class="help-block"></span>
                                    </div>                            
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col-md-6" id="calleInmDiv">
                                        <label class="control-label" for="calleInm">Calle*:</label>
                                        <input class="form-control" id="calleInm" placeholder="Calle" name="calle" path="calle" 
                                               type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="50"/>
                                        <span id="errorCalle" class="help-block"></span>
                                    </div>

                                    <div class="col-md-3" id="numeroInmDiv">
                                        <label class="control-label" for="numeroInm">N&uacute;mero*:</label>
                                        <input class="form-control" id="numeroInm" placeholder="N&uacute;mero" name="numero" path="numero" 
                                               type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="10"/>
                                        <span id="errorNumero" class="help-block"></span>
                                    </div>

                                    <div class="col-md-3" id="cpInmDiv">
                                        <label class="control-label" for="cpInm">CP*:</label>
                                        <input class="form-control" id="cpInm" placeholder="CP" name="cp" path="cp" 
                                               type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="5"/>
                                        <span id="errorCP" class="help-block"></span>
                                    </div>

                                </div>
                            </div>

                            <div class="form-group">
                                <div class="row">

                                    <div class="col-md-4" id="claveInmDiv">
                                        <label class="control-label" for="claveInm">Clave del inmueble:</label>
                                        <input class="form-control" id="claveInm" placeholder="Clave" name="clave" path="clave" 
                                               type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="15"/>
                                        <span id="errorClaveInm" class="help-block"></span>
                                    </div>

                                    <div class="col-md-4" id="numeroAccInmDiv">
                                        <label class="control-label" for="numeroAccInm">N&uacute;mero de accesos:</label>
                                        <input class="form-control" id="numeroAccInm" placeholder="No. de Accesos" name="numeroAcc" path="numero" 
                                               type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="10"/>
                                        <span id="errorNumeroAcc" class="help-block"></span>
                                    </div>

                                    <div class="col-md-4" id="estatusInmDiv">
                                        <label class="control-label" for="estatusInm">Estatus*:</label>
                                        <select class="form-control" id="estatusInm"  name="estatus">
                                            <option value="">SELECCIONA</option>
                                            <option value="1">ACTIVO</option>
                                            <option value="0">INACTIVO</option>
                                        </select>
                                        <span id="errorEstatusInm" class="help-block"></span>
                                    </div>

                                </div>
                            </div>

                            <div class="form-group">
                                <p>(*) Campos obligatorios </p>
                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <button class="btn btn-primary pull-right" type="button" onclick="insertaInmuebleCat()" id="btnGuardarInmueble">Guardar</button>
                                    <button class="btn btn-default" type="button" data-dismiss="modal" onclick="cerrarModalCat()">Cerrar</button>                             
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
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';</script>
<script src="<c:url value="/static/js/app/admin/catInmuebles.js" />" rel="text/javascript"></script>		