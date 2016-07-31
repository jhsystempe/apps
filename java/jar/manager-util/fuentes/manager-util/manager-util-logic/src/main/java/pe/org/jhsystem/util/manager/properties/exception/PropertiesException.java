package pe.org.jhsystem.util.manager.properties.exception;

/**
 * @author Jose Luis Huaman Villar
 * @see <a href="http://diariojl.blogspot.pe/p/blog-page.html" target="_blank">ManagerUtil</a>
 * @version 1.0.0
 * @since 17-11-2012
 */
public class PropertiesException extends Exception {

    /**
     * Variable privada: Nombre del Parametro
     */
    private String nameParam;

    /**
     * Constructor de la clase
     * @param nombre del parametro
     */
    public PropertiesException(String nameParam) {
        super("Error: Falta parametro de configuracion: '" + nameParam + "'");
        this.nameParam = nameParam;
    }

    /**
     * Metodo GET de la variable privada Nombre del Parametro
     */
    public String getNameParam() {
        return nameParam;
    }
}
