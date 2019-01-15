<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


    <main role="main" class="container">
	
		<a href="privado/categorias?op=2&id=-1" class="btn btn-outline-success mb-2">Crear Nueva categoría</a>
		
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">id</th>
		      <th scope="col">nombre</th>
		    </tr>
		  </thead>
		  <tbody>
		 	 <c:forEach items="${categorias}" var="c">
			    <tr>		    	
			      <th scope="row">${c.id}</th>
			      <td><a href="privado/categorias?op=2&id=${c.id}">${c.nombre}</a></td>
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>


	</main>				


<%@ include file="../../includes/footer.jsp"  %>  