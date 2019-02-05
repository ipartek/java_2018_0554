package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.daos.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@Service
public class CombustibleServiceImpl implements CombustibleService {

	@Autowired
	CombustibleDAO combustibleDAO;

	@Autowired
	private Validator validator;
	
	@Override
	public List<Combustible> listar() {
		// TODO Auto-generated method stub
		return combustibleDAO.getAll();
	}

	@Override
	public Combustible detalle(int id) {

		return combustibleDAO.getById(id);
	}

	@Override
	public boolean eliminar(int idCombustible) throws CombustibleException {
		boolean isDelete = false;
		try {
			isDelete = combustibleDAO.delete(idCombustible);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CombustibleException(CombustibleException.EXCEPTION_CONSTRAINT);
		}

		return isDelete;
	}

	@Override
	public boolean crear(int id) throws CombustibleException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean modificar(Combustible combustible) throws CombustibleException {
		boolean isModificado = false;
		try {

		
			Set<ConstraintViolation<Combustible>> violations = validator.validate(combustible);
			if (violations.isEmpty()) {
				isModificado = combustibleDAO.update(combustible);

			} else {
				throw new CombustibleException("");
			}

		} catch (SQLException e) {
			throw new CombustibleException(CombustibleException.EXCEPTION_CONSTRAINT);
		}
		return isModificado;
	}
}
