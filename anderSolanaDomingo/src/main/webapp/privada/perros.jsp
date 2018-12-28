<%@ include file="../includes/cabecera.jsp" %>
<%@ include file="../includes/menu.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h1>Todos los perros</h1>
		<c:forEach items="${perros}" var="p">
  		  <div class="container border-top border-info p-3">
	  		<h2 class="display-4"><c:out value="${p.nombre}"/></h2>
	  		<ul>
	  			<li><span class="text-warning">Raza: </span><c:out value="${p.raza}"/></li>
	  			<li><span class="text-warning">Chip: </span>
	  				<ul class="list-unstyled pl-5">
	  				<li><span class="text-secondary">ID: </span><c:out value="${p.chip.id}"/></li>
	  				<li><span class="text-secondary">Latitud: </span><c:out value="${p.chip.latitud}"/></li>
	  				<li><span class="text-secondary">Longitud: </span><c:out value="${p.chip.longitud}"/></li>
	  				</ul>
	  			</li>
	  		</ul>
	  		<a class="btn btn-success" href="privada/perro?nombre=${p.nombre}">Ver ficha completa</a>
  		</div>
		</c:forEach>
	</div>
</div>

<%@ include file="../includes/pie.jsp" %>