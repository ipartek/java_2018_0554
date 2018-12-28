package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		if(email.equals("scobby") && password.equals("galletas")) {
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
			usuarios.add(new Usuario(1L, "scobby", "galletas"));
			
			
			request.setAttribute("usuarios", usuarios);
			
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", usuario);
			request.getRequestDispatcher("/privado/principal.jsp").forward(request, response);
			
		} else {
			//response.sendRedirect("login.jsp");
			request.setAttribute("error", "No tienes permiso para login");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
