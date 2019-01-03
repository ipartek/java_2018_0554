<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


    <main role="main" class="container">
		<div class="jumbotron">
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">id</th>
		      <th scope="col">Email</th>
		      <th scope="col">Password</th>
		      <th></th>	      
		    </tr>
		  </thead>
		  <tbody>
		 	 <c:forEach items="${usuarios}" var="u">
			    <tr>
			      <th scope="row">${u.id}</th>
			      <td>${u.email}</td>
			      <td>${u.password}</td>
			      <td><a href="privado/usuarios?op=2&id=${u.id}">Modificar / eliminar<span class="icon-bin"></span></a></td>		      
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>
<a href="privado/usuarios?op=2&id=-1" class="btn btn-primary">Crear Nuevo Registro</a>
</div>
	</main>				


<%@ include file="../../includes/footer.jsp"  %>  