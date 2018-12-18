package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojos.Coche;


public class CocheController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Coche> coches = new ArrayList<Coche>();

		coches.add(new Coche(1L,"Volkswagen","Golf MK1","https://res.cloudinary.com/mk1-golf-owners-club/image/upload/c_limit,w_1024/v1502871254/uploads/attachments/5993fed44b7a8.jpg"));
		coches.add(new Coche(2L,"Volkswagen","Golf MK3","https://i.ytimg.com/vi/xaqT41Gy0mc/maxresdefault.jpg"));
		coches.add(new Coche(3L,"Honda","Civic eg","https://img.gta5-mods.com/q95/images/honda-civic-5gen-stance/472b2d-gta5mods4.jpgURL"));

		 
		request.setAttribute("coches", coches);
		
		request.getRequestDispatcher("coches.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busqueda = request.getParameter("busqueda");
		
		ArrayList<Coche> coches = new ArrayList<Coche>();
		coches.add(new Coche(3L,"Honda","Civic eg","https://img.gta5-mods.com/q95/images/honda-civic-5gen-stance/472b2d-gta5mods4.jpgURL"));
		
		request.setAttribute("coches", coches);
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("coches.jsp").forward(request, response);
	}

}