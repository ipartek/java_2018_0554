package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.ConnectionManager;
import com.ipartek.formacion.modelo.dao.UsuarioDao;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LoginServlet.class);
	
	private UsuarioDao dao;
	private ValidatorFactory factory;
	private Validator validator;
	
	public static final String VIEW_LOGIN = "index.jsp";
	//public static final String CONTROLLER_VIDEOS = "privado/videos";
	
       
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	dao = UsuarioDao.getInstance();
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
		String idioma = request.getParameter("idioma");
		String view = VIEW_LOGIN;
		boolean redirect = false;
		
		try {
			
			HttpSession session = request.getSession();
		
			//idioma  TODO ver porque no funciona con Euskera
			Locale locale = new Locale("eu_ES");
			ResourceBundle messages = ResourceBundle.getBundle("i18nmessages", locale );
			LOG.debug("idioma=" + idioma);		
			
			//guardar cookie
			Cookie cIdioma = new Cookie("cIdioma", idioma);
			cIdioma.setMaxAge(60*10); //TODO poner que no expire nunca			
			response.addCookie(cIdioma);
			
			
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
					
					request.setAttribute("mensaje", messages.getString("login.incorrecto"));
				}else {
					
					
					session.setMaxInactiveInterval(60*5);
					// asociamos un listener para listar usuarios @see UsuariosListener
					session.setAttribute("usuarioLogeado", usuario);
					session.setAttribute("idioma", idioma );
					redirect = true;					
					LOG.debug("guardamos en session usuario e idioma");			
				}
			}	
				
			
		}catch (Exception e) {			
			LOG.error(e);
		}finally {
			
			if(redirect) {				
				response.sendRedirect( request.getContextPath() + "/privado/usuarios");
			}else {
				request.getRequestDispatcher(view).forward(request, response);
			}
		}
			
		
		
	}

	

}
