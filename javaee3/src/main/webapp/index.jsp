<%@ include file="includes/cabecera.jsp"%>

<body class="text-center">
	<form class="form-signin" action="login" method="post" novalidate>
		<img class="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt=""
			width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="email" class="sr-only">Email</label> <input type="email"
			id="email" name="email" class="form-control" placeholder="Email"
			required autofocus> <label for="pass" class="sr-only">Password</label>
		<input type="password" id="pass" name="pass" class="form-control"
			placeholder="Password" required>
		<div class="checkbox mb-3"></div>
		<c:if test="${mensaje != null}">
			<div class="alert alert-danger ">${mensaje}</div>
		</c:if>
		<c:if test="${sessionScope.error != null}">
			<div class="alert alert-danger ">${mensaje}</div>
		</c:if>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
	</form>


</body>
</html>



