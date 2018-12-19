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
	#carrito{
		position:fixed;
		top:0;
		right: 0;
		background-color: teal;
		color: #FFF;
		width: 200px;
		height: 500px;
		padding: 5px 10px;
	}
	#carrito .titulo{
		text-align: center;
		text-transform: uppercase;
		font-weight: 600px;
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

	<%
		ArrayList<Perro> carrito = (ArrayList<Perro>) session.getAttribute("carrito");
	if( carrito== null){
		carrito = new ArrayList<Perro>();
		
	}
	
	//hardcodear dos productos
	//carrito.add(new Perro(1L, "Shih Tzu", "República Popular China, Tíbet", "https://petyzoo.com/wp-content/uploads/2017/10/shih-tzu-razas-perros-cuidados-alimentacion.jpg"));
	//carrito.add(new Perro(2L, "Golden retriever", "Reino Unido, Escocia, Inglaterra", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRn2vuFbLoH5pvd-9bsAtNX1ddZVnS2fU4TBrgA6eX_m5YGlqzusw"));
 
	%>
	<div id="carrito">
		<span class="titulo">Carrito compra</span>
		<%if(carrito.isEmpty()){ %>
			<p>Todavia no hay productos</p>
		<%}else{
			%><ol><% 
			for(Perro p:carrito){
			%>
			
				<li><%=p.getRaza() %></li>
			
		<%} //for 
		%></ol><%
		} //else%>
	</div>
	
	
	
	
	
	<p>
		<a href="privado/index.jsp">Zona privada</a>
	</p>

</nav>
