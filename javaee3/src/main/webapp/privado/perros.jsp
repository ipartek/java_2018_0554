<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>

  

<main role="main" class="container">
	<div class="jumbotron">
		<ul>
			<c:forEach items="${perros}" var="p">
				<li>${p.id} ${p.raza} <img src="${p.img}" alt="${p.raza}" width="300"></li>
			</c:forEach>
		</ul>
	</div>
	
	<table  class="table table-striped">
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">Raza</th>
				<th scope="col">Imagen</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${perros}" var="p">
				<tr>
					<th scope="row">${p.id}</td>
					<td>${p.raza}</td>
					<td><img src="${p.img}" alt="${p.raza}" width="300"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</main>
  
<%@ include file="../includes/footer.jsp"  %>  