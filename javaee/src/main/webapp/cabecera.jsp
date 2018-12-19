<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>

<style>
nav {
	background-color: #CCC;
	color: #000;
	margin-bottom: 3px solid BEBEBE;
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
</nav>