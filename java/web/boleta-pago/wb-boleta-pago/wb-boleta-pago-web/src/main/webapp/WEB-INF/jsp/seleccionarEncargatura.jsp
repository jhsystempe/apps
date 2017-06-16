<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <!--<meta content="text/html; charset=utf-8" http-equiv="Content-Type">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

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

        <style>
            @import url(http://fonts.googleapis.com/css?family=Open+Sans:400,600,700);
            @import url(http://fonts.googleapis.com/css?family=Lato:700,400);
            @import url(http://fonts.googleapis.com/css?family=Roboto+Slab:400,700,300,100);
            @import url(http://fonts.googleapis.com/css?family=Pacifico);		
        </style>

    </head>
    <body>
        <div id="page_content">
            <div id="page_content_inner">
                <div class="uk-grid">
                    <div class="uk-width-1-1">
                        <div class="md-card">
                            <div class="md-card-content">
                                <p style="color:red">${mensajeEncar}</p>

                                <!---<table class="table table-striped table-bordered table-hover" id="datable-grilla"> -->
                                <table id="datable-grilla" width="50%"  class="uk-table uk-table-striped uk-text-nowrap" align="center">								
                                    <thead>
                                        <tr>                                                            
                                            <th>Codigo de Encargatura</th>
                                            <th>Cod Area</th>
                                            <th>Cod Usuario</th>
                                            <th>Des Cargo</th>
                                            <th>Des Encargatura</th>
                                            <th>Ingresar</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="lista" items="${lista}">
                                            <tr>                                         
                                                <td align="center"><c:out value="${lista.codi_enc}" /></td>
                                                <td align="center"><c:out value="${lista.codi_are}" /></td>
                                                <td align="center"><c:out value="${lista.codi_usu}" /></td>
                                                <td align="center"><c:out value="${lista.des_car}" /></td>
                                                <td align="center"><c:out value="${lista.des_enc}" /></td>
                                                <!--<td><a href="javascript:enviarEncargatura('${lista.codi_enc}','${lista.codi_are}','${lista.codi_usu}','${lista.des_car}','${lista.des_enc}');" id="link" >Seleccionar</a></td>-->
                                                <td align="center"><a href="${pageContext.request.contextPath}/seleccionarPerfil.htm?coEnc=${lista.codi_enc}&coArea=${lista.codi_are}&coUsuario=${lista.codi_usu}" id="link" >Seleccionar</a></td>
                                                <!--<td><a href="javascript:seleccionarPerfil(${lista.codi_enc},${lista.codi_usu});" id="link" >Seleccionar</a></td>-->
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <a href="javascript:history.back()">Atras</a> 


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <form id="frmAjax" name="frmAjax" method="POST" action="${pageContext.request.contextPath}/seleccionarPerfil.htm">    
            <input type="hidden" name="hddContext" id="hddContext" value="${pageContext.request.contextPath}"/>
            <input type="hidden" name="coEnc" id="coEnc" value=""/>
            <input type="hidden" name="coArea" id="coEnc" coArea=""/> <!--Pruebas -->
            <input type="hidden" name="coUsuario" id="coUsuario" value=""/>
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