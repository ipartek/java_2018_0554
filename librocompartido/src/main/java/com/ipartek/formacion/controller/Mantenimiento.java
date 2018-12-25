package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojos.Libro;

@WebServlet("/mantenimiento")
public class Mantenimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pagina = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String paginaStr = request.getParameter("pagina");
		switch (accion) {
		case "insertar":
		case "editar":
			if ("editar".equals(accion)) {
				String texto = request.getParameter("texto");
				request.setAttribute("texto", texto);
				pagina = Integer.parseInt(paginaStr);
				request.setAttribute("pagina", pagina);
			}
			String autor = request.getParameter("autor");
			request.setAttribute("autor", autor);
			request.getRequestDispatcher("mantenimiento.jsp").forward(request, response);
			break;
		case "borrar":
			HttpSession session = request.getSession();
			ArrayList<Libro> libro = (ArrayList<Libro>) session.getAttribute("paginas");
			pagina = Integer.parseInt(paginaStr);
			libro.remove(pagina);
			response.sendRedirect("libro");
			break;
		default:
			response.sendRedirect("libro");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paginaStr = request.getParameter("pagina");
		HttpSession session = request.getSession();
		ArrayList<Libro> libro = (ArrayList<Libro>) session.getAttribute("paginas");
		String texto = request.getParameter("texto");
		String autor = request.getParameter("autor");
		if (!"".equals(paginaStr)) {
			int pagina = Integer.parseInt(paginaStr);
			libro.set(pagina, new Libro(autor, texto));
		} else {
			libro.add(new Libro(autor, texto));
		}
		response.sendRedirect("libro");
	}

}
