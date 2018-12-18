<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String mensaje = (String) request.getAttribute("mensaje");
		if (mensaje != null) {
	%>

	<p style="color: red"><%=mensaje%></p>
	<%
		}
	%>
<%@ include file="cabecera.jsp" %>
	<form action="Calculator" method=GET>

		<!--   <form action="Calculator" method=POST> -->

		<label for="text">op1</label> <input type=text name="op1" id="op1" />

		<label for="text">op2</label> <input type="text" id="op2" name="op2" />


		<button>Enviar</button>


	</form>
</body>
</html>