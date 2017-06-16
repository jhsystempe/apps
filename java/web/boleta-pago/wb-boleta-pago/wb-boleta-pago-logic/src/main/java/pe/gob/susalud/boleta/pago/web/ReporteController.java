package pe.gob.susalud.boleta.pago.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.gob.susalud.boleta.pago.entity.GenerarRequest;
import pe.gob.susalud.boleta.pago.service.GenerarBoletaService;

/**
 * @author jhuamanv
 */
@Controller
public class ReporteController {

    Map model = null;
    
    @Autowired
    private GenerarBoletaService generarBoletaService;
    
    private static final Logger logger = Logger.getLogger(ReporteController.class);
    
    @RequestMapping("/index.htm")
    public ModelAndView inicio(){
        logger.debug("Ingresando a la vista de Inicio");
        return new ModelAndView("/index");
    }
  
    @RequestMapping("/generarBoleta.htm")
    public ModelAndView generarBoleta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JRException, Exception {
        model = new HashMap();
        
        String tiPlan = request.getParameter("hddTiPlan").trim();
        String suTiPlan = request.getParameter("hddSuTiPlan").trim();
        String anio = request.getParameter("hddAnioP").trim();
        String mes = request.getParameter("hddMesP").trim();
//        String coEmpleado = request.getParameter("hddCoEmpleado").trim();
        String flag = "N";
        String path = request.getSession().getServletContext().getRealPath("").toString();

        String mensaje = "";
        
        GenerarRequest generar = new GenerarRequest();
        
        generar.setTiPlan(tiPlan.trim());
        generar.setSuTiPlan(suTiPlan.trim());
        generar.setNuAnio(anio.trim());
        generar.setNuMes(mes.trim());
//        generar.setCoEmpleado(coEmpleado.trim());
        generar.setIdFlag(flag.trim());
        generar.setDePath(path);
        
//        generar.setTiPlan("06");
//        generar.setSuTiPlan("N");
//        generar.setNuAnio("2016");
//        generar.setNuMes("02");
////        generar.setCoEmpleado("00000160");
//        generar.setIdFlag("N");
//        generar.setDePath(path);
        
        generarBoletaService.generarBoleta(generar);
//        return null;
        mensaje = "Generación de Boletas Correcto.";
        model.put("mensajeGenerar", mensaje);
        return new ModelAndView("admin/procesar_mensaje",model);        
    }

    @RequestMapping("/generarBoletaTest.htm")
    public ModelAndView generarBoletaTest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JRException {
        String path = request.getSession().getServletContext().getRealPath("").toString();
        
        GenerarRequest generar = new GenerarRequest();
        generar.setDePath(path);
        
        ServletOutputStream out = null;
        byte[] reporte = null;
        reporte = generarBoletaService.generarBoletaTest(generar);
        
        if(reporte != null){
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "inline; filename=boletaPago.pdf");
            response.setHeader("Cache-Control", "max-age=30");
            response.setHeader("Pragma", "No-cache");
            response.setDateHeader("Expires", 0);
            response.setContentLength(reporte.length);
            
            out = response.getOutputStream();
            out.write(reporte, 0, reporte.length);
            out.flush();
            out.close();
        }
        return null;
    }

}
