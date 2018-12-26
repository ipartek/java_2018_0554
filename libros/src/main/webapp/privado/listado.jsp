<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

 <meta http-equiv="refresh" content="5 ;URL='http://localhost:8080/javaee3/privado/listado.jsp'" />
 <!-- Recargar la pagina -->
 <p>Recargar cada 5 segundos</p>
${usuariosLogeados }
<table class="table">


  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Email</th>
      <th scope="col">Password</th>

    </tr>
  </thead>
  <tbody>
  <c:forEach items="${usuariosLogeados}" var="usuarioLog">
    <tr>
      <th scope="row">${usuarioLog.id}</th>
      <td>${usuarioLog.email}</td>
      <td>${usuarioLog.password}</td>
    </tr>
    </c:forEach>
<%--         <tr>
      <th scope="row">${usuario.id}</th>
      <td>${usuario.email}</td>
      <td>${usuario.password}</td>
    </tr> --%>
  </tbody>
</table>




<%@ include file="../includes/footer.jsp"%>