package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.CombustibleService;

@CrossOrigin
@RestController
@RequestMapping("/api/combustible")
public class CombustibleController {

	@Autowired
	CombustibleService combustibleService;

	@RequestMapping(value=(""), method=RequestMethod.GET)
	public ResponseEntity<ArrayList<Combustible>> listar() {
		ResponseEntity<ArrayList<Combustible>> response = new ResponseEntity<ArrayList<Combustible>>(HttpStatus.NOT_FOUND);
		try {
			ArrayList<Combustible> combustibles = (ArrayList<Combustible>) combustibleService.listar();
			if(!combustibles.isEmpty()) {
				response = new ResponseEntity<ArrayList<Combustible>>(combustibles, HttpStatus.OK);
			}
		}catch (Exception e) {
			 response = new ResponseEntity<ArrayList<Combustible>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return response;
	}
	// TODO Listar por ID
	@RequestMapping(value=("/{id}"), method=RequestMethod.GET)
	public ResponseEntity<Combustible> detalleC(@PathVariable int id){
		
		ResponseEntity<Combustible> response = new ResponseEntity<Combustible>(HttpStatus.NOT_FOUND);
		try {
			Combustible combustible=combustibleService.detalleId(id);
			if(combustible!=null) {
				response = new ResponseEntity<Combustible>(combustible,HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
			 response = new ResponseEntity<Combustible>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	// TODO Eliminar por id

	// TODO Crear por ID

	// TODO Modificar por ID

}
