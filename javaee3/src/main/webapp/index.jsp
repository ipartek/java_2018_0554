<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>JavaEE</title>
<base href="${pageContext.request.contextPath}/">
<!-- Bootstrap core CSS -->
<link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->

<link href="css/signin.css" rel="stylesheet">
<link href="css/miCss.css" rel="stylesheet">
</head>
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
			<div class="alert alert-${mensaje.tipo} ">${mensaje.texto}</div>
		</c:if>
		<c:if test="${sessionScope.error != null}">
			<div class="alert alert-danger alert-dismissible fade show ">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${error}
			</div>
		</c:if>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
	</form>


</body>
</html>



