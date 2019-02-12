package com.ipartek.formacion.taller.service.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.dao.ModeloDAO;
import com.ipartek.formacion.taller.modelo.dao.PersonaDAO;
import com.ipartek.formacion.taller.modelo.dao.VehiculoDAO;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.service.VehiculoService;
import com.ipartek.formacion.taller.service.exception.VehiculoException;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@Service
public class VehiculoServiceImpl implements VehiculoService {   // AQUI EN SERVICE IMPLEMENT SE VALIDA

	@Autowired
	private VehiculoDAO vehiculoDAO;  

	
	@Autowired
	CombustibleDAO combustibleDAO;
	
	@Autowired
	PersonaDAO personaDAO;
	
	@Autowired
	ModeloDAO modeloDAO;
 	
	@Autowired
	private Validator validator;        // Para validar
	
	
 	@Override
	public List<Vehiculo> listar() {
		
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();				// Creo un arraylista para guardar los datos del DAO  
		vehiculos = (ArrayList<Vehiculo>) vehiculoDAO.getAll();					// Guardo en el arrylist los datos del metodo GET_ALL del DAO
		

		for ( Vehiculo v : vehiculos ) {  										//recorro el array que he creado con los datos del dao para introducirle los datos de la persona y del combustible
			v.setCombustible( combustibleDAO.getByIdVehiculo( v.getId() ) );  	// IMPORTANTE: obtengo la id del vehiculo del que quiero coger los datos Y le introduzco a ese vehiculo los datos del combustible. PARA ESTO  UTILIZO OTRO METODO DAO. GET_BY_ID_VEHICULO.    
			v.setPersona( personaDAO.getByIdVehiculo( v.getId() ) );  																				 
		}
		
		return vehiculos;
	}
	
	// LLAMAR A DAO PARA DETALLE (GETBYID)
	@Override
	public Vehiculo detalle(int id) {
		return vehiculoDAO.getById(id);
	}


	// LLAMAR A DAO PARA ELIMINAR (DELETE)
	@Override
	public boolean eliminar(int idVehiculo) throws VehiculoException {		
		boolean isDelete = false;
		try {
			isDelete = vehiculoDAO.delete(idVehiculo);
		}catch ( SQLException e) {			
			throw new VehiculoException( VehiculoException.EXCEPTION_CONSTRAINT );
		}			
		return isDelete;
	}

	
	// LLAMAR A DAO PARA CREAR (INSERT)
	@Override
	public boolean crear(Vehiculo vehiculo) throws VehiculoException {   
		boolean isCreado = false;
		
		//Set<ConstraintViolation<Vehiculo>> violations = validator.validate(vehiculo);
		//if ( violations.isEmpty() ) {	
		try {
			isCreado = vehiculoDAO.create(vehiculo);  //SI SE CREA DEVUELVE TRUE
		}catch ( SQLException e) {			
			throw new VehiculoException( VehiculoException.EXCEPTION_CONSTRAINT );
		}
		//}else {
			//throw new VehiculoException( " necesitamos el nombre para crear un nuevo vehiculo" );
		//}
		return isCreado;
	}

	
	// LLAMAR A DAO PARA MODIFICAR (UPDATE)
	
	@Override
	public boolean modificar(Vehiculo vehiculo) throws VehiculoException {
		boolean isModificado = false;
		try {
			
			Set<ConstraintViolation<Vehiculo>> violations = validator.validate(vehiculo);
			if ( violations.isEmpty() ) {			
				isModificado = vehiculoDAO.update(vehiculo);				
			}else {
				throw new VehiculoException( VehiculoException.EXCEPTION_VIOLATIONS, violations );
			}	

		}catch ( SQLException e) {			
			throw new VehiculoException( VehiculoException.EXCEPTION_CONSTRAINT );
		}			
		return isModificado;
	}
	
}

	
	
	
	
	
	