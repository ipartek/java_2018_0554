<%@ include file="../includes/cabecera.jsp" %>
<%@ include file="../includes/menu.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h1>Saludos <span class="text-capitalize text-info">${sessionScope.nombre_saludo} ${sessionScope.apellido_saludo}</span></h1>
	</div>
</div>

<%@ include file="../includes/pie.jsp" %>