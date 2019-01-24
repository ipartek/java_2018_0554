package com.ipartek.formacion.dgt.wssoap;

import com.ipartek.appMultas.modelo.dao.CocheDAO;
import com.ipartek.appMultas.modelo.pojo.Coche;

public class WSVehiculo {
	
	private static CocheDAO cocheDao;
	
	// No coge los metodos privados y los contructores
	public WSVehiculo(){
		super();
		 cocheDao = CocheDAO.getInstance();
	}
	
	
	public Coche obtenerDatos(String matricula) {		
		Coche c = null;
		if(matricula != null) {
			c= cocheDao.getByMatricula(matricula);
		}	
		
		return c;
		
	}
}
