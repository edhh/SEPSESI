// window.addEventListener ?
//            window.addEventListener("load", obtieneUsuario, false) :
//            window.attachEvent && window.attachEvent("onload", obtieneUsuario);

$(document).ready(function () {
    obtieneUsuario();
});


    function obtieneUsuario() {
        //Obtiene el usuario de sesión

        console.log('obteniendo usuario');
        $.ajax({
            type: "POST",
            cache: false,
            url: baseURI + "/mvc/configuracion/obtenerUsuario",
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            success: function (response) {
                if (response.idUsuario !== '') {
                    $('#nombreUsConfig').val(response.username);
                    console.log("username --> " + response.username);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#mensajesError').html('<div class="alert alert-warning">No se encontraron registros</div>').show();
                console.log('jqXHR.status:: ' + jqXHR.status);
                console.log('jqXHR.text:: ' + jqXHR.text);
                console.log('textStatus:: ' + textStatus);
            }
        });

    }
    
     $(".sinEspaciosPass").keydown(function (event) {
         console.log("barra de espacio");
        // Desactiva la barra de espacio
        if (event.keyCode === 32) {
            event.preventDefault();
            $("#newPasswordDiv").addClass("has-error");
            $("#errorNewPass").text('');
            $("#errorNewPass").show();
            $("#errorNewPass").append("La contrase&ntilde;a no debe tener espacios en blanco");
        } else {
            $("#newPasswordDiv").removeClass("has-error");
            $("#errorNewPass").text('');
            $("#errorNewPass").hide();
        }
    });


    function cambioContrasena() {
        var idUsuario;
        hideErrorLabels();
        var search = {};
        search["idUsuario"] = idUsuario;
        search["nombreUsu"] = $("#nombreUsConfig").val();
        search["contrasena"] = $("#newPass").val();
        search["contrasena"] = $("#confPass").val();

        console.log('update');
        if (validaDatos()) {
            document.getElementById("btnGuardarPass").disabled = true;
            $.ajax({
                type: "POST",
                cache: false,
                url: baseURI + "/mvc/configuracion/cambioContrasena.htm",
                data: search,
                dataType: 'text',
                success: function (response) {

                    console.log("respuesta --> " + response);

                    if (response == 'exito') {
                        $("#divExitoPagina").removeClass().addClass("alert alert-success").text('').append("La contrase&ntilde;a se modific&oacute; exitosamente.").show();
                        console.log('exito00');
                        setTimeout(function () {
                            location.href = baseURI + '/mvc/index';
                            //location.href = baseURI + '/mvc/firmantes/listFirmantes';
                        }, 3000);
                    } else if (response == 'noPermitido'){

                        $("#divErrorPagina").removeClass().addClass("alert alert-warning").text('').append("Acci&oacute;n no permitida").show();
                        console.log('Acción no permitida');
                    }else{

                        $("#divErrorPagina").removeClass().addClass("alert alert-warning").text('').append("No se encontr&oacute; usuario").show();
                        console.log('No se encontró usuario');

                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#myModal4').modal('show');

                    // Modificar el texto dentro de la ventana modal
                    $("#myModal4.modal-body").text('Se ha producido un error');
                    console.log('jqXHR.status:: ' + jqXHR.status);
                    console.log('jqXHR.text:: ' + jqXHR.text);
                    console.log('textStatus:: ' + textStatus);
                }
            });
        }
    }

    function hideErrorLabels() {
        console.log("Limpiando etiquetas");
        $("#errorNombreUsConfig").hide();
        $("#errorNewPass").hide();
        $("#errorConfPass").hide();

    }

    function validaDatos() {
        console.log("validaDatos");
        var datosValidos = true;
        var nombreUs = $("#nombreUsConfig").val();
        var newPass = $("#newPass").val();
        var confPass = $("#confPass").val();

        if (nombreUs === null || nombreUs.length === 0) {
            $("#nombreUsDiv").parent("div.form-group").addClass("has-error");
            $("#errorNombreUs").text('');
            $("#errorNombreUs").show();
            $("#errorNombreUs").append("Campo obligatorio");
            datosValidos = false;
        }

        if (newPass === null || newPass.length === 0) {
            //$("#newPasswordDiv").parent("div.form-group").addClass("has-error");
            $("#newPasswordDiv").addClass("has-error");
            $("#errorNewPass").text('');
            $("#errorNewPass").show();
            $("#errorNewPass").append("Campo obligatorio");
            datosValidos = false;
        }

        if (confPass === null || confPass.length === 0) {
            $("#confPassDiv").addClass("has-error");
            $("#errorConfPass").text('');
            $("#errorConfPass").show();
            $("#errorConfPass").append("Campo obligatorio");
            datosValidos = false;
        }

        if (newPass.length > 0 && newPass.length < 6) {
            //$("#newPasswordDiv").parent("div.form-group").addClass("has-error");
            $("#newPasswordDiv").addClass("has-error");
            $("#errorNewPass").text('');
            $("#errorNewPass").show();
            $("#errorNewPass").append("La contrase&ntilde;a debe tener 6 caracteres como m&iacute;nimo");
            datosValidos = false;
        }

        if (newPass !== confPass) {
            $("#confPassDiv").addClass("has-error");
            $("#errorConfPass").text('');
            $("#errorConfPass").show();
            $("#errorConfPass").append("Las contrase&ntilde;as no coinciden");
            datosValidos = false;
        }

        return datosValidos;

    }

   