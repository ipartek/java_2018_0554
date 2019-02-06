package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ipartek.formacion.taller.modelo.dao.RolDAO;
import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.ipartek.formacion.taller.service.RolService;
import com.ipartek.formacion.taller.service.exception.RolException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	RolDAO rolDAO;

	@Autowired
	private Validator validator;

	@Override
	public List<Rol> listar() {
		// TODO Auto-generated method stub
		return rolDAO.getAll();
	}

	@Override
	public Rol detalle(int id) {

		return RolDAO.getById(id);
	}

	@Override
	public boolean eliminar(int idRol) throws RolException {
		boolean isDelete = false;
		try {
			isDelete = rolDAO.delete(idRol);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RolException(RolException.EXCEPTION_CONSTRAINT);
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
				throw new RolException("");
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
			if (violations.isEmpty()) {
				isModificado = rolDAO.update(rol);

			} else {
				throw new RolException("");
			}

		} catch (SQLException e) {
			throw new RolException(RolException.EXCEPTION_CONSTRAINT);
		}
		return isModificado;
	}
}
