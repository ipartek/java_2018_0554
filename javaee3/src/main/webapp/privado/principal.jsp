<%@ include file="../includes/cabecera.jsp" %>
<%@ include file="../includes/menu.jsp" %>
	<main role="main" class="container">
	<div class="jumbotron">
		<h1>Logueo realizado con éxito!</h1>
		<p class="lead">Bienvenido ${sessionScope.usuario_logueado.email}</p>
		<!-- <a class="btn btn-lg btn-primary" href="../../components/navbar/" role="button">View navbar docs &raquo;</a> -->
		<h3>Videos Registrados</h3>
		<table class="table">
		<thead class="thead-dark">
		<tr>
		<th>ID</th>
		<th>Nombre</th>
		<th>Ver Video</th>
		</tr>
		</thead>
		<tbody class="bg-light">
		<c:forEach items="${videos}" var="v">
		<tr>
  			<td>${v.id}</td> <td>${v.nombre}</td> 
  			<td><iframe width="200" height="100" 
  			src="https://www.youtube.com/embed/${v.url}" 
  			frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
  			allowfullscreen>
  			</iframe>
  			</td>
  		</tr>
 		</c:forEach>
 		</tbody>
 		</table>
<%@include file="../includes/pie.jsp"%>