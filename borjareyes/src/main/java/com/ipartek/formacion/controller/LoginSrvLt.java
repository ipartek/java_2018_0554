package com.ipartek.formacion.controller;

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

import com.ipartek.formacion.modelos.Perro;
import com.ipartek.formacion.modelos.Usuario;

@WebServlet("/login")
public class LoginSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidatorFactory factory;
	private Validator validator;
	ArrayList<Perro> perros;
	Usuario usuario;

	@Override
	public void init() throws ServletException {
		super.init();
		perros= new ArrayList<Perro>();
		perros.add(new Perro("rodolfo",3,"dogo",5.6,false,"55-4562-2016"));
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usu = request.getParameter("usu");
		String pass = request.getParameter("pass");
		
		

		try {
			usuario = new Usuario(usu,pass);
			
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			
			if (violations.size() > 0) {	
				
				request.setAttribute("error", "Los formatos introducidos en usuario y/o contraseña no son correctos");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				if ("scooby".equals(usuario.getUsuario()) && "galletas".equals(usuario.getPassword())) {
					HttpSession session = request.getSession();

					session.setMaxInactiveInterval(60 * 5);
					session.setAttribute("usuario", usuario);
					
					request.getServletContext().setAttribute("perros", perros);

					request.getRequestDispatcher("/privado/principal.jsp").forward(request, response);
				}else {
					request.setAttribute("error", "Usuario y/o contraseña incorrecto(s)");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}


		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
