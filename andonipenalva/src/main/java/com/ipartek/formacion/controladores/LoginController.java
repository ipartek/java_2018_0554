package com.ipartek.formacion.controladores;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelos.pojos.PojoException;
import com.ipartek.formacion.modelos.pojos.Usuario;

@WebServlet("/login")

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String apellidos = request.getParameter("apellidos");
		Usuario usuario;

		try {
			usuario = new Usuario(null, nombre, password, apellidos);
		} catch(PojoException e) {
			
			if(nombre != null && password != null) {
				request.setAttribute("error", "Error en el formato del nombre o contraseña");
			}

			request.getRequestDispatcher("index.jsp").forward(request, response);

			return;
		}

		if("scooby".equals(usuario.getNombre()) && "galletas".equals(usuario.getPassword())) {
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

			
//			usuarios.add(new Usuario(2L, "pepe@perez.com", "Pa$$w0rd"));

			request.setAttribute("usuarios", usuarios);

			request.getSession().setAttribute("usuario", usuario);

			request.getRequestDispatcher("privado/menu.jsp").forward(request, response);
		} else {
			//response.sendRedirect("login.jsp");
			request.setAttribute("error", "No tienes permiso para login");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		//response.getWriter().println("Hola " + usuario.getEmail());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

