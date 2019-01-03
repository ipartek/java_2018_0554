<%@ include file="../../includes/cabecera.jsp"%>
<%@ include file="../../includes/navbar.jsp" %>

 <main role="main" class="container p-3 ">
     <%@ include file="../../includes/mensajes.jsp" %>
      <div class="jumbotron">
        <h1>Listado de videos</h1>
         <a class="btn btn-primary mt-3 mb-3" href="privado/videos?op=2&id=-1">Nuevo Video</a>
        
        <table class="table-striped col-md-12">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Video/url</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${videos}" var="v">
				<tr>
					<td>${v.id}</td>
					<td>${v.nombre}</td>
					<td><iframe width="500" height="150"
							src="https://www.youtube.com/embed/${v.codigo}" frameborder="0"
							allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
							allowfullscreen></iframe></td>
					<td><a class="btn btn-warning btn-block" href="privado/videos?op=2&id=${v.id}">Editar/Eliminar</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
        
        </div>
    </main>

<%@ include file="../../includes/footer.jsp"%>