<%

	//redireccion, otra solucion es declarar web.xml => welcome file list
	response.sendRedirect( request.getContextPath() + "/login");

%>