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
<script type="text/javascript" src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>   -->

<script type="text/javascript">
</script>

<t:particularTemplate>    
    <jsp:attribute name="paginaTitulo">
        Registro de entrada/salida
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body>  
        <div class="container" id="divCodigoQR">
            
            <div class="row">
                <div class="col-md-12">
                    <h4>Entrada/Salida</h4>
                    <hr class="red">
                </div>                
            </div>
            
            <div class="form-group">
                <div class="row">
                    <div class="col-md-6" id="descInmuebleDiv">
                        <label class="control-label" for="descInmueble">Inmueble:</label>
                        <input class="form-control" id="descInmueble" placeholder="Inmueble" name="descInmueble" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" readonly/>
                        <span id="errorInmueble" class="help-block"></span>
                    </div>
                    <div class="col-md-6" id="accesoDiv">
                        <label class="control-label" for="acceso">Acceso:</label>
                        <input class="form-control" id="acceso" placeholder="Acceso" name="acceso" path="acceso" type="text" value="" onkeyup="this.value = this.value.toUpperCase()" maxlength="32" readonly/>
                        <span id="errorAcceso" class="help-block"></span>
                    </div>
                </div>
            </div>                 
            
            
            <div class="panel panel-default" >
                <div class="panel-heading">
                    <label>Registro con código QR</label>
                </div>                
                
                <div class="panel-collapse collapse in" id="collapseOne">
                    <div class="panel-body">
                        <div class="row" id="divImagen">            
                            <center>
                                <div id="file-preview-zone"></div>
                            </center>
                            <center>
                                <div id="imageBase"><img id="ItemPreview" src=""></div>
                            </center>
                            
                            <br />
                            <center>
                                <label class="control-label" id="nombrePersona"></label>                                
                            </center>               
                        </div>
                        <div id="registroCorrecto" class="alert alert-success alert-dismissible" style="opacity: 500; display: none;" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                El registro se realizó correctamente.
                        </div>
                        <div id="registroInactivo" class="alert alert-warning alert-dismissible" style="opacity: 500; display: none;" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                La persona no se encuentra activa. Pasar al módulo de registro de visitante.
                        </div>
                        <div id="noEncontrado" class="alert alert-danger alert-dismissible" style="opacity: 500; display: none;" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                La persona no se encuentra registrado. Pasar al módulo de registro de visitante.
                        </div>
                        <div id="sesionExpirada" class="alert alert-danger alert-dismissible" style="opacity: 500; display: none;" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                La sesión terminó, inicié sesión de nuevo.
                        </div>
                        <div class="row">
                            <center>
                                <div class="col-md-3"  />   
                                </div>
                                <div class="col-md-6" id="divLectorQR" >                            
                                    <input type="text" class="form-control" id="keyPersona" placeholder="Código QR" autofocus="autofocus" maxlength="300" />                                 
                                </div>
                            </center>
                        </div>
                        <br/>
                        <center>
                        <p><strong> Nota:</strong> Asegúrese de que el cursor este posicionado en el campo Código QR </p>
                        </center>
                    </div>
                </div>
            </div>          
            
            <div id="app">
<!--                <div class="sidebar">
                  <section class="cameras">
                    <h2>Cameras</h2>
                    <ul>
                      <li v-if="cameras.length === 0" class="empty">No cameras found</li>
                      <li v-for="camera in cameras">
                        <span v-if="camera.id == activeCameraId" :title="formatName(camera.name)" class="active">{{ formatName(camera.name) }}</span>
                        <span v-if="camera.id != activeCameraId" :title="formatName(camera.name)">
                          <a @click.stop="selectCamera(camera)">{{ formatName(camera.name) }}</a>
                        </span>
                      </li>
                    </ul>
                  </section>
                  <section class="scans">
                    <h2>Scans</h2>
                    
                    <ul v-if="scans.length === 0">
                      <li class="empty">No scans yet</li>
                    </ul>
                    <transition-group name="scans" tag="ul">
                      <li v-for="scan in scans" :key="scan.date" :title="scan.content">{{ scan.content }}</li>
                    </transition-group>
                  </section>
                </div> -->
               
<!--                <div class="preview-container">
                    <center>
                        <video id="preview"></video>    
                    </center>
                </div> -->
            </div>            
            
            <div>                
                <input type="hidden" id="idUsuario" value="" />
                <input type="hidden" id="idAcceso" value="" />
                <input type="hidden" id="idInmueble" value="" />
            </div> 
        </div>            
        
    </jsp:body>
</t:particularTemplate>   
             

<script type="text/javascript" src="http://b.scorecardresearch.com/c2/17183199/ct.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">var baseURI = '${pageContext.request.contextPath}';</script>
<script src="<c:url value="/static/js/app/controlAcceso/registroEntrada.js" />" rel="text/javascript"></script>
<script src="<c:url value="/static/js/app/controlAcceso/scanner.js" />" rel="text/javascript"></script>

