package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojos.Coche;
import com.mysql.jdbc.PreparedStatement.ParseInfo;

/**
 * Servlet implementation class ComprarServlet
 */
public class ComprarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String idCocheString = request.getParameter("idCoche");
			Long idCoche = Long.parseLong(idCocheString);
			String marcaCoche = request.getParameter("marcaCoche");
			String modeloCoche = request.getParameter("modeloCoche");
			String imagenCoche = request.getParameter("getParameter");

			ArrayList<Coche> cochescarrito = new ArrayList<Coche>();
			cochescarrito.add(new Coche(idCoche, marcaCoche, modeloCoche, imagenCoche));
//			guardar la sesion
			HttpSession sessioncarrito = request.getSession();
			sessioncarrito.setMaxInactiveInterval(60 * 5); //5 minutos TAMBIEN SE PUEDE CONFIGURAR EN WEB.XML
			sessioncarrito.setAttribute("cochescarrito", cochescarrito);
			
			request.getRequestDispatcher("carrito.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
