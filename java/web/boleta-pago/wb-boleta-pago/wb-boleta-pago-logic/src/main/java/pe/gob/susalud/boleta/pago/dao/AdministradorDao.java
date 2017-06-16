package pe.gob.susalud.boleta.pago.dao;

import java.util.List;
import java.util.Map;
import pe.gob.susalud.boleta.pago.model.Administrador;
/**
 *
 * @author jllamas
 */
public interface AdministradorDao {

    public List<Administrador> consultarProcesoList(Map reporteMap) throws Exception;
//    public List<Administrador> consultarBoletaList(Map reporteMap) throws Exception;
}
