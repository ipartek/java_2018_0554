<%@ include file="../includes/cabecera.jsp"%>
<%@ include file="../includes/navbar.jsp" %>

 <main role="main" class="container p-3 ">
      <div class="jumbotron">
        <h1>Videos almacenados</h1>
        <table class="table-striped col-md-12">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Video/url</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${videos}" var="video">
				<tr>
					<td>${video.id}</td>
					<td>${video.nombre}</td>
					<td><iframe width="500" height="150"
							src="https://www.youtube.com/embed/${video.url}" frameborder="0"
							allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
							allowfullscreen></iframe></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
        
        </div>
    </main>

<%@ include file="../includes/footer.jsp"%>