var checkedRows = [];

$( document ).ready(function() {
     $('#fecha').datepicker();
 });
 $("#foto").click(function(){
     $("#vista").attr("src", "bety.jpg")
 });

 $("#limpiar").click(function(){                  
    $('#curp').val('');
    $('#nombre').val('');
    $('#primerApellido').val('');
    $('#segundoApellido').val(''); 
    checkedRows = [];
    $('#resultadosResumenTable').bootstrapTable('destroy');
     
    $("#errorCurp").text('');
    $("#errorCurp").hide();     
    $("#curpDiv").removeClass("has-error");
    
    $("#errorNombre").text('');
    $("#errorNombre").hide();
    $("#nombreDiv").removeClass("has-error");
    
    $("#errorPaterno").text('');
    $("#errorPaterno").hide();
    $("#paternoDiv").removeClass("has-error");
    
    $("#errorMaterno").text('');
    $("#errorMaterno").hide();
    $("#maternoDiv").removeClass("has-error");
    
    $("#errorUr").text('');
    $("#errorUr").hide();
    $("#urDiv").removeClass("has-error");
    obtenerUR();
 });


function addInput(value, row, index) {  
    var input; 
    var estatus = row.estatus;
    if(estatus == 0){    
        input = '<input type=\'checkbox\' disabled=\'true\' value="'+row.idPersona+'" id="chk_' + row.idPersona + '">';
    }  else {
        input = '<input type=\'checkbox\' onchange=\'toggleCheckbox(this)\' value="'+row.idPersona+'" id="chk_' + row.idPersona + '">';
    }
    return input;
}


 $("#buscar").click(function(){    
     //object.configModule.standby.show();
     $("#errorCurp").text('');
    $("#errorCurp").hide();     
    $("#curpDiv").removeClass("has-error");
    
    $("#errorNombre").text('');
    $("#errorNombre").hide();
    $("#nombreDiv").removeClass("has-error");
    
    $("#errorPaterno").text('');
    $("#errorPaterno").hide();
    $("#paternoDiv").removeClass("has-error");
    
    $("#errorMaterno").text('');
    $("#errorMaterno").hide();
    $("#maternoDiv").removeClass("has-error");
    
    $("#errorUr").text('');
    $("#errorUr").hide();
    $("#urDiv").removeClass("has-error");
    if(!validarDatos()){
        return false;
    }
     var columnas = [
     {
         field : 'idPersona',
         title : 'Selecci\u00F3n para imprimir',
         align : 'center',
         formatter: addInput
     },    
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
         field : 'puesto',
         title : 'Puesto',
         align : 'center',
     },{
         field: 'operate',
         //title: 'Edit',
         align: 'center',
         valign: 'middle',
         clickToSelect: false,
          formatter: addbutton = function addbutton(value, row, index) {
             return '<button class=\'btn btn-primary btn-edit\' iduser="'+row.idPersona+'">Modificar</button> ';
         }
      }]
     $('#resultadosResumenTable').bootstrapTable({
         columns : columnas
     });
     $('#resultadosResumenTable').bootstrapTable('showLoading');
     var param = {};
//                param["idRol"] = $('#rol').val();
//                param["idInmueble"] = $('#inmueble').val();

    var idUr = $('#ur').val();
    if (idUr === "SELECCIONA") {
        idUr = 1000;
    }

     param["idTipoPersona"] = 2; //Tipo de Persona Proveedor
     param["idUr"] = idUr;
     param["curp"] = $('#curp').val();
     param["nombre"] = $('#nombre').val();
     param["primerApellido"] = $('#primerApellido').val();
     param["segundoApellido"] = $('#segundoApellido').val();
     $('#loader').modal('toggle');
     checkedRows = [];
     $.ajax({
         url: baseURI +"/mvc/persona/listEmpleado",
         type: 'GET',
         contentType: "application/json; charset=utf-8",
         data: param,
         //dataType: "json",
         cache: false,
     }).done(function(resumenInstancias) {
         //console.log(resumenInstancias)                
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

 $(function() {
     init();
 }); 

 function init(){
     //obtenerTipoPersona();       
     //obtInmueble();
     obtenerUR();     
     //usuarioRol();
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

 function obtenerUR()
 {
     $.ajax({
         type: "GET",
         cache: false,
         url: baseURI + "/mvc/catalogos/obtenerUR",
         contentType: "application/json; charset=utf-8",
         dataType: 'json',
         success: function (response) {
             //console.log(response);
             //console.log(response.length);
             //drawTableGeneric(response);
             if (response.length > 0) {
                 //console.log('if');
                 //console.log(response);
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

 function usuarioRol(){
         var vUrl = baseURI + '/mvc/seguridad/menu/obtenerUsuario';
         conectaPost(vUrl,"",resUsuario);
 }

 function resUsuario(data){
     var rol_usuario = data.idRol
     var idUr = data.idUr;
     if( rol_usuario == 2 ){
         $("#ur").prop('disabled', true);
         $('#ur').val(idUr);
     }
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

    document.getElementById("inmuebleID").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleID').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleID').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }

}

 function populateSelectUR(lstUR) {
     //console.log("POPULATING SELECT UR");
     //console.log(lstUR);
     document.getElementById("ur").options.length = 0;
     for (var i = 0; i <= lstUR.length - 1; i++) {
         if (i == 0 && lstUR.length >= 1) {
            $('#ur').append('<option>' + 'SELECCIONA' + '</option>');
        }
         $('#ur').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
     }

 }

 function populateSelectTipoPersona(lstTipoPersona) {
     //console.log("POPULATING SELECT TIPO PERSONA");
     //console.log(lstTipoPersona);
     document.getElementById("rol").options.length = 0;
     for (var i = 0; i <= lstTipoPersona.length - 1; i++) {
         $('#rol').append('<option value="' + lstTipoPersona[i].idTipoPersona + '">' + lstTipoPersona[i].tipoPersona + '</option>');
     }
 }

 /*$('#nuevoProveedor').click(function(){                
     location.href = baseURI + "/mvc/persona/nuevoProveedor";   
 });*/

 $('#resultadosResumenTable').on('click', '.btn-edit', function(){
     var idPersona = $(this).attr('iduser');
         //location.href = baseURI + "/mvc/persona/modificaProveedor?idPersona="+idPersona;   
         obtieneEmpleado(idPersona);
 });


$("#gafete").click(function(){
    if(checkedRows.length == 0){
         alert("Seleccione al menos un registro");
         return false;
     }
     
     verificaFirmante();
     
 });

 function resultadoImpresion(data){
     $('#loader').modal('toggle');
 }
 
 $('#resultadosResumenTable').on('page-change.bs.table', function (e, size, number)
{
    $.each(checkedRows, function (i, id) {        
        var vName = $('#chk_' + id).val();
        if( vName != 'undefined' && vName != null ){ 
            $('#chk_' + id).prop("checked", true);
        }
    });
});

function toggleCheckbox(element)
 {   
    //console.log(element.value); 
    var index = $.inArray(element.value,checkedRows);
    if( element.checked ){ 
        if( index == -1 ){        
            checkedRows.push(element.value);
        }                  
     } else {
        if( index !== -1 ){
            checkedRows.splice(index, 1);
        }
     }  
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
    if (!pattern.test(data)){          
        return false;
    }
    else{        
        return true; 
    }
}

function verificaFirmante(){
    $.ajax({
            type: "POST",
            cache: false,
            url: baseURI + "/mvc/persona/verificaFirmante/" + $("#ur").val(),
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            success: function (response) {
                if (response.respuesta !== 'Si existe') {
                    console.log('respuesta' + response.respuesta);
                    alert("No hay ning\u00FAn firmante asignado a esta Unidad Responsable, favor de verificar");
                    return false;
                }
                else{
                    window.document.location.href = baseURI + '/mvc/jasper/repCredencial?lstId=' + checkedRows;
                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('jqXHR.status:: ' + jqXHR.status);
                console.log('jqXHR.text:: ' + jqXHR.text);
                console.log('textStatus:: ' + textStatus);
            }
        });
    
}

function validarDatos(){
    var curp = $("#curp").val();
    var nombre = $("#nombre").val();
    var apPaterno = $("#primerApellido").val();
    var apMaterno = $("#segundoApellido").val();
    var ur = $('#ur').val();
    var datosValidos = true;
    
    
     if (ur === "SELECCIONA") {
        $("#urDiv").addClass("has-error");
        $("#errorUr").text('');
        $("#errorUr").show();
        $("#errorUr").append("Campo obligatorio");
        datosValidos = false;
    }
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
    if (apPaterno.length > 0 && !validaSoloLetras(apPaterno)) {  
        $("#paternoDiv").addClass("has-error");
        $("#errorPaterno").text('');
        $("#errorPaterno").show();
        $("#errorPaterno").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }
    if (apMaterno.length > 0 && !validaSoloLetras(apMaterno)) {  
        $("#maternoDiv").addClass("has-error");
        $("#errorMaterno").text('');
        $("#errorMaterno").show();
        $("#errorMaterno").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }    
    return datosValidos;
}

 function usuarioRolModal(){
         var vUrl = baseURI + '/mvc/seguridad/menu/obtenerUsuario';
         conectaPost(vUrl,"",resUsuarioModal);
 }
 
 function resUsuarioModal(data){
     var rol_usuario = data.idRol
     var idUr = data.idUr;                
     if( rol_usuario == 2 ){
         $("#urModal").prop('disabled', true);
         $('#urModal').val(idUr);
         $('#idUR').val(idUr);
         obtenerURMod(idUr);
     }
 }
 
 function resCuadrante(data) {

    $('#cuadrante').val(data);
    $('#cuadrante').val(data);

}

function verificarCurp() {
    
    //if (modo === "nuevo") {
        $.ajax({
            type: "POST",
            cache: false,
            url: baseURI + "/mvc/persona/verificaCurp/" + $("#curpModal").val(),
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            success: function (response) {
                if (response.respuesta !== ' ') {
                    console.log('respuesta' + response.respuesta);
                    alert(response.respuesta);
                    $('#ModalProveedor').modal('hide');

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
 
 
  function populateSelectUR1(lstUR) {
     //console.log("POPULATING SELECT UR");
     //console.log(lstUR);
     document.getElementById("urModal").options.length = 0;
     for (var i = 0; i <= lstUR.length - 1; i++) {
        if (i == 0 && lstUR.length >= 1) {
            $('#ur').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#ur').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
    }

 }
 
 function populateSelectTipoPersona(lstTipoPersona) {
     //console.log("POPULATING SELECT TIPO PERSONA");
     //console.log(lstTipoPersona);
     document.getElementById("rol").options.length = 0;
     for (var i = 0; i <= lstTipoPersona.length - 1; i++) {
         $('#rol').append('<option value="' + lstTipoPersona[i].idTipoPersona + '">' + lstTipoPersona[i].tipoPersona + '</option>');
     }
 }
 
  function obtieneEmpleado(idPersona) {
      $('#puesto').val('PROVEEDOR');
    $('.has-error').removeClass("has-error");
    $('#idPersona').val("");
    $('.has-error').removeClass("has-error");
    $("#errorCurpModal").text('');
    $("#errorNombreModal").text('');
    $("#errorPaternoModal").text('');
    $("#errorMaternoModal").text('');
    $("#errorInmueble").text('');
    $("#errorUrModal").text('');
    $("#errorCuadrante").text('');
    $("#errorPuesto").text('');
    $("#errorCorreo").text('');
    $("#errorEmergencia").text('');
    $("#errortipoSangre").text('');
    $("#errorAlergias").text('');
    $("#errorEnfermedad").text('');
    $("#errorEstatus").text('');
    document.getElementById("file-preview-zone").innerHTML = "";
    document.getElementById("imageBase").innerHTML = "";
    document.getElementById("formCarga").reset();
    document.getElementById("btnGuardar").disabled = false;
    //Obtiene el usuario de sesión
    console.log('obteniendo usuario');
    console.log('El idPersona para obtener es ' + idPersona);
    var cuadranteArea;
    var inmueble;
    var ur;
    $('#loader').modal('toggle');
    $.ajax({
        type: "POST",
        cache: false,
        url: baseURI + "/mvc/persona/obtieneEmpleado/" + idPersona,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (response) {
            if (response.idPersona !== '') {
                console.log('idPersona' + response.idPersona);
                $('#idPersona').val(response.idPersona);
                $('#curpModal').val(response.curp);
                $('#nombreModal').val(response.nombre);
                $('#primerApellidoModal').val(response.apellido1);
                $('#segundoApellidoModal').val(response.apellido2);
                $('#correoModal').val(response.correo);
                inmueble = response.idInmueble;

                if (response.idInmueble != null) {
                    obtInmuebleMod(inmueble);
                } else {
                    obtInmueble();
                }

                ur = response.idUr;


                $('#idUR').val(ur);
                console.log('ur es ' + ur);
                if (response.idUr != null) {
                    obtenerURMod(ur);
                } else {
                    obtenerUR();
                }
                usuarioRolModal();
                cuadranteArea = response.idCuadranteArea;
                if (response.idCuadranteArea != null) {
                    obtenerCuadranteS(response.idInmueble, cuadranteArea);
                }
                else {
                    populateSelectVacio();
                    $('#cuadrante').val('SELECCIONA');
                }

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
                if (response.estatus != null){
                    $('#estatus').val(response.estatus);
                }
                else{
                    $('#estatus').val('SELECCIONA');
                }
                $('#idFoto').val(response.fotografia);
                var fotografia = response.fotografia;
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
                $('#loader').modal('toggle');
                $('#ModalProveedor').modal('show');
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
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

function populateSelectVacio() {

    document.getElementById("cuadrante").options.length = 0;
    $('#cuadrante').append('<option>' + 'SELECCIONA' + '</option>');

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

function populateSelectSangre(lstSangre) {

    document.getElementById("tipoSangre").options.length = 0;
    for (var i = 0; i <= lstSangre.length - 1; i++) {
        if (i == 0 && lstSangre.length >= 1) {
            $('#tipoSangre').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#tipoSangre').append('<option value="' + lstSangre[i].idTipo + '">' + lstSangre[i].tipoSangre + '</option>');
    }

}

function bin2string(array) {
    var result = "";
    for (var i = 0; i < array.length; ++i) {
        result += (String.fromCharCode(array[i]));
    }
    return result;
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

function insertaProveedor() {
    console.log("BOTON DE CARGA");
    var doc = document.getElementById("cargaArchivo").value;
    console.log('doc es ' + doc);
    var idUr = document.getElementById("ur");
    var foto = document.getElementById("idFoto").value;
    console.log('ur es ' + document.getElementById("urModal").value);
    var vcfData = new FormData($('#formCarga')[0]);
    vcfData.append("urModal", document.getElementById("urModal").value);
    vcfData.append("puesto", "PROVEEDOR");
    if (validaDatos()) {
        document.getElementById("btnGuardar").disabled = true;
        if (foto === '') {
            console.log('foto esta vacia ' + foto);
            if (doc) {
                var imgsize = document.getElementsByClassName("subirimagen")[0].files[0].size;
                console.log('imgsize '+ imgsize);
                var jpgType = doc.search(".jpg");
                var jpegType = doc.search(".jpeg");
                if (jpgType != -1 || jpegType != -1) {
                    if (imgsize <= 10000000) {
                        console.log('imagen no pesada');
                        //$('#myModal').modal('show');
                        //document.forms["formCarga"].submit();
                        $.ajax({
                            type: "POST",
                            cache: false,
                            url: baseURI + "/mvc/persona/insertaProveedor",
                            data: vcfData,
                            processData: false, contentType: false,
                            method: "POST",
                            dataType: 'json',
                            success: function (reponse) {
                                
                                alert(reponse.msg);
                                $('#ModalProveedor').modal('hide');
                                console.log('despues');
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
                    else {
                        console.log('imagen pesada');
                        alert("La imagen no puede tener un tama\u00F1o superior a los 10 MB");
                        document.getElementById("btnGuardar").disabled = false;
                    }
                }
                else {
                    alert("Tipo de archivo inv\u00E1lido");
                    document.getElementById("btnGuardar").disabled = false;
                }
            }
            else {
                console.log("SELECIONE UN ARCHIVO");
                alert("Seleccione un archivo")
                
                document.getElementById("btnGuardar").disabled = false;
            }
        } else {
            console.log('foto no esta vacia');
            
            $.ajax({
                type: "POST",
                cache: false,
                url: baseURI + "/mvc/persona/insertaProveedor",
                data: vcfData,
                processData: false, contentType: false,
                method: "POST",
                dataType: 'json',
                success: function (reponse) {
                    
                    alert(reponse.msg)
                   $('#ModalProveedor').modal('hide');
                    console.log('despues');
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
}

function validaDatos() {

    var datosValidos = true;
    var curp = $("#curpModal").val();
    var nombre = $("#nombreModal").val();
    var apPaterno = $("#primerApellidoModal").val();
    var apMaterno = $("#segundoApellidoModal").val();
    var inmueble = $("#inmuebleID").val();
    var ur = $("#urModal").val();
    var cuadrante = $("#cuadrante").val();
    var tipoSangre = $("#tipoSangre").val();
    var emergencia = $("#emergencia").val();
    var alergias = $("#alergias").val();
    var enfermedad = $("#enfermedad").val();
    var puesto = $("#puesto").val();
    var estatus = $("#estatus").val();
    var correo = $("#correoModal").val();
    var idUr = document.getElementById("ur").value;
    var doc = document.getElementById("cargaArchivo").value;
    $('#idUR').val(idUr);

    /* if (doc) {
     
     }
     else {
     console.log("SELECIONE UN ARCHIVO");
     $('#myModal').modal('show');
     $("#myModal .modal-body").text('Seleccione un archivo');
     }*/

    if (curp === null || curp.length === 0) {
        $("#curpDivModal").addClass("has-error");
        $("#errorCurpModal").text('');
        $("#errorCurpModal").show();
        $("#errorCurpModal").append("Campo obligatorio");
        datosValidos = false;
    }

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
        $("#paternoDivModal").addClass("has-error");
        $("#errorPaternoModal").text('');
        $("#errorPaternoModal").show();
        $("#errorPaternoModal").append("Campo obligatorio");
        datosValidos = false;
    }
    
    if (correo === null || correo.length === 0) {
        $("#correoDiv").addClass("has-error");
        $("#errorCorreo").text('');
        $("#errorCorreo").show();
        $("#errorCorreo").append("Campo obligatorio");
        datosValidos = false;
    }
    
    if (validarEmail(correo) === false && correo.length > 0) {
       $("#correoDiv").addClass("has-error");
        $("#errorCorreo").text('');
        $("#errorCorreo").show();
        $("#errorCorreo").append("Formato inv&aacute;lido para el correo");
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
        $("#nombreDivModal").addClass("has-error");
        $("#errorNombreModal").text('');
        $("#errorNombreModal").show();
        $("#errorNombreModal").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }

    if (!validaSoloLetras(apPaterno) && apPaterno.length > 0) {
        $("#paternoDivModal").addClass("has-error");
        $("#errorPaternoModal").text('');
        $("#errorPaternoModal").show();
        $("#errorPaternoModal").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }
    if (!validaSoloLetras(apMaterno) && apMaterno.length > 0) {
        $("#maternoDivModal").addClass("has-error");
        $("#errorMaternoModal").text('');
        $("#errorMaternoModal").show();
        $("#errorMaternoModal").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }

   if(!validaSoloLetrasPuesto(puesto) && puesto.length > 0) {
        $("#puestoDiv").addClass("has-error");
        $("#errorPuesto").text('');
        $("#errorPuesto").show();
        $("#errorPuesto").append("&Uacute;nicamente debe contener caracteres alfab&eacute;ticos");
        datosValidos = false;
    }


    if (emergencia.length != 10 && emergencia.length > 0) {
        $("#emergenciaDiv").addClass("has-error");
        $("#errorEmergencia").text('');
        $("#errorEmergencia").show();
        $("#errorEmergencia").append("Debe contener 10 d&iacute;gitos");
        datosValidos = false;
    }

    if (emergencia.length === 0) {
        $("#emergenciaDiv").addClass("has-error");
        $("#errorEmergencia").text('');
        $("#errorEmergencia").show();
        $("#errorEmergencia").append("Campo obligatorio");
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
        $("#urDivModal").addClass("has-error");
        $("#errorUrModal").text('');
        $("#errorUrModal").show();
        $("#errorUrModal").append("Campo obligatorio");
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


    console.log('datosVlidos ess ' + datosValidos);

    return datosValidos;
}

function validaSoloNumeros(data) {
    var re = /^[0-9]+$/;
    if (data.match(re))  //Coincide con el formato general?
        return false;
    else
        return true; //Validado
}

function validaSoloLetrasPuesto(data) {
 var pattern = new RegExp('^[A-Z\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DC\u00FC\u00D1\u00F1\u0022\u0027\u003C\u003E\\-\_\\s]+$', 'i');
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
 
 $('#nuevoProveedor').click(function () {
    console.log('nuevoProveedor');
    
    //location.href = baseURI + "/mvc/persona/nuevoVisitante";
    document.getElementById("file-preview-zone").innerHTML = "";
    document.getElementById("imageBase").innerHTML = "";
    document.getElementById("formCarga").reset();
    $('#idPersona').val("");
    var valor = "PROVEEDOR";
    $('#puesto').val(valor);
    $('.has-error').removeClass("has-error");
    $("#errorCurpModal").text('');
    $("#errorNombreModal").text('');
    $("#errorPaternoModal").text('');
    $("#errorMaternoModal").text('');
    $("#errorInmueble").text('');
    $("#errorUrModal").text('');
    $("#errorCuadrante").text('');
    $("#errorPuesto").text('');
    $("#errorEmergencia").text('');
    $("#errortipoSangre").text('');
    $("#errorAlergias").text('');
    $("#errorEnfermedad").text('');
    $("#errorCorreo").text('');
    $("#errorEstatus").text('');
    document.getElementById("btnGuardar").disabled = false;
    obtenerUR1();
    obtInmueble1();
    usuarioRolModal();
    obtenertipoSangre();
    populateSelectVacio();
    $('#ModalProveedor').modal('show');
});

 function obtenerUR1()
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
                 populateSelectUR1(UR);
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


  function populateSelectUR1(lstUR) {
     //console.log("POPULATING SELECT UR");
     //console.log(lstUR);
     document.getElementById("urModal").options.length = 0;
     for (var i = 0; i <= lstUR.length - 1; i++) {
        if (i == 0 && lstUR.length >= 1) {
            $('#urModal').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#urModal').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
    }

 }
 
 
 function obtInmueble1()
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
                populateSelectInmueble1(inmuebles);
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

function populateSelectInmueble1(lstInmueble) {
    console.log('Inmueble1');
    document.getElementById("inmuebleID").options.length = 0;
    for (var i = 0; i <= lstInmueble.length - 1; i++) {
        if (i == 0 && lstInmueble.length >= 1) {
            $('#inmuebleID').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#inmuebleID').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
    }

}


function asignaUR() {
    var idUr = document.getElementById("urModal").value;
    $('#idUR').val(idUr);
    console.log('id Ur valorURmodal es ' + idUr);

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

function populateSelectCuadrante(lstCuadrante) {

    document.getElementById("cuadrante").options.length = 0;
    for (var i = 0; i <= lstCuadrante.length - 1; i++) {
        if (i == 0 && lstCuadrante.length >= 1) {
            $('#cuadrante').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#cuadrante').append('<option value="' + lstCuadrante[i].idCuadranteArea + '">' + lstCuadrante[i].cuadranteArea + '</option>');
    }

}

function populateSelectURMod(lstUR, idUr) {

    document.getElementById("urModal").options.length = 0;
    for (var i = 0; i <= lstUR.length - 1; i++) {
        if (i == 0 && lstUR.length >= 1) {
            $('#urModal').append('<option>' + 'SELECCIONA' + '</option>');
        }
        $('#urModal').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
    }
    $('#urModal').val(idUr);
}

function validarEmail(email) {
  const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  console.log('valida email' + re.test(email));
  if (!re.test(email)){
      return false;
  }
  else{
      return true;
  }
}

