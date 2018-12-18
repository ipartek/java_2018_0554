<%@page import="com.ipartek.formacion.modelo.pojos.Perro"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<Perro> perrosCarro = (ArrayList<Perro>) session.getAttribute("carro");

		if (usuarioLogeado != null) {
	%>

	<%=usuarioLogeado.getEmail()%>
	<a href="logout">Cerrar sesión</a>
	
	<h2>Carrito  de la compra</h2>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Raza</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Perro p : perrosCarro) {
			%>
			<tr>

				<th><%=p.getId()%></th>
				<td><%=p.getRaza()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

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
