package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.GatoDAO;
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		try {
			GatoDAO dao = new GatoDAO();
			Gato g = dao.getById(Long.parseLong(id));
			
			HttpSession session = request.getSession();
			ArrayList<Gato> gatosComprados = (ArrayList<Gato>) session.getAttribute("gatosComprados");
			
			if (gatosComprados == null) {
				gatosComprados = new ArrayList<Gato>();
			}
			
			gatosComprados.add(g);
			
			session.setAttribute("gatosComprados", gatosComprados);
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			String url = request.getContextPath() + "/gatos";
			response.sendRedirect(url);
		}
	}

}
