package com.ipartek.formacion.dgt.api;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.appMultas.modelo.dao.CocheDAO;
import com.ipartek.appMultas.modelo.pojo.Coche;

@RestController
public class VehiculoController {
	
	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	public static CocheDAO cocheDAO;
	
	public VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();
	}
	
	@RequestMapping(value=("/api/vehiculo"), method=RequestMethod.GET)
	public ArrayList<Coche> listar(){
		
		//ArrayList<Coche> coches = new ArrayList<Coche>();
		//coches.add(new Coche((long)1, "BI000CM", "Fiat", (long)34555));
		//coches.add(new Coche((long)2, "ZA000HK", "Flagoneta", (long)34555));
		
		return cocheDAO.getAll();
	}
	
	/*
	 * RequestParam para parametros. ej: ?id=1 @RequestParam(value="id") Long id
	 * PathVariable para uris. ej: @PathVariable long id
	 */
	@RequestMapping(value=("/api/vehiculo/{id}"),method=RequestMethod.GET)
	public ResponseEntity<Coche> detalle(@PathVariable long id){
		Coche c = null;
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(c,HttpStatus.NOT_FOUND);
		
		if(id>0) {
			c= cocheDAO.getBYId(id);
			response = new ResponseEntity<Coche>(c,HttpStatus.OK);
		}
		
		return response;
	}

}
