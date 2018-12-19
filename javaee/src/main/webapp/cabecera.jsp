<%@page import="com.ipartek.formacion.modelo.pojos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>

<style>
	nav{
		background-color: #CCC;
		color: #000;
		border-bottom:3px solid BEBEBE;
		padding: 10px;
	}
	
	#carrito{
	positio:fixed;
	top:0;
	right:0;
	}
</style>

<nav>
<%
	Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");
	if ( usuarioLogeado != null ){
%>
	
	
	<p><%=usuarioLogeado.getEmail() %></p>
	<a href="privado/index.jsp">Zona Privada</a><br>
	<a href="logout">Cerrar Session</a>
	

<% } else { %>

	<a href="login">Iniciar session</a>

<% } %>

<!-- carrito de la compra -->

<%
ArrayList<Video>carrito = (ArrayList<Video>)session.getAttribute("carrito");
if(carrito == null){
	carrito = new ArrayList<Video>();
}

//harcodear dos productos

carrito.add(new Video());
// mod constructor


%>
<div id="carrito">
<span class = "titulo">Carrito Compra</span>

<%if(carrito.isEmpty()){ %>
	<p>Todavia no hay productos</p>
<% }else{%>	


<%} %>
</div>

</nav>
