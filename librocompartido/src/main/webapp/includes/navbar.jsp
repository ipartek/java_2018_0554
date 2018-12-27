
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<a class="navbar-brand" href="#"><fmt:message key="titulo.navbar"/></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<c:if test="${usuario.nombre!=null}">
				<li class="nav-item"><a class="btn btn-outline-primary"
					href="pagina?pag=0"><fmt:message key="ver.libro"/></a></li>
				<li>&nbsp;</li>
				<li class="nav-item"><a class="btn btn-outline-primary"
					href="edicion/agregarlibro.jsp"><fmt:message key="esc.libro"/></a></li>
			</c:if>
		</ul>
		<ul class="navbar-nav float-right">
		
			<li><form action="pagina" method="get"><input name="pag" type="text" size="50"><input name="donde" type="hidden" value="busc"> &nbsp;&nbsp;<button href="logout" class="btn btn-outline-primary "><fmt:message key="bot.buscar"/></button></form></li>
			
			<li>&nbsp;&nbsp;&nbsp;</li>
		</ul>
		<ul class="navbar-nav float-right align-middle">
			<li><span class="badge badge-light mr-3 ">${usuario.nombre}</span></li>
			<c:choose>
				<c:when test="${usuario.nombre!=null}">
					<li><a href="logout" class="btn btn-outline-danger"><fmt:message key="bot.salir"/></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="login.jsp" class="btn btn-outline-success"><fmt:message key="bot.login"/></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>