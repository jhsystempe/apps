package pe.gob.susalud.boleta.pago.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.susalud.boleta.pago.dao.PerfilDao;
import pe.gob.susalud.boleta.pago.entity.PerfilRequest;
import pe.gob.susalud.boleta.pago.model.Perfil;
import pe.gob.susalud.boleta.pago.service.PerfilService;
import pe.org.jhsystem.util.manager.trace.ManagerTrace;

/**
 *
 * @author jllamas
 */
@Service("perfilService")
public class PerfilServiceImpl implements PerfilService {

    private static final Logger log = (Logger) LogManager.getLogger(PerfilServiceImpl.class);
    @Autowired
    private PerfilDao dao;

    @Override
//    public PerfilRequest selectPerfil(PerfilRequest params) throws Exception {
    public List<Perfil> selectPerfil(PerfilRequest req) throws Exception {        
            
            String error = "0000", mensaje = "";

        List<Perfil> listaPerfil = null;
//        System.out.println("tipo_reporte:"+req.getTiReporte().toString());
        
            try {
                Map reporteMap = new HashMap();
                reporteMap.put("pcoPerfil", req.getCoPerfil().toString());
                
                System.out.println("consultarProcesoList>>>>>>>");
                
                listaPerfil = dao.selectPerfil(reporteMap);
                System.out.println("listaPerfil>>:"+listaPerfil.size());
            } catch (Exception ex) {
                error = "9000"; //Error en la base de datos
                mensaje = "Parametros:\n" + ManagerTrace.PilaToString(ex);
                log.error(mensaje);
            }
        return listaPerfil;
}            
        
    @Override
    public PerfilRequest selectUsuario(PerfilRequest params) throws Exception {
        PerfilRequest usuario = new PerfilRequest();
        try {

            usuario = dao.selectUsuario(params);

        } catch (Exception e) {

            e.printStackTrace();
        }
        return usuario;
    }
}
