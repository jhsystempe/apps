<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <!--<![endif]-->
    <head>
        <meta charset="UTF-8"/>
    <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <!-- Remove Tap Highlight on Windows Phone IE -->
    <meta name="msapplication-tap-highlight" content="no"/>

    <link rel="icon" type="image/png" href="images/favicon.ico" sizes="16x16"/>
    <!--<link rel="icon" type="image/png" href="assets/img/favicon-32x32.png" sizes="32x32">-->

    <title>SUSALUD | Boletas de Pago</title>
    <%@include file="/WEB-INF/jsp/common/inc_taglibs.jsp"%>
    <link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500' rel='stylesheet' type='text/css'/>

    <!-- uikit -->
    <link rel="stylesheet" href="bower_components/uikit/css/uikit.almost-flat.min.css"/>

    <!-- altair admin login page -->
    <link rel="stylesheet" href="assets/css/login_page.min.css" />
    
    <!-- ReCaptcha Google -->
    <script src='https://www.google.com/recaptcha/api.js'></script>	
    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/login.js"></script>

    

</head>
<body class="login_page">

    <div class="login_page_wrapper">
        <div class="md-card" id="login_card">
            <div class="md-card-content large-padding" id="login_form">
                <div class="login_heading">
                    <div class="user_avatar"></div>
                    <span><img src="images/large-logo.png" width="310" height="100" /></span>
                    <h2 class="panel-title"><strong>BOLETAS DE PAGO</strong> <br />
                        <small>Ingreso al Sitema</small></h2>
                </div>
                
                <!--<form id="frmAjaxPrueba" name="frmAjaxPrueba" method="POST" action="">-->
                <form role="form" name="frmSesion" id="frmSesion" action="${pageContext.request.contextPath}/seleccionarEncargatura.htm" method="POST">
                    <div class="uk-form-row">
                        <label for="login_username">Usuario</label>
                        <input id="txtUsuario" name="txtUsuario" class="md-input" type="text"/>
                        <span class="help-block"></span>
                    </div>
                    <div class="uk-form-row">
                        <label for="login_password">Contrase&nacute;a</label>
                        <input id="txtPass" name="txtPass" class="md-input" type="password"/>
                        <span class="help-block"></span>
                    </div>
                    <div class="uk-form-row">
                        <table width="100%" border="0" cellspacing="0" cellpadding="5">
                            <tr>
                                <td width="60%" align="left" valign="top">
                                    <img src="${pageContext.request.contextPath}/public/captcha.htm" id="img-captcha" alt="Captcha" width="155" height="47" class="img-captcha" />
                                </td> 
                                <td width="40%" align="left" valign="top" id="txt_captcha">
                                    <label for="login_username" style="font-size: 13px">Ingresar C&oacute;digo</label>
                                    <input id="txtText" name="txtText" class="md-input" type="text" onkeyup="conMayusculas();" maxlength="6"/>
                                    <span class="help-block"></span>                                    
                                </td>
                            </tr>
                            <tr>
                                <td height="10" align="left" valign="top" id="txt_captcha" name="txt_captcha">
                                    <strong>
                                        <small><a onclick="javascript:cargarCaptcha();" target="_parent" id="txt_captcha2" style="font-size: 12px;" >Refrescar C&oacute;digo</a>
                                    </strong>
                                </td>
                            </tr>
                        </table>
                        
                    </div>
                        
                    <!-- BOTONES  -->
                    <div class="uk-grid uk-grid-width-1-2 uk-grid-small uk-margin-top">
                        <!--<a href="${pageContext.request.contextPath}/inicioProceso.htm" class="md-btn md-btn-primary md-btn-block md-btn-large">Ingresar</a>-->
                        <!--<a id="idConsultarPocesar" class="md-btn md-btn-primary md-btn-block md-btn-large" onclick="javascript:loginPrueba()">Ingresar</a>-->                        
                        <a href="#" onclick="javascript:comprobarImagen();" class="md-btn md-btn-primary md-btn-block md-btn-large">Ingresar</a>
                    </div>                    
                    <div class="uk-grid uk-grid-width-1-2 uk-grid-small uk-margin-top">
                        <a href="javascript:enviarContrasenia();" class="md-btn md-btn-success md-btn-block md-btn-large">Olvido Contraseña</a>
                    </div>
                    <div class="uk-grid uk-grid-width-1-2 uk-grid-small uk-margin-top">
                        <a href="lectura_documento.htm?hoja=ManualUsuario.pdf" target="_blank"><i class="fa fa-book fa-fw"></i> Manual de Usuario</a>
                    </div>
                                            
                    <div align="center"><label style="color: red"> ${mensajeEmpleado}</label></div>
                    <div align="center"><label style="color: red"> ${mensaje}</label></div>
                    
                    <input type="hidden" id="ruta" name="ruta" value="${pageContext.request.contextPath}" />
                    <input type="hidden" name="hddContext" id="hddContext" value="${pageContext.request.contextPath}"/>                    
                    <input type="hidden" name="hddUsuario" id="hddUsuario" value=""/>
                    <input type="hidden" name="hddPass" id="hddPass" value=""/>
                </form>
            </div>                        
        </div>
        
<!--        <form id="frmAjax" name="frmAjax" method="POST" action="${pageContext.request.contextPath}/enviarContrasenia.htm">    
            <input type="hidden" name="hddContext" id="hddContext" value="${pageContext.request.contextPath}"/>
            <input type="hidden" name="deUsuario" id="deUsuario" value=""/>            
        </form>-->
                
    </div>


    
    <!-- common functions -->
    <script src="assets/js/common.min.js"></script>
    <!-- uikit functions -->
    <script src="assets/js/uikit_custom.min.js"></script>
    <!-- altair core functions -->
    <script src="assets/js/altair_admin_common.min.js"></script>

    <!-- altair login page functions -->
    <script src="assets/js/pages/login.min.js"></script>
    <!--<script src="js/new.js"></script>-->

    <script>
        function enviarContrasenia() {
            if (document.getElementById("txtUsuario").value == "")
            {
                alert("Ingrese Usuario")
                document.getElementById("txtUsuario").focus();
                return;
            }
            document.getElementById("deUsuario").value = document.getElementById("txtUsuario").value;
            document.getElementById("frmAjax").submit();
            }
    </script> 
    
    <script>
        // check for theme
        if (typeof(Storage) !== "undefined") {
            var root = document.getElementsByTagName( 'html' )[0],
                theme = localStorage.getItem("altair_theme");
            if(theme == 'app_theme_dark' || root.classList.contains('app_theme_dark')) {
                root.className += ' app_theme_dark';
            }
        }
    </script>

    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
        ga('create', 'UA-65191727-1', 'auto');
        ga('send', 'pageview');
    </script>
</body>
</html>