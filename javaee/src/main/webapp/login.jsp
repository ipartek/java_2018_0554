<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicie sesión</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
	.error{ color: red;}	
</style>
</head>
<body>
<div class="container">
<div class="jumbotron">
<form action="login" method="post">
	
	<fieldset>
		<legend>Login</legend>
		
		<div class="form-group">
			<label for="email">Email</label>
			<input type="email" name="email" id="email" />
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<input type="password" name="password" id="password" />
		</div>
		<div class="form-group">
			<button>Login</button>
		<%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
		</div>
	</fieldset>
	
</form>
</div>
</div>
</body>
</html>