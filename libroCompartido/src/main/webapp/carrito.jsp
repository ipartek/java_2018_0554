<%@ include file="includes/cabecera.jsp" %>
<%@ include file="includes/menu.jsp" %>
<%-- <%@ include file="includes/mensajes.jsp" %> --%>
<div class="container">
	<div class="jumbotron">
	<h1>Todos los gatos</h1>
	<c:forEach items="${gatos}" var="g">
  	<div class="container border-top border-info p-3">
  		<h2 class="display-4"><c:out value="${g.nombre}"/></h2>
  		<ul>
  			<li><c:out value="${g.raza}"/></li>
  			<li><c:out value="${g.color}"/></li>
  			<li><c:out value="${g.peso}"/></li>
  		</ul>
  		<img src="${g.imagen}" width="200px" height="150px">
  		<form action="${pageContext.request.contextPath}/carrito?id=${g.id}" method="POST">
  			<input class="btn btn-success mt-3" type="submit" value="Añadir al carrito">
  		</form>
  	</div>
 	</c:forEach>
	</div>
</div>
<%@ include file="includes/pie.jsp" %>