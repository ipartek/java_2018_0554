package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import com.ipartek.formacion.modelo.pojo.Perro;
import com.ipartek.formacion.modelo.pojo.Usuario;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VISTA_LOGIN = "index.jsp";
	private static final String VISTA_PRINCIPAL = "privado/principal.jsp";
	private ValidatorFactory factory;
	private Validator validator;
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VISTA_LOGIN).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = null;
		String vista = VISTA_LOGIN;

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			
			usuario = new Usuario();
			usuario.setId(1L);
			usuario.setEmail(email);
			usuario.setPassword(password);
			//validar			
		    Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
		    if ( violations.isEmpty() ) {
		    	if (email.equals("scooby") && password.equals("galletas")) {
					vista = VISTA_PRINCIPAL;

		
					
//					guardar el usuario en sesion
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(60 * 60); // 1 hora
					session.setAttribute("usuario_logeado", usuario);

//					crear el array de perros y guardarlo en sesion
					ArrayList<Perro> perros = new ArrayList<Perro>();
					
					perros.add(new Perro("scooby", 4L, "pitbull", 25L, true, "32-4444-2014", "X582464.9|Y321464.9"));
					perros.add(new Perro("lur", 1L, "pastor", 19L, true, "32-1424-2016", "X582464.9|Y321464.9"));
					perros.add(new Perro("doggy", 3L, 30L, false, "93-0449-2017", "X582464.9|Y321464.9"));
					perros.add(new Perro("lalala", 2L, 45L, false, "73-0449-2017", "X582464.9|Y321464.9"));
					
					session.setAttribute("perros", perros);

				} else {
					request.setAttribute("mensaje", "Usuario no valido");
				}
		    	
		    }else {
		    	
		    	request.setAttribute("mensaje", "Los campos introducidos no cumplen los requisitos minimos de formato");
		    }


			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}

	}

}
