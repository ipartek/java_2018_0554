<%@ include file="../includes/cabecera.jsp"  %>
<%@ page import= "com.ipartek.formacion.modelo.pojo.HomePojo"  %> 

<!DOCTYPE html>
<html>
<head>


<title>Listado</title>

</head>
<body>
	<main class="container">
		<div >
		    <h1>Listado de Perros</h1>
		  <table class="table table-striped">
			    <thead>
				    <tr>
				    <th>Imagen</th>  
				    <th>Nombre</th>
				    <th>Raza</th>		    
				    <th>Edad</th>
				    <th>Peso</th>
				    <th>nº Chip</th>
				    </tr>
			    </thead>
			    <tbody>	
			      <c:forEach items="${perros}" var="v">
				    <tr>			    
				    <td><a href="home?imagen=${v.imagen}&nombre=${v.nombre}&raza=${v.raza}&edad=${v.edad}&peso=${v.peso}"><img src="${v.imagen}"/></a></td>
				    <td>${v.nombre}</td> 
				    <td>${v.raza}</td>	
				    <td>${v.edad}</td>
				    <td>${v.peso}</td>
				    <td>${v.chip}</td>					
				    </tr>
			      </c:forEach>	      
			    </tbody>
		  </table>
	  </div>
	</main>
</body>
</html>