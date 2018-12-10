package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojos.Noticia;

@WebServlet("/noticias")
public class NoticiasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<Long, Noticia> noticias = new HashMap<>();
		
		for(Long i = 1L; i <= 3L; i++) {
			noticias.put(i, new Noticia(i, "Titular" + i, new Date(), "Autor" + i, "Texto" + i));
		}
		
		request.setAttribute("noticias", noticias);
		
		request.getRequestDispatcher("noticias.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

	