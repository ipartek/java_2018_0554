package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojos.Gato;

/**
 * Servlet implementation class ComprarServlet
 */
public class ComprarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Gato> gatos = (ArrayList<Gato>)session.getAttribute("gatos");
		ArrayList<String> gatosComprados = new ArrayList<String>();
		
		gatosComprados = (ArrayList<String>)session.getAttribute("gatosComprados");
		
		Long id = Long.parseLong(request.getParameter("id"));
		for (Gato g : gatos) {
			if (g.getId() == id) {
				gatosComprados.add(g.getRaza() + " - " + g.getNombre());
				break;
			}
		}
		
		session.setAttribute("gatosComprados", gatosComprados);
		response.sendRedirect("gatos");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
