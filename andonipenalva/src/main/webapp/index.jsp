 
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>Acceso a perros</title>
 
 
 <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
  </head>
  
  
<main role="main" class="container">
<form action="login" method="post" class="form-signin">
	<fieldset>
		<legend>Login</legend>

		<p>
			<label for="nombre">Nombre</label>
			
			<input type="text" name="nombre" id="nombre" value="scooby" />
		</p>
		<p>
			<label for="password">Password</label>
			
			<input type="password" name="password" id="password" value="galletas" />
		</p>
		<p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		<%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %> 
		
				</p>
	</fieldset>
</form>
</main>