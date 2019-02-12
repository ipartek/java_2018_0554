package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojos.Noticia;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/homeservlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
// long es el indcie 
		HashMap<Long, Noticia> noticias;

		ServletContext application = request.getServletContext();

		noticias = (HashMap<Long, Noticia>) application.getAttribute("noticias");

		if (noticias == null) {
			noticias = new HashMap<>();
			
			for (Long i = 1L; i <= 4L; i++) {  // aqui le digo cuantas noticias quiero
				noticias.put(i, new Noticia(i, "Titular" + i, new Date(), "Autor" + i, "Texto" + i));
			}

			application.setAttribute("noticias", noticias);
		}
		
	
		//getRequestDispatcher.forward  sirve para que el servlet envie la respuesta al jsp. mediante el objeto request
		request.getRequestDispatcher("/pantallaListadoOriginal.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
