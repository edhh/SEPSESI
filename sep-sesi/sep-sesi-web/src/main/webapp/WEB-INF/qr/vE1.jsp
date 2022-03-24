<%-- 
    Document   : vE1
    Created on : 2/03/2022, 05:38:54 PM
    Author     : HeribertoGonzálezPér
--%>

<%@page language="java" 
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page import="mx.sep.seguridad.util.SeguridadUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!--<script src="/libs/jquery.min.js"></script>
<script src="/libs/jquery.plugin.js"></script>-->

<script type="text/javascript">
</script>

<t:validacionQREquipos>
    <jsp:attribute name="paginaTitulo">
        Datos del empleado / Prestador de servicios
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body>     
        <div class="container">
            <br>
            <div class="row">
                <div class="col-md-12">
                    <h4>Equipo de cómputo asignado</h4>
                    <hr class="red">
                </div>
            </div>
            <div class="table-responsive col-md-12">
                <table id="resultadosResumenTable"></table>
            </div>
            <input id="idEquipo" name="idEquipo" type="hidden">
            <input id="bandera" name="bandera" type="hidden">
        </div>
        <div class ="container">
            <!--<div class="row">
            <div class="col-md-12" id="divLectorQR" >
                <label class="control-label" for="claveID">Clave*:</label>
                <input type="text" class="form-control" id="keyPersona" placeholder="Código QR" autofocus="autofocus" maxlength="300" />                                 
            </div>
            </div>-->
             <br>
            <div class="row">
                <div class="col-md-4" id="usuarioQr" >
                <label class="control-label" for="usuarioID">Usuario*:</label>
                <input type="text" class="form-control" id="usuarioID" placeholder="Usuario" maxlength="300" onchange="verificarDatos()"/>
                <span id="errorUsuario" class="help-block"></span>
                </div>
                <div class="col-md-4" id="passwordID" >
                <label class="control-label" for="contrasegnaUsuar">Contrase&ntilde;a*:</label>
                                            <input class="form-control sinEspacios" id="contrasegnaUsuar" placeholder="Contrase&ntilde;a" name="contrasegna" 
                                                   type="password" value="" maxlength="16" onchange="verificarDatos()">
                    <span id="errorPassword" class="help-block"></span>                        
                </div>
                <div class="col-md-4" id="operacionDiv">
                <label class="control-label" for="operacionID">Operación*:</label>
                <select class="form-control"  id="operacionID" name="operacionID">
                    <option>SELECCIONA </option>
                    <option value="1">ENTRADA </option>
                    <option value="0">SALIDA </option>
                </select>
                <span id="errorOperacion" class="help-block"></span>
            </div>
            </div>
            <!--<div class="row">
            <div class="col-md-6" id="inmuebleDiv">
                <label class="control-label" for="inmuebleID">Inmueble*:</label>
                <select class="form-control"  id="inmuebleID" name="inmuebleID">
                    <option>SELECCIONA </option>
                </select>
                <span id="errorInmueble" class="help-block"></span>
            </div>
            <div class="col-md-6" id="operacionDiv">
                <label class="control-label" for="operacionID">Operación*:</label>
                <select class="form-control"  id="operacionID" name="operacionID">
                    <option>SELECCIONA </option>
                    <option value="1">ENTRADA </option>
                    <option value="0">SALIDA </option>
                </select>
                <span id="errorOperacion" class="help-block"></span>
            </div>
            </div>-->
            
            <br>
        </div>
        <div class="container" id="datosPersona">
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
            <!--                <center>
                                <button id="nuevoEmpleado" class="btn btn-primary">
                                    <span class="glyphicon glyphicon-plus"></span>
                                    Nuevo empleado
                                </button>
                            </center><br><br><br>-->
        </div> 
        <br>
        <div class="container">
            <div class="form-group">
                                        <button class="btn btn-primary pull-right" type="submit" id="btnGuardar" onclick="registrarEntradaEquipos()">Registrar</button>
                                        
                                    </div>
        </div>
        
        <div id="registroCorrecto" class="alert alert-success alert-dismissible" style="opacity: 500; display: none;" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                El registro se realizó correctamente.
                        </div>
        
    </jsp:body>
</t:validacionQREquipos>   

        
<script type="text/javascript" src="https://b.scorecardresearch.com/c2/17183199/ct.js"></script>
<!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>-->
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';</script>
<script src="<c:url value="/static/js/app/validacionCredencial/vE1.js" />" rel="text/javascript"></script>	
<script src="<c:url value="/static/js/libs/jquery/jquery.table2excel.js" />" rel="text/javascript"></script>
<script src="<c:url value="/static/js/libs/jquery/xls.core.min.js" />" rel="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.4.0/bootstrap-table.min.js"></script>
<script type="text/javascript" src="<c:url value='/static/js/libs/jquery/jquery-cookie-min.js'/>"></script> 

        <script>

            jQuery(document).ready(function () {
                /*jQuery('#recordarme').click(function () {
                    crearCookieRecordame();
                });*/

                verificarCookieRecordarmeVE();

                jQuery("#btnGuardar").click(function () {
                    crearCookieRecordameVE();
                    //jQuery("#btnSubmit").click();
                });

                /*jQuery('#j_username').keypress(function (e) {
                    var key = e.which;
                    if (key == 13) {
                        jQuery("#btnEnviar").click();
                        return false;
                    }
                });

                jQuery('#j_password').keypress(function (e) {
                    var key = e.which;
                    if (key == 13) {
                        jQuery("#btnEnviar").click();
                        return false;
                    }
                });*/
            });

            function verificarCookieRecordarmeVE() {
                //var recordarme = getCookie('recordarme');
                //if (recordarme == 'true')
                //{
                    var usuario = getCookie('usuario-ve');
                    var password = getCookie('password-ve');

                    jQuery('#usuarioID').val(usuario);
                    jQuery('#contrasegnaUsuar').val(password);
                    //jQuery('#recordarme').attr("checked", "checked");

                /*} else
                {

                }*/
            }

            function crearCookieRecordameVE() {
                
                    var rfc = jQuery('#usuarioID').val();
                    var password = jQuery('#contrasegnaUsuar').val();
                    var diasExpiracion = 14;

                    setCookieVE('usuario-ve', rfc, diasExpiracion);
                    setCookieVE('password-ve', password, diasExpiracion);
                    setCookieVE('recordarmeVE', true, diasExpiracion);
                
            }

            function setCookieVE(cname, cvalue, exdays) {
                var d = new Date();
                d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
                var expires = "expires=" + d.toUTCString();
                document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
            }

            function getCookie(cname) {
                var name = cname + "=";
                var decodedCookie = decodeURIComponent(document.cookie);
                var ca = decodedCookie.split(';');
                for (var i = 0; i < ca.length; i++) {
                    var c = ca[i];
                    while (c.charAt(0) == ' ') {
                        c = c.substring(1);
                    }
                    if (c.indexOf(name) == 0) {
                        return c.substring(name.length, c.length);
                    }
                }
                return "";

            }


        </script>