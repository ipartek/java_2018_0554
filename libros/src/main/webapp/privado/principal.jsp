<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>



<main role="main" class="container">
<div class="jumbotron">


<table class="table">


  <thead>
    <tr>
      <th scope="col">Titulo</th>
      <th scope="col">Video</th>
      <th scope="col">Comprar?</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${videos}" var="vid">
    <tr>
      <th scope="row">${vid.nombre}</th>
      <td><iframe width="560" height="315" src="//www.youtube.com/embed/${vid.url}" allowfullscreen=""></iframe></td>
      <td><a href="comprar?idVideo=${vid.id}&tituloVideo=${vid.nombre}$urlVideo=${vid.url}=">Añadir al carrito</a></td>
    </tr>
    </c:forEach>

  </tbody>
</table>


</div>
</main>
		




<%@ include file="../includes/footer.jsp"%>
