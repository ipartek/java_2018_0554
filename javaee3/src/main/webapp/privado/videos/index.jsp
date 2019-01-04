<%@ include file="../../include/header.jsp"  %>
<%@ include file="../../include/navbar.jsp"  %>
<%@ include file="../../include/mensajes.jsp"  %>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
<h1 class="h2">Videos registrados: ${videos.size() }</h1>
<div class="btn-toolbar mb-2 mb-md-0">
<div class="btn-group mr-2">
<a href="privado/video?op=2&id=-1" class="btn btn-outline-info mb-2 mt-2">Insertar nuevo video</a>
</div> 
</div>
</div>

	<table class="table col-md-12">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">TITULO</th>
		      <th scope="col">CODIGO</th>
		      <th scope="col">VIDEO</th>
		      <th scope="col">USUARIO</th>		      
		    </tr>
		  </thead>
		  <tbody>
		 	 <c:forEach items="${videos}" var="video">
			    <tr>
			      <th scope="row" >${video.id}</th>
			      <td><a href="privado/video?op=2&id=${video.id}">${video.titulo}</a></td>
			      <td >${video.codigo}</td>	
			      <td>
			     	<div class="embed-responsive embed-responsive-16by9">
					 	 <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/${video.codigo}" allowfullscreen></iframe>
				</div>
					</td>	
					<td scope="row">${video.usuario.email}</td>      
			    	</tr>    
		    </c:forEach>
		  </tbody>
		</table>




<%@ include file="../../include/footer.jsp"  %>  