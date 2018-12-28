package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final String INDEX_JSP = "index.jsp";
	private static final String ZONA_PRIVADA = "privada/principal.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vista = INDEX_JSP;
		String nombre = request.getParameter("usuario");
		String password = request.getParameter("pass");
		
		Usuario usuario = new Usuario(1L, nombre, password);
		
		if (usuario != null) {
			if ("scobby".equals(usuario.getNombre()) && "galletas".equals(usuario.getPassword())) {
				vista = ZONA_PRIVADA;
				HttpSession session = request.getSession();
				session.setAttribute("usuario_logueado", usuario);
			}else {
				request.setAttribute("mensaje", "Los datos introducidos no son correctos");
			}
		}
		
		if ("index.jsp".equals(vista)) {
			request.getRequestDispatcher(vista).forward(request, response);
		}else {
			response.sendRedirect(vista);
		}
		
	}

}
