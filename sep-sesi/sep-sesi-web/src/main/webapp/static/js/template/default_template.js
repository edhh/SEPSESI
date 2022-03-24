
var jsonLog = "";
$(document).ready(function() {
	funMenu();
	obtenerUsuario();
});

function obtenerUsuario(){
	var vUrl = baseURI + '/mvc/seguridad/menu/obtenerUsuario';
	conectaPost(vUrl,"",resNombreUsuario);
}

function resNombreUsuario(data){
        //console.log(data);
    	$("#usuario").html(data.nombreUsu);
	$("#nombreUsu").html(data.nombre + ' ' + data.apellido1+ ' ' + data.apellido2);
        $("#inmueble").html(data.descInmueble);
        if (data.nombreUsu === null || data.nombreUsu.length === 0) {
                document.getElementById("usuarioQr").style.display = "block";
                document.getElementById("passwordID").style.display = "block";
            }
            else{
                document.getElementById("usuarioQr").style.display = "none";
                document.getElementById("passwordID").style.display = "none";
            }
}

function funMenu() {
        //console.log("inicio menu");
	var vUrl = baseURI + '/mvc/seguridad/menu/modulos';
	$.ajax({
		type : 'GET',
		url : vUrl,
		success : function(response) {                    
                    if (!jQuery.isEmptyObject(response)) {                       
                        buildMenu($("#ulMenu"), response);
                        $('#hrefSalir').click(function() {
                                parent.window.location.href =  baseURI + 'logout';
                        });                        
                    }
		}
	});
}

function buildMenu(parent, modulos) {
	var res = "";
	for (var i = 0; i < modulos.length; i++) {
		var contieneOpciones = modulos[i].opcionesMenu.length != 0;
		res += '<li class="dropdown" >';
		if (!contieneOpciones) {
			res += '<a href="' + baseURI + modulos[i].url + '" id='+i+'>'
					+ modulos[i].modulo + '</a></li>';
		} else {
			res += '<a href="#"  class="dropdown-toggle"  data-toggle="dropdown" role="button"   aria-expanded="false" >';
			res += modulos[i].modulo;
			res += '<span class="caret"></span></a>';
			res += '<ul class="dropdown-menu" role="menu">';
			for (var j = 0; j < modulos[i].opcionesMenu.length; j++) {
				var menu = modulos[i].opcionesMenu[j];
				res += '<li>';

				res += '<a href="'+ baseURI + menu.url + '">';
				res += menu.opcion;
				res += '</a>';
			}
			res += '</ul>';
		}
	}

	parent.html(res);

}