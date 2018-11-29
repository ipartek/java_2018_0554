package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplocapas.pojos.PojoException;
import com.ipartek.formacion.ejemplocapas.pojos.Usuario;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario;
		
		try {
			usuario = new Usuario(null, email, password);
		} catch(PojoException e) {
			//response.sendRedirect("login.jsp");
			request.setAttribute("error", "Error en el formato de email o contraseña");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		if("javier@lete.com".equals(usuario.getEmail()) && "Pa$$w0rd".equals(usuario.getPassword())) {
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
			usuarios.add(new Usuario(1L, "javier@lete.com", "Pa$$w0rd"));
			usuarios.add(new Usuario(2L, "pepe@perez.com", "Pa$$w0rd"));
			
			request.setAttribute("usuarios", usuarios);
			
			request.getSession().setAttribute("usuario", usuario);
			
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		} else {
			//response.sendRedirect("login.jsp");
			request.setAttribute("error", "No tienes permiso para login");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		//response.getWriter().println("Hola " + usuario.getEmail());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
