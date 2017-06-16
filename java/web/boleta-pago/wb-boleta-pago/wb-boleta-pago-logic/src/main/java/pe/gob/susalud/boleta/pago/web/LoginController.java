package pe.gob.susalud.boleta.pago.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.susalud.boleta.pago.entity.EmpleadoRequest;
import pe.gob.susalud.clientseguridadsunasa.WsLogin;
import pe.gob.susalud.boleta.pago.entity.PerfilRequest;
import pe.gob.susalud.boleta.pago.model.Empleado;
import pe.gob.susalud.boleta.pago.model.Funcion;
import pe.gob.susalud.boleta.pago.model.Perfil;
import pe.gob.susalud.boleta.pago.service.EmpleadoService;
import pe.gob.susalud.boleta.pago.service.PerfilService;
import pe.gob.susalud.model.OpcionesxPerfil;
import pe.gob.susalud.model.Perfiles;
import pe.gob.susalud.model.Table;
import pe.org.jhsystem.util.manager.ajax.ManagerAjax;

/**
 *
 * @author lleandro
 */
@Controller
public class LoginController {

    private static final Logger log = LogManager.getLogger(LoginController.class);
    @Autowired
    @Qualifier("perfilService")
    private PerfilService PerfilService;
        
    Map model = null;
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
    @Value("${fromCorreo}")
    private String fromCorreo;
    @Value("${pathManualUsuario}")
    private String pathManualUsuario;

    @RequestMapping("/ingresar.htm")
    public ModelAndView ingresar(HttpServletRequest req, HttpServletResponse res) throws Exception {

        return new ModelAndView("login", model);
    }
    
    @RequestMapping("/cambiarContrasenia.htm")
    public ModelAndView cambiarContrasenia(HttpServletRequest req, HttpServletResponse res) throws Exception {

        //loginUsuario.ModificaPwd_Externo(usuario, pass, passnuevo, wsUrl);

        return new ModelAndView("cambiarContrasenia");
    }

    @RequestMapping("/enviarContrasenia.htm")
    public ModelAndView enviarContrasenia(HttpServletRequest req, HttpServletResponse res) throws Exception {
        WsLogin loginUsuario = new WsLogin();
        String user = "";
        user = req.getParameter("deUsuario");
//        System.out.println(user);
        PerfilRequest usuario = new PerfilRequest();
        usuario.setDeUsuario(user);
        usuario = PerfilService.selectUsuario(usuario);
        log.info("enviarContrasenia==" + usuario.getCoUsuario());

        model = new HashMap();
        String mensaje1 = "";
        if (usuario == null) {
            log.info("EnviarContrasenia Usuario no registrado==" + usuario);
            mensaje1 = "Usuario no Registrado.";
            model.put("mensaje", mensaje1);
            return new ModelAndView("login", model);
        }
        String coUsuario = "", deUsuario = "";
        coUsuario = usuario.getCoUsuario();
        deUsuario = usuario.getDeUsuario();
        String resultado = "";
//        resultado = loginUsuario.EnviarCorreoIngPwdWithURL(wsUsuario, wsPass,deUsuario, coUsuario, "http://" + req.getRemoteHost() + ":" + req.getServerPort() + req.getContextPath() + "/recibirGUID.htm", fromCorreo, wsUrl);
        resultado = loginUsuario.EnviarCorreoIngPwdWithURL(wsUsuario, wsPass, deUsuario, coUsuario, "http://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/recibirGUID.htm", fromCorreo, wsUrl);

        model = new HashMap();
        String mensaje = "";
        if (resultado.equals("1")) {
            mensaje = "Se envió correctamente verificar su correo";
            model.put("mensaje", mensaje);
            return new ModelAndView("login", model);
        } else {
            mensaje = "No se Envió el correo";
            model.put("mensaje", mensaje);
            return new ModelAndView("login", model);
        }
    }

    @RequestMapping("/recibirGUID.htm")
    public ModelAndView recibirGUID(HttpServletRequest req, HttpServletResponse res) throws Exception {

        return new ModelAndView("recibirGUID", model);
    }

    @RequestMapping(value = "/confirmarContrasenia.htm", method = RequestMethod.GET)
    public ModelAndView confirmarContraseniaget(HttpServletRequest req, HttpServletResponse res) throws Exception {

        return new ModelAndView("login");
    }

    @RequestMapping("/confirmarContrasenia.htm")
    public ModelAndView confirmarContrasenia(HttpServletRequest req, HttpServletResponse res) throws Exception {
        WsLogin loginUsuario = new WsLogin();
        String GUID = "", nuevoPass = "";
        String url = req.getParameter("hddurl");
        int posicion;
        posicion = url.indexOf("=");
        GUID = url.substring(posicion + 1);

//        System.out.println("guid es==" + GUID);
        nuevoPass = req.getParameter("txtPass");
        String resultado = "";
        resultado = loginUsuario.ModificarContraseniaByGUID(wsUsuario, wsPass, GUID, nuevoPass, wsUrl);
        model = new HashMap();
        String mensaje = "";

        if (resultado.equals("1")) {
            mensaje = "Se Actualizo correctamente su contraseña";
            model.put("mensaje", mensaje);
            return new ModelAndView("login", model);
        } else {
            mensaje = "No se Actualizó su contraseña";
            model.put("mensaje", mensaje);
            return new ModelAndView("login", model);
        }
    }

    @RequestMapping("/cambiarContrasenia2.htm")
    public void cambiarContrasenia2(HttpServletRequest req, HttpServletResponse res) throws Exception {
        model = new HashMap();
        String usuario, pass, passnuevo;
        usuario = req.getParameter("txtUser");
        pass = req.getParameter("txtPass");
        passnuevo = req.getParameter("txtPassNuevo");
//        System.out.println(usuario);
//        System.out.println(pass);
//        System.out.println(passnuevo);
        WsLogin loginUsuario = new WsLogin();
        int resultado;

        resultado = loginUsuario.ModificaPwd_Externo(wsUsuario, wsPass, usuario, pass, passnuevo, wsUrl);
//        if(resultado == 1){
//           String mensaje = "se cambio correctamente" ;  
//           model.put("mensaje", mensaje);
//             return new ModelAndView("cambiarContrasenia",model); 
//        
//        }else{
//            String mensaje = "no se cambio correctamente" ;             
//             model.put("mensaje", mensaje);
//             return new ModelAndView("cambiarContrasenia",model);           
//        }        
        Map ajaxMap = new HashMap();
        if (resultado == 1) {
            ajaxMap.put("respuesta", "0");
            ajaxMap.put("alerta", "Se Cambio correctamente");
            ManagerAjax.sendResult(res, (String) ajaxMap.get("respuesta"), (String) ajaxMap.get("alerta"));
        } else {

            ajaxMap.put("respuesta", "1");
            ajaxMap.put("alerta", "No se cambio correctamente");
            ManagerAjax.sendResult(res, (String) ajaxMap.get("respuesta"), (String) ajaxMap.get("alerta"));
        }
    }

    @RequestMapping("/obtenerIdentificadorPerfil.htm")
    public void obtenerIdentificadorPerfil(HttpServletRequest req, HttpServletResponse res) throws Exception {
        model = new HashMap();
//        String coPerfil = ""; 
        String coIdentificador = "";
        
        String coPerfil = req.getParameter("coPerfil").trim();
        System.out.println("coPerfil=="+coPerfil);

        PerfilRequest perfil = new PerfilRequest();
        perfil.setCoPerfil(coPerfil);
//        perfil.setCoSistema(coSis);

        
        List<Perfil> listPerfil = PerfilService.selectPerfil(perfil);
        System.out.println("controller_Carga:" + listPerfil.size());
        
         coIdentificador = listPerfil.get(0).getCoIdentificador().trim();
//        identificadorPerfil = perfil.getCoIdentificador();
//
        req.getSession().setAttribute("coIdentificador", coIdentificador);
        //System.out.println("perfil.getCoIdentificador()===="+perfil.getCoIdentificador());
        System.out.println("noPerfil===="+coIdentificador);
        //        req.getSession().setAttribute("deRazon", perfil.getCoIdentificador());

        Map ajaxMap = new HashMap();
        ajaxMap.put("respuesta", coIdentificador);
        ManagerAjax.sendResult(res, (String) ajaxMap.get("respuesta"));

    }

    @RequestMapping("/seleccionarEncargatura.htm")
    public ModelAndView seleccionarEncargatura(HttpServletRequest req, HttpServletResponse res) throws Exception {
        model = new HashMap();
        String usuario = "", pass = "";
        String mensaje = "";
        String coEnc = "";
        String coUsuario = "";
        String coArea = "";

        usuario = req.getParameter("txtUsuario");
        pass = req.getParameter("txtPass");
        WsLogin loginUsuarios = new WsLogin();
        if (usuario == null) {
            usuario = (String) req.getSession().getAttribute("usuario");
            pass = (String) req.getSession().getAttribute("pass");
            if (usuario == null) {
                mensaje = "";
                model.put("mensaje", mensaje);
                return new ModelAndView("login", model);
            }
        }
        List<Table> lista = loginUsuarios.loginUsuarioing(wsUsuario, wsPass, usuario, pass, wsUrl);
        req.getSession().setAttribute("usuario", usuario);
        req.getSession().setAttribute("pass", pass);
        // req.getSession().setAttribute("coArea", coArea);

        if (lista.size() == 0) {
            HttpSession session;
            session = req.getSession(true);
            session.removeAttribute("usuario");
            session.removeAttribute("pass");

            mensaje = "Credenciales Incorrectas";
            model.put("mensaje", mensaje);
            return new ModelAndView("login", model);
        } else {
                     
            if (lista.size() == 1) {
                coEnc = lista.get(0).getCodi_enc();
                coUsuario = lista.get(0).getCodi_usu();
                coArea = lista.get(0).getCodi_are();
                req.getSession().setAttribute("coEnc", coEnc);
                req.getSession().setAttribute("coUsuario", coUsuario);
                req.getSession().setAttribute("coArea", coArea);
                return new ModelAndView("redirect:seleccionarPerfil.htm");
//se agrego jllamas
            }
            if (lista.size() >= 2) {
                model.put("lista", lista);
                return new ModelAndView("seleccionarEncargatura", model);
            } else {
                model.put("lista", lista);
                return new ModelAndView("seleccionarEncargatura", model);
            }

        }
    }
    
    @RequestMapping("/seleccionarPerfil.htm")
    public ModelAndView seleccionarPerfil(HttpServletRequest req, HttpServletResponse res) throws Exception {

        
        String coEnc = req.getParameter("coEnc");
        String coUsuario = req.getParameter("coUsuario");
        //se agrego jllamas
        String coArea = req.getParameter("coArea");

        if (coEnc == null) {
            coEnc = (String) req.getSession().getAttribute("coEnc");
        }
        if (coUsuario == null) {
            coUsuario = (String) req.getSession().getAttribute("coUsuario");
        }
        if (coArea == null) {
            coArea = (String) req.getSession().getAttribute("coArea");
        }


        WsLogin loginUsuario = new WsLogin();
        String usuario, pass;
        usuario = (String) req.getSession().getAttribute("usuario");
        pass = (String) req.getSession().getAttribute("pass");
        if (usuario == null) {
            return new ModelAndView("login");

        } else {
            //List<Perfiles> listaPerfiles = loginUsuario.ObtenerPerfiles(wsUsuario, wsPass, coUsuario,Integer.parseInt(coEnc),Integer.parseInt(coSis), Integer.parseInt(coApl), wsUrl);

            List<Perfiles> listaPerfiles = loginUsuario.ListadoPerfiles_con_encargatura(wsUsuario, wsPass, coUsuario,
                    Integer.parseInt(coEnc),
                    Integer.parseInt(coSis),
                    Integer.parseInt(coApl),
                    coArea,
                    wsUrl);

            model.put("listaPerfiles", listaPerfiles);
            if (listaPerfiles.size() == 0) {
                model.put("mensajeEncar", "Esta Encargatura no tiene Acceso.");
                return new ModelAndView("seleccionarEncargatura", model);
            }
            model.put("coEnc", coEnc);
            req.getSession().setAttribute("coUsuario", coUsuario);
            return new ModelAndView("seleccionarPerfil", model);
        }
    }

//    @RequestMapping("/seleccionarEntidad.htm")
//    public ModelAndView seleccionarEntidad(HttpServletRequest req, HttpServletResponse res) throws Exception {
//
//        WsLogin loginUsuario = new WsLogin();
//        String usuario, coPerfil, pass;
//        String coUsuario = "";
//        List<PerfilRequest> listaIafas = new ArrayList();
//        PerfilRequest iafas = new PerfilRequest();
//        usuario = (String) req.getSession().getAttribute("usuario");
//        pass = (String) req.getSession().getAttribute("pass");
//        coUsuario = (String) req.getSession().getAttribute("coUsuario");
//
//
//        coPerfil = req.getParameter("coPerfil");
//
//        if (coPerfil == null) {
//            coPerfil = (String) req.getSession().getAttribute("coPerfil");
//        }
//
//        req.getSession().setAttribute("coPerfil", coPerfil);
//
//        if ((usuario == null) || (coPerfil == null)) {
//            return new ModelAndView("login");
//        } else {
//            List<OpcionesxPerfil> listaOpciones = loginUsuario.ObtenerOpcionesxPerfil(wsUsuario, wsPass, usuario, pass, wsUrl, coSis, coApl, coPerfil);
//            req.getSession().setAttribute("coPerfil", coPerfil);
//            PerfilRequest perfil = new PerfilRequest();
//            perfil.setCoPerfil(coPerfil);
//            perfil.setCoSistema(coSis);
//            iafas.setCoUsuario(coUsuario);
//            iafas.setCoPerfil(coPerfil);
////            perfil = PerfilService.selectPerfil(perfil);
//
//            //iafas.setIdPersona(coUsuario);
////            listaIafas = PerfilService.selectIafas(iafas);
//
//            model.put("perfil", perfil.getCoIdentificador());
//            System.out.println("perfil.getCoIdentificador()>>>"+perfil.getCoIdentificador());
//            model.put("listaOpciones", listaOpciones);
//            model.put("listaIafas", listaIafas);
//            req.getSession().setAttribute("perfil", perfil.getCoIdentificador());
//            return new ModelAndView("seleccionarEntidad", model);
//        }
//    }

    @RequestMapping("/inicio1.htm")
    public ModelAndView cerrar(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session;
        session = req.getSession(true);
        session.removeAttribute("usuario");
        session.removeAttribute("pass");

        session.removeAttribute("perfil");
        session.removeAttribute("coPerfil");
        session.removeAttribute("coUsuario");
        session.removeAttribute("coEnc");
        session.removeAttribute("deRazon");

        return new ModelAndView("login");
    }    
    
     @RequestMapping(value = "/lectura_documento.htm", method = RequestMethod.GET)
    public void lectura_documento_public(HttpServletRequest request, HttpServletResponse response) throws IOException {
        getDocumento(request, response);
    }

    public void getDocumento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //String archivoTipo = "application/excel";
        //String archivoName = request.getParameter("hoja");
        //String ruta = "";

        String filename = request.getParameter("hoja");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);
        OutputStream out = response.getOutputStream();

        String resName = pathManualUsuario + filename;
        log.info("Ruta del Manual==" + resName);

        java.io.File file = new java.io.File(resName);
        java.io.FileInputStream in = new java.io.FileInputStream(file);
        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        in.close();
        out.close();
    }
}