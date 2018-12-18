<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
 
 <style>
 	nav{
 		background-color:#CCC
 		color: #000;
 		border-bottom: 3px solid BEBEBE;
 	}
 
 </style> 

<nav> 
<%

Usuario usuarioLogeado = (Usuario)session.getAttribute("usuarioLogeado");

if(usuarioLogeado!=null){
	

%>

	
		<p><%usuarioLogeado.getEmail(); %></p>
		<a href="logout">Cerrar sesion</a>
	
	


<%} else{ %>

	<a href="login">Iniciar sesion</a>

<%}//else  %>
</nav>