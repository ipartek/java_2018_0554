<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>



<main role="main" class="container">
<div class="jumbotron">


	<!-- <h1><a href="saludar?nombreGet=pepe&apellidoGet=grillo">Saludar por get</a></h1> -->

	<c:if test="${not empty nombreGet}">

		<h1>Bienvenido, ${nombreGet} ${apellidoGet}</h1>
		<h2>[Esto es GET]</h2>

	</c:if>

	<c:if test="${not empty nombre}">
		<h1>Bienvenido, ${nombre} ${apellido}</h1>
		<h2>[Esto es POST]</h2>

		<h3>
			Quieres saludar por get? <a
				href="saludar?nombreGet=${nombre}&apellidoGet=${apellido}">Saludar
				por get</a>
		</h3>
		<h3></h3>
	</c:if>

	</body>
	</html>





</div>
</main>





<%@ include file="../includes/footer.jsp"%>
