<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


<main role="main" class="container">

<h1>Mis Videos</h1>


<a href="privado/videos?op=2&id=-1" class="btn btn-outline-success mb-2">Añadir Nuevo Video</a>



<table class="table table-striped">
		<thead>
			<tr>
			<th scope="col">Id</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Video</th>
		      <th scope="col">Usuario</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${videos}" var="v">
			    <tr>		    	
			      <th scope="row">${v.id}</th>
			      <td><a href="privado/videos?op=2&id=${v.id}">${v.nombre}</a></td>
			      <th scope="row">${v.codigo}</th>			      		      
			      <th scope="row">${v.usuario.email}</th>
			    </tr>    
		    </c:forEach>
		</tbody>
	</table>





</main>

<%@ include file="../../includes/footer.jsp"  %>  