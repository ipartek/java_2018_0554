package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.Usuario;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String usuario = request.getParameter("usuario");
		String pass = request.getParameter("pass");
		*/
		
		/*request.setAttribute("video",new Video());
		request.setAttribute("mensaje", "usuario erroneo" + usuario );
		*/
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = null;
		String vista = "index.jsp";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
		
		try {
			
			UsuarioDAO dao = new UsuarioDAO();			
			usuario = dao.login(email, password);
			
			if ( usuario != null ) {
				vista = "principal.jsp";
				
				ArrayList<Usuario> usuariosValidos = dao.getAll();
				
				request.setAttribute("usuario", usuario);
				request.setAttribute("listado", usuariosValidos);
				
				
				//guardar usuario en session
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval( 60 * 5 ); // 5 min, tambien se puede configurar en WEB.XML
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
