window.addEventListener ?
        window.addEventListener("load", obtieneDatos, false) :
        window.attachEvent && window.attachEvent("onload", obtieneDatos);

function obtieneDatos() {
        
    var columnas = [
            {
                field: 'nombre',
                title: 'Marca',
                align: 'center'
            },
            {
                field: 'puesto',
                title: 'Número de serie',
                align: 'center'
            }]
       /* $('#resultadosResumenTable').bootstrapTable({
            columns: columnas
        });*/
        //$('#resultadosResumenTable').bootstrapTable('showLoading');

    var pathname = window.location.pathname;

    var sURLVariables = pathname.split('vC.jsp/');
    //var datos = cadena.split("/ValidacionCredencial/"); 
    var cadena = sURLVariables[sURLVariables.length-1];
    console.log('cadena ' + cadena);
    var param = {};
        param["cadena"] = cadena;
    $('#loader2').modal('toggle');
    $.ajax({
        type: "GET",
        cache: false,
        url: baseURI + "/mvc/consultaQR/datosPersona",
        contentType: "application/json; charset=utf-8",
        data: param,
        cache: false,
        success: function (response) {
            
            if (response.idPersona !== '') {
                var fotografia = response.fotografia;
            if(fotografia == null || fotografia == ''){                
                fotografia = imagenBase();                 
            }     
            document.getElementById("ItemPreview").src = "data:image/jpg;base64," + fotografia;
            document.getElementById("ItemPreview").width = 300;
            document.getElementById("ItemPreview").height = 300;
            var nombre = response.nombre;
            var primerApellido = response.apellido1;
            var segundoApellido = response.apellido2;
            if (segundoApellido == null){
                segundoApellido = '';
            }
            $('#ur').val(response.unidadResponsable);
            $('#nombre').val(nombre + " " + primerApellido + " " + segundoApellido);
            $('#puesto').val(response.puesto);
            $('#estatus').val(response.estatusDes);
            //gridEquipos();
            $('#loader2').modal('toggle');
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            $('#loader2').modal('toggle');
            console.log('jqXHR.status:: ' + jqXHR.status);
            console.log('jqXHR.text:: ' + jqXHR.text);
            console.log('textStatus:: ' + textStatus);
        }
        /*}).done(function (resumenInstancias) {
        console.log(resumenInstancias)
        var fotografia = resumenInstancias.fotografia;
            if(fotografia == null || fotografia == ''){                
                fotografia = imagenBase();                 
            }     
            document.getElementById("ItemPreview").src = "data:image/jpg;base64," + fotografia;
            document.getElementById("ItemPreview").width = 300;
            document.getElementById("ItemPreview").height = 300;
            var nombre = resumenInstancias.nombre;
            var primerApellido = resumenInstancias.apellido1;
            var segundoApellido = resumenInstancias.apellido2;
            if (segundoApellido == null){
                segundoApellido = '';
            }
        $('#ur').val(resumenInstancias.unidadResponsable);
        $('#nombre').val(nombre + " " + primerApellido + " " + segundoApellido);
        $('#puesto').val(resumenInstancias.puesto);
        $('#estatus').val(resumenInstancias.estatusDes);
        $('#loader').modal('toggle');
        }).fail(function () {
            $('#loader').modal('toggle');
        });*/
        });
        

}

function gridEquipos(){    
                //object.configModule.standby.show();
                var columnas = [
                {
                field: 'marca',
                title: 'Marca',
                align: 'center'
            },
            {
                field: 'numSerie',
                title: 'N\u00FAmero de serie',
                align: 'center'
            },{
                field: 'descripcionEquipo',
                title: 'Descripci\u00F3n del equipo',
                align: 'center'
            }]
                $('#resultadosResumenTable').bootstrapTable({
                    columns : columnas
                });
                $('#resultadosResumenTable').bootstrapTable('showLoading');
               var pathname = window.location.pathname;

    var sURLVariables = pathname.split('vC.jsp/');
    //var datos = cadena.split("/ValidacionCredencial/"); 
    var cadena = sURLVariables[sURLVariables.length-1];
    var param = {};
        param["cadena"] = cadena;
                //$('#loader').modal('toggle');
        	$.ajax({
                    url: baseURI +"/mvc/consultaQR/datosEquipo",
                    type: 'GET',
                    contentType: "application/json; charset=utf-8",
                    data: param,
                    //dataType: "json",
                    cache: false,
		}).done(function(resumenInstancias) {
                    console.log(resumenInstancias)                
                    $('#resultadosResumenTable').bootstrapTable('destroy');
                    $('#resultadosResumenTable').bootstrapTable({
                        pagination : false,
                        paginationHAlign : 'left',
                        paginationDetailHAlign : 'right',
                        classes: 'table table-bordered table-hover',
                        striped : true,
                        pageList : [],
                        columns : columnas,
                        data : resumenInstancias
                    });
                    //$('#loader').modal('toggle');
		}).fail(function() {
                    $('#loader').modal('toggle');
		});
            };  

function imagenBase(){    
    var imagen = "iVBORw0KGgoAAAANSUhEUgAAAcIAAAEcCAIAAADbTiNNAAABN2lDQ1BBZG9iZSBSR0IgKDE5OTgpAAAokZWPv0rDUBSHvxtFxaFWCOLgcCdRUGzVwYxJW4ogWKtDkq1JQ5ViEm6uf/oQjm4dXNx9AidHwUHxCXwDxamDQ4QMBYvf9J3fORzOAaNi152GUYbzWKt205Gu58vZF2aYAoBOmKV2q3UAECdxxBjf7wiA10277jTG+38yH6ZKAyNguxtlIYgK0L/SqQYxBMygn2oQD4CpTto1EE9AqZf7G1AKcv8ASsr1fBBfgNlzPR+MOcAMcl8BTB1da4Bakg7UWe9Uy6plWdLuJkEkjweZjs4zuR+HiUoT1dFRF8jvA2AxH2w3HblWtay99X/+PRHX82Vun0cIQCw9F1lBeKEuf1UYO5PrYsdwGQ7vYXpUZLs3cLcBC7dFtlqF8hY8Dn8AwMZP/fNTP8gAAAAJcEhZcwAACxMAAAsTAQCanBgAAAgGaVRYdFhNTDpjb20uYWRvYmUueG1wAAAAAAA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA3LjAtYzAwMCA3OS5kYWJhY2JiLCAyMDIxLzA0LzE0LTAwOjM5OjQ0ICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RFdnQ9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZUV2ZW50IyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyIgeG1sbnM6cGhvdG9zaG9wPSJodHRwOi8vbnMuYWRvYmUuY29tL3Bob3Rvc2hvcC8xLjAvIiB4bWxuczp0aWZmPSJodHRwOi8vbnMuYWRvYmUuY29tL3RpZmYvMS4wLyIgeG1sbnM6ZXhpZj0iaHR0cDovL25zLmFkb2JlLmNvbS9leGlmLzEuMC8iIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1wTU06RG9jdW1lbnRJRD0iMUI5QzlBNDVFOERCMjcyMzFCRTQ2RjhCNUNEQjMxNDkiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6Yzg3OGQ5NmEtZTc1Zi00OWVhLWIyNmQtYTM4NTdhOGQ4YzkyIiB4bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ9IjFCOUM5QTQ1RThEQjI3MjMxQkU0NkY4QjVDREIzMTQ5IiBkYzpmb3JtYXQ9ImltYWdlL3BuZyIgcGhvdG9zaG9wOkNvbG9yTW9kZT0iMyIgcGhvdG9zaG9wOklDQ1Byb2ZpbGU9IiIgdGlmZjpJbWFnZVdpZHRoPSI0NTAiIHRpZmY6SW1hZ2VMZW5ndGg9IjI4NCIgdGlmZjpQaG90b21ldHJpY0ludGVycHJldGF0aW9uPSIyIiB0aWZmOlNhbXBsZXNQZXJQaXhlbD0iMyIgdGlmZjpYUmVzb2x1dGlvbj0iNzIvMSIgdGlmZjpZUmVzb2x1dGlvbj0iNzIvMSIgdGlmZjpSZXNvbHV0aW9uVW5pdD0iMiIgZXhpZjpFeGlmVmVyc2lvbj0iMDIzMSIgZXhpZjpDb2xvclNwYWNlPSI2NTUzNSIgZXhpZjpQaXhlbFhEaW1lbnNpb249IjQ1MCIgZXhpZjpQaXhlbFlEaW1lbnNpb249IjI4NCIgeG1wOkNyZWF0ZURhdGU9IjIwMjEtMTItMDJUMTM6MTM6NDAtMDY6MDAiIHhtcDpNb2RpZnlEYXRlPSIyMDIxLTEyLTAyVDEzOjM3OjA2LTA2OjAwIiB4bXA6TWV0YWRhdGFEYXRlPSIyMDIxLTEyLTAyVDEzOjM3OjA2LTA2OjAwIj4gPHhtcE1NOkhpc3Rvcnk+IDxyZGY6U2VxPiA8cmRmOmxpIHN0RXZ0OmFjdGlvbj0iZGVyaXZlZCIgc3RFdnQ6cGFyYW1ldGVycz0iY29udmVy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";
    return imagen;
}
