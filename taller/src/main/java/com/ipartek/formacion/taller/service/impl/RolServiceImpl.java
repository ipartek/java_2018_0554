package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.RolDAO;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.ipartek.formacion.taller.service.RolService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;
import com.ipartek.formacion.taller.service.exception.RolException;


@Service
public class RolServiceImpl implements RolService{
	
	@Autowired
	private RolDAO rolDAO;
	
	@Autowired
	private Validator validator;
	
	@Override
	public ArrayList<Rol> listar() {		
		return rolDAO.getAll();
	}

	@Override
	public Rol detalle(int id) {
		
		return rolDAO.getById(id);
	}

	@Override
	public boolean eliminar(int idRol) throws RolException {
		boolean isDelete = false;
		try {
			isDelete = rolDAO.delete(idRol);
		}catch ( SQLException e) {			
			throw new RolException( RolException.EXCEPTION_CONSTRAINT );
		}			
		return isDelete;
	}

	@Override
	public boolean crear(Rol rol) throws RolException {
		boolean isCreado = false;
		try {

			Set<ConstraintViolation<Rol>> violations = validator.validate(rol);
			if (violations.isEmpty()) {
				isCreado = rolDAO.insert(rol);
			} else {
				throw new RolException(RolException.EXCEPTION_VIOLATIONS, violations);
			}

		} catch (SQLException e) {
			throw new RolException(RolException.EXCEPTION_CONSTRAINT);
		}
		return isCreado;
	}

	@Override
	public boolean modificar(Rol rol) throws RolException {
		boolean isModificado = false;
		try {
			
			Set<ConstraintViolation<Rol>> violations = validator.validate(rol);
			if ( violations.isEmpty() ) {			
				isModificado = rolDAO.update(rol);
				
			}else {
				throw new RolException(CombustibleException.EXCEPTION_VIOLATIONS, violations );
			}	

		}catch ( SQLException e) {			
			throw new RolException( RolException.EXCEPTION_CONSTRAINT );
		}			
		return isModificado;
	}
}
