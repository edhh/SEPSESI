/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import mx.sep.sesi.dao.join.DatosEquipoJoinMapper;
import mx.sep.sesi.servicios.ObtenerDatosEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Service;
import mx.sep.sesi.datos.vo.DatosEquipoVO;
import org.springframework.jdbc.UncategorizedSQLException;
import mx.sep.sesi.modelo.Tses024Equipos;
import mx.sep.sesi.modelo.Tses024EquiposExample;
import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.modelo.Tses004PersonasExample;
import mx.sep.sesi.dao.Tses024EquiposMapper;
import mx.sep.sesi.dao.Tses004PersonasMapper;

/**
 *
 * @author HeribertoGonzálezPér
 */
@Service
public class ObtenerDatosEquipoServiceImpl implements ObtenerDatosEquipoService, MessageSourceAware {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private DatosEquipoJoinMapper datosEquipoJoinMapper;

    @Autowired
    private Tses024EquiposMapper tses024EquiposMapper;

    @Autowired
    private Tses004PersonasMapper tses004PersonasMapper;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public DatosEquipoVO obtieneDatosEquipo(DatosEquipoVO datosEquipoVO) {
        DatosEquipoVO aDatosEquipoVO = new DatosEquipoVO();
        Long tipoOperacion = datosEquipoVO.getTipoOperacion();
        java.util.Date fecha = new Date();
        if (datosEquipoVO.getCorreo() != null && datosEquipoVO.getCurp()!= null && datosEquipoVO.getIdPartida() != null && datosEquipoVO.getNumSerie() != null && datosEquipoVO.getTipoOperacion() != null){
            aDatosEquipoVO.setTipoError("Faltan argumentos en la petición");
            aDatosEquipoVO.setStatusOper(new Short("4"));
            return aDatosEquipoVO;
        }
        if (tipoOperacion == 1) {
            Tses024EquiposExample tses024EquiposExample = new Tses024EquiposExample();
            tses024EquiposExample.createCriteria().andNumSerieEqualTo(datosEquipoVO.getNumSerie());
            List<Tses024Equipos> tses024Equipos = tses024EquiposMapper.selectByExample(tses024EquiposExample);
            if (tses024Equipos.size() > 0) {
                aDatosEquipoVO.setStatusOper(new Short("1"));
                aDatosEquipoVO.setTipoError("Ya esta asignado ese número de serie a un empleado");
                return aDatosEquipoVO;
            } else {
                Tses004PersonasExample tses004PersonasExample = new Tses004PersonasExample();
                tses004PersonasExample.createCriteria().andCurpEqualTo(datosEquipoVO.getCurp());
                List<Tses004Personas> tses004Personas = tses004PersonasMapper.selectByExample(tses004PersonasExample);
                if (tses004Personas.size() > 0) {
                    try {
                        Tses024Equipos tses024EquiposInsert = new Tses024Equipos();
                        tses024EquiposInsert.setIdPersona(tses004Personas.get(0).getIdPersona().longValue());
                        tses024EquiposInsert.setIdPartida(datosEquipoVO.getIdPartida());
                        tses024EquiposInsert.setNumSerie(datosEquipoVO.getNumSerie());
                        tses024EquiposInsert.setTipooperacion(datosEquipoVO.getTipoOperacion());
                        tses024EquiposInsert.setFechaAsignacion(fecha);
                        tses024EquiposMapper.insert(tses024EquiposInsert);
                        aDatosEquipoVO = datosEquipoJoinMapper.cunsultaDatosEquipo(datosEquipoVO);
                        if (aDatosEquipoVO.getCurp() != null) {
                            aDatosEquipoVO.setStatusOper(new Short("5"));
                            return aDatosEquipoVO;
                        } else {
                            aDatosEquipoVO.setStatusOper(new Short("0"));
                            aDatosEquipoVO.setTipoError("No existen datos");
                            return aDatosEquipoVO;
                        }
                    } catch (UncategorizedSQLException ex) {
                        System.out.println("--- UncategorizedSQLException --- : " + ex.getSQLException().getErrorCode() + ", " + ex.getSQLException().getMessage());
                        String errorCode = Integer.toString(ex.getSQLException().getErrorCode());
                        String msjSQLException = messageSource.getMessage("servicios.consulta.sesi.errorcode." + errorCode, new Object[]{errorCode}, null);
                        aDatosEquipoVO = new DatosEquipoVO();
                        aDatosEquipoVO.setStatusOper(new Short("2"));
                        aDatosEquipoVO.setTipoError(msjSQLException);
                        return aDatosEquipoVO;
                    } catch (Exception ex) {
                        System.out.println("--- Exception --- : " + ex.getMessage());
                        aDatosEquipoVO = new DatosEquipoVO();
                        String msjException = this.messageSource.getMessage("servicios.consulta.sesi.exception", new Object[]{}, null);
                        aDatosEquipoVO.setStatusOper(new Short("2"));
                        aDatosEquipoVO.setTipoError(msjException + " " + ex.getMessage());
                        return aDatosEquipoVO;
                    }
                } else {
                    aDatosEquipoVO.setStatusOper(new Short("3"));
                    aDatosEquipoVO.setTipoError("No se encontro al empleado");
                    return aDatosEquipoVO;
                }
            }
        }
        if (tipoOperacion == 2) {
            Tses004PersonasExample tses004PersonasExample = new Tses004PersonasExample();
            tses004PersonasExample.createCriteria().andCurpEqualTo(datosEquipoVO.getCurp());
            List<Tses004Personas> tses004Personas = tses004PersonasMapper.selectByExample(tses004PersonasExample);
            if (tses004Personas.size() > 0) {
                Tses024EquiposExample tses024EquiposExample = new Tses024EquiposExample();
                tses024EquiposExample.createCriteria().andNumSerieEqualTo(datosEquipoVO.getNumSerie()).andIdPersonaEqualTo(tses004Personas.get(0).getIdPersona().longValue());
                List<Tses024Equipos> tses024Equipos = tses024EquiposMapper.selectByExample(tses024EquiposExample);
                if (tses024Equipos.size() > 0) {
                    try {
                        Tses024EquiposExample tses024EquiposExampleUdpate = new Tses024EquiposExample();
                        tses024EquiposExampleUdpate.createCriteria().andIdPersonaEqualTo(tses004Personas.get(0).getIdPersona().longValue()).andNumSerieEqualTo(datosEquipoVO.getNumSerie());
                        Tses024Equipos tses024EquiposInsert = new Tses024Equipos();
                        tses024EquiposInsert.setIdPersona(tses004Personas.get(0).getIdPersona().longValue());
                        tses024EquiposInsert.setIdPartida(datosEquipoVO.getIdPartida());
                        tses024EquiposInsert.setNumSerie(datosEquipoVO.getNumSerie());
                        tses024EquiposInsert.setTipooperacion(datosEquipoVO.getTipoOperacion());
                        tses024EquiposInsert.setFechaAsignacion(fecha);
                        tses024EquiposMapper.updateByExampleSelective(tses024EquiposInsert, tses024EquiposExampleUdpate);
                        //tses024EquiposMapper.updateByPrimaryKey(tses024EquiposInsert);
                        aDatosEquipoVO = datosEquipoJoinMapper.cunsultaDatosEquipo(datosEquipoVO);
                        if (aDatosEquipoVO.getCurp() != null) {
                            aDatosEquipoVO.setStatusOper(new Short("5"));
                            return aDatosEquipoVO;
                        } else {
                            aDatosEquipoVO.setStatusOper(new Short("0"));
                            aDatosEquipoVO.setTipoError("No existen datos");
                            return aDatosEquipoVO;
                        }
                    } catch (UncategorizedSQLException ex) {
                        System.out.println("--- UncategorizedSQLException --- : " + ex.getSQLException().getErrorCode() + ", " + ex.getSQLException().getMessage());
                        String errorCode = Integer.toString(ex.getSQLException().getErrorCode());
                        String msjSQLException = messageSource.getMessage("servicios.consulta.sesi.errorcode." + errorCode, new Object[]{errorCode}, null);
                        aDatosEquipoVO = new DatosEquipoVO();
                        aDatosEquipoVO.setStatusOper(new Short("2"));
                        aDatosEquipoVO.setTipoError(msjSQLException);
                        return aDatosEquipoVO;
                    } catch (Exception ex) {
                        System.out.println("--- Exception --- : " + ex.getMessage());
                        aDatosEquipoVO = new DatosEquipoVO();
                        String msjException = this.messageSource.getMessage("servicios.consulta.sesi.exception", new Object[]{}, null);
                        aDatosEquipoVO.setStatusOper(new Short("2"));
                        aDatosEquipoVO.setTipoError(msjException + " " + ex.getMessage());
                        return aDatosEquipoVO;
                    }
                } else {
                    aDatosEquipoVO.setStatusOper(new Short("2"));
                    aDatosEquipoVO.setTipoError("No se encontro ese número de serie asociado a ese empleado");
                    return aDatosEquipoVO;
                }
            }

        }
        if (tipoOperacion == 3) {
            Tses004PersonasExample tses004PersonasExample = new Tses004PersonasExample();
            tses004PersonasExample.createCriteria().andCurpEqualTo(datosEquipoVO.getCurp());
            List<Tses004Personas> tses004Personas = tses004PersonasMapper.selectByExample(tses004PersonasExample);
            if (tses004Personas.size() > 0) {
                Tses024EquiposExample tses024EquiposExample = new Tses024EquiposExample();
                tses024EquiposExample.createCriteria().andNumSerieEqualTo(datosEquipoVO.getNumSerie()).andIdPersonaEqualTo(tses004Personas.get(0).getIdPersona().longValue());
                List<Tses024Equipos> tses024Equipos = tses024EquiposMapper.selectByExample(tses024EquiposExample);
                if (tses024Equipos.size() > 0) {
                    try {
                        /*Tses024Equipos tses024EquiposInsert = new Tses024Equipos();
                        tses024EquiposInsert.setIdPersona(tses004Personas.get(0).getIdPersona().longValue());
                        tses024EquiposInsert.setIdPartida(datosEquipoVO.getIdPartida());
                        tses024EquiposInsert.setNumSerie(datosEquipoVO.getNumSerie());
                        tses024EquiposInsert.setTipooperacion(datosEquipoVO.getTipoOperacion());
                        tses024EquiposInsert.setFechaAsignacion(fecha);
                        tses024EquiposMapper.insert(tses024EquiposInsert);
                        Tses024Equipos tses024EquiposBaja = new Tses024Equipos();
                        tses024EquiposBaja.setIdPersona(tses024Equipos.get(0).getIdPersona());
                        tses024EquiposBaja.setFechaAsignacion(fecha);
                        tses024EquiposBaja.setTipooperacion(tipoOperacion);
                        tses024EquiposMapper.updateByPrimaryKey(tses024EquiposBaja);*/
                        Tses024EquiposExample tses024EquiposExampleUdpate = new Tses024EquiposExample();
                        tses024EquiposExampleUdpate.createCriteria().andIdPersonaEqualTo(tses004Personas.get(0).getIdPersona().longValue()).andNumSerieEqualTo(datosEquipoVO.getNumSerie());
                        Tses024Equipos tses024EquiposInsert = new Tses024Equipos();
                        tses024EquiposInsert.setIdPersona(tses004Personas.get(0).getIdPersona().longValue());
                        tses024EquiposInsert.setIdPartida(datosEquipoVO.getIdPartida());
                        tses024EquiposInsert.setNumSerie(datosEquipoVO.getNumSerie());
                        tses024EquiposInsert.setTipooperacion(datosEquipoVO.getTipoOperacion());
                        tses024EquiposInsert.setFechaAsignacion(fecha);
                        tses024EquiposMapper.updateByExampleSelective(tses024EquiposInsert, tses024EquiposExampleUdpate);
                        aDatosEquipoVO = datosEquipoJoinMapper.cunsultaDatosEquipo(datosEquipoVO);
                        if (aDatosEquipoVO.getCurp() != null) {
                            aDatosEquipoVO.setStatusOper(new Short("5"));
                            return aDatosEquipoVO;
                        } else {
                            aDatosEquipoVO.setStatusOper(new Short("0"));
                            aDatosEquipoVO.setTipoError("No existen datos");
                            return aDatosEquipoVO;
                        }
                    } catch (UncategorizedSQLException ex) {
                        System.out.println("--- UncategorizedSQLException --- : " + ex.getSQLException().getErrorCode() + ", " + ex.getSQLException().getMessage());
                        String errorCode = Integer.toString(ex.getSQLException().getErrorCode());
                        String msjSQLException = messageSource.getMessage("servicios.consulta.sesi.errorcode." + errorCode, new Object[]{errorCode}, null);
                        aDatosEquipoVO = new DatosEquipoVO();
                        aDatosEquipoVO.setStatusOper(new Short("2"));
                        aDatosEquipoVO.setTipoError(msjSQLException);
                        return aDatosEquipoVO;
                    } catch (Exception ex) {
                        System.out.println("--- Exception --- : " + ex.getMessage());
                        aDatosEquipoVO = new DatosEquipoVO();
                        String msjException = this.messageSource.getMessage("servicios.consulta.sesi.exception", new Object[]{}, null);
                        aDatosEquipoVO.setStatusOper(new Short("2"));
                        aDatosEquipoVO.setTipoError(msjException + " " + ex.getMessage());
                        return aDatosEquipoVO;
                    }
                } else {
                    aDatosEquipoVO.setStatusOper(new Short("3"));
                    aDatosEquipoVO.setTipoError("No se encontro ese número de serie asociado a ese empleado");
                    return aDatosEquipoVO;
                }
            }
        }
        else{
            aDatosEquipoVO.setStatusOper(new Short("4"));
            aDatosEquipoVO.setTipoError("Faltan argumentos en la petición");
            return aDatosEquipoVO;
        }
       /* try {
            aDatosEquipoVO = datosEquipoJoinMapper.cunsultaDatosEquipo(datosEquipoVO);
            if (aDatosEquipoVO.getCurp() != null) {
                aDatosEquipoVO.setStatusOper(new Short("1"));
            } else {
                aDatosEquipoVO.setStatusOper(new Short("0"));
                aDatosEquipoVO.setTipoError("No existen datos");
            }
        } catch (UncategorizedSQLException ex) {
            System.out.println("--- UncategorizedSQLException --- : " + ex.getSQLException().getErrorCode() + ", " + ex.getSQLException().getMessage());
            String errorCode = Integer.toString(ex.getSQLException().getErrorCode());
            String msjSQLException = messageSource.getMessage("servicios.consulta.sesi.errorcode." + errorCode, new Object[]{errorCode}, null);
            aDatosEquipoVO = new DatosEquipoVO();
            aDatosEquipoVO.setStatusOper(new Short("2"));
            aDatosEquipoVO.setTipoError(msjSQLException);
        } catch (SQLException ex) {
            System.out.println("--- SQLException --- : " + ex.getErrorCode() + ", " + ex.getMessage());
            String errorCode = Integer.toString(ex.getErrorCode());
            String msjSQLException = messageSource.getMessage("servicios.consulta.sesi.errorcode." + errorCode, new Object[]{errorCode}, null);
            aDatosEquipoVO = new DatosEquipoVO();
            aDatosEquipoVO.setStatusOper(new Short("2"));
            aDatosEquipoVO.setTipoError(msjSQLException);
        } catch (Exception ex) {
            System.out.println("--- Exception --- : " + ex.getMessage());
            aDatosEquipoVO = new DatosEquipoVO();
            String msjException = this.messageSource.getMessage("servicios.consulta.sesi.exception", new Object[]{}, null);
            aDatosEquipoVO.setStatusOper(new Short("2"));
            aDatosEquipoVO.setTipoError(msjException + " " + ex.getMessage());
        }*/
        return aDatosEquipoVO;
    }

}
