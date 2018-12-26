<!-- foreach Usuarios usuarios-->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@page import="java.util.ArrayList"%>


	${usuariosLogueados}
	
	
 <c:forEach items ="${usuariosLogueados}" var ="conectados">	
	<!--CLASE BOOTSTRAP PARA LISTAS class="" --><li >${conectados}</li>
	
	</c:forEach>
	
	
	<%-- <!--  CREAR NUEVO USUARIO-->
	
	<h2>Crear Nuevo USuario</h2>
	<form action="usuarios" method="post">
	
	<!--  NUEVO: aseguramos los campos rellenados en caso de error-->
	
		<input type="text" name="id" value="<%=(request.getAttribute("id")==null)?"":request.getAttribute("id")%>" placeholder="identificodor"><br>

	
		<input type="text" name="email" placeholder="tu@email.com" value="<%=(request.getAttribute("email")==null)?"":request.getAttribute("email")%>"><br/>
		
	
		<input type="text" name="password" value="<%=(request.getAttribute("password")==null)?"":request.getAttribute("password")%>" placeholder="contraseña"><br>
		
		
		
		<input type="submit" value="CREAR">
	</form> --%>