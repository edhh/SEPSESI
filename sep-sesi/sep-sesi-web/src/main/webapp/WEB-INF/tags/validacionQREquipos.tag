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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/static/js/libs/bootstrap-table/bootstrap-table.min.css">-->
        <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/colors.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/js/libs/bootstrap/bootstrap-table.min.css">-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/actaintegracion.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/libs/bootstrap/bootstrap-table.min.js"></script>
        <c:url value="/logout" var="logoutUrl" />        
        <jsp:invoke fragment="styles"></jsp:invoke>
        </head>
        <body>

        <main role="main"> <t:menuInterno/>
        <div class="container top-buffer">
            <!--<div class="row">
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
            </div>-->
            
        </div>
        <div class="modal fade" id="loader2">
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
        
        <!--<script src="https://framework-gb.cdn.gob.mx/gobmx.js"></script>       -->
        <script src="<c:url value='/static/js/libs/jquery/jquery-ui.min.js' />"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
       <!-- <script src="https://framework-gb.cdn.gob.mx/assets/scripts/jquery-ui-datepicker.js"></script>-->
        <script type="text/javascript" src="<c:url value='/static/js/libs/jquery/jquery.js'/>"></script>       
        <script	type="text/javascript" src="<c:url value='/static/js/libs/bootstrap/js/tooltipBootstrap.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/static/js/util/util.js'/>"></script>         
        

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