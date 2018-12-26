package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.pojos.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//TODO usuario dao
	private ValidatorFactory factory;
	private Validator validator;
	
	
	public static final String VIEW_LOGIN = "index.jsp";
	public static final String CONTROLLER_LIBROS = "privado/libros";
	
	//TODO
	 /*@Override
	    public void init(ServletConfig config) throws ServletException {    
	    	super.init(config);
	    	dao = UsuarioDAO.getInstance();
	    	//Crear Factoria y Validador
	    	factory  = Validation.buildDefaultValidatorFactory();
	    	validator  = factory.getValidator();
	    }*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String view = VIEW_LOGIN;
		boolean redirect = false;
		
	try {	
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
		
		if(validarUsuario(usuario)) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("privado/libro").forward(request, response);
		} else {
			//TODO: Errores
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	
	
	}catch (Exception e) {
		
		e.printStackTrace();
	}finally {
		
		if(redirect) {				
			response.sendRedirect(CONTROLLER_LIBROS);
		}else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}
	}
	private boolean validarUsuario(Usuario usuario) {
		//TODO: Poner lista de usuarios
		return true;
	}

}