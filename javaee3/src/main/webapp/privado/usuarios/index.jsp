<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


<main role="main" class="container">

<h1>Listado de Usuarios</h1>


<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Email</th>
				<th>Password</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${usuarios}" var="usu">
	
			
			
			<tr>
			
				<td>${usu.id}</td>
				<td>${usu.email}</td>
				<td>${usu.password}</td>
			</tr>
			
			</c:forEach>
		</tbody>
	</table>




</main>

<%@ include file="../../includes/footer.jsp"  %>  