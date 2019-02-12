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

@WebServlet("/guardarnoticiaservlet")
public class GuardarNoticiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recoger información
		String id = request.getParameter("id");
		String titular = request.getParameter("titular");
		String fecha = request.getParameter("fecha");
		String autor = request.getParameter("autor");
		String texto = request.getParameter("texto");
		String descripcion = request.getParameter("descripcion");
		
		@SuppressWarnings("unchecked")
		HashMap<Long, Noticia> noticias = 
				(HashMap<Long, Noticia>) request.getServletContext().getAttribute("noticias");
		
		//Empaquetarla en un objeto
		Noticia noticia = new Noticia(Long.parseLong(id), titular, fecha, autor, texto );
		
		//Realizar la operación
		noticias.put(Long.parseLong(id), noticia);
		
		//Redireccionar a la página correspondiente
		request.getRequestDispatcher("/mantenimiento.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
