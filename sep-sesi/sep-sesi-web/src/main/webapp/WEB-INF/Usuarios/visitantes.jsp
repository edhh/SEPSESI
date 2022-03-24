<%-- 
    Document   : visitantes
    Created on : 24/06/2020, 11:47:49 AM
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
<link rel="shortcut icon" href="https://framework-gb.cdn.gob.mx/favicon.ico">
<link rel="stylesheet" type="text/css" href="https://framework-gb.cdn.gob.mx/assets/styles/main.css">
<script type="text/javascript">


</script>

<t:particularTemplate>
    <jsp:attribute name="paginaTitulo">
        Registro visitante
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body>    



        <div class="container">
            <div class="row small-bottom-buffer">
                <div ><div class="col-md-12">
                        <h4>Registro visitantes</h4>
                        <hr class="red">
                    </div>
                </div>
            </div>
            <iframe style="width:0;height:0;border: 0;border: none;" name="dummyframe" id="dummyframe"></iframe>
            <form role="form" enctype="multipart/form-data" target="dummyframe" id="formCarga">
                <h3>Fotografía</h3>
                <hr class="red">
                <div class="row" id="divFileUpload">
                    <center><label class="control-label">Fotografía cargada: </label> </center>
                    <center><div id="file-preview-zone">
                        </div></center>
                    <center><div id="imageBase">
                            <img id="ItemPreview" src="">
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
                        <div class="col-md-6" id="curpDiv">
                            <label class="control-label" for="curp">CURP:</label>
                            <input class="form-control" id="curp" placeholder="CURP" name="curp" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="18"/>
                            <span id="errorCurp" class="help-block"></span>
                        </div>
                        <div class="col-md-6" id="nombreDiv">
                            <label class="control-label" for="nombre">Nombre*:</label>
                            <input class="form-control" id="nombre" placeholder="Nombre" name="nombre" path="nombre" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="32"/>
                            <span id="errorNombre" class="help-block"></span>
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
                        <div class="col-md-6" id="cuadranteDiv">
                            <label class="control-label" for="cuadrante">Sector/Área/Despacho*:</label>
                            <select class="form-control"  id="cuadrante" name="cuadrante" >
                                <option>SELECCIONA </option>
                            </select>
                            <span id="errorCuadrante" class="help-block"></span>
                        </div>
                        <div class="col-md-6" id="perviDiv">
                            <label class="control-label" for="personaV">Persona o Área que visita:</label>
                            <input class="form-control" id="personaV" name="personaV" placeholder="Persona que visita" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="150">
                            <span id="errorpersonaV" class="help-block"></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <p>(*) Campos obligatorios </p>
                </div>
                <div class="row">
                    <div class="form-group">
                        <center><button class="btn btn-primary pull-right" type="submit"  id="btnGuardar">Guardar</button></center>
                        <button class="btn btn-primary pull-right" onclick="consultaVisitante()" id="btnLimpiar">Regresar</button>
                        <!--<button id="gafete" class="btn btn-primary pull-right credencial" type="submit">Imprimir etiqueta</button>-->
                    </div>
                </div>

            </form> 


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
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
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
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

        </div>

    </jsp:body>
</t:particularTemplate>
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';
</script>
<script src="<c:url value="/static/js/app/Usuarios/visitantes.js" />" rel="text/javascript"></script>