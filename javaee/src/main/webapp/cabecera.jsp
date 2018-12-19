<%@page import="com.ipartek.formacion.modelo.pojos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<style>
nav {
	background-color: #CCC;
	color: black;
	margin-bottom: 3px solid BEBEBE;
}
/* #carrito {
	position: fixed;
	background-color: teal;
	color: #FFF;
	top: 0;
	bottom: 0;
	width: 200px;
	height: 500px;
	padding: 5px 10px;
} */

#carrito .titulo {
	text-align: center;
	text-transform: uppercase;
}
</style>
<body>
	<nav>
		<%
			Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario_logueado");
			if (usuarioLogueado != null) {
		%>
		<p><%=usuarioLogueado.getEmail()%></p>
		<a href="logout">Cerrar Sesión</a>
		<%
			} else {
		%>
		<a href="login.jsp">Iniciar Sesión</a>
		<%
			}
		%>
	</nav>
	<!-- carrito de la compra -->
	<%
		ArrayList<Video> carrito = (ArrayList<Video>) session.getAttribute("carrito");
		if (carrito == null) {
			carrito = new ArrayList<Video>();
		}
		carrito.add(new Video());
	%>
	<div id="carrito">
		<span class="titulo">Carrito compra</span>
		<%
			if (carrito.isEmpty()) {
		out.print("<p>Todavía no hay productos</p>");
			} else {
				for (Video v : carrito) {
						out.print("<li>");
						v.getNombre();
						out.print("</li>");
				}
			}
		%>
	</div>
</body>