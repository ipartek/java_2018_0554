<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<body>
	<form method="post" action="mantenimiento">
		<input type="hidden" name="pagina" value="${pagina}">
		<div class="form-row">
			<div class="col">
				<input type="text" name="autor" readonly class="form-control" value="${autor}">
			</div>
		</div>
		<div class="form">
			<div class="col">
				<textarea rows="20" name="texto" cols="50">${texto}</textarea>
			</div>
			<div class="col">
				<button type="submit" class="btn btn-primary">Enviar</button>
			</div>
		</div>
	</form>
</body>
<%@include file="includes/footer.jsp"%>