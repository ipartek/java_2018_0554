<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="#"><fmt:message key="navbar.videos"/></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath }">
						<fmt:message key="navbar.inicio"/>
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active">
				<a class="nav-link" href="usuarios_logueados.jsp"><fmt:message key="navbar.usuarios.conectados"/></a>
				</li>
				<!-- <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
          </li> -->
			</ul>
			<ul class="navbar-nav mr-auto border border-success">
			<li class="nav-item">
            <i class="fa fa-user-o fa-2x text-success" aria-hidden="true"></i>
          	</li>
          	<li class="nav-item">
          	<span class="text-warning">${sessionScope.usuario_logueado.email }</span>
          	</li>
			</ul>
			<c:choose>
			    <c:when test="${sessionScope.usuario_logueado!=null}">
			    <a href="privado/pagina.jsp" class="btn btn-outline-primary my-2 my-sm-0"><fmt:message key="navbar.crear.pagina"/></a>
			    <form class="form-inline mt-2 mt-md-0" action="logout" method="POST">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit"><fmt:message key="navbar.logout"/></button>
					</form>   
					    </c:when>    
					    <c:otherwise>
					     <form class="form-inline mt-2 mt-md-0" action="login" method="GET">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit"><fmt:message key="navbar.login"/></button>
					</form>
			    </c:otherwise>
			</c:choose>
		</div>
	</nav>