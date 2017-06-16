package pe.gob.susalud.boleta.pago.service.imp;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.susalud.boleta.pago.dao.FuncionDao;
import pe.gob.susalud.boleta.pago.model.Funcion;
import pe.gob.susalud.boleta.pago.service.FuncionService;
import pe.org.jhsystem.util.manager.trace.ManagerTrace;

/**
 *
 * @author jllamas
*/
@Service("selectAnio")
@Transactional
public class FuncionServiceImpl implements FuncionService{

    private static final Logger log = LogManager.getLogger(FuncionServiceImpl.class);
    @Autowired
    private FuncionDao funcionDao;
     
    
    @Override
    public List<Funcion> selAnio() throws Exception{
        
        String error = "0000", mensaje = "";
        List<Funcion> listaAnio= null;
        
        try {
            listaAnio = funcionDao.selAnio();
        } catch (Exception ex) {
            error = "9000";
            mensaje = "Parametros:\n" + ManagerTrace.PilaToString(ex);
            log.error(mensaje);
        }
        return listaAnio;
    }    
    
}
