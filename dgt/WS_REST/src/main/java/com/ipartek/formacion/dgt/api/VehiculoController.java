package com.ipartek.formacion.dgt.api;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.appMultas.modelo.dao.CocheDAO;
import com.ipartek.appMultas.modelo.pojo.Coche;

@RestController
public class VehiculoController {

	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	public static CocheDAO cocheDao;
	
	public VehiculoController() {
		super();
		cocheDao = CocheDAO.getInstance();
	}
	
	@RequestMapping( value= {"/api/vehiculo"}, method = RequestMethod.GET)
	public ArrayList<Coche> listar(){
		//ArrayList<Coche> coches = new ArrayList<Coche>();
		//coches.add(new Coche(1L, "BI000CM", "Fiat", 34555L));
		//coches.add(new Coche(2L, "ZA000HK", "Flagoneta", 34555L));
		return cocheDao.getAll();
	}
	
	@RequestMapping( value= {"/api/vehiculo/{id}"}, method = RequestMethod.GET)
	public Coche detalle(@PathVariable Long id) {
		return cocheDao.getBYId(id);
	}
	
}
