package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.api.pojo.Mensaje;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.ipartek.formacion.taller.service.ModeloService;
import com.ipartek.formacion.taller.service.exception.PojoException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping("/api/modelo/")
@Api(tags = { "MODELO" }, produces = "application/json", description = "Gestión de taller")
public class ModeloController {
	// LOG
	private final static Logger LOG = Logger.getLogger(ModeloController.class);

	/* instancia e implementa patron singleton - inyeccion de dependencias */
	@Autowired
	ModeloService modeloService;

	@ApiResponses({ @ApiResponse(code = 200, message = "Listado"), @ApiResponse(code = 500, message = "Error interno"),
			@ApiResponse(code = 404, message = "Datos no encontrados") })
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Modelo>> listarModelo() {
		ResponseEntity<ArrayList<Modelo>> response = new ResponseEntity<ArrayList<Modelo>>(
				HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		try {
			modelos = (ArrayList<Modelo>) modeloService.listarCombustible();
			if (modelos.size() != 0) {
				response = new ResponseEntity<ArrayList<Modelo>>(modelos, HttpStatus.OK);
			} else {
				response = new ResponseEntity<ArrayList<Modelo>>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return response;
	}

	@ApiResponses({ @ApiResponse(code = 200, message = "Detalle"), @ApiResponse(code = 500, message = "Error interno"),
			@ApiResponse(code = 404, message = "Dato no encontrado") })
	@RequestMapping(value = { "{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Modelo> combustibleById(@PathVariable int id) {
		ResponseEntity<Modelo> response = new ResponseEntity<Modelo>(HttpStatus.INTERNAL_SERVER_ERROR);
		Modelo modelo = new Modelo();
		try {
			modelo = modeloService.detalle(id);
			if (modelo != null) {
				response = new ResponseEntity<Modelo>(modelo, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Modelo>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			LOG.debug(e);
		}
		return response;
	}

	@ApiResponses({ @ApiResponse(code = 200, message = "Eliminado"),
			@ApiResponse(code = 500, message = "Error interno"), @ApiResponse(code = 409, message = "Conflicto"),
			@ApiResponse(code = 404, message = "Dato no encontrado") })
	@RequestMapping(value = { "{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {

		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);
		boolean resul = false;
		try {
			resul = modeloService.eliminar(id);
			if (resul == true) {
				response = new ResponseEntity<Mensaje>(HttpStatus.OK);
			}

		} catch (PojoException e) {
			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.CONFLICT);

		} catch (Exception e) {
			LOG.debug(e);
			response = new ResponseEntity<Mensaje>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@ApiResponses({ @ApiResponse(code = 201, message = "Creado"), @ApiResponse(code = 500, message = "Error interno"),
			@ApiResponse(code = 409, message = "Conflicto"),
			@ApiResponse(code = 400, message = "Peticion incorrecta") })
	@RequestMapping(value = { "" }, method = RequestMethod.POST)
	public ResponseEntity crear(@RequestBody Modelo modelo) {

		ResponseEntity response = new ResponseEntity(HttpStatus.BAD_REQUEST);
		boolean resul = false;
		try {
			resul = modeloService.crear(modelo);
			if (resul == true) {
				response = new ResponseEntity(modelo, HttpStatus.CREATED);
			}

		} catch (PojoException e) {
			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity(mensaje, HttpStatus.CONFLICT);

		} catch (Exception e) {
			LOG.debug(e);
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@ApiResponses({ @ApiResponse(code = 200, message = "Modificado"),
			@ApiResponse(code = 500, message = "Error interno"), @ApiResponse(code = 409, message = "Conflicto"),
			@ApiResponse(code = 404, message = "No encontrado") })
	@RequestMapping(value = { "{id}" }, method = RequestMethod.PUT)
	public ResponseEntity modificar(@RequestBody Modelo modelo, @PathVariable int id) {

		ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
		boolean resul = false;
		try {
			modelo.setId(id);
			resul = modeloService.modificar(modelo);
			if (resul == true) {
				response = new ResponseEntity(modelo, HttpStatus.OK);
			}

		} catch (PojoException e) {
			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity(mensaje, HttpStatus.CONFLICT);

		} catch (Exception e) {
			LOG.debug(e);
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}