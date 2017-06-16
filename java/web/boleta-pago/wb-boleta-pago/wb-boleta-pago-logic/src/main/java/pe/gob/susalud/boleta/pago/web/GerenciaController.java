package pe.gob.susalud.boleta.pago.web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jllamas
 */
@Controller
public class GerenciaController {

    Map model = null;

//    @Autowired
//    private AdministradorService consultarProcesoService;
    @RequestMapping(value = "/consulta.htm")
    public ModelAndView ConsultarGerencia(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        model = new HashMap();
        
        String perfil = (String) request.getSession().getAttribute("coIdentificador");
        System.out.println("perfil Nombre>>>"+perfil);
        model.put("perfil", perfil);
        
        return new ModelAndView("gerencia/consulta");
    }

    @RequestMapping(value = "/consultaProceso.htm")
    public ModelAndView ConsultaProceso(HttpServletRequest req) throws Exception {
    
        
        String perfil = (String) req.getSession().getAttribute("coIdentificador");
        System.out.println("perfil Nombre>>>"+perfil);
        model.put("perfil", perfil);
        
        return new ModelAndView("gerencia/procesar_consulta");
    }
        
}
