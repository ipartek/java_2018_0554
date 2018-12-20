package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelos.daos.UsuarioDAO;
import com.ipartek.formacion.modelos.pojos.Usuario;

@WebServlet("/login")
public class LoginSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuariof = request.getParameter("usuario");
		String passf = request.getParameter("pass");
		HttpSession session = request.getSession();
		Usuario usuario = null;
		try {
			UsuarioDAO dao = new UsuarioDAO();
			usuario = dao.loginCorrecto(usuariof, passf);
			if (usuario != null) {
				session.setMaxInactiveInterval(60 * 5);
				session.setAttribute("usuario_logueado", usuario);
				request.getRequestDispatcher("principal.jsp").forward(request, response);
			} else {
				request.setAttribute("error","Login incorrecto");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
