package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelos.daos.UsuarioDAO;
import com.ipartek.formacion.modelos.pojos.Usuario;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTA_LOGIN="login.jsp";
	private static final String VISTA_PRINCIPAL="principal.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = (String)request.getParameter("email");
		String password = (String)request.getParameter("password");
		Usuario usuario=null;
		ArrayList<Usuario> usuariosok=null;
		ArrayList<String> usuariosnook=null;
		String vista=VISTA_LOGIN;
		try {
			UsuarioDAO dao = new UsuarioDAO();
			usuario=dao.login(email,password);
			if(usuario  != null) {
				usuariosok= dao.getAllValidos();	
				usuariosnook= dao.getAllNoValidos();
				request.setAttribute("usuariosok", usuariosok);
				request.setAttribute("usuariosnook", usuariosnook);
				request.setAttribute("usuario", usuario);
				vista=VISTA_PRINCIPAL;
			}else {
				request.setAttribute("error", "Usuario No valido");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}
		
	}

}
