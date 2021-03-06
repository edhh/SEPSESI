/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.impl;

import java.math.BigDecimal;
import java.util.List;
import mx.sep.sesi.dao.Tses011VisitantesMapper;
import mx.sep.sesi.dao.Tses018EtiquetasMapper;
import mx.sep.sesi.dao.join.EtiquetasJoinMapper;
import mx.sep.sesi.datos.vo.EtiquetaVO;
import mx.sep.sesi.modelo.Tses004PersonasExample;
import mx.sep.sesi.modelo.Tses011Visitantes;
import mx.sep.sesi.modelo.Tses011VisitantesExample;
import mx.sep.sesi.servicios.EtiquetaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.sep.sesi.modelo.Tses018Etiquetas;
import mx.sep.sesi.modelo.Tses018EtiquetasExample;
import mx.sep.sesi.servicios.util.LoggerUtil;

/**
 *
 * @author pedro.flores
 */
@Service
public class EtiquetaServicioImpl implements EtiquetaServicio {
    
    @Autowired
    private EtiquetasJoinMapper etiquetasJoinMapper;
    
    @Autowired
    private Tses018EtiquetasMapper tses018EtiquetasMapper;
    
    @Autowired
    private Tses011VisitantesMapper tses011VisitantesMapper;
    

    public Integer getUltimaEtiqueta( Integer idInmueble ) {        
        Integer nextIdEtiqueta = etiquetasJoinMapper.endIdEtiqueta( idInmueble );
        return nextIdEtiqueta;
    }

    public EtiquetaVO crearEtiquetas(EtiquetaVO etiquetaVO) throws Exception{
        String strIds = "";
        try{
            Long nextId = etiquetasJoinMapper.nextIdEtiqueta( etiquetaVO.getIdInmueble().intValue() );            
            for(int i = 1; i <= etiquetaVO.getCantidad(); ++i){ 
                Long idEtiqueta = nextId;
                Tses018Etiquetas record = new Tses018Etiquetas();
                record.setIdEtiqueta (idEtiqueta);
                record.setIdInmueble(etiquetaVO.getIdInmueble());
                record.setEstatus((short)0);
                tses018EtiquetasMapper.insert(record); 
                strIds +=  strIds.equals("")  ? "" + idEtiqueta:("," + idEtiqueta);  
                ++nextId;
            }
            etiquetaVO.setValidos(strIds);
        }catch( Exception e ){
            throw e;
        }
        return etiquetaVO;
    }
    
    
    public EtiquetaVO reimprimirEtiquetas(EtiquetaVO etiquetaVO) throws Exception{
        
        Integer inicio = etiquetaVO.getEtiquetaInicial();
        Integer fin = etiquetaVO.getEtiquetaFinal();
        String strValidos = "";
        String strInvalidos = "";
        
        try {        
            for(long i = inicio; i <= fin; ++i){                    
                Tses011VisitantesExample tses011VisitantesExample = new Tses011VisitantesExample();
                tses011VisitantesExample.createCriteria().andIdEtiquetaEqualTo(i).andIdInmuebleEqualTo(etiquetaVO.getIdInmueble());
                List<Tses011Visitantes> visitante = tses011VisitantesMapper.selectByExample(tses011VisitantesExample);
                if( visitante != null && visitante.size() > 0 ){
                    strInvalidos += strInvalidos.equals("")  ? "" + i:("," + i);
                } else { 
                    strValidos += strValidos.equals("")  ? "" + i:("," + i);   
                }            
            }        
            etiquetaVO.setValidos(strValidos);
            etiquetaVO.setInvalidos(strInvalidos);
        } catch (Exception e){
            LoggerUtil.debug(this, e);
            throw e;
        }
        return etiquetaVO;
    }
    
}
