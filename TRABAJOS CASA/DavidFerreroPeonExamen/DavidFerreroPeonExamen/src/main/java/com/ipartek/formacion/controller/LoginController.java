package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ipartek.formacion.modelo.pojo.LoginPojo;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	// variables
	private static final long serialVersionUID = 1L;
	private static final String VISTA_EMPEZAR = "login.jsp";
	private static final String VISTA_ACCESO = "home";

	// array list , objetos
	private static ArrayList<LoginPojo> usuarios;

	LoginPojo usuario = new LoginPojo();

	@Override
	public void init(ServletConfig config) throws ServletException { // PREGUNTAR QUE METODO ES ESTE Y PORQUE METO EL
																		// ARRAYLIST AQUI.
		super.init(config);
		usuarios = new ArrayList<LoginPojo>();
		usuarios.add(new LoginPojo("scobby", "galletas"));

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VISTA_EMPEZAR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vista = VISTA_EMPEZAR;

		// recoger parametros
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String idioma = request.getParameter("idioma");

		try {

			usuario.setEmail(email);
			usuario.setPassword(password);

			HttpSession session = request.getSession();

			// mi validacion // al no saber usar validator

			for (LoginPojo f : usuarios) {
				if (f.getEmail().equals(email) && f.getPassword().equals(password)) {
					vista = VISTA_ACCESO;
					session.setAttribute("usuarioEmail", usuario.getEmail()); // // para mostrar usuario
					session.setAttribute("usuario", usuario); // para logout // tambien para validator pero aun no se
																// usarlo

				} else if (f.getEmail().equals(email) && f.getPassword().equals(password) == false) {
					vista = VISTA_EMPEZAR;
					request.setAttribute("error", " Password incorrecto");
				} else if (f.getEmail().equals(email) == false && f.getPassword().equals(password)) {
					vista = VISTA_EMPEZAR;
					request.setAttribute("error", " Email incorrecto");
				} else if (f.getEmail().equals(email) == false && f.getPassword().equals(password) == false) {
					vista = VISTA_EMPEZAR;
					request.setAttribute("error", " Email y password incorrectos");
				}
				session.setAttribute("idioma", idioma);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}

	}
}
