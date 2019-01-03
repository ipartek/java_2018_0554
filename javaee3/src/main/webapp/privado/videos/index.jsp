<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


<main role="main" class="container">

<h1>Mis Videos</h1>


<a href="privado/videos?op=2&id=-1" class="btn btn-outline-success mb-2">Añadir Nuevo Video</a>

<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Video</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${listado}" var="vid">
	
			
			
			<tr>
			
				<th scope="row">${vid.id}</th>
				<td><a href="privado/videos?op=2&id=${vid.id}">${vid.nombre}</a></td>
				<td><iframe width="350" height="250" src="https://www.youtube.com/embed/${vid.codigo}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></td>
			</tr>
			
			</c:forEach>
		</tbody>
	</table>





</main>

<%@ include file="../../includes/footer.jsp"  %>  