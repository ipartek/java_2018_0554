<%@page import="com.ipartek.formacion.modelo.pojos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
 
 <style>
 	nav{
 		background-color:#CCC
 		color: #000;
 		border-bottom: 3px solid BEBEBE;
 	}
 	
 	#carrito{
 		position:fixed;
 		color: #000;
 		top:0;
 		right:0;
 		background-color:teal;
 		padding: 5px 10px;
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



<!-- carrito compra -->

<%
 
	ArrayList<Video> carrito = (ArrayList<Video>)session.getAttribute("carrito");
	if ( carrito == null ){
		carrito = new ArrayList<Video>();
	}
	
%>

<div id="carrito">
	<span class="titulo">Carrito Compra</span>
	
	<% if ( carrito.isEmpty() ){
		out.print("<p>Todavia no hay productos</p>");
	   }else{ 
			out.print("<ol>");
			for( Video v : carrito ){
				%>
					<li><%=v.getNombre()%></li>
				<%
			} // for
			out.print("</ol>");
	 } // else
	%>
</div>




</nav>