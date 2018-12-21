<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>

  

    <main role="main" class="container">
      <div class="jumbotron">
      
		 <table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">Id</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Video</th>
		    </tr>
		  </thead>
			
			<tbody>
			<c:forEach items="${videos}" var="v">
				<tr>
			      <th scope="row">${v.id}</th>
			      <td>${v.nombre}</td>
			      <td><iframe width="150" 
												        height="150" 
												        src="https://www.youtube.com/embed/${v.url}" 
												        frameborder="0" 
												        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
												        allowfullscreen></iframe></td>
			    </tr>
			</c:forEach>
			</tbody>
      	 </table>
      </div>
    </main>

  
<%@ include file="../includes/footer.jsp" %> 