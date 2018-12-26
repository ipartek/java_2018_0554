package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojo.Libro;
import com.ipartek.formacion.modelo.pojo.Pagina;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/libro")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<Long, Pagina> paginas;
	private Libro libro;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		paginas = new HashMap<Long, Pagina>();
		paginas.put(1L, new Pagina(0L, "Peter", "Lorem ipsum dolor sit amet, consectetur turpis duis."));
		paginas.put(1L, new Pagina(1L, "Ander", "Lorem ipsum dolor sit amet, consectetur turpis duis."));
		paginas.put(2L, new Pagina(2L, "Pedro", "Lorem ipsum dolor sit amet, consectetur turpis duis."));
		paginas.put(3L, new Pagina(3L, "Ander", "Lorem ipsum dolor sit amet, consectetur turpis duis."));
		paginas.put(4L, new Pagina(4L, "Juanjo", "Lorem ipsum dolor sit amet, consectetur turpis duis."));
		
		libro = new Libro(paginas, 1L);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paginaActual = 1;
		int totalPaginas = libro.getPaginas().size();
		Pagina paginaMostrar = new Pagina();
		
		try {
			String pagina = request.getParameter("pagina");
			if ( pagina != null ) {
				paginaActual = Integer.parseInt(pagina);
				if ( paginaActual <= 0 ) {
					paginaActual = 1;
				}
				if ( paginaActual > totalPaginas ) {
					paginaActual = 1;
				}						
				paginaMostrar = libro.getPaginas().get((long)paginaActual);			
			}else {
				paginaMostrar = libro.getPaginas().get(1L);
			}

	}catch (Exception e) {
		request.setAttribute("alerta", "Pagina NO disponible" );
		paginaMostrar = libro.getPaginas().get(1L);
		paginaActual = 1;

	}finally {
		HttpSession session = request.getSession();
		session.setAttribute("paginas", libro.getPaginas());
		
		request.setAttribute("pagina", paginaMostrar );
		request.setAttribute("paginaActual", paginaActual);
		request.setAttribute("totalPaginas",  totalPaginas );

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}		
		
		
		
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
