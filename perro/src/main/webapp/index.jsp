<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/style_index.css" rel="stylesheet">
  </head>

  <body class="text-center">
    <form action="login" method="post" class="form-signin">
      <img class="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Inicia sesion</h1>
      <label for="email" class="sr-only">Email</label>
      	<input type="text" id="email" name="email" class="form-control" placeholder="tu@email.com" value="scobby" required autofocus>
      <label for="password" class="sr-only">Password</label>
      	<input type="text" id="password" name="password" class="form-control" placeholder="minimo 6 caracteres" required autofocus value="galletas">
   
      <button class="btn btn-lg btn-primary btn-block" type="submit">Inicia sesion</button>
  
    </form>
  </body>
</html>