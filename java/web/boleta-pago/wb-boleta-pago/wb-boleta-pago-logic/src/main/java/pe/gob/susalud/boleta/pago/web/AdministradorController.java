package pe.gob.susalud.boleta.pago.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.susalud.boleta.pago.entity.AdministradorRequest;
import pe.gob.susalud.boleta.pago.entity.EmpleadoRequest;
import pe.gob.susalud.boleta.pago.entity.PersonalRequest;
import pe.gob.susalud.boleta.pago.model.Administrador;
import pe.gob.susalud.boleta.pago.model.Empleado;
import pe.gob.susalud.boleta.pago.model.Funcion;
import pe.gob.susalud.boleta.pago.model.Personal;
import pe.gob.susalud.boleta.pago.service.AdministradorService;
import pe.gob.susalud.boleta.pago.service.EmpleadoService;
import pe.gob.susalud.boleta.pago.service.FuncionService;
import pe.gob.susalud.boleta.pago.service.PersonalService;
import pe.gob.susalud.clientseguridadsunasa.WsLogin;
import pe.gob.susalud.model.Table;

/**
 *
 * @author Jose Luis Huaman Villar
 * @version 1.0.0
 */
@Controller
public class AdministradorController {

    Map model = null;
    @Autowired
    private AdministradorService consultarProcesoService;
    @Autowired
    private PersonalService consultarPersonal;
    @Autowired
    private FuncionService funcionService;
    @Autowired
    private EmpleadoService empleadoService;

    @Value("${wsUrl}")
    private String wsUrl;
    @Value("${wsUsuario}")
    private String wsUsuario;
    @Value("${wsPass}")
    private String wsPass;
    @Value("${coApl}")
    private String coApl;
    @Value("${coSis}")
    private String coSis;
    
    @RequestMapping(value = "/seleccionarEmpleado.htm", method = RequestMethod.POST)
    public ModelAndView SeleccionarEmpleado(HttpServletRequest req, HttpServletResponse response) throws Exception {

        model = new HashMap();

        String usuario = req.getParameter("hddUsuario").trim();
        String pass = req.getParameter("hddPass").trim();

        String mensaje = "";
        String nuDocumento = "";
        String noUsuario = "";
        
        WsLogin loginUsuarios = new WsLogin();
        List<Table> lista = loginUsuarios.loginUsuarioing(wsUsuario, wsPass, usuario, pass, wsUrl);
            
        //        req.getSession().setAttribute("usuario", usuario);

        if (lista.isEmpty()) {
            HttpSession session;
            session = req.getSession(true);
            session.removeAttribute("usuario");
            session.removeAttribute("pass");

            mensaje = "Credenciales Incorrectas";
            model.put("mensajeEmpleado", mensaje);
            return new ModelAndView("login", model);
        } else {            
            EmpleadoRequest empleadoRequest = new EmpleadoRequest();
            empleadoRequest.setpUsuario(usuario.trim());

            req.getSession().setAttribute("obtieneEmpleado", "");        

            List<Empleado> obtieneEmpleado = empleadoService.obtenerEmpleado(empleadoRequest);
            System.out.println("listaEMpelado" + obtieneEmpleado.size());            
            nuDocumento = obtieneEmpleado.get(0).getNuDocEmpleado().trim();
            noUsuario = obtieneEmpleado.get(0).getNoEmpleado().trim();            
            model.put("nomUsuario", noUsuario);
            model.put("nuDocumento", nuDocumento);
            model.put("obtieneEmpleado", obtieneEmpleado);
        }
            
        req.getSession().setAttribute("usuario", usuario);
        req.getSession().setAttribute("nuDocumento", nuDocumento);
        return new ModelAndView("redirect:inicioProceso.htm");
    }

    @RequestMapping(value = "/iniciar.htm")
    public ModelAndView Iniciar(HttpServletRequest req) throws Exception {
        model = new HashMap();
        
        String perfil = (String) req.getSession().getAttribute("coIdentificador");
        System.out.println("perfil Nombre>>>"+perfil);
        model.put("perfil", perfil);
        
        return new ModelAndView("inicio", model);
    }
    
    @RequestMapping(value = "/inicioProceso.htm")
    public ModelAndView InicioProceso(HttpServletRequest req) throws Exception {
        model = new HashMap();

        String perfil = (String) req.getSession().getAttribute("coIdentificador");
        System.out.println("perfil   2>>>"+perfil);
        model.put("perfil", perfil);
        
        List<Funcion> listaAnio = funcionService.selAnio();
        System.out.println("listaAnio>>" + listaAnio.size());
        model.put("listaAnio", listaAnio);

        return new ModelAndView("admin/procesar", model);
    }

    @RequestMapping(value = "/consultarProceso.htm")
    public ModelAndView ConsultarProceso(HttpServletRequest req) throws Exception {
        model = new HashMap();

        List<Funcion> listaAnio = funcionService.selAnio();
        System.out.println("listaAnio>>" + listaAnio.size());
        model.put("listaAnio", listaAnio);

        String perfil = (String) req.getSession().getAttribute("coIdentificador");
        System.out.println("perfil Nombre>>>"+perfil);
        model.put("perfil", perfil);
        return new ModelAndView("admin/procesar_consulta", model);
    }

    @RequestMapping(value = "/procesar.htm", method = RequestMethod.POST)
    public ModelAndView procesarBoletas(HttpServletRequest request, HttpServletResponse response) throws Exception {
        model = new HashMap();

        String anio = request.getParameter("hddAnio").trim();
        String mes = request.getParameter("hddMes").trim();
        String flagAnulado = "N";
        String flagDescargado = "0";
        String flagGenerado = "0";

        if (anio.equals("-1")) {
            anio = "";
        }
        if (mes.equals("-1")) {
            mes = "";
        }

        AdministradorRequest administradorRequest = new AdministradorRequest();
//        if(anio != null) administradorRequest.setpPerAnio(anio.trim());
//        if(mes != null) administradorRequest.setpPerMes(mes.trim());
        administradorRequest.setpPerAnio(anio.trim());
        administradorRequest.setpPerMes(mes.trim());
        administradorRequest.setpFlagAnulado(flagAnulado.trim());
        administradorRequest.setpFlagDescargado(flagDescargado.trim());
        administradorRequest.setpFlagGenerado(flagGenerado.trim());

        request.getSession().setAttribute("listConsultaProceso", "");

        List<Administrador> listConsultaProceso = consultarProcesoService.consultarProcesoList(administradorRequest);

        model.put("listConsultaProceso", listConsultaProceso);
        
        String perfil = (String) request.getSession().getAttribute("coIdentificador");
        System.out.println("perfil Nombre>>>"+perfil);
        model.put("perfil", perfil);
        return new ModelAndView("admin/procesar_listar", model);
    }

    @RequestMapping(value = "/consultaProcesar.htm", method = RequestMethod.POST)
    public ModelAndView consultarBoletas(HttpServletRequest request, HttpServletResponse response) throws Exception {
        model = new HashMap();

        String nuDni = request.getParameter("hddDniEmpleado").trim();
        String aniop = request.getParameter("hddAnio").trim();
        String mesp = request.getParameter("hddMes").trim();
        String flag = "N";

        if (aniop.equals("-1")) {
            aniop = "";
        }
        if (mesp.equals("-1")) {
            mesp = "";
        }

        PersonalRequest personalRequest = new PersonalRequest();
        personalRequest.setNuDni(nuDni.trim());
        personalRequest.setIdAnio(aniop.trim());
        personalRequest.setIdMes(mesp.trim());
        personalRequest.setIdFlag(flag.trim());

        request.getSession().setAttribute("listConsultaBoletas", "");

        List<Personal> listConsultaBoletas = consultarPersonal.consultarPersonalList(personalRequest);
        System.out.println("controller_Carga:" + listConsultaBoletas.size());

        model.put("listConsultaBoletas", listConsultaBoletas);
        
        String perfil = (String) request.getSession().getAttribute("coIdentificador");
        System.out.println("perfil Nombre>>>"+perfil);
        model.put("perfil", perfil);
        
        return new ModelAndView("admin/procesar_consulta_listar", model);
    }
    
    @RequestMapping(value = "/consultaPersonalDetalle.htm", method = RequestMethod.POST)
    public ModelAndView consultarPersonalDetalle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        model = new HashMap();

        String aniop = request.getParameter("hddAnioD").trim();
        String mesp = request.getParameter("hddMesD").trim();
        String idDescargado = request.getParameter("hddDescargado").trim();
        String idGenerado = request.getParameter("hddGenerado").trim();
        String flag = "N";

        if (aniop.equals("-1")) aniop = "";
        if (mesp.equals("-1")) mesp = "";
        
        PersonalRequest personalRequest = new PersonalRequest();
        personalRequest.setNuDni("");
        personalRequest.setIdAnio(aniop.trim());
        personalRequest.setIdMes(mesp.trim());
        personalRequest.setIdFlag(flag.trim());
        personalRequest.setIdDescargado(idDescargado.trim());
        personalRequest.setIdGenerado(idGenerado.trim());

        request.getSession().setAttribute("listConsultaBoletasDetalle", "");

        List<Personal> listConsultaBoletasDetalle = consultarPersonal.consultarPersonalDetalle(personalRequest);
        System.out.println("controller_Carga:" + listConsultaBoletasDetalle.size());

        model.put("listConsultaBoletasDetalle", listConsultaBoletasDetalle);
        
        String perfil = (String) request.getSession().getAttribute("coIdentificador");
        System.out.println("perfil Nombre>>>"+perfil);
        model.put("perfil", perfil);
        
        return new ModelAndView("admin/procesar_listar_detalle", model);
    }
}
