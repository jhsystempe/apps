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

        <title>SUSALUD | LOGIN</title>
        <%@include file="/WEB-INF/jsp/common/inc_taglibs.jsp"%>
        <link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500' rel='stylesheet' type='text/css'/>

        <!-- uikit -->
        <link rel="stylesheet" href="bower_components/uikit/css/uikit.almost-flat.min.css"/>

        <!-- altair admin login page -->
        <link rel="stylesheet" href="assets/css/login_page.min.css" />

        <!-- ReCaptcha Google -->
        <script src='https://www.google.com/recaptcha/api.js'></script>	
        <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/login.js"></script>

        <script>
            function updateTarget()
            {
                if ($("#destino").val() == "iafas")
                {
                    $("#link").attr("href", "templateIAFAS.html");
                    //alert($("#link").attr("href"));
                }
                else
                {
                    $("#link").attr("href", "templateIPRESS.html");
                    //alert($("#link").attr("href"));
                }
            }
        </script>
    </head>
    <body>

        <div class="container latizator">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><label>Sistema de contratos y convenios - CONCON</label></h3>
                        </div>
                        <div class="panel-body">
                            <form role="form">

                                <fieldset>
                                    <div class="form-group">
                                        <p>Seleccionar Entidad</p>                                        
                                    </div>
                                    <div class="form-group">
                                        <label>TIPO DE ENTIDAD: IAFAS</label>                                        
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="table-responsive">
                                                <table class="table table-striped table-bordered table-hover" id="datable-grilla">
                                                    <thead>
                                                        <tr>                                                            
                                                            <th>C&oacute;digo</th>
                                                            <th>RUC</th>
                                                            <th>Raz&oacute;n social</th>
                                                            <th>Ingreso</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                        <c:forEach var="lista" items="${listaIafas}">
                                                            <tr>                                         
                                                                <td><c:out value="${lista.coIafas}" /></td>
                                                                <td><c:out value="${lista.deRuc}" /></td>
                                                                <td><c:out value="${lista.deRazonSocial}" /></td>                                            
                    <!--                                            <td><a href="${pageContext.request.contextPath}/acuerdos.htm?action=mostrarPendientes&deRazon=${lista.deRazonSocial}&coIafas=${lista.coIafas}" id="link" >Seleccionar</a></td>-->
                                                                <td><a href="javascript:mostrarPendientes('${lista.deRazonSocial}','${lista.coIafas}','${lista.idPersona}','${lista.coUsuario}')" id="link" >Seleccionar</a></td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                                <a href="javascript:history.back()">Atras</a> 
                                            </div>
                                        </div>
                                    </div>                                   
<!--                                    <a href="${pageContext.request.contextPath}/acuerdos.htm?action=mostrarPendientes" id="link" class="btn btn-md btn-primary btn-block"><i class="fa fa-check-square-o"></i>&nbsp;&nbsp;Seleccionar</a>-->
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <form id="frmAjax" name="frmAjax" method="POST" action="${pageContext.request.contextPath}/acuerdos.htm?action=mostrarPendientes">    
            <input type="hidden" name="hddContext" id="hddContext" value="${pageContext.request.contextPath}"/>
            <input type="hidden" name="deRazon" id="deRazon" value=""/>
            <input type="hidden" name="coIafas" id="coIafas" value=""/>
            <input type="hidden" name="idPersona" id="idPersona" value=""/>
            <input type="hidden" name="coUsuario" id="coUsuario" value=""/>
        </form>

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="js/plugins/metisMenu/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="js/sb-admin-2.js"></script>

    </body>

</html>