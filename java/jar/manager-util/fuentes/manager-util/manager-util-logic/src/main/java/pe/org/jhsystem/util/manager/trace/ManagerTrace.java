package pe.org.jhsystem.util.manager.trace;

import java.io.PrintWriter;
import java.io.StringWriter;
import pe.org.jhsystem.util.manager.log.ManagerLog;

/**
 * @author Jose Luis Huaman Villar
 * @see <a href="http://diariojl.blogspot.pe/p/blog-page.html" target="_blank">ManagerUtil</a>
 * @version 1.0.0
 * @since 17-11-2012
 */
public class ManagerTrace {

    /**
     * Metodo que captura una excepcion y lo convierte a una cadena para su visualizacion mas amigable.
     * @param error capturado del tipo Throwable.
     * @return string cadena del error encontrado.
     * @since version 1.0.0
     */
    public static String PilaToString(Throwable error){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        error.printStackTrace(pw);
        return "Traza de Error:\n"+sw.toString();
    }

    /**
     * Metodo que captura una excepcion, la clase y metodo donde ocurrio el error, y lo convierte a una cadena para su visualizacion mas amigable.
     * @param error capturado del tipo Throwable.
     * @param clase donde se provoco el error.
     * @param identificador del metodo donde se provoco el error.
     * @return string cadena del error encontrado.
     * @since version 1.0.0
     */
    public static String PilaToString(Throwable error, String sClase, int iMetodo){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        error.printStackTrace(pw);
        String sResult = ManagerLog.toDescription(sClase, iMetodo);
        return sResult + "\nTraza de Error:\n"+sw.toString();
    }

    /**
     * Metodo que captura una excepcion y lo convierte a detalle a una cadena para su visualizacion mas amigable.
     * @param error capturado del tipo Throwable.
     * @return cadena del error encontrado.
     * @since version 1.0.0
     */
    public static String DetallePilaToString(Throwable error){
        String cadenaError = "";
        StackTraceElement[] elemRastreo = error.getStackTrace();
        for(int i=0; i<elemRastreo.length;i++){
            StackTraceElement elemActual = elemRastreo[i];
            cadenaError = cadenaError + elemActual.toString()+"\n";
        }
        cadenaError = "Mensaje:\n"+error.getMessage()+"\n\nCausa:\n"+error.getCause()+"\n\nUbicacion:\n"+error.getLocalizedMessage()+"\n\nTraza:\n"+cadenaError;
        return cadenaError;
    }
}
