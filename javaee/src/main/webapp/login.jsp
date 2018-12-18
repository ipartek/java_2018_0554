<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="cabecera.jsp"%>

	<form action="login" method="post">
		<fieldset>
			<legend>Login</legend>

			<p>
				<label for="email">Email</label> <input type="email" name="email"
					id="email" value="danielzallo@gmail.com" />
			</p>
			<p>
				<label for="password">Password</label> <input type="password"
					name="password" id="password" value="Daniel1234." />
			</p>
			<p>
				<button>Login</button>
				<%=request.getAttribute("error") != null ? request.getAttribute("error") : ""%>
				<%=session.getAttribute("sesionNoIniciada") != null ? session.getAttribute("sesionNoIniciada") : ""%>
			</p>
		</fieldset>
	</form>

</body>
</html>