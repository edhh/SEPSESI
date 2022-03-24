<%-- 
    Document   : cambioContrasena
    Created on : 24/09/2020, 05:27:11 PM
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

<t:particularTemplate>
    <jsp:attribute name="paginaTitulo">
        Cambiar contrase&ntilde;a
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body>   
        <div class="container">

            <div class="row">
                <div class="col-md-12">
                    <h4>Cambiar contrase&ntilde;a</h4>
                    <hr class="red">
                </div>
            </div>

            <div class="row">
                <div id="divErrorPagina" class="col-md-12"></div>
                <div id="divExitoPagina" class="col-md-12"></div>
            </div>

            <div class="row">

                <div class="form-group">
                    <div class="col-md-4" id="nombreUsDiv">
                        <label class="control-label" for="nombreUsConfig">Nombre de Usuario:*</label>
                        <input class="form-control" id="nombreUsConfig" placeholder="Nombre de Usuario" type="text" value="" readonly>
                        <span id="errorNombreUsConfig" class="help-block"></span>
                    </div>
                </div>
            </div>


            <div class="form-group">
                <div class="row">
                    <div class="col-md-4" id="newPasswordDiv">
                        <label class="control-label" for="newPass">Nueva Contrase&ntilde;a:*</label>
                        <input class="form-control sinEspaciosPass" id="newPass" placeholder="Nueva Contrase&ntilde;a" type="password" maxlength="18">
                        <span id="errorNewPass" class="help-block"></span>
                    </div>
                </div>
            </div>    


            <div class="form-group"> 
                <div class="row">
                    <div class="col-md-4" id="confPassDiv">
                        <label class="control-label" for="confPass">Confirme Contrase&ntilde;a:*</label>
                        <input class="form-control" id="confPass" placeholder="Confirme Contrase&ntilde;a" type="password" maxlength="18">
                        <span id="errorConfPass" class="help-block"></span>
                    </div>
                </div>
            </div>

            <div class="row">
                <button class="btn btn-primary pull-right" type="button" onclick="cambioContrasena()" id="btnGuardarPass">Guardar</button>
            </div>

            <div class="row">
                <p>(*) Campos obligatorios </p>
            </div>
            <table class="pageTable">
                <tr class="contenidos">
                    <td colspan="5">&nbsp;</td>
                </tr>
                <tr class="contenidos">
                    <td colspan="4" class=tituloFondoGris>Elementos a considerar para su nueva contrase&ntilde;a</td>
                </tr>
                <tr class="contenidos">
                    <td class="contenidos" colspan="4">1.- La contrase&ntilde;a debe tener 6 caracteres como m&iacute;nimo y 18 como m&aacute;ximo.</td>
                </tr>
                <tr class="contenidos">
                    <td class="contenidos" colspan="4">2.- La contrase&ntilde;a distingue letras may&uacute;sculas y  min&uacute;sculas.</td>
                </tr>
                <tr class="contenidos">
                    <td class="contenidos" colspan="4">3.- Se permiten caracteres alfanum&eacute;ricos y caracteres especiales (ej. % $ #).</td>
                </tr>

            </table>


        </div>

    </jsp:body>
</t:particularTemplate>

<script type="text/javascript" src="http://b.scorecardresearch.com/c2/17183199/ct.js"></script>
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';</script>
<script src="<c:url value="/static/js/app/configuracion/cambioContrasena.js" />" rel="text/javascript"></script>	