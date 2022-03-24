define([
    "dojo/_base/xhr",
    "dojo/store/Memory",
    "dojo/DeferredList",
    "dojo/_base/Deferred",
    "dojo/_base/lang",
    "dijit/registry",
    "app/util/constants",
    "dojo/dom-form",
    "dojo/io-query",
    "dojox/timing/doLater",
    "dojo/has",
    "dojo/_base/json",
    "dojo/dom-construct",
    "dojo/_base/sniff"
], function(
        xhr,
        Memory,
        DeferredList,
        Deferred,
        lang,
        registry,
        constants,
        domForm,
        ioQuery,
        doLater,
        has,
        json,
        domConstruct
        ) {
    var isEmpty = function(obj) {
        for (var i in obj) {
            if (obj.hasOwnProperty(i)) {
                return false;
            }
        }

        return true;
    };
    /**
     * Obtiene de una URL un arreglo de objetos para devolverlo como Memory
     * Params: object
     *		properties: 
     *			urlBase url base para de los contraladores
     *			requestMapping RequestMapping a obtener List<? extends Object>
     *			load function que recibe el resultado
     * Return: dojo/store/Memory
     */
    var getMemory = function(object) {
        if (object.configModule) {
            object.configModule.standby.show();
        }
        var _handle = function() {
            if (object.configModule) {
                object.configModule.standby.hide();
            }
        };
        if (object.handle) {
            _handle = object.handle;
        }
        var objectGet = {
            url: object.urlBase + object.requestMapping + '?currentSystem=' + new Date().getTime(),
            headers: {
                "Content-Type": "application/json; charset=UTF-8"
            },
            handleAs: 'json',
            load: function(response) {
                var objectData = {
                    data: response
                };
                if (object.idProperty) {
                    objectData.idProperty = object.idProperty
                }
                ;
                var objStore = new Memory(objectData);
                object.load(objStore);
                if (object.configModule) {
                    object.configModule.standby.hide();
                }
            },
            handle: _handle
        };
        if (object.error) {
            objectGet.error = object.error;
        }
        return xhr.get(objectGet);
    };
    /**
     *envia una petición Json de un objeto Json
     *Params: object
     *		properties:
     *			urlBase url base para de los contraladores
     *			requestMapping RequestMapping a enviar la peticion
     *			data objeto en js tipo JSON
     *			load function que recibe el resultado
     *			configModule configuracion de objetos del contendedor
     */
    var submitObject = function(object) {
        //console.log( object );
        if (object.configModule) {
            object.configModule.standby.show();
        }
        var objectParam = {
            url: object.urlBase + object.requestMapping + '?currentSystem=' + new Date().getTime(),
            postData: dojo.toJson(object.data),
            headers: {
                "Content-Type": "application/json; charset=UTF-8"
            },
            handleAs: 'json',
            load: function(response) {
                object.load(response);
            },
            handle: function() {
                if (object.configModule) {
                    object.configModule.standby.hide();
                }
            }
        };
        if (object.timeout) {
            objectParam.timeout = object.timeout;
        }
        if (object.error) {
            var errorFunction = function(response) {
                var objectErr = json.fromJson(response.responseText || null);
                object.error(objectErr);
            }
            objectParam.error = errorFunction;
        }
        return xhr.post(
                objectParam
                );
    };
    /**
     *envia una petición Json de un objeto Json
     *Params: object
     *		properties:
     *			urlBase url base para de los contraladores
     *			requestMapping RequestMapping a enviar la peticion
     *			data objeto en js tipo JSON
     *			load function que recibe el resultado
     *			configModule configuracion de objetos del contendedor
     */
    var submitUrl = function(object) {
        if (object.configModule) {
            object.configModule.standby.show();
        }
        xhr.get({
            url: object.urlBase + object.requestMapping + '?currentSystem=' + new Date().getTime(),
            headers: {
                "Content-Type": "application/json; charset=UTF-8"
            },
            handleAs: 'json',
            load: function(response) {
                object.load(response);
            },
            handle: function() {
                if (object.configModule) {
                    object.configModule.standby.hide();
                }
            }
        });
    };
    /**
     *De un objeto Json realiza set('value') a las variables declaradas con los
     *nombres de las propiedades
     **/
    var setVarWidgetFromObject = function(object, objectWidget, aleatorio) {
        var widget = null;
        for (var property in object) {
            //widget = objectWidget[ property ];
            widget = registry.byId(property + ((aleatorio) ? aleatorio : ""));
            if (widget == null || widget == undefined || property == '__parent') {
                //console.log(property + '-->Fue omitido', widget);
                widget = registry.byId(property + object[ property ] + ((aleatorio) ? aleatorio : ""));
                if (widget == null || widget == undefined || property == '__parent') {
                    continue;
                }
            }
            if (object[ property ] == null) {
                continue;
            }
            //widget = module.get( property );//eval( property );
            //console.log( "Variable que debe existir: " + property + " de tipo: " + widget.declaredClass );
            if (widget.declaredClass == 'dijit.form.CheckBox') {
                var value = object[ property ];
                if (value == '1') {
                    widget.set('checked', true);
                } else {
                    widget.set('checked', false);
                }
            } else if (widget.declaredClass == 'dijit.form.RadioButton') {
                widget.set('checked', true);
            } else if (widget.declaredClass == 'dijit.form.FilteringSelect') {
                var store = widget.get('store');
                var options = {
                    deep: true
                };
                var funtionQuery = function(data) {
                    return eval("data." + property + " == '" + object[ property ] + "'");
                }
                var def = store.query(funtionQuery, options);
                Deferred.when(def, function(item) {
                    if (item == null || item.length == 0)
                        return;
                    //console.log("ITEM DEL SELECT OBTENIDO POR BUSQUEDA");
                    //console.log(item);
                    var searchAttrOrig = widget.get('searchAttr');
                    var unItem = item[0];
                    widget.set('displayedValue', unItem[ searchAttrOrig ]);
                }, function(err) {
                    //console.error('dijit.form.FilteringSelect: ' + err.toString());
                });
            } else if (widget.declaredClass == 'dijit.form.DateTextBox') {
                //console.log("Fecha a pasar al control: " + object[ property ]);
                widget.set('value', new Date(object[ property ]));
            } else {
                widget.set('value', object[ property ]);
            }
        }
    };

    /**
     * valida de un objeto Uploadar los tipos de archivos permitidos
     */
    var validFileFilter = function(type, types) {
        var filtros = types;
        var existe = false;
        var concat = "";
        for (var property in filtros) {
            if (has("ie")) {
                if (filtros[ property ].subType.indexOf(type) != -1) {
                    existe = true;
                }
            } else {
                if (filtros[ property ].type.indexOf(type) != -1) {
                    existe = true;
                }
            }

            concat += filtros[ property ].descripcion + " ";
        }
        if (existe) {
            return existe;
        } else {
            return concat;
        }
    };



    /**
     * Excluye de un objeto propiedades
     * Params: object - objeto a eliminar propiedades
     *	   properties - array de String con las propiedades a excluir
     * Return
     *	  Object con las nuevas propiedades
     */
    var excludeProperties = function(object, properties) {
        var objectNew = {};
        for (var property in object) {
            var existe = false;
            for (var idx = 0; idx < properties.length; idx++) {
                if (properties[ idx ] == property) {
                    existe = true;
                }
            }
            if (!existe) {
                //objectNew[ property ] = object[ property ];
                eval("objectNew." + property + " = '" + object[ property ] + "'");
                //delete object[ property ];
            }
        }
        return objectNew;
    };
    /**
     * Verifica de un objeto si los valores de todas sus propiedades son vacias
     * Params: object - objeto a verificar sus propiedades
     * Return  true: si todas son vacias en caso contrario false
     */
    var isAllPropertiesEmpty = function(object) {
        var allEmpty = true;
        for (var property in object) {
            console.log(object[ property ].length);
            if (object[ property ].length != 0) {
                if (object[ property ] == '0') {
                    continue;
                }
                console.log("esta es la propiedad con valor " + property + "=" + object[ property ]);
                allEmpty = false;

            }
        }
        return allEmpty;
    };

    /**
     * Dado un objeto excluye las propiedades que son vacias o con valor '0
     * Params: object - objeto a depurar las propiedades vacias'
     * Return: un nuevo objeto depurado
     */
    var excludeNullProperties = function(object) {
        var objectNew = {};
        for (var property in object) {
            if (object[ property ].length != 0) {
                if (object[ property ] == '0') {
                    continue;
                }
                objectNew[ property ] = object[ property ];
                //eval( "objectNew." + property + " = '" + object[ property ] +"'" );
                //delete object[ property ];
            }
        }
        return objectNew;
    };
    /**
     * obtiene el total de propiedades que contiene un objeto
     * Params: object - objeto a contar las propiedades
     * Return un entero
     */
    var sizeObject = function(object) {
        var size = 0, key;
        for (key in object) {
            size++;
        }
        return size;
    };
    /**
     * Dado un objeto, realiza la conversión de las propiedades indicas que contienen fecha en milisegundos
     * Params: object Objeto de propiedades
     *	   propertiesDate Array de string con las propiedades que son de fecha a convertir a milisegundos
     */
    var convertFieldDateToTime = function(object, propertiesDate) {
        for (var i = 0; i < propertiesDate.length; i++) {
            if (object[ propertiesDate[ i ] ]) {
                var value = object[ propertiesDate[ i ] ];
                if (Object.prototype.toString.call(value) === "[object Date]") {
                    object[ propertiesDate[ i ] ] = value.getTime();
                } else {
                    var newValueDate = dojo.date.locale.parse(value, {datePattern: constants.DOJO_SHORT_DATE, selector: "date"});
                    if (newValueDate != null) {
                        object[ propertiesDate[ i ] ] = newValueDate.getTime();
                    }
                }
            }
        }
        return object;
    };
    /**
     * Convierte un objeto a parte de los parametros de una URL, nota: escluye las propiedades vacias
     * Params: idForm - String con el id del formulario
     */
    var formToQuery = function(idForm, properItem, propertiesDate, requireExcludeNull) {
        var formObj = domForm.toObject(idForm);
        var object = formObj;
        if (requireExcludeNull && requireExcludeNull === true) {
            object = excludeNullProperties(formObj);
        }
        if (properItem) {
            for (var property in properItem) {
                if (object[property]) {
                    object[property] = properItem[property];
                }
            }
        }
        if (propertiesDate) {
            convertFieldDateToTime(object, propertiesDate);
        }

        var queryStr = ioQuery.objectToQuery(object);
        return queryStr + '&currentSystem=' + new Date().getTime();
    };
    /**
     * cierra un una pestaña del contenedor principal de forma indirecta
     * Params: idOp - identificador de la pestaña como fue inicializada
     */
    var closeTabTabContainerMain = function(idOp) {
        var contentTabs = registry.byId('contenedorTabs');
        var idPanel = 'contentTab_' + idOp;
        if (registry.byId(idPanel)) {
            var panel = registry.byId(idPanel);
            contentTabs.closeChild(panel);
            return;
        }
    };
    /**
     * Dispara resize del contenedor 'contenedorTabs' con la finalidad de que los widgets se visualicen correctamente
     */
    var resizeContainerMain = function() {
        var waiting = 0;
        setTimeout(function() {
            if (doLater(waiting == 5)) {
                waiting++;
                return;
            }
            var contentTabs = registry.byId('contenedorTabs');
            contentTabs.resize();
        }, 100);
    };

    var extractText = function(texto, strInicial, strFinal) {
        var ind0, ind1, parte = "";
        ind0 = texto.indexOf(strInicial);
        if (ind0 >= 0)
        {
            ind1 = texto.indexOf(strFinal);
            if (ind1 > ind0)
                parte = texto.substring(ind0 + strInicial.length, ind1);
        }
        return parte;
    };

    var getText = function(object) {
        return xhr.get({
            url: object.urlBase + object.requestMapping,
            headers: {
                "Content-Type": "text/plain; charset=UTF-8"
            },
            handleAs: 'text',
            load: function(response) {
                object.load(response);
            }
        });
    };
    /**
     * Dado una lista de String que contiene los IDs de los tabs, permite seleccionar
     * el TAB indicado en el parametro 'index', siempre comenzando en 1
     * El indice 0 del listTabs esta reservado al TabContainar
     */
    var selectedTab = function(listTabs, index) {
        var tabConteiner = registry.byId(listTabs[0]);
        tabConteiner.selectChild(registry.byId(listTabs[ index ]));
    };
    /**
     * Invoca de ioQuery la funcion objectToQuery con la finalidad de no importarla
     */
    var objectToQuery = function(/*Object*/ object) {
        return ioQuery.objectToQuery(object); // String
    }


    var disabledFieldFromObject = function(object, disabled, aleatorio) {
        var widget = null;
        for (var property in object) {
            widget = registry.byId(property + ((aleatorio) ? aleatorio : ""));
            if (widget == null || widget == undefined) {
                console.log("Invalid Setter property a " + property);
                continue;
            }
            widget.set('readOnly', disabled);
        }
    };
    /**
     * De un Store de tipo Memory obtiene un item de acuerdo a una propiedad a consultar o funcion personalizada
     * @param {type} store Store de tipo Memory
     * @param {type} propertyFinder propiedad contenida en los objetos del store a comparar
     * @param {type} value valor a encontrar en la comparaci�n de la propuiedad
     * @param {type} customFuntionQuery 
     * @returns {unresolved}
     */
    var getItemStoreQuery = function(store, propertyFinder, value, customFuntionQuery) {
        var object = null;
        var options = {
            deep: true
        };
        var funtionQuery = null;
        if (customFuntionQuery) {
            funtionQuery = customFuntionQuery;
        } else {
            funtionQuery = function(data) {
                return data[ propertyFinder ] == value;
            }
        }

        var def = store.query(funtionQuery, options);
        var deferred = Deferred.when(def, function(item) {
            if (item == null || item.length == 0)
                return null;
            object = item[0];
            return item[0];
        }, function(err) {
        });
        return object;
    };
    /**
     * Lanza una notificacion
     * @param {type} message
     * @param {type} type
     * @returns {undefined}
     */
    var notification = function(message, type, duration) {
        var typeMessage = 'message';
        var _duration = 7000;
        if (type) {
            typeMessage = type;
        }
        if (duration) {
            _duration = duration;
        }
        dojo.publish("/app/notificacion", [{
                message: message,
                type: typeMessage,
                duration: _duration
            }]);
    };

    var fold = function(arr, accu, callback) {
        if (!arr || !arr.length)
            return undefined;
        for (var i = 0; i < arr.length; i++) {
            accu = callback.call(arr[i], accu, arr[i]);
        }
        return accu;
    };
    /**
     * Dado una arreglo de objetos, se devuelve un arreglo sencillo de acuerdo a una propiedad
     * @param {type} arr Lista de los objetos
     * @param {type} property propiedad a extraer para la lista de resultado
     * @returns {unresolved} un Array simple
     */
    var extractListOneProperty = function(arr, property) {
        var listResult = new Array();
        return fold(arr, listResult, function(list) {
            list.push(this[ property ]);
            return list;
        });
    };
    /**
     * Dado un objeto se crea un DOM FORM
     */
    var objectToForm = function(object, contentForm, properties) {
        //var proper = { name: name ,id: name, method: method, action: action};
        domConstruct.destroy(properties.id);
        var form = domConstruct.create("form", properties, contentForm, "first");
        for (var property in object) {
            var properItem = object[ property ];
            if (lang.isArray(properItem)) {//solo un array de valores no objetos
                for (var i = 0; i < properItem.length; i++) {
                    var item = properItem[i];
                    if (lang.isObject(item)) {
                        console.log("Pendiente implementar de un arreglo de objetos!!");
                    } else {
                        //domConstruct.create("input", { type:'hidden', name: property + '['+ i +']', value: item }, form, "first" );
                        domConstruct.create("input", {type: 'hidden', name: property, value: item}, form, "first");
                    }
                }
            } else if (lang.isObject(properItem)) {
                console.log("Pendiente implementar de objeto interno!!");
            } else {
                domConstruct.create("input", {type: 'hidden', name: property, value: object[ property ]}, form, "first");
            }
        }
        return form;
    };
    /**
     * Dado un string que contiene 'true' o 'false' retorna el valor correcto
     * @param {type} string
     * @returns {Boolean}
     */
    var stringToBoolean = function(string) {
        switch (string.toLowerCase()) {
            case "true":
            case "yes":
            case "1":
                return true;
            case "false":
            case "no":
            case "0":
            case null:
                return false;
            default:
                return Boolean(string);
        }
    }



    return {
        isEmpty: isEmpty,
        getMemory: getMemory,
        setVarWidgetFromObject: setVarWidgetFromObject,
        submitObject: submitObject,
        submitUrl: submitUrl,
        validFileFilter: validFileFilter,
        excludeNullProperties: excludeNullProperties,
        formToQuery: formToQuery,
        excludeProperties: excludeProperties,
        isAllPropertiesEmpty: isAllPropertiesEmpty,
        sizeObject: sizeObject,
        closeTabTabContainerMain: closeTabTabContainerMain,
        resizeContainerMain: resizeContainerMain,
        extractText: extractText,
        getText: getText,
        selectedTab: selectedTab,
        objectToQuery: objectToQuery,
        convertFieldDateToTime: convertFieldDateToTime,
        disabledFieldFromObject: disabledFieldFromObject,
        getItemStoreQuery: getItemStoreQuery,
        notification: notification,
        extractListOneProperty: extractListOneProperty,
        objectToForm: objectToForm,
        stringToBoolean: stringToBoolean

    };
});