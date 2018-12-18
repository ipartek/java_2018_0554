

<%@page import="com.ipartek.formacion.modelo.pojos.Disco"%>
<%@page import="java.util.ArrayList"%>


<%@ include file="cabecera.jsp"%>

<h1>Listado de Discos</h1>


<%
	ArrayList<Disco> discos = (ArrayList<Disco>) request.getAttribute("discos");
	String busqueda = (String) request.getAttribute("busqueda");
%>

<%
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

<form action="discos" method="post">
	<input type="text" name="busqueda" value="<%=busqueda%>" required>
	<input type="submit" value="filtrar">
</form>

<%
	if (discos.isEmpty()) {
%>
<p style="color: red;">No existen Discos todavia!!!</p>
<%
	} // if
%>


<ol>
	<%
		for (Disco disco : discos) {
	%>
	<li><%=disco.getTitulo()%></li>
	



	<%
		}
	%>
</ol>