package pe.gob.susalud.boleta.pago.dao;

import java.util.List;
import java.util.Map;
import pe.gob.susalud.boleta.pago.model.ActualizaBoleta;
import pe.gob.susalud.boleta.pago.model.BoletaPago;

/**
 *
 * @author jllamas
 */
public interface BoletaPagoDao {
    public List<BoletaPago> obtenerBoleta(Map reporteMap) throws Exception;
    public void actualizarBoleta(ActualizaBoleta actualizaBoleta) throws Exception;
}
