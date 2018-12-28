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

import com.ipartek.formacion.modelos.pojos.Usuario;

/**
 * Servlet implementation class SaludoController
 */
@WebServlet("/SaludoController")
public class SaludoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArrayList<Usuario> usuario;
	private ValidatorFactory factory;
	private Validator validator;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

		usuario = new ArrayList<Usuario>();
	
		usuario.add(new Usuario(2L, "Andoni", "scooby", "Penalva Hernandez"));
}
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setAttribute("usuario", usuario);
		
//	request.setAttribute("nombre",usuario.getNombre());  //Obtener el nombre y apellidos del usuario

		request.getRequestDispatcher("privado/saludarpost.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		Usuario usuario;
		request.getRequestDispatcher("/privado/saludarget.jsp").forward(request, response);
	}

}
