<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<style>
nav {
	background-color: #CCC;
	color: #000;
	border-bottom: 3px solid #BEBEBE;
	pading: 10px;
}
</style>
<nav>
	<%
		Usuario usuarioLogeado = (Usuario) session.getAttribute("usuario_logeado");

		if (usuarioLogeado != null) {
	%>

	<%=usuarioLogeado.getEmail()%>
	<a href="logout">Cerrar sesión</a>

	<%
		} else {
	%>
	<a href="login">Iniciar sesión</a>


	<%
		} //else
	%>
	<p>
		<a href="privado/index.jsp">Zona privada</a>
	</p>
</nav>
