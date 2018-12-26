package com.ipartek.formacion.libroCompartido.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libroCompartido.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
	private static final String VIEW_LOGIN = "login.jsp";
	private static final String CONTROLER_CREARPAGINA = "privado/nuevaPagina";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		 usuariosRegistrados.add(new Usuario(1L, "Manolo", "Manolo1234."));
		 usuariosRegistrados.add(new Usuario(2L, "Pepe", "Pepe1234."));
		 usuariosRegistrados.add(new Usuario(3L, "Daniel", "Daniel1234."));
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario= request.getParameter("usuario");
		String password =request.getParameter("pass");
		String vista = VIEW_LOGIN;
		Usuario usuarioLogeado= null;
		try {
			
			for (Usuario u : usuariosRegistrados) {
				if(u.getUsuario().equals(usuario)) {
					if(u.getPassword().equals(password)) {
						usuarioLogeado = u;
						
						HttpSession session = request.getSession();
						session.setMaxInactiveInterval(60 * 5); // 5minutos
						session.setAttribute("usuarioLogeado", usuarioLogeado);
						vista= CONTROLER_CREARPAGINA;
						return;
						
					}
				}
			} 
			
			if(usuarioLogeado == null) {
				request.setAttribute("alerta", "Credenciales incorrectas");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (vista.equals(CONTROLER_CREARPAGINA)) {
				response.sendRedirect(CONTROLER_CREARPAGINA);
			} else {
				request.getRequestDispatcher(vista).forward(request, response);
			}

		}
		
	}

}
