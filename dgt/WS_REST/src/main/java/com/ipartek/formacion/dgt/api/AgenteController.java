package com.ipartek.formacion.dgt.api;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.impl.AgenteServiceImpl;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api(tags = { "AGENTE" }, produces = "application/json", description = "Gestión de agente")
public class AgenteController {

	private final static Logger LOG = Logger.getLogger(AgenteController.class);
	private static AgenteService agenteService;

	public AgenteController() {
		super();

		agenteService = AgenteServiceImpl.getInstance();

	}

	@RequestMapping(value = { "/api/agente/{placa}/{password}" }, method = RequestMethod.GET)
	public ResponseEntity<Agente> login(@PathVariable String password, @PathVariable int placa) {

		ResponseEntity<Agente> response = new ResponseEntity<Agente>(HttpStatus.INTERNAL_SERVER_ERROR);

		Agente agenteEncontrado = null;

		// BUSCA SI EXISTE AGENTE
		try {
			LOG.trace("Llama al servicio a ver si existe el agente");
			agenteEncontrado = agenteService.existe(placa, password);

		} catch (Exception e) {
			LOG.warn("BAD REQUEST la peticion no se ha hecho correctamente");
			response = new ResponseEntity<Agente>(HttpStatus.BAD_REQUEST);

		}

		// SI NO EXISTE
		if (agenteEncontrado == null) {
			LOG.trace("FORBIDDEN la peticion se ha hecho correctamente pero los datos introducidos no existen");
			response = new ResponseEntity<Agente>(HttpStatus.FORBIDDEN);

		}

		// SI EXISTE
		else {
			// SI ENCUENTRA AGENTE
			LOG.trace("El agente existe y se ha encontrado");
			response = new ResponseEntity<Agente>(agenteEncontrado, HttpStatus.OK);

		}
		return response;

	}
}
