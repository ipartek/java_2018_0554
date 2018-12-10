package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojos.Proyecto;

@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Las variables de tipo application se comparten para todos los usuarios
		//de este contexto (aplicación)
		ServletContext application = request.getServletContext();
		
		@SuppressWarnings("unchecked")
		HashMap<Long, Proyecto> proyectos = (HashMap<Long, Proyecto>) application.getAttribute("proyectos");

		if (proyectos == null) {
			proyectos = new HashMap<Long,Proyecto>();

			proyectos.put(1L, new Proyecto(1L, "Primer proyecto",
					"Este proyecto mola mogollón porque bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla"));
			proyectos.put(2L, new Proyecto(2L, "Segundo proyecto",
					"Este proyecto es una birria porque bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla, bla"));

			application.setAttribute("proyectos", proyectos);
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
