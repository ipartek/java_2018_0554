<%@page import="com.ipartek.formacion.modelo.pojos.Usuario,
com.ipartek.formacion.modelo.pojos.Video, java.util.ArrayList" %>

<style>
nav {
	background-color: #CCC;
	color: #000;
	margin-bottom: 3px solid BEBEBE;
}

#carrito{
	position: fixed;
	top:0px;
	right: 0px;
	background-color: teal;
	color: #FFF;
	width: 200px;
	height: 500px;
	padding: 5px 10px;
}
</style>

<nav>
	<ul>
		<li>
			<%
				Usuario usuarioLogeado = (Usuario) session.getAttribute("usuario_logeado");

				if (usuarioLogeado != null) {
			%>
			<nav>
				<p><%=usuarioLogeado.getEmail()%></p>
				<a href="logout">Cerrar Sesión</a>
			</nav> <%
			 	} else {
			 %> <a href="login">Iniciar</a> <%
			 	}
			 %>
		</li>

	</ul>
	
<!-- carrito compra -->

<% ArrayList<Video> carrito = (ArrayList<Video>)session.getAttribute("carrito");
	if(carrito == null){
		carrito = new ArrayList<Video>();
	}
	
	//harcodear dos productos
	/* carrito.add(new Video());
	carrito.add(new Video()); */
%>

<div id="carrito">
	<span class="titulo">Carrito compra</span>
	<% if(carrito.isEmpty()){ %>
		<p>Todavía no hay productos</p>
	<%}else{
		for( Video v: carrito){%>
			<li><%=v.getNombre() %>
		<%}
	}%>
</div>
	
	
	
</nav>