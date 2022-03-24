/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.impl;

import java.util.List;
import mx.sep.sesi.dao.Tses013AccesosMapper;
import mx.sep.sesi.dao.join.AccesoJoinMapper;
import mx.sep.sesi.datos.vo.AccesoVO;
import mx.sep.sesi.modelo.Tses013Accesos;
import mx.sep.sesi.servicios.CatAccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel.adame
 */
@Service
public class CatAccesoServiceImpl implements CatAccesoService {

    @Autowired
    AccesoJoinMapper daoAcceso;

    @Autowired
    Tses013AccesosMapper tses013Mapper;

    public List<AccesoVO> obtenerCatAcceso(Integer idInmueble) {

        List<AccesoVO> listAcceso = daoAcceso.obtenerCatAcceso(idInmueble);
        return listAcceso;

    }

    
    @Override
    public String crearAccesoCat(AccesoVO caccesoVO) {

        Tses013Accesos tses013Accesos = new Tses013Accesos();

        try{
        System.out.println("ENTRANDO A SERVICIO");
        Integer idAcceso = caccesoVO.getIdAcceso();
        System.out.println("idAcceso---" + idAcceso);
        tses013Accesos.setIdInmueble(caccesoVO.getIdInmueble());
        tses013Accesos.setDesAcceso(caccesoVO.getDesAcceso());

        if (idAcceso != null) {
            System.out.println("Entrando a update");
            tses013Accesos.setIdAcceso(idAcceso);
            tses013Mapper.updateByPrimaryKeySelective(tses013Accesos);
            System.out.println("update exitoso");
            return "Se han registrado los datos correctamente";
        } else {
            System.out.println("Entrando a Insert");
            tses013Mapper.insertSelective(tses013Accesos);
            return "Se han registrado los datos correctamente";
        }
        }catch (Exception exc) {
            System.out.println("error : " + exc.getMessage());
            return ("Error al insertar inmueble.");
        }
    }
    
    
    public Tses013Accesos obtenerAcceso (Integer idAcceso){
        Tses013Accesos tses013Accesos = new Tses013Accesos();
        tses013Accesos = tses013Mapper.selectByPrimaryKey(idAcceso);
        return tses013Accesos;      
    }
    
     public String eliminaAccesoCat(AccesoVO daccesoVO){
        try {
            Integer idAcceso = daccesoVO.getIdAcceso();
            tses013Mapper.deleteByPrimaryKey(idAcceso);
            return "El registro se ha eliminado correctamente";
        }
        catch (Exception exc){
            return "Ocurrió un error al eliminar el registro";
        }
    }
    
}
