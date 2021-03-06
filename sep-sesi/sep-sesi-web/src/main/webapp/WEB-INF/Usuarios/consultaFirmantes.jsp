<%-- 
    Document   : consultaFirmantes
    Created on : 28/07/2020, 05:05:46 PM
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
        Registro de firmantes
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body>   
        <div class="container">

            <div class="row">
                <div class="col-md-12">
                    <h4>Consulta de Firmantes</h4>
                    <hr class="red">
                </div>
            </div>

            <div class="row">
                <div class="col-md-12" align="center">
                    <h3>Criterios de búsqueda</h3>
                </div>
            </div>

            <div class="row">
                <div id="divErrorPagina" class="col-md-12"></div>
                <div id="divExitoPagina" class="col-md-12"></div>
            </div>

            <div class="form-group">
                <div class="row">
                    <div class="col-md-10" id="urFirmDiv">
                        <input id="idURFirm" name="idURFirm" type="hidden">
                        <label class="control-label" for="urFirm">Unidad Responsable:</label>
                        <select class="form-control"  id="urFirm" name="ur" onClick="asignaUR()">
                            <option>SELECCIONA </option>
                        </select>
                        <span id="errorUrFirm" class="help-block"></span>
                    </div>                   
                </div>
            </div>

            <div class="row">
                <center>
                    <button id="buscarFirm" class="btn btn-primary" type="submit" style="margin-left: 30px;">Buscar</button>
                    <button id="limpiarFirm" class="btn btn-primary" type="submit" style="margin-left: 30px;">Limpiar</button>
                    <button id="nuevoFirmante" class="btn btn-primary" style="margin-left: 30px;">
                        <span class="glyphicon glyphicon-plus"></span>
                        Nuevo firmante</button>		
                </center>
            </div><br><br><br>
            <div class="table-responsive">
                <table id="resultadosFirmantesTable"></table>
            </div>

            <div class="modal fade" id="ModalFirmantes" data-backdrop="static" data-keyboard="false" style="overflow-y: scroll;">
                <div class="modal-dialog" id="myModal1">
                    <div class="modal-content" id="myModal2">
                        <div class="modal-header" id="myModal3">
                            <h4 class="modal-title">SESI</h4>

                        </div>
                        <div class="modal-body">
                            <div id="registroFirmCorrecto" class="alert alert-success alert-dismissible" style="opacity: 500; display: none;" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                Se agregó el registro exitosamente.
                            </div>
                            <div class="container">
                                <iframe style="width:0;height:0;border: 0;border: none;" name="dummyframe" id="dummyframe"></iframe>
                                <form role="form" enctype="multipart/form-data" target="dummyframe" id="formCarga">
                                    <div class="row">
                                        <div id="divErrorPaginaMod" class="col-md-12"></div>
                                        <div id="divExitoPaginaMod" class="col-md-12"></div>
                                    </div>

                                    <h3>Datos generales</h3>
                                    <hr class="red">
                                    <div class="row" id="divFileUpload">
                                        <center><label class="control-label">Firma:</label> </center>
                                        <center><div id="file-preview-zone">
                                            </div></center>
                                        <center><div id="imageBase">

                                            </div></center>
                                        <center><label class="control-label" id="inputDocName"> </label></center>
                                        <center><input type="file" name="file" accept=".jpg" id="cargaArchivo" class="subirimagen"> 
                                            <p>Extensiones permitidas: JPG, JPEG </p></center>
                                        <span id="errorFoto" class="help-block"></span>
                                    </div>
                                    <input id="idFoto" name="idFoto" type="hidden">
                                    <input id="idFirmante" name="idFirmante" type="hidden">
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-6" id="urFirmModalDiv">
                                                <input id="idURFirmModal" name="idURFirm" type="hidden">
                                                <label class="control-label" for="urFirmModal">Unidad Responsable*:</label>
                                                <select class="form-control"  id="urFirmModal" name="ur" onClick="asignaURMod()">
                                                    <!--option>SELECCIONA </option-->
                                                </select>                                                
                                                <span id="errorUrFirmModal" class="help-block"></span>
                                            </div> 
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-6" id="nombreAutorizaDivModal">
                                                <label class="control-label" for="nombreAutorizaModal">Nombre autoriza*:</label>
                                                <input class="form-control" id="nombreAutorizaModal" placeholder="Nombre autoriza" name="nombreAutoriza" 
                                                       type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="50"/>
                                                <span id="errorNombreAutorizaModal" class="help-block"></span>
                                            </div>
                                            <div class="col-md-6" id="puestoAutorizaDivModal">
                                                <label class="control-label" for="puestoAutorizaModal">Puesto autoriza*:</label>
                                                <input class="form-control" id="puestoAutorizaModal" placeholder="Puesto Autoriza" name="puestoAutoriza" 
                                                       type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="50"/>
                                                <span id="errorPuestoAutorizaModal" class="help-block"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <p>(*) Campos obligatorios </p>
                                    </div>
                                </form>  
                                <div class="row">
                                    <div class="form-group">
                                        <button class="btn btn-primary pull-right" type="button" onclick="insertaFirmantes()" id="btnGuardarFirm">Guardar</button>
                                        <button class="btn btn-default" type="button" data-dismiss="modal" onclick="cerrarModal()">Cerrar</button>

                                        <!--<button id="gafete" class="btn btn-primary pull-right credencial" type="submit">Imprimir etiqueta</button>-->
                                    </div>
                                </div>

                            </div><!-- /.modal-dialog -->
                        </div><!-- /.modal -->
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:particularTemplate>

<script type="text/javascript" src="http://b.scorecardresearch.com/c2/17183199/ct.js"></script>
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';</script>
<script src="<c:url value="/static/js/app/Usuarios/consultaFirmantes.js" />" rel="text/javascript"></script>		

