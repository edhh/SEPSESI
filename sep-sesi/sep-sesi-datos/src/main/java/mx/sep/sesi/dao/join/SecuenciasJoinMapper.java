/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.dao.join;

import java.math.BigDecimal;

/**
 *
 * @author pedro.flores
 */
public interface SecuenciasJoinMapper {
    public Long nextIdOperacion();
    
    public Integer nextIdUsuario();
    
    public Integer nextIdRolUsuario();
    
    public Integer nextIdFirmante();
    
    public Long nextIdBitacora();
    
    
}
