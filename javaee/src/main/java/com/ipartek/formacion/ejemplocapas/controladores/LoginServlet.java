package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.Coche;
import com.ipartek.formacion.modelo.pojos.Usuario;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VISTA_LOGIN = "login.jsp";
	private static final String VISTA_PRINCIPAL = "principal.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VISTA_LOGIN).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Usuario usuario = null;
		String vista = VISTA_LOGIN;
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
		
		try {
			
			UsuarioDAO dao = new UsuarioDAO();			
			usuario = dao.login(email, password);
			
			if ( usuario != null ) {
				vista = VISTA_PRINCIPAL;
				
				ArrayList<Usuario> usuariosValidos = dao.getAll();
				
				request.setAttribute("usuario", usuario);
				request.setAttribute("listado", usuariosValidos);
				
				
				ArrayList<String> usuariosNoValidos = dao.getAllNoValid();
				request.setAttribute("listadomal", usuariosNoValidos);
				
				//recuperamos la sesion
				HttpSession session= request.getSession();
				//tambine se puede configurar en el web.xml 
				session.setMaxInactiveInterval(60*5);//5min
				session.setAttribute("usuario_logeado", usuario);
				
				
				
				
				
				
				
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
