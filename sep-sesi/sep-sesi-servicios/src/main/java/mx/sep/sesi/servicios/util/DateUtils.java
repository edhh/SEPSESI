package mx.sep.sesi.servicios.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author Horacio Sanchez Barrera
 * @Descripcion: Utileria manipular fechas y formatos
 * @Fecha: 01-02-2011
 */
public class DateUtils {

    /**
     *
     * "yyyy.MM.dd G 'at' HH:mm:ss z" 2001.07.04 AD at 12:08:56 PDT "EEE, MMM d,
     * ''yy" Wed, Jul 4, '01 "h:mm a" 12:08 PM "hh 'o''clock' a, zzzz" 12
     * o'clock PM, Pacific Daylight Time "K:mm a, z" 0:08 PM, PDT
     * "yyyyy.MMMMM.dd GGG hh:mm aaa" 02001.July.04 AD 12:08 PM "EEE, d MMM yyyy
     * HH:mm:ss Z" Wed, 4 Jul 2001 12:08:56 -0700 "yyMMddHHmmssZ"
     * 010704120856-0700
     *
     * EEE MMM d HH:mm:ss GGG yyyy Tue Feb 1 00:00:00 CST 2011
     */
    public static final String DOJO_DATE = "EEE MMM d HH:mm:ss zzz yyyy";
    public static final String DOJO_SHORT_DATE = "yyyy-MM-dd";
    public static final String DATE_ATTACH_FILE = "dd-MM-yyyy";
    public static final String REPORT_DATE_FORMAT = "dd-MM-yyyy_HH-mm";
    public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    public static final String TIME_FORMAT_HOUR = "HH:mm";
    public static final String TIME_STAMP = "ddMMyyHHmmss";
    public static final String TIME_STAMP_T = "DyyHHmmssSS";
    public static final String TIME_STAMP_Z = "yyMMddHHmmssZ";
    public static final String _FORMAT = "dd/MM/yyyy";
    public static final String MDY_FORMAT = "MM/dd/yyyy";
    public static final String _LONG_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String _LONG_FORMAT_YEAR_TO_SECOND = "yyyy-MM-dd HH:mm:ss";
    public static final String _ORACLE_LONG_FORMAT = "MM/dd/yyyy HH:mm:ss";
    public static final String DATETIME_FORMAT = "dd/MM/yy HH:mm:ss";
    public static final String DEFAULT_SEPARATOR = "/";

    private static int DIA = Calendar.DAY_OF_MONTH;
    private static int MES = Calendar.MONTH;
    private static int ANIO = Calendar.YEAR;

    private static Date fechaActual = null;

    public static String getFechaHoraActual(String formato) {
        fechaActual = new Date();
        if (formato == null) {
            formato = DATETIME_FORMAT;
        }
        SimpleDateFormat objFormatoFecha = new SimpleDateFormat(formato);
        return objFormatoFecha.format(fechaActual);
    }

    public static Date getFechaHoraActual() {
        fechaActual = new Date();
        return fechaActual;
    }

    /**
     * Obtiene el campo actual de un calendario
     *
     * @return El valor del campo seleccionado del calendario (Hora, Minutos,
     * Segundos, dias, Meses, a�os, milisegs etc)
     */
    public static int getActual(int campo) {
        Calendar cal = Calendar.getInstance();
        return cal.get(campo);
    }

    public static String getDayOfYear(Date fecha) {
        SimpleDateFormat format = new SimpleDateFormat("DDD");
        if (fecha == null) {
            fecha = new Date();
        }
        String dayNatural = format.format(fecha);
        return dayNatural;
    }

    public static String getAnioYY(Date fecha) {
        SimpleDateFormat format = new SimpleDateFormat("yyy");
        if (fecha == null) {
            fecha = new Date();
        }
        String anio = format.format(fecha);
        return anio;
    }

    /**
     * Obtiene el dia del mes actual
     *
     * @return numero del dia del mes actual
     */
    public static int getDiaActual() {
        return getActual(DIA);
    }

    /**
     * Obtiene el mes del a�o actual
     *
     * @return numero del mes del a�o actual
     */
    public static int getMesActual() {
        return (int) (getActual(MES) + 1);
    }

    /**
     * Obtiene el a�o actual
     *
     * @return a�o actual
     */
    public static int getAnioActual() {
        return getActual(ANIO);
    }

    /**
     * formatea la fecha seleccionada al formato dado
     *
     * @param fecha objeto Date al que se aplicara el formato
     * @param format que especifica el formato de la fecha
     * @return Objeto String con la fecha formateada
     */
    public static String dateFormat(Date fecha, String format) {
        if (fecha == null) {
            return null;
        }

        if (format == null) {
            format = DEFAULT_DATE_FORMAT;
        }
        SimpleDateFormat objFormatoFecha = new SimpleDateFormat(format);
        return objFormatoFecha.format(fecha);
    }

    public static String dateFormat(long fecha, String format) {
        Date _fecha = new Date(fecha);

        if (format == null) {
            format = DEFAULT_DATE_FORMAT;
        }
        SimpleDateFormat objFormatoFecha = new SimpleDateFormat(format);
        return objFormatoFecha.format(_fecha);
    }

    /**
     * convierte un objeto Date a cadena
     *
     * @param fecha objeto Date al que se aplicara el formato
     * @return Objeto String con la fecha en formato por default
     */
    public static String dateToString(Date fecha) {
        return dateFormat(fecha, null);
    }

    /**
     * Obtiene la diferencia de dos fechas dada en dias
     *
     * @param fecha1 fecha inicial
     * @param fecha2 fecha final
     * @param emision tipo de emision
     * @param periodo periodo de tiempo
     * @return numero de dias de la diferencia entre fechas
     */
    public static long getDiferenciaDias(Date fecha1, Date fecha2) {
        Calendar cal1 = new GregorianCalendar();
        cal1.setTime(fecha1);

        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(fecha2);

        long difMilisegs = cal2.getTimeInMillis() - cal1.getTimeInMillis();
		//long difSegundos = difMilisegs /(1000);
        //long difMinutos = difMilisegs /(1000*60);
        //long difHoras = difMilisegs /(1000*60*60);
        long difDias = difMilisegs / (1000 * 60 * 60 * 24);

        return difDias;
    }

    public static long getDiferenciaMin(Date fecha1, Date fecha2) {
        Calendar cal1 = new GregorianCalendar();
        cal1.setTime(fecha1);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(fecha2);
        long difMilisegs = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        long difMunutos = difMilisegs / (1000 * 60);
        return difMunutos;
    }

    /**
     * Obtiene una fecha por defecta no definida
     *
     * @return Fecha constante 01/01/1900
     */
    public static Date getFechaIndefinida() {
        int year = 1900;
        int month = 0;
        int day = 1;

        Calendar cal = new GregorianCalendar(year, month, day);
        return cal.getTime();
    }

    public static String getFieldDate(String symbol, Date date) {
        SimpleDateFormat format = new SimpleDateFormat(symbol, new Locale("es", "MX"));
        return format.format(date);
    }

    public static String formatLongDate(Date date) {
        if (date == null) {
            date = new Date();
        }
        String formatLong = "";
        formatLong = getFieldDate("EEEE", date);
        formatLong += " ";
        formatLong += getFieldDate("dd", date);
        formatLong += " de ";
        formatLong += getFieldDate("MMMM", date);
        formatLong += " del ";
        formatLong += getFieldDate("yyyy", date);
        return formatLong.toUpperCase();
    }

    public static String formatDate(Date date) {
        if (date == null) {
            date = new Date();
        }
        String formatLong = "";
        formatLong += getFieldDate("dd", date);
        formatLong += " de ";
        formatLong += getFieldDate("MMMM", date);
        formatLong += " de ";
        formatLong += getFieldDate("yyyy", date);
        return formatLong.toLowerCase();
    }

    public static String diaMesFormat(Date date) {
        if (date == null) {
            date = new Date();
        }
        String formatLong = "";
        formatLong += getFieldDate("dd", date);
        formatLong += " de ";
        formatLong += getFieldDate("MMMM", date);
        return formatLong.toLowerCase();
    }

        //final private static String RFC3339_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    //final private static String RFC3339_PATTERN = "{0,date," + RFC3339_FORMAT + "}";
    public static void main(String[] args) throws Exception {

        /**
         *
         * "yyyy.MM.dd G 'at' HH:mm:ss z" 2001.07.04 AD at 12:08:56 PDT "EEE,
         * MMM d, ''yy" Wed, Jul 4, '01 "h:mm a" 12:08 PM "hh 'o''clock' a,
         * zzzz" 12 o'clock PM, Pacific Daylight Time "K:mm a, z" 0:08 PM, PDT
         * "yyyyy.MMMMM.dd GGG hh:mm aaa" 02001.July.04 AD 12:08 PM "EEE, d MMM
         * yyyy HH:mm:ss Z" Wed, 4 Jul 2001 12:08:56 -0700 "yyMMddHHmmssZ"
         * 010704120856-0700
         *
         * EEE MMM d HH:mm:ss GGG yyyy Tue Feb 1 00:00:00 CST 2011
         */
        /*
         SimpleDateFormat formatoDelTexto = new SimpleDateFormat( "EEE MMM d HH:mm:ss zzz yyyy", Locale.getDefault() );	
         String strFecha = "Tue Feb 1 00:00:00 CST 2011";
         Date fecha = null;
         try {

         fecha = formatoDelTexto.parse(strFecha);

         } catch (ParseException ex) {

         ex.printStackTrace();

         }
         LoggerUtil.debug(DateUtils.class, "Fecha"+fecha);
         */
    	//Date date = new Date( Long.parseLong("1296799200000"));

        /*
         Date fchIni = DateUtils.stringToDate( "2000-06-21", DateUtils.DOJO_SHORT_DATE );
         Date fchFin = DateUtils.stringToDate( "2005-12-31", DateUtils.DOJO_SHORT_DATE );
         Date fchExa = DateUtils.stringToDate( "2006-02-02", DateUtils.DOJO_SHORT_DATE );
         Date fchGrado = DateUtils.stringToDate( "2006-12-31", DateUtils.DOJO_SHORT_DATE );
         if( fchIni.after( fchFin ) || fchIni.after( fchExa ) || fchIni.after( fchGrado ) ){
         LoggerUtil.debug(DateUtils.class,  "Error fchIni( "+fchFin+" ) es mayor a otra fecha de solicitud" );
		
			
         }
         LoggerUtil.debug(DateUtils.class, "fchGrado.before( fchIni ):"+fchGrado.before( fchIni ));
         LoggerUtil.debug(DateUtils.class, "fchGrado.after( fchFin ):"+fchGrado.before( fchFin ));
         LoggerUtil.debug(DateUtils.class, "fchGrado.after( fchExa ):"+fchGrado.before( fchExa ));
		
         if( fchGrado.before( fchIni ) || fchGrado.before( fchFin ) || fchGrado.before( fchExa ) ){
         LoggerUtil.debug(DateUtils.class,  "Error fchGrado( "+fchGrado+" ) es menor a [ "+ fchIni +", "+fchFin+", "+ fchExa+" ]" );
			
			
         }			
         if( fchFin.before( fchIni ) || fchFin.after( fchExa ) ){
         LoggerUtil.debug(DateUtils.class,  "Error fchFin( "+fchFin+" ) no se encuentra dentro de intervalo de ["+fchIni+" - "+fchExa+" ]." );
			
			
         }
         if( fchExa.before( fchFin  ) || fchExa.after( fchGrado ) ){
         LoggerUtil.debug(DateUtils.class,  "Error fchExa( "+fchExa+" ) no se encuentra dentro de intervalo de ["+fchIni+" - "+fchGrado+" ]." );				
			
			
         }*/
    }

    /**
     * Agrega la cantidad de dias,horas, minutos, etc segun el campo
     * especificado a una fecha
     *
     * @param fecha fecha dada
     * @param campo especifica el tipo de valor a agregar
     * @param cantidad cantidad de dias, min, etc a agregar a la fecha (negativo
     * para resta)
     * @return fecha con el valor agregardo
     */
    private static Date dateAdd(Date fecha, int campo, int cantidad) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        cal.add(campo, cantidad);

        return cal.getTime();
    }

    /**
     * resta la cantidad de dias a una fecha
     *
     * @param fecha fecha dada
     * @param dias cantidad de dias
     * @return fecha con el valor agregardo
     */
    public static Date restaDiasFecha(Date fecha, int dias) {
        return dateAdd(fecha, Calendar.DATE, (dias * -1));
    }

    /**
     * resta la cantidad de meses a una fecha
     *
     * @param fecha fecha dada
     * @param meses cantidad de meses
     * @return fecha con el valor agregardo
     */
    public static Date restaMesesFecha(Date fecha, int meses) {
        return dateAdd(fecha, Calendar.MONTH, (meses * -1));
    }

    /**
     * adiciona la cantidad de dias a una fecha
     *
     * @param fecha fecha dada
     * @param dias cantidad de dias
     * @return fecha con el valor agregardo
     */
    public static Date sumaDiasFecha(Date fecha, int dias) {
        return dateAdd(fecha, Calendar.DATE, dias);
    }

    /**
     * adiciona la cantidad de meses a una fecha
     *
     * @param fecha fecha dada
     * @param meses cantidad de meses
     * @return fecha con el valor agregardo
     */
    public static Date sumaMesesFecha(Date fecha, int meses) {
        return dateAdd(fecha, Calendar.MONTH, meses);
    }

    /**
     * obtiene la fecha de un dia anterior a la fecha actual
     *
     * @return fecha del dia anterior
     */
    public static Date getDiaPrevio() {
        return restaDiasFecha(new Date(), 1);
    }

    /**
     * convierte un objeto String con el formato por defecto a Date
     *
     * @param fecha fecha formateada
     * @return Objeto Date de la fecha dada
     */
    public static Date stringToDate(String fecha, String format) {

        SimpleDateFormat formatoDelTexto = null;
        if (format == null) {
            formatoDelTexto = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.getDefault());
        } else {
            formatoDelTexto = new SimpleDateFormat(format, Locale.getDefault());
        }
        Date date = null;
        try {
            date = formatoDelTexto.parse(fecha);

        } catch (ParseException ex) {
            if (format == null) {
                formatoDelTexto = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
            } else {
                formatoDelTexto = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
            }
            try {
                date = formatoDelTexto.parse(fecha);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return date;
    }

    public static boolean isDateValid(String fecha, String format) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat(format, Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Convierte fecha de tipo date en quincena (AAAAQQ)
     * @param fecha Fecha a convertir en quincena
     * @return quincena Quincena correspondiente a la fecha indicada
     * @throws Exception
     */
    public static int convierteFechaQuincena(Date fecha) throws Exception {
        String fechaFormato = new SimpleDateFormat("yyyy-MM-dd").format(fecha);
        String anio = fechaFormato.substring(0, 4);
        short mes = new Short(fechaFormato.substring(5, 7)).shortValue();
        short dia = new Short(fechaFormato.substring(8, 10)).shortValue();
        int qna = mes * 2;
        if (dia <= 15) {
            qna -= 1;
        }
        String qnaFormateada = "" + qna;
        if (qna < 10) {
            qnaFormateada = "0" + qna;
        }
        String quincena = anio + qnaFormateada;
        return Integer.parseInt(quincena);
    }
    
    /**
     * Concatena dos objetos de tipo fecha para regresar un objeto tipo date con fecha y hora
     * @param fecha Fecha a concatenar
     * @param hora Hora de concatenar
     * @return date con fecha y hora
     * @throws Exception
     */
    public static Date getDateTime(Date fecha, Date hora) throws Exception {
        Calendar calendarA = Calendar.getInstance();
        calendarA.setTime(fecha);

        Calendar calendarB = Calendar.getInstance();
        calendarB.setTime(hora);

        calendarA.set(Calendar.HOUR_OF_DAY, calendarB.get(Calendar.HOUR_OF_DAY));
        calendarA.set(Calendar.MINUTE, calendarB.get(Calendar.MINUTE));
        calendarA.set(Calendar.SECOND, calendarB.get(Calendar.SECOND));

        Date result = calendarA.getTime();
        return result;
    }
}
