<%@ include file="../includes/cabecera.jsp" %>
<%@ include file="../includes/menu.jsp" %>

<div class="container">
	<div class="jumbotron">
	<c:choose>
    <c:when test="${perro != null}">
        <h1>Ficha Completa del perro</h1>
		 <div class="container border-top border-info p-3">
	  		<h2 class="display-4">${perro.nombre}</h2>
	  		<ul>
	  			<li><span class="text-warning">Raza: </span>${perro.raza}</li>
	  			<c:choose>
    			<c:when test="${perro.edad != 0}">
        		<li><span class="text-warning">Edad: </span>${perro.edad}</li>
			    </c:when>    
			    <c:otherwise>
			    <li><span class="text-warning">Edad: </span><span class="text-danger">No especificada</span></li>   
			    </c:otherwise>
				</c:choose>
				
				<c:choose>
    			<c:when test="${perro.peso != 0.0}">
        		<li><span class="text-warning">Peso: </span>${perro.peso}</li>
			    </c:when>    
			    <c:otherwise>
			    <li><span class="text-warning">Peso: </span><span  class="text-danger">No especificado</span></li>   
			    </c:otherwise>
				</c:choose>
				
				<c:choose>
    			<c:when test="${perro.apadrinado == true}">
        		<li><span class="text-warning">Apadrinado: </span>SI</li>
			    </c:when>    
			    <c:otherwise>
			    <li><span class="text-warning">Apadrinado: </span>NO</li>   
			    </c:otherwise>
				</c:choose>

	  			<li><span class="text-warning">Chip: </span>
	  				<ul class="list-unstyled pl-5">
	  				<li><span class="text-secondary">ID: </span>${perro.chip.id}</li>
	  				<li><span class="text-secondary">Latitud: </span>${perro.chip.latitud}</li>
	  				<li><span class="text-secondary">Longitud: </span>${perro.chip.longitud}</li>
	  				</ul>
	  			</li>
	  		</ul>
  		</div>
    </c:when>    
    <c:otherwise>
        <div class="alert alert-danger" role="alert">
  			Lo sentimos, el perro que buscas no existe. <a href="perros">Volver a la lista de todos los perros</a>
		</div>
    </c:otherwise>
	</c:choose>

	</div>
</div>

<%@ include file="../includes/pie.jsp" %>