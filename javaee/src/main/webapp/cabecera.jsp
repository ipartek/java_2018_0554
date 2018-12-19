<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Coche"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Video"%>
<style>
nav{
	background:#CCC;
	color:#000;
	padding:20px;
	border-bottom: 3px solid black;
	margin-bottom:20px;

}
#carrito{
position:fixed;
top:0;
right:0;
background:teal;
color:#FFF;
width:200px;
height:500px;
padding: 5px 10px;
}
#carrito .titulo{
	font-weight: bold;
	text-transform:uppercase;
}
</style>

<nav>
<%

	Usuario usuario_logeado = (Usuario)session.getAttribute("usuario_logeado");
	if(usuario_logeado!=null){
%>

<%=usuario_logeado.getEmail() %>
<a href="logout">Cerrar Sesion</a>



<%}else{%>	
<a href="login">Iniciar sesion</a>
	<%}%>
	
	
	<a href="privado/index.jsp">Zona Privada</a>

<!-- CARRITO DE LA COMPRA -->
<% 
//aki utiliza la variable implicita de session k es el mismo objeto k la session de login servlet
ArrayList<Video> carrito = (ArrayList<Video>)session.getAttribute("carrito") ;
if(carrito == null){
	carrito = new ArrayList<>();
	//harcodear los productos simular que ya hay algo en el carrito
	//carrito.add(new Video());
	//carrito.add(new Video("otro"));
}
%>

<div id="carrito">
	<span class="titulo">Carrito Compra</span>
<%if(carrito.isEmpty()){%>
<p>Carrito Vacío</p>
	
<%} else{
	out.print("<ol>");
	for(Video v: carrito){
		%>
		<li><%=v.getNombre() %>
		<%
	}	
	out.print("</ol>");
}%>
</div>
	
	
	
</nav>	