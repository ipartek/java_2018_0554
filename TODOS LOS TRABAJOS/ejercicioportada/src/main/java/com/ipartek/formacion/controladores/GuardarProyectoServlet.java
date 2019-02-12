package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojos.Proyecto;

@WebServlet("/guardarproyecto")
public class GuardarProyectoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recoger información
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		
		@SuppressWarnings("unchecked")
		HashMap<Long, Proyecto> proyectos = 
				(HashMap<Long, Proyecto>) request.getServletContext().getAttribute("proyectos");
		
		//Empaquetarla en un objeto
		Proyecto proyecto = new Proyecto(Long.parseLong(id), titulo, descripcion);
		
		//Realizar la operación
		proyectos.put(Long.parseLong(id), proyecto);
		
		//Redireccionar a la página correspondiente
		request.getRequestDispatcher("/").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
