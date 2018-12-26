<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<body>
	<main role="main" class="container">
	<div class="jumbotron">
		<form method="post" action="mantenimiento">
			<input type="hidden" name="pagina" value="${pagina}"> <input
				type="text" name="autor" readonly class="form-control"
				value="${logueado.email}">
			<textarea rows="10" cols="130" placeholder="minimo 50 caracteres" name="texto"
				class="border border-secondary p-3">${texto}</textarea>
			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>
	</div>
	</main>
</body>
<%@include file="includes/footer.jsp"%>