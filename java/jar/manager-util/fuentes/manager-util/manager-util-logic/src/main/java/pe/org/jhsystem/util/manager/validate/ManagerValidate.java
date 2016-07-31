package pe.org.jhsystem.util.manager.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jose Luis Huaman Villar
 * @see <a href="http://diariojl.blogspot.pe/p/blog-page.html" target="_blank">ManagerUtil</a>
 * @version 1.0.5
 * @since 10-12-2014
 */
public class ManagerValidate {
    
    /**
     * Metodo que valida una cadena de texto en segun una cadena de expresion.
     * @param cadena a evaluar.
     * @param cadena de expresion con la que se evalua.
     * @return char 0 si todo es correcto, diferente de 0 si es incorrecto.
     * @since version 1.0.5
     */
    public static char validaCaracterCadena(String p_caracter, String p_cadena) {
        final String palabra = p_caracter.trim();
        final String validos = p_cadena.trim();
        final int len = palabra.length();
        char c = '0';
        for(int i = 0; i < len; i++){
            c = palabra.charAt(i);
            if (validos.indexOf(c) == -1) return c;
        }
        return '0';
    }

    /**
     * Metodo que busca si cadena de texto se encuentra dentro de otra cadena.
     * @param cadena a evaluar.
     * @param cadena de opciones la que se evalua.
     * @return int -1 no encuentra, diferente de -1 si encuentra.
     * @since version 1.0.5
     */
    public static int validaCadenaOpciones(String cadena, String opcion){
        int pos = -1;
        pos = opcion.indexOf(cadena);
        return pos;
    }

    /**
     * Metodo que valida una cadena de texto tienen el formato de IP 4.
     * @param cadena a evaluar.
     * @return boolean true si es correcto, false si no lo es.
     * @since version 1.0.0
     */
    public static boolean validaIp(String sIp){
        Pattern pattern;
        Matcher matcher;
        String IPADDRESS_PATTERN =
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
 	  pattern = Pattern.compile(IPADDRESS_PATTERN);
 	  matcher = pattern.matcher(sIp);
	  return matcher.matches();
    }
    
    /**
     * Metodo que valida una cadena de texto tienen el formato de fecha.
     * @param cadena a evaluar.
     * @param formato de fecha a utilizar para evaluar la cadena de texto.
     * @return boolean true si es correcto, false si no lo es.
     * @exception ParseException si no se logra parsear la cadena a evaluar.
     * @since version 1.0.0
     */
    public static boolean validaFecha(String sFecha, String sFormato) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat(sFormato, Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(sFecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Metodo que retorna una cadena de fecha tipo BD Oracle (YYYYMMDD) en un formato regular DDMMYYYY.
     * @param cadena de fecha.
     * @return string parseo para generar formato DDMMYYYY.
     * @since version 1.0.0
     */
    public static String DateToBD_DMY(String fecha){
        return fecha.substring(6)+fecha.substring(4,6)+fecha.substring(0,4);
    }
    
    /**
     * Metodo que retorna una cadena de fecha tipo BD Oracle (YYYYMMDD) en un formato regular DD/MM/YYYY.
     * @param cadena de fecha.
     * @return string parseo para generar formato DD/MM/YYYY.
     * @since version 1.0.0
     */
    public static String DateStringToDate(String fecha){
        return fecha.substring(6)+"/"+fecha.substring(4,6)+"/"+fecha.substring(0,4);
    }
}
