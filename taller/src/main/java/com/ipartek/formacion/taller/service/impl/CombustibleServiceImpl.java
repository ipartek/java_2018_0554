package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

@Service
public class CombustibleServiceImpl implements CombustibleService {

	private ValidatorFactory factory;
	private Validator validator;

	@Autowired
	CombustibleDAO combustibleDAO;

	public CombustibleServiceImpl() {
		super();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Override
	public List<Combustible> listar() {
		return combustibleDAO.getAll();
	}

	@Override
	public Combustible detalle(int idCombustible) {
		return combustibleDAO.getById(idCombustible);
	}

	@Override
	public boolean eliminar(int idCombustible) throws CombustibleException {
		boolean isDelete = false;
		try {
			isDelete = combustibleDAO.delete(idCombustible);
		} catch (SQLException e) {
			throw new CombustibleException(CombustibleException.EXCEPTION_CONSTRAINT);
		}
		return isDelete;
	}

	@Override
	public boolean crear(Combustible combustible) throws CombustibleException {
		boolean isInserted = false;
		try {
			Set<ConstraintViolation<Combustible>> violations = validator.validate(combustible);
			if (violations.size() > 0) {
				throw new CombustibleException(violations.toString());
			} else {
				isInserted = combustibleDAO.insert(combustible);
			}
		} catch (SQLException e) {
			throw new CombustibleException(CombustibleException.EXCEPTION_EXIST);
		}
		return isInserted;
	}

	@Override
	public boolean modificar(Combustible combustible) throws CombustibleException {
		boolean isUpdated = false;
		try {
			Set<ConstraintViolation<Combustible>> violations = validator.validate(combustible);
			if (violations.size() > 0) {
				throw new CombustibleException(violations.toString());
			} else {
				isUpdated = combustibleDAO.update(combustible);
			}
		} catch (SQLException e) {
			throw new CombustibleException(CombustibleException.EXCEPTION_CONSTRAINT);
		}
		return isUpdated;
	}

}
