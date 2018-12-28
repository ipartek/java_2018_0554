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
 * Servlet implementation class ListarPerroServlet
 */
@WebServlet("/listar")
public class ListarPerroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Perro> perros = new ArrayList<Perro>();
		perros.add(new Perro("Endika","30","Bulldog Frances",15, true));
		perros.add(new Perro("Jaime","30","Shiba",15,true));
		perros.add(new Perro("Peter","30","Rottweiler",15,true));
		
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("privado/listarPerros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
