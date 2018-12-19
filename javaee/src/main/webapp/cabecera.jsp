<%@page import="com.ipartek.formacion.modelo.pojos.Gato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<nav class="navbar navbar-default">
<%
	Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario_logueado");
	ArrayList<Gato> gatosComprados = (ArrayList<Gato>) session.getAttribute("gatosComprados");
	
	if(gatosComprados == null){
		gatosComprados = new ArrayList<Gato>();
	}
	//Harcodear dos productos
	
	gatosComprados.add(new Gato(4L, "Raza", "Color", "Nombre", 0.0, "Imagen"));
	gatosComprados.add(new Gato(5L, "Raza2", "Color2", "Nombre2", 0.0, "Imagen2"));

	
	
	if (usuarioLogueado != null) {
%>
	<div class="container-fluid bg-warning">
	<p><%=usuarioLogueado.getEmail()%></p>
	<a href="privado/index.jsp">Zona Privada</a>
	<a href="logout">Cerrar Sesión</a>
	</div>
	<div id="carrito" class="bg-danger col-md-6 col-md-offset-6">
		<span class="titulo">Carrito Compra</span>
		
		<%if(gatosComprados.isEmpty()){ %>
			<p>Todavía no hay productos</p>
		<%}else{ %>
		<ol>
			<% for( Gato g : gatosComprados){ %>
			<li><%= g.getNombre() %></li>
			<%} }%>
		</ol>
	</div>
<%
	}else {
%>
<div class="container-fluid bg-warning">
<a href="login">Iniciar Sesión</a>
</div>
<%
	}
%>
</nav>