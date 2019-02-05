package com.ipartek.formacion.taller.api.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.ipartek.formacion.taller.service.RolService;


@RestController
@RequestMapping("/api/rol/")
public class RolController {

	@Autowired
	RolService rolService;


	// LISTAR  (GET BY ALL)
		@RequestMapping(value = "", method = RequestMethod.GET)  											// sin parametro , metodo get
		public ResponseEntity<ArrayList<Rol>> listar() { 											// metodo listar

			ResponseEntity<ArrayList<Rol>> response = 
					new ResponseEntity<ArrayList<Rol>>(	HttpStatus.NOT_FOUND);  					// 404 por defecto devuelve not_Found
			try {
				ArrayList<Rol> roles= (ArrayList<Rol>) rolService.listar(); 						// llamada al servicio listar para que llame al DAO
				
				if (!roles.isEmpty()) {																// si el array no esta vacio
					response = new ResponseEntity<ArrayList<Rol>>(roles, HttpStatus.OK);		// envio array y codigo estado 200
				}

			} catch (Exception e) {
				e.printStackTrace(); // TODO meter en LOG
				response = new ResponseEntity<ArrayList<Rol>>(HttpStatus.INTERNAL_SERVER_ERROR);    // si el array esta vacio, codigo 500
			}

			return response;  
		}


		// LISTAR POR DETALLE POR ID (GETBYID)
				@RequestMapping(value = "{id}", method = RequestMethod.GET)
				public ResponseEntity<Rol> detalle(@PathVariable int id ) {  							  // @PathVariable para enviar parametro

					ResponseEntity<Rol> response = new ResponseEntity<Rol>(HttpStatus.NOT_FOUND); // por defecto devuelve not_Found
					
					try {
						
						Rol rol = (Rol) rolService.detalle(id);					  // lamada a servicio para que llame al DAO
						
						if (rol== null) {
							response = new ResponseEntity<Rol>(rol, HttpStatus.NOT_FOUND);
						}else {
							response = new ResponseEntity<Rol>(rol, HttpStatus.OK);
						}

					} catch (Exception e) {
						e.printStackTrace(); // TODO meter en LOG
						response = new ResponseEntity<Rol>(HttpStatus.INTERNAL_SERVER_ERROR);
					}

					return response;
				}















}//fin	