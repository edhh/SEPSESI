var checkedRows = [];
var modo;

$(document).ready(function () {
    obtenerUR();
});

$("#limpiarFirm").click(function () {
    location.href = baseURI + '/mvc/Usuarios/consultaFirmantes';
//    $('#urFirm').val('SELECCIONA');
//    //checkedRows = [];
//    $('#resultadosFirmantesTable').bootstrapTable('destroy');
});


$("#buscarFirm").click(function () {
    verificarUrInit();

    var columnas = [
        {
            field: 'unidadResponsable',
            title: 'Unidad Responsable',
            align: 'center'
        }, {
            field: 'nombreAutoriza',
            title: 'Nombre Autoriza',
            align: 'center'
        }, {
            field: 'puestoAutoriza',
            title: 'Puesto Autoriza',
            align: 'center'
        }, {
            field: 'operate',
            //title: 'Edit',
            align: 'center',
            valign: 'middle',
            clickToSelect: false,
            formatter: addbutton = function addbutton(value, row, index) {
                return '<button class=\'btn btn-primary btn-edit\' idFirmante="' + row.idFirmante + '">Modificar</button> ';
            }
        }]

    $('#resultadosFirmantesTable').bootstrapTable({
        columns: columnas
    });

    $('#resultadosFirmantesTable').bootstrapTable('showLoading');
    var param = {};
    param["idUr"] = $('#idURFirm').val();
    console.log("param==>" + param);
    console.log(param);
    $('#loader').modal('toggle');
    checkedRows = [];

    $.ajax({
        url: baseURI + "/mvc/firmantes/listFirmantes",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        data: param,
        //dataType: "json",
        cache: false,
    }).done(function (resumenInstancias) {
        console.log(resumenInstancias);
        $('#resultadosFirmantesTable').bootstrapTable('destroy');
        $('#resultadosFirmantesTable').bootstrapTable({
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

function populateSelectUR(lstUR) {

    document.getElementById("urFirm").options.length = 0;
    for (var i = 0; i <= lstUR.length - 1; i++) {
        if (i == 0 && lstUR.length >= 1) {
            $('#urFirm').append('<option value = "" >' + 'SELECCIONA' + '</option>');
        }
        $('#urFirm').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
    }

}

function asignaUR() {
    var idUr = document.getElementById("urFirm").value;
    $('#idURFirm').val(idUr);
    console.log('id Ur valorUR es ' + idUr);


}

function usuarioRol() {
    var vUrl = baseURI + '/mvc/seguridad/menu/obtenerUsuario';
    conectaPost(vUrl, "", resUsuario);
}

function resUsuario(data) {
    var rol_usuario = data.idRol
    var idUr = data.idUr;
    if (rol_usuario == 2) {
        $("#urFirm").prop('disabled', true);
        $('#idURFirm').val(idUr);
        $('#urFirm').val(idUr);
        $("#buscarFirm").trigger("click");
    }
}

$('#nuevoFirmante').click(function () {
    $("#urFirmModal").prop('disabled', false);
    obtenerURMod();
    $('#urFirmModal').append('<option>' + 'SELECCIONA' + '</option>');
    document.getElementById("file-preview-zone").innerHTML = "";
    document.getElementById("imageBase").innerHTML = "";
    $('#ModalFirmantes').modal('show');
});


function insertaFirmantes() {


    var idFirmante = $('#idFirmante').val();
    var idUR = $('#idURFirmModal').val();
    var nombreAutoriza = $('#nombreAutorizaModal').val();
    var puestoAutoriza = $('#puestoAutorizaModal').val();
    var vcfData = new FormData($('#formCarga')[0]);
    var foto = document.getElementById("idFoto").value;
    var doc = document.getElementById("cargaArchivo").value;
    console.log('foto es' + foto);
    limpiarEtiquetas();
    if (validaDatos()) {
        if (foto === '') {
            if (doc) {
                var imgsize = document.getElementsByClassName("subirimagen")[0].files[0].size;
                var jpgType = doc.search(".jpg");
                var jpegType = doc.search(".jpeg");
                if (jpgType != -1 || jpegType != -1) {
                    if (imgsize <= 10000000) {
                        $.ajax({
                            type: "POST",
                            cache: false,
                            url: baseURI + '/mvc/firmantes/insertaFirmante',
                            data: vcfData,
                            processData: false, contentType: false,
                            method: "POST",
                            dataType: 'json',
                            success: function (response) {

                                $('#btnGuardarFirm').attr('disabled', 'disabled');
                                var respuesta = response.msg;
                                if (respuesta === '2') {
                                    $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Ya existe un firmante para esta Unidad Responsable.").show();
                                } else {

                                    $("#divExitoPaginaMod").removeClass().addClass("alert alert-success").text('').append("La informaci&oacute;n se registr&oacute; exitosamente.").show();
                                    //$('#btnGuardarFirm').attr('disabled', 'disabled');
                                    //$("#myModal1 .modal-body").text(object.msg);
                                    setTimeout(function () {
                                        $('#ModalFirmantes').modal('hide');
                                        location.href = baseURI + '/mvc/Usuarios/consultaFirmantes';
                                        //location.href = baseURI + '/mvc/firmantes/listFirmantes';
                                    }, 3000);
                                }

                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                console.log('jqXHR.status:: ' + jqXHR.status);
                                console.log('jqXHR.text:: ' + jqXHR.text);
                                console.log('textStatus:: ' + textStatus);
                                $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Algo sali&oacute; mal").show();
                                
                            }
                        });
                    } else {
                        alert("La imagen no puede tener un tama\u00F1o superior a los 10 MB");
                        document.getElementById("btnGuardar").disabled = false;
                    }
                } else {
                    alert("Tipo de archivo inv\u00E1lido");
                    document.getElementById("btnGuardar").disabled = false;
                }
            } else {
                $.ajax({
                            type: "POST",
                            cache: false,
                            url: baseURI + '/mvc/firmantes/insertaFirmante',
                            data: vcfData,
                            processData: false, contentType: false,
                            method: "POST",
                            dataType: 'json',
                            success: function (response) {

                                $('#btnGuardarFirm').attr('disabled', 'disabled');
                                var respuesta = response.msg;
                                if (respuesta === '2') {
                                    $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Ya existe un firmante para esta Unidad Responsable.").show();
                                } else {

                                    $("#divExitoPaginaMod").removeClass().addClass("alert alert-success").text('').append("La informaci&oacute;n se registr&oacute; exitosamente.").show();
                                    //$('#btnGuardarFirm').attr('disabled', 'disabled');
                                    //$("#myModal1 .modal-body").text(object.msg);
                                    setTimeout(function () {
                                        $('#ModalFirmantes').modal('hide');
                                        location.href = baseURI + '/mvc/Usuarios/consultaFirmantes';
                                        //location.href = baseURI + '/mvc/firmantes/listFirmantes';
                                    }, 3000);
                                }

                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                console.log('jqXHR.status:: ' + jqXHR.status);
                                console.log('jqXHR.text:: ' + jqXHR.text);
                                console.log('textStatus:: ' + textStatus);
                                $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Algo sali&oacute; mal").show();
                                
                            }
                        });
            }
        } else{
            /*$.ajax({
                            type: "POST",
                            cache: false,
                            url: baseURI + '/mvc/firmantes/insertaFirmante',
                            data: vcfData,
                            processData: false, contentType: false,
                            method: "POST",
                            dataType: 'json',
                            success: function (response) {

                                $('#btnGuardarFirm').attr('disabled', 'disabled');
                                var respuesta = response.msg;
                                if (respuesta === '2') {
                                    $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Ya existe un firmante para esta Unidad Responsable.").show();
                                } else {

                                    $("#divExitoPaginaMod").removeClass().addClass("alert alert-success").text('').append("La informaci&oacute;n se registr&oacute; exitosamente.").show();
                                    //$('#btnGuardarFirm').attr('disabled', 'disabled');
                                    //$("#myModal1 .modal-body").text(object.msg);
                                    setTimeout(function () {
                                        $('#ModalFirmantes').modal('hide');
                                        location.href = baseURI + '/mvc/Usuarios/consultaFirmantes';
                                        //location.href = baseURI + '/mvc/firmantes/listFirmantes';
                                    }, 3000);
                                }

                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                console.log('jqXHR.status:: ' + jqXHR.status);
                                console.log('jqXHR.text:: ' + jqXHR.text);
                                console.log('textStatus:: ' + textStatus);
                                $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Algo sali&oacute; mal").show();
                                
                            }
                        });*/
            if (doc) {
                var imgsize = document.getElementsByClassName("subirimagen")[0].files[0].size;
                var jpgType = doc.search(".jpg");
                var jpegType = doc.search(".jpeg");
                if (jpgType != -1 || jpegType != -1) {
                    if (imgsize <= 10000000) {
                        $.ajax({
                            type: "POST",
                            cache: false,
                            url: baseURI + '/mvc/firmantes/insertaFirmante',
                            data: vcfData,
                            processData: false, contentType: false,
                            method: "POST",
                            dataType: 'json',
                            success: function (response) {

                                $('#btnGuardarFirm').attr('disabled', 'disabled');
                                var respuesta = response.msg;
                                if (respuesta === '2') {
                                    $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Ya existe un firmante para esta Unidad Responsable.").show();
                                } else {

                                    $("#divExitoPaginaMod").removeClass().addClass("alert alert-success").text('').append("La informaci&oacute;n se registr&oacute; exitosamente.").show();
                                    //$('#btnGuardarFirm').attr('disabled', 'disabled');
                                    //$("#myModal1 .modal-body").text(object.msg);
                                    setTimeout(function () {
                                        $('#ModalFirmantes').modal('hide');
                                        location.href = baseURI + '/mvc/Usuarios/consultaFirmantes';
                                        //location.href = baseURI + '/mvc/firmantes/listFirmantes';
                                    }, 3000);
                                }

                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                console.log('jqXHR.status:: ' + jqXHR.status);
                                console.log('jqXHR.text:: ' + jqXHR.text);
                                console.log('textStatus:: ' + textStatus);
                                $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Algo sali&oacute; mal").show();
                                
                            }
                        });
                    } else {
                        alert("La imagen no puede tener un tama\u00F1o superior a los 10 MB");
                        document.getElementById("btnGuardar").disabled = false;
                    }
                } else {
                    alert("Tipo de archivo inv\u00E1lido");
                    document.getElementById("btnGuardar").disabled = false;
                }
            } else {
                $.ajax({
                            type: "POST",
                            cache: false,
                            url: baseURI + '/mvc/firmantes/insertaFirmante',
                            data: vcfData,
                            processData: false, contentType: false,
                            method: "POST",
                            dataType: 'json',
                            success: function (response) {

                                $('#btnGuardarFirm').attr('disabled', 'disabled');
                                var respuesta = response.msg;
                                if (respuesta === '2') {
                                    $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Ya existe un firmante para esta Unidad Responsable.").show();
                                } else {

                                    $("#divExitoPaginaMod").removeClass().addClass("alert alert-success").text('').append("La informaci&oacute;n se registr&oacute; exitosamente.").show();
                                    //$('#btnGuardarFirm').attr('disabled', 'disabled');
                                    //$("#myModal1 .modal-body").text(object.msg);
                                    setTimeout(function () {
                                        $('#ModalFirmantes').modal('hide');
                                        location.href = baseURI + '/mvc/Usuarios/consultaFirmantes';
                                        //location.href = baseURI + '/mvc/firmantes/listFirmantes';
                                    }, 3000);
                                }

                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                console.log('jqXHR.status:: ' + jqXHR.status);
                                console.log('jqXHR.text:: ' + jqXHR.text);
                                console.log('textStatus:: ' + textStatus);
                                $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Algo sali&oacute; mal").show();
                                
                            }
                        });
            }
        }
        /*var datosFirmante = {}

        datosFirmante.idFirmante = idFirmante;
        datosFirmante.idUr = idUR;
        datosFirmante.nombreAutoriza = nombreAutoriza;
        datosFirmante.puestoAutoriza = puestoAutoriza;
        console.log(datosFirmante);

        var vURL = baseURI + '/mvc/firmantes/insertaFirmante';

        $.ajax({
            type: "POST",
            cache: false,
            url: vURL,
            contentType: 'application/json;  charset=utf-8',
            data: JSON.stringify(datosFirmante),
            dataType: 'json',
            success: function (response) {
                console.log("objeto----" + response);
                $('#btnGuardarFirm').attr('disabled', 'disabled');
                var respuesta = response.msg;
                if (respuesta === '2') {
                    $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Ya existe un firmante para esta Unidad Responsable.").show();
                } else {

                    $("#divExitoPaginaMod").removeClass().addClass("alert alert-success").text('').append("La informaci&oacute;n se registr&oacute; exitosamente.").show();
                    //$('#btnGuardarFirm').attr('disabled', 'disabled');
                    //$("#myModal1 .modal-body").text(object.msg);
                    setTimeout(function () {
                        $('#ModalFirmantes').modal('hide');
                        location.href = baseURI + '/mvc/Usuarios/consultaFirmantes';
                        //location.href = baseURI + '/mvc/firmantes/listFirmantes';
                    }, 3000);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('jqXHR.status:: ' + jqXHR.status);
                console.log('jqXHR.text:: ' + jqXHR.text);
                console.log('textStatus:: ' + textStatus);
                $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Algo sali&oacute; mal").show();
            }

        });*/
    }
}


$('#resultadosFirmantesTable').on('click', '.btn-edit', function () {
    var idFirmante = $(this).attr('idFirmante');
    obtieneFirmante(idFirmante);
    modo = 'editar';
});


function obtieneFirmante(idFirmante) {
    $('.has-error').removeClass("has-error");
    $("#errorUrFirmModal").text('');
    $("#errorNombreAutorizaModal").text('');
    $("#errorPuestoAutorizaModal").text('');
    document.getElementById("formCarga").reset();
    document.getElementById("file-preview-zone").innerHTML = "";
    document.getElementById("imageBase").innerHTML = "";
    $("#urFirmModal").prop('disabled', true);
    $('#loader').modal('toggle');
    var ur;
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/firmantes/obtieneFirmante/" + idFirmante,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            console.log("response---" + response);
            if (response.idFirmante !== '') {
                $('#idFirmante').val(response.idFirmante);

                //$('#idURFirmModal').val(response.idUr);
                $('#nombreAutorizaModal').val(response.nombreAutoriza);
                $('#puestoAutorizaModal').val(response.puestoAutoriza);
                ur = response.idUr;
                $('#idURFirmModal').val(ur);

                //if (response.idUr != null) {
                obtenerURMod(ur);
                $('#urFirmModal').val(ur);
//                } else {
//                    obtenerUR();
//                }
                $('#idFoto').val(response.fotografia);
                var fotografia = response.fotografia;
                if (fotografia === null) {
                    document.getElementById("imageBase").innerHTML = "";
                } else {

                    document.getElementById("imageBase").innerHTML = "";
                    var ItemPreview = document.createElement('img');
                    ItemPreview.id = 'item-preview';
                    //e.target.result contents the base64 data from the image uploaded
                    ItemPreview.src = "data:image/jpg;base64," + fotografia;
                    ItemPreview.width = 200;
                    ItemPreview.height = 200;

                    var previewZone = document.getElementById('imageBase');
                    previewZone.appendChild(ItemPreview);
                }

                $('#loader').modal('toggle');
                $('#ModalFirmantes').modal('show');
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }

    });

}


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
                //$('#urFirmModal').val(idUr);
                usuarioRolMod();

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


//function populateSelectURMod(lstUR, idUr) {
//
//    document.getElementById("urFirmModal").options.length = 0;
//    for (var i = 0; i <= lstUR.length - 1; i++) {
//        if (i == 0 && lstUR.length >= 1) {
//            $('#urFirmModal').append('<option value="-1">' + 'SELECCIONA' + '</option>');
//        }
//        $('#urFirmModal').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
//    }
//    $('#urFirmModal').val(idUr);
//}

function populateSelectURMod(lstUR, idUr) {

    document.getElementById("urFirmModal").options.length = 0;
    $('#urFirmModal').append('<option value="">SELECCIONA</option>');
    if (lstUR.length > 0) {
        for (var i = 0; i <= lstUR.length - 1; i++) {
            $('#urFirmModal').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
        }
    }
    $('#urFirmModal').val(idUr);
}

function asignaURMod() {
    var idUr = document.getElementById("urFirmModal").value;
    $('#idURFirmModal').val(idUr);
    console.log('id Ur valorUR es ' + idUr);
    verificarUr();

}


function usuarioRolMod() {
    var vUrl = baseURI + '/mvc/seguridad/menu/obtenerUsuario';
    conectaPost(vUrl, "", resUsuarioMod);
}

function resUsuarioMod(data) {
    var rol_usuario = data.idRol
    var idUr = data.idUr;
    if (rol_usuario == 2) {
        $("#urFirmModal").prop('disabled', true);
        $('#idURFirmModal').val(idUr);
        $('#urFirmModal').val(idUr);
    }
}

function verificarUr() {
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/firmantes/verificaUR/" + $("#urFirmModal").val(),
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            if (response.respuesta == 'Si existe') {
                console.log('respuesta' + response.respuesta);
                $("#divErrorPaginaMod").removeClass().addClass("alert alert-warning").text('').append("Ya existe firmante para esta Unidad Responsable. Seleccione otra Unidad Responsable").show();
                $('#btnGuardarFirm').attr('disabled', true);
            } else {
                $("#divErrorPaginaMod").removeClass().hide();
                $('#btnGuardarFirm').attr('disabled', false);
                //return true;
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }
    });

}

function cerrarModal() {

    $('#idFirmante').val('');
    $('#idURFirmModal').val('');
    $('#urFirmModal').val('SELECCIONA');
    $('#nombreAutorizaModal').val('');
    $('#puestoAutorizaModal').val('');
    $("#divErrorPaginaMod").removeClass().hide();

    $("#errorNombreAutorizaModal").text('');
    $("#errorNombreAutorizaModal").hide();
    $("#nombreAutorizaDivModal").removeClass("has-error");

    $("#errorPuestoAutorizaModal").text('');
    $("#errorPuestoAutorizaModal").hide();
    $("#puestoAutorizaDivModal").removeClass("has-error");

    $("#errorUrFirmModal").text('');
    $("#errorUrFirmModal").hide();
    $("#urFirmModalDiv").removeClass("has-error");

    $('#btnGuardarFirm').attr('disabled', false);
}



function validaDatos() {

    var datosValidos = true;
    var ur = $("#urFirmModal").val();
    var idUr = $('#idURFirmModal').val('');
    var nombreAutoriza = $("#nombreAutorizaModal").val();
    var puestoAutoriza = $("#puestoAutorizaModal").val();


    if (ur == null || ur == "") {
        $("#urFirmModalDiv").addClass("has-error");
        $("#errorUrFirmModal").text('');
        $("#errorUrFirmModal").show();
        $("#errorUrFirmModal").append("Campo obligatorio");
        datosValidos = false;
    }

    if (idUr == null || idUr == "") {
        $("#urFirmModalDiv").addClass("has-error");
        $("#errorUrFirmModal").text('');
        $("#errorUrFirmModal").show();
        $("#errorUrFirmModal").append("Campo obligatorio");
        datosValidos = false;
    }


    //if (nombreAutoriza === null || nombreAutoriza.length === 0) {
    if (nombreAutoriza === null || nombreAutoriza.trim() === '') {
        $("#nombreAutorizaDivModal").addClass("has-error");
        $("#errorNombreAutorizaModal").text('');
        $("#errorNombreAutorizaModal").show();
        $("#errorNombreAutorizaModal").append("Campo obligatorio");
        datosValidos = false;
    }

    //if (puestoAutoriza === null || puestoAutoriza.length === 0) {
    if (puestoAutoriza === null || puestoAutoriza.trim() === '') {
        $("#puestoAutorizaDivModal").addClass("has-error");
        $("#errorPuestoAutorizaModal").text('');
        $("#errorPuestoAutorizaModal").show();
        $("#errorPuestoAutorizaModal").append("Campo obligatorio");
        datosValidos = false;
    }

    if (nombreAutoriza.length > 0 && !validaSoloLetras(nombreAutoriza)) {
        $("#nombreAutorizaDivModal").addClass("has-error");
        $("#errorNombreAutorizaModal").text('');
        $("#errorNombreAutorizaModal").show();
        $("#errorNombreAutorizaModal").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }

    if (!validaSoloLetrasPuesto(puestoAutoriza) && puestoAutoriza.length > 0) {
        $("#puestoAutorizaDivModal").addClass("has-error");
        $("#errorPuestoAutorizaModal").text('');
        $("#errorPuestoAutorizaModal").show();
        $("#errorPuestoAutorizaModal").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }

    console.log('datosValidos es ' + datosValidos);

    return datosValidos;
}

function validaSoloLetrasPuesto(data) {
    var pattern = new RegExp('^[A-Z\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DC\u00FC\u00D1\u00F1\u0022\u0027\u003C\u003E\\-\_\\s]+$', 'i');
    console.log('valor reg --> ' + pattern.test(data));
    if (!pattern.test(data)) {  //Coincide con el formato general?
        console.log("false");
        return false;
    } else {
        console.log("true");
        return true;
    }//Validado
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

function limpiarEtiquetas() {


    $("#errorNombreAutorizaModal").text('');
    $("#errorNombreAutorizaModal").hide();
    $("#nombreAutorizaDivModal").removeClass("has-error");

    $("#errorPuestoAutorizaModal").text('');
    $("#errorPuestoAutorizaModal").hide();
    $("#puestoAutorizaDivModal").removeClass("has-error");

    $("#errorUrFirmModal").text('');
    $("#errorUrFirmModal").hide();
    $("#urFirmModalDiv").removeClass("has-error");

    //$('#btnGuardarFirm').attr('disabled', false);
}

function verificarUrInit() {
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/firmantes/verificaUR/" + $("#urFirm").val(),
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            if (response.respuesta == 'Si existe') {
                console.log('respuesta' + response.respuesta);
                $('#nuevoFirmante').attr('disabled', true);
                $("#divErrorPagina").removeClass().addClass("alert alert-warning").text('').append("Ya existe firmante para esta Unidad Responsable").show();
                //alert("No hay ning\u00FAn firmante asignado a esta Unidad Responsable, favor de verificar");
                return false;
            } else {
                $("#divErrorPagina").removeClass().hide();
                $('#nuevoFirmante').attr('disabled', false);
                return true;
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }
    });

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
            filePreview.width = 200;
            filePreview.height = 200;

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
