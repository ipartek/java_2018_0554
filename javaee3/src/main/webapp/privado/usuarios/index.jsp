<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


<main role="main" class="container">

<h1>Listado de Usuarios</h1>


<a href="privado/usuarios?op=2&id=-1">Crear Nuevo Registro</a>

<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Email</th>
				<th>Password</th>
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

<%@ include file="../../includes/footer.jsp"  %>  