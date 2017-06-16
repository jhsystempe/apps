package pe.gob.susalud.boleta.pago.service;

import java.util.List;
import pe.gob.susalud.boleta.pago.entity.PersonalRequest;
import pe.gob.susalud.boleta.pago.model.Personal;

/**
 *
 * @author jllamas
 */
public interface PersonalService {

    public List<Personal> consultarPersonalList(PersonalRequest req) throws Exception;
    public void updFechaDescarga(String nuSecuencial);
    public List<Personal> consultarPersonalDetalle(PersonalRequest req) throws Exception;
}
