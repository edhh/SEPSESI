<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.jar.Attributes"%>
<%@page import="java.util.jar.Manifest"%>
<%@page import="java.io.InputStream"%>

<!-- v 2.0.21-->
<%! String impVersion = "";%>  
<%
    try {
        ServletContext context = getServletConfig().getServletContext();
        InputStream inputStream = context.getResourceAsStream("/META-INF/MANIFEST.MF");
        Manifest manifest = new Manifest(inputStream);
        Attributes attributes = manifest.getMainAttributes();
        impVersion = attributes.getValue("Build-Time");
    } catch (Exception ex) {
        impVersion = "No se obtuvo fecha y hora de compilaci&oacute;n";
    }
      //request.setAttribute("timeBuild", impVersion); 
%>

<t:loginTemplate>
    <jsp:attribute name="paginaTitulo">
        Sistema de Entrada y Salida de Inmuebles
    </jsp:attribute>
    <jsp:attribute name="scripts">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <h3>Sistema de Entrada y Salida de Inmuebles</h4>
                        <hr class="red">
                        </div>
                        </div>

                        <div id="login" class="col-sm-8 panel panel-default">
                            <br>
                            <form id="command" role="form" class="form-horizontal bottom-buffer"
                                  role="form" id="frmLogin" action="j_spring_security_check"
                                  method="post">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label" for="usuario">Usuario:</label>
                                    <div class="col-sm-9">
                                        <input class="form-control errorMessageCall" id="j_username" name="j_username" placeholder="Usuario">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label" for="contrasena">Contrase&ntilde;a:</label>
                                    <div class="col-sm-9">
                                        <input class="form-control errorMessageCall" id="j_password" name="j_password" placeholder="Ingresa tu contraseña" type="password" minlength="3" maxlength="18">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-5 col-sm-offset-3">
                                        <input type="checkbox" id="recordarme" name="recordarme" /> Recordarme
                                    </div>
                                </div>
                                <div id="error" style="display: none;">
                                    <span style="color: red">Datos incorrectos, verifique e inténtelo de nuevo.</span>
                                </div>
                                <div id="error2" style="display: none;">
                                    <span style="color: red">El usuario se encuentra inhabilitado.</span>
                                </div>
                                <div id="error3" style="display: none;">
                                    <span style="color: red">El usuario ya ha iniciado sesi&oacute;n en otro lugar.</span>
                                </div>
                                <div id="error4" style="display: none;">
                                    <span style="color: red">Problema al ingresar,verifique su conexión a Internet.</span>
                                </div>
                                <br>
                                <div class="form-group">
                                    <div class="col-sm-offset-7 col-sm-5">
                                        <button class="btn btn-primary pull-right" type="button" id="btnEnviar">Entrar</button>
                                        <button class="btn btn-primary pull-right" type="submit" style="display:none" id="btnSubmit"></button>
                                    </div>
                                </div>
                            </form>
                        </div>
                </div>

                <div class="col-md-8 text-right">
                    <!-- TESTING -->
                    <!--<h6 id="title" align="center">versi&oacute;n 2.47</h6>-->
                    <!-- PRODUCCION -->
                    <h6 id="title">versi&oacute;n 2.0.21</h6>
                </div>
            </jsp:body>
        </t:loginTemplate>
        <script type="text/javascript" src="<c:url value='/static/js/libs/jquery/jquery-cookie-min.js'/>"></script> 

        <script>

            jQuery(document).ready(function () {
                jQuery('#recordarme').click(function () {
                    crearCookieRecordame();
                });

                verificarCookieRecordarme();

            <c:if test="${param.authfailed == true}" >
                var messageException = "<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>";

                if ("Bad credentials" === messageException) {
                    jQuery("#error").show("blind");
                } else if ("User is disabled" === messageException) {
                    jQuery("#error2").show("blind");
                } else if ("Maximum sessions of 1 for this principal exceeded" === messageException) {
                    jQuery("#error3").show("blind");
                } else {
                    jQuery("#error4").show("blind");
                }
            </c:if>
                jQuery("#btnEnviar").click(function () {
                    crearCookieRecordame();
                    jQuery("#btnSubmit").click();
                });

                jQuery('#j_username').keypress(function (e) {
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
                });
            });

            function verificarCookieRecordarme() {
                var recordarme = getCookie('recordarme');
                if (recordarme == 'true')
                {
                    var rfc = getCookie('rfc-rvoe');
                    var password = getCookie('password-rvoe');

                    jQuery('#j_username').val(rfc);
                    jQuery('#j_password').val(password);
                    jQuery('#recordarme').attr("checked", "checked");

                } else
                {

                }
            }

            function crearCookieRecordame() {
                if (jQuery('#recordarme').is(':checked')) {
                    var rfc = jQuery('#j_username').val();
                    var password = jQuery('#j_password').val();
                    var diasExpiracion = 14;

                    setCookie('rfc-rvoe', rfc, diasExpiracion);
                    setCookie('password-rvoe', password, diasExpiracion);
                    setCookie('recordarme', true, diasExpiracion);
                }
                else
                {
                    setCookie('rfc-rvoe', "", -1);
                    setCookie('password-rvoe', "", -1);
                    setCookie('recordarme', "", -1);
                }
            }

            function setCookie(cname, cvalue, exdays) {
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
