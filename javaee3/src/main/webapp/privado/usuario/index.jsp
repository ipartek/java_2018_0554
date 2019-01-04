<%@ include file="../../includes/cabecera.jsp"%>
<%@ include file="../../includes/navbar.jsp" %>

 <main role="main" class="container">
 <%@ include file="../../includes/mensajes.jsp" %>
      <div class="jumbotron">
      
        <h1>Listado Usuarios</h1>
        
        <table class="table-striped col-md-12">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Password</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="u">
				<tr>
					<td>${u.id}</td>
					<td>${u.email}</td>
					<td>${u.password}</td>
					<td><a class="btn btn-warning btn-block" href="privado/usuarios?op=2&id=${u.id}">Editar/Eliminar</a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table> 
	
    <a class="btn btn-primary mt-3" href="privado/usuarios?op=2&id=-1">Nuevo Usuario</a>
    
        </div>
    </main>

<%@ include file="../../includes/footer.jsp"%>