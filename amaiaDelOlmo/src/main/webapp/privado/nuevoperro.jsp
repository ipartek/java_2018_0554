<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>		
		
<main role="main" class="container en-dos">
	<div class="jumbotron">
		<h2 class="h3 mb-3 font-weight-normal">Escribir nuevo perro</h2>
		<form class="form-signin" action="perro" method="post">
			<input type="text" name="nombre" placeholder="nombre" class="form-control mb-3" required><br>
			<input type="text" name="chip" placeholder="chip" class="form-control mb-3" required><br>
			<input type="text" name="raza" value="milrazas" placeholder="raza" class="form-control mb-3" required><br>
			<input type="text" name="edad" placeholder="edad" class="form-control mb-3" required><br>
			<input type="text" name="peso" placeholder="peso" class="form-control mb-3" required><br>
			<input type="text" name="apadrinado" placeholder="apadrinado" class="form-control mb-3" required><br>
			<input type="text" name="localizacion" placeholder="localizacion" class="form-control mb-3" required><br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Nuevo perro</button>
		</form>
	</div>
</main>	
<%@ include file="../includes/footer.jsp"  %>