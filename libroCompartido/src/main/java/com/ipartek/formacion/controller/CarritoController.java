package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojo.Gato;

/**
 * Servlet implementation class CarritoController
 */
@WebServlet("/carrito")
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Gato> gatos = new ArrayList<Gato>();
		gatos.add(new Gato(1L, "Persa", "Negro", "Luna", 4.2, "https://upload.wikimedia.org/wikipedia/commons/c/cd/Persa_negro.JPG"));
		gatos.add(new Gato(2L, "Siamés", "Pardo", "Niko", 5.7, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlQ-zTe-AfkchZdIpbJoGEfJlldiJ8dsqHtezb-0o_tLwmLKNI"));
		gatos.add(new Gato(3L, "Snowshoe", "Blanco-Manchas", "Txispi", 5.3, "https://gatosexotico.com/wp-content/uploads/2018/06/sno7-e1528145806192.jpg"));
		
		request.setAttribute("gatos", gatos);
		
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
