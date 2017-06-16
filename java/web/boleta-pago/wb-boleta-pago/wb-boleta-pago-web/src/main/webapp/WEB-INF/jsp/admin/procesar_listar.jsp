<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@include file="/WEB-INF/jsp/common/inc_taglibs.jsp"%>


<div  id="displayTagDiv" class="uk-overflow-container">

    <c:if test="${!empty listConsultaProceso}">
        <table width="900"  class="uk-table uk-table-striped uk-text-nowrap">
            <thead>
                <tr>                    
                    <th>A&Ntilde;O</th>
                    <th>MES</th>
                    <th>TIPO DE PLANILLA</th>
                    <th>SUBTIPO DE PLANILLA</th>
                    <th>TOTAL</th>                    
                    <th>PROCESADOS</th>
                    <th>SIN PROCESAR</th>                    
                    <th>DESCARGADOS</th>
                    <th>SIN DESCARGAR</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="listar" items="${listConsultaProceso}" varStatus="status">
                    <tr>
                        <!--<td align="center"><input name="ch" type="checkbox" value="checked" style="margin-left:auto; margin-right:auto;"></td>-->
                        <td align="center">${listar.deAnio}</td>
                        <td align="center">${listar.dePeriodo}</td>                                                                            
                        <td align="center">${listar.dePlanilla}</td>
                        <td align="center">${listar.deSubPlanilla}</td>
                        <td align="center">${listar.total}</td>
                                                
                        <c:choose>
                            <c:when test="${empty listar.siProcesa || listar.siProcesa == 0}">
                                <td align="center"> ${listar.siProcesa} </td>
                            </c:when>    
                            <c:otherwise>
                                <td align="center">${listar.siProcesa} &nbsp;&nbsp;
                                    <a href="#" class="md-btn md-btn-facebook md-btn-mini md-btn-icon" style="min-width:10px">C</a>                                
                                </td>
                            </c:otherwise>
                        </c:choose>
                
                        <c:choose>
                            <c:when test="${empty listar.noProcesa || listar.noProcesa == 0}">
                                <td align="center"> ${listar.noProcesa} </td>
                            </c:when>    
                            <c:otherwise>
                                <td align="center">${listar.noProcesa} &nbsp;&nbsp;                                    
                                    <a id="idProcesar" class="md-btn md-btn-mini md-btn-icon" href="javascript:seleccioneProceso('${listar.tiPlanilla}','${listar.suTiPlanilla}','${listar.deAnio}','${listar.dePeriodo}')" style="min-width:10px">P</a>
                                    <!--<a href="#" class="md-btn md-btn-twitter md-btn-mini md-btn-icon" style="min-width:10px">P</a>-->
                                    <a id="idProcesar" class="md-btn md-btn-mini md-btn-icon" href="javascript:seleccioneDetalle('${listar.deAnio}','${listar.dePeriodo}')" style="min-width:10px">C</a>
                                </td>
                            </c:otherwise>
                        </c:choose>

                        <c:choose>
                            <c:when test="${empty listar.siDescarga || listar.siDescarga == 0}">
                                <td align="center"> ${listar.siDescarga} </td>
                            </c:when>    
                            <c:otherwise>
                                <td align="center">${listar.siDescarga} &nbsp;&nbsp;                                
                                    <a href="#" class="md-btn md-btn-twitter md-btn-mini md-btn-icon" style="min-width:10px">C</a>
                                </td>
                            </c:otherwise>
                        </c:choose>  

                        <c:choose>
                            <c:when test="${empty listar.noDescarga || listar.noDescarga == 0}">
                                <td align="center"> ${listar.noDescarga} </td>
                            </c:when>    
                            <c:otherwise>
                                <td align="center">${listar.noDescarga} &nbsp;&nbsp;                                
                                    <a href="#" class="md-btn md-btn-twitter md-btn-mini md-btn-icon" style="min-width:10px">C</a>
                                </td>
                            </c:otherwise>
                        </c:choose>
 
                        <!--<td align="center">
                            <a id="idProcesar" class="md-btn md-btn-primary" href="javascript:seleccioneProceso('${listar.tiPlanilla}','${listar.suTiPlanilla}','${listar.deAnio}','${listar.dePeriodo}')">Procesar</a>
                        </td>-->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty listConsultaProceso}">
        <table width="900"  class="uk-table table-bordered uk-table-striped">
            <thead>
                <tr>
                    <th align="center" scope="col">No se encontraron registros.</th>
                </tr>
            </thead>
        </table>
    </c:if>
</div>

