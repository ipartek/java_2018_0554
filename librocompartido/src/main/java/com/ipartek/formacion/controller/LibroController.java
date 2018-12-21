package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojos.Libro;

@WebServlet("/libro")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Libro> libro;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		libro = new ArrayList<Libro>();
		libro.add(new Libro("Héctor1",
				"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga."));
		libro.add(new Libro("Héctor2",
				"Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. "));
		libro.add(new Libro("Héctor3",
				"Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae."));
		libro.add(new Libro("Héctor4",
				"Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat."));
		libro.add(new Libro("Héctor5",
				"Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int paginaActual = 0;

		String pagina = request.getParameter("pagina");
		if (pagina != null) {
			paginaActual = Integer.parseInt(pagina);
		}

		request.setAttribute("pagina", libro.get(paginaActual));
		request.setAttribute("paginaActual", paginaActual);
		request.setAttribute("paginasTotal", libro.size());

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
