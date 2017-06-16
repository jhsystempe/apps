package pe.gob.susalud.boleta.pago.service;

import pe.gob.susalud.boleta.pago.entity.GenerarRequest;

/**
 *
 * @author jllamas
 */
public interface GenerarBoletaService {

    public String generarBoleta(GenerarRequest req) throws Exception;
    public byte[] generarBoletaTest(GenerarRequest req);
}
