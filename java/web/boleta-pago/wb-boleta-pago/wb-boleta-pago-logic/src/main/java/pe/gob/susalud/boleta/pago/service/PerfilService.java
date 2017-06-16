package pe.gob.susalud.boleta.pago.service;

import java.util.List;
import pe.gob.susalud.boleta.pago.entity.PerfilRequest;
import pe.gob.susalud.boleta.pago.model.Perfil;

/**
 *
 * @author jllamas
 */
public interface PerfilService {
    
    public List<Perfil> selectPerfil(PerfilRequest req) throws Exception;
    PerfilRequest selectUsuario(PerfilRequest entity) throws Exception;
}
