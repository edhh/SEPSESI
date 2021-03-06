<%-- 
    Document   : consultaVisitantes
    Created on : 25/06/2020, 12:04:31 PM
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

<style>
    #myModal1{
        width: 95% !important;
    }
</style>

<t:particularTemplate>
    <jsp:attribute name="paginaTitulo">
        Registro de visitantes
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
                    <h4>Consulta de Visitantes</h4>
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
                    <div class="col-md-6" id="curpDiv">
                        <label class="control-label" for="curp">CURP:</label>
                        <input class="form-control" id="curp" placeholder="CURP" name="curp" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="18"/>
                        <span id="errorCurp" class="help-block"></span>
                    </div>
                    <div class="col-md-6" id="nombreDiv">
                        <label class="control-label" for="nombre">Nombre:</label>
                        <input class="form-control" id="nombre" placeholder="Nombre" name="nombre" path="nombre" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="32"/>
                        <span id="errorNombre" class="help-block"></span>
                    </div>
                    <input id="idUrB" name="idUrB" type="hidden">
                </div>
            </div>
            <br/>   
            <div class="row">
                <center>
                    <button id="buscar" class="btn btn-primary" type="submit" style="margin-left: 30px;">Buscar</button>
                    <!--                        <button class="btn btn-primary" type="submit" style="margin-left: 30px;">Exportar datos a excel</button>-->
                    <button id="limpiar" class="btn btn-primary" type="submit" style="margin-left: 30px;">Limpiar</button>
                    <button id="nuevoVisitante" class="btn btn-primary" style="margin-left: 30px;">
                        <span class="glyphicon glyphicon-plus"></span>
                        Nuevo visitante</button>		
                </center>
            </div><br><br><br>
            <div class="table-responsive">
                <table id="resultadosResumenTable"></table>
            </div>

            <div class="modal fade" id="ModalVisitantes" data-backdrop="static" data-keyboard="false" style="overflow-y: scroll;">
                <div class="modal-dialog" id="myModal1">
                    <div class="modal-content" id="myModal2">
                        <div class="modal-header" id="myModal3">
                            <h4 class="modal-title">SESI</h4>
                        </div>
                        <div class="modal-body">
                            <div class="container">

                                <iframe style="width:0;height:0;border: 0;border: none;" name="dummyframe" id="dummyframe"></iframe>
                                <form role="form" method="POST" action="../persona/insertaVisitante" enctype="multipart/form-data" target="dummyframe" id="formCarga">
                                    <h3>Fotografía</h3>
                                    <hr class="red">
                                    <div class="row" id="divFileUpload">
                                        <center><label class="control-label">Fotografía cargada: </label> </center>
                                        <center><div id="file-preview-zone">
                                            </div></center>
                                        <center><div id="imageBase">
                                            </div></center>
                                        <center><label class="control-label" id="inputDocName"> </label></center>
                                        <center><input type="file" name="file" accept=".jpg" id="cargaArchivo" class="subirimagen"> 
                                            <p>Extensiones permitidas: JPG, JPEG </p></center>
                                    </div>

                                    <input id="idVisitante" name="idVisitante" type="hidden">
                                    <input id="idFoto" name="idFoto" type="hidden">
                                    <h3>Datos generales</h3>
                                    <hr class="red">
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-6" id="curpDivModal">
                                                <label class="control-label" for="curpModal">CURP:</label>
                                                <input class="form-control" id="curpModal" placeholder="CURP" name="curp" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="18" onchange="verificarCurp()"/>
                                                <span id="errorCurpModal" class="help-block"></span>
                                            </div>
                                            <div class="col-md-6" id="nombreDivModal">
                                                <label class="control-label" for="nombreModal">Nombre*:</label>
                                                <input class="form-control" id="nombreModal" placeholder="Nombre" name="nombre" path="nombre" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="32"/>
                                                <span id="errorNombreModal" class="help-block"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-6" id="paternoDiv">
                                                <label class="control-label" for="primerApellido">Primer apellido*:</label>
                                                <input class="form-control" id="primerApellido" placeholder="Primer apellido" type="text" name="primerApellido" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="32">
                                                <span id="errorPaterno" class="help-block"></span>
                                            </div>
                                            <div class="col-md-6" id="maternoDiv">
                                                <label class="control-label" for="segundoApellido">Segundo apellido:</label>
                                                <input class="form-control" id="segundoApellido" placeholder="Segundo apellido" name="segundoApellido" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="32">
                                                <span id="errorMaterno" class="help-block" ></span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">

                                            <div class="col-md-6" id="inmuebleDiv">
                                                <label class="control-label" for="inmuebleID">Inmueble*:</label>
                                                <select class="form-control"  id="inmuebleID" name="inmuebleID" onChange="obtenerCuadrante()">
                                                    <option>SELECCIONA </option>
                                                </select>
                                                <span id="errorInmueble" class="help-block"></span>
                                            </div>
                                            <div class="col-md-6" id="urDiv">
                                                <label class="control-label" for="ur">Unidad Responsable a visitar*:</label>
                                                <select class="form-control"  id="ur" name="ur" onClick="asignaUR()">
                                                    <option>SELECCIONA </option>
                                                </select>
                                                <span id="errorUr" class="help-block"></span>
                                            </div>
                                            <input id="idUR" name="idUR" type="hidden">

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-4" id="cuadranteDiv">
                                                <label class="control-label" for="cuadrante">Sector/Área/Despacho*:</label>
                                                <select class="form-control"  id="cuadrante" name="cuadrante" >
                                                    <option>SELECCIONA </option>
                                                </select>
                                                <span id="errorCuadrante" class="help-block"></span>
                                            </div>
                                            <div class="col-md-4" id="perviDiv">
                                                <label class="control-label" for="personaV">Persona o Área que visita:</label>
                                                <input class="form-control" id="personaV" name="personaV" placeholder="Persona que visita" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="150">
                                                <span id="errorpersonaV" class="help-block"></span>
                                            </div>
                                            <div class="col-md-4" id="etiquetaDiv">
                                                <label class="control-label" for="numEtiqueta">Número de etiqueta*:</label>
                                                <input class="form-control" id="numEtiqueta" name="numEtiqueta" placeholder="Número de etiqueta" type="text" value="" onkeyup="this.value = this.value.toUpperCase()">
                                                <span id="errornumEtiqueta" class="help-block"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <p>(*) Campos obligatorios </p>
                                    </div>
                                    <!--<div class="row">
                                        <div class="col-md-12">
                                            <h4>Equipo de cómputo</h4>
                                            <hr class="red">
                                        </div>
                                        <div class="card-body">
                                            <div id="table" class="table-editable">-->
                                                <!--<span class="glyphicon glyphicon-search" aria-hidden="true"></span>-->
                                                <!--<span class="table-add float-right"
                                                      ><a href="#!" class="text-success"
                                                    ><i class="glyphicon glyphicon-plus" aria-hidden="true"></i></a
                                                    </span>-->
                                                             <!--<span class="table-add"
                                                                      ><button type="button" class="btn btn-danger pull-right" onclick="agregar()">
                                                                        Agregar
                                                                    </button></span>

                                                <br>
                                                <table class="table table-bordered table-responsive-md table-striped text-center" id="fragmenterTable">
                                                    <thead>
                                                        <tr>
                                                            <th class="text-center">Estatus</th>
                                                            <th class="text-center">Marca</th>
                                                            <th class="text-center">Número de serie</th>
                                                            <th class="text-center">Descripción</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="tbody">
                                                        
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>-->
                                    <div class="row">
                                        <div class="form-group">
                                            <button class="btn btn-primary pull-right" type="button" onclick="insertaVisitantes()" id="btnGuardar">Guardar</button>
                                            <button class="btn btn-default" type="button" data-dismiss="modal">Cerrar</button>

                                            <!--<button id="gafete" class="btn btn-primary pull-right credencial" type="submit">Imprimir etiqueta</button>-->
                                        </div>
                                    </div>


                                </form>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            </div>



            <div class="modal fade" id="myModal1">
                <div class="modal-dialog" id="myModal12">
                    <div class="modal-content" id="myModal2">
                        <div class="modal-header" id="myModal3">
                            <h4 class="modal-title">SESI</h4>
                        </div>
                        <div class="modal-body">

                        </div>
                        <div class="modal-footer">
                            <!--<button id="gafete" type="button" class="btn btn-primary credencial" data-dismiss="modal">Imprimir etiqueta</button>-->
                            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="consultaVisitante()">Cerrar</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            <div class="modal fade" id="myModal">
                <div class="modal-dialog" id="myModal1" data-backdrop="static" data-keyboard="false">
                    <div class="modal-content" id="myModal2">
                        <div class="modal-header" id="myModal3">
                            <h4 class="modal-title">SESI</h4>
                        </div>
                        <div class="modal-body">

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="consultaVisitante()">Cerrar</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            <div class="modal fade" id="myModalll">
                <div class="modal-dialog" id="myModal1">
                    <div class="modal-content" id="myModal2">
                        <div class="modal-header" id="myModal3">
                            <h4 class="modal-title">SESI</h4>
                        </div>
                        <div class="modal-body">
                            <p>Se han registrado los datos correctamente</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
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
    <script src="<c:url value="/static/js/app/Usuarios/consultaVisitantes.js" />" rel="text/javascript"></script>		
