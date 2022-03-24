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
        Catálogo de usuarios       
    </jsp:attribute>

    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body> 

        <div class="container">

            <div ><div class="row">
                    <h4>Catálogo de usuarios</h4>
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
                    <div class="col-md-10" id="urFirmDiv">
                        <input id="idURCatUsu" name="idURCatUsu" type="hidden">
                        <label class="control-label" for="urCatUsu">Unidad Responsable:</label>
                        <select class="form-control"  id="urCatUsu" name="ur" onClick="asignaUR()">
                            <option>SELECCIONA </option>
                        </select>
                        <span id="errorUrCatUsu" class="help-block"></span>
                    </div>                   
                </div>
            </div>

            <div class="form-group">
                <div class="row">

                    <div class="col-md-6" id="rolCatUsuDiv">
                        <input id="idRolCatUsuar" name="idRolUsuar" type="hidden">
                        <label class="control-label" for="rolCatUsuar">Rol:</label>
                        <select class="form-control"  id="rolCatUsuar" name="rolUsuar" onChange="asignarRol()">
                            <option>SELECCIONA </option>
                        </select>
                        <span id="errorRolCatUsuar" class="help-block" ></span>
                    </div>   

                    <div class="col-md-6" id="inmuebleCatUsuarDiv">
                        <input id="idInmuebleCatUsuar" name="idInmuebleCatUsuar" type="hidden">
                        <label class="control-label" for="inmuebleCatUsuar">Inmueble:</label>
                        <select class="form-control"  id="inmuebleCatUsuar" name="inmuebleCatUsuar" onChange="asignarInmueble()">
                            <option>SELECCIONA </option>
                        </select>
                        <span id="errorInmuebleCatUsuar" class="help-block"></span>
                    </div>
                </div>
            </div>

            <div class="row">
                <center>
                    <button id="buscarCatUsuario" class="btn btn-primary" type="submit" style="margin-left: 30px;">Buscar</button>
                    <button id="limpiarCatUsuario" class="btn btn-primary" type="submit" style="margin-left: 30px;">Limpiar</button>
                    <button id="nuevoUsuario" class="btn btn-primary" style="margin-left: 30px;">
                        <span class="glyphicon glyphicon-plus"></span>
                        Nuevo usuario</button>		
                </center>
            </div><br><br><br>
            <div class="table-responsive">
                <table id="resultadosUsuarioTable"></table>
            </div>

            <div id="divMensaje" 
                 style="display: none">
            </div>
            <div class="modal fade" id="ModalUsuarios" data-backdrop="static" data-keyboard="false" style="overflow-y: scroll;">
                <div class="modal-dialog" id="myModal1">
                    <div class="modal-content" id="myModal2">
                        <div class="modal-header" id="myModal3">
                            <h4 class="modal-title">SESI</h4>

                        </div>
                        <div class="modal-body">
                            <div id="registroUsuarCorrecto" class="alert alert-success alert-dismissible" style="opacity: 500; display: none;" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                Se agregó el registro exitosamente.
                            </div>

                            <div class="container">
                                <div class="row">
                                    <div id="divErrorPagina" class="col-md-12"></div>
                                    <div id="divExitoPagina" class="col-md-12"></div>
                                </div>
                                <h3>Datos generales</h3>
                                <hr class="red">
                                <input id="idUsuarioCat" name="idUsuarioCat" type="hidden">
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-6" id="curpDivModal">
                                                <label class="control-label" for="curpModal">CURP:</label>
                                                <input class="form-control" id="curpModal" placeholder="CURP" name="curp" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="18" onchange="verificarCurp()"/>
                                                <span id="errorCurpModal" class="help-block"></span>
                                        </div>
                                        <div class="col-md-6" id="nombreUsuarDiv">
                                            <label class="control-label" for="nombreUsuar">Nombre*:</label>
                                            <input class="form-control" id="nombreUsuar" placeholder="Nombre" name="nombre" path="nombre" 
                                                   type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="32"/>
                                            <span id="errorNombreUsuar" class="help-block"></span>
                                        </div>                                                      
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-6" id="paternoUsuarDiv">
                                            <label class="control-label" for="primerApellidoUsuar">Primer apellido*:</label>
                                            <input class="form-control" id="primerApellidoUsuar" placeholder="Primer apellido" 
                                                   type="text" name="primerApellido" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="32">
                                            <span id="errorPaternoUsuar" class="help-block"></span>
                                        </div> 
                                        <div class="col-md-6" id="maternoUsuarDiv">
                                            <label class="control-label" for="segundoApellidoUsuar">Segundo apellido:</label>
                                            <input class="form-control" id="segundoApellidoUsuar" placeholder="Segundo apellido" name="segundoApellido" 
                                                   type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="32">
                                            <span id="errorMaternoUsuar" class="help-block" ></span>
                                        </div>

                                       
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-4" id="nombreUsuUsuarDiv">
                                            <label class="control-label" for="nombreUsuUsuar">Nombre de usuario*:</label>
                                            <input class="form-control" id="nombreUsuUsuar" placeholder="Nombre de usuario" name="nombreUsuarios" 
                                                   type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="32">
                                            <span id="errorNombreUsuUsuar" class="help-block" ></span>
                                        </div>
                                        <div class="col-md-4" id="contrasegnaUsuarDiv">
                                            <label class="control-label" for="contrasegnaUsuar">Contrase&ntilde;a*:</label>
                                            <input class="form-control sinEspacios" id="contrasegnaUsuar" placeholder="Contrase&ntilde;a" name="contrasegna" 
                                                   type="password" value="" maxlength="16"  disabled="disabled">
                                            <label id="labPass" for="passCheckbox">Actualizar contrase&ntilde;a:</label>
                                            <input type="checkbox" id="passCheckbox" value="1" onclick="showModal()"/>
                                            <span id="errorContrasegnalUsuar" class="help-block" ></span>
                                        </div>
                                        <div class="col-md-4" id="contrasegnaVerifDiv">
                                            <label class="control-label" for="contrasegnaVerif">Verifique contrase&ntilde;a:</label>
                                            <input class="form-control" id="contrasegnaVerif" placeholder="Verifique contrase&ntilde;a" name="contrasegna" 
                                                   type="password" value="" maxlength="16" disabled="disabled">
                                            <span id="errorContrasegnaVerif" class="help-block" ></span>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="row">
                                        <div class="col-md-4" id="rolUsuarModDiv">
                                            <input id="idRolUsuarMod" name="idRolUsuarMod" type="hidden">
                                            <label class="control-label" for="rolUsuarMod">Rol*:</label>
                                            <select class="form-control"  id="rolUsuarMod" name="rolUsuarMod" onChange="asignarRolMod()">
                                                <option>SELECCIONA </option>
                                            </select>
                                            <span id="errorRolUsuar" class="help-block" ></span>
                                        </div>

                                        <div class="col-md-4" id="inmuebleUsuarModDiv">
                                            <label class="control-label" for="inmuebleIDUsuarMod">Inmueble*:</label>
                                            <select class="form-control"  id="inmuebleIDUsuarMod" name="inmuebleIDUsuarMod" onChange="obtenerAcceso()">
                                                <option>SELECCIONA </option>
                                            </select>
                                            <span id="errorInmuebleUsuar" class="help-block"></span>
                                        </div>

                                        <div class="col-md-4" id="accesoUsuarDiv">
                                            <input id="idAccesoUsuar" name="idAccesoUsuar" type="hidden">
                                            <label class="control-label" for="accesoUsuar">Acceso*:</label>
                                            <select class="form-control"  id="accesoUsuar" name="accesoUsuar" onClick="asignaAccesoUsuar()">
                                                <option value="">SELECCIONA </option>
                                            </select>
                                            <span id="errorAccesoUsuar" class="help-block"></span>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-8" id="urUsuarDiv">
                                            <input id="idURUsuar" name="idUR" type="hidden">
                                            <label class="control-label" for="urUsuar">Unidad Responsable*:</label>
                                            <select class="form-control"  id="urUsuar" name="urUsuar" onClick="asignaURMod()">
                                                <option>SELECCIONA </option>
                                            </select>
                                            <span id="errorUrUsuar" class="help-block"></span>
                                        </div>  
                                        <div class="col-md-4" id="activoDiv">
                                            <label class="control-label" for="activoUsu">Estatus*:</label>
                                            <select class="form-control" id="activoUsu"  name="estatus">
                                                <option value="">SELECCIONA</option>
                                                <option value="1">ACTIVO</option>
                                                <option value="0">INACTIVO</option>
                                            </select>
                                            <span id="errorActivo" class="help-block"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <p>(*) Campos obligatorios </p>
                                </div>
                                <div class="row">
                                    <div class="form-group">
                                        <button class="btn btn-primary pull-right" type="button" onclick="insertaUsuarioCat()" id="btnGuardarUsuar">Guardar</button>
                                        <button class="btn btn-default" type="button" data-dismiss="modal" onclick="cerrarModalCat()">Cerrar</button>                             
                                    </div>
                                </div>

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
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';</script>
<script src="<c:url value="/static/js/app/admin/catUsuarios.js" />" rel="text/javascript"></script>		