
var checkedRows = [];
var modo;


$(document).ready(function () {
    obtInmueble();
});


$("#limpiarCatInmueble").click(function () {
    $('#inmuebleCatInmueb').val('');
    $('#idInmuebleCatInmue').val('');
    checkedRows = [];
    $('#resultadosInmuebleTable').bootstrapTable('destroy');
});


$("#buscarCatInmueble").click(function () {

    var columnas = [
        {
            field: 'denominacion',
            title: 'Denominaci&oacute;n',
            align: 'center'
        }, {
            field: 'entidad',
            title: 'Entidad',
            align: 'center'
        }, {
            field: 'alcaldiaMun',
            title: 'Alcald&iacute;a o Municipio',
            align: 'center'
        }, {
            field: 'colonia',
            title: 'Colonia',
            align: 'center'
        }, {
            field: 'calle',
            title: 'Calle',
            align: 'center'
        }, {
            field: 'numero',
            title: 'N&uacute;mero',
            align: 'center'
        }, {
            field: 'operate',
            //title: 'Edit',
            align: 'center',
            valign: 'middle',
            clickToSelect: false,
            formatter: addbutton = function addbutton(value, row, index) {
                return '<button class=\'btn btn-primary btn-edit\' idInmueble="' + row.idInmueble + '">Modificar</button> ';
            }
        }]

    $('#resultadosInmuebleTable').bootstrapTable({
        columns: columnas
    });

    $('#resultadosInmuebleTable').bootstrapTable('showLoading');
    var param = {};
    param["idInmueble"] = $('#idInmuebleCatInmue').val();
    console.log(param);

    $('#loader').modal('toggle');
    checkedRows = [];
    $.ajax({
        url: baseURI + "/mvc/inmueble/obtenerCatInmueble",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        data: param,
        //dataType: "json",
        cache: false,
    }).done(function (resumenInstancias) {
        console.log(resumenInstancias);
        $('#resultadosInmuebleTable').bootstrapTable('destroy');
        $('#resultadosInmuebleTable').bootstrapTable({
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

    document.getElementById("inmuebleCatInmueb").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleCatInmueb').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleCatInmueb').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }

}

function asignarInmueble() {
    var idInmueble = document.getElementById("inmuebleCatInmueb").value;
    $('#idInmuebleCatInmue').val(idInmueble);
    console.log('id Inmueble  ' + idInmueble);

}


$('#nuevoInmueble').click(function () {
    obtenerEntidad();

    $('#ModalInmuebles').modal('show');
});

function obtenerEntidad(idEntidad)
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerEntidad",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            if (response.length > 0) {

                var entidad;
                entidad = response;
                populateSelectEntidad(entidad, idEntidad);
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

function populateSelectEntidad(lstEntidad, idEntidad) {

    document.getElementById("entidadFed").options.length = 0;
    for (var i = 0; i <= lstEntidad.length - 1; i++) {
        if (i == 0 && lstEntidad.length >= 1) {
            $('#entidadFed').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#entidadFed').append('<option value="' + lstEntidad[i].idEntidad + '">' + lstEntidad[i].entidad + '</option>');
    }
    $('#entidadFed').val(idEntidad);
}


function obtenerAlcaldiaMun(idEntidad, idAlcaldiaMun)
{
//$("#obtenerAlcaldiaMun").change(function () {    
//$("#entidadFed").change(function () {    

    var entidad = $("#entidadFed").val();

    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerAlcaldiaMun/" + entidad,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            if (response.length > 0) {

                var alcaldia;
                alcaldia = response;
                populateSelectAlcaldiaMun(alcaldia, idAlcaldiaMun);
            } else {
                populateSelectVacioAlc();
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

function populateSelectAlcaldiaMun(lstAlcaldia, idAlcaldiaMun) {

    document.getElementById("alcaldiaInm").options.length = 0;
    for (var i = 0; i <= lstAlcaldia.length - 1; i++) {
        if (i == 0 && lstAlcaldia.length >= 1) {
            $('#alcaldiaInm').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#alcaldiaInm').append('<option value="' + lstAlcaldia[i].idAlcaldiaMun + '">' + lstAlcaldia[i].alcaldiaMun + '</option>');
    }
    $('#alcaldiaInm').val(idAlcaldiaMun);
}

function populateSelectVacioAlc() {

    document.getElementById("alcaldiaInm").options.length = 0;
    $('#alcaldiaInm').append('<option>' + 'SELECCIONA' + '</option>');

}

//function asignaAlcaldia() {
//    var idAlcaldia = document.getElementById("alcaldiaInm").value;
//    $('#idAlcaldiaMun').val(idAlcaldia);
//    console.log('id Colonia valor es ' + idAlcaldia);
//
//}


function obtenerColonia(idColonia)
//$("#coloniaInm").change(function () 
{

    var entidad = $("#entidadFed").val();
    var alcaldia = $("#alcaldiaInm").val();

    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerColonia/" + entidad + "/" + alcaldia,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            console.log(response);
            if (response.length > 0) {

                var colonia;
                colonia = response;
                populateSelectColonia(colonia, idColonia);
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

function populateSelectColonia(lstColonia, idColonia) {

    document.getElementById("coloniaInm").options.length = 0;
    for (var i = 0; i <= lstColonia.length - 1; i++) {
        if (i == 0 && lstColonia.length >= 1) {
            $('#coloniaInm').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#coloniaInm').append('<option value="' + lstColonia[i].idColonia + '">' + lstColonia[i].colonia + '</option>');
    }
    $('#coloniaInm').val(idColonia);
}

function populateSelectVacio() {

    document.getElementById("coloniaInm").options.length = 0;
    $('#coloniaInm').append('<option>' + 'SELECCIONA' + '</option>');

}

function asignaColonia() {
    var idCol = document.getElementById("coloniaInm").value;
    $('#idColonia').val(idCol);
    console.log('id Colonia valor es ' + idCol);

}


function insertaInmuebleCat() {

    var idInmueble = $('#idInmuebleCat').val();
    var denominacion = $('#denominacionInm').val();
    var idEntidad = $('#entidadFed').val();
    var idAlcaldiaMun = $('#alcaldiaInm').val();
    var idColonia = $('#idColonia').val();
    var calle = $('#calleInm').val();
    var numero = $('#numeroInm').val();
    var cp = $('#cpInm').val();
    var claveInm = $('#claveInm').val();
    var noAccesos = $('#numeroAccInm').val();
    var estatus = $('#estatusInm').val();
    limpiarEtiquetas();

    if (validaDatos()) {
        $('#btnGuardarInmueble').attr('disabled', 'disabled');

        var dataInmueble = {};

        dataInmueble.idInmueble = idInmueble;
        dataInmueble.denominacion = denominacion;
        dataInmueble.idEntidad = idEntidad;
        dataInmueble.idAlcaldiaMun = idAlcaldiaMun;
        dataInmueble.idColonia = idColonia;
        dataInmueble.calle = calle;
        dataInmueble.numero = numero;
        dataInmueble.cp = cp;
        dataInmueble.claveInmueble = claveInm;
        dataInmueble.numAccesos = noAccesos;
        dataInmueble.estatus = estatus;

        var vURL = baseURI + '/mvc/inmueble/crearInmuebleCat';

        $.ajax({
            type: "POST",
            cache: false,
            url: vURL,
            contentType: 'application/json;  charset=utf-8',
            data: JSON.stringify(dataInmueble),
            dataType: 'json',
            success: function (response) {
                console.log(response);
                $('#btnGuardarInmueble').attr('disabled', 'disabled');
                //var respuesta = response.msg;

                $("#divExitoPagina").removeClass().addClass("alert alert-success").text('').append("La informaci&oacute;n se registr&oacute; exitosamente.").show();

                setTimeout(function () {
                    location.href = baseURI + '/mvc/admin/catInmuebles';
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

$('#resultadosInmuebleTable').on('click', '.btn-edit', function () {
    var idInmueble = $(this).attr('idInmueble');
    obtieneInmueble(idInmueble);
    modo = 'editar';
});


function obtieneInmueble(idInmueble) {
    $('.has-error').removeClass("has-error");
    $("#errorDenominacion").text('');
    $("#errorEntidad").text('');
    $("#errorAlcaldia").text('');
    $("#errorColonia").text('');
    $("#errorCalle").text('');
    $("#errorNumero").text('');
    $("#errorCP").text('');
    $("#errorClaveInm").text('');
    $("#errorNumeroAcc").text('');
    $("#errorEstatusInm").text('');


    var entidad;
    var alcaldia;
    var colonia;

    $('#loader').modal('toggle');
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/inmueble/obtieneInmueble/" + idInmueble,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            console.log(response);
            if (response.idInmueble !== '') {
                $('#idInmuebleCat').val(response.idInmueble);
                $('#denominacionInm').val(response.denominacion);


                entidad = response.idEntidad;

                if (response.idEntidad != null) {
                    obtenerEntidad(entidad);
                } else {

                }

                $('#alcaldiaInm').val(response.idAlcaldiaMun);
                alcaldia = response.idAlcaldiaMun;
                console.log(alcaldia);
                if (response.idAlcaldiaMun !== null) {
                    obtenerAlcaldiaMunInm(response.idEntidad, alcaldia);
                } else {
                    populateSelectVacioAlc();
                }

                $('#coloniaInm').val(response.idColonia);
                colonia = response.idColonia;
                if (response.idColonia != null) {
                    obtenerColoniaInm(response.idEntidad, response.idAlcaldiaMun, colonia);
                } else {
                    populateSelectVacio();
                }

                $('#calleInm').val(response.calle);
                $('#numeroInm').val(response.numero);
                $('#cpInm').val(response.cp);
                $('#claveInm').val(response.claveInmueble);
                $('#numeroAccInm').val(response.numAccesos);
                $('#estatusInm').val(response.estatus);

                $('#loader').modal('toggle');
                $('#ModalInmuebles').modal('show');
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }
    });

}

function obtenerAlcaldiaMunInm(entidadID, idAlcaldiaMun)
{

    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerAlcaldiaMun/" + entidadID,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            if (response.length > 0) {

                var alcaldia;
                alcaldia = response;
                populateSelectAlcaldiaMunInm(alcaldia, idAlcaldiaMun);
            } else {
                populateSelectVacioAlc();
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

function populateSelectAlcaldiaMunInm(lstAlcaldia, idAlcaldiaMun) {

    document.getElementById("alcaldiaInm").options.length = 0;
    for (var i = 0; i <= lstAlcaldia.length - 1; i++) {
        if (i == 0 && lstAlcaldia.length >= 1) {
            $('#alcaldiaInm').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#alcaldiaInm').append('<option value="' + lstAlcaldia[i].idAlcaldiaMun + '">' + lstAlcaldia[i].alcaldiaMun + '</option>');
    }
    $('#alcaldiaInm').val(idAlcaldiaMun);
}

function obtenerColoniaInm(entidadID, alcaldiaID, idColonia)
//$("#coloniaInm").change(function () 
{


    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerColonia/" + entidadID + "/" + alcaldiaID,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            console.log(response);
            if (response.length > 0) {

                var colonia;
                colonia = response;
                populateSelectColoniaInm(colonia, idColonia);
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

function populateSelectColoniaInm(lstColonia, idColonia) {

    document.getElementById("coloniaInm").options.length = 0;
    for (var i = 0; i <= lstColonia.length - 1; i++) {
        if (i == 0 && lstColonia.length >= 1) {
            $('#coloniaInm').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#coloniaInm').append('<option value="' + lstColonia[i].idColonia + '">' + lstColonia[i].colonia + '</option>');
    }
    $('#coloniaInm').val(idColonia);
}

function validaDatos() {

    var datosValidos = true;
    var denominacion = $('#denominacionInm').val();
    var idEntidad = $('#entidadFed').val();
    var idAlcaldiaMun = $('#alcaldiaInm').val();
    var idColonia = $('#coloniaInm').val();
    var calle = $('#calleInm').val();
    var numero = $('#numeroInm').val();
    var cp = $('#cpInm').val();
    var claveInm = $('#claveInm').val();
    var noAccesos = $('#numeroAccInm').val();
    var estatus = $('#estatusInm').val();

    if (denominacion === null || denominacion.trim() === '') {
        $("#denominacionDiv").addClass("has-error");
        $("#errorDenominacion").text('');
        $("#errorDenominacion").show();
        $("#errorDenominacion").append("Campo obligatorio");
        datosValidos = false;
    }

    if (idEntidad === null || idEntidad === "") {
        $("#entidadFedDiv").addClass("has-error");
        $("#errorEntidad").text('');
        $("#errorEntidad").show();
        $("#errorEntidad").append("Campo obligatorio");
        datosValidos = false;
    }

    if (idAlcaldiaMun === null || idAlcaldiaMun === "") {
        $("#alcaldiaDiv").addClass("has-error");
        $("#errorAlcaldia").text('');
        $("#errorAlcaldia").show();
        $("#errorAlcaldia").append("Campo obligatorio");
        datosValidos = false;
    }

    if (idColonia === null || idColonia === "") {
        $("#coloniaDiv").addClass("has-error");
        $("#errorColonia").text('');
        $("#errorColonia").show();
        $("#errorColonia").append("Campo obligatorio");
        datosValidos = false;
    }

    if (calle === null || calle.trim() === '') {
        $("#calleInmDiv").addClass("has-error");
        $("#errorCalle").text('');
        $("#errorCalle").show();
        $("#errorCalle").append("Campo obligatorio");
        datosValidos = false;
    }

    if (numero === null || numero.trim() === '') {
        $("#numeroInmDiv").addClass("has-error");
        $("#errorNumero").text('');
        $("#errorNumero").show();
        $("#errorNumero").append("Campo obligatorio");
        datosValidos = false;
    }

    if (cp === null || cp.trim() === '') {
        $("#cpInmDiv").addClass("has-error");
        $("#errorCP").text('');
        $("#errorCP").show();
        $("#errorCP").append("Campo obligatorio");
        datosValidos = false;
    }

    if (validaSoloNumeros(cp) && cp.length > 0) {
        $("#cpInmDiv").addClass("has-error");
        $("#errorCP").text('');
        $("#errorCP").show();
        $("#errorCP").append("&Uacute;nicamente debe contener caracteres num&eacute;ricos");
        datosValidos = false;
    }

    if (estatus === null || estatus === "") {
        $("#estatusInmDiv").addClass("has-error");
        $("#errorEstatusInm").text('');
        $("#errorEstatusInm").show();
        $("#errorEstatusInm").append("Campo obligatorio");
        datosValidos = false;
    }

    console.log('datosValidos es ' + datosValidos);

    return datosValidos;
}

function validaSoloNumeros(data) {
    var re = /^[0-9]+$/;
    if (data.match(re))  //Coincide con el formato general?
        return false;
    else
        return true; //Validado
}

function cerrarModalCat() {

    $('#denominacionInm').val('');
    $('#entidadFed').val('');
    $('#alcaldiaInm').val('');
    $('#idColonia').val('');
    $('#calleInm').val('');
    $('#numeroInm').val('');
    $('#cpInm').val('');
    $('#claveInm').val('');
    $('#numeroAccInm').val('');
    $('#estatusInm').val('');

    $("#denominacionDiv").removeClass("has-error");
    $("#errorDenominacion").text('');
    $("#errorDenominacion").hide();

    $("#entidadFedDiv").removeClass("has-error");
    $("#errorEntidad").text('');
    $("#errorEntidad").hide();

    $("#alcaldiaDiv").removeClass("has-error");
    $("#errorAlcaldia").text('');
    $("#errorAlcaldia").hide();

    $("#coloniaDiv").removeClass("has-error");
    $("#errorColonia").text('');
    $("#errorColonia").hide();

    $("#calleInmDiv").removeClass("has-error");
    $("#errorCalle").text('');
    $("#errorCalle").hide();

    $("#numeroInmDiv").removeClass("has-error");
    $("#errorNumero").text('');
    $("#errorNumero").hide();

    $("#cpInmDiv").removeClass("has-error");
    $("#errorCP").text('');
    $("#errorCP").hide();

    $("#estatusInmDiv").removeClass("has-error");
    $("#errorEstatusInm").text('');
    $("#errorEstatusInm").hide();

}

function limpiarEtiquetas(){
 $("#denominacionDiv").removeClass("has-error");
    $("#errorDenominacion").text('');
    $("#errorDenominacion").hide();

    $("#entidadFedDiv").removeClass("has-error");
    $("#errorEntidad").text('');
    $("#errorEntidad").hide();

    $("#alcaldiaDiv").removeClass("has-error");
    $("#errorAlcaldia").text('');
    $("#errorAlcaldia").hide();

    $("#coloniaDiv").removeClass("has-error");
    $("#errorColonia").text('');
    $("#errorColonia").hide();

    $("#calleInmDiv").removeClass("has-error");
    $("#errorCalle").text('');
    $("#errorCalle").hide();

    $("#numeroInmDiv").removeClass("has-error");
    $("#errorNumero").text('');
    $("#errorNumero").hide();

    $("#cpInmDiv").removeClass("has-error");
    $("#errorCP").text('');
    $("#errorCP").hide();

    $("#estatusInmDiv").removeClass("has-error");
    $("#errorEstatusInm").text('');
    $("#errorEstatusInm").hide();

}