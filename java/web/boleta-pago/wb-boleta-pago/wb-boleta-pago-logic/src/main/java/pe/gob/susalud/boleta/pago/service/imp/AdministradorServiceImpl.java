package pe.gob.susalud.boleta.pago.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.susalud.boleta.pago.dao.AdministradorDao;
import pe.gob.susalud.boleta.pago.entity.AdministradorRequest;
import pe.gob.susalud.boleta.pago.model.Administrador;
import pe.gob.susalud.boleta.pago.service.AdministradorService;
import pe.org.jhsystem.util.manager.trace.ManagerTrace;

/**
 *
 * @author jllamas
 */
@Service("consultarProcesoService")
@Transactional
public class AdministradorServiceImpl implements AdministradorService{

    private static final Logger log = LogManager.getLogger(AdministradorServiceImpl.class);
    @Autowired
    private AdministradorDao consultarProcesoDao;
    
    
    @Override
    public List<Administrador> consultarProcesoList(AdministradorRequest req) throws Exception {
        String error = "0000", mensaje = "";

        List<Administrador> listaConsultaProceso = null;
//        System.out.println("tipo_reporte:"+req.getTiReporte().toString());
        
            try {
                Map administradorMap = new HashMap();
                administradorMap.put("pPerAnio", req.getpPerAnio().toString());
                administradorMap.put("pPerMes", req.getpPerMes().toString());
                administradorMap.put("pFlagAnulado", req.getpFlagAnulado().toString());
//                administradorMap.put("pFlagDescargado", req.getpFlagDescargado().toString());
//                administradorMap.put("pFlagGenerado", req.getpFlagGenerado().toString());
                
                listaConsultaProceso = consultarProcesoDao.consultarProcesoList(administradorMap);
                log.info("listaConsultaProceso"+listaConsultaProceso.size());
            } catch (Exception ex) {
                error = "9000"; //Error en la base de datos
                mensaje = "Parametros:\n" + ManagerTrace.PilaToString(ex);
                log.error(mensaje);
            }
        return listaConsultaProceso;
        
    }

//    @Override
//    public List<Administrador> consultarBoletaList(AdministradorRequest req) throws Exception {
//        String error = "0000", mensaje = "";
//
//        List<Administrador> consultarBoletaList = null;        
//            try {
//                Map administradorMap = new HashMap();                 
//                administradorMap.put("pPerAnio", req.getpPerAnio().toString());
//                administradorMap.put("pPerMes", req.getpPerMes().toString());
//                administradorMap.put("pFlagAnulado", req.getpFlagAnulado().toString());
//                administradorMap.put("pFlagDescargado", req.getpFlagDescargado().toString());
//                administradorMap.put("pFlagGenerado", req.getpFlagGenerado().toString());
//
//                log.info("consultarBoletaList");
//                consultarBoletaList = consultarProcesoDao.consultarBoletaList(administradorMap);
//            } catch (Exception ex) {
//                error = "9000"; //Error en la base de datos
//                mensaje = "Parametros:\n" + ManagerTrace.PilaToString(ex);
//                log.error(mensaje);
//            }
//        return consultarBoletaList;
//    }

    
}
