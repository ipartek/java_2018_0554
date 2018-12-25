package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojos.Libro;

@WebServlet("/libro")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Libro> libro;
	private int paginaActual = 0;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		libro = new ArrayList<Libro>();
		libro.add(new Libro("demo",
				"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga."));
		libro.add(new Libro("demo",
				"Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. "));
		libro.add(new Libro("demo",
				"Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae."));
		libro.add(new Libro("demo",
				"Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat."));
		libro.add(new Libro());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paginaStr = request.getParameter("pagina");
		if (paginaStr != null) {
			paginaActual = Integer.parseInt(paginaStr);
			if (paginaActual >= libro.size() || paginaActual < 0) {
				while(paginaActual < 0) {
					paginaActual++;
				}
				while(paginaActual > libro.size()) {
					paginaActual--;
				}
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("paginas", libro); // ArrayList de libros recogidos en una variable de sesión llamada "paginas"
		request.setAttribute("pagina", libro.get(paginaActual)); // Al ArrayList "libro" se le pasa la página actual del getParameter para introducirla en el método get del ArryList y obtener el índice de la página actual en el atributo llamado "pagina"
		request.setAttribute("paginaActual", paginaActual); // La variable que contiene el número de la página actual se pasa en el atributo llamado "paginaActual"
		request.setAttribute("paginasTotal", libro.size()); // La cantidad de objetos libro se obtiene con el método size y se envia el atributo llamado "paginasTotal"

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
