package mx.sep.sesi.servicios.util;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Excepci�n base para el manejo de errores dentro de la aplicaci�n.
 * 
 * Siguiendo las recomendaciones de dise�o de la comunidad spring-java se usa 
 * {@link RuntimeException} para no obligar al desarrollador a siempre cachar las
 * excepciones.
 * 
 * Los mensajes colocados dentro de las excepciones de este tipo pueden ser c�digos que
 * posteriormente sean resueltos por medio de alg�n {@link MessageSource}
 * 
 * Ya que esta clase implementa la interfaz {@link MessageSourceResolvable} cualquier instancia
 * de una exceci�n que herede de est� clase puede ser enviada a cualquier estrategia de resolusi�n
 * de mensajes que implemente {@link MessageSource} por ejemplo {@link ResourceBundleMessageSource}.
 * 
 * @author Alejandro Pimentel
 *  
 */
public abstract class BaseTipoError
        extends RuntimeException
        implements MessageSourceResolvable {

	private static final long serialVersionUID = 7217445484129502645L;

	private String[] codes;

    private Object[] arguments;

    private String defaultMessage;

    private boolean resolvable;

    private boolean mensajeResuelto;

    private Object extraInfo;

    public BaseTipoError() {
        super();
    }

    private void setComunes(String codigoMensaje, Object[] argumentosMensaje) {
        this.codes = new String[1];
        this.codes[0] = codigoMensaje;
        this.arguments = argumentosMensaje;
        this.resolvable = true;
    }

	/**
	 * 
	 * @param message Mensaje literal que brinda mayor informaci�n sobre el error.
	 */    
    public BaseTipoError(String message) {
        super(message);
    }

    /**
     * Constructor que permite envolver una excepci�n arbitraria.
     * 
     * @param msg Mensaje literal que brinda mayor informaci�n sobre el error.
     * @param t La excepci�n originalmente lanzada. Cuando esta existe es buena pr�ctica conservarla y envolverla detro de otro
     * 			tipo de excepci�n que tenga mayor significado dentro de la aplicaci�n.
     */    
    public BaseTipoError(String msg, Throwable t) {
        super(msg, t);
    }

    /**
     * 
     * @param message Mensaje literal que brinda mayor informaci�n sobre el error.
     * @param extraInfo Alg�n bean que contenga informaci�n que la aplicaci�n deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */    
    public BaseTipoError(String message, Object extraInfo) {
        super(message);
        this.extraInfo = extraInfo;
    }

    /**
     * 
     * @param msg Mensaje literal que brinda mayor informaci�n sobre el error.
     * @param t La excepci�n originalmente lanzada. Cuando esta existe es buena pr�ctica conservarla y envolverla detro de otro
     * 			tipo de excepci�n que tenga mayor significado dentro de la aplicaci�n.
     * @param extraInfo Alg�n bean que contenga informaci�n que la aplicaci�n deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */    
    public BaseTipoError(String msg, Throwable t, Object extraInfo) {
        super(msg, t);
        this.extraInfo = extraInfo;
    }

    /**
     * 
     * @param t La excepci�n originalmente lanzada. Cuando esta existe es buena pr�ctica conservarla y envolverla detro de otro
     * 			tipo de excepci�n que tenga mayor significado dentro de la aplicaci�n.
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     */    
    public BaseTipoError(Throwable t, String codigoMensaje, Object[] argumentosMensaje) {
        super(t);
        this.setComunes(codigoMensaje, argumentosMensaje);
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
    public BaseTipoError(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(mensajeDefault, t);
        this.defaultMessage = mensajeDefault;
        this.setComunes(codigoMensaje, argumentosMensaje);
    }

    /**
     * 
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     */    
    public BaseTipoError(String codigoMensaje, Object[] argumentosMensaje) {
        super();
        this.setComunes(codigoMensaje, argumentosMensaje);
    }

    /**
     * 
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     * @param mensajeDefault Si el c�digo del mensaje no puede resuelto se usar� el mensaje literal default.
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     */    
    public BaseTipoError(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje) {
        super(mensajeDefault);
        this.defaultMessage = mensajeDefault;
        this.setComunes(codigoMensaje, argumentosMensaje);
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
    public BaseTipoError(Throwable t, String codigoMensaje, Object[] argumentosMensaje, Object extraInfo) {
        this(t, codigoMensaje, argumentosMensaje);
        this.extraInfo = extraInfo;
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
    public BaseTipoError(Throwable t, String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        this(t, codigoMensaje, mensajeDefault, argumentosMensaje);
        this.extraInfo = extraInfo;
    }

    /**
     * 
     * @param argumentosMensaje Los valores que ser�n sustituidos en los "placeholders" dentro del mensaje. Estos placeholders
     * 						son de la forma {n}. Los valores ser�n tomados seg�n el orden dentro del arreglo.
     * @param codigoMensaje C�digo de un mensaje para ser resuelto v�a alguna implementaci�n de {@link MessageSource}.
     * @param extraInfo Alg�n bean que contenga informaci�n que la aplicaci�n deba procesar debido al error. Por ejemplo
     * 			{@link ManejadorErroresJson} puede convertirlo a formato json para pasarlo como respuesta al cliente.
     */    
    public BaseTipoError(String codigoMensaje, Object[] argumentosMensaje, Object extraInfo) {
        this(codigoMensaje, argumentosMensaje);
        this.extraInfo = extraInfo;
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
    public BaseTipoError(String codigoMensaje, String mensajeDefault, Object[] argumentosMensaje, Object extraInfo) {
        this(codigoMensaje, mensajeDefault, argumentosMensaje);
        this.extraInfo = extraInfo;
    }

    /**
     * {@inheritDoc}
     */
    public String[] getCodes() {
        return this.codes;
    }

    /**
     * {@inheritDoc}
     */    
    public Object[] getArguments() {
        return this.arguments;
    }

    /**
     * {@inheritDoc}
     */    
    public String getDefaultMessage() {
        return this.getMessage();
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    /**
     * {@inheritDoc}
     */    
    public boolean isResolvable() {
        return this.resolvable;
    }

    /**
     * Indica que el mensaje fue resuelto por i18n.
     *
     * @return mensajeResuelto
     */
    public boolean isMensajeResuelto() {
        return mensajeResuelto;
    }

    /**
     * @param mensajeResuelto the mensajeResuelto to set
     */
    public void setMensajeResuelto(boolean mensajeResuelto) {
        this.mensajeResuelto = mensajeResuelto;
    }
}

