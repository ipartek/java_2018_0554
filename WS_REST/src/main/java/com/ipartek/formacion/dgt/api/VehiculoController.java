package com.ipartek.formacion.dgt.api;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.pojo.Coche;

@CrossOrigin
@RestController
public class VehiculoController {

	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	private static CocheDAO cocheDAO;

	public VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();
	}

	@RequestMapping(value = { "/api/vehiculo" }, method = RequestMethod.GET)
	public ArrayList<Coche> listar() {

		ArrayList<Coche> coches = cocheDAO.getAll();

		return coches;

	}

	@RequestMapping(value = { "/api/vehiculo/{idomatricula}" }, method = RequestMethod.GET)
	public ResponseEntity<Coche> detalle(@PathVariable String idomatricula) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		boolean isId = false;
		long id = 0;
		try {
			// si es un id

			id = Long.parseLong(idomatricula);
			isId = true;

		} catch (Exception e) {

		}
		if (isId) {
			Coche coche = cocheDAO.getById(id);
			if (coche != null) {

				response = new ResponseEntity<Coche>(coche, HttpStatus.OK);
			}

			return response;
		} else {
			response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
			Coche coche = cocheDAO.getByMatricula(idomatricula);
			if (coche != null) {

				response = new ResponseEntity<Coche>(coche, HttpStatus.OK);
			}

			return response;
		}

	}

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Coche> eliminar(@PathVariable long id) {
		ResponseEntity<Coche> response = null;
		boolean resultado;

		try {
			resultado = cocheDAO.delete(id);
			if (resultado == true) {

				response = new ResponseEntity<Coche>(HttpStatus.OK);

			} else {
				response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
			}

		} catch (SQLException e) {
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);
		}

		return response;

	}

	@RequestMapping(value = { "/api/vehiculo/" }, method = RequestMethod.POST)
	public ResponseEntity<Coche> crear(@RequestBody Coche coche) {

		// TODO terminar
		// 201 creado y retornar coche con id actulizado
		// 400 datos del coche no son correctos, por ejemplo sin matricula o vacia
		// 409 ya exsite la matricula Unique Key
		return new ResponseEntity<Coche>(HttpStatus.NOT_IMPLEMENTED);
	}

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<Coche> modificar(@PathVariable long id, @RequestBody Coche coche) {

		// TODO terminar
		return new ResponseEntity<Coche>(HttpStatus.NOT_IMPLEMENTED);
	}

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.PATCH)
	public ResponseEntity<Coche> darDeBaja(@PathVariable String idomatricula, @RequestBody Coche coche) {

		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		boolean isId = false;
		boolean resultado;
		long id = 0;
		try {
			// si es un id

			id = Long.parseLong(idomatricula);
			isId = true;

			if (isId) {
				resultado = cocheDAO.darDeBajaPorId(id);
				if (resultado != false) {

					response = new ResponseEntity<Coche>(HttpStatus.OK);
				}

				return response;
			} else {
				response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
				resultado = cocheDAO.darDeBajaPorMatricula(idomatricula);
				if (resultado != false) {

					response = new ResponseEntity<Coche>(HttpStatus.OK);
				}

				return response;
			}
		} catch (Exception e) {
			return new ResponseEntity<Coche>(HttpStatus.NOT_IMPLEMENTED);
		}

	}

}

//package com.ipartek.formacion.dgt.api;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import org.apache.log4j.Logger;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ipartek.formacion.modelo.daos.CocheDAO;
//import com.ipartek.formacion.modelo.pojo.Coche;
//
//@RestController
//public class VehiculoController {
//
//	private static CocheDAO cocheDAO;
//	private final static Logger LOG = Logger.getLogger(CocheDAO.class);
//
//	public VehiculoController() {
//		super();
//		cocheDAO = CocheDAO.getInstance();
//	}
//
//	@RequestMapping(value = { "/api/vehiculo" }, method = RequestMethod.GET)
//	public ArrayList<Coche> listar() {
//
//		ArrayList<Coche> coches = cocheDAO.getAll();
//
//		return coches;
//
//	}
//
////	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.GET)
////	@ResponseBody
////	public Coche getById(@PathVariable("id") long id) {
////
////
////		Coche coche = cocheDAO.getById(id);
////
////		if (coche == null) {
////		} else {
////		}
////		return coche;
////	}
//
//	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<Coche> detalle(@PathVariable("id") long id) {
//
//		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
//
//		Coche coche = cocheDAO.getById(id);
//
//		if (coche != null) {
//			response = new ResponseEntity<Coche>(coche, HttpStatus.OK);
//
//		}
//		return response;
//	}
//
//	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.DELETE)
//	@ResponseBody
//	public String deleteVehiculo(@PathVariable("id") long id) throws SQLException {
//		String mensaje;
//		boolean resultado = cocheDAO.delete(id);
//
//		if (resultado == true) {
//
//			mensaje = "Existia y Borrado";
//			
//		} else {
//			mensaje = "No borrado o no existe";
//		}
//		return mensaje;
//	}
//
//}
