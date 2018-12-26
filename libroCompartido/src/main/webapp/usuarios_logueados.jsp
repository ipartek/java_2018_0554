<%@ include file="includes/cabecera.jsp" %>
<%@ include file="includes/menu.jsp" %>
<%@ include file="includes/mensajes.jsp" %>
       <table>
       <tr>
      <th>Nombre</th>
      </tr>
      <c:forEach items="${applicationScope.usuarios_logueados}" var="ul">
        <tr>
          <td><c:out value="${ul.email}" /><td>
        </tr>
      </c:forEach>
    </table>
<%@ include file="includes/pie.jsp" %>