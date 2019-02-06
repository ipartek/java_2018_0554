package com.ipartek.formacion.taller.service.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	private VehiculoDAO vehiculoDAO;  	// para enviar a dao

 	@Autowired
	private Validator validator;         		// Para validar
	
	
	// LLAMAR A DAO PARA LISTAR (GETALL)
	@Override	
	public List<Vehiculo> listar() {		
		return vehiculoDAO.getAll();
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
		Set<ConstraintViolation<Vehiculo>> violations = validator.validate(vehiculo);
		if ( violations.isEmpty() ) {	
		try {
			isCreado = vehiculoDAO.create(vehiculo);
		}catch ( SQLException e) {			
			throw new VehiculoException( VehiculoException.EXCEPTION_CONSTRAINT );
		}
		}else {
			throw new VehiculoException( " necesitamos el nombre para crear un nuevo vehiculo" );
		}
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

	
	
	
	
	
	