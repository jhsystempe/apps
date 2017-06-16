<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <!--<![endif]-->
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="msapplication-tap-highlight" content="no"/>
        <link rel="icon" type="image/png" href="images/favicon.ico" sizes="16x16">
        <title>SUSALUD | Boletas de Pago</title>
        <%@include file="/WEB-INF/jsp/common/inc_taglibs.jsp"%>
        <link rel="stylesheet" href="bower_components/uikit/css/uikit.almost-flat.min.css" media="all">
        <link rel="stylesheet" href="assets/icons/flags/flags.min.css" media="all">
        <link rel="stylesheet" href="assets/css/main.min.css" media="all">
        <link rel="stylesheet" href="assets/css/custom.css" media="all">      

        <!--[if lte IE 9]> <script type="text/javascript" src="bower_components/matchMedia/matchMedia.js"></script> <script type="text/javascript" src="bower_components/matchMedia/matchMedia.addListener.js"></script> <![endif]-->
    </head>
    <!-- sidebar_main_open -->
    <body class="sidebar_main_swipe app_theme_a sidebar_main_active">
        <header id="header_main">
            <div class="header_main_content">
                <nav class="uk-navbar"> <a href="#" id="sidebar_main_toggle" class="sSwitch sSwitch_left"> <span class="sSwitchIcon"></span> </a> <a href="#" id="sidebar_secondary_toggle" class="sSwitch sSwitch_right sidebar_secondary_check"> <span class="sSwitchIcon"></span> </a> </nav>
            </div>
        </header>
        <aside id="sidebar_main">
            <div class="sidebar_main_header">
                <div class="sidebar_logo"> <a href="${pageContext.request.contextPath}/iniciar.htm" class="sSidebar_hide"><img src="assets/img/logo_main.png" alt="" height="80" width="200"/></a> <a href="index.html" class="sSidebar_show"><img src="assets/img/logo_main_small.png" alt="" height="32" width="32"/></a> </div>
            </div>
            <div class="menu_section">
                <ul>
                    <li> 
                        <a href="#">Men&uacute; Administrador</a>
                        <ul class="">
                            <li><a href="${pageContext.request.contextPath}/inicioProceso.htm">Módulo de boletas a procesar</a></li>
                            <!--<li><a href="${pageContext.request.contextPath}/detalleProceso.htm">Detalle de boletas procesadas</a></li>-->                            
                            <li><a href="${pageContext.request.contextPath}/consultarProceso.htm">Módulo de consulta de boletas</a></li>
                        </ul>
                    </li>
                    <li> 
                        <a href="#">Men&uacute; Personal</a>
                        <ul class="">                            
                            <li><a href="${pageContext.request.contextPath}/consultarPersonal.htm">Consultar Boletas</a></li>
                        </ul>
                    </li>
                    <li> 
                        <a href="#">Men&uacute; Consulta Gerencia</a>
                        <ul class="">
                            <li><a href="${pageContext.request.contextPath}/consulta.htm">Detalle Proceso</a></li>
                            <li  class="act_item"><a href="${pageContext.request.contextPath}/consultaProceso.htm">Consultar Boletas</a></li>                            
                        </ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/inicio1.htm">
                        <i class="fa fa-sign-out fa-fw"></i>Cerrar sesi&oacute;n</a>
                    </li>                    
                </ul>
            </div>
        </aside>

        <div id="page_content">
            <div id="page_content_inner">
                <div class="uk-grid">
                    <div class="uk-width-1-1">
                        <div class="md-card">
                            <div class="md-card-content">
                                <ul class="uk-tab" data-uk-tab="{connect:'#tabs_anim1', animation:'scale'}">
                                    <li class="uk-active"><a href="consultar.htm">Consulta Boletas</a></li>
<!--                                    <li><a href="#">Detalle del Proceso</a></li>                                    
                                    <li><a href="#">Consulta Boletas</a></li>                                    -->
                                </ul>                                
                                <ul id="tabs_anim1" class="uk-switcher uk-margin">
                                    <li>
                                        <br />
                                        <div class="uk-grid" data-uk-grid-margin>
                                            <div class="uk-width-medium-1-5 uk-width-medium-1-1">
                                                <div class="uk-grid">
                                                    <div class="uk-width-small-11-1 uk-width-medium-1-1">
                                                        <div class="uk-input-group"> <span class="uk-input-group-addon">
                                                                <i class="uk-input-group-icon inline-list"></i></span> <label >Estado</label>
                                                            <select id="estado" data-md-selectize>
                                                                <option value="-1">---Escoger--</option>
                                                                <option value="0">Generado</option>
                                                                <option value="1">Descargado</option>                                                                
                                                            </select>
                                                        </div>                                                       
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="uk-width-medium-1-5 uk-width-medium-1-1">
                                                <div class="uk-grid">
                                                    <div class="uk-width-small-11-1 uk-width-medium-1-1">
                                                        <div class="uk-input-group"> <span class="uk-input-group-addon">
                                                                <i class="uk-input-group-icon uk-icon-calendar"></i></span> <label >Año</label>
                                                            <select id="estado" data-md-selectize>
                                                                <option value="-1">---Escoger--</option>
                                                                <option value="1">2016</option>
                                                                <option value="2">2015</option>
                                                                <option value="3">2014</option>
                                                                <option value="4">2013</option>
                                                            </select>
                                                        </div>                                                       
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="uk-width-large-1-5 uk-width-medium-1-1">
                                                <div class="uk-grid">
                                                    <div class="uk-width-small-11-1 uk-width-medium-1-1">
                                                        <div class="uk-input-group"> <span class="uk-input-group-addon">
                                                                <i class="uk-input-group-icon uk-icon-calendar"></i></span> <label >Mes</label>
                                                            <select id="estado" data-md-selectize>
                                                                <option value="-1">---Escoger--</option>
                                                                <option value="01">Enero</option>
                                                                <option value="02">Febrero</option>
                                                                <option value="03">Marzo</option>
                                                                <option value="04">Abril</option>
                                                                <option value="05">Mayo</option>
                                                                <option value="06">Junio</option>
                                                                <option value="07">Julio</option>
                                                                <option value="08">Agosto</option>
                                                                <option value="09">Setiembre</option>
                                                                <option value="10">Octubre</option>
                                                                <option value="11">Noviembre</option>
                                                                <option value="12">Diciembre</option>
                                                            </select>
                                                        </div>                                                       
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="uk-width-large-1-5 uk-width-medium-1-1">
                                                <div class="uk-grid">
                                                    <div class="uk-width-small-11-1 uk-width-medium-1-1">
                                                        <div class="uk-input-group">                                                    
                                                            <a class="md-btn md-btn-success md-btn-wave-light waves-effect waves-button waves-light" href="#" >Buscar</a>
                                                            <a class="md-btn md-btn-primary md-btn-wave-light waves-effect waves-button waves-light" href="#">Procesar</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                      
                                        <br />
                                        <div class="uk-width-large-1- uk-width-medium-1-1">
                                            <h3>CABECERA DE BOLETAS</h3>
                                            <div class="md-card-content">
                                                <div class="uk-overflow-container">
                                                    <table width="900"  class="uk-table uk-table-striped uk-text-nowrap">
                                                        <thead>
                                                            <tr>                                                                
                                                                <th>A&nacute;o</th>
                                                                <th>Mes</th>
                                                                <th>Tipo de Planilla</th>
                                                                <th>SubtipoPlanilla</th>
                                                                <th>N&ordm; Empleados</th>
                                                                <th>Procesados</th>
                                                                
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>                                                                
                                                                <td align="center">2016</td>
                                                                <td align="center">09</td>
                                                                <td align="center">PERMANENTE PLAZO INDETERMINADO</td>
                                                                <td align="center">Adicional</td>
                                                                <td align="center">10</td>
                                                                <td align="center">10</td>
                                                                
                                                            </tr>
                                                            <tr>                                                                
                                                                <td align="center">2016</td>
                                                                <td align="center">09</td>
                                                                <td align="center">CAS</td>
                                                                <td align="center">Normal</td>
                                                                <td align="center">299</td>
                                                                <td align="center">200</td>                                                                
                                                            </tr>
                                                        </tbody>
                                                    </table>                                        
                                                </div> 

                                            </div>
                                        </div>
                                        <br />
                                        <div class="uk-width-large-1- uk-width-medium-1-1">
                                            <h3>CONTROL DE BOLETAS X EMPLEADO</h3>
                                            <div class="md-card-content">
                                                <div class="uk-overflow-container">
                                                    <table width="900"  class="uk-table uk-table-striped uk-text-nowrap">
                                                        <thead>
                                                            <tr>             
                                                                <th>Codigo Empleado</th>
                                                                <th>Tipo Documento</th>
                                                                <th>Num Documento</th>
                                                                <th>Estado</th>
                                                                <th>Usuario</th>
                                                                <th>Fecha</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>                                                                
                                                                <td align="center">00000064</td>
                                                                <td align="center">DNI</td>
                                                                <td align="center">66006585</td>
                                                                <td align="center">GENERADO</td>
                                                                <td align="center">Jose Lujan</td>
                                                                <td align="center">08/11/2016</td>
                                                            </tr>
                                                            <tr>                                                                
                                                                <td align="center">00000080</td>
                                                                <td align="center">DNI</td>
                                                                <td align="center">66006585</td>
                                                                <td align="center">DESCARGADO</td>
                                                                <td align="center">Thalia Chavez</td>
                                                                <td align="center">08/11/2016</td>
                                                            </tr>
                                                            <tr>                                                                
                                                                <td align="center">00000065</td>
                                                                <td align="center">DNI</td>
                                                                <td align="center">66006585</td>
                                                                <td align="center">DESCARGADO</td>
                                                                <td align="center">Kathya</td>
                                                                <td align="center">08/11/2016</td>
                                                            </tr>

                                                        </tbody>
                                                    </table>                                        
                                                </div> 

                                            </div>
                                        </div>

                                    </li>
                                </ul>


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