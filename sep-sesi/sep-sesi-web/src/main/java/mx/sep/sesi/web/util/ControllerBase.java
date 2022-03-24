package mx.sep.sesi.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.sep.sesi.datos.vo.FiltroBusquedaVO;
import static mx.sep.sesi.servicios.util.Constants.PAGE_SIZE_GRID;
import mx.sep.sesi.servicios.util.LoggerUtil;
import org.springframework.util.StringUtils;

/**
 * Los controllers pueden heredar de esta clase para hacer uso de utilerÃ­as y
 * helpers.
 *
 * @author Alejandro Pimentel
 *
 */
public abstract class ControllerBase {

    /**
     * MÃ©todo de utilerÃ­a para simplificar el uso de operaciones REST como
     * paginaciÃ³n y ordenamiento.
     *
     * @param rango cadena con informaciÃ³n de la paginaciÃ³n en la forma
     * items=x-y
     * @param total
     * @param request
     * @param response
     * @return
     */
    protected FiltroBusquedaVO manejarRestPaging(String rango, Integer total, HttpServletRequest request, HttpServletResponse response) {
        String[] rangos = rango.substring("items=".length()).split("-");
        int desde = Integer.valueOf(rangos[0]);
        //int hasta = Integer.valueOf(rangos[1]);	
        int hasta = PAGE_SIZE_GRID;
        String nombreCampo = null;
        String ascDesc = null;

        String queryString = request.getQueryString();
        LoggerUtil.debug(this, rango + "********************************************************************************************////" + queryString);
        if (StringUtils.hasText(queryString) && queryString.indexOf("sort(") != -1) {
            Integer idx = "sort(".length();
            nombreCampo = queryString.substring(idx + 1, queryString.indexOf(")"));
            ascDesc = queryString.substring(idx, idx + 1);
            ascDesc = ascDesc.equals("+") ? "asc" : "desc";
        }

        response.addHeader("Content-Range", "items " + desde + "-" + hasta + "/" + total);

        return new FiltroBusquedaVO(desde, hasta, nombreCampo, ascDesc);
    }

    public String getRequestURI(HttpServletRequest request) {
        String requestURI = null;
        if (requestURI != null) {
            return requestURI;
        }
        requestURI = "";
        if (request.isSecure()) {
            requestURI = "https://";
        } else {
            requestURI = "http://";
        }
        requestURI += request.getServerName() + ":";
        requestURI += request.getLocalPort();
        requestURI += request.getContextPath();
        requestURI += "/";
        return requestURI;
    }
}
