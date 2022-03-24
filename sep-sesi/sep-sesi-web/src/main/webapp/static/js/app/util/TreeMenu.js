/**
 * Crea un árbol sin nodo raíz con el componente dijit/Tree para representar las opciones de un módulo
 * de la aplicación.
 * 
 * Se debe proporcionar el id del módulo cuyas opciones se quieren mostrar y un callback para
 * ejecutar cuando el usuario da click en alguna rama del árbol.
 * 
 * Se usa un store tipo JsonRest para obtener las opciones bajo demanda y evitar cargar toda la información
 * de inicio.
 * 
 */
define(["dijit/Tree",
    "dojo/store/JsonRest",
    "dojo/store/Memory",
    "dojo/_base/Deferred"
],
        function(
                Tree,
                JsonRest,
                Memory,
                Deferred) {

            var items = new Array();
            items.push({icon: 'dijitIconUsers', opcion: '||'});
            items.push({icon: 'iconMenu', opcion: '||'});
            items.push({icon: 'iconAutoriza', opcion: '||'});
            items.push({icon: 'iconParametros', opcion: '||'});
            items.push({icon: 'iconUpdate1', opcion: '||'});
            items.push({icon: 'iconUpdate2', opcion: '||'});
            items.push({icon: 'iconExport', opcion: '||'});
            items.push({icon: 'iconCapura1', opcion: '||'});
            items.push({icon: 'iconCapura2', opcion: '||'});
            items.push({icon: 'iconTableConfig', opcion: '||'});
            items.push({icon: 'iconProfile', opcion: '||'});
            items.push({icon: 'iconAccount', opcion: '||'});
            items.push({icon: 'iconReport', opcion: '||'});
            items.push({icon: 'iconFind', opcion: '||'});
            items.push({icon: 'iconPdf', opcion: '||'});
            items.push({icon: 'iconExcel', opcion: '||'});
            items.push({icon: 'iconPass', opcion: '||'});
            items.push({icon: 'iconEvaluacion', opcion: '||'});
            items.push({icon: 'iconCalcula', opcion: '||'});
            items.push({icon: 'iconNotification', opcion: '||'});
            items.push({icon: 'iconLoadUpload', opcion: '||'});

            var storeIcons = new Memory({data: items});

            var getIcon = function(idOpcion) {
                var icon = "dijitLeaf";
                var options = {
                    deep: true
                };
                var funtionQuery = function(data) {
                    return data.opcion.indexOf('|' + idOpcion + '|') != -1;
                }
                var def = storeIcons.query(funtionQuery, options);
                var deferred = Deferred.when(def, function(item) {
                    if (item == null || item.length == 0)
                        return;
                    icon = item[0].icon;
                    return icon;
                }, function(err) {
                });
                return icon;
            }

            var treeOpen = new Array();
            treeOpen.push({icon: 'iconScreenLock', opcion: '|76|'});
            var storeIconsTreeOpen = new Memory({data: treeOpen});
            var treeClose = new Array();
            treeClose.push({icon: 'iconScreenLockBlue', opcion: '|76|'});
            var storeIconsTreeClose = new Memory({data: treeClose});
            var getIconTree = function(idOpcion, mode) {
                var iconDefaultOpen = "iconBooks";
                var iconDefaultClose = "iconArchiver";
                var icon = null;
                var storeQuery = null;
                if (mode) {//open
                    icon = iconDefaultOpen;
                    storeQuery = storeIconsTreeOpen;
                } else {//close
                    icon = iconDefaultClose;
                    storeQuery = storeIconsTreeClose;
                }
                var options = {
                    deep: true
                };
                var funtionQuery = function(data) {
                    return data.opcion.indexOf('|' + idOpcion + '|') != -1;
                }
                var def = storeQuery.query(funtionQuery, options);
                var deferred = Deferred.when(def, function(item) {
                    if (item == null || item.length == 0)
                        return;
                    icon = item[0].icon;
                    return icon;
                }, function(err) {
                });
                return icon;
            }


            function TreeMenu(idModulo, onClickOpcion) {

                var storeMenu = new JsonRest({
                    target: dojo.config.app.urlBase + "seguridad/menu/",
                    mayHaveChildren: function(opcion) {
                        return !!opcion.opciones;
                    },
                    getChildren: function(object, onComplete, onError) {
                        this.get(object.id).then(function(fullObject) {
                            object.opciones = fullObject.opciones;
                            onComplete(fullObject.opciones);
                        }, function(error) {
                            console.error(error);
                            onComplete([]);
                        });
                    },
                    getRoot: function(onItem, onError) {
                        this.get("modulo/" + idModulo).then(onItem, onError);
                    },
                    getLabel: function(object) {
                        return object.opcion;
                    }
                });

                var tree = new Tree({
                    model: storeMenu,
                    showRoot: false,
                    onClick: onClickOpcion,
                    getIconClass: function(/*dojo.data.Item*/ item, /*Boolean*/ opened) {
                        var iconClass = getIcon(item.id);
                        return (!item || this.model.mayHaveChildren(item)) ?
                                (opened ? getIconTree(item.id, true) : getIconTree(item.id, false)) :
                                iconClass
                    }
                });

                this.idModulo = idModulo;
                this.getTree = function() {
                    return tree;
                };
                this.getStore = function() {
                    return storeMenu;
                };

            }

            return TreeMenu;

        });