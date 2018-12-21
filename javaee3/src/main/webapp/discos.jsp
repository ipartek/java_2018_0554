<%@page import="com.ipartek.formacion.modelo.pojos.Disco"%>
<%@page import="java.util.ArrayList"%>

<h1>Listado de Discos</h1>

<!-- <form action="discos" method="get"> -->

<%
	ArrayList<Disco> discos = (ArrayList<Disco>)request.getAttribute("lista");
	
%>
	
</form>




<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Título</th>
				<th>Artista</th>
				<th>Portada</th>
				<th>Año</th>
			</tr>
		</thead>
		
		<tbody>
		
			<% for(Disco dis : discos) { 
			
			%>
			
			<tr>
				<th><%=dis.getId() %></th>
				<td><%=dis.getTitulo()%></td>
				<td><%=dis.getArtista()%></td>
				<td><%=dis.getPortada()%></td>
				<td><%=dis.getYear()%></td>
			</tr>
			
			<% } %>
		</tbody>
	</table>