package pe.org.jhsystem.util.manager.print;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import pe.org.jhsystem.util.manager.trace.ManagerTrace;

/**
 * @author Jose Luis Huaman Villar
 * @see <a href="http://diariojl.blogspot.pe/p/blog-page.html" target="_blank">ManagerUtil</a>
 * @version 1.0.5
 * @since 10-12-2014
 */
public class ManagerPrint {

    /**
     * Metodo que convierte una objeto MAP a una cadena.
     * @param pMap, objeto MAP a extraer datos.
     * @return string cadena de valores encontrados.
     * @since version 1.0.5
     */
    public static String MapToString(Map pMap){
        StringBuilder sbReturn = new StringBuilder();
	for( Iterator it = pMap.keySet().iterator(); it.hasNext();) {
            String s = (String)it.next();
            String s1 = (String)pMap.get(s);
            sbReturn.append("\t").append(s).append(" : ").append(s1).append("\n");
	}
        sbReturn.append("\n");
        return sbReturn.toString();
    }

    /**
     * Metodo que convierte una objeto de negocio BEAN a una cadena.
     * @param oBean, objeto a extraer datos.
     * @return string cadena de valores encontrados.
     * @since version 1.0.5
     */
    public static String BeanToString(Object oBean){
        Class clase;
        Field campo, campos[];
        String valor;
        StringBuilder sbReturn = new StringBuilder();

        try{
            clase = oBean.getClass();
            campos = clase.getFields();
            for (int i=0; i < campos.length; i++) {
                campo = campos[i];
                valor = (String) campo.get(oBean);
                sbReturn.append("\t").append(campo.getName()).append(" : ").append(valor).append("\n");
            }
        } catch (Exception ex) {
            String mensaje = "ERROR. " + ManagerTrace.PilaToString(ex);
            System.out.println(mensaje);
            return mensaje;
        }
        sbReturn.append("\n");
        return sbReturn.toString();
    }

}
