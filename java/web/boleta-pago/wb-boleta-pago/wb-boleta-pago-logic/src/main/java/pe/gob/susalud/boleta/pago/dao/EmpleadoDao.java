package pe.gob.susalud.boleta.pago.dao;

import java.util.List;
import java.util.Map;
import pe.gob.susalud.boleta.pago.model.Empleado;

/**
 *
 * @author jllamas
 */
public interface EmpleadoDao {
    public List<Empleado> obtenerEmpleado(Map reporteMap) throws Exception;
}
