<%@ include file="includes/cabecera.jsp" %>
<%@ include file="includes/menu.jsp" %>
<%@ include file="includes/mensajes.jsp" %>
    <div class="container">
    <h1>Usuarios Logueados</h1>
    <div class="jumbotron">
    <table class="table">
	<thead class="thead-dark">
       <tr>
      <th>Nombre</th>
      </tr>
      </thead>
      <tbody class="bg-success">
      <c:forEach items="${applicationScope.usuarios_logueados}" var="entry"> 
      <tr><td><c:out value="${entry.key}"/></td> </tr> 
      </c:forEach> 
      </tbody>
    </table>
    </div>
    </div>
<%@ include file="includes/pie.jsp" %>