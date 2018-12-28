<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>

<main role="main" class="container">
<div class="jumbotron">
	<table class="table table-hover">
		<tr>
			<th>Opciones</th>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td><a class="list-group-item" href="saludars?met=post">Saludar
					por POST</a></td>
		</tr>
		<tr>
			<td><a class="list-group-item" href="saludars?met=get">Saludar
					por GET</a></td>
		</tr>
		<tr>
			<td><a class="list-group-item" href="perros">Listar</a></td>
		</tr>
		<tr>
			<td><a class="list-group-item" href="privado/nuevoperro.jsp">Nuevo
					Perro</a></td>
		</tr>

	</table>

</div>
</main>
<%@ include file="../includes/footer.jsp"%>
