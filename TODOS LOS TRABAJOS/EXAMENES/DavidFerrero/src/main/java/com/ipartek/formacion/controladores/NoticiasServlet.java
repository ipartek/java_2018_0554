package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.Date;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojos.Noticia;

@WebServlet("/noticias")
public class NoticiasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TreeMap<Long, Noticia> noticias;

		ServletContext application = request.getServletContext();

		noticias = (TreeMap<Long, Noticia>) application.getAttribute("noticias");

		if (noticias == null) {
			noticias = new TreeMap<>();
			
			for (Long i = 1L; i <= 4L; i++) {  // aqui le digo cuantas noticias quiero
				noticias.put(i, new Noticia(i, "Titular" + i, new Date(), "Autor" + i, "Texto" + i));
			}

			application.setAttribute("noticias", noticias);
		}
		
		request.getRequestDispatcher("noticias.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
