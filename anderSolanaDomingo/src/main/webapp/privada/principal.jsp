<%@ include file="../includes/cabecera.jsp" %>
<%@ include file="../includes/menu.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h1>Bienvenido a la zona privada <span class="text-capitalize text-info">${sessionScope.usuario_logueado.nombre}</span></h1>
	</div>
</div>

<%@ include file="../includes/pie.jsp" %>