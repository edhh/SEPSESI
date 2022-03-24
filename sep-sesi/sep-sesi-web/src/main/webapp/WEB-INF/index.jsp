<%@page language="java" 
        contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:defaultTemplate>    
    <jsp:attribute name="paginaTitulo">
        <s:message code="bienvenida.pagina.titulo"></s:message>
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="col-md-8">
               <h3>Sistema para el registro de entrada y salida de personas a los inmuebles de la Secretaría de Educación Pública.</h3>
               <br>
               <br/>
           </div>
        </div>
    </jsp:body>       
</t:defaultTemplate>