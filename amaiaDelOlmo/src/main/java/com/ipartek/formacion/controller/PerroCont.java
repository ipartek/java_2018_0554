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
 * Servlet implementation class PerroCont
 */
@WebServlet(name = "PerroCont", urlPatterns = { "/perro" })
	
public class PerroCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Perro> perros;	
	private ValidatorFactory factory;
	private Validator validator;
    
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	
    	perros = new ArrayList<Perro>();
		
		perros.add(new Perro("Tobi", 10, "Bulldog", 20, "Sí", "01-DDDD-2008", "1800, 1550"));
		perros.add(new Perro("Azkar", 6, "Pastor alemán", 15, "Sí", "02-DDDD-2012", "1800, 1550"));
		perros.add(new Perro("Kena", 4, "Beagle", 10, "No", "01-DDDD-2014", "1800, 1550"));
		
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int total = perros.size();
		request.setAttribute("total", total);
		request.setAttribute("perros", perros);
		
		request.getRequestDispatcher("privado/perros.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String nombre = request.getParameter("nombre");
		String chip = request.getParameter("chip");
		String raza = request.getParameter("raza");
		int edad = Integer.parseInt(request.getParameter("edad"));
		int peso = Integer.parseInt(request.getParameter("peso"));
		String apadrinado = request.getParameter("apadrinado");
		String localizacion = request.getParameter("localizacion");
		Perro p = new Perro();
		
		try {
		
			p = new Perro(nombre, edad, raza, peso, apadrinado, chip, localizacion);
			
			//validar			
		    Set<ConstraintViolation<Perro>> violations = validator.validate(p);
		    if ( violations.isEmpty() ) {
		    	
		    	perros.add(p);
		    	
		    }else {
		    	
		    	request.setAttribute("alerta", "Por favor rellena el nombre, chip y raza del perro");
		    }
			
				
		}catch (Exception e) {
			request.setAttribute("alerta", "Error escribiendo perro" );
			
		}finally {
			request.setAttribute("nombre", nombre );
			request.setAttribute("chip", chip );
			request.setAttribute("raza",  raza );
			request.setAttribute("edad", edad );
			request.setAttribute("peso",  peso );
			request.setAttribute("apadrinado", apadrinado );
			request.setAttribute("localizacion",  localizacion );
			request.getRequestDispatcher("perro").forward(request, response);
		}		
	}	
}
