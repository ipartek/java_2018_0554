package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelos.pojos.Pagina;

@WebServlet("/pagina")
public class PaginaSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Pagina> libro;

	@Override
	public void init() throws ServletException {
		super.init();
		libro = new ArrayList<Pagina>();
		libro.add(new Pagina("autor1", "texto1"));
		libro.add(new Pagina("autor2", "texto2"));
		libro.add(new Pagina("autor3", "texto3"));

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getServletContext().setAttribute("libro", libro);
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int paginaactual = 0;
		String error = null;
		ArrayList<Pagina> libro = null;

		try {
			paginaactual = 0;

			error = (String) request.getAttribute("error");
			libro = (ArrayList<Pagina>) request.getServletContext().getAttribute("libro");
			String recibepagina = request.getParameter("pag");
			String recibedonde = request.getParameter("donde");
			if (recibepagina != null) {
				paginaactual = Integer.parseInt(recibepagina);
				if (recibedonde!=null) {
					paginaactual-=1;
				}
				if (paginaactual > libro.size() - 1) {
					error="Pagina no valida";
					paginaactual = libro.size() - 1;
				}
			}
		} catch (NumberFormatException e) {
			error="Pagina NO disponible";
			request.getRequestDispatcher("pagina?pag=0").forward(request, response);
			e.printStackTrace();
		} finally {
			request.setAttribute("paginaactual", paginaactual);
			request.setAttribute("totalpaginas", libro.size());
			request.setAttribute("pagina", libro.get(paginaactual));
			request.setAttribute("error", error);

			request.getRequestDispatcher("libro.jsp").forward(request, response);
		}

	}

}
