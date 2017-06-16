package pe.gob.susalud.boleta.pago.dao;

import java.util.List;
import java.util.Map;
import pe.gob.susalud.boleta.pago.entity.PerfilRequest;
import pe.gob.susalud.boleta.pago.model.Perfil;

/**
 *
 * @author jllamas
 */
public interface PerfilDao {
    public List<Perfil> selectPerfil(Map reporteMap) throws Exception;
    PerfilRequest selectUsuario(PerfilRequest perfil) throws Exception;
}
 