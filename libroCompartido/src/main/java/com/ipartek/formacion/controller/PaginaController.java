package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojo.Pagina;

/**
 * Servlet implementation class PaginaController
 */
@WebServlet("/pagina")
public class PaginaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		HttpSession session = request.getSession();
		
		HashMap<Long, Pagina> paginas = (HashMap<Long, Pagina>) session.getAttribute("paginas");
		
		String autor = request.getParameter("autor");
		String texto = request.getParameter("texto");
		
		Pagina pagina = new Pagina((long) paginas.size() + 1, autor, texto);
		
		paginas.put(pagina.getId(), pagina);
		session.setAttribute("paginas", paginas);
		request.getRequestDispatcher("libro").forward(request, response);
		
	}

}
