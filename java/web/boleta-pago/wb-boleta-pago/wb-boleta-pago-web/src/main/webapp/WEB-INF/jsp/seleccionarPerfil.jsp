<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
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
    <body>
        
        <div id="page_content">
            <div id="page_content_inner">
                <div class="uk-grid">
                    <div class="uk-width-1-1">
                        <div class="md-card">
                            <div class="md-card-content">
                                <form >
                                <table width="70%"  class="uk-table uk-table-striped uk-text-nowrap" align="center">
                                <!--<table width="100%" border="2" align="center" bordercolor="#666666" class="table table-striped table-bordered table-hover">-->
                                    <thead>
                                        <tr bordercolor="#999999">                                       
                                            <th>Nombre del Aplicativo</th>
                                            <th>Codigo de Perfil</th>
                                            <th>Nombre de Perfil</th>
                                            <th>Ingresar</th>

                                        </tr>
                                    </thead>
                                    <c:forEach var="listaPerfiles" items="${listaPerfiles}">
                                        <tr>                                         
                                            <td align="center"><c:out value="${listaPerfiles.noApp}" /></td>
                                            <td align="center"><c:out value="${listaPerfiles.coPerfil}" /></td>
                                            <td align="center"><c:out value="${listaPerfiles.noPerfil}" /></td>

                                            <!--<td><a href="${pageContext.request.contextPath}/seleccionarEmpleado.htm?coEnc=${coEnc}&coPerfil=${listaPerfiles.coPerfil}" id="link" >Seleccionar</a></td>-->
                                            <td align="center"><a href="javascript:seleccioneEntidad(${coEnc},${listaPerfiles.coPerfil})" id="link" >Seleccionar</a></td>
                                            <!--<td align="center"><a href="${pageContext.request.contextPath}/inicioProceso.htm" id="inicioProceso" >Seleccionar</a></td>-->
                                        </tr>
                                    </c:forEach>
                                </table>
                                <a href="javascript:history.back()">Atras</a> 
                            </form> 
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        
<%--        <div class="container latizator">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><label>Sistema de contratos y convenios - CONCON Seleccione Perfil</label></h3>
                        </div>
                        <div class="panel-body">
                            <form >
                                <table width="900"  class="uk-table uk-table-striped uk-text-nowrap" align="center">
                                <table width="100%" border="2" align="center" bordercolor="#666666" class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr bordercolor="#999999">                                       
                                            <th>Nombre del Aplicativo</th>
                                            <th>Codigo de Perfil</th>
                                            <th>Nombre de Perfil</th>
                                            <th>Ingresar</th>

                                        </tr>
                                    </thead>
                                    <c:forEach var="listaPerfiles" items="${listaPerfiles}">
                                        <tr>                                         
                                            <td><c:out value="${listaPerfiles.noApp}" /></td>
                                            <td align="center"><c:out value="${listaPerfiles.coPerfil}" /></td>
                                            <td><c:out value="${listaPerfiles.noPerfil}" /></td>

                                            <td><a href="${pageContext.request.contextPath}/seleccionarEmpleado.htm?coEnc=${coEnc}&coPerfil=${listaPerfiles.coPerfil}" id="link" >Seleccionar</a></td>
                                            <td><a href="javascript:seleccioneEntidad(${coEnc},${listaPerfiles.coPerfil})" id="link" >Seleccionar</a></td>
                                            <td><a href="${pageContext.request.contextPath}/inicioProceso.htm" id="inicioProceso" >Seleccionar</a></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                                <a href="javascript:history.back()">Atras</a> 
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>--%>
        <%--          <form id="frmAjax" name="frmAjax" method="POST" action="${pageContext.request.contextPath}/seleccionarEntidad.htm">  --%>
        <form id="frmAjax" name="frmAjax" method="POST">   
            <input type="hidden" name="hddContext" id="hddContext" value="${pageContext.request.contextPath}"/>
            <input type="hidden" name="coEnc" id="coEnc" value=""/>
            <input type="hidden" name="coPerfil" id="coPerfil" value=""/>
        </form>

        <!-- common functions -->
        <script src="assets/js/common.min.js"></script>
        <!-- uikit functions -->
        <script src="assets/js/uikit_custom.min.js"></script>
        <!-- altair core functions -->
        <script src="assets/js/altair_admin_common.min.js"></script>

        <!-- altair login page functions -->
        <script src="assets/js/pages/login.min.js"></script>
        <!--<script src="js/new.js"></script>-->

    </body>
</html>