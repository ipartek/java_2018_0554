<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>
<%@include file="cabecera.jsp" %>
<form>
	<fieldset>
		<legend>Dime quien eres</legend>
		
		<p>
			<label for="nombre">Nombre</label>
			<input name="nombre" id="nombre" />
		</p>
		<p>
			<button>Saludar</button>
		</p>
	</fieldset>
</form>

<h1>Hola <%= request.getParameter("nombre") != null ? request.getParameter("nombre") : "Mundo" %></h1>

</body>
</html>