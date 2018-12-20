<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

${usuario}
<h1>Listado videos</h1>


<ol>
	<c:forEach items="${videos}" var="video">
	<li>${video.nombre}</li>
	</c:forEach>
	
</ol>

