/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.web.endpoints;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import mx.sep.sesi.servicios.ObtenerDatosEquipoService;
import mx.sep.sesi.web.schemas.GetDatosEquipoRequest;
import mx.sep.sesi.web.schemas.GetDatosEquipoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import mx.sep.sesi.datos.vo.DatosEquipoVO;
import mx.sep.sesi.web.schemas.DatosEquipo;

/**
 *
 * @author HeribertoGonzálezPér
 */
@Endpoint
public class obtenerDatosEquipoEndPoint {
    
    private static final String NAMESPACE_URI = "http://web.sesi.sep.mx/schemas";
    
    @Autowired
    private ObtenerDatosEquipoService obtenerDatosEquipoService;
    
    /**
     * Método Request para obtener los datos del equipo deal empleado
     * 
     */
    @PayloadRoot(localPart = "getDatosEquipoRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public GetDatosEquipoResponse handleDatosEquipoRequest(@RequestPayload GetDatosEquipoRequest request) throws Exception {
        GetDatosEquipoResponse response = new GetDatosEquipoResponse();
        DatosEquipoVO datosEquipoVO = new DatosEquipoVO();
        datosEquipoVO.setCurp(request.getCurp());  
        datosEquipoVO.setNumSerie(request.getNumSerie());
        datosEquipoVO.setTipoOperacion(request.getTipoOperacion());
        datosEquipoVO.setIdPartida(request.getIdPartida());
        datosEquipoVO.setCorreo(request.getCorreo());
        datosEquipoVO = obtenerDatosEquipoService.obtieneDatosEquipo(datosEquipoVO);
        List listdatosEquipo=new ArrayList();
        listdatosEquipo.add(datosEquipoVO);
        short statusOper = datosEquipoVO.getStatusOper();
        if (statusOper == 5) {
            Iterator<DatosEquipoVO> ldatosEquipoVO = listdatosEquipo.iterator();
            while (ldatosEquipoVO.hasNext()) {
                datosEquipoVO = ldatosEquipoVO.next();
                DatosEquipo datosEquipo = new DatosEquipo();
                datosEquipo.setCurp(datosEquipoVO.getCurp());
                datosEquipo.setCorreo(datosEquipoVO.getCorreo());
                datosEquipo.setNumSerie(datosEquipoVO.getNumSerie());
                //datosEquipo.setTipoOperacion(datosEquipoVO.getTipoOperacion());
                response.getDatosEquipo().add(datosEquipo);                
            }            
            response.setStatusOper(statusOper);
            response.setTipoError(datosEquipoVO.getTipoError());
        } else if (statusOper == 0) {
            response.setStatusOper(statusOper);
            response.setTipoError(datosEquipoVO.getTipoError());
        } else {
            response.setStatusOper(statusOper);
            response.setTipoError(datosEquipoVO.getTipoError());
        }
        return response;
    }
    
}
