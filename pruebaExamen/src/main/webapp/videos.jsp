<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>

<main role="main" class="container">

<h1>Listado Videos</h1>

<%
	ArrayList<String> videos = (ArrayList<String>) request.getAttribute("videos");
	String busqueda = (String) request.getAttribute("busqueda");
%> <%
 	if (busqueda != null) {
 %>
<p>
	Resultado para la busqueda: <b><%=busqueda%></b>
</p>
<%
	} else {
		busqueda = "";
	}
%>

<form action="videos" method="post">
	<input type="text" name="busqueda" value="<%=busqueda%>" required>
	<input type="submit" value="filtrar">
</form>

<ol class="list-group">
	<%
		for (String video : videos) {
	%>
	<span class="border border-primary">

		<li class="list-group p-3"><%=video%></li>
	</span>

	<%
		}
	%>
</ol>

</main>

<%@ include file="../includes/footer.jsp"%>