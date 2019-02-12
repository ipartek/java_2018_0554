package com.ipartek.formacion.animales.api.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.animales.service.StockService;
import com.ipartek.formacion.modelo.pojo.Animal;
import com.ipartek.formacion.modelo.pojo.Venta;

@RestController
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@RequestMapping(value = "/api/catalogo/", method = RequestMethod.GET)
	ResponseEntity<ArrayList<Animal>> listar() {
		
		ResponseEntity<ArrayList<Animal>> respuesta;
		respuesta = new ResponseEntity<ArrayList<Animal>>(HttpStatus.NOT_FOUND);
		try {
			ArrayList<Animal> catlaogo = (ArrayList<Animal>) stockService.catalogo();
			if (!catlaogo.isEmpty()) {
				respuesta = new ResponseEntity<ArrayList<Animal>>(catlaogo, HttpStatus.OK);
			}
		} catch (Exception e) {
			respuesta = new ResponseEntity<ArrayList<Animal>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}
	
	
	@RequestMapping(value = "/api/venta/", method = RequestMethod.POST)
	ResponseEntity<Animal> comprar( @RequestBody Venta venta ) {
		ResponseEntity<Animal> respuesta;
		
		try {
			
			// si hay stock del animal 201
			if ( stockService.comprar( venta.getIdAnimal(), venta.getIdUsuario()) ) {
				
				//recuperar Animal
				Animal animal = new Animal();
				respuesta = new ResponseEntity<Animal>( animal , HttpStatus.CREATED);
				
			}else {     // si no hay stock 409
				
				respuesta = new ResponseEntity<Animal>(HttpStatus.CONFLICT);
			}
			
		} catch (SQLException e) {			
			respuesta = new ResponseEntity<Animal>(HttpStatus.BAD_REQUEST);
		
		} catch (Exception e) {
			respuesta = new ResponseEntity<Animal>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}
	
	
}
