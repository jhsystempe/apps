function consultarProcesar() {
    var context = document.getElementById("hddContext").value;
    var idAnio = $("#idAnio").val();
    var idMes = $("#idMes").val();
//    var idFlag = "N";
        
//    if (idAnio === "-1") {
//        alert("Seleccione el Año");
//        $("#idAnio").focus();
//        return false;
//    }
//    if (idMes === "-1") {
//        alert("Seleccione el Mes");
//        $("#idMes").focus();        
//        return false;
//    }    
    document.getElementById("hddAnio").value = idAnio;
    document.getElementById("hddMes").value = idMes;
//    document.getElementById("hddFlag").value = idFlag;
    document.getElementById("frmAjax").action = context + '/procesar.htm';
    doSubmitFormHtml("frmAjax", jQuery('#divResultado'));
}

function seleccioneProceso(tiPlanilla,suTiPlanilla,deAnio,dePeriodo) {           
//    alert("tiPlanilla="+tiPlanilla+"-suTiPlanilla-"+suTiPlanilla +"-deAnio-"+deAnio+"*-dePeriodo*-"+dePeriodo);
    var context = document.getElementById("hddContext").value;    
    var tiPlan = tiPlanilla;
    var suTiPlan = suTiPlanilla;
    var idAnioP = deAnio;
    var idMesP = dePeriodo;

    document.getElementById("hddTiPlan").value = tiPlan;
    document.getElementById("hddSuTiPlan").value = suTiPlan;
    document.getElementById("hddAnioP").value = idAnioP;
    document.getElementById("hddMesP").value = idMesP;    
    document.getElementById("frmAjaxProcesar").action = context + '/generarBoleta.htm';
    doSubmitFormHtml("frmAjaxProcesar", jQuery('#divMensaje'));
    $("#divListarG").slideDown();
}

function seleccioneDetalle(deAnio,dePeriodo) {           
    var context = document.getElementById("hddContext").value;        
    var idAnioP = deAnio;
    var idMesP = dePeriodo;
    
    document.getElementById("hddAnioD").value = idAnioP;
    document.getElementById("hddMesD").value = idMesP;    
    document.getElementById("hddDescargado").value = "0";
    document.getElementById("hddGenerado").value = "0";
    
    document.getElementById("frmAjaxDetalleBoleta").action = context + '/consultaPersonalDetalle.htm';
    doSubmitFormHtml("frmAjaxDetalleBoleta", jQuery('#divDetalleBoleta'));
}

function consultaProceso() {
    var context = document.getElementById("hddContext").value;
    var dniEmpl = $("#dniEmpleado").val();
    var idAnio = $("#idAnio").val();
    var idMes = $("#idMes").val();
   
    document.getElementById("hddDniEmpleado").value = dniEmpl;
    document.getElementById("hddAnio").value = idAnio;
    document.getElementById("hddMes").value = idMes;    
    document.getElementById("frmAjax").action = context + '/consultaProcesar.htm';
    doSubmitFormHtml("frmAjax", jQuery('#divResultadoB'));
}

function consultarPersonal() {
    var context = document.getElementById("hddContext").value;
//    var dniEmpl = $("#dniEmpl").val();
    var idAnio = $("#idAnio").val();
    var idMes = $("#idMes").val();
//    var idFlag = "N";
        
//    if (dniEmpl === "") {
//        alert("Ingresar número de DNI");
//        $("#codiEmpl").focus();
//        return false;
//    }
    
//    document.getElementById("hddNuDni").value = dniEmpl;
    document.getElementById("hddAnio").value = idAnio;
    document.getElementById("hddMes").value = idMes;
    document.getElementById("frmAjaxP").action = context + '/personalListar.htm';
    doSubmitFormHtml("frmAjaxP", jQuery('#divResultadoP'));
}

function limpiarConsulta(){
    document.getElementById("dniEmpl").value = "";
    document.getElementById("idAnio").value = "-1";
    document.getElementById("idMes").value = "-1";    
}

function descargaBoleta(nuSecuencial,rutaArchivo) {
    //alert("nuSecuencial="+nuSecuencial+"  rutaArchivo=="+rutaArchivo);
    window.location.href = 'descargarBoleta.htm?nuSecuencial=' + nuSecuencial + '&rutaArchivo=' + rutaArchivo;
}

//function fu_obtener(){
//    var registro = new Object();
//    registro.dePeticion = "Jose";
//    var urlContexto = "server/boletaDePago/demo";
//    $.ajax({
//        dataType: "json",
//        type: "POST",
//        url: urlContexto,
//        data: JSON.stringify(registro),
//        contentType: "application/json; charset=utf-8",
//        error: callback_error,
//        success: recuperar_callback
//    });
//}

function callback_error(HttpServletRequest, textStatus, errorThrown){
    // en ambientes serios esto debe manejarse con mucho cuidado, aquí optamos por una solución simple
    alert(errorThrown);
}

// recuperamos la informacion que nos ha enviado el servidor
function procesarRespuesta(ajaxResponse){ 
    // observa que aquí asumimos que el resultado es un objeto serializado en JSON, razón por la cual tomamos este dato
    // y lo procesamos para recuperar un objeto que podamos manejar fácilmente
    if (typeof ajaxResponse ==="string") ajaxResponse = $.parseJSON(ajaxResponse);
    return ajaxResponse;
}

// recupera la informacion 
function recuperar_callback(ajaxResponse, textStatus){
    var datos = procesarRespuesta(ajaxResponse);
    if (!datos)return;
    var dato;
    var item = "";
    var items = new Array();
    
    var error = datos.coError;
    var nombre = datos.noUsuario;
    //alert("Nombre:"+nombre);
    
    if(error!=="0000"){
        alert("No se puede mostrar la informacion");
        return false;
    }
    
    for (var idx in datos.detalles){
        dato = datos.detalles[idx];
        $("#txt_mssql").val(dato.mssql);
        //$("#txt_mysql").val(dato.mysql);
        //$("#txt_oracle").val(dato.oracle);
    }
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

function doSubmitFormXML(formulario) {
    var form = document.getElementById(formulario);
    if (form != null) {
        var lparams = $(form).serialize();
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