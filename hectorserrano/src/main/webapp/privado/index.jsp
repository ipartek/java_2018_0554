<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
	<main role="main" class="container">
		<h2 class="h3 mb-4 font-weight-normal">Saludar por Post</h2>
		<form novalidate class="form-signin" action="saludo" method="post">
			<label for="nombre">Usuario: </label> 
				<input type="text" id="usuario" name="nombre" class="form-line" required autofocus> 
			<label for="password"> Apellidos:</label> 
				<input type="text" id="apellidos" class="form-line" name="apellidos" required>
			<button class="mb-4 btn btn-outline-primary" type="submit">Saludar</button>
		</form>

		<p>
			<a class="btn btn-outline-secondary" href="saludo?nombre=hector&apellidos=serrano">Saludar por Get</a>
		</p>
		
		<hr>
		
		<h2 class="h2 mb-4">Perro</h2>
		<h3 class="h3 mb-4">Nuevo Perro</h3>
		
		<form novalidate class="form-signin" action="perro" method="post">
			<label for="nombre">Nombre: </label> 
				<input type="text" id="nombre" name="nombre" class="form-line" required autofocus> 
			<label for="chip">Chip: </label> 
				<input type="text" id="chip" name="chip" class="form-line" placeholder="DD-DDDD-AAAA" required> 
			<label for="raza">Raza: </label> 
				<input type="text" id="raza" name="raza" class="form-line" required>
			<button class="mb-4 btn btn-outline-primary" type="submit">Crear</button>
		</form>
		<%@ include file="../includes/mensajes.jsp"%>
		
		<h3 class="h3 mb-4">Lista de Perros</h3>
		
		<table class="table table-hover table-borderless">
			<thead class="thead-dark">
				<tr>
					<th>Chip</th>
					<th>Nombre</th>
					<th>Raza</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${arrayPerros}" var="perro">
					<tr>
						<td>${perro.chip}</td>
						<td>${perro.nombre}</td>
						<td>${perro.raza}</td>
						<td>
							<a class="btn btn-outline-dark" href="detalles?chip=${perro.chip}
							&coordenadas=${perro.coordenadas}
							&nombre=${perro.nombre}
							&edad=${perro.edad}
							&raza=${perro.raza}">
								Detalles
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
<%@include file="../includes/footer.jsp"%>