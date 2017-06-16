package pe.gob.susalud.boleta.pago.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.susalud.boleta.pago.dao.EmpleadoDao;
import pe.gob.susalud.boleta.pago.entity.EmpleadoRequest;
import pe.gob.susalud.boleta.pago.model.Empleado;
import pe.gob.susalud.boleta.pago.service.EmpleadoService;
import pe.org.jhsystem.util.manager.trace.ManagerTrace;

/**
 *
 * @author jllamas
 */
@Service("empleadoService")
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

    private static final Logger logger = LogManager.getLogger(EmpleadoServiceImpl.class);
    @Autowired
    private EmpleadoDao empleadoDao;

    @Override
    public List<Empleado> obtenerEmpleado(EmpleadoRequest req) throws Exception {
        String error = "0000", mensaje = "";

        List<Empleado> listEmpleado = null;
//        System.out.println("tipo_reporte:"+req.getTiReporte().toString());
        try {
            Map reporteMap = new HashMap();
            reporteMap.put("pUsuario", req.getpUsuario().toString());
//            System.out.println("consultarProcesoList>>>>>>>");
            logger.info("listaConsultaPersonal");
            listEmpleado = empleadoDao.obtenerEmpleado(reporteMap);
            System.out.println("servicio:" + listEmpleado.size());
        } catch (Exception ex) {
            error = "9000"; //Error en la base de datos
            mensaje = "Parametros:\n" + ManagerTrace.PilaToString(ex);
            logger.error(mensaje);
        }
        return listEmpleado;
    }
}
