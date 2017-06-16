package pe.gob.susalud.boleta.pago.dao;

import java.util.List;
import pe.gob.susalud.boleta.pago.model.Funcion;

/**
 *
 * @author jllamas
 */
public interface FuncionDao {

    public List<Funcion> selAnio() throws Exception;
}
