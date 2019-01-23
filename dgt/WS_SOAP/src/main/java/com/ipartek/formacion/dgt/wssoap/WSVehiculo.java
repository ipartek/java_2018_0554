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
		
		if( c == null ) {
			c = new Coche();
			c.setModelo("No se ha encontrado ningun Vehiculo");
			c.setMatricula(matricula);			
		}
		
		return c;
	}

}
