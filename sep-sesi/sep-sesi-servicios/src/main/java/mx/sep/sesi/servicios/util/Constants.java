package mx.sep.sesi.servicios.util;

import java.util.Date;

/**
 *
 * @author jose.hernandezb
 */
public class Constants {

    public static char[] CRLF = new char[]{(byte) '\r', (byte) '\n'};
    public static final String NEW_LINE = System.getProperty("line.separator");
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    public static final int PAGE_SIZE_GRID = 10;
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILURE = "FAILURE";
    public static final int OPERACION_BITACORA_POR_DEFINIFIR = 1;

    public static final Short ACTIVO_SHORT = 1;
    public static final Short DESACTIVO_SHORT = 0;

    public static final Boolean ACTIVO_BOOLEAN = true;
    public static final Boolean DESACTIVO_BOOLEAN = false;

    public static final String OBJECT_LIST = "List";
    public static final String OBJECT_MAP = "Map";
    public static final String OBJECT_STRING = "String";
    public static final String OBJECT_ARRAY = "Array";
    public static final String OBJECT_INTEGER = "Integer";
    public static final String OBJECT_SHORT = "Short";

    public static final Date FECHA_INI_DEFAULT = DateUtils.stringToDate("1900-01-01", DateUtils.DOJO_SHORT_DATE);
    public static final Date FECHA_FIN_DEFAULT = DateUtils.stringToDate("9999-12-31", DateUtils.DOJO_SHORT_DATE);

    public static final String SESSION_DATA_EXPORTER = "SESSION_DATA_EXPORTER";

    //ROLES DEL SISTEMA
    public static final Integer ROLE_ADMINISTRADOR = 1;

    //Estatus CURP a validar
    public static final Short CURP_SIN_VALIDAR = 1;
    public static final Short CURP_VALIDADO = 2;
    
    //Clave Secreta para generar QR
    public static final String CLAVE_SECRETA = "Sesi202114se379!";
    //Clave Secreta para generar QR de equipos
    public static final String CLAVE_SECRETA_EQUIPOS = "EquiposSesiSiac202123te891!";

    public static final String SEPARADOR_QR = "/vC.jsp/";
}
