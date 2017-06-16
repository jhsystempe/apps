package pe.gob.susalud.boleta.pago.service;

import java.util.List;
import pe.gob.susalud.boleta.pago.entity.EmpleadoRequest;
import pe.gob.susalud.boleta.pago.model.Empleado;

/**
 *
 * @author jllamas
 */
public interface EmpleadoService {

    public List<Empleado> obtenerEmpleado(EmpleadoRequest req) throws Exception;
}
