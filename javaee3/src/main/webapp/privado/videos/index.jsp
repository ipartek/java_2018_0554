<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


	<a href="privado/usuarios?op=2&id=-1" class="btn btn-outline-success mb-2">Crear Nuevo Registro</a>
		

<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">id</th>
		      <th scope="col">nombre</th>
		      <th scope="col">codigo</th>		      
		    </tr>
		  </thead>
		  <tbody>
		 	 <c:forEach items="${video}" var="v">
			    <tr>
			      <th scope="row">${v.id}</th>
			      <td><a href="privado/videos?op=2&id=${v.id}">${v.nombre}</a></td>
			      <td>${v.codigo}</td>		      
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>
			
<!-- //Integrar el carrito aqui -->
			
<%@ include file="../../includes/footer.jsp"  %>  