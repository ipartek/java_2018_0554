package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

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
		ArrayList<Proyecto> proyectos = 
				(ArrayList<Proyecto>) request.getServletContext().getAttribute("proyectos");
		
		//Empaquetarla en un objeto
		Proyecto proyecto = new Proyecto(Long.parseLong(id), titulo, descripcion);
		
		//Realizar la operación
		proyectos.add(proyecto);
		
		request.getRequestDispatcher("/").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
