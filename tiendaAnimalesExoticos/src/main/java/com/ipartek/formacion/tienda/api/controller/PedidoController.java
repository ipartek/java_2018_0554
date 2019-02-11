package com.ipartek.formacion.tienda.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.tienda.modelo.pojo.Pedido;
import com.ipartek.formacion.tienda.service.PedidoService;

@CrossOrigin
@RestController
@RequestMapping("api/pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity crear(@RequestBody Pedido pedido) {

		ResponseEntity response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			if (pedidoService.insert(pedido)) {
				response = new ResponseEntity(pedido, HttpStatus.CREATED);
			} else {
				response = new ResponseEntity(HttpStatus.CONFLICT);
			}
		}catch (Exception e) {
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}
}
