/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.util.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.sep.seguridad.modelo.UsuarioSeguridad;
import mx.sep.seguridad.util.SeguridadUtil;
import mx.sep.sesi.dao.Tses021BitacoraMapper;
import mx.sep.sesi.dao.Tses022TraduccionServicioMapper;
import mx.sep.sesi.dao.join.BitacoraJoinMapper;
import mx.sep.sesi.dao.join.SecuenciasJoinMapper;
import mx.sep.sesi.datos.vo.BitacoraVO;
import mx.sep.sesi.modelo.Tses001Usuarios;
import mx.sep.sesi.modelo.Tses021Bitacora;
import mx.sep.sesi.modelo.Tses022TraduccionServicio;
import mx.sep.sesi.modelo.Tses022TraduccionServicioExample;
import mx.sep.sesi.servicios.UsuarioService;
import mx.sep.sesi.servicios.util.BitacoraAspect;
import mx.sep.sesi.servicios.util.BitacoraService;
import mx.sep.sesi.servicios.util.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel.adame
 */
@Service
public class BitacoraServiceImpl implements BitacoraService{
    
      private static final Logger logger = Logger.getLogger(BitacoraAspect.class);
    
   @Autowired
   UsuarioService usuarioService;
   
   @Autowired
   SecuenciasJoinMapper secuenciasMapper;
   
    @Autowired
    private Tses022TraduccionServicioMapper traduccionServicioMapper;
   
   @Autowired
   BitacoraJoinMapper bitacoraJoinMapper;
   
   @Autowired
   Tses021BitacoraMapper bitacoraMapper;
   
   @Autowired
   Tses022TraduccionServicioMapper tses022TraduccionMapper;
    
     public Integer obtenIdUsuarioSession(){
         
           Integer idUsuario = null;
           UsuarioSeguridad us = SeguridadUtil.getUsuarioActual();
                    
           Tses001Usuarios tses001Usuarios = new Tses001Usuarios();
           tses001Usuarios.setNombreUsu(us.getUsername());
       
        try {
            List<Tses001Usuarios> lstUsuarios = usuarioService.consultarPorUsuario(tses001Usuarios);                    
            for (Tses001Usuarios usuario : lstUsuarios) {
                idUsuario =  usuario.getIdUsuario();                      
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return idUsuario;
        
    }
     
//          public List<BitacoraVO> consultaProcesos() throws Exception {
//
//    	return null;
//    }

     
    @Override
    public void guardar(Tses021Bitacora bitacora) {
        try{            
            
            List<Tses022TraduccionServicio> lstTraduccionServicio = new ArrayList<Tses022TraduccionServicio>();
            Tses022TraduccionServicioExample traduccionServicioExample = new Tses022TraduccionServicioExample();
            traduccionServicioExample.createCriteria().andNombreMetodoEqualTo(bitacora.getDescripcion());
            lstTraduccionServicio = tses022TraduccionMapper.selectByExample(traduccionServicioExample);
            if(lstTraduccionServicio!=null && lstTraduccionServicio.size()>0){
                bitacora.setIdTradServicio(lstTraduccionServicio.get(0).getIdTradServicio());
                    
            }else{
                bitacora.setIdTradServicio(Constants.OPERACION_BITACORA_POR_DEFINIFIR);
 
            }   
            Long idBitacora = secuenciasMapper.nextIdBitacora();
            bitacora.setIdBitacora(idBitacora);
            bitacoraMapper.insert(bitacora);  
            
        }catch(Exception exc){
            exc.printStackTrace();
            logger.error("Error al guardar en la bitacora del sistema");
        }
    }
    
    @Override
     public List<Tses022TraduccionServicio> obtenerProcesos() throws Exception{
        List<Tses022TraduccionServicio> lstBitacora = new ArrayList<Tses022TraduccionServicio>();
        Tses022TraduccionServicioExample traduccionServicioExample  = new Tses022TraduccionServicioExample();
        lstBitacora = traduccionServicioMapper.selectByExample(traduccionServicioExample);
        return lstBitacora;
    }

      
//    @Override
//    public List<BitacoraVO> consultarBitacora(BitacoraVO bitacoraConsulVO) throws Exception{
//        
//        List <BitacoraVO> bitacoraJoin = new ArrayList<BitacoraVO>();
//        try{
//            if(bitacoraConsulVO.getNombreUsu().compareTo("") != 0){
//                String user = bitacoraConsulVO.getNombreUsu() + "%";
//                bitacoraConsulVO.setNombreUsu(user);
//            }
//            
//           bitacoraJoin = bitacoraJoinMapper.obtenerUsuarioConsulta(bitacoraConsulVO);
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(this, e);
//        }
//        return bitacoraJoin;
//    }
    
     @Override
    public List<BitacoraVO> consultarBitacora(Integer idTradServicio, String nombreUsu, Date fechaOpIni,  Date fechaOpFin) throws Exception{
        
        List <BitacoraVO> bitacoraJoin = new ArrayList<BitacoraVO>();
        try{
            
             System.out.println("ENTRANDO A SERVICIO");
            if(nombreUsu != ""){
               String user = nombreUsu + "%";
               nombreUsu = user;
            }
            
           bitacoraJoin = bitacoraJoinMapper.obtenerUsuarioConsulta(idTradServicio, nombreUsu, fechaOpIni, fechaOpFin);
                           
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(this, e);
        }
    
        return bitacoraJoin;
        
    }
    
    public Tses021Bitacora obtenerDetalle(Long idBitacora){
        
        Tses021Bitacora tses021Bitacora = new Tses021Bitacora();
        tses021Bitacora = bitacoraMapper.selectByPrimaryKey(idBitacora);
        return tses021Bitacora;      
    }
    
}
