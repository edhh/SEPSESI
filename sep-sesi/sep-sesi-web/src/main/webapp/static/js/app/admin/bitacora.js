$(document).ready(function () {
    obtProceso();
    var today = new Date();
    $('#fechaDesde').datepicker({
        format: 'dd/mm/yyyy',
        endDate: today,
        language: 'es'});

    $('#fechaHasta').datepicker({
        endDate: today,
        format: 'dd/mm/yyyy',
        language: 'es'});

});

$("#limpiarBit").click(function () {
    location.href = baseURI + '/mvc/admin/bitacora';
});


$("#buscarBit").click(function () {
    //object.configModule.standby.show();
    $("#errorUserBit").text('');
    $("#errorUserBit").hide();
    $("#userBitDiv").removeClass("has-error");
    $("#errorDesdeBit").text('');
    $("#errorDesdeBit").hide();
    $("#desdeBitDiv").removeClass("has-error");
    $("#errorHastaBit").text('');
    $("#errorHastaBit").hide();
    $("#hastaBitDiv").removeClass("has-error");


    if (validaDatos()) {


        function DateFormat(value, row, index) {
            console.log(value);
            //return moment(value).format('MM/DD/YYYY');
            var currentTime = new Date(value);
            //var month = currentTime.getMonth() + 1;
            var month = (currentTime.getMonth() + 1) < 10 ? "0" + (currentTime.getMonth() + 1) : (currentTime.getMonth() + 1);
            var day = currentTime.getDate();
            var year = currentTime.getFullYear();
            var date = day + "/" + month + "/" + year;
            console.log(date);
            return date;
        }

        var columnas = [
            {
                field: 'fechaOperacion',
                title: 'Fecha',
                align: 'center',
                type: 'datetime',
                def: function (object) {
                    console.log(object.value);
                    return new Date();
                },
                //format: 'MM-DD-YYYY h:mm A',
                formatter: DateFormat,
                fieldInfo: 'US style m-d-y date input with 12 hour clock',
                opts: {
                    minutesIncrement: 5
                }
            },

            {
                field: 'nombreUsu',
                title: 'Nombre usuario',
                align: 'center'
            }, {
                field: 'nombreCompleto',
                title: 'Nombre completo',
                align: 'center',
            }, {
                field: 'descRol',
                title: 'Rol',
                align: 'center'
            }, {
                field: 'descripcion',
                title: 'Proceso',
                align: 'center',
            }, {
                field: 'operate',
                //title: 'Edit',
                align: 'center',
                valign: 'middle',
                clickToSelect: false,
                formatter: addbutton = function addbutton(value, row, index) {
                    return '<button class=\'btn btn-primary btn-detalle\' idBitacora="' + row.idBitacora + '">Detalle</button> ';
                }

            }]
        $('#resultadosBitacoraTable').bootstrapTable({
            columns: columnas
        });
        $('#resultadosBitacoraTable').bootstrapTable('showLoading');

        var param = {};
        var fApertura = $('#fechaDesde').datepicker('getDate');
        $.datepicker.formatDate('dd-mm-yy', fApertura);
        var fCierre = $('#fechaHasta').datepicker('getDate');
        $.datepicker.formatDate('dd-mm-yy', fCierre);

        param["idTradServicio"] = $('#selecProceso').val();
        param["nombreUsu"] = $('#userBit').val();
        param["fechaOpIni"] = fApertura;
        param["fechaOpFin"] = fCierre;
        console.log(param);

//    var consultaBitacora = {};
//    consultaBitacora.idTradServicio = $('#selecProceso').val();
//    consultaBitacora.nombreUsu = $('#userBit').val();
//    consultaBitacora.fechaOpIni = fApertura;
//    consultaBitacora.fechaOpFin = fCierre;
//    console.log(consultaBitacora);

        $('#loader').modal('toggle');
        checkedRows = [];
        $.ajax({
            url: baseURI + "/mvc/bitacora/consultaBitacora",
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            data: param,
//        data: JSON.stringify(consultaBitacora),
//        dataType: "json",
            cache: false,
        }).done(function (resumenInstancias) {
            console.log(resumenInstancias);
            $('#resultadosBitacoraTable').bootstrapTable('destroy');
            $('#resultadosBitacoraTable').bootstrapTable({
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


function obtProceso()
{
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/bitacora/obtenerProcesos",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {

            if (response.length > 0) {

                var procesos;
                procesos = response;
                populateSelectProceso(procesos);
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

function  populateSelectProceso(lstProceso) {

    document.getElementById("selecProceso").options.length = 0;
    for (var i = 0; i <= lstProceso.length - 1; i++) {
        if (i == 0 && lstProceso.length >= 1) {
            $('#selecProceso').append('<option value="">' + 'SELECCIONA' + '</option>');
        }
        $('#selecProceso').append('<option value="' + lstProceso[i].idTradServicio + '">' + lstProceso[i].descripcion + '</option>');
    }

}

function asignaProceso() {
    var idProceso = document.getElementById("selecProceso").value;
    $('#selecProceso').val(idProceso);
    console.log('idProceso  ' + idProceso);

}


$('#resultadosBitacoraTable').on('click', '.btn-detalle', function () {
    var idBitacora = $(this).attr('idBitacora');
    obtieneDetalle(idBitacora);
    //modo = 'editar';
});



function obtieneDetalle(idBitacora) {

    $('#loader').modal('toggle');
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/bitacora/obtieneDetalle/" + idBitacora,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            console.log(response);
            if (response.idBitacora !== '') {
                $('#areaDetalle').val(response.detalle);

                $('#loader').modal('toggle');
                $('#modalMostrarDetalle').modal('show');
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }
    });

}

function validaDatos() {

    var datosValidos = true;
    var username = $('#userBit').val();
    var fechaInicio = $('#fechaDesde').val();
    var fechaFin = $('#fechaHasta').val();

    if (username !== "") {
        if (username.length < 4) {
            $("#userBitDiv").addClass("has-error");
            $("#errorUserBit").text('');
            $("#errorUserBit").show();
            $("#errorUserBit").append("Ingrese m&iacute;nimo 4 caracteres");
            datosValidos = false;
        }

    }

    if (fechaInicio === '' && fechaFin === '') {
        $("#desdeBitDiv").addClass("has-error");
        $("#errorDesdeBit").text('');
        $("#errorDesdeBit").show();
        $("#errorDesdeBit").append("Seleccione rango de fechas");
        $("#hastaBitDiv").addClass("has-error");
        //$("#errorHastaBit").text('');
        $("#errorHastaBit").show();
        datosValidos = false;

    }

    if (fechaInicio == '' && fechaFin != '') {
        $("#desdeBitDiv").addClass("has-error");
        $("#errorDesdeBit").text('');
        $("#errorDesdeBit").show();
        $("#errorDesdeBit").append("Seleccione fecha inicial");
        datosValidos = false;

    }

    if (fechaInicio != '' && fechaFin == '') {
        $("#hastaBitDiv").addClass("has-error");
        $("#errorHastaBit").text('');
        $("#errorHastaBit").show();
        $("#errorHastaBit").append("Seleccione fecha final");
        datosValidos = false;

    }

    var fApertura = $('#fechaDesde').datepicker('getDate');
    $.datepicker.formatDate('dd-mm-yy', fApertura);
    var fCierre = $('#fechaHasta').datepicker('getDate');
    $.datepicker.formatDate('dd-mm-yy', fCierre);

    if (fechaInicio != '' && fechaFin != '') {
        if (fApertura > fCierre) {
            $("#desdeBitDiv").addClass("has-error");
            $("#errorDesdeBit").text('');
            $("#errorDesdeBit").show();
            $("#errorDesdeBit").append("La fecha Hasta no puede ser menor a la fecha Desde");
            $("#hastaBitDiv").addClass("has-error");
            $("#errorHastaBit").show();
            datosValidos = false;

        }
    }

    console.log('datosValidos es ' + datosValidos);

    return datosValidos;
}




