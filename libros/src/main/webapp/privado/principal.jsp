<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>



<main role="main" class="container">
<div class="jumbotron">
<a href="privado/videos?op=2&id=-1">Crear nuevo video</a>
<h1>Videos</h1>
<table class="table">


  <thead>
    <tr>
      <th scope="col">Titulo</th>
      <th scope="col">Video</th>
      <th scope="col">Propietario</th>
      <th scope="col">Comprar?</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${videos}" var="vid">
    <tr>
      <td><a href="privado/videos?op=2&id=${vid.id}&nombre=${vid.nombre}&codigo=${vid.codigo}">${vid.nombre}</a></td>
      <td><iframe width="360" height="215" src="//www.youtube.com/embed/${vid.codigo}" allowfullscreen=""></iframe></td>
      <td>${vid.usuario.email}</td>
      <td><a href="privado/comprar?idVideo=${vid.id}">Añadir al carrito</a></td>
    </tr>
    </c:forEach>

  </tbody>
</table>


</div>
</main>
		




<%@ include file="../includes/footer.jsp"%>
