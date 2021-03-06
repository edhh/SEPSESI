
package mx.sep.sesi.servicios.impl;

import java.math.BigDecimal;
import java.util.List;
import mx.sep.sesi.dao.Tses009InmueblesMapper;
import mx.sep.sesi.dao.join.InmueblesJoinMapper;
import mx.sep.sesi.datos.vo.InmuebleVO;
import mx.sep.sesi.modelo.Tses009Inmuebles;
import mx.sep.sesi.servicios.CatInmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel.adame
 */
@Service
public class CatInmuebleServiceImpl implements CatInmuebleService{
    
    @Autowired
    InmueblesJoinMapper daoInmueble;
    
    @Autowired
    Tses009InmueblesMapper tses009InmueblesMapper;
    
    public List<InmuebleVO> obtenerCatInmueble (Integer idInmueble){
         
        List<InmuebleVO> listInmueble = daoInmueble.obtenerCatInmueble(idInmueble);
        return listInmueble;
        
     }
    
    @Override
    public String crearInmuebleCat(InmuebleVO cinmuebleVO) {
        
        Tses009Inmuebles inmueble = new Tses009Inmuebles();
        
         try {
            System.out.println("ENTRANDO A SERVICIO");
            Integer idInmueble = cinmuebleVO.getIdInmueble();
            System.out.println("idInmueble---" + idInmueble);
            inmueble.setDenominacion(cinmuebleVO.getDenominacion());
            inmueble.setIdEntidad(cinmuebleVO.getIdEntidad());
            inmueble.setIdAlcaldiaMun(cinmuebleVO.getIdAlcaldiaMun());
            inmueble.setIdColonia(cinmuebleVO.getIdColonia());
            inmueble.setCalle(cinmuebleVO.getCalle());
            inmueble.setNumero(cinmuebleVO.getNumero());
            inmueble.setCp(cinmuebleVO.getCp());
            inmueble.setNumAccesos(cinmuebleVO.getNumAccesos());
            inmueble.setClaveInmueble(cinmuebleVO.getClaveInmueble());    
            inmueble.setEstatus(cinmuebleVO.getEstatus());
            
            if (idInmueble != null) {
                System.out.println("Entrando a update");
                 inmueble.setIdInmueble(idInmueble);
                tses009InmueblesMapper.updateByPrimaryKeySelective(inmueble);
                System.out.println("update exitoso");
                return "Se han registrado los datos correctamente";
            } else {
                System.out.println("Entrando a Insert");
                    tses009InmueblesMapper.insertSelective(inmueble);
                    return "Se han registrado los datos correctamente";
            }
            
         }catch (Exception exc) {
            System.out.println("error : " + exc.getMessage());
            return ("Error al insertar inmueble.");
        }
    }
    
      public Tses009Inmuebles obtenerInmueble(Integer idInmueble) {
        Tses009Inmuebles tses009Inmuebles = new Tses009Inmuebles();
        tses009Inmuebles = tses009InmueblesMapper.selectByPrimaryKey(idInmueble);
        return tses009Inmuebles;
    }
    
}
