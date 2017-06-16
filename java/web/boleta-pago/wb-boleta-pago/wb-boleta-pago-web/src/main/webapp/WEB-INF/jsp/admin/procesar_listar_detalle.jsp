<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@include file="/WEB-INF/jsp/common/inc_taglibs.jsp"%>


<div  id="divDetalleBoleta" class="uk-overflow-container">

    <c:if test="${!empty listConsultaBoletasDetalle}">
        <table width="900"  class="uk-table uk-table-striped uk-text-nowrap">
            <thead>
                <tr>                    
                    <th>CODIGO</th>
                    <th>TIPO</th>
                    <th>DOCUMENTO</th>
                    <th>EMPLEADO</th>
                    <th>DESCARGA</th>                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="listar" items="${listConsultaBoletasDetalle}" varStatus="status">
                    <tr>
                        <td align="center">${listar.coEmpleado}</td>
                        <td align="center">${listar.tiDocumento}</td>                                                                            
                        <td align="center">${listar.nuDocumento}</td>
                        <td align="center">${listar.noEmpleado}</td>
                        <td align="center">${listar.esDescarga}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty listConsultaBoletasDetalle}">
        <table width="900"  class="uk-table table-bordered uk-table-striped">
            <thead>
                <tr>
                    <th align="center" scope="col">No se encontraron registros.</th>
                </tr>
            </thead>
        </table>
    </c:if>
</div>

