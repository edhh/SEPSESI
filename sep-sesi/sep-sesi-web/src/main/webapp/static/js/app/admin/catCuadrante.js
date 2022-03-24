/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    init();
});

function init() {
    obtInmueble();
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

function populateSelectInmueble(lstInmueble) {

    document.getElementById("inmuebleID").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleID').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleID').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }

}

$("#limpiarCatCuadrante").click(function () {
    obtInmueble();
    $('#resultadosResumenTable').bootstrapTable('destroy');
});

$("#buscarCatCuadrante").click(function () {
    var columnas = [
        {
            field: 'inmueble',
            title: 'Inmueble',
            align: 'center'
        }, {
            field: 'cuadrante',
            title: 'Cuadrante / &Aacute;rea',
            align: 'center'
        }, {
            field: 'operate',
            //title: 'Edit',
            align: 'center',
            valign: 'middle',
            clickToSelect: false,
            formatter: addbutton = function addbutton(value, row, index) {
                return '<button class=\'btn btn-primary btn-edit\' iduser="' + row.idCuadrante + '">Modificar</button> ';
            }
        }, {
            field: 'operate',
            //title: 'Edit',
            align: 'center',
            valign: 'middle',
            clickToSelect: false,
            formatter: addbutton = function addbutton(value, row, index) {
                return '<button class=\'btn btn-primary btn-delete\' idCuadrante="' + row.idCuadrante + '">Eliminar</button> ';
            },
        }]
    $('#resultadosResumenTable').bootstrapTable({
        columns: columnas
    });
    $('#resultadosResumenTable').bootstrapTable('showLoading');
    var param = {};

    //param["idInmueble"] =  $('#inmuebleID').val();
    var inmueble = $('#inmuebleID').val();
    if (inmueble === "SELECCIONA") {
        inmueble = 1000;
    }
    param["idInmueble"] = inmueble;
    $('#loader').modal('toggle');
    checkedRows = [];
    $.ajax({
        url: baseURI + "/mvc/catalogos/consultaCuadrantes/",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        data: param,
        cache: false,
        //dataType: "json",
    }).done(function (resumenInstancias) {
        //console.log(resumenInstancias)                
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
});

$('#nuevoCuadrante').click(function () {
    console.log('nuevoCuadrante');
    $('#idCuadranteCat').val('');
    $("#inmuebleMod").prop('disabled', false);
    $('#nombreCuadrante').val('');
    document.getElementById("btnGuardar").disabled = false;
    obtInmuebleMod();
    $('.has-error').removeClass("has-error");
    $("#errorInmuebleMod").text('');
    $("#errorNombreCuadrante").text('');
    $('#ModalCuadrante').modal('show');
});

function obtInmuebleMod()
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
                populateSelectInmuebleMod(inmuebles);
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

function populateSelectInmuebleMod(lstInmueble) {

    document.getElementById("inmuebleMod").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleMod').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleMod').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }

}

function insertaCuadrante() {

    limpiarEtiquetas();
    if (validaDatos()) {
        document.getElementById("btnGuardar").disabled = true;
        //$('#myModal').modal('show');
        //document.forms["formCarga"].submit();
        var vcfData = new FormData($('#formCarga')[0]);
        vcfData.append("inmuebleMod", document.getElementById("inmuebleMod").value);
        $.ajax({
            type: "POST",
            cache: false,
            url: baseURI + "/mvc/catalogos/insertaCuadrante",
            data: vcfData,
            processData: false, contentType: false,
            method: "POST",
            dataType: 'json',
            success: function (reponse) {

                $('#btnGuardar').attr('disabled', 'disabled');

                $("#divExitoPagina").removeClass().addClass("alert alert-success").text('').append("La informaci&oacute;n se registr&oacute; exitosamente.").show();
                setTimeout(function () {
                    location.href = baseURI + '/mvc/admin/catCuadrante';
                }, 3000);
//                
//                    $('#ModalCuadrante').modal('hide');
//                console.log('despues');
                //docenteId = 0;

            },
            error: function (jqXHR, textStatus, errorThrown) {

                alert("Ocurri\u00F3 un error al registrar los datos");
                console.log('jqXHR.status:: ' + jqXHR.status);
                console.log('jqXHR.text:: ' + jqXHR.text);
                console.log('textStatus:: ' + textStatus);
            }
        });

    }
}

$('#resultadosResumenTable').on('click', '.btn-edit', function () {
    var idCuadrante = $(this).attr('iduser');
    //location.href = baseURI + "/mvc/persona/modificaProveedor?idPersona="+idPersona;   
    obtieneCuadrante(idCuadrante);
});


$('#resultadosResumenTable').on('click', '.btn-delete', function () {
    var r = confirm("¿Seguro que deseas eliminar?");
    if (r == true) {
        var idCuadrante = $(this).attr('idCuadrante');
        eliminaCuadrante(idCuadrante);
        modo = 'eliminar';
    }

});


function obtieneCuadrante(idCuadrante) {
    //Obtiene el usuario de sesión
    var inmueble;
    $('.has-error').removeClass("has-error");
    $("#errorInmuebleMod").text('');
    $("#errorNombreCuadrante").text('');
    $('#loader').modal('toggle');
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerCuadrante10/" + idCuadrante,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            if (response[0].idCuadranteArea !== '') {

                console.log('idCuadranteArea' + response[0].idCuadranteArea);
                inmueble = response[0].idInmueble;
                console.log('inmueble ' + inmueble);
                if (inmueble != null) {
                    obtInmuebleMod2(inmueble);
                } else {
                    obtInmuebleMod();
                }
                $('#idCuadranteCat').val(response[0].idCuadranteArea);
                $('#nombreCuadrante').val(response[0].cuadranteArea);
                $('#loader').modal('toggle');
                $('#ModalCuadrante').modal('show');
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }
    });

}

function obtInmuebleMod2(idInmueble)
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
                populateSelectInmuebleMod2(inmuebles, idInmueble);
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


function populateSelectInmuebleMod2(lstInmueble, idInmueble) {

    document.getElementById("inmuebleMod").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleMod').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleMod').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }
    $("#inmuebleMod").prop('disabled', true);
    $('#inmuebleMod').val(idInmueble);
}

function validaDatos() {

    var datosValidos = true;
    var inmueble = $("#inmuebleMod").val();
    var cuadrante = $("#nombreCuadrante").val();

    if (inmueble === "SELECCIONA") {
        $("#inmuebleModDiv").addClass("has-error");
        $("#errorInmuebleMod").text('');
        $("#errorInmuebleMod").show();
        $("#errorInmuebleMod").append("Campo obligatorio");
        datosValidos = false;
    }

    if (cuadrante === null || cuadrante.length === 0) {
        $("#nombreCuadranteDiv").addClass("has-error");
        $("#errorNombreCuadrante").text('');
        $("#errorNombreCuadrante").show();
        $("#errorNombreCuadrante").append("Campo obligatorio");
        datosValidos = false;
    }

    console.log('datosValidos es ' + datosValidos);

    return datosValidos;
}

function limpiarEtiquetas() {

    $("#inmuebleModDiv").removeClass("has-error");
    $("#errorInmuebleMod").text('');
    $("#errorInmuebleMod").hide();

    $("#nombreCuadranteDiv").removeClass("has-error");
    $("#errorNombreCuadrante").text('');
    $("#errorNombreCuadrante").hide();
}



function eliminaCuadrante(idCuadrante) {
    console.log("Eliminando cuadrante");
    var search = {};
    search["idCuadrante"] = idCuadrante;
    console.log(idCuadrante);
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catalogos/eliminaCuadranteCat",
        data: search,
        method: "POST",
        dataType: 'json',
        success: function (response) {
            console.log("SUCCESS");
            $("#divExitoPaginaCuad").removeClass().addClass("alert alert-success").text('').append("Se ha eliminado el registro").show();
            setTimeout(function () {
                location.href = baseURI + '/mvc/admin/catCuadrante';
            }, 3000);

        },
        error: function (jqXHR, textStatus, errorThrown) {
            $("#divErrorPaginaCuad").removeClass().addClass("alert alert-warning").text('').append("Ocurri&#243; un error al eliminar el registro").show();
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }
    });

}
