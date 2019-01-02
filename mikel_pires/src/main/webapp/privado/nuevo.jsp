<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>



<main role="main" class="container">
<div class="jumbotron">

	<h1>Crear nuevo perro</h1>

	<form action="nuevo" method="post">
		<div class="form-group">
			<c:if test="${not empty mensaje}">
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">${mensaje}</div>
			</c:if>
		</div>
		<div class="form-group">

			<input type="text" class="form-control" aria-describedby="emailHelp"
				name="nombre" placeholder="Inserta nombre">
		</div>

		<div class="form-group">
			<input type="text" class="form-control" aria-describedby="emailHelp"
				name="raza" placeholder="Inserta raza ">
		</div>

		<div class="form-group">
			<input type="text" class="form-control" aria-describedby="emailHelp"
				name="chip" placeholder="Inserta nº chip (DD-DDDD-AAAA)">
		</div>

		<div class="form-group">
			<button type="submit" class="btn btn-primary btn-block">
				Guardar cambios</button>
		</div>
	</form>



</div>
</main>





<%@ include file="../includes/footer.jsp"%>
