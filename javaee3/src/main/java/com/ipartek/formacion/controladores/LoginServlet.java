package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

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

import com.ipartek.formacion.modelo.pojo.Video;
import com.ipartek.formacion.modelo.dao.UsuarioDao;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTA_LOGIN = "index.jsp";
	private static final String VISTA_PRINCIPAL = "privado/videos";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//Crear Factoria y Validador
		 ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		 Validator validator = factory.getValidator();
		
		
		String vista = VISTA_LOGIN;
		
		try {
		
			// validar
			Usuario usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setPassword(password);
			
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			
			
			if ( violations.size() > 0) {			// validacion NO PASA
				
				 String errores = "<ul>"; 
				 for (ConstraintViolation<Usuario> violation : violations) {
					 	
					 errores += "<li>" + violation.getPropertyPath() + ": " +violation.getMessage() + "</li>";
						
						// violation.getPropertyPath()
				 }
				 errores += "</ul>"; 
				request.setAttribute("errores", violations);
				request.setAttribute("mensaje", errores);
				
			}                              // validacion OK

				//Recojemos el usuario de la base de datos
				UsuarioDao dao = UsuarioDao.getInstance();
				usuario = dao.login(email, password);
				
				if(usuario!=null) {
					vista = VISTA_PRINCIPAL;
					ArrayList<Usuario> usuarios = dao.getAll();
					
					request.setAttribute("usuarios", usuarios);
					
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(60 * 5);// 5 mins, tambien en WEB.xml
					session.setAttribute("usuarioLogeado", usuario);
					
				}else {
					request.setAttribute("error", "Usuario No valido"); 
				}
				
				
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			if(vista.equals("privado/videos")) {
				response.sendRedirect(vista);
			}else {
			request.getRequestDispatcher(vista).forward(request, response);
			}
		}
	}
}
