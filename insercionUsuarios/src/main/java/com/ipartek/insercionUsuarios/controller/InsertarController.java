package com.ipartek.insercionUsuarios.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.insercionUsuarios.dao.InsertarDAO;
import com.ipartek.insercionUsuarios.pojo.Persona;

/**
 * Servlet implementation class InsertarController
 */
@WebServlet("/insertar")
public class InsertarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static Logger LOG = Logger.getLogger(InsertarController.class);

	InsertarDAO dao = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = InsertarDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Archivo almacenado en el directorio del proyecto
		String csvFile = "C:\\0554\\workspace\\insercionUsuarios\\ArchivoInsercion\\personas.txt";
		LOG.info("Se insertaran las lineas del fichero: [ " + csvFile + " ]");
		String line = "";
		String cvsSplitBy = ",";

		int lineas = 0;
		int personasIncompletas = 0;
		int menores = 0;
		int insertadas = 0;
		ArrayList<Persona> personas = new ArrayList<Persona>();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				LOG.debug("Leyendo línea...");
				// use comma as separator
				String[] parametro = line.split(cvsSplitBy);
				
				if (parametro.length == 7) {
					LOG.debug("La persona es válida, tiene 7 parámetros.");
					Persona p = new Persona();
					p.setNombre(parametro[0]);
					p.setAp1(parametro[1]);
					p.setAp2(parametro[2]);
					p.setEdad(Integer.parseInt(parametro[3]));
					p.setEmail(parametro[4]);
					p.setDni(parametro[5]);
					if (p.getEdad() < 18) {
						LOG.debug("Es menor, descartamos su inserción.");
						menores++;
					} else {
						LOG.debug("Persona correcta, añadida a la cola de inserción.");
						personas.add(p);
						p = null;
					}
				} else {
					LOG.debug("Persona no válida, descartada.");
					personasIncompletas++;
				}
				LOG.debug("Cambiando de línea...");
				lineas++;
			}

			if (personas.size() > 0) {
				LOG.debug("Comenzamos la inserción.");
				dao.insert(personas);
				insertadas = personas.size();
			}
		} catch (IOException e) {
			e.printStackTrace();
			LOG.error("Excepción de entrada-salida: " + e.getStackTrace());
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Excepción de SQL: " + e.getStackTrace());
		} finally {
			request.setAttribute("lineas", lineas);
			request.setAttribute("insertadas", insertadas);
			request.setAttribute("personasIncompletas", personasIncompletas);
			request.setAttribute("menores", menores);

			LOG.debug("Redirigiendo a la página de resultados.");
			
			request.getRequestDispatcher("resultados.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
