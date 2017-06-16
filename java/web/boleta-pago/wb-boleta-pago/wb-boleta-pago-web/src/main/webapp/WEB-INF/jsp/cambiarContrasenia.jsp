
<div class="modal-content">
    <form id="frmContrasenia" name='frmContrasenia' method='post' action='${pageContext.request.contextPath}/cambiarContrasenia2.htm'>
		<input type="hidden" id="hddContext" name="hddContext" value="${pageContext.request.contextPath}" />    
        <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel"></h4>
            <h4>
                Cambio de Contraseña
                <div class="css3gradient"></div>
            </h4>
        </div>
        <div class="modal-body">
			<div class="panel panel-default">
                <div class="panel-body">
                    <table border="0" cellpadding="0" cellspacing="0" width="100%">       
                        <tr> 
                            <td colspan="5" valign="top">
								<div align="center">
									<font size="2" face="Arial, Helvetica, sans-serif">
										<strong>Ingrese Usuario</strong>
									</font>
								</div>
							</td>
                        </tr>
                        <tr> 
                            <td colspan="5" valign="top">
								<div align="center"> 
                                    <input type="text" name="txtUser" id="txtUser"  maxlength="15" class="form-control input-sm" style="width: 200px" required >
                                    <span class="help-block"></span>
                                </div>
							</td>
                        </tr>                        
                        <tr> 
                            <td colspan="5" valign="top">
								<div align="center">
									<font size="2" face="Arial, Helvetica, sans-serif">
										<strong>Contraseña Actual</strong>
									</font>
								</div>
							</td>
                        </tr>
                        <tr> 
                            <td colspan="5" valign="top">
								<div align="center"> 
                                    <input type="password" name="txtPass" id="txtPass" maxlength="15" class="form-control input-sm" style="width: 200px" required >
									<span class="help-block"></span>
                                </div>
							</td>
                        </tr>

                        <tr> 
                            <td colspan="5" valign="top">
								<div align="center">
									<font size="2" face="Arial, Helvetica, sans-serif">
										<strong> Nueva Clave</strong>
									</font>
								</div>
							</td>
                        </tr>
                        <tr> 
                            <td colspan="5" valign="top">
								<div align="center"> 
                                    <input type="password" name="txtPassNuevo" id="txtPassNuevo" maxlength="15" class="form-control input-sm" style="width: 200px" required>
									<span class="help-block"></span>
                                </div>
							</td>
                        </tr>
                        <tr> 
                            <td height="7" align='center' colspan="7"><label style='color: blue'>${mensaje}</label></td>

                        </tr>
                        <tr> 
                            <td valign="top"> <div align="center"> 
                                    <input type="button" class="btn btn-sm btn-primary btn-block" name="btoAceptar" value="Aceptar" onClick="javascript:cambiarContrasenia();" style="width: 100px" >
                    <!--            <a href="${pageContext.request.contextPath}/cambiarContrasenia2.htm" id="link" >Cambiar</a>-->
                                </div></td>

                            <td>&nbsp;</td>
                            <td valign="top"> <div align="center"> 
                                    <input type="button" class="btn btn-sm btn-primary btn-block" name="btoCancelar" value="Cancelar" onclick="javascript:closePopup();"style="width: 100px" >
                                </div></td>
                            <td>&nbsp;</td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div></div>
    </form>
</div>
                                
<script>

    function cambiarContrasenia() {

            if (document.getElementById("txtUser").value == "") {
                    alert("Ingrese Usuario")
                    return;
            }
            if (document.getElementById("txtPass").value == "") {
                    alert("Ingrese Contraseña")
                    return;
            }
            if (document.getElementById("txtPassNuevo").value == "") {
                    alert("Ingrese Nueva Contraseña")
                    return;
            }
            doSubmitFormXML();
    }

    function closePopup() {
            jQuery.closePopupLayer('myWindowPopup');
    }


    function doSubmitFormXML() {
            var form = document.getElementById("frmContrasenia");
            if (form != null) {
                    var lparams = $(form).serialize();
                    // alert(lparams);
                    $.ajax({
                            url: form.action,
                            type: (form.method) ? form.method : 'POST',
                            data: lparams,
                            dataType: 'xml',
                            success: function(data) {
                                    fu_pasaRespuesta(data);
                            }
                    });
            }

    }

    function fu_pasaRespuesta(response) {
            if (response == null)
                    return false;
            else {
                    var mensaje = response.documentElement.getElementsByTagName("mensaje");
                    if (mensaje.length > 0) {
                            var aValor = new Array(2);
                            aValor[0] = mensaje[0].getAttribute("valor0");
                            aValor[1] = mensaje[0].getAttribute("valor1");
                            // 
                            alert(aValor[1]);

                            if (aValor[0] == "0") {
                                    closePopup();
                            }
                    }
                    return true;
            }
    }
</script>
