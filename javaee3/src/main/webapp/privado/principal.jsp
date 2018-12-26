<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>



 
      <div class="container">
        <h1>Listado Videos</h1>
        <table class="table table-dark table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Video</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${videos}" var="v">
      <tr>
        <td>${v.id}</td>
        <td>${v.nombre}</td>
        <td><iframe width="350" height="250" src="https://www.youtube.com/embed/${v.url}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></td>
								
								
								
      </tr>
      </c:forEach>
    </tbody>
  </table>
  </div>

 




<%@ include file="../includes/footer.jsp"%>
