package com.ipartek.formacion.taller.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.service.VehiculoService;

@CrossOrigin
@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoController {

	@Autowired
	VehiculoService vehiculoService;
}
