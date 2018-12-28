<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!doctype html>
<html lang="ES">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Prueba</title>
<base href="${pageContext.request.contextPath}/">
<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->

<link href="css/signin.css" rel="stylesheet">
<link href="css/miCss.css" rel="stylesheet">
</head>
<body class="text-center">

	<form class="form-signin" action="login" method="post" >
	
		<%@include file="/includes/mensajes.jsp"%>
		
	
		<h1 class="h3 mb-3 font-weight-normal">
			Login
		</h1>
		
		<label for="usuario" class="sr-only"></label> <input type="text" id="usuario"
			name="usuario" class="form-control"
			placeholder="Usuario" required autofocus>

		<label for="pass" class="sr-only"></label> <input type="password" id="pass" name="pass"
			class="form-control"
			placeholder="Password" required>
		

		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Login
		</button>
	</form>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>
</body>
</html>

