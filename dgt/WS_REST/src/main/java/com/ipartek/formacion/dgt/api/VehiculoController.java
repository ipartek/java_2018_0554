package com.ipartek.formacion.dgt.api;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.pojo.Coche;

@RestController
public class VehiculoController {
	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	private static CocheDAO cocheDAO;
	Coche c = null;

	public VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();

	}

	@RequestMapping(value = { "/api/vehiculo" }, method = RequestMethod.GET)
	public ArrayList<Coche> listar() {

		/*
		 * ArrayList<Coche> coches = new ArrayList<Coche>(); coches.add(new Coche (1L,
		 * "BI0000CM", "Fiat", 3455)); coches.add(new Coche (2L, "ZA0000HK",
		 * "Flagoneta", 3455));
		 */
		// return coches;
		return cocheDAO.getCoche();
	}

	/*
	 * @RequestMapping(value= {"/api/vehiculo/{id}"}, method = RequestMethod.GET)
	 * public Coche detalle(@PathVariable long id){
	 * 
	 * Coche c = new Coche (2L, "ZA0000HK", "Flagoneta", 3455); c.setId(id);
	 * 
	 * return c;
	 * 
	 * }
	 */

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Coche> detalle(@PathVariable long id) {

		/*
		 * ResponseEntity<Coche> response = null;
		 * 
		 * if (id > 0) { Coche c = new Coche(2L, "ZA0000HK", "Flagoneta", 3455);
		 * c.setId(id); response = new ResponseEntity<Coche>(c, HttpStatus.OK); } else
		 * {// coche no existe
		 * 
		 * response = new ResponseEntity<Coche>(c, HttpStatus.NOT_FOUND); }
		 */
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);

		if (id > 0) {
			Coche c = new Coche(2L, "ZA0000HK", "Flagoneta", 3455);
			c.setId(id);
			response = new ResponseEntity<Coche>(c, HttpStatus.OK);
		}

		return response;

	}
}
