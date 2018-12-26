
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Listado de usuarios logeados</h2>



<c:forEach items="${usuariosLogeados}" var="usuariolog">

	<p>${usuariolog}</p>
	<p></p>

</c:forEach>