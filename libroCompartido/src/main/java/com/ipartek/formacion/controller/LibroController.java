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
		String pagina = request.getParameter("pagina");
		
		if (pagina == null) {
			pagina = "1";
		}
		
		request.setAttribute("pagina", libro.getPaginas().get(Long.parseLong(pagina)));
		
		HttpSession session = request.getSession();
		session.setAttribute("paginas", libro.getPaginas());
		
		request.setAttribute("paginaActual", Long.parseLong(pagina));
		request.setAttribute("totalPaginas", libro.getPaginas().size());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
