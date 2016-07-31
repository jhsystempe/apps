package pe.org.jhsystem.util.manager.ajax;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import pe.org.jhsystem.util.manager.trace.ManagerTrace;

/**
 * @author Jose Luis Huaman Villar
 * @see <a href="http://diariojl.blogspot.pe/p/blog-page.html" target="_blank">ManagerUtil</a>
 * @version 1.0.0
 * @since 17-11-2012
 */
public class ManagerAjax {

    /**
     * Metodo que permite el envio de varios valores del tipo String de la forma de AJAX.
     * Genera un XML con todos los parametros ingresados, y los envia por el metodo getWriter del HttpServletResponse.
     * El XML tiene la siguiente estructura:
     * "<?xml version=1.0 encoding=ISO-8859-1?>"
     * "<mensajes>"
     * "<mensaje valor1=string1 valor2=string2 ... valorn=stringN "/>"
     * "</mensajes>"
     * @param response HttpServletResponse, de la sesion actual del servlet.
     * @param valor string, listado de string que se desee enviar.
     * @return no tiene retorno.
     * @exception Debe enviar primero el objeto HttpServletResponse y luego tanto valores String como se desee enviar.
     * @since version 1.0.0
     */
    public static void sendResult(HttpServletResponse response, String... valor) {
        System.out.println("Iniciando el metodo sendResult'");
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        StringBuilder sb = new StringBuilder();
        PrintWriter out = null;
        int iCantidad = valor.length;
        if (iCantidad>0){
            try {
                sb.append("<?xml version='1.0' encoding='ISO-8859-1'?>");
                sb.append(" <mensajes>");
                sb.append(" <mensaje ");
                for(int i=0;i<valor.length;i++) sb.append(" valor").append(i).append("='").append(valor[i]).append("' ");
                sb.append(" /> ");
                sb.append(" </mensajes>");
                out = response.getWriter();
                out.println(sb.toString());
            }catch(Exception e){
                System.err.println(ManagerTrace.PilaToString(e));
            }finally {
                if (out != null) out.close();
            }
        }
    }
}
