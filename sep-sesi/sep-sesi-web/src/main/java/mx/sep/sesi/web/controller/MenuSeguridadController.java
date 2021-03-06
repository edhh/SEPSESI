package mx.sep.sesi.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.sep.seguridad.modelo.ModuloMenu;
import mx.sep.seguridad.modelo.OpcionMenu;
import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.servicios.MenuSeguridadServicio;
import mx.sep.seguridad.util.SeguridadUtil;
import mx.sep.sesi.datos.vo.UsuarioVO;
import mx.sep.sesi.servicios.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller que se encarga de atender la peticiones del cliente para el menú
 * de opciones que será mostrado.
 *
 * @author Alejandro Pimentel
 *
 */
@Controller
@RequestMapping("/seguridad/menu")
public class MenuSeguridadController {

    @Autowired
    private MenuSeguridadServicio menuSeguridadServicio;
    
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Obtiene un objeto tipo {@link OpcionMenu}, verifica si cada uno de sus
     * subopciones tendrán o no hijos a su vez.
     *
     * @param id El id de la opción de menu que se desea obtener.
     * @return Un objeto tipo {@link OpcionMenu} que contiene la información de
     * la opción y de sus subopciones.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public OpcionMenu obtenerOpciones(@PathVariable Long id) {
        OpcionMenu opcion = menuSeguridadServicio.consultarOpcionSubOpciones(id);

        for (OpcionMenu op : opcion.getOpciones()) {
            if (!StringUtils.hasLength(op.getUrl())) {
                // con un arreglo vacío indicamos que tiene hijos
                // que posteriormente podrían ser cargados.
                op.setOpciones(new ArrayList<OpcionMenu>());
            }
        }

        return opcion;
    }

    /**
     * Consulta un módulo por id y lo devuelve como una OpcionMenu. Coloca
     * además en {@link OpcionMenu#setOpciones(List)} una lista vacía
     * indicando que dado que es un módulo este siempre tendra opciones hijas.
     *
     * @param id El id de la opción de menu que se desea obtener.
     * @return
     */
    @RequestMapping(value = "/modulo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public OpcionMenu obtenerModulo(@PathVariable Long id) {
        ModuloMenu modulo = menuSeguridadServicio.consultarModuloMenu(id);
        OpcionMenu opcion = new OpcionMenu();
        opcion.setId(modulo.getId());
        opcion.setOpcion(modulo.getModulo());
        // con un arreglo vacío indicamos que tiene hijos
        // que posteriormente podrían ser cargados.		
        opcion.setOpciones(new ArrayList<OpcionMenu>());
        return opcion;
    }

    /**
     * Devuelve la lista de módulo que se mostrará en el menú.
     *
     * @return lista de módulos.
     */
    @RequestMapping(value = "/modulos", method = RequestMethod.GET)
    @ResponseBody
    public List<ModuloMenu> obtenerModulos() {
        List<ModuloMenu> modulos = menuSeguridadServicio.consultarModulos();
        return modulos;
    }
    
    @RequestMapping(value = "/obtenerUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> obtenerUsuario(HttpServletRequest request, HttpServletResponse response) {
        UsuarioVO usuarioVO = new UsuarioVO();
        HttpSession session = request.getSession();
        try {
            UsuarioSeguridad usuarioSeguridad = SeguridadUtil.getUsuarioActual();                    
            usuarioVO = usuarioService.consultarPorNombreUsu(usuarioSeguridad.getUsername());
            
            if (usuarioVO.getIdRol()==6){
            System.out.println("Obtener usuario segunods");
            String segundos = usuarioService.obtieneSegundosSesion();

            session.setMaxInactiveInterval(Integer.parseInt(segundos));
            }
        } catch (Exception ex) {                     
            String mensaje = "No se obtener informaci?n del usuario:" + " por favor intente m?s tarde";
            return new ResponseEntity<String>(mensaje, HttpStatus.CONFLICT);
        }
        
        return new ResponseEntity<UsuarioVO>(usuarioVO, HttpStatus.OK);
    }
}
