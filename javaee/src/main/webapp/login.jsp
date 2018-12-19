<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%@ include file="cabecera.jsp" %>
 <a href="privado/index.jsp">Zona privada</a>
<form action="login" method="post">
	<fieldset>
		<legend>Login</legend>
		
		<p>
			<label for="email">Email</label>
			<input type="email" name="email" id="email" value="ander@solana.com" />
		</p>
		<p>
			<label for="password">Password</label>
			<input type="password" name="password" id="password" value="Pa$$w0rd" />
		</p>
		<p>
			<button>Login</button>
			<p><%= request.getSession().getAttribute("navegador") != null ? request.getSession().getAttribute("navegador") : "" %></p>
			<p><%= request.getSession().getAttribute("error") != null ? request.getSession().getAttribute("error") : "" %></p>
			<p><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>
		</p>
	</fieldset>
</form>

</body>
</html>