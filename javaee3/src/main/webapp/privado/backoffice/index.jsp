<%-- <%@ include file="../../includes/materialize/cabecera.jsp" %>
<%@ include file="../../includes/materialize/menu.jsp" %>
<%@ include file="../../includes/materialize/mensajes.jsp" %> --%>

<%@ include file="../../includes/cabecera.jsp" %>
<%@ include file="../../includes/menu.jsp" %>
<%@ include file="../../includes/mensajes.jsp" %>

	<main role="main" class="container">
	<div class="jumbotron">
		<h3>BackOffice</h3>
		<div class="row">
		<c:choose>
		  <c:when test="${n_usuarios == 0}">
		    <div class="alert alert-danger" role="alert">
		  		No hay usuarios registrados en la BD
			</div>
		  </c:when>
		  <c:otherwise>
		  <div class="col-6">
		 	<div class="card bg-warning">
				<div class="card-body"><p class="text-center"><strong>Usuarios registrados</strong></p> 
				<div class="text-center">${n_usuarios}</div>
				</div>
		 		<a class="btn btn-info m-2">Ir a usuarios</a>
		 	</div>
		  </div>
		  </c:otherwise>
		</c:choose>
		<c:choose>
		  <c:when test="${n_videos == 0}">
		    <div class="alert alert-danger" role="alert">
		  		No hay videos registrados en la BD
			</div>
		  </c:when>
		  <c:otherwise>
		  <div class="col-6">
		   <div class="card bg-success">
				<div class="card-body"><p class="text-center"><strong>Videos registrados</strong></p>
				<div class="text-center">${n_videos}</div>
				</div>
		 		<a class="btn btn-info m-2">Ir a Videos</a>
		 	</div>
		  </div>
		  </c:otherwise>
		</c:choose>
		</div>
	</div>
	</main>
<%@include file="../../includes/pie.jsp"%>
<%-- <%@include file="../../includes/materialize/pie.jsp"%> --%>