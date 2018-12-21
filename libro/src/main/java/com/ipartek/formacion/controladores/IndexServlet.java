package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojo.Pagina;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Pagina> libro;
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		libro = new  ArrayList<Pagina>();
		libro.add( new Pagina(1L,"lorem1", "autor1"));
		libro.add( new Pagina(2L,"lorem2", "autor2"));
		libro.add( new Pagina(3L,"lorem3", "autor3"));
		libro.add( new Pagina(4L,"lorem4", "autor4"));
		libro.add( new Pagina(5L,"lorem5", "autor5"));
		
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

		int paginaActual = 0;
		
		String pagina = request.getParameter("pagina");
		if ( pagina != null ) {
			paginaActual = Integer.parseInt(pagina);
		}
				
		request.setAttribute("pagina", libro.get(paginaActual));
		request.setAttribute("paginaActual", paginaActual);
		request.setAttribute("paginasTotal", libro.size() );
		
		request.getRequestDispatcher("index_real.jsp").forward(request, response);
		
		
	}

}
