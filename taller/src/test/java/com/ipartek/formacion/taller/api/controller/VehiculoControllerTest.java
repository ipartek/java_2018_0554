package com.ipartek.formacion.taller.api.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;

public class VehiculoControllerTest {

	@Test
	public void testPost() {


			VehiculoController vController = new VehiculoController();
			
			
			Vehiculo v = new Vehiculo();
			
			
			ResponseEntity response = vController.crear(v);
			
			
			assertEquals( 400 , response.getStatusCode() );
		
	}

}
