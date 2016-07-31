package pe.org.jhsystem.util.manager.properties;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;
import pe.org.jhsystem.util.manager.properties.exception.PropertiesException;
import pe.org.jhsystem.util.manager.trace.ManagerTrace;

/**
 * @author Jose Luis Huaman Villar
 * @see <a href="http://diariojl.blogspot.pe/p/blog-page.html" target="_blank">ManagerUtil</a>
 * @version 1.0.6
 * @since 19-06-2015
 */
public class ManagerProperties {

    /**
     * Variable privada: Properties
     */
    private static String properties = "";
    /**
     * Variable privada: HashMap Prop
     */
    private static HashMap prop;

    /**
     * Constructor de la clase
     * @param nombre del properties
     */
    public ManagerProperties(String theProperties) {
        properties = theProperties;
        cargaProperties();
    }
    
    /**
     * Metodo que carga los valores del archivo properties a objetos JAVA.
     * @since version 1.0.0
     */
    private void cargaProperties(){
        try {
            FileInputStream f = new FileInputStream(properties);
            Properties propTemp = new Properties();
            propTemp.load(f);
            f.close();
            prop = new HashMap(propTemp);
        } catch (Exception ex) {
            System.err.println(ManagerTrace.PilaToString(ex));
        }
    }

    /**
     * Metodo que obtiene el properties cargado anteriormente.
     * @param name, nombre del properties a devolver.
     * @return string valor encontrado.
     * @since version 1.0.5
     */
    public String getProperty(String name) throws PropertiesException {
        String valor = (String) prop.get(name);
        if (valor == null) throw new PropertiesException(name);
        return valor;
    }

}
