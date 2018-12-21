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

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UsuarioDAO dao;
	private ValidatorFactory factory;
	private Validator validator;
	
	public static final String VIEW_LOGIN = "index.jsp";
	public static final String CONTROLLER_VIDEOS = "privado/videos";
	
       
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	dao = UsuarioDAO.getInstance();
    	//Crear Factoria y Validador
    	factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
    }

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
	}
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String view = VIEW_LOGIN;
		boolean redirect = false;
		
		try {
		
			// validar
			Usuario usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setPassword(pass);
			
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			
			
			if ( violations.size() > 0) {			// validacion NO PASA
				
				 String errores = "<ul>"; 
				 for (ConstraintViolation<Usuario> violation : violations) {					 	
					 errores += String.format("<li> %s : %s </li>" , violation.getPropertyPath(), violation.getMessage() );					
				 }
				 errores += "</ul>";				 
				request.setAttribute("mensaje", errores);				
				
			}else {                                // validacion OK
			
				usuario = dao.login(email, pass);
				
				if ( usuario == null ) {
					
					request.setAttribute("mensaje", "Credenciales incorrectas");
				}else {
					
					HttpSession session = request.getSession();
					session.setAttribute("usuario", usuario);
					redirect = true;					
				}
			}	
				
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
			if(redirect) {				
				response.sendRedirect(CONTROLLER_VIDEOS);
			}else {
				request.getRequestDispatcher(view).forward(request, response);
			}
		}
			
		
		
	}

	

}