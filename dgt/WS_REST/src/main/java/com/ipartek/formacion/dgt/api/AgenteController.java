package com.ipartek.formacion.dgt.api;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.modelo.pojo.Vehiculo;

@RestController
public class AgenteController {
	Agente a = null;
	
	private static MultaDAO multaDAO;
	
	// LISTAR
		@RequestMapping(value = { "/api/agente/{id}/multa" }, method = RequestMethod.GET)
		public ArrayList<Multa> detalleId(@PathVariable String id) {

			ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.BAD_REQUEST);

			

			return null;

		}

}
