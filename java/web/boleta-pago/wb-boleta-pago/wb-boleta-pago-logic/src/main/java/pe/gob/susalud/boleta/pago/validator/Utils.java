package pe.gob.susalud.boleta.pago.validator;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author jllamas
 */
public class Utils {

    public Utils() {
    }

    public static String getProperties(String cadena) throws MalformedURLException {

        String ruta_java = System.getProperty("java.home");

        File file = new File(ruta_java);
        URL[] urls = {file.toURI().toURL()};
        ClassLoader loader = new URLClassLoader(urls);
        ResourceBundle bundle = ResourceBundle.getBundle("wb-boleta-pago", Locale.getDefault(), loader);

        String valorproperties = (String) bundle.getObject(cadena);

        return valorproperties;
    }
    
    
}
