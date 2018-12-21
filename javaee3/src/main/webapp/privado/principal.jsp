<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>USUARIO SESSION ${usuario}</p>

<a href="${pageContext.request.contextPath}/logout">LOGOUT</a>


<h1>Principal</h1>

<ol>
	<c:forEach items="${videos}" var="v">
		<li>${v.id} + ${v.nombre}</li>
	</c:forEach>
</ol>



