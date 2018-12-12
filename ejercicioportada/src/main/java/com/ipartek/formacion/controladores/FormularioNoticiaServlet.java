package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojos.Noticia;

@WebServlet("/formularionoticia")
public class FormularioNoticiaServlet extends HttpServlet {
	private static final String NOTICIA_JSP = "noticia.jsp";
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		
		if(accion != null && !"insertar".equals(accion)) {
			@SuppressWarnings("unchecked")
			TreeMap<Long, Noticia> noticias = 
					(TreeMap<Long, Noticia>) request.getServletContext().getAttribute("noticias");
			
			if(noticias == null) {
				response.sendRedirect("noticias");
				return;
			}
			
			Noticia noticia = noticias.get(Long.parseLong(id));
			
			request.setAttribute("noticia", noticia);
		}
		
		request.setAttribute("accion", accion);
		
		request.getRequestDispatcher(NOTICIA_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		
		String titular = request.getParameter("titular");
		String fecha = request.getParameter("fecha");
		String autor = request.getParameter("autor");
		String texto = request.getParameter("texto");
		
		@SuppressWarnings("unchecked")
		TreeMap<Long, Noticia> noticias = 
				(TreeMap<Long, Noticia>) request.getServletContext().getAttribute("noticias");
		
		if(noticias == null) {
			response.sendRedirect("noticias");
			return;
		}
		
		Long idLong;
		if("insertar".equals(accion)) {
			idLong = noticias.lastKey() + 1L;
		} else {
			idLong = Long.parseLong(id);
		}
		
		switch(accion) {
		case "insertar": 
		case "editar": 
			Noticia noticia = new Noticia(idLong, titular, fecha, autor, texto);
			
			if(!noticia.isCorrecto()) {
				request.setAttribute("accion", accion);
				request.setAttribute("noticia", noticia);
				request.getRequestDispatcher(NOTICIA_JSP).forward(request, response);
				return;
			}
			
			noticias.put(noticia.getId(), noticia);

			break;
		case "borrar": noticias.remove(Long.parseLong(id)); break;
		default: throw new ServletException("Opción no definida");
		}
		
		response.sendRedirect("noticias");
	}

}
