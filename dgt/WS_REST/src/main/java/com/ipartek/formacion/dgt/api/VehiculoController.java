package com.ipartek.formacion.dgt.api;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.pojo.Coche;

@RestController
public class VehiculoController {

	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	private static CocheDAO cocheDAO;
	
	public VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();
	}
	
	
	@RequestMapping( value= {"/api/vehiculo"}, method = RequestMethod.GET)
	public ArrayList<Coche> listar(){		
		
		ArrayList<Coche> coches = new ArrayList<Coche>();
		coches.add( new Coche( 1L, "BI000CM", "Fiat", 34555 ) );
		coches.add( new Coche( 2L, "ZA000HK", "Flagoneta", 34555 ) );
		
		return coches;
	}
	
	
	@RequestMapping( value= {"/api/vehiculo/{id}"}, method = RequestMethod.GET)
	public ResponseEntity<Coche> detalle( @PathVariable long id ){		
		
		ResponseEntity<Coche> response = new ResponseEntity<Coche>( HttpStatus.NOT_FOUND );
		
		if ( id > 0 ) {
			
			Coche c = new Coche( 2L, "ZA000HK", "Flagoneta", 34555 );
			c.setId(id);
			response = new ResponseEntity<Coche>( c, HttpStatus.OK );			
		}
			 	
		return response;
	}
	
	
	@RequestMapping( value= {"/api/vehiculo/{id}"}, method = RequestMethod.DELETE)
	public ResponseEntity<Coche> eliminar( @PathVariable long id ){		
		
		ResponseEntity<Coche> response = new ResponseEntity<Coche>( HttpStatus.NOT_FOUND );
		
		if ( id > 0 ) {
			
			response = new ResponseEntity<Coche>(HttpStatus.OK );	
			
			//TODO 409 cuando no se pueda eliminar Coche porque tiene multas asociadas
			
		}
			 	
		return response;
	}
	
	
	@RequestMapping( value= {"/api/vehiculo/"}, method = RequestMethod.POST)
	public ResponseEntity<Coche> crear( @RequestBody Coche coche ){
		
		//TODO terminar		
		// 201 creado y retornar coche con id actulizado		
		// 400 datos del coche no son correctos, por ejemplo sin matricula o vacia		
		// 409 ya exsite la matricula Unique Key 		
		return new ResponseEntity<Coche>( HttpStatus.NOT_IMPLEMENTED );		
	}
	
	@RequestMapping( value= {"/api/vehiculo/{id}"}, method = RequestMethod.PUT)
	public ResponseEntity<Coche> modificar(  
				@PathVariable long id, 
				@RequestBody Coche coche ){
		
		//TODO terminar
		return new ResponseEntity<Coche>( HttpStatus.NOT_IMPLEMENTED );		
	}
	
	@RequestMapping( value= {"/api/vehiculo/{id}"}, method = RequestMethod.PATCH)
	public ResponseEntity<Coche> darDeBaja( @PathVariable long id,  @RequestBody Coche coche ){		
		
		//TODO terminar
		return new ResponseEntity<Coche>( HttpStatus.NOT_IMPLEMENTED );
	}
	
	
	
	
	
}
