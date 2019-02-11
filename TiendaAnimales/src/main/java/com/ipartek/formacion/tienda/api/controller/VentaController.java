package com.ipartek.formacion.tienda.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.tienda.api.pojo.Mensaje;
import com.ipartek.formacion.tienda.modelo.pojo.Venta;
import com.ipartek.formacion.tienda.service.VentaService;
import com.ipartek.formacion.tienda.service.exception.VentaException;

@CrossOrigin
@RestController
@RequestMapping("api/venta")
public class VentaController {

	@Autowired
	VentaService ventaService;

	/**
	 * Método para generar una venta
	 * 
	 * @param venta Objeto compuesto por un cliente (<b>Persona</b>) y un
	 *              <b>Animal</b> del Stock.
	 * @return 201 Si se <b>genera la venta</b>
	 * @return 404 Si no es posible crear la venta
	 * @return 409 Si ocurre una <b>VentaException</b> (P.E: si no hay stock de ese
	 *         animal)
	 * @return 500 Si ocurre un <b>fallo no esperado</b> (P.E: Los datos o su
	 *         formato no son correctos)
	 * @throws <b>VentaException:</b> Si no existe Stock para el animal a comprar
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public ResponseEntity<Mensaje> insert(@RequestBody Venta venta) {
		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);
		try {
			if (ventaService.crear(venta)) {
				response = new ResponseEntity<Mensaje>(new Mensaje("Venta creada con éxito."), HttpStatus.CREATED);
			} else {
				throw new VentaException(VentaException.EXCEPTION_NO_STOCK);
			}
		} catch (VentaException e) {
			response = new ResponseEntity<Mensaje>(new Mensaje(e.getMessage()), HttpStatus.CONFLICT);
		} catch (Exception e) {

			response = new ResponseEntity<Mensaje>(new Mensaje("Error en el Servidor"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
