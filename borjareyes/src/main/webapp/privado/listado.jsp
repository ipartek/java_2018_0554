<%@ include file="../includes/header.jsp" %>   
<%@ include file="../includes/navbar.jsp" %>  
<%@ include file="../includes/mensajes.jsp" %> 
<main class="container">

	<table class="table table-hover ">
		<tr>
			<th>Nombre del perro</th>
			<th>Numero de chip</th>
			<th></th>
		</tr>
		<c:forEach items="${perros}" var = "p">
		<tr>
			<td>${p.nombre } </td>
			<td>${p.chip} </td>
			<td> <a href="mostrarperro?chip=${p.chip}">más info.</a></td>
		</tr>
		</c:forEach>
	</table>

</main>
<%@ include file="../includes/footer.jsp" %>  