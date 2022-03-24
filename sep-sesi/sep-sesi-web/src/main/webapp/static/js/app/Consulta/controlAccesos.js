$(document).ready(function () {
     var today = new Date();
    $('#fecha').datepicker({ 
        format: 'dd/mm/yyyy',
        endDate: today,
        language: 'es'});
    //$('#fecha').datepicker("setDate", new Date());
    $('#fecha2').datepicker({
        endDate: today,
        format: 'dd/mm/yyyy',
        language: 'es'});
    //$('#fecha2').datepicker("setDate", new Date());
});
$("#foto").click(function () {
    $("#vista").attr("src", "bety.jpg")
});

$("#limpiar").click(function () {
    populateSelectControl();
    obtenerUR();
    obtInmueble();
    obtenerTipoPersona();
    $('#fecha').val('');
    $('#fecha2').val('');
    $("#errorRol").text('');
    $("#errorRol").hide();
    $("#rolDiv").removeClass("has-error");
    $("#errorDesde").text('');
    $("#errorDesde").hide();
    $("#desdeDiv").removeClass("has-error");
    $("#errorHasta").text('');
    $("#errorHasta").hide();
    $("#hastaDiv").removeClass("has-error");
    $('#fecha').val('').datepicker('update');
    $('#fecha2').val('').datepicker('update');
    $('#resultadosResumenTable').bootstrapTable('destroy');
});

function addInput(value, row, index) {
    return  '<input class=\'chk\' type=\'checkbox\' value="' + row.idPersona + '" id="chk_' + row.idPersona + '">';
}

$("#buscar").click(function () {
    //object.configModule.standby.show();
    $("#errorRol").text('');
    $("#errorRol").hide();
    $("#rolDiv").removeClass("has-error");
    $("#errorDesde").text('');
    $("#errorDesde").hide();
    $("#desdeDiv").removeClass("has-error");
    $("#errorHasta").text('');
    $("#errorHasta").hide();
    $("#hastaDiv").removeClass("has-error");
    if (validaDatos()) {
        var columnas = [
            {
                field: 'operacion',
                title: 'Tipo de operacion',
                align: 'center'
            },
//            {
//                field: 'fechaDate',
//                title: 'Fecha',
//                align: 'center',
//                type: 'datetime',
//                def: function () {
//                    return new Date();
//                },
//                format: 'MM-DD-YYYY hh:mm A',
//                fieldInfo: 'US style m-d-y date input with 12 hour clock',
//                opts: {
//                    minutesIncrement: 5
//                }
//            },
            {
                field: 'fecha',
                title: 'Fecha',
                align: 'center',
                type: 'datetime',
                formatter: function (value,type,row) {
                    console.log(value);
                    return dateFormat(value);
                }
              
            },
            {
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
            },
            {
                field: 'tipoPersona',
                title: 'Tipo de persona',
                align: 'center',
            }, {
                field: 'unidadResponsable',
                title: 'UR',
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
        var idTipoPersona = $('#rol').val();
        if (idTipoPersona === "SELECCIONA") {
            idTipoPersona = '';
        }
        var idOperacion = $('#control').val();
        if (idOperacion === "SELECCIONA") {
            idOperacion = '';
        }
        var desde = $('#fecha').val();
        if (desde === '') {
            console.log('if');
            desde === new Date();
        }
        var hasta = $('#fecha2').val();
        if (hasta === '') {
            console.log('if');
            hasta === new Date();
        }
        var x = desde.split('/'); 
        var z = hasta.split('/');
        var fecha1 = x[1] + '/' + x[0] + '/'+ x[2];
        var fecha2 = z[1] + '/' + z[0] + '/' + z[2];
        var param = {};
        param["idUr"] = idUR;
        param["idOperacion"] = idOperacion;
        param["idInmueble"] = idINMUEBLE;
        param["idTipoPersona"] = idTipoPersona;
        param["desde"] = fecha1;
        param["hasta"] = fecha2;
        $('#loader').modal('toggle');
        $.ajax({
            url: baseURI + "/mvc/consulta/consultaAcceso",
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            data: param,
            //dataType: "json",
            cache: false,
        }).done(function (resumenInstancias) {
            console.log(resumenInstancias);
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
    populateSelectControl();
    obtenerUR();
    usuarioRol();
    obtInmueble();
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
                console.log('if');
                console.log(response);
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

function populateSelectControl() {
    var listaControl = ["SELECCIONA","ENTRADA", "SALIDA"];
    document.getElementById("control").options.length = 0;
    console.log('selectControl');
    for (var i = 1; i < 3; i++) {
        console.log('i es ' + i);
        if (i == 1) {
            $('#control').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#control').append('<option value="' + i + '">' + listaControl[i] + '</option>');
    }

}

function populateSelectTipoPersona(lstTipoPersona) {
    console.log("POPULATING SELECT TIPO PERSONA");
    console.log(lstTipoPersona);
    document.getElementById("rol").options.length = 0;
    for (var i = 0; i <= lstTipoPersona.length - 1; i++) {
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
            var idTipoPersona = $('#rol').val();
            if (idTipoPersona === "SELECCIONA") {
                idTipoPersona = '';
            }
            var idOperacion = $('#control').val();
            if (idOperacion === "SELECCIONA") {
                idOperacion = '';
            }
            var desde = $('#fecha').val();
            if (desde === '') {
                console.log('if');
                desde === new Date();
            }
            var hasta = $('#fecha2').val();
            if (hasta === '') {
                console.log('if');
                hasta === new Date();
            }
            var tipoPersona = $('#rol').val();
            var param = {};
            param["idTipoPersona"] = tipoPersona;
            param["idUr"] = idUR;
            param["idInmueble"] = idINMUEBLE;
            param["idOperacion"] = idOperacion;
            var x = desde.split('/'); 
            var z = hasta.split('/');
            var fecha1 = x[1] + '/' + x[0] + '/'+ x[2];
            var fecha2 = z[1] + '/' + z[0] + '/' + z[2];
            param["desde"] = fecha1;
            param["hasta"] = fecha2;
            $.ajax({
                type: "GET",
                cache: false,
                url: baseURI + "/mvc/consulta/consultaAcceso",
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data: param,
                success: function (response) {
                    console.log(response.length);
                    if (response.length > 0) {
                        if (tipoPersona === '3') {
                            window.document.location.href = baseURI + '/mvc/jasper/repControlVisitante?entradaSalida=' + idOperacion + '&tipoPersona=' + idTipoPersona + '&idUr=' + idUR
                                    + '&idInmueble=' + idINMUEBLE + '&fecha1=' + desde + '&fecha2=' + hasta;
                        } else {
                            window.document.location.href = baseURI + '/mvc/jasper/repControl?entradaSalida=' + idOperacion + '&tipoPersona=' + idTipoPersona + '&idUr=' + idUR
                                    + '&idInmueble=' + idINMUEBLE + '&fecha1=' + desde + '&fecha2=' + hasta;
                        }
                    } else {
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

            /*if (tipoPersona === '3') {
             window.document.location.href = baseURI + '/mvc/jasper/repControlVisitante?entradaSalida=' + idOperacion + '&tipoPersona=' + idTipoPersona + '&idUr=' + idUR
             + '&idInmueble=' + idINMUEBLE + '&fecha1=' + desde + '&fecha2=' + hasta;
             } else {
             window.document.location.href = baseURI + '/mvc/jasper/repControl?entradaSalida=' + idOperacion + '&tipoPersona=' + idTipoPersona + '&idUr=' + idUR
             + '&idInmueble=' + idINMUEBLE + '&fecha1=' + desde + '&fecha2=' + hasta;
             }*/
        }
    });

});

function validaDatos() {

    var datosValidos = true;
    var idTipoPersona = $('#rol').val();
    var desde = ($('#fecha').val());
    var hasta = ($('#fecha2').val());
    var x = desde.split('/'); 
    var z = hasta.split('/');
    console.log('desdeV ' + desde);
    console.log('hastaV ' + hasta);
    console.log('x ' + x[1]);
    console.log('z ' + z[1]);
    var fecha1 = x[1] + '-' + x[0] + '-'+ x[2];
    var fecha2 = z[1] + '-' + z[0] + '-' + z[2];
    console.log('fecha1V ' + fecha1);
    console.log('fecha2V ' + fecha2);
    
    var getBrowserInfo = function() {
    var ua= navigator.userAgent, tem, 
    M= ua.match(/(opera|chrome|safari|firefox|msie|trident(?=\/))\/?\s*(\d+)/i) || [];
    if(/trident/i.test(M[1])){
        tem=  /\brv[ :]+(\d+)/g.exec(ua) || [];
        return 'IE '+(tem[1] || '');
    }
    if(M[1]=== 'Chrome'){
        tem= ua.match(/\b(OPR|Edge)\/(\d+)/);
        if(tem!= null) return tem.slice(1).join(' ').replace('OPR', 'Opera');
    }
    M= M[2]? [M[1], M[2]]: [navigator.appName, navigator.appVersion, '-?'];
    if((tem= ua.match(/version\/(\d+)/i))!= null) M.splice(1, 1, tem[1]);
    return M.join(' ');
};

console.log(getBrowserInfo());
console.log('index of ' + getBrowserInfo().indexOf('Firefox') > -1);
if (getBrowserInfo().indexOf('Firefox') > -1){
    console.log('Firefox');
    if (x[2] > z[2]){
        console.log('errorAnio');
        $("#desdeDiv").addClass("has-error");
        $("#errorDesde").text('');
        $("#errorDesde").show();
        $("#errorDesde").append("El campo Desde no puede ser mayor al campo Hasta");
        $("#hastaDiv").addClass("has-error");
        $("#errorHasta").text('');
        $("#errorHasta").show();
        $("#errorHasta").append("El campo Desde no puede ser mayor al campo Hasta");
        datosValidos = false;
    } else if (x[2]<= z[2]  && x[1] > z [1] && x[2]==z[2]){
        console.log('errorMes');
        console.log('x[1]' + x[1]);
        console.log('z[1]' + z[1]);
        $("#desdeDiv").addClass("has-error");
        $("#errorDesde").text('');
        $("#errorDesde").show();
        $("#errorDesde").append("El campo Desde no puede ser mayor al campo Hasta");
        $("#hastaDiv").addClass("has-error");
        $("#errorHasta").text('');
        $("#errorHasta").show();
        $("#errorHasta").append("El campo Desde no puede ser mayor al campo Hasta");
        datosValidos = false;
    } else if (x[2]<= z[2] && x[1] <= z [1] && x[0] > z[0]){
        console.log('errorDía');
        $("#desdeDiv").addClass("has-error");
        $("#errorDesde").text('');
        $("#errorDesde").show();
        $("#errorDesde").append("El campo Desde no puede ser mayor al campo Hasta");
        $("#hastaDiv").addClass("has-error");
        $("#errorHasta").text('');
        $("#errorHasta").show();
        $("#errorHasta").append("El campo Desde no puede ser mayor al campo Hasta");
        datosValidos = false;
    }
}

    /*if (desde > fechaa || hasta > fechaa){
        alert ('No se puede ingresar una fecha posterior al d\u00EDa de hoy');
        datosValidos = false;
    }*/
    
    if (Date.parse(fecha1) > Date.parse(fecha2)){
        console.log('error');
        $("#desdeDiv").addClass("has-error");
        $("#errorDesde").text('');
        $("#errorDesde").show();
        $("#errorDesde").append("El campo Desde no puede ser mayor al campo Hasta");
        $("#hastaDiv").addClass("has-error");
        $("#errorHasta").text('');
        $("#errorHasta").show();
        $("#errorHasta").append("El campo Desde no puede ser mayor al campo Hasta");
        datosValidos = false;
    }

    /*if (desde > hasta) {
        $("#desdeDiv").addClass("has-error");
        $("#errorDesde").text('');
        $("#errorDesde").show();
        $("#errorDesde").append("El campo Desde no puede ser mayor al campo Hasta");
        $("#hastaDiv").addClass("has-error");
        $("#errorHasta").text('');
        $("#errorHasta").show();
        $("#errorHasta").append("El campo Desde no puede ser mayor al campo Hasta");
        datosValidos = false;
    }*/

    if (idTipoPersona === "SELECCIONA") {
        $("#rolDiv").addClass("has-error");
        $("#errorRol").text('');
        $("#errorRol").show();
        $("#errorRol").append("Campo obligatorio");
        datosValidos = false;
    }
    if (desde === '') {
        $("#desdeDiv").addClass("has-error");
        $("#errorDesde").text('');
        $("#errorDesde").show();
        $("#errorDesde").append("Campo obligatorio");
        datosValidos = false;
    }
    if (hasta === '') {
        $("#hastaDiv").addClass("has-error");
        $("#errorHasta").text('');
        $("#errorHasta").show();
        $("#errorHasta").append("Campo obligatorio");
        datosValidos = false;
    }

    return datosValidos;
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
    }
}

function dateFormat(d) {
    
var dateVal = d + "";
    var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
    var dia = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
    var mes = (date.getMonth() + 1) < 10 ? "0" + (date.getMonth() + 1) : (date.getMonth() + 1);
    var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();

    console.log(date);
    return ((dia + "")
            + "/" + mes + "")
            + "/" + date.getFullYear() + " " + hours + ":" + minutes;
}
