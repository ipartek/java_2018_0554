package com.ipartek.formacion.dgt.wssoap;

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.pojo.Coche;

public class WSVehiculo {
	public CocheDAO daoCoche;

	public Coche obtenerDatos(String matricula) {

		Coche c = null;
		try {

			daoCoche = CocheDAO.getInstance();
			c = daoCoche.getByMatricula(matricula);

		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Error");
		}

		return c;
	}
}
