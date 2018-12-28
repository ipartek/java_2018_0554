package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojo.Perro;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class FormularioPerroServlet
 */
@WebServlet("/formperro")
public class FormularioPerroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Perro> perros;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("privado/formularioPerros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		
		Perro p = new Perro();

		 
		 try {
			 p = new Perro(nombre,raza);
			 perros.add(p);
			 
		 }catch(Exception e) {
			 request.setAttribute("error", "error añadiendo perro");
			 
		 }finally {
			 request.setAttribute("perros", perros);
			 request.getRequestDispatcher("privado/listarPerros.jsp").forward(request, response);
	}
	}
}
