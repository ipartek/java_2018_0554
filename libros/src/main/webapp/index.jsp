<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Pagina"%>




<h1>funciona</h1>

<c:forEach items="${libro}" var="pagina">

	<h1>${pagina.autor}</h1>
	<p>${pagina.texto}</p>
</c:forEach>