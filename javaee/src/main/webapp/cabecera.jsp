<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<style>
nav {
	background-color: #CCC;
	color: black;
	margin-bottom: 3px solid BEBEBE;
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
</body>