package com.ipartek.formacion.dgt.wssoap;

import com.ipartek.formacion.modelo.pojo.Coche;

public class WSVehiculo {

	public Coche obtenerDatos(String matricula) {
		
		Coche c = new Coche();
		c.setModelo("Mock coche");
		c.setMatricula("TODO llamar DAO");
		return c;
	}
}
