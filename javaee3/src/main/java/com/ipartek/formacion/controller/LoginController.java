package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTA_LOGIN = "index.jsp";
	private static final String VISTA_PRINCIPAL = "principal.jsp";

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
		Usuario usuario = null;
		String vista = VISTA_LOGIN;
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		try {
			
			UsuarioDAO dao = new UsuarioDAO();
			
			usuario = dao.login(email, pass);
			
			if (usuario != null) {
				vista = VISTA_PRINCIPAL;
			}else {
				request.setAttribute("mensaje", "Usuario erróneo '" + email + "'");
			}
			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60 * 5); // 5 min, también se puede configurar en WEB.XML [Para configurarlo para toda aplicación]
			session.setAttribute("usuario_logueado", usuario);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}
		
		
	}

}
