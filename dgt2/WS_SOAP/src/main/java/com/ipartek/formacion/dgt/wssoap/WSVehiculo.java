package com.ipartek.formacion.dgt.wssoap;

import com.ipartek.appMultas.modelo.dao.CocheDAO;
import com.ipartek.appMultas.modelo.pojo.Coche;

public class WSVehiculo {
	private static CocheDAO dao = null;
	
	public WSVehiculo() {
		super();
		dao = CocheDAO.getInstance();
	}
	
	public Coche obtenerDatos (String matricula) {
		
		Coche c = null;
		if (matricula != null) {
			c = dao.getByMatricula(matricula);
		}
		
		return c;
	}

}
