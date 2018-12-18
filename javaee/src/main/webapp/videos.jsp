
<%@page import="java.util.ArrayList"%>
<h1>Listado Videos</h1>


<%
ArrayList<String> videos=(ArrayList<String>)request.getAttribute("videos");
String busqueda = (String)request.getAttribute("busqueda");

%>





<ol>




<form>

<input type="text" name="busqueda" value="busqueda" required />
</form>
<% 
	for(String video: videos){
		%>
		<li><%=video %>
		

		
		
	}

%>
</ol>