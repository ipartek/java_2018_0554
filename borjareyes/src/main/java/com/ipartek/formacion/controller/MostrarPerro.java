package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelos.Perro;

/**
 * Servlet implementation class MostrarPerro
 */
@WebServlet("/mostrarperro")
public class MostrarPerro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Perro> perros;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chip = request.getParameter("chip");
		Perro perro=null;
		perros = (ArrayList<Perro>) request.getServletContext().getAttribute("perros");
		 for (Perro p:perros) {
			 if(p.getChip().equals(chip)) {
				 perro=p;
				 break;
			 }
		 }
		 request.setAttribute("perro", perro);
		 
		 request.getRequestDispatcher("/privado/detalles.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
