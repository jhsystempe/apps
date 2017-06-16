package pe.gob.susalud.boleta.pago.service;

import java.util.List;
import pe.gob.susalud.boleta.pago.entity.GenerarRequest;
import pe.gob.susalud.boleta.pago.model.ActualizaBoleta;
import pe.gob.susalud.boleta.pago.model.BoletaPago;

/**
 *
 * @author jllamas
 */
public interface BoletaPagoService {

    public List<BoletaPago> obtenerBoleta(GenerarRequest req) throws Exception;
    public String actualizarBoleta(ActualizaBoleta actualiza) throws Exception;
}
