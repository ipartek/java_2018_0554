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

import com.ipartek.formacion.modelos.pojos.Pagina;
import com.ipartek.formacion.modelos.pojos.Usuario;

@WebServlet("/nuevapag")
public class NuevapagSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL = "pagina?pag=";
	
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
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String texto = request.getParameter("texto");
		String direccion = URL;
		HttpSession session = request.getSession();
		ArrayList<Pagina> libro = (ArrayList<Pagina>) request.getServletContext().getAttribute("libro");
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Pagina pagina;
		if (texto != null && texto != "") {
			if (texto.length() < 50) {
				direccion += 0;
				request.setAttribute("error", "minimo 50 caracteres");
			} else {
				pagina = new Pagina();
				
				pagina.setAutor(usuario.getNombre());
				Set<ConstraintViolation<Pagina>> violations = validator.validate(pagina);
				if (violations.isEmpty()) {
					libro.add(pagina);

					direccion += libro.size() - 1;
					request.getServletContext().setAttribute("libro", libro);
					
				}else {
					request.setAttribute("error","hay algun error con tu texto" );
				}
				
			}

		} else {
			direccion += 0;
			request.setAttribute("error", "No se ha escrito ningun texto");

		}
		request.getRequestDispatcher(direccion).forward(request, response);

	}

}
