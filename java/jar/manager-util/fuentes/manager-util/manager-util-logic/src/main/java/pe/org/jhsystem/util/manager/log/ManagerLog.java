package pe.org.jhsystem.util.manager.log;

import java.lang.reflect.Method;

/**
 * @author Jose Luis Huaman Villar
 * @see <a href="http://diariojl.blogspot.pe/p/blog-page.html" target="_blank">ManagerUtil</a>
 * @version 1.0.0
 * @since 17-11-2012
 */
public class ManagerLog {
    
    /**
     * Variable privada: Nombre de la Clase
     */
    static Class clase;
    /**
     * Variable privada: Nombre del Metodo
     */
    static Method metodo;

    /**
     * Metodo que describe la clase JAVA y sus metodos publicos.
     * @param sClase string nombre de la clase a visualizar.
     * @param iMetodo int identificador numerico del metodo a visualizar
     * @return string con los datos a visualizar.
     * @exception ClassNotFoundException Sino encuentra la clase y/o metodo a visualizar.
     * @since version 1.0.0
     */
    public static String toDescription(String sClase, int iMetodo){
        String sReturn = "";
        try {
            clase = Class.forName(sClase);
            sReturn = "Clase: "+clase.getName();
            metodo = clase.getMethods()[iMetodo];
            sReturn = sReturn + " Metodo: "+metodo.getName();
        } catch (ClassNotFoundException e) {
            sReturn = "No se ha encontrado la clase. " + e;
        }
        return sReturn;
    }
}
