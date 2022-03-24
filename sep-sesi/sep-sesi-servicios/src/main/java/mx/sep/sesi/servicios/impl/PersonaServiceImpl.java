/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import mx.sep.sesi.datos.vo.PersonaVO;
import mx.sep.sesi.datos.vo.VisitanteVO;
import mx.sep.sesi.dao.Tses004PersonasMapper;
import mx.sep.sesi.dao.Tses011VisitantesMapper;
import mx.sep.sesi.dao.Tses020FirmantesMapper;
import mx.sep.sesi.dao.Tses018EtiquetasMapper;
import mx.sep.sesi.dao.Tses023ParametrosMapper;
import mx.sep.sesi.dao.Tses025EquiposVisitanteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.modelo.Tses004PersonasExample;
import mx.sep.sesi.modelo.Tses011Visitantes;
import mx.sep.sesi.modelo.Tses011VisitantesExample;
import mx.sep.sesi.modelo.Tses020Firmantes;
import mx.sep.sesi.modelo.Tses020FirmantesExample;
import mx.sep.sesi.modelo.Tses018Etiquetas;
import mx.sep.sesi.modelo.Tses018EtiquetasExample;
import mx.sep.sesi.modelo.Tses025EquiposVisitante;
import mx.sep.sesi.modelo.Tses025EquiposVisitanteExample;
import mx.sep.sesi.modelo.Tses023Parametros;
import mx.sep.sesi.modelo.Tses018EtiquetasExample;
import mx.sep.sesi.modelo.join.TSES004PersonasJoin;
import mx.sep.sesi.servicios.PersonaService;
import org.springframework.stereotype.Service;
import mx.sep.sesi.dao.join.TSES004PersonasJoinMapper;
import mx.sep.sesi.modelo.join.Tses011VisitanteJoin;

/**
 *
 * @author heriberto.perez
 */
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private Tses004PersonasMapper tses004PersonasMapper;

    @Autowired
    TSES004PersonasJoinMapper daoPersonasJoin;

    @Autowired
    Tses011VisitantesMapper tses011VisitantesMapper;

    @Autowired
    private Tses020FirmantesMapper tses020FirmantesMapper;

    @Autowired
    private Tses018EtiquetasMapper tses018EtiquetasMapper;

    @Autowired
    private Tses023ParametrosMapper tses023ParametrosMapper;

    @Autowired
    private Tses025EquiposVisitanteMapper tses025EquiposVisitanteMapper;

    public String insertaEmpleado(PersonaVO persona) {
        try {
            System.out.println("ENTRANDO A SERVICIO");
            System.out.println("La foto es " + persona.getImagen());
            java.util.Date fecha = new Date();
            Integer idEmpleado = persona.getIdPersona();
            Tses004Personas tses004Personas = new Tses004Personas();
            tses004Personas.setIdTipoPersona(1);
            tses004Personas.setCurp(persona.getCurp());
            tses004Personas.setNombre(persona.getNombre());
            tses004Personas.setApellido1(persona.getPrimerApellido());
            tses004Personas.setApellido2(persona.getSegundoApellido());
            tses004Personas.setIdInmueble((persona.getIdInmueble()));
            tses004Personas.setIdUr(persona.getIdUR());
            tses004Personas.setIdCuadranteArea(persona.getCuadrante());
            tses004Personas.setIdTipoSangre(persona.getTipoSangre());
            tses004Personas.setTelEmergencia((persona.getEmergencia()));
            tses004Personas.setAlergias((persona.getIdAlergia()));
            tses004Personas.setEnfermedad((persona.getEnfermedad()));
            tses004Personas.setPuesto(persona.getPuesto());
            tses004Personas.setFechaActualizacion(fecha);
            tses004Personas.setCorreo(persona.getCorreo());
            tses004Personas.setIdArea(persona.getIdArea());
            if (persona.getImagen().length != 0) {
                tses004Personas.setFotografia(persona.getImagen());
            }
            //tses004Personas.setFotografia(persona.getImagen());
            tses004Personas.setEstatus((persona.getEstatus()));
            if (idEmpleado != null) {
                System.out.println("Entramos en un update");
                tses004Personas.setIdPersona(idEmpleado);
                tses004PersonasMapper.updateByPrimaryKeySelective(tses004Personas);
                System.out.println("update exitoso");
                return "Se han registrado los datos correctamente";
            } else {
                System.out.println("Insert");
                Tses004PersonasExample tses004PersonasExample = new Tses004PersonasExample();
                tses004PersonasExample.createCriteria().andCurpEqualTo(persona.getCurp());
                List<Tses004Personas> registrado = tses004PersonasMapper.selectByExample(tses004PersonasExample);
                if (registrado.isEmpty()) {
                    System.out.println("Entrando a Insert");
                    tses004PersonasMapper.insertSelective(tses004Personas);
                    System.out.println("Insert exitosos");
                    return "Se han registrado los datos correctamente";
                } else {
                    return "Ya se encuentra registrado el usuario.";
                }
            }

        } catch (Exception exc) {
            System.out.println("Error " + exc);
            return ("Error al insertar el empleado");
        }
    }

    public String insertaProveedor(PersonaVO persona) {
        try {
            System.out.println("ENTRANDO A SERVICIO");
            System.out.println("La foto es " + persona.getImagen());
            java.util.Date fecha = new Date();
            Integer idEmpleado = persona.getIdPersona();
            Tses004Personas tses004Personas = new Tses004Personas();
            tses004Personas.setIdTipoPersona((2));
            tses004Personas.setCurp(persona.getCurp());
            tses004Personas.setNombre(persona.getNombre());
            tses004Personas.setApellido1(persona.getPrimerApellido());
            tses004Personas.setApellido2(persona.getSegundoApellido());
            tses004Personas.setIdInmueble((persona.getIdInmueble()));
            tses004Personas.setIdUr((persona.getIdUR()));
            tses004Personas.setIdCuadranteArea((persona.getCuadrante()));
            tses004Personas.setIdTipoSangre((persona.getTipoSangre()));
            tses004Personas.setTelEmergencia((persona.getEmergencia()));
            tses004Personas.setAlergias((persona.getIdAlergia()));
            tses004Personas.setEnfermedad((persona.getEnfermedad()));
            tses004Personas.setPuesto(persona.getPuesto());
            tses004Personas.setFechaActualizacion(fecha);
            tses004Personas.setCorreo(persona.getCorreo());
            if (persona.getImagen().length != 0) {
                tses004Personas.setFotografia(persona.getImagen());
            }
            tses004Personas.setEstatus((persona.getEstatus()));
            if (idEmpleado != null) {
                System.out.println("Entramos en un update");
                tses004Personas.setIdPersona((idEmpleado));
                tses004PersonasMapper.updateByPrimaryKeySelective(tses004Personas);
                System.out.println("update exitoso");
                return "Se han registrado los datos correctamente";
            } else {
                System.out.println("Insert");
                Tses004PersonasExample tses004PersonasExample = new Tses004PersonasExample();
                tses004PersonasExample.createCriteria().andCurpEqualTo(persona.getCurp());
                List<Tses004Personas> registrado = tses004PersonasMapper.selectByExample(tses004PersonasExample);
                if (registrado.isEmpty()) {
                    System.out.println("Entrando a Insert");
                    tses004PersonasMapper.insertSelective(tses004Personas);
                    System.out.println("Insert exitosos");
                    return "Se han registrado los datos correctamente";
                } else {
                    return "Ya se encuentra registrado el usuario.";
                }
            }

        } catch (Exception exc) {
            System.out.println("Error " + exc);
            return ("Error al insertar el proveedor");
        }
    }

    public String insertaVisitante(PersonaVO persona) {
        Tses018Etiquetas tses018Etiquetas = new Tses018Etiquetas();
        Tses018Etiquetas update018 = new Tses018Etiquetas();
        tses018Etiquetas = tses018EtiquetasMapper.selectByPrimaryKey(persona.getNumEtiqueta(), persona.getIdInmueble());
        Tses025EquiposVisitante tses025EquiposVisitante = new Tses025EquiposVisitante();
        Tses025EquiposVisitanteExample updateInsert025 = new Tses025EquiposVisitanteExample();
//System.out.println("Estatus " + tses018Etiquetas.getEstatus());
        Short estatus = 1;
        if (tses018Etiquetas == null) {
            //return "No se encuentra registrado ese n&uacute;mero de etiqueta";
            return "1";
        } else {
            if (tses018Etiquetas.getEstatus() == 0) {
                try {
                    System.out.println("ENTRANDO A SERVICIO");
                    java.util.Date fecha = new Date();
                    Long idVisitante = null;
                    if (persona.getIdPersona() != null) {
                        idVisitante = Long.valueOf(persona.getIdPersona());
                    }

                    Tses011Visitantes tses011Visitantes = new Tses011Visitantes();
                    tses011Visitantes.setIdTipoPersona((3));
                    tses011Visitantes.setCurp(persona.getCurp());
                    tses011Visitantes.setNombre(persona.getNombre());
                    tses011Visitantes.setApellido1(persona.getPrimerApellido());
                    tses011Visitantes.setApellido2(persona.getSegundoApellido());
                    tses011Visitantes.setIdInmueble((persona.getIdInmueble()));
                    tses011Visitantes.setIdUr((persona.getIdUR()));
                    tses011Visitantes.setIdCuadranteArea((persona.getCuadrante()));
                    tses011Visitantes.setPersonaVisita(persona.getPersonaVisita());
                    tses011Visitantes.setFechaActualizacion(fecha);
                    tses011Visitantes.setIdEtiqueta((persona.getNumEtiqueta()));
                    if (persona.getImagen().length != 0) {
                        tses011Visitantes.setFotografia(persona.getImagen());
                    }
                    if (idVisitante != null) {
                        System.out.println("Entrando a update");
                        Tses011VisitantesExample tses011VisitantesExample = new Tses011VisitantesExample();
                        tses011VisitantesExample.createCriteria().andCurpEqualTo(persona.getCurp());
                        List<Tses011Visitantes> registrado = tses011VisitantesMapper.selectByExample(tses011VisitantesExample);
                        System.out.println("Registrado es " + registrado.size());
                        //if (registrado.size() <= 1) {
                        tses011Visitantes.setIdVisitante(idVisitante);
                        tses011VisitantesMapper.updateByPrimaryKeySelective(tses011Visitantes);
                        update018.setIdEtiqueta(persona.getNumEtiqueta());
                        update018.setIdInmueble(persona.getIdInmueble());
                        update018.setEstatus(estatus);
                        tses018EtiquetasMapper.updateByPrimaryKeySelective(update018);
                        int lista = persona.getEquiposVisitante().size();
                        if (lista > 0) {
                            for (int i = 0; i < lista; i++) {
                                updateInsert025.createCriteria().andNumeroSerieVisEqualTo(persona.getEquiposVisitante().get(0).getNumeroSerie()).andIdVisitanteEqualTo(idVisitante);
                                List<Tses025EquiposVisitante> tses025EquiposVisitante1 = tses025EquiposVisitanteMapper.selectByExample(updateInsert025);
                                if (persona.getEquiposVisitante().get(i).getEstatus().equals("0")) {
                                    Short estatusEquipo = 0;
                                    tses025EquiposVisitante.setEstatus(estatusEquipo);
                                } else if (persona.getEquiposVisitante().get(i).getEstatus().equals("1")) {
                                    Short estatusEquipo = 1;
                                    tses025EquiposVisitante.setEstatus(estatusEquipo);
                                }
                                tses025EquiposVisitante.setDescripcionEquipoVis(persona.getEquiposVisitante().get(0).getDescripcion());
                                tses025EquiposVisitante.setMarcaVis(persona.getEquiposVisitante().get(0).getMarca());
                                tses025EquiposVisitante.setNumeroSerieVis(persona.getEquiposVisitante().get(0).getNumeroSerie());
                                tses025EquiposVisitante.setIdVisitante(idVisitante);
                                if (tses025EquiposVisitante1.size() > 0) {
                                    tses025EquiposVisitanteMapper.updateByPrimaryKey(tses025EquiposVisitante);
                                } else {
                                    tses025EquiposVisitanteMapper.insertSelective(tses025EquiposVisitante);
                                }
                            }
                        }
                        return "Se han registrado los datos correctamente";
                        //} else {
                        // return "Ya se encuentra registrado el usuario.";
                        //}
                    } else {
                        Tses011VisitantesExample tses011VisitantesExample = new Tses011VisitantesExample();
                        tses011VisitantesExample.createCriteria().andCurpEqualTo(persona.getCurp());
                        List<Tses011Visitantes> registrado = tses011VisitantesMapper.selectByExample(tses011VisitantesExample);
                        if (registrado.isEmpty()) {
                            System.out.println("Entrando a Insert");
                            tses011VisitantesMapper.insertSelective(tses011Visitantes);
                            update018.setIdEtiqueta(persona.getNumEtiqueta());
                            update018.setIdInmueble(persona.getIdInmueble());
                            update018.setEstatus(estatus);
                            tses018EtiquetasMapper.updateByPrimaryKeySelective(update018);

                            return "Se han registrado los datos correctamente";
                        } else {
                            return "Ya se encuentra registrado el usuario.";
                        }
                    }

                } catch (Exception exc) {
                    return ("Error al insertar al visitante.");
                }
            } else {
                //return "Ya esta asignada ese n&uacute;mero de etiqueta, selecciona otra";
                return "2";
            }
        }

    }

    public String insertaEquipos(PersonaVO persona) {
        int lista = persona.getEquiposVisitante().size();
        Tses011VisitantesExample buscarIdVisitante = new Tses011VisitantesExample();
        buscarIdVisitante.createCriteria().andIdEtiquetaEqualTo(persona.getNumEtiqueta());
        List<Tses011Visitantes> idVisitanteEquipo = tses011VisitantesMapper.selectByExample(buscarIdVisitante);
        Tses025EquiposVisitante tses025EquiposVisitante = new Tses025EquiposVisitante();
        try {
            for (int i = 0; i < lista; i++) {
                if (persona.getEquiposVisitante().get(i).getEstatus().equals("0")) {
                    Short estatusEquipo = 0;
                    tses025EquiposVisitante.setEstatus(estatusEquipo);
                } else if (persona.getEquiposVisitante().get(i).getEstatus().equals("1")) {
                    Short estatusEquipo = 1;
                    tses025EquiposVisitante.setEstatus(estatusEquipo);
                }
                tses025EquiposVisitante.setDescripcionEquipoVis(persona.getEquiposVisitante().get(0).getDescripcion());
                tses025EquiposVisitante.setMarcaVis(persona.getEquiposVisitante().get(0).getMarca());
                tses025EquiposVisitante.setNumeroSerieVis(persona.getEquiposVisitante().get(0).getNumeroSerie());
                tses025EquiposVisitante.setIdVisitante(idVisitanteEquipo.get(0).getIdVisitante());
                tses025EquiposVisitanteMapper.insertSelective(tses025EquiposVisitante);
                
            }
            return "Se han registrado los datos correctamente";
        } catch (Exception exc) {
            return ("Error al insertar el equipo del visitante.");
        }
    }

    public String verificaCurp(String curp) {
        Tses004PersonasExample tses004PersonasExample = new Tses004PersonasExample();
        tses004PersonasExample.createCriteria().andCurpEqualTo(curp);
        List<Tses004Personas> registrado = tses004PersonasMapper.selectByExample(tses004PersonasExample);
        if (registrado.isEmpty()) {
            return " ";
        } else {
            return "Ya se encuentra registrado el usuario.";
        }
    }

    public String verificaCurpVisitante(String curp) {
        Tses011VisitantesExample tses011VisitantesExample = new Tses011VisitantesExample();
        tses011VisitantesExample.createCriteria().andCurpEqualTo(curp);
        List<Tses011Visitantes> registrado = tses011VisitantesMapper.selectByExample(tses011VisitantesExample);
        if (registrado.isEmpty()) {
            return " ";
        } else {
            return "Ya se encuentra registrado el usuario.";
        }
    }

    public String verificaFirmante(Integer ur) {
        Tses020FirmantesExample tses020FirmantesExample = new Tses020FirmantesExample();
        tses020FirmantesExample.createCriteria().andIdUrEqualTo(ur);
        List<Tses020Firmantes> existe = tses020FirmantesMapper.selectByExample(tses020FirmantesExample);
        if (existe.isEmpty()) {
            return "No hay ningún firmante asignado a esta UR, favor de verificar";
        } else {
            return "Si existe";
        }
    }

    public Tses004Personas obtenerPersona(Integer idPersona) {
        Tses004Personas tses004Personas = new Tses004Personas();
        tses004Personas = tses004PersonasMapper.selectByPrimaryKey(idPersona);
        return tses004Personas;
    }

    public VisitanteVO obtenerVisitante(Long idVisitante) {
        Tses011Visitantes tses011Visitantes = new Tses011Visitantes();
        tses011Visitantes = tses011VisitantesMapper.selectByPrimaryKey(idVisitante);
        VisitanteVO visitante = new VisitanteVO();
        visitante.setIdVisitante(tses011Visitantes.getIdVisitante());
        visitante.setIdEtiqueta(tses011Visitantes.getIdEtiqueta());
        visitante.setIdTipoPersona(tses011Visitantes.getIdTipoPersona());
        visitante.setIdInmueble(tses011Visitantes.getIdInmueble());
        visitante.setIdCuadranteArea(tses011Visitantes.getIdCuadranteArea());
        visitante.setIdUr(tses011Visitantes.getIdUr());
        visitante.setCurp(tses011Visitantes.getCurp());
        visitante.setApellido1(tses011Visitantes.getApellido1());
        visitante.setApellido2(tses011Visitantes.getApellido2());
        visitante.setNombre(tses011Visitantes.getNombre());
        visitante.setFotografia(tses011Visitantes.getFotografia());
        visitante.setPersonaVisita(tses011Visitantes.getPersonaVisita());
        visitante.setFechaActualizacion(tses011Visitantes.getFechaActualizacion());
        Tses025EquiposVisitanteExample tses025EquiposVisitanteExample = new Tses025EquiposVisitanteExample();
        tses025EquiposVisitanteExample.createCriteria().andIdVisitanteEqualTo(idVisitante);
        List<Tses025EquiposVisitante> tses025EquiposVisitante = tses025EquiposVisitanteMapper.selectByExample(tses025EquiposVisitanteExample);
        if (tses025EquiposVisitante.size() > 0) {
            List<Tses025EquiposVisitante> equipoVisitante = new ArrayList<Tses025EquiposVisitante>();
            for (int i = 0; i < tses025EquiposVisitante.size(); i++) {
                Tses025EquiposVisitante tses025EquiposVisitante1 = new Tses025EquiposVisitante();
                tses025EquiposVisitante1.setDescripcionEquipoVis(tses025EquiposVisitante.get(i).getDescripcionEquipoVis());
                tses025EquiposVisitante1.setMarcaVis(tses025EquiposVisitante.get(i).getMarcaVis());
                tses025EquiposVisitante1.setNumeroSerieVis(tses025EquiposVisitante.get(i).getNumeroSerieVis());
                if (tses025EquiposVisitante.get(i).getEstatus() == 1) {
                    tses025EquiposVisitante1.setEstatusS("checked");
                } else {
                    tses025EquiposVisitante1.setEstatusS("");
                }
                tses025EquiposVisitante1.setEstatus(tses025EquiposVisitante.get(i).getEstatus());
                equipoVisitante.add(tses025EquiposVisitante1);
            }
            visitante.setEquiposVisitante(equipoVisitante);
        }
        return visitante;
    }

    @Override
    public List<TSES004PersonasJoin> obtenerAllPersonaRol(Integer idTipoPersona, Integer idUr, String curp, String nombre, String primerApellido, String segundoApellido) {

        List<TSES004PersonasJoin> listAllPesonas = daoPersonasJoin.selecPersonas(idTipoPersona, idUr, curp, nombre, primerApellido, segundoApellido);
        return listAllPesonas;

    }

    public List<Tses011VisitanteJoin> obtenerVisitantes(String curp, String nombre, Integer idUr) {

        List<Tses011VisitanteJoin> listAllVisitantes = daoPersonasJoin.selectVisitantes(curp, nombre, idUr);
        return listAllVisitantes;

    }

    /**
     * @param criterios lista de id de personas a obtener
     */
    public List<Tses004Personas> obtenerListaPersonas(List<Integer> criterios) {

        Tses004PersonasExample tses004PersonasExample = new Tses004PersonasExample();
        tses004PersonasExample.createCriteria().andIdPersonaIn(criterios);
        List<Tses004Personas> listPersonas = tses004PersonasMapper.selectByExample(tses004PersonasExample);
        return listPersonas;

    }

    /**
     * @param criterios lista de id de personas a obtener
     */
    public List<Tses018Etiquetas> obtenerListaVisitantes(List<Long> criterios, Integer idInmueble) {

        Tses018EtiquetasExample tses018EtiquetasExample = new Tses018EtiquetasExample();
        tses018EtiquetasExample.createCriteria().andIdEtiquetaIn(criterios).andIdInmuebleEqualTo(idInmueble);
        List<Tses018Etiquetas> listVisitantes = tses018EtiquetasMapper.selectByExample(tses018EtiquetasExample);
        return listVisitantes;

    }

    /**
     * Función que obtiene la url para mostrar en el QR
     */
    public String obtieneURLQr() {
        Tses023Parametros tses023Parametros = new Tses023Parametros();
        tses023Parametros = tses023ParametrosMapper.selectByPrimaryKey(new Integer(1));
        String url = tses023Parametros.getValor();
        return url;

    }

    /**
     * Función que obtiene el valor para encriptar
     */
    public String obtieneValorSecreto() {
        Tses023Parametros tses023Parametros = new Tses023Parametros();
        tses023Parametros = tses023ParametrosMapper.selectByPrimaryKey(new Integer(2));
        String url = tses023Parametros.getValor();
        return url;

    }
}
