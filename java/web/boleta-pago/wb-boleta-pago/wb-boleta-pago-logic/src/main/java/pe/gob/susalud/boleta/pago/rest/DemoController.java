package pe.gob.susalud.boleta.pago.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.org.jhsystem.util.manager.trace.ManagerTrace;

/**
 *
 * @author Jose Luis Huaman Villar
 * @version 1.0.0
 */
@Controller
@RequestMapping("/boletaDePago")
public class DemoController {
    
    private static final Logger logger = Logger.getLogger(DemoController.class);
    
//    @Autowired
//    private DemoService demoService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        logger.info("Se ha ingresado la raiz de la peticion");
        return "index";
    }
    
//    @RequestMapping(value = "/demo",
//                    method = RequestMethod.POST, 
//                    produces = "application/json")
//    public @ResponseBody DemoResponse getFechas(@RequestBody DemoRequest demoRequest,
//           HttpServletRequest req, HttpServletResponse res) {
//        
//        DemoResponse demoResponse = new DemoResponse();
//        
//        DemoRequestValidator demoValidator = new DemoRequestValidator();
//        demoResponse.setCoError(demoValidator.validateRequest(demoRequest));
//        
//        if(demoResponse.getCoError().equals("0000")){
//            try {
//                demoResponse = (DemoResponse) demoService.getDemo(demoRequest);
//            } catch (Exception ex) {
//                String mensaje = "Error:\n" + ManagerTrace.PilaToString(ex);
//                logger.error(mensaje);
//                return returnErrorDemo(demoRequest,"9999"); //Error del ws
//            }
//        }else{
//            logger.debug("Error: "+demoResponse.getCoError());
//            return returnErrorDemo(demoRequest, demoResponse.getCoError());
//        }
//    	return demoResponse;
//    }
//    
//    DemoResponse returnErrorDemo(DemoRequest request, String sError){
//        DemoResponse response = new DemoResponse();
//        response.setCoError(sError);
//        response.setDeRespuesta(request.getDePeticion());
//        response.addDetalle(null);
//        return response;
//    }
}
