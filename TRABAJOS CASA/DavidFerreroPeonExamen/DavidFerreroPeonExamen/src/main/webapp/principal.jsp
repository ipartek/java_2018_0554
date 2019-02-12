<%@page import= "com.ipartek.formacion.modelo.pojo.HomePojo" %> <!-- page para importar clases etc -->


<!DOCTYPE html>
<html>
<%@ include file="../includes/cabecera.jsp" %> <!-- include para incluir otro archivo -->
<head>
	<title>Home</title>
</head>

<body>
	<main class="container">
		<div>
		<p>
			${mensajeNewPerro}
			</p>
		</div>
		<div>
			<h4>Hola: ${nombre} ${apellido1} ${apellido2} </h4>
			<h5> ¡Encantado de saludarte!  <h5>
		</div>
		
		
		
		

	  <table class="table table-striped">
			    
			    <h5>Detalles de Perro seleccionado en listado</h5>
			    <thead>
				    <tr>
				    
				    <th>Nombre</th>
				    <th>Raza</th>		    
				  	<th>Edad</th>
				 	
				    </tr>
			    </thead>
			    <tbody>	
			    	<tr>
			    	<td><img src="${detalleImagen}"/></td>		    			    
				    <td>${detalleNombre}</td> 
				    <td>${detalleRaza}</td>
				  
				    					   					
				    </tr>			           
			    </tbody>
		  </table>




		
		
	</main>
</body>
</html>














  
  