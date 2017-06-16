package pe.gob.susalud.boleta.pago.web;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pe.gob.susalud.boleta.pago.entity.EmpleadoRequest;

import pe.gob.susalud.boleta.pago.entity.PersonalRequest;
import pe.gob.susalud.boleta.pago.model.Empleado;
import pe.gob.susalud.boleta.pago.model.Funcion;
import pe.gob.susalud.boleta.pago.model.Personal;
import pe.gob.susalud.boleta.pago.service.EmpleadoService;
import pe.gob.susalud.boleta.pago.service.FuncionService;
import pe.gob.susalud.boleta.pago.service.PersonalService;

/**
 *
 * @author jllamas
 */
@Controller
public class PersonalController {

    Map model = null;
    @Autowired
    private PersonalService consultarPersonalService;
    @Autowired
    private FuncionService funcionService;
    @Autowired
    private EmpleadoService empleadoService;

    @Value("${pathArchivos}")
    private String pathArchivos;

    @RequestMapping(value = "/consultarPersonal.htm")
    public ModelAndView ConsultarPersonal(HttpServletRequest req) throws Exception {
        model = new HashMap();
        
        List<Funcion> listaAnio= funcionService.selAnio();        
        System.out.println("listaAnio>>" + listaAnio.size());
        model.put("listaAnio", listaAnio);        
       
        String perfil = (String) req.getSession().getAttribute("coIdentificador");
        System.out.println("perfil Nombre>>>"+perfil);
        model.put("perfil", perfil);
        
        return new ModelAndView("personal/personal", model);
    }

    @RequestMapping(value = "/personalListar.htm", method = RequestMethod.POST)
    public ModelAndView reportePersonal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        model = new HashMap();
        String usuario = "";
        String nuDocumento = "";

        String anio = request.getParameter("hddAnio").trim();
        String mes = request.getParameter("hddMes").trim();
        
        if(usuario.isEmpty()){
            usuario = (String) request.getSession().getAttribute("usuario");
        }
        
        EmpleadoRequest empleadoRequest = new EmpleadoRequest();
        empleadoRequest.setpUsuario(usuario.trim());

        request.getSession().setAttribute("obtieneEmpleado", "");        

        List<Empleado> obtieneEmpleado = empleadoService.obtenerEmpleado(empleadoRequest);
        System.out.println("listaEMpelado" + obtieneEmpleado.size());            
        nuDocumento = obtieneEmpleado.get(0).getNuDocEmpleado().trim();
        System.out.println("nuDocumento>>"+nuDocumento);
                
        String flag = "N";

        if (anio.equals("-1")) { anio = ""; }
        if (mes.equals("-1")) { mes = ""; }

        PersonalRequest personalRequest = new PersonalRequest();
//        personalRequest.setNuDni(dni.trim());
        personalRequest.setNuDni(nuDocumento.trim());
        personalRequest.setIdAnio(anio.trim());
        personalRequest.setIdMes(mes.trim());
        personalRequest.setIdFlag(flag.trim());

        request.getSession().setAttribute("listConsultaPersonal", "");

        List<Personal> listConsultaPersonal = consultarPersonalService.consultarPersonalList(personalRequest);
        System.out.println("controller_Carga:" + listConsultaPersonal.size());

        model.put("listConsultaPersonal", listConsultaPersonal);
        
        String perfil = (String) request.getSession().getAttribute("coIdentificador");
        System.out.println("perfil Nombre>>>"+perfil);
        model.put("perfil", perfil);
        
        return new ModelAndView("personal/personal_listar", model);

    }

    @RequestMapping(value = "/descargarBoleta.htm")
    protected void descargarBoleta(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String nuSecuencial = req.getParameter("nuSecuencial") == null ? "" : req.getParameter("nuSecuencial");
        String rutaArchivo = req.getParameter("rutaArchivo") == null ? "" : req.getParameter("rutaArchivo");

        String fileName = "";
        fileName = pathArchivos.trim() + rutaArchivo.trim();
        System.out.println("fileName=" + fileName);
        resp.setContentType("application/pdf");
        resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        OutputStream out = resp.getOutputStream();
        java.io.File file = new java.io.File(fileName);
        java.io.FileInputStream in = new java.io.FileInputStream(file);
        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        in.close();
        out.close();

        consultarPersonalService.updFechaDescarga(nuSecuencial);

    }
}
