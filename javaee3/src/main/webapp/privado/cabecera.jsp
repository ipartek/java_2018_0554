<%@page import="com.ipartek.formacion.modelo.pojos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<style>
nav {
	background-color: #ccc;
	color: #000;
	margin-bottom: 3px solid BEBEBE;
}
#carrito{
position:fixed;
top:0;
right:0;
background-color: teal;
color: #FFF;
width: 200px;
height: 500px;
padding: 5px 10px;
}

#carrito .titulo{
text-align: center;
text-transform: uppercase;
font-weight: bold;
}

</style>
<%
	Usuario usuarioLogeado = (Usuario) session.getAttribute("usuario_logeado");

	if (usuarioLogeado != null) {
%>
<nav>
	<p><%=usuarioLogeado.getEmail()%></p>
	<a href="logout">Cerrar sesion</a>
</nav>

<%
	} //cierre if 
	else {
%>
<nav>
	<a href="login">Iniciar sesion</a>
</nav>

<%
	} //cierre else
%>




<!-- Carrito de la compra -->
<%
	ArrayList<Video> carrito = (ArrayList<Video>) session.getAttribute("carrito");
	if (carrito == null) {
		carrito = new ArrayList<Video>();
	}
	
	//harcodear productos
	//carrito.add(new Video());
	//carrito.add(new Video("otro video"));

%>



<div id="carrito">
	<span class="titulo">Carrito compra</span>
	<%
		if (carrito.isEmpty()) {

			out.print("<p>Todavia no hay productos</p>");
	
		} else {
			out.print("<ol>");
			for (Video v: carrito){
			%>	
				<li><%=v.getNombre() %></li>
			
			<%}
		}
	%>
</div>