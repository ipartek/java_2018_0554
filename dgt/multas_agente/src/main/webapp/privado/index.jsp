<%@include file="../includes/cabecera.jsp" %>
<%@include file="../includes/menu.jsp" %>

<main role="main" class="inner cover text-center">
    <h1 class="cover-heading">
	    <span class="d-flex justify-content-center align-items-center">
	    	<i class="material-icons" style="font-size:64px;">equalizer</i>
	    	Estadísticas:
	    </span>
    </h1>
    <div class="col-xl-12 col-sm-6 py-2">
    	<div class="card bg-success text-white h-100">
    		<div class="card-body bg-success">
    		<div class="rotate">
    			<i class="material-icons" style="font-size:36px;">trending_up</i>
    		</div>
    		<h3 class="text-uppercase">Ganancias mensuales</h3>
    		
		<c:choose>
			  <c:when test="${agenteLogueado.mensual.importeTotal <= 700}"> 
			    <h4 class="text-danger">${agenteLogueado.mensual.importeTotal}&euro; / 1000&euro;</h4>

			</c:when>
			  <c:when test="${agenteLogueado.mensual.importeTotal >= 1000}">
			    <h4 class="">${agenteLogueado.mensual.importeTotal}&euro; / 1000&euro;</h4>
			    <small>Has cumplido el objetivo mensual!</small>
			  </c:when>
			  <c:otherwise>
			    <h4 class=" text-warning">${agenteLogueado.mensual.importeTotal}&euro; / 1000&euro;</h4>
			    <small class="text-warning">Te quedan 
				    <fmt:formatNumber type = "number" 
	         			maxIntegerDigits = "2" value = "${(1000 - agenteLogueado.mensual.importeTotal)}" />
				    	&euro; para cumplir el objetivo mensual.
			    </small>
			  </c:otherwise>
			</c:choose>   		 
			
    		</div>
    	</div>
    </div>
   <div class="col-xl-12 col-sm-6 py-2">
    	<div class="card bg-info text-white h-100">
    		<div class="card-body bg-info">
    		<div class="rotate">
    			<i class="material-icons" style="font-size:36px;">trending_up</i>
    		</div>
    		<h3 class="text-uppercase">Ganancias anuales</h3>
    		
    		<c:choose>
			  <c:when test="${agenteLogueado.anual.importeTotal <= 10000}">
			    <h4 class=" text-danger">${agenteLogueado.anual.importeTotal}&euro; / 12000&euro;</h4>
			  </c:when>
			  <c:when test="${agenteLogueado.anual.importeTotal >= 12000}">
			    <h4 class="">${agenteLogueado.anual.importeTotal}&euro; / 12000&euro;</h4>
			    <small>Has cumplido el objetivo anual!</small>
			  </c:when>
			  <c:otherwise>
			    <h4 class=" text-warning">${agenteLogueado.anual.importeTotal}&euro; / 12000&euro;</h4>
			    <small class="text-warning">Te quedan 
				    <fmt:formatNumber type = "number" 
	         			maxIntegerDigits = "2" value = "${(12000 - agenteLogueado.anual.importeTotal)}" />
				    	&euro; para cumplir el objetivo anual.
			    </small>
			  </c:otherwise>
			</c:choose> 
    		</div>
    	</div>
    </div> 
    Seleccionar el año: 
    <select class="form-control">
    	<option selected>2018</option>
    	<option >2019</option>
    </select>
    <table class="table table-striped">
    	<thead class="thead-dark">
    		<tr>
    			<th>Mes</th>
    			<th>Importe</th>
    		</tr>
    	</thead>
    	<tbody class="tbody-light">
    	<c:forEach items="${agenteLogueado.objetivoMeses}" var="om">
         <tr>
        	<td>${om.mes }</td>
   			<td>${om.importeTotal}&euro;</td>
   		</tr> 
      </c:forEach>
    	</tbody>
    	<tfoot class="tfoot-dark">
    	<tr>
   			<th>Mes</th>
   			<th>Importe</th>
   		</tr>
    	</tfoot>
    </table>
<%@include file="../includes/mensajes.jsp" %>
<%@include file="../includes/pie.jsp" %>