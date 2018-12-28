package com.ipartek.formacion.controladores;

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

import com.ipartek.formacion.modelos.pojos.Perro;
import com.ipartek.formacion.modelos.pojos.Usuario;

/**
 * Servlet implementation class PerroControler
 */
@WebServlet("/listadeperros")
public class PerroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArrayList<Perro> perro;
	private ValidatorFactory factory;
	private Validator validator;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

		perro = new ArrayList<Perro>();

		perro.add(new Perro("01-0001-1989","Loki", 0, "peke", 1,true));
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("perro", perro);

		request.getRequestDispatcher("privado/listadeperros.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//los parametros que nos manda el formulario
		
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		Perro perro;
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("raza", raza);
		
		
		request.getRequestDispatcher("/privado/listadeperros.jsp").forward(request, response);
		
	
	}

}
