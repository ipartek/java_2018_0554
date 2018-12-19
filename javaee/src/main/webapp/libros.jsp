
<%@page import="com.ipartek.formacion.modelo.pojos.Libro"%>
<%@page import="java.util.ArrayList"%>

<%@ include file="cabecera.jsp"%>

<h1>Listado Libros</h1>

<%

	ArrayList<Libro> libros = (ArrayList<Libro>)request.getAttribute("libros");
	String busqueda = (String)request.getAttribute("busqueda");

%>

<% 
	if ( busqueda != null ){
		%>
<p>
	Resultado para la busqueda: <b><%=busqueda%></b>
</p>
<% 
	}else{
		busqueda = "";
	}
%>

<form action="libros" method="post">
	<input type="text" name="busqueda" value="<%=busqueda%>" required>
	<input type="submit" value="filtrar">
</form>

<form action="carritoLibros" method="post">
<ol>
	<%
		for( Libro libro: libros){
	%>
	<li>
		<ul>
			<li><%=libro.getNombre()%></li>
			<li><%=libro.getAutor()%></li>
			<li><img alt="<%=libro.getNombre()%>"
				src="<%=libro.getImagen()%>" width="150" height="200"></li>
			<li><input type="checkbox" name="carrito?id=<%=libro.getId()%>" /> <label
				for="compra+<%=libro.getId()%>">Comprar</label></li>
		</ul>
	</li>
	<%}%>
</ol>
</form>
