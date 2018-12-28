<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>


<h1>Listado de Perros</h1>


<table class="table table-striped">
		<thead>
			<tr>
				
				<th>Chip</th>
				<th>Nombre</th>
				<th>Raza</th>
				
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${perro}" var="perr">
	
			
			
			<tr>			
				<td>${perr.chip}</td>
				<td>${perr.nombre}</td>
				<td>${perr.raza}</td>				
			</tr>
			
		
			
			</c:forEach>
		</tbody>
	</table>
	
	<%@ include file="../includes/footer.jsp"%>