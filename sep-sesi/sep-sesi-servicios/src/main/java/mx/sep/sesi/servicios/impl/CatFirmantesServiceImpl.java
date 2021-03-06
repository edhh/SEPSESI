/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.impl;

import java.util.ArrayList;
import java.util.List;
import mx.sep.sesi.dao.Tses020FirmantesMapper;
import mx.sep.sesi.dao.join.FirmantesJoinMapper;
import mx.sep.sesi.dao.join.SecuenciasJoinMapper;
import mx.sep.sesi.datos.vo.FirmantesVO;
import mx.sep.sesi.modelo.Tses020Firmantes;
import mx.sep.sesi.modelo.Tses020FirmantesExample;
import mx.sep.sesi.servicios.CatFirmantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel.adame
 */
@Service
public class CatFirmantesServiceImpl implements CatFirmantesService {

    @Autowired
    Tses020FirmantesMapper tses020firmantesMapper;

    @Autowired
    FirmantesJoinMapper firmantesMap;

    @Autowired
    SecuenciasJoinMapper secuenceMapper;

    public List<FirmantesVO> obtenerCatFirmante(Integer idUr) {

        List<FirmantesVO> listFirmantes = firmantesMap.obtenerCatUsuario(idUr);

        return listFirmantes;

    }

    public String insertaFirmante(FirmantesVO cfirmanteVO) {
        Tses020Firmantes tses020Firmantes = new Tses020Firmantes();

        try {
            System.out.println("ENTRANDO A SERVICIO");
            Integer idFirmante = cfirmanteVO.getIdFirmante();
            System.out.println("idfirmantes---" + idFirmante);
            tses020Firmantes.setIdUr(cfirmanteVO.getIdUr());
            tses020Firmantes.setNombreAutoriza(cfirmanteVO.getNombreAutoriza());
            tses020Firmantes.setPuestoAutoriza(cfirmanteVO.getPuestoAutoriza());
            if (cfirmanteVO.getImagen().length != 0) {
                tses020Firmantes.setFotografia(cfirmanteVO.getImagen());
            }
            if (idFirmante != null) {
                System.out.println("Entrando a update");
                tses020Firmantes.setIdFirmante(idFirmante);
                tses020firmantesMapper.updateByPrimaryKeySelective(tses020Firmantes);
                System.out.println("update exitoso");
                return "Se han registrado los datos correctamente";
            } else {
                Tses020FirmantesExample tses020FirmantesExample = new Tses020FirmantesExample();
                tses020FirmantesExample.createCriteria().andIdUrEqualTo(cfirmanteVO.getIdUr());
                List<Tses020Firmantes> registrado = tses020firmantesMapper.selectByExample(tses020FirmantesExample);
                if (registrado.isEmpty()) {
                    System.out.println("Entrando a Insert");
                    Integer idFirma = secuenceMapper.nextIdFirmante();
                    tses020Firmantes.setIdFirmante(idFirma);
                    System.out.println("idFirmante----" + idFirma);
                    // tses020Firmantes.setIdUr(cfirmanteVO.getIdUr());
                    //tses020Firmantes.setNombreAutoriza(cfirmanteVO.getNombreAutoriza());
                    //tses020Firmantes.setPuestoAutoriza(cfirmanteVO.getPuestoAutoriza());
                    tses020firmantesMapper.insertSelective(tses020Firmantes);
                    return "Se han registrado los datos correctamente";

                } else {
                    System.out.println("Ya existe un firmante por esa Unidad Responsable.");
                    //return "Ya existe un firmante por esa Unidad Responsable.";
                    return "2";
                }
            }

        } catch (Exception exc) {
            System.out.println("error : " + exc.getMessage());
            return ("Error al insertar firmante.");
        }
    }

    /*public FirmantesVO insertaFirmante(FirmantesVO cfirmanteVO) {
     Tses020Firmantes tses020Firmantes = new Tses020Firmantes();
     Integer idFirmante = secuenceMapper.nextIdFirmante();
     tses020Firmantes.setIdFirmante(new BigDecimal(idFirmante));
     tses020Firmantes.setIdUr(cfirmanteVO.getIdUr());
     tses020Firmantes.setNombreAutoriza(cfirmanteVO.getNombreAutoriza());
     tses020Firmantes.setPuestoAutoriza(cfirmanteVO.getPuestoAutoriza());
     tses020firmantesMapper.insertSelective(tses020Firmantes);
     return cfirmanteVO;
     }*/
    public Tses020Firmantes obtenerFirmante(Integer idFirmante) {
        Tses020Firmantes tses020Firmantes = new Tses020Firmantes();
        tses020Firmantes = tses020firmantesMapper.selectByPrimaryKey(idFirmante);
        return tses020Firmantes;
    }

    @Override
    public List<Tses020Firmantes> verificaUR(Tses020Firmantes tses020Firmantes) {
        Tses020Firmantes tses020Firm = new Tses020Firmantes();
        tses020Firm.setIdUr(tses020Firmantes.getIdUr());
        Tses020FirmantesExample tses020FirmantesExample = new Tses020FirmantesExample();
        tses020FirmantesExample.createCriteria().andIdUrEqualTo(tses020Firmantes.getIdUr());
        List<Tses020Firmantes> registrado = tses020firmantesMapper.selectByExample(tses020FirmantesExample);
        return registrado;

    }

}
