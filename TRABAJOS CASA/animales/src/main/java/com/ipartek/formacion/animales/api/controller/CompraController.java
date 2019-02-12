package com.ipartek.formacion.animales.api.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.animales.api.pojo.CompraPost;
import com.ipartek.formacion.animales.api.pojo.Mensaje;
import com.ipartek.formacion.animales.modelo.pojo.Cliente;
import com.ipartek.formacion.animales.modelo.pojo.Compra;
import com.ipartek.formacion.animales.modelo.pojo.Empleado;
import com.ipartek.formacion.animales.modelo.pojo.Stock;
import com.ipartek.formacion.animales.service.CompraService;
import com.ipartek.formacion.animales.service.exception.CompraException;

@CrossOrigin
@RestController
@RequestMapping("/api/compra")
public class CompraController {

	@Autowired
	CompraService compraService;

	// METODO ELIMINAR (DELETE)
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {

		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);

		try {

			if (compraService.eliminar(id)) {
				response = new ResponseEntity<Mensaje>(HttpStatus.OK);
			}
		} catch (CompraException e) { // si falla la consulta

			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.CONFLICT);

		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<Mensaje>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// METODO CREAR
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity crear(@RequestBody CompraPost compraPost) {

		ResponseEntity response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			Compra c = new Compra();

			c.setStock(new Stock(compraPost.getIdStock(), 0, 0));
			c.setEmpleado(new Empleado(compraPost.getIdEmpleado(), "", "", "", "", "", null));
			c.setCliente(new Cliente(compraPost.getIdCliente(), ""));

			if (compraService.crear(c)) {

				response = new ResponseEntity(c, HttpStatus.CREATED);

			} else {
				response = new ResponseEntity(HttpStatus.CONFLICT);

			}

		} catch (CompraException e) {

			Mensaje mensaje = new Mensaje(e.getMessage());
			Set<ConstraintViolation<Compra>> violations = e.getViolations();

			if (violations != null) {
				mensaje.addViolationsCr(e.getViolations());
				response = new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
			} else {
				response = new ResponseEntity(mensaje, HttpStatus.CONFLICT);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

}
