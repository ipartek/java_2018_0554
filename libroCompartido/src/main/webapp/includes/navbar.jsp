<%@include file="/includes/cabecera.jsp" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="#"><fmt:message key="navbar.tituloPrincipal" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="index"><fmt:message key="navbar.libro" />
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="usuariosLogeados.jsp"><fmt:message key="navbar.usuariosConectados" />
						<span class="sr-only">(current)</span>
				</a></li>
				<c:choose>
					<c:when test="${empty sessionScope.usuarioLogeado.usuario}">
      					
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link disabled" href="privado/nuevaPagina"><fmt:message key="navbar.nuevaPagina"/></a>
					</c:otherwise>
				</c:choose>				
			</ul>
			
			
			<c:choose>
			<c:when test="${empty sessionScope.usuarioLogeado.usuario}">
      			<form class="form-inline mt-2 mt-md-0" action="login" method="">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit"><fmt:message key="navbar.login" /></button>
				</form>
			</c:when>
			<c:otherwise>
			<!-- Mostrar fecha de ultima conexion -->
			<%-- <c:set var="cFechaConexion" value="${not empty cookie.cFechaConexion ? cookie.cFechaConexion : ''}" scope="session" /> --%>
				<%--  ${cFechaConexion} --%>
				<span class="text-success nav-link">${sessionScope.usuarioLogeado.usuario}:</span>
				
				<form class="form-inline mt-2 mt-md-0" action="desconectar" method="">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit"><fmt:message key="navbar.logOut"/></button>
				</form>
			</c:otherwise>
		</c:choose>
		</div>
	</nav>
