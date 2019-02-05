package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.service.CombustibleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping("/api/combustible/")
@Api(tags = { "COMBUSTIBLE" }, produces = "application/json", description = "Gestión de taller")
public class CombustibleController {
	// LOG
	private final static Logger LOG = Logger.getLogger(CombustibleController.class);

	/* instancia e implementa patron singleton - inyeccion de dependencias */
	@Autowired
	CombustibleService combustibleService;

	@ApiResponses({ @ApiResponse(code = 200, message = "Listar ok"),
			@ApiResponse(code = 500, message = "Error interno"),
			@ApiResponse(code = 404, message = "Datos no encontrados") })
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Combustible>> listarCombustible() {
		ResponseEntity<ArrayList<Combustible>> response = new ResponseEntity<ArrayList<Combustible>>(
				HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Combustible> combustibles = new ArrayList<Combustible>();
		try {
			combustibles = (ArrayList<Combustible>) combustibleService.listarCombustible();
			if (combustibles.size() != 0) {
				response = new ResponseEntity<ArrayList<Combustible>>(combustibles, HttpStatus.OK);
			} else {
				response = new ResponseEntity<ArrayList<Combustible>>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return response;
	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "Listar ok"),
		@ApiResponse(code = 500, message = "Error interno"),
		@ApiResponse(code = 404, message = "Dato no encontrado") })
		@RequestMapping(value = { "{id}" }, method = RequestMethod.GET)
		public ResponseEntity<Combustible> combustibleById(@PathVariable int id) {
			ResponseEntity<Combustible> response = new ResponseEntity<Combustible>(
					HttpStatus.INTERNAL_SERVER_ERROR);
			Combustible combustible = new Combustible();
			try {
				combustible =  combustibleService.detalle(id);
				if (combustible != null) {
					response = new ResponseEntity<Combustible>(combustible, HttpStatus.OK);
				} else {
					response = new ResponseEntity<Combustible>(HttpStatus.NOT_FOUND);
				}
				
			} catch (Exception e) {
				LOG.debug(e);
			}
			return response;
		}
	
}