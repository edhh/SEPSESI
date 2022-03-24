/**
 * Valida la extencion y el tamano de archivo
 * @param archivo
 * @param btnFile
 * @returns
 */
function comprueba_extension_size(archivo, btnFile, extensiones) {
    var mierror = "";

    var nameFile = getFileName(archivo.value);

    if (nameFile.length > 100) {
        mierror = "El nombre del archivo excede el tamaño permitido(100 caracteres).";
        alert(mierror);
        document.getElementById(archivo.id).value = "";
        return 0;
    }

    var extensiones_permitidas;
    if (extensiones == null) {
        extensiones_permitidas = new Array(".pdf");
    } else {
        extensiones_permitidas = extensiones.split(",");
    }

    //recupero la extensión de este nombre de archivo 
    var extension = (archivo.value.substring(archivo.value.lastIndexOf("."))).toLowerCase();
    if(extension == ''){
        return 1;
    }
    //compruebo si la extensión está entre las permitidas 
    var permitidaExt = false;
    var permitidaSize = false;


    for (var i = 0; i < extensiones_permitidas.length; i++) {
        if (extensiones_permitidas[i] == extension) {
            permitidaExt = true;
            break;
        }
    }
    
    if (archivo.files[0].size < (1024 * 1024 * 10)) {
        permitidaSize = true;
    }
    
    if (permitidaExt && permitidaSize) {
        document.getElementById(btnFile.id).value = nameFile;
        return 1;
    } else {
        document.getElementById(archivo.id).value = "";
        if (!permitidaExt) {
            mierror = nameFile + " no contiene un formato valido (" + extensiones_permitidas.join().replace(".", " ") + "). ";
        }

        if (!permitidaSize) {
            mierror = nameFile + " excede el tamaño permitido(10MB).";
        }

    }


    //si estoy aqui es que no se ha podido submitir 
    alert(mierror);
    return 0;
}

/**
 * Obtiene el nombre del archivo en cuestion 
 * @param path
 * @returns
 */
function getFileName(path)
{
    var pos = path.lastIndexOf(path.charAt(path.indexOf(":") + 1));
    var filename = path.substring(pos + 1);
    return filename;
}

/**
 * Funcion de solo numeros
 * @param e
 * @returns
 */
function soloNumeros(e)
{
    var keynum = window.event ? e.which : e.keyCode;
    return (keynum >= 48 && keynum <= 57);
}

var b = false;

//función que acepta letras, acentos, números con espacio en blanco, punto y coma, guiones, diagonal( ,A-Z,a-z,0-9,ñ,Ñ,á,é,í,ó,ú,Á,É,Í,Ó,Ú,ü.,-,/,_)
function f_aceptaLetrasNumerosPuntoGuion(evt) {
    var key = b ? evt.which : evt.keyCode;
    if (key == undefined)
        return key;
    return ((key >= 0 && key <= 31) || (key == 44) || (key >= 65 && key <= 90) || (key >= 97 && key <= 122) || (key >= 48 && key <= 57) || (key == 233) || (key == 250) || (key == 211) || (key == 46) || (key == 45) || (key == 47) || (key == 95));
}

/**
 * Valida la extencion y el tamano de archivo
 * @param archivo
 * @param btnFile
 * @returns
 */
function comprueba_extension_size2(archivo, btnFile, extensiones) {
    var mierror = "";
    var nameFile = getFileName(archivo.value);

    if (nameFile.length > 70) {
        mierror = "El nombre del archivo excede el tamaño permitido(70 caracteres).";
        alert(mierror);
        document.getElementById(archivo.id).value = "";
        return 0;
    }

    var extensiones_permitidas;
    if (extensiones == null) {
        extensiones_permitidas = new Array(".pdf");
    } else {
        extensiones_permitidas = extensiones.split(",");
    }

    //recupero la extensión de este nombre de archivo 
    var extension = (archivo.value.substring(archivo.value.lastIndexOf("."))).toLowerCase();
    if(extension == ''){
        return 2;
    }
    //compruebo si la extensión está entre las permitidas 
    var permitidaExt = false;
    var permitidaSize = false;
    
    for (var i = 0; i < extensiones_permitidas.length; i++) {
        if (extensiones_permitidas[i] == extension) {
            permitidaExt = true;
            break;
        }
    }

    if (archivo.size < (1024 * 1024 * 10)) {
        permitidaSize = true;
    }

    if (permitidaExt && permitidaSize) {
        document.getElementById(btnFile.id).value = nameFile;
        return 1;
    } else {
        document.getElementById(archivo.id).value = "";
        
        if (!permitidaExt) {
            mierror = nameFile + " no contiene un formato valido (" + extensiones_permitidas.join().replace(".", " ") + "). ";
        }

        if (!permitidaSize) {
            mierror = nameFile + " excede el tamaño permitido(10MB).";
        }

    }
    //si estoy aqui es que no se ha podido submitir 
    alert(mierror);
    return 0;
}