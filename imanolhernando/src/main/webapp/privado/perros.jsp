<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">CHIP</th>
      <th scope="col">NOMBRE</th>
      <th scope="col">RAZA</th>
      <th scope="col">DETALLE</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${perros}" var="perro">
  <tr>
      <th scope="row">${perro.chip } </th>
      <td>${perro.nombre }</td>
      <td>${perro.raza }</td>
      <td><a href="privado/perros?chip=${perro.chip }">Detalle</a></td>
    </tr>
    </c:forEach> 
  </tbody>
</table>