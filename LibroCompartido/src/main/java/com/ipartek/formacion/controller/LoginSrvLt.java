package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelos.pojos.Usuario;

@WebServlet("/login")
public class LoginSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Usuario> usuarios;
	Usuario usuario;

	@Override
	public void init() throws ServletException {
		super.init();
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario(1, "uno@uno.com", "Pa$$w0rd"));
		usuarios.add(new Usuario(2, "dos@dos.com", "Pa$$w0rd"));
		usuarios.add(new Usuario(3, "tres@tres.com", "Pa$$w0rd"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usu = request.getParameter("usu");
		String pass = request.getParameter("pass");
		usuario = null;

		for (Usuario u : usuarios) {
			if (u.getEmail().equals(usu) && u.getPassword().equals(pass)) {
				usuario = u;
				break;
			}
		}
		if (usuario != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60 * 5);
			session.setAttribute("usuario", usuario);

			request.getRequestDispatcher("edicion.jsp").forward(request, response);

		} else {
			request.setAttribute("error", "Credenciales no válidas");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
