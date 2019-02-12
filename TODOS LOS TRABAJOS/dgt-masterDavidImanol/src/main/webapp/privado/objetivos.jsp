<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/cabecera.jsp" %> 	

<main>
<section class="container-fluid mt-5 ">
<c:if test = "${mensaje!=null}">
	<div class="alert alert-info alert-dismissible fade show" role="alert">
	  <strong> ${mensaje }</strong>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>


<div class="card-deck mb-3 text-center">
<div class="card mb-4 box-shadow">
<div class="card-header">
<h4 class="my-0 font-weight-normal">Mes actual  <fmt:formatDate pattern = "MMMM" value = "${objetivo.fecha }" /></h4>
</div>
<div class="card-body">
<h1 class="card-title pricing-card-title text-${estado }"> 
   <fmt:formatNumber pattern="#,##0.00" value="${not empty objetivo.importe ? objetivo.importe : '0.0'}"/>€ 

<small class="text-muted">/1.000€</small></h1>						
</div>
</div>    
<div class="card mb-4 box-shadow">
<div class="card-header">
<h4 class="my-0 font-weight-normal">Año actual <fmt:formatDate pattern = "yyyy" value = "${objetivo2.fecha }" /></h4>
</div>
<div class="card-body">
<h1 class="card-title pricing-card-title text-${estado2 }">
    <fmt:formatNumber pattern="#,##0.00" value="${objetivo2.importe}"/>€ 

<small class="text-muted">/12.000€</small></h1>
</div>
</div>      
</div>


 <hr>




 <h5>Historico </h5>
 <c:choose>
 <c:when test="${not empty anios }">


<form>
<select class="form-control" onchange="cambiaranio(this)">
<c:forEach items="${anios}" var="anio">
<option value="${anio }" <c:if test="${anio == a }">selected</c:if> >${anio }</option>
</c:forEach>
</select> 
</form>



<table class="table table-hover"> 
<thead>
<tr>
<th>Mes</th> 
<th>Recaudado</th>           
<th>Total de Multas</th>                                             
</tr>
</thead>
<tbody>
<c:forEach items="${historico }" var="h">

     
 <c:choose>
<c:when test="${h.importe >= 1000}">
 <c:set var = "s" scope = "session" value = "success"/>  
  <tr class="text-<c:out value = "${s}"/>">
</c:when>
<c:when test="${h.importe >= 1000/2}">
 <c:set var = "s" scope = "session" value = "warning"/>  
  <tr class="text-<c:out value = "${s}"/>">
</c:when>
<c:when test="${h.importe < 1000/2}">
 <c:set var = "s" scope = "session" value = "danger"/>  
  <tr class="text-<c:out value = "${s}"/>">
</c:when>
</c:choose>	
           

<td><fmt:formatDate pattern = "MMMM" value = "${h.fecha }" /></td>
<td><fmt:formatNumber pattern="#,##0.00" value="${h.importe }"/>€ </<td>
<td>${h.num_multas }</<td> 
</tr>                                                   
</c:forEach>                  
</tbody>      
</table>  
    
 </c:when>
 <c:otherwise>
 SIN DATOS
 </c:otherwise>
 </c:choose>



 
</section>
</main>
<%@ include file="../includes/footer.jsp"  %>