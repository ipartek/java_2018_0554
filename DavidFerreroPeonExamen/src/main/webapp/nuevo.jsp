<%@ include file="../includes/cabecera.jsp"  %>
<head>
<title>Nuevo Perro</title>
</head>

<main class="container">
<section>
	<form action="home" method="post" class="form-signin">			
		
		<p><strong>Introduce los Datos del Perro que deseas incluir</strong></p>
		<p>
			<label for="nombre">Nombre</label>
			<input type="text"  name="nombre" class="form-control" > 
		</p>
		<p>
			<label for="raza">Raza</label>
			<input type= "text" name="raza" class="form-control"  placeholder="sin raza/milrazas"></input>
		</p>
		<p>
			<label for="chip">Chip</label>
			<input type="number"  name="chip" class="form-control" > 
		</p>
			<button class="btn btn-lg btn-primary btn-block" type ="submit">Aceptar</button>			
		</form>
	</section>
</main>	


