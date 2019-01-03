<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>

  

<main role="main" class="container">
	<div class="jumbotron">
		<ul>
			<c:forEach items="${videos}" var="v">
				<li>${v.id} + ${v.nombre}</li>
			</c:forEach>
		</ul>
		<table  class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nombre</th>
				<th scope="col">Vídeo</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${videos}" var="v">
				<tr>
					<th scope="row">${v.id}</th>
					<td>${v.nombre}</td>
					<td><iframe width="560" height="315" src="https://www.youtube.com/embed/${v.codigo}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></td>
					<td><a href="privado/videos?op=2&id=${u.id}"><span class="icon-pencil2"></span></a> / <a href="privado/videos?op=4&id=${u.id}"><span class="icon-bin"></span></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</main>



  
<%@ include file="../../includes/footer.jsp"  %>  