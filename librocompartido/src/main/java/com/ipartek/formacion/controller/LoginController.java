package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.daos.UsuarioDAO;
import com.ipartek.formacion.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	

	private static final long serialVersionUID = 1L;
	
	private static final String LOGIN_JSP = "login.jsp";
	private static final String PRIVADO_INSERTAR_JSP = "privado/insertar.jsp";
	
	
	private UsuarioDAO dao;
	private ValidatorFactory factory;
	private Validator validator;
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
    	dao = UsuarioDAO.getInstance();
    	factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String view = LOGIN_JSP;
		boolean redirect = false;
		try {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60*10);
			// validar
			Usuario usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setPassword(pass);
			
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if ( violations.size() > 0) {			
				 String errores = "<ul>"; 
				 for (ConstraintViolation<Usuario> violation : violations) {					 	
					 errores += String.format("<li> %s : %s </li>" , violation.getPropertyPath(), violation.getMessage() );					
				 }
				 errores += "</ul>";				 
				request.setAttribute("error", errores);				
				
			}else {                               
				usuario = dao.login(email, pass);
				if ( usuario == null ) {
					request.setAttribute("error", "Credenciales incorrectas");
				}else {
					session.setAttribute("usuario_logeado", usuario);
					redirect = true;					
				}
			}	
	
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
			if(redirect) {				
				response.sendRedirect(PRIVADO_INSERTAR_JSP);
			}else {
				request.getRequestDispatcher(view).forward(request, response);
			}
		}
			
		
		
	}

	
	
	
	
	
	
	
	
	
	
}
