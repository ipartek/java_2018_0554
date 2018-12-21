<%@ include file="includes/header.jsp" %>   
<%@ include file="includes/navbar.jsp" %>  
<%@ include file="includes/mensajes.jsp" %>   
    <main role="main" class="container">
      <div class="jumbotron">
	       <table class="table table-hover ">
				<thead class="thead-dark">
					<tr>
						<th class="align-middle">ID</th>
						<th class="align-middle">raza</th>
						<th class="align-middle">Imagen</th>
						<!-- <th>&nbsp;</th>-->
					</tr>
				</thead>
				<tbody>
					<c:choose>
					<c:when test="${listado.size()!=0}">
						<c:forEach items="${listado}" var="p">
							<tr>
								<th scope="row " class="align-middle">${p.id}</th>
								<td class="align-middle">${p.raza}</td>
								<td class="align-middle"><img width=150 height=150 src="${p.imagen}" alt="Imagen ${p.raza}"></td>
								<!-- <td><a href="carrito?id=">Comprar</a></td> -->
							</tr>
						</c:forEach>
					</c:when>
						<c:otherwise>
							<tr>
								<th class="align-middle" scope="row">NO</th>
								<td class="align-middle">EXISTEN</td>
								<td class="align-middle">PERROS</td>
							</tr>
						</c:otherwise>
					</c:choose>
	
				</tbody>
			</table>
		       
      </div>
    </main>
<%@ include file="includes/footer.jsp" %>  