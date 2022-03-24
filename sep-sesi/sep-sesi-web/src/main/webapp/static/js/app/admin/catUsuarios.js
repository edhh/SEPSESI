var checkedRows = [];
var modo;

$(document).ready(function () {
    obtInmueble();
    obtenerUR();
    obtenerRol();
});

$("#limpiarCatUsuario").click(function () {
    $('#urCatUsu').val('');
    $('#rolCatUsuar').val('');
    $('#inmuebleCatUsuar').val('');
    $('#idURCatUsu').val('');
    $('#idRolCatUsuar').val('');
    $('#idInmuebleCatUsuar').val('');
    checkedRows = [];
    $('#resultadosUsuarioTable').bootstrapTable('destroy');
});

$("#buscarCatUsuario").click(function () {

    var columnas = [
        {
            field: 'nombre',
            title: 'Nombre',
            align: 'center'
        }, {
            field: 'apellido1',
            title: 'Primer apellido',
            align: 'center'
        }, {
            field: 'apellido2',
            title: 'Segundo apellido',
            align: 'center'
        }, {
            field: 'nombreUsu',
            title: 'Nombre Usuario',
            align: 'center'
        }, {
            field: 'descRol',
            title: 'Rol',
            align: 'center'
        }, {
            field: 'unidadResponsable',
            title: 'Unidad Responsable',
            align: 'center'
        }, {
            field: 'descInmueble',
            title: 'Inmueble',
            align: 'center'
        }, {
            field: 'descAcceso',
            title: 'Acceso',
            align: 'center'
        }, {
            field: 'operate',
            //title: 'Edit',
            align: 'center',
            valign: 'middle',
            clickToSelect: false,
            formatter: addbutton = function addbutton(value, row, index) {
                return '<button class=\'btn btn-primary btn-edit\' idUsuario="' + row.idUsuario + '">Modificar</button> ';
            }
        }]

    $('#resultadosUsuarioTable').bootstrapTable({
        columns: columnas
    });

    $('#resultadosUsuarioTable').bootstrapTable('showLoading');
    var param = {};
    param["idUr"] = $('#idURCatUsu').val();
    param["idRol"] = $('#idRolCatUsuar').val();
    param["idInmueble"] = $('#idInmuebleCatUsuar').val();
    console.log(param);

    $('#loader').modal('toggle');
    checkedRows = [];
    $.ajax({
        url: baseURI + "/mvc/admin/obtenerCatUsuario",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        data: param,
        //dataType: "json",
        cache: false,
    }).done(function (resumenInstancias) {
        console.log(resumenInstancias);
        $('#resultadosUsuarioTable').bootstrapTable('destroy');
        $('#resultadosUsuarioTable').bootstrapTable({
            pagination: true,
            paginationHAlign: 'left',
            paginationDetailHAlign: 'right',
            classes: 'table table-bordered table-hover',
            striped: true,
            pageList: [],
            columns: columnas,
            data: resumenInstancias
        });
        $('#loader').modal('toggle');
    }).fail(function () {
        $('#loader').modal('toggle');
    });
});


function obtenerUR() {

    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerUR",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            if (response.length > 0) {

                var UR;
                UR = response;
                populateSelectUR(UR);

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

function populateSelectUR(lstUR) {

    document.getElementById("urCatUsu").options.length = 0;
    for (var i = 0; i <= lstUR.length - 1; i++) {
        if (i == 0 && lstUR.length >= 1) {
            $('#urCatUsu').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#urCatUsu').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
    }

}

function asignaUR() {
    var idUr = document.getElementById("urCatUsu").value;
    $('#idURCatUsu').val(idUr);
    console.log('id Ur valorUR es ' + idUr);

}


function obtenerRol() {

    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerRol",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            if (response.length > 0) {

                var rol;
                rol = response;
                populateSelectRol(rol);

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

function populateSelectRol(lstRol) {

    document.getElementById("rolCatUsuar").options.length = 0;
    for (var i = 0; i <= lstRol.length - 1; i++) {
        if (i == 0 && lstRol.length >= 1) {
            $('#rolCatUsuar').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#rolCatUsuar').append('<option value="' + lstRol[i].idRol + '">' + lstRol[i].descRol + '</option>');
    }

}

function asignarRol() {
    var idRol = document.getElementById("rolCatUsuar").value;
    $('#idRolCatUsuar').val(idRol);
    console.log('id Rol  ' + idRol);

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


function populateSelectInmueble(lstInmueble) {

    document.getElementById("inmuebleCatUsuar").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleCatUsuar').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleCatUsuar').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }

}

function asignarInmueble() {
    var idInmueble = document.getElementById("inmuebleCatUsuar").value;
    $('#idInmuebleCatUsuar').val(idInmueble);
    console.log('id Inmueble  ' + idInmueble);

}

$('#nuevoUsuario').click(function () {
    //$("#urFirmModal").prop('disabled', false);
    obtenerURMod();
    obtInmuebleMod();
    obtenerRolMod();
    $("#passCheckbox").prop('checked', true);
    $("#passCheckbox").hide();
    $("#labPass").hide();

    f_pass();
    $('#ModalUsuarios').modal('show');
});

function obtenerURMod(idUr) {

    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerUR",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            if (response.length > 0) {

                var UR;
                UR = response;
                populateSelectURMod(UR, idUr);

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

function populateSelectURMod(lstUR, idUr) {

    document.getElementById("urUsuar").options.length = 0;
    for (var i = 0; i <= lstUR.length - 1; i++) {
        if (i == 0 && lstUR.length >= 1) {
            $('#urUsuar').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#urUsuar').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
    }
    $('#urUsuar').val(idUr);
}

function asignaURMod() {
    var idUr = document.getElementById("urUsuar").value;
    $('#idURUsuar').val(idUr);
    console.log('id Ur valorUR es ' + idUr);

}

function obtenerRolMod(idRol) {

    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerRol",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            if (response.length > 0) {

                var rol;
                rol = response;
                populateSelectRolMod(rol, idRol);
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

function populateSelectRolMod(lstRol, idRol) {

    document.getElementById("rolUsuarMod").options.length = 0;
    for (var i = 0; i <= lstRol.length - 1; i++) {
        if (i == 0 && lstRol.length >= 1) {
            $('#rolUsuarMod').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#rolUsuarMod').append('<option value="' + lstRol[i].idRol + '">' + lstRol[i].descRol + '</option>');
    }
    $('#rolUsuarMod').val(idRol);
}

function asignarRolMod() {
    var idRol = document.getElementById("rolUsuarMod").value;
    $('#idRolUsuarMod').val(idRol);
    console.log('id Rol  ' + idRol);

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


function populateSelectInmuebleMod(lstInmueble, idInmueble) {

    document.getElementById("inmuebleIDUsuarMod").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleIDUsuarMod').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleIDUsuarMod').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }
    $('#inmuebleIDUsuarMod').val(idInmueble);
}

function obtenerAcceso(idAcceso)
{
    var inmueble = $("#inmuebleIDUsuarMod").val();

    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerAcceso/" + inmueble,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            if (response.length > 0) {

                var acceso;
                acceso = response;
                populateSelectAcceso(acceso, idAcceso);
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


function populateSelectAcceso(lstAcceso, idAcceso) {

    document.getElementById("accesoUsuar").options.length = 0;
    for (var i = 0; i <= lstAcceso.length - 1; i++) {
        if (i == 0 && lstAcceso.length >= 1) {
            $('#accesoUsuar').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#accesoUsuar').append('<option value="' + lstAcceso[i].idAcceso + '">' + lstAcceso[i].desAcceso + '</option>');
    }
    $('#accesoUsuar').val(idAcceso);
}

function populateSelectVacio() {

    document.getElementById("accesoUsuar").options.length = 0;
    $('#accesoUsuar').append('<option>' + 'SELECCIONA' + '</option>');

}

function asignaAccesoUsuar() {
    var idAcceso = document.getElementById("accesoUsuar").value;
    $('#idAccesoUsuar').val(idAcceso);
    console.log('idAcceso  ' + idAcceso);
}

//$('#crearUsuarioCat').click(function(e) {

function insertaUsuarioCat() {
    
    var idUsuario = $('#idUsuarioCat').val();
    var curp = $('#curpModal').val();
    var nombre = $('#nombreUsuar').val();
    var apellidoPat = $('#primerApellidoUsuar').val();
    var apellidoMat = $('#segundoApellidoUsuar').val();
    var nombreUsu = $('#nombreUsuUsuar').val();
    //var contrasegna = $('#contrasegnaUsuar').val();
    var idRol = $('#idRolUsuarMod').val();
    var idInmueble = $('#inmuebleIDUsuarMod').val();
    var acceso = $('#idAccesoUsuar').val();
    var idUR = $('#idURUsuar').val();
    var estatus = $('#activoUsu').val();
    limpiarEtiquetas();

    if (validaDatos()) {
        $('#btnGuardarUsuar').attr('disabled', 'disabled');

        var dataUsuario = {};

        dataUsuario.idUsuario = idUsuario;
        dataUsuario.nombre = nombre;
        dataUsuario.curp = curp;
        dataUsuario.apellido1 = apellidoPat;
        dataUsuario.apellido2 = apellidoMat;
        dataUsuario.nombreUsu = nombreUsu;
        if ($("#passCheckbox").prop('checked') == false) {
            $("#contrasegnaUsuar").val('');
            $("#contrasegnaVerif").val('');
        } else {
            $("#contrasegnaUsuar").attr('required', 'required');
            var pass = $("#contrasegnaUsuar").val();
            if (pass == '') {
                $("#contrasegnaUsuarDiv").addClass("has-error");
                $("#errorContrasegnalUsuar").text('');
                $("#errorContrasegnalUsuar").show();
                $("#errorContrasegnalUsuar").append("Especifique contrase&ntilde;a");
                //$("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Falta especificar la contraseña.").show();
                return;
            }
        }
        dataUsuario.contrasena = $('#contrasegnaUsuar').val();
        dataUsuario.idRol = idRol;
        dataUsuario.idInmueble = idInmueble;
        dataUsuario.idUr = idUR;
        dataUsuario.idAcceso = acceso;
        dataUsuario.activo = estatus;
        console.log(dataUsuario);

        var vURL = baseURI + '/mvc/admin/crearUsuarioCat';

        $.ajax({
            type: "POST",
            cache: false,
            url: vURL,
            contentType: 'application/json;  charset=utf-8',
            data: JSON.stringify(dataUsuario),
            dataType: 'json',
            success: function (response) {
                console.log(response);
                $('#btnGuardarUsuar').attr('disabled', 'disabled');
                var respuesta = response.msg;
                if (respuesta === '2') {
                    $("#divErrorPagina").removeClass().addClass("alert alert-warning").text('').append("Ya existe ese nombre de usuario.").show();
                } else {
                    $("#divExitoPagina").removeClass().addClass("alert alert-success").text('').append("La informaci&oacute;n se registr&oacute; exitosamente.").show();

                    setTimeout(function () {
                        location.href = baseURI + '/mvc/admin/catUsuarios';
                    }, 3000);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('jqXHR.status:: ' + jqXHR.status);
                console.log('jqXHR.text:: ' + jqXHR.text);
                console.log('textStatus:: ' + textStatus);
                $("#divErrorPagina").removeClass().addClass("alert alert-warning").text('').append("Algo sali&oacute; mal").show();
            }
        });
    }
}

$('#resultadosUsuarioTable').on('click', '.btn-edit', function () {
    var idUsuario = $(this).attr('idUsuario');
    obtieneUsuario(idUsuario);
    modo = 'editar';
});

function obtieneUsuario(idUsuario) {
    $('.has-error').removeClass("has-error");
    $("#errorCurpModal").text('');
    $("#errorNombreUsuar").text('');
    $("#errorPaternoUsuar").text('');
    $("#errorMaternoUsuar").text('');
    $("#errorNombreUsuUsuar").text('');
    $("#errorContrasegnalUsuar").text('');
    $("#errorContrasegnaVerif").text('');
    $("#errorRolUsuar").text('');
    $("#errorInmuebleUsuar").text('');
    $("#errorAccesoUsuar").text('');
    $("#errorUrUsuar").text('');
    $("#errorActivo").text('');
    $("#passCheckbox").prop('checked', false);
    $("#passCheckbox").show();
    $("#labPass").show();

    var rol;
    var inmueble;
    var ur;
    var acceso;
    $('#loader').modal('toggle');
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/admin/obtieneUsuario/" + idUsuario,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            console.log(response);
            if (response.idUsuario !== '') {
                $('#idUsuarioCat').val(response.idUsuario);
                $('#curpModal').val(response.curp);
                $('#nombreUsuar').val(response.nombre);
                $('#primerApellidoUsuar').val(response.apellido1);
                $('#segundoApellidoUsuar').val(response.apellido2);
                $('#nombreUsuUsuar').val(response.nombreUsu);

                $('#contrasegnaUsuar').val(response.contrasena);
                $('#contrasegnaVerif').val(response.contrasena);
                inmueble = response.idInmueble;

                if (response.idInmueble != null) {
                    obtInmuebleMod(inmueble);
                } else {
                    obtInmueble();
                }

                ur = response.idUr;

                $('#idURUsuar').val(ur);
                if (response.idUr != null) {
                    obtenerURMod(ur);
                } else {
                    obtenerUR();
                }

                rol = response.idRol;
                $('#idRolUsuarMod').val(rol);
                if (response.idRol !== null) {
                    obtenerRolMod(response.idRol);
                } else {

                }
                acceso = response.idAcceso;
                $('#idAccesoUsuar').val(acceso);
                if (response.idAcceso != null) {
                    obtenerAccesoUsu(response.idInmueble, acceso);
                } else {
                    populateSelectVacio();
                }

                $('#activoUsu').val(response.activo);
                $("#nombreUsuUsuar").prop('disabled', true);
                $('#loader').modal('toggle');
                $('#ModalUsuarios').modal('show');
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }
    });

}

function obtenerAccesoUsu(inmuebleID, idAcceso)
{

    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerAcceso/" + inmuebleID,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            if (response.length > 0) {

                var acceso;
                acceso = response;
                populateSelectAccesoUsu(acceso, idAcceso);
            } else {
                $('#accesoUsuar option').prop('selected', function () {
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


function populateSelectAccesoUsu(lstAcceso, idAcceso) {

    document.getElementById("accesoUsuar").options.length = 0;
    for (var i = 0; i <= lstAcceso.length - 1; i++) {
        if (i == 0 && lstAcceso.length >= 1) {
            $('#accesoUsuar').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#accesoUsuar').append('<option value="' + lstAcceso[i].idAcceso + '">' + lstAcceso[i].desAcceso + '</option>');
    }
    $('#accesoUsuar').val(idAcceso);
}

function validaDatos() {

    var datosValidos = true;
    var curp = $("#curpModal").val();
    var nombre = $("#nombreUsuar").val();
    var apPaterno = $("#primerApellidoUsuar").val();
    var apMaterno = $("#segundoApellidoUsuar").val();
    var nombreUsu = $("#nombreUsuUsuar").val();
    var contrasena = $("#contrasegnaUsuar").val();
    var contrasenaVerif = $("#contrasegnaVerif").val();
    var rol = $("#rolUsuarMod").val();
    var ur = $("#urUsuar").val();
    var inmueble = $("#inmuebleIDUsuarMod").val();
    var acceso = $("#accesoUsuar").val();
    var activo = $("#activoUsu").val();
    

    //if (nombre === null || nombre.length === 0) {
    /*if ((curp === null || curp.length === 0 || rol === 3 || rol === 4)){
        $("#curpDivModal").addClass("has-error");
        $("#errorCurpModal").text('');
        $("#errorCurpModal").show();
        $("#errorCurpModal").append("Campo obligatorio");
        datosValidos = false;
        
    }*/
    
    if (curpV(curp) && curp.length > 0) {
        $("#curpDivModal").addClass("has-error");
        $("#errorCurpModal").text('');
        $("#errorCurpModal").show();
        $("#errorCurpModal").append("Formato inv&aacute;lido para la CURP");
        datosValidos = false;
    }
    
    if (nombre === null || nombre.trim() === '') {
        $("#nombreUsuarDiv").addClass("has-error");
        $("#errorNombreUsuar").text('');
        $("#errorNombreUsuar").show();
        $("#errorNombreUsuar").append("Campo obligatorio");
        datosValidos = false;
    }

    //if (apPaterno === null || apPaterno.length === 0) {
    if (apPaterno === null || apPaterno.trim() === '') {
        $("#paternoUsuarDiv").addClass("has-error");
        $("#errorPaternoUsuar").text('');
        $("#errorPaternoUsuar").show();
        $("#errorPaternoUsuar").append("Campo obligatorio");
        datosValidos = false;
    }

    //if (nombreUsu === null || nombreUsu.length === 0) {
    if (nombreUsu === null || nombreUsu.trim() === '') {
        $("#nombreUsuUsuarDiv").addClass("has-error");
        $("#errorNombreUsuUsuar").text('');
        $("#errorNombreUsuUsuar").show();
        $("#errorNombreUsuUsuar").append("Campo obligatorio");
        datosValidos = false;
    }


    if (contrasena === null || contrasena.length === 0) {
        $("#contrasegnaUsuarDiv").addClass("has-error");
        $("#errorContrasegnalUsuar").text('');
        $("#errorContrasegnalUsuar").show();
        $("#errorContrasegnalUsuar").append("Campo obligatorio");
        datosValidos = false;
    }


    if (contrasena !== contrasenaVerif) {
        $("#contrasegnaVerifDiv").addClass("has-error");
        $("#errorContrasegnaVerif").text('');
        $("#errorContrasegnaVerif").show();
        $("#errorContrasegnaVerif").append("Las contrase&ntilde;as no coinciden");
        datosValidos = false;
    }

    if (rol === null || rol === "") {
        $("#rolUsuarModDiv").addClass("has-error");
        $("#errorRolUsuar").text('');
        $("#errorRolUsuar").show();
        $("#errorRolUsuar").append("Campo obligatorio");
        datosValidos = false;
    }

    if (inmueble === null || inmueble === "") {
        $("#inmuebleUsuarModDiv").addClass("has-error");
        $("#errorInmuebleUsuar").text('');
        $("#errorInmuebleUsuar").show();
        $("#errorInmuebleUsuar").append("Campo obligatorio");
        datosValidos = false;
    }

    if (acceso == null || acceso == "") {
        $("#accesoUsuarDiv").addClass("has-error");
        $("#errorAccesoUsuar").text('');
        $("#errorAccesoUsuar").show();
        $("#errorAccesoUsuar").append("Campo obligatorio");
        datosValidos = false;
    }

    if (activo == null || activo == "") {
        $("#activoDiv").addClass("has-error");
        $("#errorActivo").text('');
        $("#errorActivo").show();
        $("#errorActivo").append("Campo obligatorio");
        datosValidos = false;
    }

    if (ur == null || ur == "") {
        $("#urUsuarDiv").addClass("has-error");
        $("#errorUrUsuar").text('');
        $("#errorUrUsuar").show();
        $("#errorUrUsuar").append("Campo obligatorio");
        datosValidos = false;
    }

    if (nombre.length > 0 && !validaSoloLetras(nombre)) {
        $("#nombreUsuarDiv").addClass("has-error");
        $("#errorNombreUsuar").text('');
        $("#errorNombreUsuar").show();
        $("#errorNombreUsuar").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }

    if (!validaSoloLetras(apPaterno) && apPaterno.length > 0) {
        $("#paternoUsuarDiv").addClass("has-error");
        $("#errorPaternoUsuar").text('');
        $("#errorPaternoUsuar").show();
        $("#errorPaternoUsuar").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }

    if (!validaSoloLetras(apMaterno) && apMaterno.length > 0) {
        $("#maternoUsuarDiv").addClass("has-error");
        $("#errorMaternoUsuar").text('');
        $("#errorMaternoUsuar").show();
        $("#errorMaternoUsuar").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }

    if (nombreUsu.length > 0 && !validaSoloLetras(nombre)) {
        $("#nombreUsuarDiv").addClass("has-error");
        $("#errorNombreUsuar").text('');
        $("#errorNombreUsuar").show();
        $("#errorNombreUsuar").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }


    console.log('datosValidos es ' + datosValidos);

    return datosValidos;
}


function validaSoloLetras(data) {
    var pattern = new RegExp('^[A-Z\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DC\u00FC\u00D1\u00F1\\s]+$', 'i');
    console.log('valor reg --> ' + pattern.test(data));
    if (!pattern.test(data)) {  //Coincide con el formato general?
        console.log("false");
        return false;
    } else {
        console.log("true");
        return true;
    }//Validado
}

/*function espaciosBlanco(data){
 var pattern = new RegExp ('^$|\s');
 console.log('espacios --> ' + pattern.test(data));
 if (!pattern.test(data)) {  //Coincide con el formato general?
 console.log("false");
 return false;
 } else {
 console.log("true");
 return true;
 }//Validado
 }*/
$(".sinEspacios").keydown(function (event) {

    // Desactiva la barra de espacio
    if (event.keyCode === 32) {
        event.preventDefault();
        $("#contrasegnaUsuarDiv").addClass("has-error");
        $("#errorContrasegnalUsuar").text('');
        $("#errorContrasegnalUsuar").show();
        $("#errorContrasegnalUsuar").append("La contrase&ntilde;a no debe tener espacios en blanco");
    } else {
        $("#contrasegnaUsuarDiv").removeClass("has-error");
        $("#errorContrasegnalUsuar").text('');
        $("#errorContrasegnalUsuar").hide();
    }
});

function cerrarModalCat() {

    $("#idUsuarioCat").val('');
    $("#nombreUsuar").val('');
    $("#primerApellidoUsuar").val('');
    $("#segundoApellidoUsuar").val('');
    $("#nombreUsuUsuar").val('');
    $("#contrasegnaUsuar").val('');
    $("#contrasegnaVerif").val('');
    $("#idRolUsuarMod").val('');
    $("#rolUsuarMod").val('');
    $("#idURUsuar").val('');
    $("#urUsuar").val('');
    $("#inmuebleIDUsuarMod").val('');
    $("#idAccesoUsuar").val('');
    $("#accesoUsuar").val('');
    $("#activoUsu").val('');
    $("#curpModal").val('');
    $("#divErrorPagina").removeClass().hide();
    $("#nombreUsuUsuar").prop('disabled', false);

    $("#passCheckbox").prop('checked', false);
    $('#contrasegnaUsuar').attr('disabled', 'disabled');
    $('#contrasegnaVerif').attr('disabled', 'disabled');

    $("#nombreUsuarDiv").removeClass("has-error");
    $("#errorNombreUsuar").text('');
    $("#errorNombreUsuar").hide();

    $("#paternoUsuarDiv").removeClass("has-error");
    $("#errorPaternoUsuar").text('');
    $("#errorPaternoUsuar").hide();

    $("#maternoUsuarDiv").removeClass("has-error");
    $("#errorMaternoUsuar").text('');
    $("#errorMaternoUsuar").hide();

    $("#nombreUsuUsuarDiv").removeClass("has-error");
    $("#errorNombreUsuUsuar").text('');
    $("#errorNombreUsuUsuar").hide();

    $("#contrasegnaUsuarDiv").removeClass("has-error");
    $("#errorContrasegnalUsuar").text('');
    $("#errorContrasegnalUsuar").hide();

    $("#contrasegnaVerifDiv").removeClass("has-error");
    $("#errorContrasegnaVerif").text('');
    $("#errorContrasegnaVerif").hide();

    $("#rolUsuarModDiv").removeClass("has-error");
    $("#errorRolUsuar").text('');
    $("#errorRolUsuar").hide();

    $("#inmuebleUsuarModDiv").removeClass("has-error");
    $("#errorInmuebleUsuar").text('');
    $("#errorInmuebleUsuar").hide();

    $("#accesoUsuarDiv").removeClass("has-error");
    $("#errorAccesoUsuar").text('');
    $("#errorAccesoUsuar").hide();

    $("#urUsuarDiv").removeClass("has-error");
    $("#errorUrUsuar").text('');
    $("#errorUrUsuar").hide();

    $("#activoDiv").removeClass("has-error");
    $("#errorActivo").text('');
    $("#errorActivo").hide();
    
    $("#curpDivModal").removeClass("has-error");
    $("#errorCurpModal").text('');
    $("#errorCurpModal").hide();

}

function limpiarEtiquetas() {

    $("#nombreUsuarDiv").removeClass("has-error");
    $("#errorNombreUsuar").text('');
    $("#errorNombreUsuar").hide();

    $("#paternoUsuarDiv").removeClass("has-error");
    $("#errorPaternoUsuar").text('');
    $("#errorPaternoUsuar").hide();

    $("#maternoUsuarDiv").removeClass("has-error");
    $("#errorMaternoUsuar").text('');
    $("#errorMaternoUsuar").hide();

    $("#nombreUsuUsuarDiv").removeClass("has-error");
    $("#errorNombreUsuUsuar").text('');
    $("#errorNombreUsuUsuar").hide();

    $("#contrasegnaUsuarDiv").removeClass("has-error");
    $("#errorContrasegnalUsuar").text('');
    $("#errorContrasegnalUsuar").hide();

    $("#contrasegnaVerifDiv").removeClass("has-error");
    $("#errorContrasegnaVerif").text('');
    $("#errorContrasegnaVerif").hide();

    $("#rolUsuarModDiv").removeClass("has-error");
    $("#errorRolUsuar").text('');
    $("#errorRolUsuar").hide();

    $("#inmuebleUsuarModDiv").removeClass("has-error");
    $("#errorInmuebleUsuar").text('');
    $("#errorInmuebleUsuar").hide();

    $("#accesoUsuarDiv").removeClass("has-error");
    $("#errorAccesoUsuar").text('');
    $("#errorAccesoUsuar").hide();

    $("#urUsuarDiv").removeClass("has-error");
    $("#errorUrUsuar").text('');
    $("#errorUrUsuar").hide();

    $("#activoDiv").removeClass("has-error");
    $("#errorActivo").text('');
    $("#errorActivo").hide();
    
    $("#curpDivModal").removeClass("has-error");
    $("#errorCurpModal").text('');
    $("#errorCurpModal").hide();

}

function f_pass() {
    $('#alertActualizarPass').modal('hide');
    $("#contrasegnaUsuar").prop('disabled', false);
    $("#contrasegnaVerif").prop('disabled', false);
    $("#contrasegnaUsuar").val('');
    $("#contrasegnaVerif").val('');
}

function showModal() {
    if ($("#passCheckbox").prop('checked')) {
        $('#alertActualizarPass').modal('show');
    } else {
        $("#contrasegnaUsuar").prop('disabled', true);
        $("#contrasegnaVerif").prop('disabled', true);
        $("#contrasegnaUsuar").val('');
        $("#contrasegnaVerif").val('');
    }
}

function noUpdate() {
    $('#alertActualizarPass').modal('hide');
    $("#passCheckbox").prop('checked', false);
}

function curpV(curp) {
    if (curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9a-z]{1}[0-9]{1})$/i)) {//AAAA######AAAAAAA-##
        return false;
    } else {
        return true;
    }
}

function verificarCurp() {
    
    //if (modo === "nuevo") {
        $.ajax({
            type: "POST",
            cache: false,
            url: baseURI + "/mvc/admin/verificaCurp/" + $("#curpModal").val(),
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            success: function (response) {
                if (response.respuesta !== ' ') {
                    console.log('respuesta' + response.respuesta);
                    alert(response.respuesta);
                    $('#ModalUsuarios').modal('hide');

                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('jqXHR.status:: ' + jqXHR.status);
                console.log('jqXHR.text:: ' + jqXHR.text);
                console.log('textStatus:: ' + textStatus);
            }
        });
    //}
}