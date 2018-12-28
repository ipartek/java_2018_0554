<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>

<main role="main" class="container">
      <div class="jumbotron">
      	<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">Nombre</th>
		      <th scope="col">Raza</th>
		    </tr>
		  </thead>
			
			<tbody>
			<c:forEach items="${perros}" var="p">
				<tr>
			      <th scope="row">${p.nombre}</th>
			      <td>${p.raza}</td>
			    </tr>
			</c:forEach>
			</tbody>
      	 </table>
		
      </div>
    </main>
    
    
    
<%@ include file="../includes/footer.jsp" %> 