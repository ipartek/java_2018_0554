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
//		try {
//
//			if (combustibleService.crear(pedido)) {
//				response = new ResponseEntity(pedido, HttpStatus.CREATED);
//			} else {
//				response = new ResponseEntity(HttpStatus.CONFLICT);
//			}
//
//		} catch (CombustibleException e) {
//
//			Mensaje mensaje = new Mensaje(e.getMessage());
//			Set<ConstraintViolation<Combustible>> violations = e.getViolations();
//
//			if (violations != null) {
//				mensaje.addViolations(e.getViolations());
//				response = new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
//			} else {
//				response = new ResponseEntity(mensaje, HttpStatus.CONFLICT);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		return response;

	}
}
