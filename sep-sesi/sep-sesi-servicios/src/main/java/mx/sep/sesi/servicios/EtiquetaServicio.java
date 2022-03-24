/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios;

import mx.sep.sesi.datos.vo.EtiquetaVO;

/**
 *
 * @author pedro.flores
 */
public interface EtiquetaServicio {
    
    public Integer getUltimaEtiqueta(Integer idInmueble);
            
    public EtiquetaVO crearEtiquetas( EtiquetaVO etiquetaVO ) throws Exception;
    
    public EtiquetaVO reimprimirEtiquetas( EtiquetaVO etiquetaVO ) throws Exception;
    
}
