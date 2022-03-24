package mx.sep.sesi.servicios.util;

import org.springframework.context.MessageSource;

/**
 * 
 * Excepci�n lanzada por alg�n componente de infraestructura. En algunos
 * casos este tipo de errores representan bugs que deber�an ser corregidos.
 * Tambi�n pueden ser errores que componentes aplicativos usan en su 
 * funcionalidad propia.
 * 
 * Un caso t�pico de esto �ltimo es {@link AccessDeniedException} que es lanzada
 * cada vez que a un Principal se le niega cierto permiso.
 * 
 * Dado lo anterior este tipo de errores no deber�an ser lanzadas desde c�digo de
 * negocio.
 * 
 * @author Alejandro Pimentel
 *
 */
public class ErrorInfraestructura extends BaseTipoError {
		 
	private static final long serialVersionUID = -4917062960842845345L;

	public ErrorInfraestructura(){
        super();
    }

	/**
	 * 
	 * @param message Mensaje literal que brinda mayor informaci�n sobre el error.
	 */
    public ErrorInfraestructura(String message){
        super(message);
    }

    /**
     * Constructor que permite envolver una excepci�n arbitraria.
     * 
     * @param msg Mensaje literal que brinda mayor informaci�n sobre el error.
     * @param t La excepci�n originalmente lanzada. Cuando esta existe es buena pr�ctica conservarla y envolverla detro de otro
     * 			tipo de excepci�n que tenga mayor significado dentro de la aplicaci�n.
     */
    public ErrorInfraestructura(String msg, Throwable t){
        super(msg,t);
    }

    /**
     * 
     * @param message Mensaje literal que brinda mayor informaci�n sobre el error.
     * @param extraInfo Alg�n bean que contenga informaci�n que la aplicaci�n deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorInfraestructura(String message, Object extraInfo){
        super(message, extraInfo);
    }

    /**
     * 
     * @param msg Mensaje literal que brinda mayor informaci�n sobre el error.
     * @param t La excepci�n originalmente lanzada. Cuando esta existe es buena pr�ctica conservarla y envolverla detro de otro
     * 			tipo de excepci�n que tenga mayor significado dentro de la aplicaci�n.
     * @param extraInfo Alg�n bean que contenga informaci�n que la aplicaci�n deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorInfraestructura(String msg, Throwable t, Object extraInfo){
        super(msg,t,extraInfo);
    }

    /**
     * 
     * @param t La excepci�n originalmente lanzada. Cuando esta existe es buena pr�ctica conservarla y envolverla detro de otro
     * 			tipo de excepci�n que tenga mayor significado dentro de la aplicaci�n.
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     */
    public ErrorInfraestructura(Throwable t, String codigoMensaje, Object[] argumentosMensaje) {
        super(t, codigoMensaje, argumentosMensaje);
    }

    /**
     * 
     * @param t La excepci�n originalmente lanzada. Cuando esta existe es buena pr�ctica conservarla y envolverla detro de otro
     * 			tipo de excepci�n que tenga mayor significado dentro de la aplicaci�n.
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     * @param mensajeDefault Si el c�digo del mensaje no puede resuelto se usar� el mensaje literal default.
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     */
    public ErrorInfraestructura(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(t, codigoMensaje, mensajeDefault, argumentosMensaje);
    }

    /**
     * 
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     */
    public ErrorInfraestructura(Object[] argumentosMensaje, String codigoMensaje) {
        super(codigoMensaje, argumentosMensaje);
    }

    /**
     * 
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     * @param mensajeDefault Si el c�digo del mensaje no puede resuelto se usar� el mensaje literal default.
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     */
    public ErrorInfraestructura(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(codigoMensaje, mensajeDefault, argumentosMensaje);
    }

    /**
     * 
     * @param t La excepci�n originalmente lanzada. Cuando esta existe es buena pr�ctica conservarla y envolverla detro de otro
     * 			tipo de excepci�n que tenga mayor significado dentro de la aplicaci�n.
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     * @param extraInfo Alg�n bean que contenga informaci�n que la aplicaci�n deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorInfraestructura(Throwable t, String codigoMensaje, Object[] argumentosMensaje, Object extraInfo) {
        super(t, codigoMensaje, argumentosMensaje, extraInfo);
    }

    /**
     * 
     * @param t La excepci�n originalmente lanzada. Cuando esta existe es buena pr�ctica conservarla y envolverla detro de otro
     * 			tipo de excepci�n que tenga mayor significado dentro de la aplicaci�n.
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     * @param mensajeDefault Si el c�digo del mensaje no puede resuelto se usar� el mensaje literal default.
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     * @param extraInfo Alg�n bean que contenga informaci�n que la aplicaci�n deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorInfraestructura(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        super(t, codigoMensaje, mensajeDefault, argumentosMensaje, extraInfo);
    }

    /**
     * 
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     * @param extraInfo Alg�n bean que contenga informaci�n que la aplicaci�n deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorInfraestructura(Object[] argumentosMensaje, String codigoMensaje, Object extraInfo) {
        super(codigoMensaje, argumentosMensaje, extraInfo);
    }

    /**
     * 
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     * @param mensajeDefault Si el c�digo del mensaje no puede resuelto se usar� el mensaje literal default.
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     * @param extraInfo Alg�n bean que contenga informaci�n que la aplicaci�n deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorInfraestructura(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        super(codigoMensaje, mensajeDefault, argumentosMensaje, extraInfo);
    }
}
