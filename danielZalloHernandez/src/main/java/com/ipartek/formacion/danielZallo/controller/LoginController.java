package com.ipartek.formacion.danielZallo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.danielZallo.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
	private static final String VIEW_LOGIN = "login.jsp";
	private static final String CONTROLLER_PRINCIPAL = "privado/principal";
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		usuariosRegistrados.add(new Usuario(1L, "scobby", "galletas", "Do"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//le mandamos el login.jsp
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("pass");
		
			String vista = VIEW_LOGIN;
			Usuario usuarioLogeado= null;
			
			try {
				
				for(Usuario user: usuariosRegistrados) {
					if(user.getUsuario().equals(usuario)) {
						if(user.getPassword().equals(password)) {
							usuarioLogeado = user;
							
							HttpSession session = request.getSession();
							
							session.setMaxInactiveInterval(60*5); //5 minutos
							session.setAttribute("usuario", usuarioLogeado);
							
							vista=CONTROLLER_PRINCIPAL;
							return;
							
						}
					}
				}
				
				if(usuarioLogeado == null) {
					request.setAttribute("alerta", "Ese usuario no existe, introduzca uno que si exista");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(vista.equals(CONTROLLER_PRINCIPAL)) {
					response.sendRedirect(CONTROLLER_PRINCIPAL);
				}else {
					request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
				}
			}
	}

}
