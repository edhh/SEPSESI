/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var checkedRows = [];
var modo;
var listaEquipos = [];

$(document).ready(function () {
    $('#fecha').datepicker();
});
$("#foto").click(function () {
    $("#vista").attr("src", "bety.jpg")
});

$("#limpiar").click(function () {
    $('#curp').val('');
    $('#nombre').val('');
    checkedRows = [];
    $('#resultadosResumenTable').bootstrapTable('destroy');

    $("#errorCurp").text('');
    $("#errorCurp").hide();
    $("#curpDiv").removeClass("has-error");

    $("#errorNombre").text('');
    $("#errorNombre").hide();
    $("#nombreDiv").removeClass("has-error");
});

function validarDatos() {
    var curp = $("#curp").val();
    var nombre = $("#nombre").val();

    var datosValidos = true;

    if ( curp.length > 0 && curpV(curp) ) {   
        $("#curpDiv").addClass("has-error");
        $("#errorCurp").text('');
        $("#errorCurp").show();
        $("#errorCurp").append("Formato inv&aacute;lido para la CURP");
        datosValidos = false;
    }
    if (nombre.length > 0 && !validaSoloLetras(nombre)) {
        $("#nombreDiv").addClass("has-error");
        $("#errorNombre").text('');
        $("#errorNombre").show();
        $("#errorNombre").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }
    return datosValidos;
}

function addInput(value, row, index) {
    var input;
    var estatus = row.estatus;
    if (estatus == 0) {
        input = '<input type=\'checkbox\' disabled=\'true\' value="' + row.idVisitante + '" id="chk_' + row.idVisitante + '">';
    } else {
        input = '<input type=\'checkbox\' onchange=\'toggleCheckbox(this)\' value="' + row.idVisitante + '" id="chk_' + row.idVisitante + '">';
    }
    return input;
}

 $("#buscar").click(function(){    
    //object.configModule.standby.show();
    if(!validarDatos()){
        return false;
    }
    var columnas = [
        {
         field : 'curp',
         title : 'CURP',
         align : 'center'
        }, {
         field : 'nombre',
         title : 'Nombre',
         align : 'center'
        }, {
         field : 'apellido1',
         title : 'Primer Apellido',
         align : 'center',
     },{
         field : 'apellido2',
         title : 'Segundo Apellido',
         align : 'center'
        }, {
         field : 'denominacion',
         title : 'Inmueble',
         align : 'center',
     },{
         field : 'unidadResponsable',
         title : 'UR',
         align : 'center'
     },{
            field: 'operate',
            //title: 'Edit',
            align: 'center',
            valign: 'middle',
            clickToSelect: false,
          formatter: addbutton = function addbutton(value, row, index) {
             return '<button class=\'btn btn-primary btn-edit\' idVisitante="'+row.idVisitante + '">Modificar</button> ';
            }
        }]
    $('#resultadosResumenTable').bootstrapTable({
         columns : columnas
    });
    $('#resultadosResumenTable').bootstrapTable('showLoading');
    var param = {};
    //param["idTipoPersona"] = 3; //Tipo de Persona Visitante
    param["idUr"] = $('#idUrB').val();
    param["curp"] = $('#curp').val();
    param["nombre"] = $('#nombre').val();

    $('#loader').modal('toggle');
    checkedRows = [];
    $.ajax({
        url: baseURI + "/mvc/persona/listVisitante",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        data: param,
        //dataType: "json",
        cache: false,
     }).done(function(resumenInstancias) {
        //console.log(resumenInstancias);                
        $('#resultadosResumenTable').bootstrapTable('destroy');
        $('#resultadosResumenTable').bootstrapTable({
             pagination : true,
             paginationHAlign : 'left',
             paginationDetailHAlign : 'right',
            classes: 'table table-bordered table-hover',
             striped : true,
             pageList : [],
             columns : columnas,
             data : resumenInstancias
        });
        $('#loader').modal('toggle');
     }).fail(function() {
        $('#loader').modal('toggle');
    });
});

$(function () {
    init();
});

function init() {
    usuarioRol();
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

function usuarioRol() {
    var vUrl = baseURI + '/mvc/seguridad/menu/obtenerUsuario';
    conectaPost(vUrl, "", resUsuario);
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

function obtenerCuadranteSeguridad(idInmueble)
{
    //var inmueble = $("#inmuebleID").val();

    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/catalogos/obtenerCuadrante/" + idInmueble,
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
                //usuarioRol();
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

    document.getElementById("ur").options.length = 0;
    for (var i = 0; i <= lstUR.length - 1; i++) {
        if (i == 0 && lstUR.length >= 1) {
            $('#ur').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#ur').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].abreviatura + " - " + lstUR[i].unidadResponsable + '</option>');
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


function resUsuario(data) {
    var rol_usuario = data.idRol
    var idInmueble = data.idInmueble;
    console.log('idUr es ' + idInmueble);
    if (rol_usuario == 3) {
        $("#inmuebleID").prop('disabled', true);
        $('#inmuebleID').val(idInmueble);
        $('#idUrB').val(idInmueble);
        obtInmuebleMod(idInmueble);
        obtenerCuadranteSeguridad(idInmueble);
    }
}


$('#nuevoVisitante').click(function () {
    console.log('nuevoVisitante');
    //location.href = baseURI + "/mvc/persona/nuevoVisitante";
    document.getElementById("file-preview-zone").innerHTML = "";
    document.getElementById("imageBase").innerHTML = "";
    document.getElementById("formCarga").reset();
    $('#idVisitante').val("");
    $('.has-error').removeClass("has-error");
    $("#errorCurpModal").text('');
    $("#errorNombreModal").text('');
    $("#errorPaterno").text('');
    $("#errorMaterno").text('');
    $("#errorInmueble").text('');
    $("#errorUr").text('');
    $("#errorCuadrante").text('');
    $("#errorpersonaV").text('');
    $("#errornumEtiqueta").text('');
    obtenerUR();
    obtInmueble();
    usuarioRol();
    //var table = document.getElementById('tbody');
    //table.innerHTML = '';
    $('#ModalVisitantes').modal('show');
});

function asignaUR() {
    var idUr = document.getElementById("ur").value;
    $('#idUR').val(idUr);
    console.log('id Ur valorUR es ' + idUr);

}

$('#resultadosResumenTable').on('click', '.btn-edit', function () {
    var idVisitante = $(this).attr('idVisitante');
    obtieneVisitante(idVisitante);
    modo = 'editar';
});

function obtieneVisitante(idVisitante) {
    $('.has-error').removeClass("has-error");
    $("#errorCurpModal").text('');
    $("#errorNombreModal").text('');
    $("#errorPaterno").text('');
    $("#errorMaterno").text('');
    $("#errorInmueble").text('');
    $("#errorUr").text('');
    $("#errorCuadrante").text('');
    $("#errorpersonaV").text('');
    $("#errornumEtiqueta").text('');
    $('#idVisitante').val("");
    document.getElementById("formCarga").reset();
    var cuadranteArea;
    var inmueble;
    var ur;
    var fotografia;
    $('#loader').modal('toggle');
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/persona/obtieneVisitante/" + idVisitante,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            if (response.idVisitante !== '') {
                $('#idVisitante').val(response.idVisitante);
                $('#curpModal').val(response.curp);
                $('#nombreModal').val(response.nombre);
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
                
                cuadranteArea = response.idCuadranteArea;
                if (response.idCuadranteArea != null) {
                    obtenerCuadranteS(response.idInmueble, cuadranteArea);
                }
                else {
                    populateSelectVacio();
                }

                $('#cuadrante').val(response.idCuadranteArea);
                $('#puesto').val(response.puesto);


                $('#emergencia').val(response.telEmergencia);
                $('#alergias').val(response.alergias);
                $('#correo').val(response.email);
                $('#enfermedad').val(response.enfermedad);
                $('#personaV').val(response.personaVisita);
                $('#numEtiqueta').val(response.idEtiqueta);
                $('#idFoto').val(response.fotografia);
                fotografia = response.fotografia;
                if (fotografia === null) {
                    document.getElementById("imageBase").innerHTML = "";
                }
                 else {
                    
                    document.getElementById("imageBase").innerHTML = "";
                    var ItemPreview = document.createElement('img');
                    ItemPreview.id = 'item-preview';
                    //e.target.result contents the base64 data from the image uploaded
                    ItemPreview.src = "data:image/jpg;base64," + fotografia;
                    ItemPreview.width = 400;
                    ItemPreview.height = 300;

                    var previewZone = document.getElementById('imageBase');
                    previewZone.appendChild(ItemPreview);
                }
                var re = /"/g;
                
                if (response.equiposVisitante != null){
                    var table = document.getElementById('tbody');

                    //table.innerHTML = '';
                    for (var i=0; i< response.equiposVisitante.length; i++){
                        $('#tbody').append(`<tr id="${++rowIdx}">
                            <td class="row-index text-center" contenteditable="false">
                            <input type=\checkbox\ id="chk" ${response.equiposVisitante[i].estatusS}></td>
                        <td class="row-index text-center" contenteditable="true">
                        ${response.equiposVisitante[i].marcaVis}
                        </td>
                        <td class="row-index text-center" contenteditable="true">
                        ${response.equiposVisitante[i].numeroSerieVis}
                            </td>
                        <td class="row-index text-center" contenteditable="true">
                        ${response.equiposVisitante[i].descripcionEquipoVis}
                        </td>

                        </tr>`);
                    }
                }
                else{
                    var table = document.getElementById('tbody');

                    //table.innerHTML = '';
                }
                
               
               
                $('#loader').modal('toggle');
                $('#ModalVisitantes').modal('show');
            }
            
           
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }
    });

}

function insertaVisitantes() {
    var vcfData = new FormData($('#formCarga')[0]);
    var inmueble = document.getElementById("inmuebleID");
    var inmuebleValue = inmueble.value;
    console.log('inmueble es ' + inmueble);
    vcfData.append("inmuebleID", inmuebleValue);
    var doc = document.getElementById("cargaArchivo").value;

    var idUr = document.getElementById("ur");
    var idUrValue = idUr.value;
    var idVisitante = document.getElementById("idVisitante");

    var foto = document.getElementById("idFoto").value;
    if (validaDatos()) {
        document.getElementById("btnGuardar").disabled = true;
        vcfData.append("listaEquipos", listaEquipos);
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
                            url: baseURI + "/mvc/persona/insertaVisitante",
                            data: vcfData,
                            processData: false, contentType: false,
                            method: "POST",
                            dataType: 'json',
                            success: function (reponse) {

                                var respuesta = reponse.msg;
                                if (respuesta === '1') {
                                    alert("No se encuentra registrado ese n\u00FAmero de etiqueta");
                                }
                                else if (respuesta === '2') {
                                    alert("Ya est\u00E1 asignada ese n\u00FAmero de etiqueta, selecciona otra");
                                }
                                else {
                                    if (idVisitante != null){
                                        alert(respuesta);
                                        $('#ModalVisitantes').modal('hide');
                                    }
                                    else{
                                        insertaEquipoVisitantes();
                                    }
                                    
                                }

                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                alert("Ocurri\u00F3 un error al registrar los datos");
                                console.log('jqXHR.status:: ' + jqXHR.status);
                                console.log('jqXHR.text:: ' + jqXHR.text);
                                console.log('textStatus:: ' + textStatus);
                            }
                        });
                    }
                    else {
                        alert("La imagen no puede tener un tama\u00F1o superior a los 10 MB");
                        document.getElementById("btnGuardar").disabled = false;
                    }
                }
                else {
                    alert("Tipo de archivo inv\u00E1lido")
                    document.getElementById("btnGuardar").disabled = false;
                }
            } else {
                $.ajax({
                    type: "POST",
                    cache: false,
                    url: baseURI + "/mvc/persona/insertaVisitante",
                    data: vcfData,
                    processData: false, contentType: false,
                    method: "POST",
                    dataType: 'json',
                    success: function (reponse) {

                        var respuesta = reponse.msg;
                        if (respuesta === '1') {
                            alert("No se encuentra registrado ese n\u00FAmero de etiqueta");
                        }
                        else if (respuesta === '2') {
                            alert("Ya est\u00E1 asignada ese n\u00FAmero de etiqueta, selecciona otra");
                        }
                        else {
                            if (idVisitante != null){
                                        alert(respuesta);
                                        $('#ModalVisitantes').modal('hide');
                                    }
                                    else{
                                        insertaEquipoVisitantes();
                                    }
                        }

                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        //$('#loader').modal('toggle');
                        alert("Ocurri\u00F3 un error al registrar los datos");
                        /*$('#myModal1').modal('show');
                         $("#myModal1 .modal-body").text('Ocurri\u00F3 un error al registrar los datos');*/
                        console.log('jqXHR.status:: ' + jqXHR.status);
                        console.log('jqXHR.text:: ' + jqXHR.text);
                        console.log('textStatus:: ' + textStatus);
                    }
                });
            }
        } else {
            $.ajax({
                type: "POST",
                cache: false,
                url: baseURI + "/mvc/persona/insertaVisitante",
                data: vcfData,
                processData: false, contentType: false,
                method: "POST",
                dataType: 'json',
                success: function (reponse) {

                    var respuesta = reponse.msg;
                    if (respuesta === '1') {
                        alert("No se encuentra registrado ese n\u00FAmero de etiqueta");
                    }
                    else if (respuesta === '2') {
                        alert("Ya est\u00E1 asignada ese n\u00FAmero de etiqueta, selecciona otra");
                    }
                    else {
                        if (idVisitante != null){
                                        alert(respuesta);
                                        $('#ModalVisitantes').modal('hide');
                                    }
                                    else{
                                        insertaEquipoVisitantes();
                                    }
                    }
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

    document.getElementById("btnGuardar").disabled = false;


    //}
}

function insertaEquipoVisitantes() {
    var vcfData = new FormData($('#formCarga')[0]);
    var inmueble = document.getElementById("inmuebleID");
    var inmuebleValue = inmueble.value;
    console.log('inmueble es ' + inmueble);
    vcfData.append("inmuebleID", inmuebleValue);
    var doc = document.getElementById("cargaArchivo").value;

    var idUr = document.getElementById("ur");
    var idUrValue = idUr.value;

    var foto = document.getElementById("idFoto").value;
    if (validaDatos()) {
        document.getElementById("btnGuardar").disabled = true;
        vcfData.append("listaEquipos", listaEquipos);

                        $.ajax({
                            type: "POST",
                            cache: false,
                            url: baseURI + "/mvc/persona/insertaEquipoVisitante",
                            data: vcfData,
                            processData: false, contentType: false,
                            method: "POST",
                            dataType: 'json',
                            success: function (reponse) {

                                var respuesta = reponse.msg;
                                if (respuesta === '1') {
                                    alert("No se encuentra registrado ese n\u00FAmero de etiqueta");
                                }
                                else if (respuesta === '2') {
                                    alert("Ya est\u00E1 asignada ese n\u00FAmero de etiqueta, selecciona otra");
                                }
                                else {
                                    alert(respuesta);
                                    $('#ModalVisitantes').modal('hide');
                                }

                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                alert("Ocurri\u00F3 un error al registrar los datos");
                                console.log('jqXHR.status:: ' + jqXHR.status);
                                console.log('jqXHR.text:: ' + jqXHR.text);
                                console.log('textStatus:: ' + textStatus);
                            }
                        });
                    }            
        

    

    document.getElementById("btnGuardar").disabled = false;


    //}
}


function verificarCurp() {
    console.log('modo es ' + modo);
    if (modo === "undefined") {
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

function validaDatos() {

    var datosValidos = true;
    var curp = $("#curpModal").val();
    var nombre = $("#nombreModal").val();
    var apPaterno = $("#primerApellido").val();
    var apMaterno = $("#segundoApellido").val();
    var inmueble = $("#inmuebleID").val();
    var ur = $("#ur").val();
    var cuadrante = $("#cuadrante").val();
    var numEtiqueta = $("#numEtiqueta").val();

    var personaVisita = $("#personaV").val();
    var idUr = document.getElementById("ur").value;
    var checkbox;
    $('#idUR').val(idUr);
    
    $('#fragmenterTable').find("td").each(function() {
        var field = $(this).html(); 
        if(field.includes("<input")){
            var isChecked = document.getElementById('chk').checked;
            if(isChecked){
                field = "1";
            }
            else{
                field = "0";
            }
            listaEquipos.push(field);
        }
        else{
            listaEquipos.push(field);
        }
        console.log(field);
        
    });
    
    
    var longitudLista = listaEquipos.length;
    for (i=0; i< longitudLista; i++){
       /*if ((listaEquipos[1] === null || listaEquipos[1] === "" || listaEquipos[1].trim() === '') || (listaEquipos[5] === null || listaEquipos[5] === "" || listaEquipos[5].trim() === '')  || (listaEquipos[9] === null || listaEquipos[9] === "" || listaEquipos[9].trim() === '') || (listaEquipos[13] === null || listaEquipos[13] === "" || listaEquipos[13].trim() === '') || (listaEquipos[17] ===null || listaEquipos[17] === "" || listaEquipos[17].trim() === '')){
           console.log('equipos ' + listaEquipos[i]);
            alert ('Es obligatorio registrar la marca');
           return;
       }
       if ((listaEquipos[2] === null || listaEquipos[2] === "" || listaEquipos[2].trim() === '') || (listaEquipos[6] === null || listaEquipos[6] === "" || listaEquipos[6].trim() === '')  || (listaEquipos[10] === null || listaEquipos[10] === "" || listaEquipos[10].trim() === '') || (listaEquipos[14] === null || listaEquipos[14] === "" || listaEquipos[14].trim() === '') || (listaEquipos[18] ===null || listaEquipos[18] === "" || listaEquipos[18].trim() === '')){
           console.log('equipos ' + listaEquipos[i]);
            alert ('Es obligatorio registrar el n\u00FAmero de serie');
           return;
       }
       if ((listaEquipos[3] === null || listaEquipos[3] === "" || listaEquipos[3].trim() === '') || (listaEquipos[7] === null || listaEquipos[7] === "" || listaEquipos[7].trim() === '')  || (listaEquipos[11] === null || listaEquipos[11] === "" || listaEquipos[11].trim() === '') || (listaEquipos[15] === null || listaEquipos[15] === "" || listaEquipos[15].trim() === '') || (listaEquipos[19] ===null || listaEquipos[19] === "" || listaEquipos[19].trim() === '')){
           console.log('equipos ' + listaEquipos[i]);
            alert ('Es obligatorio registrar la descripci\u00F3n');
           return;
       }*/
       if (listaEquipos[i] === null || listaEquipos[i] === "" || listaEquipos[i].trim() === ''){
           alert ('Es obligatorio registrar todos los datos de equipos de computo');
           return;
       }
    }


//    if (curp === null || curp.length === 0) {
//        $("#curpDivModal").addClass("has-error");
//        $("#errorCurpModal").text('');
//        $("#errorCurpModal").show();
//        $("#errorCurpModal").append("Campo obligatorio");
//        datosValidos = false;
//    }

    if (curpV(curp) && curp.length > 0) {
        $("#curpDivModal").addClass("has-error");
        $("#errorCurpModal").text('');
        $("#errorCurpModal").show();
        $("#errorCurpModal").append("Formato inv&aacute;lido para la CURP");
        datosValidos = false;
    }

    if (nombre === null || nombre.length === 0) {
        $("#nombreDivModal").addClass("has-error");
        $("#errorNombreModal").text('');
        $("#errorNombreModal").show();
        $("#errorNombreModal").append("Campo obligatorio");
        datosValidos = false;
    }

    if (apPaterno === null || apPaterno.length === 0) {
        $("#paternoDiv").addClass("has-error");
        $("#errorPaterno").text('');
        $("#errorPaterno").show();
        $("#errorPaterno").append("Campo obligatorio");
        datosValidos = false;
    }

    if (nombre.length > 0 && !validaSoloLetras(nombre)) {
        $("#nombreDivModal").addClass("has-error");
        $("#errorNombreModal").text('');
        $("#errorNombreModal").show();
        $("#errorNombreModal").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
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

    if (!validaSoloLetras(personaVisita) && personaVisita.length > 0) {
        $("#perviDiv").addClass("has-error");
        $("#errorpersonaV").text('');
        $("#errorpersonaV").show();
        $("#errorpersonaV").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }
    if (inmueble === "SELECCIONA") {
        $("#inmuebleDiv").addClass("has-error");
        $("#errorInmueble").text('');
        $("#errorInmueble").show();
        $("#errorInmueble").append("Campo obligatorio");
        datosValidos = false;
    }

    if (validaSoloNumeros(numEtiqueta) && numEtiqueta.length > 0) {
        $("#etiquetaDiv").addClass("has-error");
        $("#errornumEtiqueta").text('');
        $("#errornumEtiqueta").show();
        $("#errornumEtiqueta").append("&Uacute;nicamente debe contener caracteres num&eacute;ricos");
        datosValidos = false;
    }

    if (numEtiqueta.length === 0) {
        $("#etiquetaDiv").addClass("has-error");
        $("#errornumEtiqueta").text('');
        $("#errornumEtiqueta").show();
        $("#errornumEtiqueta").append("Campo obligatorio");
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

    console.log('datosVlidos ess ' + datosValidos);

    return datosValidos;
}

function curpV(curp) {
    if (curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9a-z]{1}[0-9]{1})$/i)) {//AAAA######AAAAAAA-##
        return false;
    } else {
        return true;
    }
}

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


function validaSoloNumeros(data) {
    var re = /^[0-9]+$/;
    if (data.match(re))  //Coincide con el formato general?
        return false;
    else
        return true; //Validado
}

$("#gafete").click(function () {

    if (checkedRows.length == 0) {
        alert("Seleccione al menos un registro");
        return false;
    }

    window.document.location.href = baseURI + '/mvc/jasper/repEtiqueta?lstId=' + checkedRows;

});

function resultadoImpresion(data) {
    $('#loader').modal('toggle');
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

    document.getElementById("ur").options.length = 0;
    for (var i = 0; i <= lstUR.length - 1; i++) {
        if (i == 0 && lstUR.length >= 1) {
            $('#ur').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#ur').append('<option value="' + lstUR[i].idUr + '">' +  lstUR[i].abreviatura +  " - "  +  lstUR[i].unidadResponsable + '</option>');
    }
    $('#ur').val(idUr);
}


function obtenerCuadranteS(inmuebleID, idCuadrante)
{
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

function bin2string(array) {
    var result = "";
    for (var i = 0; i < array.length; ++i) {
        result += (String.fromCharCode(array[i]));
    }
    return result;
}


$('#resultadosResumenTable').on('page-change.bs.table', function (e, size, number)
{
    $.each(checkedRows, function (i, id) {
        var vName = $('#chk_' + id).val();
        if (vName != 'undefined' && vName != null) {
            $('#chk_' + id).prop("checked", true);
        }
    });
});

function toggleCheckbox(element)
{
    console.log(element.value);
    var index = $.inArray(element.value, checkedRows);
    if (element.checked) {
        if (index == -1) {
            checkedRows.push(element.value);
        }
    } else {
        if (index !== -1) {
            checkedRows.splice(index, 1);
        }
    }
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

function verificarCurp() {
    console.log('verificarCurp');
        $.ajax({
            type: "POST",
            cache: false,
            url: baseURI + "/mvc/persona/verificaCurpVisitante/" + $("#curpModal").val(),
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            success: function (response) {
                if (response.respuesta !== ' ') {
                    console.log('respuesta' + response.respuesta);
                    alert(response.respuesta);
                     $('#ModalVisitantes').modal('hide');
                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('jqXHR.status:: ' + jqXHR.status);
                console.log('jqXHR.text:: ' + jqXHR.text);
                console.log('textStatus:: ' + textStatus);
            }
        });
    
}

var rowIdx = 0;

function agregar(){
  
    // Adding a row inside the tbody.
    $('#tbody').append(`<tr id="R${++rowIdx}">
          <td class="row-index text-center" contenteditable="false"> 
                <input type=\checkbox\ id="chk"></td>
    <td class="row-index text-center" contenteditable="true" <span style="text-transform:uppercase;"> </span>
                </td>
    <td class="row-index text-center" contenteditable="true" <span style="text-transform:uppercase;"> </span>
                </td>
    <td class="row-index text-center" contenteditable="true" <span style="text-transform:uppercase;"> </span>
                </td>
           
           </tr>`);
}

 $('#tbody').on('click', '.remove', function () {
  
        // Getting all the rows next to the row
        // containing the clicked button
        var child = $(this).closest('tr').nextAll();
  
        // Iterating across all the rows 
        // obtained to change the index
        child.each(function () {
  
          // Getting <tr> id.
          var id = $(this).attr('id');
  
          // Getting the <p> inside the .row-index class.
          var idx = $(this).children('.row-index').children('p');
  
          // Gets the row number from <tr> id.
          var dig = parseInt(id.substring(1));
  
          // Modifying row index.
          idx.html(`Row ${dig - 1}`);
  
          // Modifying row id.
          $(this).attr('id', `R${dig - 1}`);
        });
  
        // Removing the current row.
        $(this).closest('tr').remove();
  
        // Decreasing total number of rows by 1.
        rowIdx--;
      });
  

function pregunta_Validar_Campos() {

  // selecciona TODOS los campos por clase
  /*const nomapes = document.querySelectorAll(".nomape_nosocio");
  const dnis = document.querySelectorAll(".dni_nosocio");*/
  
  // los convertimos a un array bidimensional
  // el primer elemento sera un array con los nombres
  // el segundo elemento sera un array con los dnis
  /*aArray = [
    [...nomapes].map(el => el.value),
    [...dnis].map(el => el.value)
  ];
  
  var table = document.getElementById("table");
  console.log('table es ' + table);
  var rowCount = table.rows.length;

  for (var i = 0; i < rowCount - 1; i++) {
    for (var j = 0; j < aArray.length; j++) {*/

      // adem?s de la columna, tambi?n quieres leer la fila! aArray[j][i] en lugar de aArray[j]
      /*document.write("El valor de la posici?n [" + i + "][" + j + "] es [" + aArray[j][i] + "]<br/>");
    }
  }

  if (confirm('Los datos ser?n guardados en la Base de Datos. ?Est?s seguro de realizar esta acci?n?')) {
    document.Actualizar.submit()
  }*/
    /*var dadosTabela = $("#fragmenterTable").bootstrapTable("getData").length;;
    console.log('datos ' + dadosTabela);*/
    //alert(JSON.stringify($('#fragmenterTable').bootstrapTable('getData')));
    /*var tabla=document.getElementsByTagName("td");
    var numeros=[];
    for (var i=0; i<tabla.length; i++){
		numeros.push(parseInt(tabla[i].innerHTML));
	}
    console.log('numeros ' + numeros);*/
    
    $('#fragmenterTable').find("td").each(function() {
        var field = $(this).html(); 
        listaEquipos.push(field);
    });
    
    
    
    if( $('#chk').is(':checked') ) {
    alert('checkbox1 esta Seleccionado');
    }
    
    
    
}   

/*$('#fragmenterTable').on('click-cell.bs.table', function (field, value, row, $el) {???????
                            console.log("CLICK"+ value);
                            console.log($el);
                        
                    });*/
