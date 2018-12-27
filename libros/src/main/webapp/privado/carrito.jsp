<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>



<main role="main" class="container">
<div class="jumbotron">
<h1>Carrito</h1>

<table class="table">


  <thead>
    <tr>
      <th scope="col">Titulo</th>
      <th scope="col">Video</th>

    </tr>
  </thead>
  <tbody>
  <c:forEach items="${carrito}" var="vid">
    <tr>
      <th scope="row">${vid.nombre}</th>
      <td><iframe width="560" height="315" src="//www.youtube.com/embed/${vid.url}" allowfullscreen=""></iframe></td>
     
    </tr>
    </c:forEach>

  </tbody>
</table>


</div>
</main>
		




<%@ include file="../includes/footer.jsp"%>
