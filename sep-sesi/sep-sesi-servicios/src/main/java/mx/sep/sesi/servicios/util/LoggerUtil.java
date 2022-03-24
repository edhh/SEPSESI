package mx.sep.sesi.servicios.util;

import com.thoughtworks.xstream.XStream;
import org.apache.log4j.Logger;

/**
 * Fecha de creacion: 06-10-2011 Autor: Horacio Sanchez Barrera Descripci�n:
 * Logeo de la aplicacion version: 1.0
 */
public final class LoggerUtil {

    private static Logger LOG = Logger.getLogger(LoggerUtil.class);

    public static void fatal(Object object, Throwable tr, boolean xml) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }
        LOG.fatal(clazz + " ->> " + "Error:", tr);
        tr.printStackTrace();
    }

    public static void fatal(Object object, Exception e) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }
        LOG.fatal(clazz + " ->> " + "Error:", e);
        e.printStackTrace();
    }

    public static void fatal(Object object, Object value) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }

        if (value instanceof String) {
            LOG.fatal(clazz + " ->> " + value);
        } else {
            LOG.fatal(clazz + " ->> " + parseObject(value));
        }
    }

    public static void fatal(Object object, String mensaje, Object value) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }
        LOG.fatal(clazz + " ->> " + mensaje + " : " + parseObject(value));
    }

    public static void error(Object object, Exception e) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }
        LOG.error(clazz + " ->> " + "Exception: " + e.getMessage() + " \n " + e.getCause(), e);
    }

    /**
     * @param object
     * @param value
     */
    public static void debug(Object object, Object value) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }

        if (value instanceof String) {
            LOG.debug(clazz + " ->> " + value);
        } else {
            LOG.debug(clazz + " ->> " + parseObject(value));
        }

    }

    /**
     * @param object
     * @param value
     */
    public static void info(Object object, Object value) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }
        if (value instanceof String) {
            LOG.info(clazz + " ->> " + value);
        } else {
            LOG.info(clazz + " ->> " + parseObject(value));
        }
    }

    /**
     * @param object
     * @param value
     */
    public static void warning(Object object, Object value) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }
        if (value instanceof String) {
            LOG.warn(clazz + " ->> " + value);
        } else {
            LOG.warn(clazz + " ->> " + parseObject(value));
        }
    }

    /**
     * @param object
     * @param value
     */
    public static void error(Object object, Object value) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }

        if (value instanceof String) {
            LOG.error(clazz + " ->> " + value);
        } else {
            LOG.error(clazz + " ->> " + parseObject(value));
        }
    }

    public static void debug(Object object, String mensaje, Object value) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }
        LOG.debug(clazz + " ->> " + mensaje + " : " + parseObject(value));
    }

    /**
     * @param object
     * @param value
     */
    public static void info(Object object, String mensaje, Object value) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }
        LOG.info(clazz + " ->> " + mensaje + " : " + parseObject(value));
    }

    /**
     * @param object
     * @param value
     */
    public static void warning(Object object, String mensaje, Object value) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }
        LOG.warn(clazz + " ->> " + mensaje + " : " + parseObject(value));
    }

    /**
     * @param object
     * @param value
     */
    public static void error(Object object, String mensaje, Object value) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }
        LOG.error(clazz + " ->> " + mensaje + " : " + parseObject(value));
    }

    /**
     * @param object
     * @param value
     */
    public static void println(Object object, Object value) {
        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }
        System.out.println(clazz + ":" + parseObject(value));
    }

    /**
     * @param object
     * @param value
     */
    public static void println(Object object, String message, Object value) {

        String clazz = object.getClass().getName();
        if (object instanceof java.lang.Class<?>) {
            clazz = object.toString();
        }
        System.out.println(clazz + " - " + message + ":" + parseObject(value));
    }

    /**
     * @param value
     * @return boolean
     */
    @SuppressWarnings("unused")
    private boolean isNull(Object value) {
        if (value == null) {
            return true;
        }
        return false;
    }

    /**
     * @param value
     * @return String
     */
    private static String parseObject(Object value) {
        XStream stream = new XStream();
        stream.setMode(XStream.XPATH_RELATIVE_REFERENCES);
        String xmlStr = stream.toXML(value);
        return xmlStr;
    }

}
