package pe.gob.susalud.boleta.pago.validator;

import pe.gob.susalud.boleta.pago.entity.AdministradorRequest;

/**
 *
 * @author Jose Luis Huaman Villar
 * @version 1.0.0
 */
public class DemoRequestValidator {

    String error = "0000";
    
    public String validateRequest(AdministradorRequest request){
        if(request.getpPerAnio().trim().length()==0) error = "0110"; // getpPerAnio --> vacio
        return error;
    }
}
