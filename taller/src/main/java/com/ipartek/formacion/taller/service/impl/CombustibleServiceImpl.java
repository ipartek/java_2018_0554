package com.ipartek.formacion.taller.service.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@Service
public class CombustibleServiceImpl implements CombustibleService {   // AQUI EN SERVICE IMPLEMENT SE VALIDA

	@Autowired
	private CombustibleDAO combustibleDAO;  	// para enviar a dao

 	@Autowired
	private Validator validator;         		// Para validar
	
	
	// LLAMAR A DAO PARA LISTAR (GETALL)
	@Override	
	public List<Combustible> listar() {		
		return combustibleDAO.getAll();
	}

	
	// LLAMAR A DAO PARA DETALLE (GETBYID)
	@Override
	public Combustible detalle(int id) {
		return combustibleDAO.getById(id);
	}


	// LLAMAR A DAO PARA ELIMINAR (DELETE)
	@Override
	public boolean eliminar(int idCombustible) throws CombustibleException {		
		boolean isDelete = false;
		try {
			isDelete = combustibleDAO.delete(idCombustible);
		}catch ( SQLException e) {			
			throw new CombustibleException( CombustibleException.EXCEPTION_CONSTRAINT );
		}			
		return isDelete;
	}

	
	// LLAMAR A DAO PARA CREAR (INSERT)
	@Override
	public boolean crear(Combustible combustible) throws CombustibleException {   
		boolean isCreado = false;
		Set<ConstraintViolation<Combustible>> violations = validator.validate(combustible);
		if ( violations.isEmpty() ) {	
		try {
			isCreado = combustibleDAO.create(combustible);
		}catch ( SQLException e) {			
			throw new CombustibleException( CombustibleException.EXCEPTION_CONSTRAINT );
		}
		}else {
			throw new CombustibleException( " necesitamos el nombre para crear un nuevo combustible" );
		}
		return isCreado;
	}

	
	// LLAMAR A DAO PARA MODIFICAR (UPDATE)
	
	@Override
	public boolean modificar(Combustible combustible) throws CombustibleException {
		boolean isModificado = false;
		try {
			
			Set<ConstraintViolation<Combustible>> violations = validator.validate(combustible);
			if ( violations.isEmpty() ) {			
				isModificado = combustibleDAO.update(combustible);				
			}else {
				throw new CombustibleException( CombustibleException.EXCEPTION_VIOLATIONS, violations );
			}	

		}catch ( SQLException e) {			
			throw new CombustibleException( CombustibleException.EXCEPTION_CONSTRAINT );
		}			
		return isModificado;
	}
	
}

	
	
	
	
	
	
	
	
	
	
	

