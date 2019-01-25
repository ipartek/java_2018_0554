package com.ipartek.formacion.dgt.api;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.pojo.Coche;

@RestController
public class VehiculoController {

	private static CocheDAO cocheDAO;
	private final static Logger LOG = Logger.getLogger(CocheDAO.class);

	public VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();
	}

	@RequestMapping(value = { "/api/vehiculo" }, method = RequestMethod.GET)
	public ArrayList<Coche> listar() {

		ArrayList<Coche> coches = cocheDAO.getAll();

		return coches;

	}

//	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.GET)
//	@ResponseBody
//	public Coche getById(@PathVariable("id") long id) {
//
//
//		Coche coche = cocheDAO.getById(id);
//
//		if (coche == null) {
//		} else {
//		}
//		return coche;
//	}

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Coche> detalle(@PathVariable("id") long id) {

		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);

		Coche coche = cocheDAO.getById(id);

		if (coche != null) {
			response = new ResponseEntity<Coche>(coche, HttpStatus.OK);

		}
		return response;
	}

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteVehiculo(@PathVariable("id") long id) throws SQLException {
		String mensaje;
		boolean resultado = cocheDAO.delete(id);

		if (resultado == true) {

			mensaje = "Existia y Borrado";
			
		} else {
			mensaje = "No borrado o no existe";
		}
		return mensaje;
	}

}
