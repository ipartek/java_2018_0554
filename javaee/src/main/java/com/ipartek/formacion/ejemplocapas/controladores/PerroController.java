package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojos.Perro;

/**
 * Servlet implementation class PerroController
 */
public class PerroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Perro> perros = new ArrayList<Perro>();
		
		Perro p1 = new Perro(1L, "Pastor alemán", "https://http2.mlstatic.com/pastor-aleman-cachorros-super-calidad-vip-D_NQ_NP_949437-MLM27059324737_032018-F.jpg");
		Perro p2 = new Perro(2L, "Labrador retriever", "https://t2.ea.ltmcdn.com/es/razas/0/0/1/img_100_labrador-retriever_0_600.jpg");
		Perro p3 = new Perro(3L, "Beagle", "https://t1.ea.ltmcdn.com/es/razas/0/4/3/img_340_beagle_0_600.jpg");
		
		request.setAttribute("perros", perros);
		
		request.getRequestDispatcher("perros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda = request.getParameter("busqueda");
		
		ArrayList<String> perros = new ArrayList<String>();
		perros.add("p1");
		perros.add("p2");
		
		request.setAttribute("perros", perros);
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("perros.jsp").forward(request, response);
	}

}
