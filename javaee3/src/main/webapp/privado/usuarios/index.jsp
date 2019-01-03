<%@ include file="../../include/header.jsp"  %>
<%@ include file="../../include/navbar.jsp"  %>
<%@ include file="../../include/mensajes.jsp"  %>


<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
<h1 class="h2">Usuarios registrados: ${usuarios.size() }</h1>
<div class="btn-toolbar mb-2 mb-md-0">
<div class="btn-group mr-2">
<a href="privado/usuarios?op=2&id=-1" class="btn btn-outline-info mb-2 mt-2">Insertar nuevo usuario</a>
</div> 
</div>
</div>
	
		<table class="table col-md-10 offset-md-1">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">EMAIL</th>
		      <th scope="col">PASSWORD</th>		      
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