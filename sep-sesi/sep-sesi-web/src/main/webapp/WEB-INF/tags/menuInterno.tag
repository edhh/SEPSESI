<%@ tag language="java" pageEncoding="UTF-8"%>

<style>
    .dropdown-submenu {
        position: relative;
    }

    .dropdown-submenu .dropdown-menu {
        top: 0;
        left: 100%;
        margin-top: -1px;
    }
</style>
<div class="row">
    <nav class="navbar navbar-inverse sub-navbar navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#subenlaces">
                    <span class="sr-only">Interruptor de Navegación</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}">EDUCACIÓN</a>
            </div>

            <div class="collapse navbar-collapse" id="subenlaces">
                <ul class="nav navbar-nav navbar-right" id="ulMenu">
                </ul>                
            </div>
        </div>
    </nav>
</div>
