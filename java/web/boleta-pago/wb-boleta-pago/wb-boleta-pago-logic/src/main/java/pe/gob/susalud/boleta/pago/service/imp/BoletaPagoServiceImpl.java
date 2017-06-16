package pe.gob.susalud.boleta.pago.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.susalud.boleta.pago.dao.BoletaPagoDao;
import pe.gob.susalud.boleta.pago.entity.GenerarRequest;
import pe.gob.susalud.boleta.pago.model.ActualizaBoleta;
import pe.gob.susalud.boleta.pago.model.BoletaPago;
import pe.gob.susalud.boleta.pago.service.BoletaPagoService;
import pe.org.jhsystem.util.manager.trace.ManagerTrace;

/**
 *
 * @author jllamas
 */
@Service("boletaPagoService")
@Transactional
public class BoletaPagoServiceImpl  implements BoletaPagoService{
    
    private static final Logger logger = LogManager.getLogger(BoletaPagoServiceImpl.class);
    @Autowired
    private BoletaPagoDao boletaPagoDao;

    @Override
    public List<BoletaPago> obtenerBoleta(GenerarRequest req) throws Exception {
        String error = "0000", mensaje = "";
        List<BoletaPago> listaBoletaPago = null;
        try {
            Map reporteMap = new HashMap();
            reporteMap.put("pTipoPlan", req.getTiPlan().toString());
            reporteMap.put("pSubTipoPlan", req.getSuTiPlan().toString());
            reporteMap.put("pPerAnio", req.getNuAnio().toString());
            reporteMap.put("pPerMes", req.getNuMes().toString());
//            reporteMap.put("pCodiEmpl", req.getCoEmpleado().toString());
            reporteMap.put("pFlagAnulado", req.getIdFlag().toString());
            listaBoletaPago = boletaPagoDao.obtenerBoleta(reporteMap);
            logger.debug("servicio:"+listaBoletaPago.size());
        } catch (Exception ex) {
            error = "9000"; //Error en la base de datos
            mensaje = error+":Parametros:\n" + ManagerTrace.PilaToString(ex);
            logger.error(mensaje);
        }
        return listaBoletaPago;
    }

    @Override
    public String actualizarBoleta(ActualizaBoleta actualiza) throws Exception {
        String error = "0000", mensaje = "";
        try {
            boletaPagoDao.actualizarBoleta(actualiza);
            logger.debug("Actualizo?"+actualiza.getpRetorno());
        } catch (Exception ex) {
            error = "9000"; //Error en la base de datos
            mensaje = error+":Error de base de datos:\n" + ManagerTrace.PilaToString(ex);
            logger.error(mensaje);
        }
        return actualiza.getpRetorno();
    }
    
}
