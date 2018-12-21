package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojos.Disco;

/**
 * Servlet implementation class DiscoController
 */
@WebServlet("/disco")
public class DiscoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Disco> discos = new ArrayList<Disco>();
		
		discos.add(new Disco());
		discos.add(new Disco(1L, "Trapped!","Rage", "PortadaRage", "1992"));
		discos.add(new Disco(2L, "Firepower","Judas Priest", "PortadaJudas", "2018"));
		discos.add(new Disco(3L, "01011001","Ayreon", "Portada01011001", "2008"));
		discos.add(new Disco(4L, "The Bottom Deep","Communic", "PortadaThe Bottom Deep", "2011"));
		discos.add(new Disco(5L, "In Your Multitude","Conception", "PortadaIn Your Multitude", "1995"));

		request.setAttribute("lista", discos);
		
		request.getRequestDispatcher("discos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
