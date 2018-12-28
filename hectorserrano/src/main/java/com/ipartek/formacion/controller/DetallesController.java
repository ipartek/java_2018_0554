package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojos.Perro;

@WebServlet("/privado/detalles")
public class DetallesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chip = request.getParameter("chip");
		request.setAttribute("chip", chip);
		
		String coordenadas = request.getParameter("coordenadas");
		request.setAttribute("coordenadas", coordenadas);
		
		String nombre = request.getParameter("nombre");
		request.setAttribute("nombre", nombre);
		
		String edad = request.getParameter("edad");
		request.setAttribute("edad", edad);
		
		String raza = request.getParameter("raza");
		request.setAttribute("raza", raza);
		
		request.getRequestDispatcher("detalles.jsp").forward(request, response);
	}
}
