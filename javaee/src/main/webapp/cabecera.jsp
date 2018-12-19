<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Videos"%>
<%@page import="java.util.ArrayList"%>
<style>
	nav{
		background-color: #CCC;
		color: #000;
		border-bottom:3px solid BEBEBE;
		padding: 10px;
	}
	
	#carrito{
	position:fixed;
	top:0;
	right:0;
	background: teal;
	width: 200px;
	height: 200px;
	}
	
	#carrito .titulo{
	
	text-align:center;
	font-weight: 15px;
	
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

<a href="calculadora.jsp">Ejemplo Calculadora</a>
<a href="calcular">Ejemplo Calculadora</a>
<a href="privado/index.jsp"></a>


<!--  carrito de la compra-->
<!--  -->


<%
ArrayList<Videos> carrito = (ArrayList<Videos>)session.getAttribute("carrito");
if ( carrito == null ){
	carrito = new ArrayList<Videos>();
}

carrito.add(new Videos());
carrito.add(new Videos("otro video"));
%>

<div id="carrito">
	<span class="titulo">Carrito Compra</span>
	
	<% if ( carrito.isEmpty() ){
		out.print("<p>Todavia no hay productos</p>");
	   }else{ 
			out.print("<ol>");
			for( Videos v : carrito ){
				%>
					<li><%=v.getTitulo()%></li>
				<%
			} // for
			out.print("</ol>");
	 } // else
	%>
</div>

</div>
</nav>