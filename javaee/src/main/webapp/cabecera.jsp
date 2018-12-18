<%@page import="com.ipartek.formacion.modelos.pojos.Usuario"%>
<style>
	nav{
		background-color: #CCC;
		color: #000;
		boder-bottom: 3px solid BEBEBE;
	}
</style>
<nav>
<%
	Usuario usuariolog=(Usuario)session.getAttribute("usuario_logueado");
%>


<%
	if(usuariolog!=null){%>
		<p><%=usuariolog.getEmail() %></p>
		<p><a href="carrito">Ver carrito de la compra</a></p>
		<a href="logout">Cerrar sesion</a>	
<%	}else{ %>
		<a href="login">Iniciar sesion</a>
<%	}%>
</nav>