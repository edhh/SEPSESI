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

<!--<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/webrtc-adapter/3.3.3/adapter.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.1.10/vue.min.js"></script>
<script type="text/javascript" src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>-->

<script type="text/javascript">
</script>

<t:particularTemplate>
    <jsp:attribute name="paginaTitulo">
        Registro de salida
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body>  
        <div class="container" id="divCodigoQR">
            <div class="container">

                <div class="row">
                    <div class="col-md-12">
                        <h4>Salida</h4>
                        <hr class="red">
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-md-6" id="descInmuebleDivSal">
                            <label class="control-label" for="descInmuebleSal">Inmueble:</label>
                            <input class="form-control" id="descInmuebleSal" placeholder="Inmueble" name="descInmuebleSal" 
                                   type="text" value="" onkeyup="this.value = this.value.toUpperCase()" readonly/>
                            <span id="errorInmuebleSal" class="help-block"></span>
                        </div>
                        <div class="col-md-6" id="accesoDiv">
                            <label class="control-label" for="accesoSal">Acceso:</label>
                            <input class="form-control" id="accesoSal" placeholder="Acceso" name="acceso" path="acceso" 
                                   type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="32" readonly/>
                            <span id="errorAccesoSal" class="help-block"></span>
                        </div>
                    </div>
                </div>   

                <div id="app">
    <!--                <center>
                        <div class="preview-container">
                          <video id="preview"></video>
                        </div>
                    </center>-->
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <label>Registro de salida con código QR</label>
                    </div>

                    <div class="panel-collapse collapse in" id="collapseOneSal">
                        <div class="panel-body">
                            <div class="row" id="divImagenSal">            
                                <center>
                                    <div id="file-preview-zone"></div>
                                </center>
                                <center>
                                    <div id="imageBaseSal"><img id="ItemPreviewSal" src=""></div>
                                </center>
                                <br />
                                <center><label class="control-label" id="nombrePersonaSal"> </label></center>               
                            </div>
                            <div id="registroCorrectoSal" class="alert alert-success alert-dismissible" style="opacity: 500; display: none;" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                    La salida se ha registrado exitosamente.
                            </div>

                            <div class="row">
                                <center>
                                    <div class="col-md-3"  />   
                                    </div>
                                    <div class="col-md-6" id="divLectorQR" >                            
                                        <input type="text" class="form-control" id="keyPersona" placeholder="Código QR" autofocus="autofocus" maxlength="34" />                                 
                                    </div>
                                </center>
                            </div>
                            <br/>
                            <center>
                            <p><strong> Nota:</strong> Asegúrese de que el cursor este posicionado en el campo Código QR </p>
                        </div>
                    </div>
                </div>        

                <div id="appSal"></div> 

                 <div>                
                    <input type="hidden" id="idUsuarioSal" value="" />
                    <input type="hidden" id="idAccesoSal" value="" />
                    <input type="hidden" id="idInmuebleSal" value="" />
                </div>
            </div>
        </div>
    </jsp:body>
</t:particularTemplate>

<script type="text/javascript" src="http://b.scorecardresearch.com/c2/17183199/ct.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';</script>
<script src="<c:url value="/static/js/app/controlAcceso/registroSalida.js" />" rel="text/javascript"></script>
<script src="<c:url value="/static/js/app/controlAcceso/scannerSalida.js" />" rel="text/javascript"></script>