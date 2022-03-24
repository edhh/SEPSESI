<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="breadcrumb" fragment="true"%>
<%@attribute name="styles" fragment="true"%>
<%@attribute name="scripts" fragment="true"%>
<%@attribute name="paginaTitulo" fragment="false"%>
<%@attribute name="tituloSistema" fragment="false"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html class="no-js" lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>${paginaTitulo}</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <link rel="shortcut icon" href="https://framework-gb.cdn.gob.mx/favicon.ico">
        <link rel="stylesheet" type="text/css" href="https://framework-gb.cdn.gob.mx/assets/styles/main.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/js/libs/bootstrap-table/bootstrap-table.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/colors.min.css">
        
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/actaintegracion.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.js"></script>
        <c:url value="/logout" var="logoutUrl" />        
        <jsp:invoke fragment="styles"></jsp:invoke>
        </head>
        <body>

        <main role="main"> <t:menuInterno/>
        <div class="container top-buffer">
            <div class="row">
                <div class="col-sm-8">
                    <ol class="breadcrumb">
                        <li><a href="http://www.gob.mx"> <i class="icon icon-home"></i>
                            </a></li>
                        <li><a
                                href="${pageContext.request.contextPath}/mvc/index">
                                Inicio </a></li>
                                <jsp:invoke fragment="breadcrumb"></jsp:invoke>
                        <li class="active" id="titPagina">${paginaTitulo}</li>
                    </ol>
                </div>
                <form id="logout" action="${logoutUrl}" method="post" >
                        <div class="col-sm-4">
                            <div class="user-credencials">
                                <ul class="list-unstyled">
                                    <li>
                                        <b>Usuario:</b>                                        
                                        <span class="user-credencials__name" id="usuario"></span> 
                                        <a class="pull-right"
                                           href="javascript:document.getElementById('logout').submit()"> Salir
                                        </a>
                                    </li>
                                    <li>
                                        <b>Nombre:</b>
                                        <span class="user-credencials__name" id="nombreUsu"></span>                                                                                        
                                    </li>
                                    <li>
                                        <b>Inmueble:</b>
                                        <span class="user-credencials__name" id="inmueble"></span>
                                    </li> 

                                </ul>
                            </div>
                        </div>
                    </form>
            </div>
            <div class="row">
                <div class="col-md-8">
                    <h2>Sistema de Entrada y Salida de Inmuebles</h2>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
        <div class="modal fade" id="loader">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Procesando solicitud.</h4>
                    </div>
                    <div class="modal-body">
                        <p>Estamos procesando su solicitud ...</p>
                    </div>
                    <div class="modal-footer"></div>
                </div>
            </div>
        </div>
        <jsp:doBody />             
        
        <script src="https://framework-gb.cdn.gob.mx/gobmx.js"></script>       
        <script src="<c:url value='/static/js/libs/jquery/jquery-ui.min.js' />"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://framework-gb.cdn.gob.mx/assets/scripts/jquery-ui-datepicker.js"></script>
        <script type="text/javascript" src="<c:url value='/static/js/libs/jquery/jquery.js'/>"></script>       
        <script	type="text/javascript" src="<c:url value='/static/js/libs/bootstrap/js/tooltipBootstrap.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/static/js/util/util.js'/>"></script>         
        <script type="text/javascript" src="<c:url value='/static/js/template/default_template.js'/>"></script>

        <script type="text/javascript">
            var baseURI = "${pageContext.request.contextPath}";
            $gmx(document)
                    .ready(
                            function() {
                                Modernizr
                                        .load([{
                                                load: [
                                                    baseURI
                                                                + '/static/js/libs/jquery/jquery.form-validator.js',
                                                        baseURI
                                                                + '/static/js/libs/bootstrap/bootstrap-table.min.js',
                                                        baseURI
                                                                + '/static/js/util/jquery.cookie-1.4.1.min.js',
                                                        baseURI
                                                                + '/static/js/util/template.js',                                                   
                                                    
            <jsp:invoke fragment="scripts"></jsp:invoke>]
                                            }]);

                            });
        </script> </main>
</body>
</html>