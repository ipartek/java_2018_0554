package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ipartek.formacion.modelo.pojos.Coche;


public class CochesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String IMG1="https://img.milanuncios.com/fg/2365/49/236549537_1.jpg?VersionId=ak5VuRjm0A6F_7p_4HptrJjhcDTNaO9b";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Coche> coches = new ArrayList<Coche>();
		
		Coche coche = new Coche(1L,"BMW", "325TDS", "Gris", IMG1);
		coches.add(coche);
		//request.setAttribute("coches", coches);
		
		Coche coche2 = new Coche(2L,"AlfaRomeo", "Spider", "Gris", IMG1);
		coches.add(coche2);
		request.setAttribute("coches", coches);
		
		request.getRequestDispatcher("coches.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
