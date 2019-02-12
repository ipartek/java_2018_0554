package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojos.Proyecto;

@WebServlet("/editarproyecto")
public class EditarProyectoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		@SuppressWarnings("unchecked")
		HashMap<Long, Proyecto> proyectos = 
				(HashMap<Long, Proyecto>) request.getServletContext().getAttribute("proyectos");
		
		Proyecto proyecto = proyectos.get(Long.parseLong(id));
		
		request.setAttribute("proyecto", proyecto);
		
		request.getRequestDispatcher("nuevoproyecto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
