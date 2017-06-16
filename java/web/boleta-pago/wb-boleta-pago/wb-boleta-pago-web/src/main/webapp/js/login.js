function initial(){
    cargarCaptcha();
    $("#txtUser").focus();
}

function cargarCaptcha(){
    var root = $("#hddContext").val();
    var imagen = document.getElementById("img-captcha");
    imagen.src = root+'/public/captcha.htm?'+Date();
}

function comprobarImagen() {
    var sDni = $("#txtUsuario").val();
    if (sDni==="" || sDni===null){
        alert("Debe ingresar un usuario valido...");
        $("#txtUser").focus();
        return false;
    }
    var sPass = $("#txtPass").val();
    if (sPass==="" || sPass===null){
        alert("Debe ingresar password...");
        $("#txtPass").focus();
        return false;
    }
    var sCodigo = $("#txtText").val();
    if (sCodigo==="" || sCodigo===null){
        alert("Debe ingresar el texto de la imagen...");
        refrescar();
        $("#txtText").focus();
        return false;
    }
    
    fu_HaceSubmitFormXML();
    
}

function loginPrueba() {
    
    var context = document.getElementById("hddContext").value;
    var sUsser = $("#txtUsuario").val();
    var sPass = $("#txtPass").val();
    
    if (sUsser==="" || sUsser===null){
        alert("Debe ingresar un usuario valido...");
        $("#txtUsuario").focus();
        return false;
    }
    if (sPass==="" || sPass===null){
        alert("Debe ingresar un usuario valido...");
        $("#txtPass").focus();
        return false;
    }
    
    
    document.getElementById("hddUsuario").value = sUsser;
    document.getElementById("hddPass").value = sPass;
    document.getElementById("frmAjaxPrueba").action = context + '/seleccionarEmpleado.htm';
//    doSubmitFormHtml("frmAjaxPrueba", jQuery('#page_content'));
//    doSubmitFormXML();
    document.getElementById("frmAjaxPrueba").submit();
    
}

function  fu_HaceSubmitFormXML(){
    var root = $("#hddContext").val();
    var local_url = root + "/public/comprobarcaptcha.htm";
    
    var sCodigo = $("#txtText").val();
    
    if (sCodigo=="" || sCodigo==null){
        alert("Debe ingresar el texto de la imagen...");
        $("#txtText").focus();
        return false;
    }
    var lparams = "codigo=" + encodeURI(document.getElementById('txtText').value);
    $.ajax({
        url: local_url,
        type: 'POST',
        data: lparams,
        dataType: 'xml',
        success: function(data){
            fu_pasaRespuesta(data);
        }
    });
}
function conMayusculas() {
    document.getElementById("txtText").value=document.getElementById("txtText").value.toUpperCase();
}

function fu_pasaRespuesta(response){
    if(response == null) return false;
    else{
        var mensaje = response.documentElement.getElementsByTagName("mensaje");
        if(mensaje.length>0){
            var aValor = new Array(1);
            aValor[0] = mensaje[0].getAttribute("valor0");
            var respuesta = aValor[0];
            if (respuesta=='NN' || respuesta==null){
                document.getElementById("div-mensaje").innerHTML="<p class='lbl-mensaje'>No se recibio resultado esperado</p>";
            }else{
                if(respuesta=='true'){
                     document.getElementById("frmSesion").submit();
                   // if(opcion_ingreso=="1") inscribir();
                    //if(opcion_ingreso=="2") verificar();
                } else {
//                    $("#div-mensaje").html("<p class='lbl-mensaje'>Caracteres equivocados</p>");
                    alert("Caracteres equivocados");                    
                    cargarCaptcha();
                    document.getElementById("txtText").value="";
                    $("#txtText").focus();
                }
            }
        }
        return true;
    }
}

function seleccioneEncargatura() { 
    //document.getElementById("txtText").value=document.getElementById("txtText").value.toUpperCase();
}

function seleccioneEntidad(coEnc,coPerfil) {
	
	// Llamada ajax para obtener la constante del perfil
	var context = document.getElementById("hddContext").value;
    var local_url = context + "/obtenerIdentificadorPerfil.htm";
	var lparams = "coPerfil=" + coPerfil;
	$.ajax({
        url: local_url,
        type: 'POST',
        data: lparams,
        dataType: 'xml',
        success: function(data) {
            //fu_pasaRespuesta(data);
        	 var mensaje = data.documentElement.getElementsByTagName("mensaje");
             if (mensaje.length > 0) {
                 var aValor = new Array(1);
                 aValor[0] = mensaje[0].getAttribute("valor0");
//                 if (aValor[0] == "IAFAS"){
//                	 document.getElementById("frmAjax").action = context+"/seleccionarEntidad.htm";
//                 } else {
//                	 document.getElementById("frmAjax").action = context+"/acuerdos.htm?action=mostrarPendientes";
//                 }
                 
//                 document.getElementById("frmAjax").action = context+"/action=seleccionarEmpleado.htm";
                 document.getElementById("frmAjax").action = context+"/iniciar.htm?action=obtenerIdentificadorPerfil";
                 
                 document.getElementById("coPerfil").value=coPerfil;
                 document.getElementById("coEnc").value=coEnc;
            	 document.getElementById("frmAjax").submit();
             }
        	
        }
    });
    
}
function seleccionePerfil(coEnc,coUsuario) {
    document.getElementById("coUsuario").value=coUsuario
    document.getElementById("coEnc").value=coEnc    
    document.getElementById("frmAjax").submit();
    
}
function mostrarPendientes(deRazonSocial,coIafas,idPersona,coUsuario) {
       
//    alert(coIafas);
    document.getElementById("deRazon").value=deRazonSocial;
    document.getElementById("coIafas").value=coIafas;
    document.getElementById("idPersona").value=idPersona;
    document.getElementById("coUsuario").value=coUsuario;
    
    document.getElementById("frmAjax").submit();
}




//Metodos de AJAX
//Ajax HTML
function doSubmitFormHtml(formId, obj) {
    var form = document.getElementById(formId);
    if (form != null) {
        var ruta = document.getElementById(formId).action;
        jQuery.post(ruta, jQuery(form).serialize(), function(XML_AJAX) {
            obj.html(XML_AJAX);
            obj.show();
        }, 'HTML');
    }
}

function doSubmitFormXML() {
    var form = document.getElementById("frmAjaxPrueba");
    if (form != null) {
        var lparams = $(form).serialize();
        $.ajax({
            url: form.action,
            type: (form.method) ? form.method : 'POST',
            data: lparams,
            dataType: 'xml',
            success: function(data) {
                fu_pasaRespuesta_2(data);
            }
        });
    }

}

function fu_pasaRespuesta_2(response){
    if(response == null) return false;
    else{
        var mensaje = response.documentElement.getElementsByTagName("mensaje");
        if(mensaje.length>0){
            var aValor = new Array(2);
            aValor[0] = mensaje[0].getAttribute("valor0");
            aValor[1] = mensaje[0].getAttribute("valor1");
            if(aValor[1]=="00") alert(aValor[0]);
        }
        return true;
    }
}
