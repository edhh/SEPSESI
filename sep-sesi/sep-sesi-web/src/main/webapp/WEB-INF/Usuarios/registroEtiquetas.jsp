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

    
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/webrtc-adapter/3.3.3/adapter.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.1.10/vue.min.js"></script>
    <script type="text/javascript" src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
    

<script type="text/javascript">
</script>

<t:particularTemplate>
    <jsp:attribute name="paginaTitulo">
        Generación de etiquetas
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body>  
        <div class="container">
            
            <div class="row">
                <div class="col-md-12">
                    <h4>Registro de etiquetas</h4>
                    <hr class="red">
                </div>
            </div>
            
            <div class="form-group">
                <div class="row">                     
                    <div class="col-md-2" id="impresionRadio">
                        <input type="radio" class="form-check-input" id="impresion" name="impresionRadios" value="1" checked>
                        <label class="control-label" for="impresion">Impresión</label>                    
                    </div>
                    <div class="col-md-2" id="reimpresionRadio">
                        <input type="radio" class="form-check-input" id="reimpresion" name="impresionRadios" value="2" >
                        <label class="control-label" for="reimpresion">Reimpresión</label>                    
                    </div>
                </div>
                <br/>
            </div>             
            
            <div class="form-group">
                <div class="row">
                    <div class="col-md-6" id="inmuebleDiv">
                        <label class="control-label" for="inmuebleID">Inmueble*:</label>
                        <select class="form-control"  id="inmuebleID" name="inmuebleID" onchange="obtenerUltimaEtiqueta(this.value)">
                        </select>
                        <span id="errorInmueble" class="help-block"></span>
                    </div>
                </div>
            </div> 
            <input type="hidden" id="numEtiquetaAux" value=""/>
            <input type="hidden" id="rolUsuario" value=""/>
            
            <div class="form-group" id="impresionDiv">
                <div class="row">                    
                    <div class="col-md-6" id="cantidadEtiquetasDiv">
                        <label class="control-label" for="cantidadEtiquetas">Cantidad de etiquetas*:</label>
                        <input type="text" name="cantidadEtiquetas" class="form-control soloNumeros" id="cantidadEtiquetas" placeholder="Cantidad de etiquetas" 
                               value="" maxlength="4"  >
                        <span id="errorCantidadEtiquetas" class="help-block"></span>
                    </div>  
                </div>
            </div>
            
            <div class="form-group" id="reimpresionDiv" style="display: none;">
                <div class="row">
                    <div class="col-md-6" id="etiquetaGeneradasDiv">
                        <label class="control-label" for="numEtiquetas">Etiquetas generadas:</label>
                        <input class="form-control soloNumeros" id="numEtiquetas" type="text" name="numEtiquetas" value="" disabled="disabled" >
                        <span id="errorNumEtiquetas" class="help-block"></span>
                    </div> 
                </div>
                <div class="row">                       
                    <div class="col-md-6" id="etiquetaInicialDiv">
                        <label class="control-label" for="etiquetaInicial">Etiqueta inicial*:</label>
                        <input type="text" name="etiquetaInicial" class="form-control soloNumeros" id="etiquetaInicial" 
                               placeholder="Etiqueta inicial"  value=""  maxlength="7">
                        <span id="errorEtiquetaInicial" class="help-block"></span>
                    </div>  
                    <div class="col-md-6" id="etiquetaFinalDiv">
                        <label class="control-label" for="etiquetaFinal">Etiqueta final*:</label>
                        <input type="text" name="etiquetaFinal" class="form-control soloNumeros" id="etiquetaFinal" 
                               placeholder="Etiqueta final"  value="" maxlength="7" >
                        <span id="errorEtiquetaFinal" class="help-block"></span>
                    </div>
                </div>
            </div> 
            
            <div class="form-group">
                <div class="row text-right">  
                    <button id="btnLimpiar" class="btn btn-primary" type="submit" onclick="limpiar()" style="margin-left: 30px;">Limpiar</button>
                    <button id="btnImprimir" class="btn btn-primary" type="submit" style="margin-left: 30px;">Imprimir etiquetas</button>
                </div>
            </div>
            <br />
            <div id="resultadoOperacion" class="alert-dismissible" style="opacity: 500; display: none;" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                <label id="txtResultado"></label>
            </div>
        </div>
    </jsp:body>
</t:particularTemplate>   
             

<script type="text/javascript" src="http://b.scorecardresearch.com/c2/17183199/ct.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';</script>
<script src="<c:url value="/static/js/app/Usuarios/registroEtiquetas.js" />" rel="text/javascript"></script>
