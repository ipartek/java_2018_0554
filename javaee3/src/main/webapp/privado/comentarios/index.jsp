<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


    <main role="main" class="container">
	
		<a href="privado/comentarios?op=2&id=-1" class="btn btn-outline-success mb-2">Crear Nuevo Registro</a>
		<a href="privado/comentarios?view=all" class="btn btn-outline-info mb-2">Ver todos los comentarios</a>
		<a href="privado/comentarios?view=my" class="btn btn-outline-info mb-2">Ver mis comentarios</a>
		
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">id</th>
		      <th scope="col">nombre</th>
		      <th scope="col">codigo</th>
		      <th scope="col">usuario</th>
		    </tr>
		  </thead>
		  <tbody>
		 	 <c:forEach items="${comentarios}" var="c">
			    <tr>		    	
			      <th scope="row">${c.id}</th>
			      <td><a href="privado/comentarios?op=2&id=${c.id}">${c.texto}</a></td>
			      <th scope="row">${c.usuario.nombre}</th>			      		      
			      <th scope="row">${c.texto}</th>
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>


	</main>				


<%@ include file="../../includes/footer.jsp"  %>  