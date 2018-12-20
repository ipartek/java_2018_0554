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
#carrito table{
	color:white;
}
#carrito table a{
	color: coral;
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
//se crea la coleccion de videos con la variable implicita de session que recoge lo que contiene sesion y se getAttribute carrito
//SESSION ES UNA VARIABLE IMPLICITA DE JSP
ArrayList<Video> carrito = (ArrayList<Video>)session.getAttribute("carrito") ;
//Si es igual a nulo, no existe
if(carrito == null){
	//se instacia carrito
	carrito = new ArrayList<>();
	// se simulaba unos productos añadidos al carrito
	//harcodear los productos simular que ya hay algo en el carrito
	//carrito.add(new Video());
	//carrito.add(new Video("otro"));
}
%>

<div id="carrito">
	<span class="titulo">Carrito Compra</span>
	
<%--si carrito esta vacio --%>

<%if(carrito.isEmpty()){%>

<p>Carrito Vacío</p>
	
<%} else{
	out.print("<table>");
	for(Video v: carrito){
		%>
		<tr><td><%=v.getNombre() %></td><td><a href="#">Borrar</a></td>
		<%
	}	
	out.print("</table>");
}%>



<%if(carrito.isEmpty()){%>

<%} else{%>
		<form action="carrito" method="post">
			<%for(Video v: carrito){%>
			<p><label for="id"><%=v.getNombre() %> </label>
			<input type="hidden" name="id" value="<%=v.getId() %>" />
			<button>Quitar</button>
			</p>
			<%}%>
		</form>
<%}%>
</div>


	
	
	
</nav>	