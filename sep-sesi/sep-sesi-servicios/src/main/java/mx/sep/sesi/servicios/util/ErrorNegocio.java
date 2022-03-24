package mx.sep.sesi.servicios.util;

import org.springframework.context.MessageSource;

/**
 * 
 * Excepci�n lanzada cuando se detecta un error en la l�gica de negocio
 * por la cual el proceso de negocio debe ser interrumpido.
 * 
 * @author Alejandro Pimentel
 *
 */
public class ErrorNegocio extends BaseTipoError {
		 
	private static final long serialVersionUID = -1128852941580331211L;

	/**
	 * Constructor defaul. No se recomienda su uso ya que se debe
	 * intentar proveer m�s informaci�n por medio de un mensaje.
	 * 
	 */
	public ErrorNegocio(){
        super();
    }

	/**
	 * 
	 * @param message Mensaje literal que brinda mayor informaci�n sobre el error.
	 */
    public ErrorNegocio(String message){
        super(message);
    }

    /**
     * Constructor que permite envolver una excepci�n arbitraria.
     * 
     * @param msg Mensaje literal que brinda mayor informaci�n sobre el error.
     * @param t La excepci�n originalmente lanzada. Cuando esta existe es buena pr�ctica conservarla y envolverla detro de otro
     * 			tipo de excepci�n que tenga mayor significado dentro de la aplicaci�n.
     */
    public ErrorNegocio(String msg, Throwable t){
        super(msg,t);
    }

    /**
     * 
     * @param message Mensaje literal que brinda mayor informaci�n sobre el error.
     * @param extraInfo Alg�n bean que contenga informaci�n que la aplicaci�n deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */
    public ErrorNegocio(String message, Object extraInfo){
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
    public ErrorNegocio(String msg, Throwable t, Object extraInfo){
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
    public ErrorNegocio(Throwable t, String codigoMensaje, Object[] argumentosMensaje) {
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
    public ErrorNegocio(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(t, codigoMensaje, mensajeDefault, argumentosMensaje);
    }

    /**
     * 
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     */
    public ErrorNegocio(Object[] argumentosMensaje, String codigoMensaje) {
        super(codigoMensaje, argumentosMensaje);
    }

    /**
     * 
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     * @param mensajeDefault Si el c�digo del mensaje no puede resuelto se usar� el mensaje literal default.
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     */
    public ErrorNegocio(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
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
    public ErrorNegocio(Throwable t, String codigoMensaje, Object[] argumentosMensaje, Object extraInfo) {
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
    public ErrorNegocio(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
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
    public ErrorNegocio(Object[] argumentosMensaje, String codigoMensaje, Object extraInfo) {
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
    public ErrorNegocio(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        super(codigoMensaje, mensajeDefault, argumentosMensaje, extraInfo);
    }
}
