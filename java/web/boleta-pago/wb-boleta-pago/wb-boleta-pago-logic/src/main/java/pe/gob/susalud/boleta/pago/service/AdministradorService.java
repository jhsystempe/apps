package pe.gob.susalud.boleta.pago.service;

import java.util.List;
import pe.gob.susalud.boleta.pago.entity.AdministradorRequest;
import pe.gob.susalud.boleta.pago.model.Administrador;

/**
 *
 * @author jllamas
 */
public interface AdministradorService {
 
    public List<Administrador> consultarProcesoList(AdministradorRequest req) throws Exception;
//    public List<Administrador> consultarBoletaList(AdministradorRequest req) throws Exception;
}
