<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@include file="/WEB-INF/jsp/common/inc_taglibs.jsp"%>

<div  id="displayTagDivP" class="uk-overflow-container">

    <c:if test="${!empty listConsultaPersonal}">
        <table width="900"  class="uk-table uk-table-striped uk-text-nowrap">
            <thead>
                <tr>                    
                    <th>CODIGO</th>
                    <th>TIPO DOCUMENTO</th>
                    <th>NUM. DOCUMENTO</th>
                    <th>NOMBRE PERSONAL</th>
                    <th>ESTADO</th>
                    <th>DESCARGAR</th>
                    <th>FECHA DESCARGA</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="listar" items="${listConsultaPersonal}" varStatus="status">
                    <tr>                        
                        <td align="center">${listar.coEmpleado}</td>
                        <td align="center">${listar.tiDocumento}</td>                                                                            
                        <td align="center">${listar.nuDocumento}</td>
                        <td align="center">${listar.noEmpleado}</td>
                        <td align="center">${listar.esDescarga}</td>
                                                
                        <td align="center"><a id="btnDescargar" href="#" onclick="javascript:descargaBoleta('${fn:trim(listar.nuSecuencial)}',' ${fn:trim(listar.rutaArchivo)}')"><img  alt="logo" title="Descargar" width="25px" height="25px" src="images/descargar_pdf.png">  </a> </td>
                                                
                        <c:if test="${empty listar.feDescarga}">                            
                            <td align="center"> </td>
                        </c:if>
                        <c:if test="${!empty listar.feDescarga}">                            
                            <td align="center">${listar.feDescarga}</td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty listConsultaPersonal}">
        <table width="900"  class="uk-table table-bordered uk-table-striped">
            <thead>
                <tr>
                    <th align="center" scope="col">No se encontraron registros.</th>                
                </tr>
            </thead>        
        </table>
    </c:if>
</div> 

