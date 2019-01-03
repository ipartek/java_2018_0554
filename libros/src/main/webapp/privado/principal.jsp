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
      <th scope="col">Comprar?</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${videos}" var="v">
    <tr>
      <td><a href="privado/videos?op=2&id=${v.id}&nombre=${v.nombre}&codigo=${v.codigo}">${v.nombre}</a></td>
      <td><iframe width="560" height="315" src="//www.youtube.com/embed/${v.codigo}" allowfullscreen=""></iframe></td>
      <td><a href="privado/comprar?idVideo=${v.id}">Añadir al carrito</a></td>
    </tr>
    </c:forEach>

  </tbody>
</table>


</div>
</main>
		




<%@ include file="../includes/footer.jsp"%>
