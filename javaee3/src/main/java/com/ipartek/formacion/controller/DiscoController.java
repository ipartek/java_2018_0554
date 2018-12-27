package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelo.pojos.Disco;

/**
 * Servlet implementation class DiscoController
 */
@WebServlet("/disco")
public class DiscoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ArrayList<Disco> disco;	
	private ValidatorFactory factory;
	private Validator validator;

	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
		
		
		disco = new  ArrayList<Disco>();
		disco.add(new Disco(1L, "Trapped!","Rage", "PortadaRage", "1992"));
		disco.add(new Disco(2L, "Firepower","Judas Priest", "PortadaJudas", "2018"));
		disco.add(new Disco(3L, "01011001","Ayreon", "Portada01011001", "2008"));
		disco.add(new Disco(4L, "The Bottom Deep","Communic", "PortadaThe Bottom Deep", "2011"));
		disco.add(new Disco(5L, "In Your Multitude","Conception", "PortadaIn Your Multitude", "1995"));

	}
	
	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("disco", disco);
		
		request.getRequestDispatcher("discos.jsp").forward(request, response);
	}

}
