<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="breadcrumb" fragment="true"%>
<%@attribute name="styles" fragment="true"%>
<%@attribute name="scripts" fragment="true"%>
<%@attribute name="paginaTitulo" fragment="false"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js" lang="es">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>${paginaTitulo}</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width">
	<link rel="shortcut icon"
		href="https://framework-gb.cdn.gob.mx/favicon.ico">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/static/js/libs/bootstrap-table/bootstrap-table.min.css">
	<link rel="stylesheet" type="text/css"
		href="https://framework-gb.cdn.gob.mx/assets/styles/main.css">
	<jsp:invoke fragment="styles"></jsp:invoke>
</head>
<body>
    <main role="main">
        <div class="container top-buffer-submenu">
            <div class="row">
                <div class="col-sm-8">
                    <ol class="breadcrumb">
                        <li><a href="http://www.gob.mx"> <i class="icon icon-home"></i>
                        </a></li>
                        <li><a href="${pageContext.request.contextPath}/mvc/index">
                        SESI</a></li>
                    </ol>
                </div>
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
        <script type="text/javascript" src="<c:url value='/static/js/libs/jquery/jquery.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/static/js/util/util.js'/>"></script> 
        <script type="text/javascript">
            var baseURI = "${pageContext.request.contextPath}";
        </script> 
    </main>
</body>
</html>