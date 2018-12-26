package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.ArrayList;
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

import com.ipartek.formacion.modelo.pojo.Pagina;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Pagina> libro;
	private ValidatorFactory factory;
	private Validator validator;
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		
		factory  = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		
		
		libro = new  ArrayList<Pagina>();
		libro.add( new Pagina("lorem1", "autor1"));
		libro.add( new Pagina("lorem2", "autor2"));
		libro.add( new Pagina("lorem3", "autor3"));
		libro.add( new Pagina("lorem4", "autor4"));
		libro.add( new Pagina("lorem5", "autor5"));
		
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paginaActual = 1;
		int paginasTotal = libro.size();
		
		Pagina paginaMostrar = new Pagina();
		
		try {
		String pagina = request.getParameter("pagina");
		if ( pagina != null ) {
			paginaActual = Integer.parseInt(pagina);
			
			if(paginaActual<=0) {
				paginaActual=1;
			}
			
			if(paginaActual>paginasTotal) {
				paginaActual=1;
			}
			
			paginaMostrar = libro.get(--paginaActual);
		}else {
			paginaMostrar = libro.get(0);
		}
		}catch(Exception e) {
			request.setAttribute("alerta", "pagina no disponible");
			paginaMostrar = libro.get(0);
			paginaActual = 0;
		}finally {
			
			request.setAttribute("pagina", paginaMostrar);
			request.setAttribute("paginaActual", paginaActual);
			request.setAttribute("paginasTotal", libro.size() );
			
			request.getRequestDispatcher("index_real.jsp").forward(request, response);
			
		}
				
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String autor = request.getParameter("autor");
		String texto = request.getParameter("texto");
		
		Pagina p = new Pagina();
		int paginaActual = 0;
		
		try {
			
			p = new Pagina(autor,texto);
			
			
			Set<ConstraintViolation<Pagina>> violations = validator.validate(p);
			
			if(violations.isEmpty()) {
				libro.add(p);
			}else {
				request.setAttribute("alerta", "Por favor rellena el id, autor y texto");
			}
			paginaActual = libro.size();
			
		}catch(Exception e) {
			request.setAttribute("error", "error escribiendo pagina");
		}finally {
			request.setAttribute("pagina", p);
			request.setAttribute("paginaActual", --paginaActual);
			request.setAttribute("paginasTotal", libro.size());
			request.getRequestDispatcher("index_real.jsp").forward(request, response);
		}
	}
}
