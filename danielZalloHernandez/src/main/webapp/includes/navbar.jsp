<%@include file="/includes/cabecera.jsp" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="privado/principal">Principal</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="privado/saludarPost">Saludar Post<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="privado/saludarGet?nombre=Dani&apellido=Zallo">Saludar Get<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="privado/perros">Listar Perros<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="#">Formulario Nuevo Perro<span class="sr-only">(current)</span>
				</a></li>
			</ul>
			
			
		<c:choose>
			<c:when test="${empty sessionScope.usuario.usuario}">
      			<form class="form-inline mt-2 mt-md-0" action="login" method="">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
				</form>
			</c:when>
			<c:otherwise>
				<span class="text-success nav-link">${sessionScope.usuario.usuario}</span>
				
				<form class="form-inline mt-2 mt-md-0" action="logout" method="">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log out</button>
				</form>
			</c:otherwise>
		</c:choose> 
		</div>
	</nav>
