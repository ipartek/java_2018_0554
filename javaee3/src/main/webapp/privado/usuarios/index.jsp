<%@ include file="../../include/header.jsp"  %>
<%@ include file="../../include/navbar.jsp"  %>
<%@ include file="../../include/mensajes.jsp"  %>


    <main role="main" class="container">
	
		<a href="privado/usuarios?op=2&id=-1" class="btn btn-outline-success mb-2">Crear Nuevo Registro</a>
		
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">id</th>
		      <th scope="col">Email</th>
		      <th scope="col">Password</th>		      
		    </tr>
		  </thead>
		  <tbody>
		 	 <c:forEach items="${usuarios}" var="u">
			    <tr>
			      <th scope="row">${u.id}</th>
			      <td><a href="privado/usuarios?op=2&id=${u.id}">${u.email}</a></td>
			      <td>${u.password}</td>		      
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>


	</main>				


<%@ include file="../../include/footer.jsp"  %>  