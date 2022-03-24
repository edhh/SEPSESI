/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import mx.sep.sesi.datos.vo.BitacoraVO;
import mx.sep.sesi.modelo.Tses021Bitacora;
import mx.sep.sesi.modelo.Tses022TraduccionServicio;

/**
 *
 * @author angel.adame
 */
public interface BitacoraService {

    Integer obtenIdUsuarioSession();

//     List<BitacoraVO> consultaProcesos() throws Exception;
    void guardar(Tses021Bitacora bitacora);

    List<Tses022TraduccionServicio> obtenerProcesos() throws Exception;

    List<BitacoraVO> consultarBitacora(Integer idTradServicio, String nombreUsu,Date fechaOpIni,  Date fechaOpFi) throws Exception;
    
    Tses021Bitacora obtenerDetalle(Long idBitacora);

}
