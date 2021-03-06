/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 $(function() {
     init();
 }); 
 
 function init(){      
    obtInmueble();
    //$('#cantidadEtiquetas').val(0); 
    //obtenerDatosRol();   
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
            var inmuebles = response;
            console.log("size: "+inmuebles);
            obtenerDatosRol(); 
            populateSelectInmueble(inmuebles);
                         
         },
         error: function (jqXHR, textStatus, errorThrown) {
             $('#mensajesError').html('<div class="alert alert-warning">No se encontraron registros</div>').show();
        }
     });
 }
 
function populateSelectInmueble(lstInmueble) {   
    document.getElementById("inmuebleID").options.length = 0;
    $('#inmuebleID').append('<option value="-1">SELECCIONA</option>');
    if (lstInmueble.length > 0) {
        for (var i = 0; i <= lstInmueble.length - 1; i++) {
            $('#inmuebleID').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
        }
    }
}
 
function obtenerDatosRol(){
    var vUrl = baseURI + '/mvc/seguridad/menu/obtenerUsuario';
    conectaPost(vUrl,"",resUsuario);
}

 function resUsuario(data){        
    var rolUsuario = data.idRol   
    $('#rolUsuario').val( rolUsuario );
    console.log("rol usuario : " + rolUsuario);
    if( rolUsuario !== 1 ){
        var idInmueble = data.idInmueble;                       
        $("#inmuebleID").prop('disabled', true);
        $('#inmuebleID  ').val( idInmueble );                
     }
 }
 
 
$(".soloNumeros").keydown(function(event) {
         
    // Desactivamos cualquier combinaci?n con shift
    if(event.shiftKey)
        event.preventDefault();

    //No permite mas de 7 caracteres Num?ricos
    if (event.keyCode != 46 && event.keyCode != 8 && event.keyCode != 9 && event.keyCode != 37 && event.keyCode != 39) 
        if($(this).val().length >= 7)
            event.preventDefault();

    // Solo Numeros del 0 a 9 
    if (event.keyCode < 48 || event.keyCode > 57)
        //Solo Teclado Numerico 0 a 9
        if (event.keyCode < 96 || event.keyCode > 105)

    if(event.keyCode != 46 && event.keyCode != 8 && event.keyCode != 9 && event.keyCode != 37 && event.keyCode != 39)
        event.preventDefault();
         
});
    

function obtenerUltimaEtiqueta( idInmueble ){   
    
    $("#errorInmueble").text('');
    $("#errorInmueble").hide();     
    $("#inmuebleDiv").removeClass("has-error");
    
    var opcion = $("input[name='impresionRadios']:checked").val();       
    if( opcion == 1 ){
        $('#cantidadEtiquetas').val('');
        return false;
    } else {
        $('#etiquetaInicial').val('');  
        $('#etiquetaFinal').val('');  
    }

    $('#loader').modal('toggle');
    
    var param = {};
    param["idInmueble"] = idInmueble;
    $.ajax({          
        url: baseURI +"/mvc/etiqueta/recuperarEtiqueta",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        data: param,
        cache: false,       
        success : function(data) {             
            $('#numEtiquetas').val(data);            
            $('#loader').modal('toggle');
        },
        error : function(jqXHR, textStatus, errorThrown) {             
            $('#loader').modal('toggle');    
        }
     });
}


$('#btnImprimir').click(function(){
    
    var opcion = $("input[name='impresionRadios']:checked").val(); 
    if( !validarDatos( opcion ) ){
        return false;
    }       
    
    var inmuebleId = $('#inmuebleID').val();
    var param = {};
    param["idInmueble"] = inmuebleId;
    
    if( opcion == 1 ){ //Impresion
        
        var cantidad = $('#cantidadEtiquetas').val();
        param["cantidad"] = cantidad;
        param["tipoOperacion"] = 1;
        
    } else {  //Reimpresion      
        var eInicial = $('#etiquetaInicial').val();
        var eFinal = $('#etiquetaFinal').val();   
        param["tipoOperacion"] = 2;
        param["etiquetaInicial"] = eInicial;
        param["etiquetaFinal"] = eFinal;        
    }      
    
    $('#loader').modal('toggle');
    document.getElementById("btnImprimir").disabled = true;
    $.ajax({
        url: baseURI + '/mvc/etiqueta/registrarEtiquetas',
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(param),
        dataType: "json",
        cache: false,
        success : function(data) {            
            var idInmueble = data.idInmueble;
            var etiquetasValidos = data.validos; 
            var etiquetasInvalidos = data.invalidos;            
            
            if( etiquetasInvalidos != null && etiquetasInvalidos != '' ){
                $("#txtResultado").text('Las etiquetas ' + etiquetasInvalidos + ' ya fueron asignados previamente');
                $("#resultadoOperacion").addClass("alert alert-success");
                $("#resultadoOperacion").show();
                setTimeout(function() {
                    $('#resultadoOperacion').fadeOut('fast');
                }, 8000);
            }
            if(etiquetasValidos != null && etiquetasValidos != ''){
                var etiquetas = etiquetasValidos.split(",");                
                window.document.location.href = baseURI + '/mvc/jasper/repEtiqueta?lstId=' + etiquetas + '&idInmueble=' + idInmueble;
            } 
            document.getElementById("btnImprimir").disabled = false;
            $('#loader').modal('toggle');
        },
        error : function(jqXHR, textStatus, errorThrown) {  
            document.getElementById("btnImprimir").disabled = false;
            $("#txtResultado").text('Se produjo un error al realizar el registro de etiquetas');
            $("#resultadoOperacion").addClass("alert alert-danger");
            $("#resultadoOperacion").show();
            setTimeout(function() {
                $('#resultadoOperacion').fadeOut('fast');
            }, 8000);
            $('#loader').modal('toggle');                 
        }
     });    
});


function limpiar(){
        
    var rolUsuario = $('#rolUsuario').val();    
    console.log('rolUsuairo: '+rolUsuario); 
    if( rolUsuario == 1){
        $('#inmuebleID').val(-1); 
        $("#errorInmueble").text('');
        $("#errorInmueble").hide();     
        $("#inmuebleDiv").removeClass("has-error");
        
        $('#numEtiquetas').val(0); 
    } 
        
    $('#cantidadEtiquetas').val('');        
    $("#errorCantidadEtiquetas").text('');
    $("#errorCantidadEtiquetas").hide();     
    $("#cantidadEtiquetasDiv").removeClass("has-error");    
    
    $('#etiquetaInicial').val('');        
    $("#errorEtiquetaInicial").text('');
    $("#errorEtiquetaInicial").hide();     
    $("#etiquetaInicialDiv").removeClass("has-error");

    $('#etiquetaFinal').val(''); 
    $("#errorEtiquetaFinal").text('');
    $("#errorEtiquetaFinal").hide();     
    $("#etiquetaFinalDiv").removeClass("has-error"); 
}


function validarDatos( opcion ){
    var datosValidos = true;
    
    var val3 = $('#inmuebleID').val();    
    if( val3 == -1  ){
        $("#inmuebleDiv").addClass("has-error");
        $("#errorInmueble").text('');
        $("#errorInmueble").show();
        $("#errorInmueble").append("El valor inmueble es requerido");
        datosValidos = false;
    }
    
    if( opcion == 1 ){
        
        var cantidad = $('#cantidadEtiquetas').val();
        if(cantidad == '' || parseInt(cantidad) < 1 ){
            $("#cantidadEtiquetasDiv").addClass("has-error");
            $("#errorCantidadEtiquetas").text('');
            $("#errorCantidadEtiquetas").show();
            if( cantidad == '')
                $("#errorCantidadEtiquetas").append("El valor del campo cantidad de etiquetas es requerido");
            else
                $("#errorCantidadEtiquetas").append("El valor del campo cantidad de etiquetas es incorrecto");
            datosValidos = false;
        }
        
        if( parseInt( cantidad ) > 500){
            $("#cantidadEtiquetasDiv").addClass("has-error");
            $("#errorCantidadEtiquetas").text('');
            $("#errorCantidadEtiquetas").show();
            $("#errorCantidadEtiquetas").append("Se permiten m\u00E1ximo 500 etiquetas");
            datosValidos = false;
        }
        
    } else {  
    
        var val1 = $('#etiquetaInicial').val();
        var val2 = $('#etiquetaFinal').val();
        var aux = $('#numEtiquetas').val();
                
        if(val1 == '' || parseInt(val1) < 1){
            $("#etiquetaInicialDiv").addClass("has-error");
            $("#errorEtiquetaInicial").text('');
            $("#errorEtiquetaInicial").show();
            $("#errorEtiquetaInicial").append("El valor etiqueta inicial es requerido");
            datosValidos = false;
        }

        if(val2 == ''){
            $("#etiquetaFinalDiv").addClass("has-error");
            $("#errorEtiquetaFinal").text('');
            $("#errorEtiquetaFinal").show();
            $("#errorEtiquetaFinal").append("El valor etiqueta final es requerido");
            datosValidos  = false;
        }

        if( val1 !== '' && val2 !== '' ){           
            
            if(parseInt(val1) > parseInt(val2)){                
                $("#etiquetaInicialDiv").addClass("has-error");
                $("#errorEtiquetaInicial").text('');
                $("#errorEtiquetaInicial").show();
                $("#errorEtiquetaInicial").append("El valor inicial no puede ser mayor al valor final");
                datosValidos = false;
            }
            
            if( parseInt(val2) >  parseInt(aux)){
                $("#etiquetaFinalDiv").addClass("has-error");
                $("#errorEtiquetaFinal").text('');
                $("#errorEtiquetaFinal").show();
                $("#errorEtiquetaFinal").append("El valor final no puede ser mayor a la cantidad de etiquetas generadas ");
                datosValidos  = false;
            }     
            
            if(parseInt( val2 ) > parseInt( val1 )){
                var cantidad =  parseInt(val2) - parseInt(val1);
                if( ( cantidad + 1 ) > 500 ){
                    alert('Se permiten m\u00E1ximo 500 etiquetas');
                    return false;
                }
            }
        }  
    }
    return datosValidos;
}


$("#impresion").click(function(){     
    $('#impresionDiv').css('display','block');
    $('#reimpresionDiv').css('display','none');
    limpiar();
});


$("#reimpresion").click(function(){
    $('#impresionDiv').css('display','none');
    $('#reimpresionDiv').css('display','block');
    limpiar();
    var idInmueble = $('#inmuebleID').val();
    if( idInmueble != -1){   
        console.log("obtener idEtiqueta...");
        obtenerUltimaEtiqueta( idInmueble );
    }  
});

$( '#cantidadEtiquetas' ).keyup(function () {   
    var val = this.value;
    if( val != '' && parseInt(val) > 0 ){
        $("#errorCantidadEtiquetas").text('');
        $("#errorCantidadEtiquetas").hide();     
        $("#cantidadEtiquetasDiv").removeClass("has-error");    
    }
});  

$( '#etiquetaInicial' ).keyup(function () {   
    var val = this.value;
    if( val != '' && parseInt(val) > 0 ){
        $("#errorEtiquetaInicial").text('');
        $("#errorEtiquetaInicial").hide();     
        $("#etiquetaInicialDiv").removeClass("has-error");        
    }
}); 

$( '#etiquetaFinal' ).keyup(function () {   
    var val = this.value;
    if( val != '' && parseInt(val) > 0 ){
        $("#errorEtiquetaFinal").text('');
        $("#errorEtiquetaFinal").hide();     
        $("#etiquetaFinalDiv").removeClass("has-error");   
    }
}); 