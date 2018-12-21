<%@ include file="../includes/cabecera.jsp"%>
<body>

	<header>
		<!-- Fixed navbar -->
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<a class="navbar-brand" href="#">Fixed navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				<form class="form-inline mt-2 mt-md-0" action="${pageContext.request.contextPath}/desconectar" method="POST">
					<!-- <input class="form-control mr-sm-2" type="text" placeholder="Buscar"
 					aria-label="Buscar"> -->
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Desconectar</button>
				</form>
			</div>
		</nav>
	</header>

	<!-- Begin page content -->
	<main role="main" class="container jumbotron">
	<h1 class="mt-5">Usuario Logeado</h1>
	<p class="lead">${sessionScope.usuario.email}</p>
	<table class="table-striped col-md-12">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Video/url</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${videos}" var="video">
				<tr>
					<td>${video.id}</td>
					<td>${video.nombre}</td>
					<td><iframe width="500" height="150"
							src="https://www.youtube.com/embed/${video.url}" frameborder="0"
							allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
							allowfullscreen></iframe></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>


	</main>
	<footer class="footer"> </footer>
</body>
</html>