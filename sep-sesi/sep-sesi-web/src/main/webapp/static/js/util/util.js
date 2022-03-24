function conectaPost(url, datos, metodo) {
	$.ajax({
		url : url,
		type : 'POST',
		contentType : 'application/json',
		data : JSON.stringify(datos),
		dataType : "json",
		cache : false,
		statusCode : {
			200 :function(data) {
				metodo(data);
			},
			201 : function(data) {
				muestraPrecaucion(data);
			},
			202 : function(data) {
				procesoRealizado(data.responseText);
			},
			206 : function(data) {
				errorFormulario(data);
			},
			408 : function(data) {
				showModalMessageAccept(data.responseText);
			},
			422 : function(data) {
				metodo(data, true);
			},
			409 : function(data) {
				muestraError(data.responseText);
			},
		},
		success : function(data) {
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$('#loader').modal('toggle');
		}
	});
}

function vincularURL(url, datos) {
	$.ajax({
		url : url,
		type : 'POST',
		contentType : 'application/json',
		data : JSON.stringify(datos),
		dataType : "json",
		cache : false,
		statusCode : {
			200 : function(data) {
			},
			422 : function(data) {
			
			}
		},
		success : function(data) {
			window.location.href = baseURI + data.urlDestino;
		},
		error : function(jqXHR, textStatus, errorThrown) {

		}
	});
}

function obtenImagenBase64(url, metodo) {
	$.ajax({
		url : url,
		type : 'GET',
		cache : false,
		statusCode : {
			
			408 : function(data) {
				muestraError(jqXHR.responseText);
			},
			422 : function(data) {
				metodo(data, true);
			}
			
		},
		success : function(data) {
			
			metodo(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
		}
	});
}


function conectaPostNombre(url, datos, metodo, nombre) {
	$.ajax({
		url : url,
		type : 'POST',
		contentType : 'application/json',
		data : JSON.stringify(datos),
		dataType : "json",
		cache : false,
		statusCode : {
			408 : function(data) {
			}
		},
		success : function(data) {
			metodo(nombre, data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			muestraError(jqXHR.responseText);
		}
	});
}

function cargaPagina(id, path) {
	$(id).load(path);
}