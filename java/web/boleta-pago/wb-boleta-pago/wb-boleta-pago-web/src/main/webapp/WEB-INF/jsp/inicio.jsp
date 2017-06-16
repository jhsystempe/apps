<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <!--<![endif]-->
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="msapplication-tap-highlight" content="no"/>
        <link rel="icon" type="image/png" href="images/favicon.ico" sizes="16x16"/>
        <title>SUSALUD | Boletas de Pago</title>
        <%@include file="/WEB-INF/jsp/common/inc_taglibs.jsp"%>
        <link rel="stylesheet" href="bower_components/uikit/css/uikit.almost-flat.min.css" media="all"/>
        <link rel="stylesheet" href="assets/icons/flags/flags.min.css" media="all"/>
        <link rel="stylesheet" href="assets/css/main.min.css" media="all"/>
        <link rel="stylesheet" href="assets/css/custom.css" media="all"/>      

        <!--[if lte IE 9]> <script type="text/javascript" src="bower_components/matchMedia/matchMedia.js"></script> <script type="text/javascript" src="bower_components/matchMedia/matchMedia.addListener.js"></script> <![endif]-->
    </head>
    <!-- sidebar_main_open -->
    <body class="sidebar_main_swipe app_theme_a sidebar_main_active">
        <header id="header_main">
            <div class="header_main_content">
                <nav class="uk-navbar"> 
                    <a href="#" id="sidebar_main_toggle" class="sSwitch sSwitch_left"> <span class="sSwitchIcon"></span> </a> 
                    <a href="#" id="sidebar_secondary_toggle" class="sSwitch sSwitch_right sidebar_secondary_check"> <span class="sSwitchIcon"></span> </a>                     
               
                    <div class="uk-navbar-flip">
                    <ul class="uk-navbar-nav user_actions">
                        
                        <li data-uk-dropdown="{mode:'click',pos:'bottom-right'}" aria-haspopup="true" aria-expanded="false">
                            <a href="#" class="user_action_image"><img class="md-user-image" src="assets/img/avatars/user-photo.png" alt=""></a>
                            <div class="uk-dropdown uk-dropdown-small" aria-hidden="true">
                                <ul class="uk-nav js-uk-prevent">
                                    <li><a href="${pageContext.request.contextPath}/seleccionarEncargatura.htm">Cambiar Perfil</a></li>
                                    
                                    <li><a href="${pageContext.request.contextPath}/inicio1.htm">Cerrar Sesion</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
                </nav>
                
            </div>
        </header>
        <aside id="sidebar_main">
            <div class="sidebar_main_header">
                <div class="sidebar_logo"> <a href="${pageContext.request.contextPath}/iniciar.htm" class="sSidebar_hide"><img src="assets/img/logo_main.png" alt="" height="80" width="200"/></a> 
                    <a href="index.html" class="sSidebar_show"><img src="assets/img/logo_main_small.png" alt="" height="32" width="32"/></a> </div>
            </div>
            <div class="menu_section">
                <ul>
                    
                     <c:if test="${perfil=='ADMINISTRADOR'}">  
                        <li> 
                           <a href="#">Men&uacute; Administrador</a>
                           <ul class="">                        
                               <li><a href="${pageContext.request.contextPath}/inicioProceso.htm">Módulo de boletas a procesar</a></li>
   <!--                            <li><a href="${pageContext.request.contextPath}/detalleProceso.htm">Detalle de boletas procesadas</a></li>                            -->
                               <li><a href="${pageContext.request.contextPath}/consultarProceso.htm">Módulo de consulta de boletas</a></li>
                           </ul>
                       </li>
                    </c:if>  
                    
                    <c:if test="${perfil=='PERSONAL'}">  
                        <li> 
                            <a href="#">Men&uacute; Personal</a>
                            <ul class="">                            
                                <li><a href="${pageContext.request.contextPath}/consultarPersonal.htm">Consultar Boletas</a></li>
                            </ul>
                        </li>
                    </c:if>  
                    
                    <c:if test="${perfil=='GERENCIA'}">
                        <li> 
                            <a href="#">Men&uacute; Consulta Gerencia</a>                        
                            <ul class="" >
                                <li><a href="${pageContext.request.contextPath}/consulta.htm">Detalle Proceso</a></li>
                                <li><a href="${pageContext.request.contextPath}/consultaProceso.htm">Consultar Boletas</a></li>                            
                            </ul>
                        </li>                    
                    </c:if>  
                    
                </ul>
            </div>
        </aside>

        <div id="page_content">
            <div id="page_content_inner">
                <div class="uk-grid">
                    <div class="uk-width-1-1">
                        <div class="md-card">
                            <div class="md-card-content">

                                <div class="timeline_content_addon" >
                                            <img src="${pageContext.request.contextPath}/images/administracionplanillas.jpg" alt="" />
                                        </div>
                            </div>
                        </div>
                    </div>
                </div>                
            </div>
        </div>

        <script src="assets/js/common.min.js"></script>
        <script src="assets/js/uikit_custom.min.js"></script>
        <script src="assets/js/altair_admin_common.min.js"></script>
        <script src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
        <!--<script src="bower_components/highcharts/highcharts.js"></script>-->
        <script src="bower_components/datatables-tabletools/js/dataTables.tableTools.js"></script>
        <!--<script src="bower_components/ion.rangeslider/js/ion.rangeSlider.min.js"></script>-->
        <script src="bower_components/jquery.inputmask/dist/jquery.inputmask.bundle.js"></script>
        <script src="assets/js/uikit_htmleditor_custom.min.js"></script>
        <!--<script src="assets/js/custom/datatables_uikit.min.js"></script>-->
        <script src="assets/js/pages/plugins_datatables.min.js"></script>
        <script src="assets/js/text.js"></script>
        <script src="js/funciones.js"></script>

    </body>
</html>