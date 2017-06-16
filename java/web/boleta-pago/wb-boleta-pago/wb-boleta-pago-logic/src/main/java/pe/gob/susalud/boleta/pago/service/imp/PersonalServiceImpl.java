package pe.gob.susalud.boleta.pago.service.imp;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.susalud.boleta.pago.dao.PersonalDao;
import pe.gob.susalud.boleta.pago.entity.PersonalRequest;
import pe.gob.susalud.boleta.pago.model.Personal;
import pe.gob.susalud.boleta.pago.service.PersonalService;
//import pe.org.jhsystem.util.manager.print.ManagerPrint;
import pe.org.jhsystem.util.manager.trace.ManagerTrace;

/**
 *
 * @author jllamas
 */
@Service("consultarPersonalService")
@Transactional
public class PersonalServiceImpl implements PersonalService{

    private static final Logger log = LogManager.getLogger(PersonalServiceImpl.class);
    @Autowired
    private PersonalDao consultarPersonalDao;
    
    @Override
    public List<Personal> consultarPersonalList(PersonalRequest req) throws Exception {
        String error = "0000", mensaje = "";

        List<Personal> listaConsultaPersonal = null;
//        System.out.println("tipo_reporte:"+req.getTiReporte().toString());
        
            try {
                Map reporteMap = new HashMap();
                reporteMap.put("pNuDni", req.getNuDni().toString());
                reporteMap.put("pPerAnio", req.getIdAnio().toString());
                reporteMap.put("pPerMes", req.getIdMes().toString());
                reporteMap.put("pFlagAnulado", req.getIdFlag().toString());

//                System.out.println("consultarProcesoList>>>>>>>");
                log.debug("listaConsultaPersonal");
                listaConsultaPersonal = consultarPersonalDao.consultarPersonalList(reporteMap);
                System.out.println("servicio:"+listaConsultaPersonal.size());
            } catch (Exception ex) {
                error = "9000"; //Error en la base de datos
                mensaje = "Parametros:\n" + ManagerTrace.PilaToString(ex);
                log.error(mensaje);
            }
        return listaConsultaPersonal;
    }

    @Override
    public void updFechaDescarga(String nuSecuencial) {
        consultarPersonalDao.updFechaDescarga(nuSecuencial);
        log.debug("ACtualizo Fecha de Descarga");
    }
    
    @Override
    public List<Personal> consultarPersonalDetalle(PersonalRequest req) throws Exception {
        String error = "0000", mensaje = "";
        List<Personal> listaConsultaPersonal = null;
        try {
            Map reporteMap = new HashMap();
            reporteMap.put("pNuDni", req.getNuDni().toString());
            reporteMap.put("pPerAnio", req.getIdAnio().toString());
            reporteMap.put("pPerMes", req.getIdMes().toString());
            reporteMap.put("pFlagAnulado", req.getIdFlag().toString());
            reporteMap.put("pFlagDescargado", req.getIdDescargado().toString());
            reporteMap.put("pFlagGenerado", req.getIdGenerado().toString());

            log.debug("listaConsultaPersonal");
            listaConsultaPersonal = consultarPersonalDao.consultarPersonalDetalle(reporteMap);
            log.debug("servicio:"+listaConsultaPersonal.size());
        } catch (Exception ex) {
            error = "9000"; //Error en la base de datos
            mensaje = error + "\nParametros:\n" + ManagerTrace.PilaToString(ex);
            log.error(mensaje);
        }
        return listaConsultaPersonal;
    }
}
