<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>WSSOAPVehiculo</title>

    <!-- Bootstrap -->
    <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

	<main class="container">
		<div class="jumbotron">
		  <h1 class="display-4">Web Service SOAP Vehiculos</h1>
		  <p class="lead">Servicio para poder consultar los datos de un Vehiculo a partir de su matricula</p>
		  <a class="btn btn-primary btn-lg" href="services/WSVehiculo?wsdl" role="button">Endpoint: WSDL</a>
		  
		  <h2>Metodos publicos</h2>
		  <p>No precisan de ningún usuario y clave para poder acceder a ellos. En ellos se devuelve información pública y accesible por todo el mundo.
			</p>
		  <ul>
		  	<li>
		  		obtenerDatos(String matricula)
		  		<ul>
		  		<li>
		  		Recibe un parametro de entrada, una matricula, una vez procesado, se obtendrán los datos requeridos del coche.
		  		<ul>
		  		 <li>Matricula</li>
		  		 <li>Modelo</li>
		  		<li>Kilometros del coche</li>
	           </ul>
		  		</li>
			  	</ul>
		  	</li>
		  </ul>
		</div>
	</main>	
		
	</body>
</html>			