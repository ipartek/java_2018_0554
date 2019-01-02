<%@ include file="../../includes/cabecera.jsp" %>
<%@ include file="../../includes/menu.jsp" %>
<%@ include file="../../includes/mensajes.jsp" %>
	<main role="main" class="container">
	<div class="jumbotron">
		<h3>Usuarios Registrados</h3>
		<table class="table">
		<thead class="thead-dark">
		<tr>
		<th>ID</th>
		<th>Email</th>
		<th>Password</th>
		<th>Editar/Borrar</th>
		<th><a href="privado/usuarios?op=2&id=-1" class="btn btn-success">Crear Nuevo</a></th>
		</tr>
		</thead>
		<tbody class="bg-light">
		<c:forEach items="${usuarios}" var="u">
		<tr>
  			<td>${u.id}</td> <td>${u.email}</td> <td>${u.password}</td> <td colspan="2"><a href="privado/usuarios?op=2&id=${u.id}" class="btn btn-info">Editar/Borrar</a></td>
  			
  		</tr>
 		</c:forEach>
 		</tbody>
 		</table>
	</div>
	</main>
<%@include file="../../includes/pie.jsp"%>