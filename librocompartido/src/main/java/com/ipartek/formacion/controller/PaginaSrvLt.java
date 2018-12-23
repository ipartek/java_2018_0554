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
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int paginaactual = 0;

		String recibepagina = request.getParameter("pag");
		if (recibepagina != null) {
			paginaactual = Integer.parseInt(recibepagina);
		}

		request.setAttribute("paginaactual", paginaactual);
		request.setAttribute("totalpaginas", libro.size());
		request.setAttribute("pagina", libro.get(paginaactual));

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
