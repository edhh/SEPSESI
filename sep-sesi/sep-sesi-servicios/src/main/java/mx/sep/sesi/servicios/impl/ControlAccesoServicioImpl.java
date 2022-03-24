/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import mx.sep.sesi.dao.Tses003RolUsuarioMapper;
import mx.sep.sesi.dao.Tses004PersonasMapper;
import mx.sep.sesi.dao.Tses011VisitantesMapper;
import mx.sep.sesi.dao.Tses012OperacionMapper;
import mx.sep.sesi.dao.Tses027OperacionEquiposMapper;
import mx.sep.sesi.dao.Tses001UsuariosMapper;
import mx.sep.sesi.dao.Tses025EquiposVisitanteMapper;
import mx.sep.sesi.dao.Tses027OperacionEquiposMapper;
import mx.sep.sesi.dao.Tses009InmueblesMapper;
//import mx.sep.sesi.dao.join.OperacionJoinMapper;
import mx.sep.sesi.dao.join.SecuenciasJoinMapper;
import mx.sep.sesi.datos.vo.OperacionVO;
import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.modelo.Tses003RolUsuario;
import mx.sep.sesi.modelo.Tses003RolUsuarioExample;
import mx.sep.sesi.modelo.Tses011Visitantes;
import mx.sep.sesi.modelo.Tses011VisitantesExample;
import mx.sep.sesi.modelo.Tses012Operacion;
import mx.sep.sesi.modelo.Tses012OperacionExample;
import mx.sep.sesi.modelo.Tses027OperacionEquipos;
import mx.sep.sesi.modelo.Tses027OperacionEquiposExample;
import mx.sep.sesi.modelo.Tses025EquiposVisitante;
import mx.sep.sesi.modelo.Tses025EquiposVisitanteExample;
import mx.sep.sesi.modelo.Tses009Inmuebles;
import mx.sep.sesi.modelo.Tses009InmueblesExample;
import mx.sep.sesi.modelo.Tses001Usuarios;
import mx.sep.sesi.modelo.Tses001UsuariosExample;
import mx.sep.sesi.servicios.ControlAccesoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.sep.seguridad.servicios.CustomUserDetailsService;
import mx.sep.sesi.dao.join.DatosEquipoJoinMapper;
import mx.sep.sesi.datos.vo.UsuarioVO;
import mx.sep.sesi.servicios.UsuarioService;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author pedro.flores
 */
@Service
public class ControlAccesoServicioImpl implements ControlAccesoServicio {

    @Autowired
    private Tses004PersonasMapper tses004PersonasMapper;

    @Autowired
    private Tses012OperacionMapper tses012OperacionMapper;

    @Autowired
    private Tses011VisitantesMapper tses011VisitantesMapper;

    @Autowired
    private SecuenciasJoinMapper secuenciasJoinMapper;

    @Autowired
    private Tses027OperacionEquiposMapper tses027OperacionEquiposMapper;

    @Autowired
    private Tses001UsuariosMapper tses001UsuariosMapper;

    @Autowired
    private Tses003RolUsuarioMapper tses003RolUsuarioMapper;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private Tses025EquiposVisitanteMapper tses025EquiposVisitanteMapper;

    @Autowired
    private DatosEquipoJoinMapper datosEquipoJoinMapper;

    @Autowired
    private Tses009InmueblesMapper tses009InmueblesMapper;

//    @Autowired
//    private OperacionJoinMapper operacionJoinMapper;
//    
    public Tses004Personas obtenerInformacion(Integer idPersona) {
        Tses004Personas persona = new Tses004Personas();
        persona = tses004PersonasMapper.selectByPrimaryKey(idPersona);
        System.out.println("Exitoso");
        return persona;
    }

    public Tses011Visitantes obtenerVisitantePorEtiqueta(Integer idInmueble, Long idEtiqueta) {
        Tses011Visitantes visitante = null;
        Tses011VisitantesExample criterios = new Tses011VisitantesExample();
        criterios.createCriteria().andIdInmuebleEqualTo(idInmueble).andIdEtiquetaEqualTo(idEtiqueta);
        List<Tses011Visitantes> lstVisitantes = tses011VisitantesMapper.selectByExampleWithBLOBs(criterios);
        if (lstVisitantes != null && lstVisitantes.size() > 0) {
            visitante = lstVisitantes.get(0);
        }
        return visitante;
    }

    public Optional<Long> registrarEntrada(OperacionVO operacionVO) throws Exception {
        java.util.Date fecha = new Date();

        Tses012Operacion operacion = new Tses012Operacion();
        System.out.println("Servicio - Se solicita idOperacion...");
        Long idOperacion = secuenciasJoinMapper.nextIdOperacion();
        System.out.println("Servicio respuesta idOperacion: " + idOperacion);
        operacion.setIdRegistro(idOperacion);
        operacion.setIdUsuario(operacionVO.getIdUsuario());
        operacion.setIdPersona(operacionVO.getIdPersona());
        operacion.setIdVisitante(operacionVO.getIdVisitante());
        operacion.setIdAcceso(operacionVO.getIdAcceso());
        operacion.setIdInmueble(operacionVO.getIdInmueble());
        operacion.setFechaOperacion(fecha);
        operacion.setEntradaSalida((short) 1);
        tses012OperacionMapper.insert(operacion);
        if (operacionVO.getIdVisitante() != null) {
            Tses025EquiposVisitanteExample tses025EquiposVisitanteExample = new Tses025EquiposVisitanteExample();
            tses025EquiposVisitanteExample.createCriteria().andIdVisitanteEqualTo(operacionVO.getIdVisitante());
            List<Tses025EquiposVisitante> tses025EquiposVisitante = tses025EquiposVisitanteMapper.selectByExample(tses025EquiposVisitanteExample);
            if (tses025EquiposVisitante.size() > 0) {
                for (int i = 0; i < tses025EquiposVisitante.size(); i++) {
                    if (tses025EquiposVisitante.get(i).getEstatus() == 1) {
                        Tses027OperacionEquipos tses027OperacionEquipos = new Tses027OperacionEquipos();
                        tses027OperacionEquipos.setIdUsuario(operacionVO.getIdUsuario().longValue());
                        tses027OperacionEquipos.setIdInmueble(operacionVO.getIdInmueble().longValue());
                        tses027OperacionEquipos.setIdEquipoVis(tses025EquiposVisitante.get(i).getIdEquipoVis());
                        tses027OperacionEquipos.setFechaOperacion(fecha);
                        tses027OperacionEquipos.setEntradaSalida((short) 1);
                        tses027OperacionEquiposMapper.insert(tses027OperacionEquipos);
                    }

                }
            }
        }
        System.out.println("Servicio finaliza proceso de inserción... ");
        return Optional.of(idOperacion);
    }

    public void registrarSalida(OperacionVO operacionVO) {
        java.util.Date fecha = new Date();
        Tses012Operacion operacion = new Tses012Operacion();
        Long idOperacion = secuenciasJoinMapper.nextIdOperacion();
        operacion.setIdRegistro(idOperacion);
        operacion.setIdUsuario(operacionVO.getIdUsuario());
        operacion.setIdPersona(operacionVO.getIdPersona());
        operacion.setIdVisitante(operacionVO.getIdVisitante());
        operacion.setIdAcceso(operacionVO.getIdAcceso());
        operacion.setIdInmueble(operacionVO.getIdInmueble());
        operacion.setFechaOperacion(fecha);
        operacion.setEntradaSalida((short) 0);
        tses012OperacionMapper.insert(operacion);
    }

    public String registrarEntradaSalidaEquipos(OperacionVO operacionVO) throws Exception {
        java.util.Date fecha = new Date();

        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO = usuarioService.consultarPorNombreUsu(operacionVO.getUsuario());
        int idInmueble;
        if (usuarioVO == null) {
            return "2";
        } else {
            idInmueble = usuarioVO.getIdInmueble();
        }
        if (operacionVO.getBandera().equals("1")) {
            Tses027OperacionEquipos consultaUltimaOperacion = new Tses027OperacionEquipos();
            consultaUltimaOperacion = datosEquipoJoinMapper.consultaUltimaOperacion(operacionVO.getIdEquipo(), idInmueble);
            if (consultaUltimaOperacion == null) {
                return "1";
            } /*else if (consultaUltimaOperacion.getEntradaSalida() == 0 && operacionVO.getTipoOperacion() == 0) {
                return "3";
            } else if (consultaUltimaOperacion.getEntradaSalida() == 1 && operacionVO.getTipoOperacion() == 1) {
                return "4";
            }*/ else {
                Tses001UsuariosExample tses001UsuariosExample = new Tses001UsuariosExample();
                tses001UsuariosExample.createCriteria().andNombreUsuEqualTo(usuarioVO.getNombreUsu());
                List<Tses001Usuarios> tses001Usuarios = tses001UsuariosMapper.selectByExample(tses001UsuariosExample);
                Integer idUsuario = tses001Usuarios.get(0).getIdUsuario();
                Tses003RolUsuarioExample tses003RolUsuarioExample = new Tses003RolUsuarioExample();
                tses003RolUsuarioExample.createCriteria().andIdUsuarioEqualTo(idUsuario);
                List<Tses003RolUsuario> tses003RolUsuario = tses003RolUsuarioMapper.selectByExample(tses003RolUsuarioExample);
                if ((tses003RolUsuario.get(0).getIdRol() != 3 /*&& tses003RolUsuario.get(0).getIdRol() != 4*/)) {
                    return "1";
                } else {
                    Tses027OperacionEquipos operacionEquipos = new Tses027OperacionEquipos();
                    operacionEquipos.setEntradaSalida(operacionVO.getTipoOperacion().shortValue());
                    operacionEquipos.setIdEquipo(new Long(operacionVO.getIdEquipo()));
                    operacionEquipos.setIdInmueble(new Long(idInmueble));
                    operacionEquipos.setIdUsuario(new Long(idUsuario));
                    operacionEquipos.setFechaOperacion(fecha);
                    tses027OperacionEquiposMapper.insert(operacionEquipos);
                }
                return "Registro Exitoso";
            }
        } else {
            PasswordEncoder encoder = new ShaPasswordEncoder();
            String encodedPassword = encoder.encodePassword(operacionVO.getPassword(), null);
            String password = usuarioVO.getContrasena();
            Tses027OperacionEquipos consultaUltimaOperacion = new Tses027OperacionEquipos();
            consultaUltimaOperacion = datosEquipoJoinMapper.consultaUltimaOperacion(operacionVO.getIdEquipo(), idInmueble);
            if (consultaUltimaOperacion == null) {
                if (password.equals(encodedPassword)) {
                    Tses001UsuariosExample tses001UsuariosExample = new Tses001UsuariosExample();
                    tses001UsuariosExample.createCriteria().andNombreUsuEqualTo(usuarioVO.getNombreUsu());
                    List<Tses001Usuarios> tses001Usuarios = tses001UsuariosMapper.selectByExample(tses001UsuariosExample);
                    Integer idUsuario = tses001Usuarios.get(0).getIdUsuario();
                    Tses003RolUsuarioExample tses003RolUsuarioExample = new Tses003RolUsuarioExample();
                    tses003RolUsuarioExample.createCriteria().andIdUsuarioEqualTo(idUsuario);
                    List<Tses003RolUsuario> tses003RolUsuario = tses003RolUsuarioMapper.selectByExample(tses003RolUsuarioExample);
                    if ((tses003RolUsuario.get(0).getIdRol() != 3 /*&& tses003RolUsuario.get(0).getIdRol() != 4*/)) {
                        return "1";
                    } else {
                        Tses027OperacionEquipos operacionEquipos = new Tses027OperacionEquipos();
                        operacionEquipos.setEntradaSalida(operacionVO.getTipoOperacion().shortValue());
                        operacionEquipos.setIdEquipo(new Long(operacionVO.getIdEquipo()));
                        operacionEquipos.setIdInmueble(new Long(idInmueble));
                        operacionEquipos.setIdUsuario(new Long(idUsuario));
                        operacionEquipos.setFechaOperacion(fecha);
                        tses027OperacionEquiposMapper.insert(operacionEquipos);
                    }
                    Tses009InmueblesExample tses009InmueblesExample = new Tses009InmueblesExample();
                    tses009InmueblesExample.createCriteria().andIdInmuebleEqualTo(idInmueble);
                    List<Tses009Inmuebles> tses009Inmuebles = tses009InmueblesMapper.selectByExample(tses009InmueblesExample);
                    return "Registro Exitoso en el inmueble " + tses009Inmuebles.get(0).getDenominacion().toLowerCase();
                } else {
                    return "2";
                }
            } /*else if (consultaUltimaOperacion.getEntradaSalida() == 0 && operacionVO.getTipoOperacion() == 0) {
                return "3";
            } else if (consultaUltimaOperacion.getEntradaSalida() == 1 && operacionVO.getTipoOperacion() == 1) {
                return "4";
            }*/ else {
                if (password.equals(encodedPassword)) {
                    Tses001UsuariosExample tses001UsuariosExample = new Tses001UsuariosExample();
                    tses001UsuariosExample.createCriteria().andNombreUsuEqualTo(usuarioVO.getNombreUsu());
                    List<Tses001Usuarios> tses001Usuarios = tses001UsuariosMapper.selectByExample(tses001UsuariosExample);
                    Integer idUsuario = tses001Usuarios.get(0).getIdUsuario();
                    Tses003RolUsuarioExample tses003RolUsuarioExample = new Tses003RolUsuarioExample();
                    tses003RolUsuarioExample.createCriteria().andIdUsuarioEqualTo(idUsuario);
                    List<Tses003RolUsuario> tses003RolUsuario = tses003RolUsuarioMapper.selectByExample(tses003RolUsuarioExample);
                    if ((tses003RolUsuario.get(0).getIdRol() != 3 /*&& tses003RolUsuario.get(0).getIdRol() != 4*/)) {
                        return "1";
                    } else {
                        Tses027OperacionEquipos operacionEquipos = new Tses027OperacionEquipos();
                        operacionEquipos.setEntradaSalida(operacionVO.getTipoOperacion().shortValue());
                        operacionEquipos.setIdEquipo(new Long(operacionVO.getIdEquipo()));
                        operacionEquipos.setIdInmueble(new Long(idInmueble));
                        operacionEquipos.setIdUsuario(new Long(idUsuario));
                        operacionEquipos.setFechaOperacion(fecha);
                        tses027OperacionEquiposMapper.insert(operacionEquipos);
                    }
                    Tses009InmueblesExample tses009InmueblesExample = new Tses009InmueblesExample();
                    tses009InmueblesExample.createCriteria().andIdInmuebleEqualTo(idInmueble);
                    List<Tses009Inmuebles> tses009Inmuebles = tses009InmueblesMapper.selectByExample(tses009InmueblesExample);
                    return "Registro Exitoso en el inmueble " + tses009Inmuebles.get(0).getDenominacion().toLowerCase();
                } else {
                    return "2";
                }
            }
            //}
        }
    }

    public String verificaCredenciales(String usuario, String pass) throws Exception {

        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO = usuarioService.consultarPorNombreUsu(usuario);
        if (usuarioVO == null) {
            return "2";
        } else {
            Integer idUsuario = usuarioVO.getIdUsuario();
            Tses003RolUsuarioExample tses003RolUsuarioExample = new Tses003RolUsuarioExample();
            tses003RolUsuarioExample.createCriteria().andIdUsuarioEqualTo(idUsuario);
            List<Tses003RolUsuario> tses003RolUsuario = tses003RolUsuarioMapper.selectByExample(tses003RolUsuarioExample);
            if ((tses003RolUsuario.get(0).getIdRol() != 3 /*&& tses003RolUsuario.get(0).getIdRol() != 4*/)) {
                return "2";
            } else {
                String password = usuarioVO.getContrasena();
                PasswordEncoder encoder = new ShaPasswordEncoder();
                String encodedPassword = encoder.encodePassword(pass, null);
                if (password.equals(encodedPassword)) {
                    return "1";
                } else {
                    return "2";
                }
            }
        }

    }
}
