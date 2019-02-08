package com.ipartek.formacion.taller.service.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.ModeloDAO;
import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.ipartek.formacion.taller.service.ModeloService;
import com.ipartek.formacion.taller.service.exception.ModeloException;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@Service
public class ModeloServiceImpl implements ModeloService {   // AQUI EN SERVICE IMPLEMENT SE VALIDA

	@Autowired
	private ModeloDAO modeloDAO;  	// para enviar a dao

 	@Autowired
	private Validator validator;         		// Para validar
	
	
	// LLAMAR A DAO PARA LISTAR (GETALL)
	@Override	
	public List<Modelo> listar() {		
		return modeloDAO.getAll();
	}

	
	// LLAMAR A DAO PARA DETALLE (GETBYID)
	@Override
	public Modelo detalle(int id) {
		return modeloDAO.getById(id);
	}


	// LLAMAR A DAO PARA ELIMINAR (DELETE)
	@Override
	public boolean eliminar(int idModelo) throws ModeloException {		
		boolean isDelete = false;
		try {
			isDelete = modeloDAO.delete(idModelo);
		}catch ( SQLException e) {			
			throw new ModeloException( ModeloException.EXCEPTION_CONSTRAINT );
		}			
		return isDelete;
	}

	
	// LLAMAR A DAO PARA CREAR (INSERT)
	@Override
	public boolean crear(Modelo modelo) throws ModeloException {   
		boolean isCreado = false;
	try {
			
			Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
			if ( violations.isEmpty() ) {			
				isCreado = modeloDAO.insert(modelo);				
			}else {
				throw new ModeloException( ModeloException.EXCEPTION_VIOLATIONS, violations );
			}	

		}catch ( SQLException e) {			
			throw new ModeloException( ModeloException.EXCEPTION_CONSTRAINT );
		}			
		return isCreado;
	}

	

	// LLAMAR A DAO PARA MODIFICAR (UPDATE)
	
	@Override
	public boolean modificar(Modelo modelo) throws ModeloException {
		boolean isModificado = false;
		try {
			
			Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
			if ( violations.isEmpty() ) {			
				isModificado = modeloDAO.update(modelo);				
			}else {
				throw new ModeloException( ModeloException.EXCEPTION_VIOLATIONS, violations );
			}	

		}catch ( SQLException e) {			
			throw new ModeloException( ModeloException.EXCEPTION_CONSTRAINT );
		}			
		return isModificado;
	}
	
}

	
	
	
	