<%@include file="includes/header.jsp"%>
<body class="text-center">
	<form novalidate class="form-signin" action="login" method="post">
		<h1 class="h3 mb-3 font-weight-normal">
			<fmt:message key="login.logueate" />
		</h1>
		<label for="usuario" class="sr-only"><fmt:message
				key="login.usuario" /><</label> <input type="text" id="usuario"
			name="usuario" class="form-control" placeholder="Tu@usuario"
			value="${usuario}" required autofocus> <label for="password"
			class="sr-only"><fmt:message key="login.pass" /></label> <input
			type="password" id="password" class="form-control"
			placeholder="Mínimo 6 caractéres" name="password" value="${password}"
			required>

		<!-- leer cookie para Idioma -->
		<c:set var="cIdioma"
			value="${not empty cookie.cIdioma ? cookie.cIdioma.value : 'es_ES'}"
			scope="session" />

		<label for="idioma"><fmt:message key="idioma" /></label> 
		<select name="idioma" class="form-control mb-5">
			<option value="es_ES" ${(cIdioma=="es_ES")?"selected":""}>Español</option>
			<option value="eu_ES" ${(cIdioma=="eu_ES")?"selected":""}>Euskera</option>
		</select>
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			<fmt:message key="login.boton" />
		</button>
		<%@include file="includes/mensajes.jsp"%>
		<p class="mt-5 mb-3 text-muted">&copy; Héctor Serrano 2018</p>
	</form>
	<%@include file="includes/footer.jsp"%>