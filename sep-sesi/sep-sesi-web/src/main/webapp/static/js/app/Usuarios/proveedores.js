/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener ?
        window.addEventListener("load", init, false) :
        window.attachEvent && window.attachEvent("onload", init);
var modo;
function init() {
    $('#puesto').val('PROVEEDOR');
    //obtenerCuadrante();
    //obtenerCuadranteTodos();
    var idPersona = obtenerValorParametro('idPersona');

    $('#idPersona').val(idPersona);
    if (idPersona !== null) {
        obtieneEmpleado(idPersona);
        modo = 'editar';
    }
    else {
        obtInmueble();
        obtenerUR();
        obtenertipoSangre();
        modo = 'nuevo';
    }
    var proveedor = window.location.pathname;

}

function usuarioRol() {
    var vUrl = baseURI + '/mvc/seguridad/menu/obtenerUsuario';
    conectaPost(vUrl, "", resUsuario);
}

function resUsuario(data) {
    var rol_usuario = data.idRol
    var idUr = data.idUr;
    if (rol_usuario == 2) {
        $("#ur").prop('disabled', true);
        $('#ur').val(idUr);
        $('#idUR').val(idUr);
    }
}

function obtieneEmpleado(idPersona) {
    //Obtiene el usuario de sesi?n

    var cuadranteArea;
    var inmueble;
    var ur;
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/persona/obtieneEmpleado/" + idPersona,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            if (response.idPersona !== '') {

                $('#idPersona').val(response.idPersona);
                $('#curp').val(response.curp);
                $('#nombre').val(response.nombre);
                $('#primerApellido').val(response.apellido1);
                $('#segundoApellido').val(response.apellido2);
                inmueble = response.idInmueble;

                if (response.idInmueble != null) {
                    obtInmuebleMod(inmueble);
                } else {
                    obtInmueble();
                }

                ur = response.idUr;


                $('#idUR').val(ur);
                if (response.idUr != null) {
                    obtenerURMod(ur);
                } else {
                    obtenerUR();
                }
                usuarioRol();
                cuadranteArea = response.idCuadranteArea;
                if (response.idCuadranteArea != null) {
                    obtenerCuadranteS(response.idInmueble, cuadranteArea);
                }
                else {
                    populateSelectVacio();
                }

                $('#cuadrante').val(response.idCuadranteArea);
                $('#puesto').val(response.puesto);
                if (response.idTipoSangre != null) {
                    obtenertipoSangreMod(response.idTipoSangre);
                } else {
                    obtenertipoSangre();
                }

                $('#emergencia').val(response.telEmergencia);
                $('#alergias').val(response.alergias);
                $('#correo').val(response.email);
                $('#enfermedad').val(response.enfermedad);
                $('#estatus').val(response.estatus);
                $('#idFoto').val(response.fotografia);
                var fotografia = response.fotografia;
                var Imagen_Bin_String = bin2string(fotografia);
                var Imagen_Base64 = btoa(Imagen_Bin_String);
                document.getElementById("ItemPreview").src = "data:image/jpg;base64," + fotografia;
                document.getElementById("ItemPreview").width = 400;
                document.getElementById("ItemPreview").height = 300;
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }
    });

}

function bin2string(array) {
    var result = "";
    for (var i = 0; i < array.length; ++i) {
        result += (String.fromCharCode(array[i]));
    }
    return result;
}

function obtenerValorParametro(sParametroNombre) {
    var sPaginaURL = window.location.search.substring(1);
    var sURLVariables = sPaginaURL.split('?');
    for (var i = 0; i < sURLVariables.length; i++) {
        var sParametro = sURLVariables[i].split('=');
        if (sParametro[0] == sParametroNombre) {
            return sParametro[1];
        }
    }
    return null;
}

function obtInmueble()
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerInmueble",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            //drawTableGeneric(response);
            if (response.length > 0) {

                var inmuebles;
                inmuebles = response;
                populateSelectInmueble(inmuebles);
            } else {

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

function obtInmuebleMod(idInmueble)
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerInmueble",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            //drawTableGeneric(response);
            if (response.length > 0) {

                var inmuebles;
                inmuebles = response;
                populateSelectInmuebleMod(inmuebles, idInmueble);
            } else {

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

function obtenerUR()
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerUR",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            //drawTableGeneric(response);
            if (response.length > 0) {

                var UR;
                UR = response;
                populateSelectUR(UR);
                usuarioRol();
            } else {

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

function obtenerURMod(idUr)
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerUR",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            //drawTableGeneric(response);
            if (response.length > 0) {

                var UR;
                UR = response;
                populateSelectURMod(UR, idUr);
                usuarioRol();
            } else {

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

function consultaProveedor()
{
    location.href = baseURI + "/mvc/persona/consultaProveedor";
}

function obtenertipoSangre()
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenertipoSangre",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            //drawTableGeneric(response);
            if (response.length > 0) {

                var sangre;
                sangre = response;
                populateSelectSangre(sangre);
            } else {

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

function obtenertipoSangreMod(idSangre)
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenertipoSangre",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            //drawTableGeneric(response);
            if (response.length > 0) {

                var sangre;
                sangre = response;
                populateSelectSangreMod(sangre, idSangre);
            } else {

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

function obtenerAlergias()
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerAlergias",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            //drawTableGeneric(response);
            if (response.length > 0) {

                var alergias;
                alergias = response;
                populateSelectAlergias(alergias);
            } else {

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

function obtenerCuadrante()
{
    var inmueble = $("#inmuebleID").val();

    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerCuadrante/" + inmueble,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            //drawTableGeneric(response);
            if (response.length > 0) {

                var cuadrante;
                cuadrante = response;
                populateSelectCuadrante(cuadrante);
            } else {

                populateSelectVacio();
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

function obtenerCuadranteS(inmuebleID, idCuadrante)
{

    //var vUrl = baseURI + "/mvc/catalogos/obtenerCuadrante/" + inmuebleID;
    //conectaPost(vUrl, "", resCuadrantes);
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerCuadrante/" + inmuebleID,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            //drawTableGeneric(response);
            if (response.length > 0) {

                var cuadrante;
                cuadrante = response;
                populateSelectCuadrantes(cuadrante, idCuadrante);
            } else {

                $('#cuadrante option').prop('selected', function () {
                    return this.defaultSelected;
                });
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

function obtenerCuadranteTodos()
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerCuadranteTodos",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            //drawTableGeneric(response);
            if (response.length > 0) {

                var cuadrante;
                cuadrante = response;
                populateSelectCuadrante(cuadrante);
            } else {

                populateSelectVacio();
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

function obtenerEnfermedad()
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerEnfermedad",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            //drawTableGeneric(response);
            if (response.length > 0) {

                var enfermedad;
                enfermedad = response;
                populateSelectEnfermedad(enfermedad);
            } else {

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

function populateSelectEnfermedad(lstEnfermedad) {

    document.getElementById("enfermedad").options.length = 0;
    for (var i = 0; i <= lstEnfermedad.length - 1; i++) {

        if (i == 0 && lstEnfermedad.length >= 1) {

            $('#enfermedad').append('<option>' + 'Selecciona' + '</option>');
        }
        $('#enfermedad').append('<option value="' + lstEnfermedad[i].idEnfermedad + '">' + lstEnfermedad[i].descEnfermedad + '</option>');
    }

}

function populateSelectInmueble(lstInmueble) {

    document.getElementById("inmuebleID").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleID').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleID').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }

}

function populateSelectInmuebleMod(lstInmueble, idInmueble) {

    document.getElementById("inmuebleID").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleID').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleID').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }
    $('#inmuebleID').val(idInmueble);

}

function populateSelectUR(lstUR) {

    document.getElementById("ur").options.length = 0;
    for (var i = 0; i <= lstUR.length - 1; i++) {
        if (i == 0 && lstUR.length >= 1) {
            $('#ur').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#ur').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
    }

}

function populateSelectURMod(lstUR, idUr) {

    document.getElementById("ur").options.length = 0;
    for (var i = 0; i <= lstUR.length - 1; i++) {
        if (i == 0 && lstUR.length >= 1) {
            $('#ur').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#ur').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
    }
    $('#ur').val(idUr);
}

function populateSelectSangre(lstSangre) {

    document.getElementById("tipoSangre").options.length = 0;
    for (var i = 0; i <= lstSangre.length - 1; i++) {
        if (i == 0 && lstSangre.length >= 1) {
            $('#tipoSangre').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#tipoSangre').append('<option value="' + lstSangre[i].idTipo + '">' + lstSangre[i].tipoSangre + '</option>');
    }

}

function populateSelectSangreMod(lstSangre, idSangre) {

    document.getElementById("tipoSangre").options.length = 0;
    for (var i = 0; i <= lstSangre.length - 1; i++) {
        if (i == 0 && lstSangre.length >= 1) {
            $('#tipoSangre').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#tipoSangre').append('<option value="' + lstSangre[i].idTipo + '">' + lstSangre[i].tipoSangre + '</option>');
    }
    $('#tipoSangre').val(idSangre);
}

function populateSelectAlergias(lstAlergias) {

    document.getElementById("alergias").options.length = 0;
    for (var i = 0; i <= lstAlergias.length - 1; i++) {
        if (i == 0 && lstAlergias.length >= 1) {
            $('#alergias').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#alergias').append('<option value="' + lstAlergias[i].idAlergia + '">' + lstAlergias[i].descAlergia + '</option>');
    }

}

function populateSelectCuadrantes(lstCuadrante, idCuadrante) {

    document.getElementById("cuadrante").options.length = 0;
    for (var i = 0; i <= lstCuadrante.length - 1; i++) {
        if (i == 0 && lstCuadrante.length >= 1) {
            $('#cuadrante').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#cuadrante').append('<option value="' + lstCuadrante[i].idCuadranteArea + '">' + lstCuadrante[i].cuadranteArea + '</option>');
    }
    $('#cuadrante').val(idCuadrante);

}

function populateSelectCuadrante(lstCuadrante) {

    document.getElementById("cuadrante").options.length = 0;
    for (var i = 0; i <= lstCuadrante.length - 1; i++) {
        if (i == 0 && lstCuadrante.length >= 1) {
            $('#cuadrante').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#cuadrante').append('<option value="' + lstCuadrante[i].idCuadranteArea + '">' + lstCuadrante[i].cuadranteArea + '</option>');
    }

}

function populateSelectVacio() {

    document.getElementById("cuadrante").options.length = 0;
    $('#cuadrante').append('<option>' + 'SELECCIONA' + '</option>');

}

function insertaProveedor() {

    var doc = document.getElementById("cargaArchivo").value;
    var vcfData = new FormData($('#formCarga')[0]);
    vcfData.append("puesto", "PROVEEDOR");
    console.log('vcfData es' + vcfData);

    //document.getElementById("btnGuardar").disabled = true;
    var idUr = document.getElementById("ur");
    var idUrValue = idUr.value;

    var foto = document.getElementById("idFoto").value;
    if (validaDatos()) {
        document.getElementById("btnGuardar").disabled = true;
        if (foto === '') {

            if (doc) {
                var imgsize = document.getElementsByClassName("subirimagen")[0].files[0].size;

                var jpgType = doc.search(".jpg");
                var jpegType = doc.search(".jpeg");
                if (jpgType != -1 || jpegType != -1) {
                    if (imgsize <= 10000000) {
                        //$('#myModal').modal('show');
                        //document.forms["formCarga"].submit();
                        $('#loader').modal('toggle');
                        document.getElementById("btnGuardar").disabled = true;
                        $.ajax({
                            type: "POST",
                            cache: false,
                            url: baseURI + "/mvc/persona/insertaProveedor",
                            data: vcfData,
                            processData: false, contentType: false,
                            method: "POST",
                            dataType: 'json',
                            success: function (reponse) {

                                $('#loader').modal('toggle');
                                $('#myModal1').modal('show');
                                $("#myModal1 .modal-body").text(reponse.msg);
                                console.log('despues');
                                //docenteId = 0;

                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                $('#loader').modal('toggle');
                                $('#myModal1').modal('show');
                                $("#myModal1 .modal-body").text('Ocurri\u00F3 un error al registrar los datos');
                                console.log('jqXHR.status:: ' + jqXHR.status);
                                console.log('jqXHR.text:: ' + jqXHR.text);
                                console.log('textStatus:: ' + textStatus);
                            }
                        });
                    }
                    else {
                        $('#myModal').modal('show');
                        $("#myModal .modal-body").text('La imagen no puede tener un tama\u00F1o superior a los 10 MB');
                        document.getElementById("btnGuardar").disabled = false;
                    }
                }
                else {

                    $('#myModal').modal('show');
                    $("#myModal .modal-body").text('Tipo de archivo inv\u00E1lido');
                    document.getElementById("btnGuardar").disabled = false;
                }
            }
            else {

                $('#myModalll').modal('show');
                $("#myModalll .modal-body").text('Seleccione un archivo');
                document.getElementById("btnGuardar").disabled = false;
            }
        } else {

            $('#loader').modal('toggle');
            document.getElementById("btnGuardar").disabled = true;
            $.ajax({
                type: "POST",
                cache: false,
                url: baseURI + "/mvc/persona/insertaProveedor",
                data: vcfData,
                processData: false, contentType: false,
                method: "POST",
                dataType: 'json',
                success: function (reponse) {

                    $('#loader').modal('toggle');
                    $('#myModal1').modal('show');
                    $("#myModal1 .modal-body").text(reponse.msg);
                    console.log('despues');
                    //docenteId = 0;

                },
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#loader').modal('toggle');
                    $('#myModal1').modal('show');
                    $("#myModal1 .modal-body").text('Ocurri\u00F3 un error al registrar los datos');
                    console.log('jqXHR.status:: ' + jqXHR.status);
                    console.log('jqXHR.text:: ' + jqXHR.text);
                    console.log('textStatus:: ' + textStatus);
                }
            });
        }

    }

    //}
}

function reloadPageModal() {
    location.reload();
}

function validaDatos() {

    var datosValidos = true;
    var curp = $("#curp").val();
    var nombre = $("#nombre").val();
    var apPaterno = $("#primerApellido").val();
    var apMaterno = $("#segundoApellido").val();
    var inmueble = $("#inmuebleID").val();
    var ur = $("#ur").val();
    var cuadrante = $("#cuadrante").val();
    var tipoSangre = $("#tipoSangre").val();
    var emergencia = $("#emergencia").val();
    var alergias = $("#alergias").val();
    var enfermedad = $("#enfermedad").val();
    var puesto = $("#puesto").val();
    var estatus = $("#estatus").val();
    var idUr = document.getElementById("ur").value;
    $('#idUR').val(idUr);

    if (curp === null || curp.length === 0) {
        $("#curpDiv").addClass("has-error");
        $("#errorCurp").text('');
        $("#errorCurp").show();
        $("#errorCurp").append("Campo obligatorio");
        datosValidos = false;
    }

    if (curpV(curp) && curp.length > 0) {
        $("#curpDiv").addClass("has-error");
        $("#errorCurp").text('');
        $("#errorCurp").show();
        $("#errorCurp").append("Formato inv&aacute;lido para la CURP");
        datosValidos = false;
    }

    if (nombre === null || nombre.length === 0) {
        $("#nombreDiv").addClass("has-error");
        $("#errorNombre").text('');
        $("#errorNombre").show();
        $("#errorNombre").append("Campo obligatorio");
        datosValidos = false;
    }

    if (apPaterno === null || apPaterno.length === 0) {
        $("#paternoDiv").addClass("has-error");
        $("#errorPaterno").text('');
        $("#errorPaterno").show();
        $("#errorPaterno").append("Campo obligatorio");
        datosValidos = false;
    }


    if (puesto === null || puesto.length === 0) {
        $("#puestoDiv").addClass("has-error");
        $("#errorPuesto").text('');
        $("#errorPuesto").show();
        $("#errorPuesto").append("Campo obligatorio");
        datosValidos = false;
    }

    if (nombre.length > 0 && !validaSoloLetras(nombre)) {
        $("#nombreDiv").addClass("has-error");
        $("#errorNombre").text('');
        $("#errorNombre").show();
        $("#errorNombre").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }


    if (!validaSoloLetras(apPaterno) && apPaterno.length > 0) {
        $("#paternoDiv").addClass("has-error");
        $("#errorPaterno").text('');
        $("#errorPaterno").show();
        $("#errorPaterno").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }
    if (!validaSoloLetras(apMaterno) && apMaterno.length > 0) {
        $("#maternoDiv").addClass("has-error");
        $("#errorMaterno").text('');
        $("#errorMaterno").show();
        $("#errorMaterno").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }

    if (emergencia.length === 0) {
        $("#emergenciaDiv").addClass("has-error");
        $("#errorEmergencia").text('');
        $("#errorEmergencia").show();
        $("#errorEmergencia").append("Campo obligatorio");
        datosValidos = false;
    }

    if (emergencia.length != 10 && emergencia.length > 0) {
        $("#emergenciaDiv").addClass("has-error");
        $("#errorEmergencia").text('');
        $("#errorEmergencia").show();
        $("#errorEmergencia").append("Debe contener 10 d&iacute;gitos");
        datosValidos = false;
    }

    if (validaSoloNumeros(emergencia) && emergencia.length > 0) {
        $("#emergenciaDiv").addClass("has-error");
        $("#errorEmergencia").text('');
        $("#errorEmergencia").show();
        $("#errorEmergencia").append("&Uacute;nicamente debe contener caracteres num&eacute;ricos");
        datosValidos = false;
    }

    if (inmueble == "SELECCIONA") {
        $("#inmuebleDiv").addClass("has-error");
        $("#errorInmueble").text('');
        $("#errorInmueble").show();
        $("#errorInmueble").append("Campo obligatorio");
        datosValidos = false;
    }

    if (ur == "SELECCIONA") {
        $("#urDiv").addClass("has-error");
        $("#errorUr").text('');
        $("#errorUr").show();
        $("#errorUr").append("Campo obligatorio");
        datosValidos = false;
    }

    if (cuadrante == "SELECCIONA") {
        $("#cuadranteDiv").addClass("has-error");
        $("#errorCuadrante").text('');
        $("#errorCuadrante").show();
        $("#errorCuadrante").append("Campo obligatorio");
        datosValidos = false;
    }

    if (tipoSangre == "SELECCIONA") {
        $("#sangreDiv").parent("div.form-group").addClass("has-error");
        $("#errortipoSangre").text('');
        $("#errortipoSangre").show();
        $("#errortipoSangre").append("Campo obligatorio");
        datosValidos = false;
    }

    if (estatus == "SELECCIONA") {
        $("#estatusDiv").parent("div.form-group").addClass("has-error");
        $("#errorEstatus").text('');
        $("#errorEstatus").show();
        $("#errorEstatus").append("Campo obligatorio");
        datosValidos = false;
    }

    if (!validaSoloLetras(alergias) && alergias.length > 0) {
        $("#alergiasDiv").addClass("has-error");
        $("#errorAlergias").text('');
        $("#errorAlergias").show();
        $("#errorAlergias").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }

    if (!validaSoloLetras(enfermedad) && enfermedad.length > 0) {
        $("#enfermedadDiv").addClass("has-error");
        $("#errorEnfermedad").text('');
        $("#errorEnfermedad").show();
        $("#errorEnfermedad").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }

    if (!validaSoloLetras(puesto) && puesto.length > 0) {
        $("#puestoDiv").addClass("has-error");
        $("#errorPuesto").text('');
        $("#errorPuesto").show();
        $("#errorPuesto").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }

    return datosValidos;
}

function curpV(curp) {
    if (curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9a-z]{1}[0-9]{1})$/i)) {//AAAA######AAAAAAA-##
        console.log('false');
        return false;
    } else {
        console.log('true');
        return true;
    }
}

/*$('#formCarga').submit(function () {
 
 //insertaVisitantes();
 
 var doc = document.getElementById("cargaArchivo").value;
 
 //document.getElementById("btnGuardar").disabled = true;
 var idUr = document.getElementById("ur");
 var idUrValue = idUr.value;
 
 var foto = document.getElementById("idFoto").value;
 if (validaDatos()) {
 document.getElementById("btnGuardar").disabled = true;
 if (foto === '') {
 
 if (doc) {
 var imgsize = document.getElementsByClassName("subirimagen")[0].files[0].size;
 
 var jpgType = doc.search(".jpg");
 var jpegType = doc.search(".jpeg");
 if (jpgType != -1 || jpegType != -1) {
 if (imgsize <= 10000000) {
 //$('#myModal').modal('show');
 //document.forms["formCarga"].submit();
 insertaProveedor();
 }
 else {
 $('#myModal').modal('show');
 $("#myModal .modal-body").text('La imagen no puede tener un tama\u00F1o superior a los 10 MB');
 document.getElementById("btnGuardar").disabled = false;
 }
 }
 else {
 
 $('#myModal').modal('show');
 $("#myModal .modal-body").text('Tipo de archivo inv\u00E1lido');
 document.getElementById("btnGuardar").disabled = false;
 }
 }
 else {
 
 $('#myModalll').modal('show');
 $("#myModalll .modal-body").text('Seleccione un archivo');
 document.getElementById("btnGuardar").disabled = false;
 }
 } else {
 
 insertaProveedor();
 }
 
 }
 
 });*/

function verificarCurp() {
    console.log('Verificar curp y el modo es ' + modo);
    if (modo === "nuevo") {
        $.ajax({
            type: "POST",
            cache: false,
            url: baseURI + "/mvc/persona/verificaCurp/" + $("#curp").val(),
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            success: function (response) {
                if (response.respuesta !== ' ') {
                    console.log('respuesta' + response.respuesta);
                    $('#myModal1').modal('show');
                    $("#myModal1 .modal-body").text(response.respuesta);

                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('jqXHR.status:: ' + jqXHR.status);
                console.log('jqXHR.text:: ' + jqXHR.text);
                console.log('textStatus:: ' + textStatus);
            }
        });
    }
}

function reloadPageAfterLoadFile() {
    var doc = document.getElementById("cargaArchivo").value;
    var proveedor = document.getElementById("puesto").value;
    console.log('Puesto es ' + proveedor);
    /*var vcfData = new FormData($('#formCarga')[0]);
     vcfData.append("puesto","PROVEEDOR");*/


    //document.getElementById("btnGuardar").disabled = true;
    var idUr = document.getElementById("ur");
    var idUrValue = idUr.value;

    var foto = document.getElementById("idFoto").value;
    if (validaDatos()) {
        document.getElementById("btnGuardar").disabled = true;
        if (foto === '') {

            if (doc) {
                var imgsize = document.getElementsByClassName("subirimagen")[0].files[0].size;

                var jpgType = doc.search(".jpg");
                var jpegType = doc.search(".jpeg");
                if (jpgType != -1 || jpegType != -1) {
                    if (imgsize <= 10000000) {
                        //$('#myModal').modal('show');
                        //document.forms["formCarga"].submit();
                        console.log('antes del submit');
                        $('#loader').modal('toggle');
                        document.forms["formCarga"].submit();
                        setTimeout(function () {
                            $('#loader').modal('toggle');
                            console.log('despues del submit');
                            $('#myModal1').modal('show');
                            $("#myModal1 .modal-body").text('Se han registrado los datos correctamente');
                        }, 32000);
                    }
                    else {
                        $('#myModal').modal('show');
                        $("#myModal .modal-body").text('La imagen no puede tener un tama\u00F1o superior a los 10 MB');
                        document.getElementById("btnGuardar").disabled = false;
                    }
                }
                else {

                    $('#myModal').modal('show');
                    $("#myModal .modal-body").text('Tipo de archivo inv\u00E1lido');
                    document.getElementById("btnGuardar").disabled = false;
                }
            }
            else {

                $('#myModalll').modal('show');
                $("#myModalll .modal-body").text('Seleccione un archivo');
                document.getElementById("btnGuardar").disabled = false;
            }
        } else {

            console.log('antes del submit');
            $('#loader').modal('toggle');
            document.forms["formCarga"].submit();
            setTimeout(function () {
                $('#loader').modal('toggle');
                console.log('despues del submit');
                $('#myModal1').modal('show');
                $("#myModal1 .modal-body").text('Se han registrado los datos correctamente');
            }, 32000);
        }

    }
}

/*function validaSoloLetras(data) {
 var re = /((^[A-Za-z\\s\u00f1\u00d1.,\\-_\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00e4\u00eb\u00ef\u00f6\u00fc\u00c4\u00cb\u00cf\u00d6\u00dc]?)|(^[A-Z a-z\\s\u00f1\u00d1.,\\-_\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00e4\u00eb\u00ef\u00f6\u00fc\u00c4\u00cb\u00cf\u00d6\u00dc]+))([A-Za-z\\s\u00f1\u00d1.,\\-_\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00e4\u00eb\u00ef\u00f6\u00fc\u00c4\u00cb\u00cf\u00d6\u00dc]$)/;
 if (data.match(re))  //Coincide con el formato general?
 return false;
 else
 return true; //Validado
 }*/

/*function validaSoloLetras(data) {
 var re = /^(?=.{1,40}$)[a-zA-Z????????????]+(?:[-' ][a-zA-Z]+)*$/;
 console.log('expresionregular ' + data.match(re));
 if (data.match(re))  //Coincide con el formato general?
 return false;
 else
 return true; //Validado }
 }*/

function validaSoloLetras(data) {
    var pattern = new RegExp('^[A-Z\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DC\u00FC\u00D1\u00F1\\s]+$', 'i');
    console.log('valor reg --> ' + pattern.test(data));
    if (!pattern.test(data)) {  //Coincide con el formato general?
        console.log("false");
        return false;
    }
    else {
        console.log("true");
        return true;
    }//Validado
}

function soloLetras(data) {
    var re = /[a-zA-Z ]$/;
    if (data.match(re))
        return false;
    else
        return true;
}

function validaCurp(curp) {
    var re = /^([A-Z][AEIOUX][A-Z]{2}\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\d])(\d)$/;
    validado = curp.match(re);
    console.log("VALIDANDO CURP " + validado);
    if (curp.match(re))  //Coincide con el formato general?
        return false;
    else
        return true; //Validado
}

function validaSoloNumeros(data) {
    var re = /^[0-9]+$/;
    if (data.match(re))  //Coincide con el formato general?
        return false;
    else
        return true; //Validado
}

function asignaUR() {
    var idUr = document.getElementById("ur").value;
    $('#idUR').val(idUr);
    console.log('id Ur valorUR es ' + idUr);

}

function readFile(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            document.getElementById("file-preview-zone").innerHTML = "";
            document.getElementById("imageBase").innerHTML = "";
            var filePreview = document.createElement('img');
            filePreview.id = 'file-preview';
            //e.target.result contents the base64 data from the image uploaded
            filePreview.src = e.target.result;
            filePreview.width = 400;
            filePreview.height = 300;

            var previewZone = document.getElementById('file-preview-zone');
            previewZone.appendChild(filePreview);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

var fileUpload = document.getElementById('cargaArchivo');
fileUpload.onchange = function (e) {
    readFile(e.srcElement);
}

function limpiar() {
    document.getElementById("formCarga").reset();
}