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
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelo.pojos.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ArrayList<Usuario> usuarios;   
    Usuario usuario = new Usuario();
    
    private ValidatorFactory factory;//validation api
	private Validator validator;//validation api
    

    @Override
	public void init(ServletConfig config) throws ServletException {  	
	super.init(config);
    	usuarios = new ArrayList <Usuario>();
    	usuarios.add(new Usuario("scobby","galletas"));
    
    	
    	
    	factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
    }
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombreusuario = request.getParameter("nombre");
		String pass = request.getParameter("password");
		
		
		
		try {
			
			usuario.setNombre(nombreusuario);
			usuario.setPassword(pass);
			
			
			HttpSession session = request.getSession();
			for ( Usuario u : usuarios){
				
				if(u.getNombre().equals(nombreusuario) && u.getPassword().equals(pass)) {
				request.getRequestDispatcher("privado/principal.jsp").forward(request, response);
				session.setAttribute("nombreUsuario",usuario.getNombre());
				session.setAttribute("usuario", usuario);
				
			}else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();		
		}finally {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

}
}
