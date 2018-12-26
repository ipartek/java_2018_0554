package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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

import com.ipartek.formacion.modelo.pojo.Pagina;

/**
 * Servlet implementation class PaginaController
 */
@WebServlet("/pagina")
public class PaginaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidatorFactory factory;
	private Validator validator;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext appContext = request.getServletContext();
		
		HashMap<Long, Pagina> paginas = (HashMap<Long, Pagina>) appContext.getAttribute("paginas");
		
		String autor = request.getParameter("autor");
		String texto = request.getParameter("texto");
		
		Pagina pagina = new Pagina((long) paginas.size() + 1, autor, texto);
		
		Set<ConstraintViolation<Pagina>> violations = validator.validate(pagina);
		
		if (violations.isEmpty()) {
			paginas.put(pagina.getId(), pagina);
			appContext.setAttribute("paginas", paginas);
			request.setAttribute("creacion", "Página creada con éxito");
			request.getRequestDispatcher("libro").forward(request, response);
		}else {
			request.setAttribute("alerta", "Existen fallos en los datos para la creación de la nueva página");
			request.getRequestDispatcher("privado/pagina.jsp").forward(request, response);
		}
		
		
		
	}

}
