<%@ include file="../includes/cabecera.jsp"  %>


<!DOCTYPE html>
<html>
<head>

<title>Negu en detalle</title>
</head>
<body>
<main class="container">

	  <table class="table table-striped">
			    <thead>
				    <tr>
				    
				    <th>Nombre</th>
				    <th>Raza</th>		    
				  
				    </tr>
			    </thead>
			    <tbody>	
			    	<tr>		    			    
				    <td>${detalleNombre}</td> 
				    <td>${detalleRaza}</td>					   					
				    </tr>			           
			    </tbody>
		  </table>
</main>


${nombre}
${raza}


</body>
</html>