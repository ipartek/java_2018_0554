<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>



<main role="main" class="container">


<h1>Listado de Discos</h1>

<a href="privado/disco?op=2&id=-1" class="btn btn-outline-success mb-2">Añadir Nuevo Disco</a>

<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Título</th>
				<th>Artista</th>
				<th>Portada</th>
				<th>Año</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${disco}" var="dis">
	
			
			
			<tr>
			
				<th>${dis.id}</th>
				<td><a href="privado/disco?op=2&id=${dis.id}">${dis.titulo}</td>
				<td>${dis.artista}</td>
				<td><img width=150 height=150 class="rounded mx-auto d-block" src=" ${dis.portada}" alt="${dis.titulo}"></td>
				<td>${dis.year}</td>
			</tr>
			
			</c:forEach>
		</tbody>
	</table>
	
</main>	
	
	<%@ include file="../../includes/footer.jsp"%>