package pe.gob.susalud.boleta.pago.dao;

import java.util.List;
import java.util.Map;
import pe.gob.susalud.boleta.pago.model.Personal;

/**
 *
 * @author jllamas
 */
public interface PersonalDao {

    public List<Personal> consultarPersonalList(Map reporteMap) throws Exception;
    public void updFechaDescarga(String nuSecuencial);
    public List<Personal> consultarPersonalDetalle(Map reporteMap) throws Exception;
}
