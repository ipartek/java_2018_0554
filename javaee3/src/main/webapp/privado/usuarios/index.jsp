<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


    <main role="main" class="container">
		<div class="jumbotron">
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">id</th>
		      <th scope="col">Email</th>
		      <th scope="col">Password</th>
		      <th></th>	      
		    </tr>
		  </thead>
		  <tbody>
		 	 <c:forEach items="${usuarios}" var="u">
			    <tr>
			      <th scope="row">${u.id}</th>
			      <td>${u.email}</td>
			      <td>${u.password}</td>
			      <td><a href="privado/usuarios?op=2&id=${u.id}">Modificar / eliminar</a>
			      <a href="privado/usuarios?op=4&id=${u.id}"><span class="icon-bin"></span></a>
			      <button type="button" class="btn btn-outline-danger btn-block mt-4" data-toggle="modal" data-target="#exampleModal">
			 ELIMINAR
			</button>
	
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Atención</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        ¿Estás serguro de eliminar el registro?
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
			        <a href="privado/usuarios?op=4&id=${usuario.id}" class="btn btn-danger">Eliminar</a>
			      </div>
			    </div>
			  </div>
			</div></td>		      
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>
<a href="privado/usuarios?op=2&id=-1" class="btn btn-primary">Crear Nuevo Registro</a>
</div>
	</main>				


<%@ include file="../../includes/footer.jsp"  %>  