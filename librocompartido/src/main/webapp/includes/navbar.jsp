
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<a class="navbar-brand" href="#">El libro gordo de petete</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"></li>
		</ul>
		<ul class="navbar-nav float-right">
			<li><span class="badge badge-light mr-3">${usuario.email}</span></li>
			<c:choose>
				<c:when test="${usuario.email!=null}">
					<li><a href="logout" class="btn btn-outline-danger">SALIR</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="login.jsp" class="btn btn-outline-success">LOGIN</a>
					<li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>