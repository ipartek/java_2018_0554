package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelo.pojos.Perro;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/perros")
public class PerrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	    
		private ArrayList<Perro> perro;	
		private ValidatorFactory factory;
		private Validator validator;

		
		@Override
		public void init(ServletConfig config) throws ServletException {	
			super.init(config);
			
			factory  = Validation.buildDefaultValidatorFactory();
	    	validator  = factory.getValidator();
			
			
			perro = new  ArrayList<Perro>();
			perro.add(new Perro("Nombre1", "1","Raza1", "7", true,"11-1111-2017","80","40"));
			perro.add(new Perro("Nombre2", "2","Raza2", "15", true,"12-1111-2017","81","41"));
			
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("perro", perro);
		
		request.getRequestDispatcher("privado/listar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String nombrep = request.getParameter("nombre");
		String chipp = request.getParameter("chip");
		String razap = request.getParameter("raza");
		Perro p = new Perro();
		
		
		try {
		
			p = new Perro(nombrep, chipp, razap);
			
			//validar			
		    Set<ConstraintViolation<Perro>> violations = validator.validate(p);
		    if ( violations.isEmpty() ) {
		    	
		    	perro.add(p);
		    	
		    }else {
		    	
		    	request.setAttribute("alerta", "Por favor rellena campos");
		    }
			

				
		}catch (Exception e) {
			request.setAttribute("alerta", "Error" );
			
		}finally {
			request.setAttribute("perro", perro);
			request.getRequestDispatcher("privado/listar.jsp").forward(request, response);
		}		
			
	}
	}



