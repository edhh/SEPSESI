
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
                $('#resultadosResumenTable').bootstrapTable('destroy');
            });
            
            function addInput(value, row, index) {  
                return  '<input class=\'chk\' type=\'checkbox\' value="'+row.idPersona+'" id="chk_' + row.idPersona + '">';
            }
            
            $("#buscar").click(function(){    
                //object.configModule.standby.show();
                var columnas = [
                {
                    field : 'seleccion',
                    title : 'Selecci\u00F3n',
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
                    formatter : addbutton = (value,row,index) =>{
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
                param["idUr"] = $('#ur').val();
                param["curp"] = $('#curp').val();
                param["nombre"] = $('#nombre').val();
                param["primerApellido"] = $('#primerApellido').val();
                param["segundoApellido"] = $('#segundoApellido').val();
                $('#loader').modal('toggle');
        	$.ajax({
                    url: baseURI +"/mvc/persona/listEmpleado",
                    type: 'GET',
                    contentType: "application/json; charset=utf-8",
                    data: param,
                    //dataType: "json",
                    cache: false,
		}).done(function(resumenInstancias) {
                    console.log(resumenInstancias)                
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
                usuarioRol();
            }            
            
            function usuarioRol(){
                    var vUrl = baseURI + '/mvc/seguridad/menu/obtenerUsuario';
                    conectaPost(vUrl,"",resUsuario);
            }

            function resUsuario(data){
                var rol_usuario = data.idRol
                if( rol_usuario == 2 ){
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
                document.getElementById("inmueble").options.length = 0;
                for (var i = 0; i <= lstInmueble.length - 1; i++) {
                    $('#inmueble').append('<option value="' + lstInmueble[i].idInmueble + '">' + lstInmueble[i].denominacion + '</option>');
                }
            }

            function populateSelectUR(lstUR) {
                console.log("POPULATING SELECT UR");
                console.log(lstUR);
                document.getElementById("ur").options.length = 0;
                for (var i = 0; i <= lstUR.length - 1; i++) {
                    $('#ur').append('<option value="' + lstUR[i].idUr + '">' + lstUR[i].unidadResponsable + '</option>');
                }

            }

            function populateSelectTipoPersona(lstTipoPersona) {
                console.log("POPULATING SELECT TIPO PERSONA");
                console.log(lstTipoPersona);
                document.getElementById("rol").options.length = 0;
                for (var i = 0; i <= lstTipoPersona.length - 1; i++) {
                    $('#rol').append('<option value="' + lstTipoPersona[i].idTipoPersona + '">' + lstTipoPersona[i].tipoPersona + '</option>');
                }
            }

            $('#resultadosResumenTable').on('click', '.btn-edit', function(){
                var idPersona = $(this).attr('iduser');
                    location.href = baseURI + "/mvc/persona/modificaEmpleado?idPersona="+idPersona;   
            });
            
            
            $("#gafete").click(function(){
               var seleccionados = []; 
               $("input:checkbox[class=chk]:checked").each(function () {
                    //seleccionados.push( $(this).attr("id") );                    
                    seleccionados.push( $(this).val() );
                });                        
               
                if(seleccionados.length == 0){
                    alert("Seleccione al menos un registro");
                    return false;
                }     
                var vUrl = baseURI + "/mvc/persona/imprimirGafete";                                     
                conectaPost(vUrl,seleccionados,resultadoImpresion);
                
            });
            
            function resultadoImpresion(data){
                $('#loader').modal('toggle');
            }
            
            