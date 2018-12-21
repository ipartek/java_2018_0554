package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojos.Pagina;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Pagina> libro;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		libro = new ArrayList<Pagina>();
		libro.add(new Pagina("Cervantes", "Cuerpo de la pagina"));
		libro.add(new Pagina("Otro ", "segundo Cuerpo de la pagina"));
		libro.add(new Pagina("Otro mas", "tercer Cuerpo de la pagina"));
		libro.add(new Pagina("Otro mas", "cuarto Cuerpo de la pagina"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response, Long paginaActual)
			throws ServletException, IOException {
//		ArrayList<Pagina> libro = new ArrayList<Pagina>();
//
//		libro.add(new Pagina("Cervantes", "Cuerpo de la pagina"));
//		libro.add(new Pagina("Otro ", "segundo Cuerpo de la pagina"));
//		libro.add(new Pagina("Otro mas", "tercer Cuerpo de la pagina"));
//		libro.add(new Pagina("Otro mas", "cuarto Cuerpo de la pagina"));
		doPost(request, response);
//		if (paginaActual == null) {
//			paginaActual = 1L;
//		}
//		HashMap<Long, Pagina> libro = new HashMap<Long, Pagina>();
//
//		libro.put(1L, new Pagina("Cervantes", "Cuerpo de la pagina"));
//		libro.put(2L, new Pagina("Otro ", "segundo Cuerpo de la pagina"));
//		libro.put(3L, new Pagina("Otro mas", "tercer Cuerpo de la pagina"));
//		libro.put(4L, new Pagina("Otro mas", "cuarto Cuerpo de la pagina"));
//
//		String accion = request.getParameter("acc");
//		switch (accion) {
//		case "ant":
//			--paginaActual;
//			break;
//		case "sig":
//			++paginaActual;
//			break;
//		default:
//			break;
//		}
//		request.setAttribute("pagina", libro.get(paginaActual));
//		request.getRequestDispatcher("real_index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int paginaActual = 0;

		String pagina = request.getParameter("pagina");

		if (pagina != null) {
			paginaActual = Integer.parseInt(pagina);
		}
		
		if (paginaActual > libro.size() | paginaActual < libro.size()) {
			paginaActual = 1;
		}
		request.setAttribute("pagina", libro.get(paginaActual));
		request.setAttribute("paginaActual", paginaActual);
		request.setAttribute("paginasTotal", libro.size());

		request.getRequestDispatcher("real_index.jsp");
		doGet(request, response);

	}

}
