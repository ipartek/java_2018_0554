<%@ include file="../../includes/cabecera.jsp" %>
<%@ include file="../../includes/menu.jsp" %>
	<main role="main" class="container">
	<div class="jumbotron">
		<h3>Usuarios Registrados</h3>
		<table class="table">
		<thead class="thead-dark">
		<tr>
		<th>ID</th>
		<th>Email</th>
		<th>Password</th>
		</tr>
		</thead>
		<tbody class="bg-light">
		<c:forEach items="${usuarios}" var="u">
		<tr>
  			<td>${u.id}</td> <td>${u.email}</td> <td>${u.password}</td> 
  			
  		</tr>
 		</c:forEach>
 		</tbody>
 		</table>
	</div>
	</main>
<%@include file="../../includes/pie.jsp"%>