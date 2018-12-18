
<%@page import="com.ipartek.formacion.modelo.pojos.Coche"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@include file="cabecera.jsp" %>
<h1>Listado Coches</h1>

<%

	ArrayList<Coche> coches = (ArrayList<Coche>)request.getAttribute("coches");
	String busqueda = (String)request.getAttribute("busqueda");

%>

<% 
	if ( busqueda != null ){
		%>
			<p>Resultado para la busqueda: <b><%=busqueda%></b></p>
		<% 
	}else{
		busqueda = "";
	}
%>

<form action="Coche" method="post">
	<input type="text" name="busqueda" value="<%=busqueda%>" required>
	<input type="submit" value="filtrar">
</form>
<%
	if(coches.isEmpty())
	//if (videos.size()==0)
	{
		
%>
	<p style="color:red">No existen videos</p>
<% } //endif %>
<table border=1>
	<tr>
		<th>ID</th>
		<th>Marca</th>
		<th>Modelo</th>
		<th>Imagen</th>
		<th>Comprar</th>
	</tr>
	<%
		for( Coche coche: coches){
			%>
					<tr>
						<td><%=coche.getId()%></td>
						<td><%=coche.getMarca()%></td>
						<td><%=coche.getModelo()%></td>
						<td><img width="200px" height="140px" src="<%=coche.getImagen()%>" alt="texto alt"></td>
						<td><a href="comprar?idCoche=<%=coche.getId()%>&marcaCoche=<%=coche.getMarca()%>&modeloCoche=<%=coche.getModelo()%>&imagenCoche<%=coche.getImagen()%>">Añadir al carrito</a></td>
					</tr>

			<%	
		}	
	%>
</table>

