package com.ipartek.formacion.animales.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.animales.service.VentaService;
import com.ipartek.formacion.modelo.pojo.Venta;

@RestController
@SuppressWarnings({"rawtypes", "unchecked"})
public class VentaController {
	
	@Autowired
	VentaService ventaService;
	
	@RequestMapping(value = "/api/venta", method = RequestMethod.POST)
	public ResponseEntity crear(@RequestBody Venta venta) {

		
		ResponseEntity response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			if (ventaService.crear(venta)) {
				response = new ResponseEntity(venta, HttpStatus.CREATED);
			} else {
				response = new ResponseEntity(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}
}
