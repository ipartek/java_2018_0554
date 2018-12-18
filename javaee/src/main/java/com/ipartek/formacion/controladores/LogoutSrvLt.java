package com.ipartek.formacion.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.removeAttribute("usuario-logueado");
		session.invalidate();
		session=null;
		response.sendRedirect("login");
		
	}

}
