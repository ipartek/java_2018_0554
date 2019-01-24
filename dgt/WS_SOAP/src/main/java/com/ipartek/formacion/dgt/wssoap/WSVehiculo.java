package com.ipartek.formacion.dgt.wssoap;

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.pojo.Coche;

public class WSVehiculo {

	private static CocheDAO cocheDAO;
	
	public WSVehiculo() {
		super();
		cocheDAO = CocheDAO.getInstance();
	}

	public Coche obtenerDatos ( String matricula ) {
		
		Coche c = null;
				
		if ( matricula != null ) {		
			c = cocheDAO.getByMatricula(matricula);
		}	
		
		return c;
	}

}
