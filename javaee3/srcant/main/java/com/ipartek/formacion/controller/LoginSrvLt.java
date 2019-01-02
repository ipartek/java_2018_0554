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

import com.ipartek.formacion.modelos.daos.UsuarioDAO;
import com.ipartek.formacion.modelos.pojos.Usuario;

@WebServlet("/login")
public class LoginSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO dao;
	private ValidatorFactory factory;
	private Validator validator;

	public void init(ServletConfig config) throws ServletException {
		dao = UsuarioDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuariof = request.getParameter("usuario");
		String passf = request.getParameter("pass");
		try {
			Usuario usuario = new Usuario();
			usuario.setEmail(usuariof);
			usuario.setPassword(passf);
			Set<ConstraintViolation<Usuario>> violations=validator.validate(usuario);
			if ( violations.size() > 0) {			
				
				 String errores = "<ul>"; 
				 for (ConstraintViolation<Usuario> violation : violations) {					 	
					 errores += String.format("<li> %s : %s </li>" , violation.getPropertyPath(), violation.getMessage() );					
				 }
				 errores += "</ul>";				 
				request.setAttribute("mensaje", errores);				
				
			}else {             
				
				usuario = dao.loginCorrecto(usuariof, passf);
				if (usuario != null) {
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(60 * 5);
					session.setAttribute("usuario_logueado", usuario);
					//request.getRequestDispatcher("principal.jsp").forward(request, response);
					//response.sendRedirect("pral");
					response.sendRedirect(request.getContextPath()+"/listadolistener.jsp");
				} else {
					request.setAttribute("error", "Login incorrecto");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
