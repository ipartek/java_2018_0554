package com.ipartek.formacion.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ipartek.formacion.modelo.pojos.Perro;

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
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("pass");
		
		
		try {
					
					HttpSession session = request.getSession();				
					session.setMaxInactiveInterval(60*5);
					session.setAttribute("usuario", usuario);
												
					
				}catch (Exception e) {			
					e.printStackTrace();
				}finally {
					if(!usuario.equals("scobby")) {
						response.sendRedirect("login.jsp");
					}else {
						response.sendRedirect("privado/principal.jsp");
					}
				}
				
				
	}

}
