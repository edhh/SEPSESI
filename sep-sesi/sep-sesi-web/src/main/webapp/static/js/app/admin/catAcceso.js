var checkedRows = [];
var modo;


$(document).ready(function () {
    obtInmueble();
});

$("#limpiarCatAcceso").click(function () {
    $('#inmuebleCatAcceso').val('');
    $('#idInmuebleCatAcceso').val('');
    checkedRows = [];
    $('#resultadosAccesoTable').bootstrapTable('destroy');
});


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

    document.getElementById("inmuebleCatAcceso").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleCatAcceso').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleCatAcceso').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }

}

function asignarInmueble() {
    var idInmueble = document.getElementById("inmuebleCatAcceso").value;
    $('#idInmuebleCatAcceso').val(idInmueble);
    console.log('id Inmueble  ' + idInmueble);

}


$("#buscarCatAcceso").click(function () {

    var columnas = [
        {
            field: 'denominacion',
            title: 'Inmueble',
            align: 'center'
        }, {
            field: 'desAcceso',
            title: 'Acceso',
            align: 'center'
        }, {
            field: 'operate',
            //title: 'Edit',
            align: 'center',
            valign: 'middle',
            clickToSelect: false,
            formatter: addbutton = function addbutton(value, row, index) {
                return '<button class=\'btn btn-primary btn-edit\' idAcceso="' + row.idAcceso + '">Modificar</button> ';
            }
        }, {
            field: 'operate',
            //title: 'Edit',
            align: 'center',
            valign: 'middle',
            clickToSelect: false,
            formatter: addbutton = function addbutton(value, row, index) {
                return '<button class=\'btn btn-primary btn-delete\' idAcceso="' + row.idAcceso + '">Eliminar</button> ';
            },
        }]

    $('#resultadosAccesoTable').bootstrapTable({
        columns: columnas
    });

    $('#resultadosAccesoTable').bootstrapTable('showLoading');
    var param = {};
    param["idInmueble"] = $('#idInmuebleCatAcceso').val();
    console.log(param);

    $('#loader').modal('toggle');
    checkedRows = [];
    $.ajax({
        url: baseURI + "/mvc/catAcceso/obtenerCatAcceso",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        data: param,
        //dataType: "json",
        cache: false,
    }).done(function (resumenInstancias) {
        console.log(resumenInstancias);
        $('#resultadosAccesoTable').bootstrapTable('destroy');
        $('#resultadosAccesoTable').bootstrapTable({
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


$('#nuevoAcceso').click(function () {
    obtenerInmuebleMod();
    $("#denominacionInmAcc").prop('disabled', false);
    $('#ModalAcceso').modal('show');
});

function obtenerInmuebleMod(idInmueble)
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

    document.getElementById("denominacionInmAcc").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#denominacionInmAcc').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#denominacionInmAcc').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }
   
    $('#denominacionInmAcc').val(idInmueble);
}

function asignarInmuebleMod() {
    var idInmueble = document.getElementById("denominacionInmAcc").value;
    $('#idInmuebleCat').val(idInmueble);
    console.log('id Inmueble  ' + idInmueble);

}


function insertaAccesoCat() {

    var idAcceso = $('#idAccesoCat').val();
    var idInmueble = $('#denominacionInmAcc').val();
    var acceso = $('#accesoCat').val();
    limpiarEtiquetas();

    if (validaDatos()) {
        $('#btnGuardarAcceso').attr('disabled', 'disabled');

        var dataAcceso = {};

        dataAcceso.idAcceso = idAcceso;
        dataAcceso.idInmueble = idInmueble;
        dataAcceso.desAcceso = acceso;

        var vURL = baseURI + '/mvc/catAcceso/crearAccesoCat';

        $.ajax({
            type: "POST",
            cache: false,
            url: vURL,
            contentType: 'application/json;  charset=utf-8',
            data: JSON.stringify(dataAcceso),
            dataType: 'json',
            success: function (response) {
                console.log(response);
                $('#btnGuardarAcceso').attr('disabled', 'disabled');
                //var respuesta = response.msg;

                $("#divExitoPagina").removeClass().addClass("alert alert-success").text('').append("La informaci&oacute;n se registr&oacute; exitosamente.").show();

                setTimeout(function () {
                    location.href = baseURI + '/mvc/admin/catAcceso';
                }, 3000);
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


function validaDatos() {

    var datosValidos = true;
    var idInmueble = $('#denominacionInmAcc').val();
    var acceso = $('#accesoCat').val();

    if (idInmueble === null || idInmueble === "") {
        $("#denominacionInmAccesDiv").addClass("has-error");
        $("#errorDenominacion").text('');
        $("#errorDenominacion").show();
        $("#errorDenominacion").append("Campo obligatorio");
        datosValidos = false;
    }

    if (acceso === null || acceso.trim() === '') {
        $("#accesoCatDiv").addClass("has-error");
        $("#errorAccesoCat").text('');
        $("#errorAccesoCat").show();
        $("#errorAccesoCat").append("Campo obligatorio");
        datosValidos = false;
    }

    console.log('datosValidos es ' + datosValidos);

    return datosValidos;

}

$('#resultadosAccesoTable').on('click', '.btn-edit', function () {
    var idAcceso = $(this).attr('idAcceso');
     $("#denominacionInmAcc").prop('disabled', true);
    obtieneAcceso(idAcceso);
    modo = 'editar';
});


$('#resultadosAccesoTable').on('click', '.btn-delete', function () {
    var r = confirm("¿Seguro que deseas eliminar?");
    if (r == true) {
        var idAcceso = $(this).attr('idAcceso');
        eliminaAcceso(idAcceso);
        modo = 'eliminar';
    }
});

function obtieneAcceso(idAcceso) {

    $('.has-error').removeClass("has-error");
    $("#errorDenominacion").text('');
    $("#errorAccesoCat").text('');

    var inmueble;

    $('#loader').modal('toggle');
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catAcceso/obtenerAcceso/" + idAcceso,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            console.log(response);
            if (response.idAcceso !== '') {
                $('#idAccesoCat').val(response.idAcceso);

                inmueble = response.idInmueble;
                if (response.idInmueble != null) {
                    obtenerInmuebleMod(inmueble);
                }

                $('#accesoCat').val(response.desAcceso);

                $('#loader').modal('toggle');
                $('#ModalAcceso').modal('show');
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }
    });

}

function cerrarModalCat() {

    $('#idAccesoCat').val('');
    $('#idInmuebleCat').val('');
    $('#denominacionInmAcc').val('');
    $('#accesoCat').val('');

    $("#denominacionInmAccesDiv").removeClass("has-error");
    $("#errorDenominacion").text('');
    $("#errorDenominacion").hide();

    $("#accesoCatDiv").removeClass("has-error");
    $("#errorAccesoCat").text('');
    $("#errorAccesoCat").hide();

}

function limpiarEtiquetas() {

    $("#denominacionInmAccesDiv").removeClass("has-error");
    $("#errorDenominacion").text('');
    $("#errorDenominacion").hide();

    $("#accesoCatDiv").removeClass("has-error");
    $("#errorAccesoCat").text('');
    $("#errorAccesoCat").hide();

}


function eliminaAcceso(idAcceso) {
    console.log("Eliminando acceso");
    var search = {};
    search["idAcceso"] = idAcceso;
    console.log(idAcceso);
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catAcceso/eliminarAccesoCat",
        data: search,
        method: "POST",
        dataType: 'json',
        success: function (response) {
            console.log("SUCCESS");
            $("#divExitoPaginaAcces").removeClass().addClass("alert alert-success").text('').append("Se ha eliminado el registro").show();
            setTimeout(function () {
                location.href = baseURI + '/mvc/admin/catAcceso';
            }, 3000);

        },
        error: function (jqXHR, textStatus, errorThrown) {
            $("#divErrorPaginaAcces").removeClass().addClass("alert alert-warning").text('').append("Ocurri&#243; un error al eliminar el registro").show();
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }
    });

}
