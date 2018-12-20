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
import com.ipartek.formacion.modelo.pojo.Usuario;




@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ENLACE_LOGIN="index.jsp";
	private static final String ENLACE_PRINCIPAL="/privado/videos";
	private UsuarioDAO dao;
	private ValidatorFactory factory;
	private Validator validator;
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		dao = UsuarioDAO.getInstance();
		
		//Crear Factoria y Validador
		  factory = Validation.buildDefaultValidatorFactory();
		  validator = factory.getValidator();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//drequest.getRequestDispatcher(ENLACE_LOGIN).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String vista = ENLACE_LOGIN;
		
		String email = request.getParameter("mail");
		String password = request.getParameter("pass");		
		
		
		try {
			Usuario usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setPassword(password);
			
			// se le pasa el pojo para k valide si las cumpel la coleccion violations estara vacio
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */
				
				String errores = "<ul>"; 
				 for (ConstraintViolation<Usuario> violation : violations) {
					 	
					 errores += "<li>" + violation.getPropertyPath() + ": " +violation.getMessage() + "</li>";
						
						// violation.getPropertyPath()
				 }
				 errores += "</ul>"; 
				//request.setAttribute("error", violations);
				request.setAttribute("error", errores);
			}else{
				    /* No tenemos ningun fallo, la Validacion es correcta */
			
					usuario = dao.login(email, password);
					
					if ( usuario != null ) {
						vista = ENLACE_PRINCIPAL;				
						request.setAttribute("usuario", usuario);
						HttpSession session= request.getSession(); 
						session.setMaxInactiveInterval(60*5);//5min
						session.setAttribute("usuario_logeado", usuario);
							
					}else {				
						request.setAttribute("error", "Credenciales incorrectas");				
					}	
			}		
					}catch (Exception e) {
						e.printStackTrace();
						
					}finally {
						response.sendRedirect("privado/videos");
						//request.getRequestDispatcher(vista).forward(request, response);
					}
		
		
		
	}

	

}
