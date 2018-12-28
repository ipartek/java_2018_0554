package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojo.Chip;
import com.ipartek.formacion.modelo.pojo.Perro;

/**
 * Servlet implementation class AltaController
 */
@WebServlet("/privada/alta")
public class AltaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private ArrayList<Perro> perros;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext appContext = config.getServletContext();
		perros = (ArrayList<Perro>) appContext.getAttribute("perros");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/privada/alta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long ultimoId = perros.get(perros.size() - 1).getChip().getId();
		
		String nombre = request.getParameter("nombre");
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");
		String edad = request.getParameter("edad");
		String apadri = request.getParameter("apadrinado");
		boolean apadrinado;
		String peso = request.getParameter("peso");
		
		if ("Si".equals(apadri)) {
			apadrinado = true;
		}else {
			apadrinado = false;
		}
		
		
		if (nombre.isEmpty() || latitud.isEmpty() || longitud.isEmpty()) {
			request.setAttribute("vacios", "Debe rellenar todos los campos del formulario para crear el perro");
			request.getRequestDispatcher("privada/alta.jsp").forward(request, response);
		}else {
			Perro perro = new Perro();
			perro.setNombre(nombre);
			
			if (!edad.equals("")) {
				if (Integer.parseInt(edad) < 0) {
					perro.setEdad(0);
				}else {
					perro.setEdad(Integer.parseInt(edad));
				}
			}
			
			if (!peso.equals("")) {
				if (Double.parseDouble(peso) < 0) {
					perro.setPeso(0.0);
				}else {
					perro.setPeso(Double.parseDouble(peso));
				}
			}
			
			perro.setApadrinado(apadrinado);
			perro.setChip(new Chip(ultimoId + 1, latitud, longitud));
			
			perros.add(perro);
			
			ServletContext appContext = request.getServletContext();
			appContext.setAttribute("perros", perros);
			
			request.getRequestDispatcher("/privada/perros").forward(request, response);
		}

	}

}
