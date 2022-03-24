/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.dao.join;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author pedro.flores
 */
public interface EtiquetasJoinMapper {
    
    public Integer endIdEtiqueta(@Param("idInmueble")  Integer idInmueble);
    
    public Long nextIdEtiqueta(@Param("idInmueble")  Integer idInmueble);   
}
