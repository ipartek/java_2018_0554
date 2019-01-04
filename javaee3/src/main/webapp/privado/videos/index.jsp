<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


    <main role="main" class="container">
	
		<a href="privado/videos?op=2&id=-1" class="btn btn-outline-success mb-2">Crear Nuevo Registro</a>
		
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">id</th>
		      <th scope="col">nombre</th>
		      <th scope="col">codigo</th>		      		      
		    </tr>
		  </thead>
		  <tbody>
		 	 <c:forEach items="${videos}" var="v">
			    <tr>
			      <th scope="row">${v.id}</th>
			      <td><a href="privado/videos?op=2&id=${v.id}">${v.nombre}</a></td>
			      <th scope="row">${v.codigo}</th>			      		      
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>


	</main>				


<%@ include file="../../includes/footer.jsp"  %>  