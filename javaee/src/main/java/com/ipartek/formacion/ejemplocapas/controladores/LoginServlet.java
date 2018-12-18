package com.ipartek.formacion.ejemplocapas.controladores;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.UsuarioDao;
import com.ipartek.formacion.modelo.pojos.PojoException;
import com.ipartek.formacion.modelo.pojos.Usuario;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTA_LOGIN = "login.jsp";
	private static final String VISTA_PRINCIPAL = "principal.jsp";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);	
		
//		if("javier@lete.com".equals(usuario.getEmail()) && "Pa$$w0rd".equals(usuario.getPassword())) {
//			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//			
//			usuarios.add(new Usuario(1L, "javier@lete.com", "Pa$$w0rd"));
//			usuarios.add(new Usuario(2L, "pepe@perez.com", "Pa$$w0rd"));
//			
//			request.setAttribute("usuarios", usuarios);
//			
//			request.getSession().setAttribute("usuario", usuario);
//			
//			request.getRequestDispatcher("principal.jsp").forward(request, response);
//		} else {
//			//response.sendRedirect("login.jsp");
//			request.setAttribute("error", "No tienes permiso para login");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		}
//		//response.getWriter().println("Hola " + usuario.getEmail());
//	}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		Usuario usuario = null;
		String vista = VISTA_LOGIN;
		
		try{
			UsuarioDao dao = new UsuarioDao();
			usuario = dao.login(email, password);
			
			if(usuario!=null) {
				vista = VISTA_PRINCIPAL;
				ArrayList<Usuario> usuariosValidos = dao.getAll();
				
				request.setAttribute("usuario", usuario);
				request.setAttribute("listado", usuariosValidos);
				
				ArrayList<String> usuariosNoValidos = (ArrayList<String>)dao.getAllNoValid();
				request.setAttribute("listadoNo", usuariosNoValidos);
				
				//guardar usuario en la session
				
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(60 * 5);// 5 mins, tambien en WEB.xml
				session.setAttribute("usuarioLogeado", usuario);
				
			}else{
				request.setAttribute("error", "Usuario No valido"); 
			}
		}catch(Exception e) {
			
		}finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}
		
		
		
	}

}
