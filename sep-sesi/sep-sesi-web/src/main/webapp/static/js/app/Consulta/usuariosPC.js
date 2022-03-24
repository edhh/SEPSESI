/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $('#fecha').datepicker();
});
$("#foto").click(function () {
    $("#vista").attr("src", "bety.jpg")
});

$("#limpiar").click(function () {
    $('#curp').val('');
    obtenerUR();
    //obtInmueble();
    obtenerTipoPersona();
    $("#errorCurp").text('');
    $("#errorCurp").hide();
    $("#curpDiv").removeClass("has-error");
    $("#errorRol").text('');
    $("#errorRol").hide();
    $("#rolDiv").removeClass("has-error");
    $('#resultadosResumenTable').bootstrapTable('destroy');
});

function addInput(value, row, index) {
    return  '<input class=\'chk\' type=\'checkbox\' value="' + row.idPersona + '" id="chk_' + row.idPersona + '">';
}

$("#buscar").click(function () {
    //object.configModule.standby.show();
    $("#errorCurp").text('');
    $("#errorCurp").hide();
    $("#curpDiv").removeClass("has-error");
    $("#errorRol").text('');
    $("#errorRol").hide();
    $("#rolDiv").removeClass("has-error");
    if (validaDatos()) {
    var columnas = [
        {
            field: 'tipoPersona',
            title: 'Tipo de persona',
            align: 'center'
        },
        {
            field: 'curp',
            title: 'CURP',
            align: 'center'
        }, {
            field: 'nombre',
            title: 'Nombre',
            align: 'center'
        }, {
            field: 'apellido1',
            title: 'Primer Apellido',
            align: 'center',
        }, {
            field: 'apellido2',
            title: 'Segundo Apellido',
            align: 'center'
        }, {
            field: 'denominacion',
            title: 'Inmueble',
            align: 'center',
        }, {
            field: 'unidadResponsable',
            title: 'UR',
            align: 'center'
        },
        {
            field: 'puesto',
            title: 'Puesto',
            align: 'center'
        },{
            field: 'tipoSangre',
            title: 'Tipo de sangre',
            align: 'center'
        },{
            field: 'enfermedad',
            title: 'Enfermedad',
            align: 'center'
        },{
            field: 'alergias',
            title: 'Alergias',
            align: 'center'
        },{
            field: 'telEmergencia',
            title: 'Tel&eacute;fono de emergencia',
            align: 'center'
        },{
            field: 'estatusDes',
            title: 'Estatus',
            align: 'center'
        }]
    $('#resultadosResumenTable').bootstrapTable({
        columns: columnas
    });
    $('#resultadosResumenTable').bootstrapTable('showLoading');
    var idUR = $('#ur').val();
    if (idUR === "SELECCIONA") {
        idUR = '';
    }
    var idINMUEBLE = $('#inmuebleID').val();
    if (idINMUEBLE === "SELECCIONA") {
        idINMUEBLE = '';
    }
    var param = {};
    param["idUr"] = idUR;
    param["curp"] = $('#curp').val();
    param["idInmueble"] = idINMUEBLE;
    param["idTipoPersona"] = $('#rol').val();
    $('#loader').modal('toggle');
    $.ajax({
        url: baseURI + "/mvc/consulta/consultaUsuariosPC",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        data: param,
        //dataType: "json",
        cache: false,
    }).done(function (resumenInstancias) {
        console.log(resumenInstancias)
        $('#resultadosResumenTable').bootstrapTable('destroy');
        $('#resultadosResumenTable').bootstrapTable({
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
    }
});

$(function () {
    init();
});

function init() {
    //obtenerTipoPersona();       
    //obtInmueble();
    obtenerUR();
    usuarioRol();
    //obtInmueble();
    obtenerTipoPersona();
}

function usuarioRol() {
    var vUrl = baseURI + '/mvc/seguridad/menu/obtenerUsuario';
    conectaPost(vUrl, "", resUsuario);
}

function resUsuario(data) {
    var rol_usuario = data.idRol
    if (rol_usuario == 2) {
        $("#ur").prop('disabled', true);
    }
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
            console.log(response);
            console.log(response.length);
            //drawTableGeneric(response);
            if (response.length > 0) {
                var inmuebles;
                inmuebles = response;
                populateSelectInmueble(inmuebles);
            } else {
                console.log('else');
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

function obtRoles()
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerRol",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            console.log(response);
            console.log(response.length);
            //drawTableGeneric(response);
            if (response.length > 0) {
                var roles;
                roles = response;
                populateSelectRoles(roles);
            } else {
                console.log('else');
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
            console.log(response);
            console.log(response.length);
            //drawTableGeneric(response);
            if (response.length > 0) {
                console.log('if');
                console.log(response);
                var UR;
                UR = response;
                populateSelectUR(UR);
                usuarioRol();
            } else {
                console.log('else');
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

function obtenerTipoPersona()
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerTipoPersona",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            console.log(response);
            console.log(response.length);
            //drawTableGeneric(response);
            if (response.length > 0) {
                var TipoPersona;
                TipoPersona = response;
                populateSelectTipoPersona(TipoPersona);
            } else {
                console.log('else');
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
    console.log("POPULATING SELECT INMUEBLE");
    console.log(lstInmueble);
    document.getElementById("inmuebleID").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleID').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleID').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }
}

function populateSelectRoles(lstRoles) {
    console.log("POPULATING SELECT ROLES");
    console.log(lstRoles);
    document.getElementById("rol").options.length = 0;
    for (var i = 0; i <= lstRoles.length - 1; i++) {
        if (i == 0 && lstRoles.length >= 1) {
            $('#rol').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#rol').append('<option value="' + lstRoles[i].idRol + '">' + lstRoles[i].descRol + '</option>');
    }
}

function populateSelectUR(lstUR) {
    console.log("POPULATING SELECT UR");
    console.log(lstUR);
    document.getElementById("ur").options.length = 0;
    for (var i = 0; i <= lstUR.length - 1; i++) {
        if (i == 0 && lstUR.length >= 1) {
            $('#ur').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#ur').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
    }

}

function populateSelectTipoPersona(lstTipoPersona) {
    console.log("POPULATING SELECT TIPO PERSONA");
    console.log('lstTipoPersona.length'+lstTipoPersona.length);
    document.getElementById("rol").options.length = 0;
    for (var i = 0; i <= 1; i++) {
        if (i == 0 && lstTipoPersona.length >= 1) {
            $('#rol').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#rol').append('<option value="' + lstTipoPersona[i].idTipoPersona + '">' + lstTipoPersona[i].tipoPersona + '</option>');
    }
}

$('#resultadosResumenTable').on('click', '.btn-edit', function () {
    var idPersona = $(this).attr('iduser');
    location.href = baseURI + "/mvc/persona/modificaEmpleado?idPersona=" + idPersona;
});


$("#gafete").click(function () {
    var seleccionados = [];
    $("input:checkbox[class=chk]:checked").each(function () {
        //seleccionados.push( $(this).attr("id") );                    
        seleccionados.push($(this).val());
    });

    if (seleccionados.length == 0) {
        alert("Seleccione al menos un registro");
        return false;
    }
    var vUrl = baseURI + "/mvc/persona/imprimirGafete";
    conectaPost(vUrl, seleccionados, resultadoImpresion);

});

function resultadoImpresion(data) {
    $('#loader').modal('toggle');
}

$(function () {
    $("#exportar").click(function (e) {
        if (validaDatos()) {
        var idUR = $('#ur').val();
        if (idUR === "SELECCIONA") {
            idUR = '';
        }
        var idINMUEBLE = $('#inmuebleID').val();
        if (idINMUEBLE === "SELECCIONA") {
            idINMUEBLE = '';
        }
        var tipoPersona = $('#rol').val();
        var param = {};
        param["idUr"] = idUR;
        param["curp"] = $('#curp').val();
        param["idInmueble"] = idINMUEBLE;
        param["idTipoPersona"] = $('#rol').val();
        $.ajax({
        url: baseURI + "/mvc/consulta/consultaUsuariosPC",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        data: param,
        //dataType: "json",
        success: function (response) {
                    if (response.length > 0) {
                        window.document.location.href = baseURI + '/mvc/jasper/repUsuariosPC?idUr=' + idUR + '&curp=' + $('#curp').val() + '&idInmueble=' + idINMUEBLE
        + '&idTipoPersona=' + $('#rol').val();
        
                    }else {
                        alert("No es posible realizar la descarga ya que no se encontraron registros");
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#mensajesError').html('<div class="alert alert-warning">No se encontraron registros</div>').show();
                    console.log('jqXHR.status:: ' + jqXHR.status);
                    console.log('jqXHR.text:: ' + jqXHR.text);
                    console.log('textStatus:: ' + textStatus);
                }
        });
        console.log('tipoPersona ' + tipoPersona);
        
    }
}
);
});

function validaDatos() {

    var datosValidos = true;
    var idTipoPersona = $('#rol').val();
    var curp = $('#curp').val();

    if (curpV(curp) && curp.length > 0) {
        $("#curpDiv").addClass("has-error");
        $("#errorCurp").text('');
        $("#errorCurp").show();
        $("#errorCurp").append("Formato inv&aacute;lido para la CURP");
        datosValidos = false;
    }

    if (idTipoPersona === "SELECCIONA") {
        $("#rolDiv").addClass("has-error");
        $("#errorRol").text('');
        $("#errorRol").show();
        $("#errorRol").append("Campo obligatorio");
        datosValidos = false;
    }

    console.log('datosVlidos ess ' + datosValidos);

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

function usuarioRol() {
    var vUrl = baseURI + '/mvc/seguridad/menu/obtenerUsuario';
    conectaPost(vUrl, "", resUsuario);
}

function resUsuario(data) {
    var rol_usuario = data.idRol
    var idInmueble = data.idInmueble;
    if (rol_usuario == 5) {
        $("#inmuebleID").prop('disabled', true);
        //$('#inmuebleID').val(idInmueble);
        obtInmuebleMod(idInmueble);
    }
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
            console.log(response);
            console.log(response.length);
            //drawTableGeneric(response);
            if (response.length > 0) {
                var inmuebles;
                inmuebles = response;
                populateSelectInmuebleMod(inmuebles, idInmueble);
            } else {
                console.log('else');
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
    console.log("POPULATING SELECT INMUEBLE");
    console.log(lstInmueble);
    document.getElementById("inmuebleID").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleID').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleID').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }
    $('#inmuebleID').val(idInmueble);
}