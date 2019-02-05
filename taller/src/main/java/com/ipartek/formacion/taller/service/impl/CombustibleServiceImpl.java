package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
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

	@Autowired
	CombustibleDAO combustibleDao;

	@Autowired
	private ValidatorFactory factory;
	@Autowired
	private Validator validator;

//	private ValidatorFactory factory;
//	private Validator validator;
//	public CombustibleServiceImpl() {
//		super();
//		
//		factory = Validation.buildDefaultValidatorFactory();
//		validator = factory.getValidator();
//	}

	@Override
	public List<Combustible> listar() {
		return combustibleDao.getAll();
	}

	@Override
	public Combustible detalleId(int idCombustible) {
		return combustibleDao.getById(idCombustible);
	}

	@Override
	public boolean crear(Combustible combustible) throws CombustibleException {
		boolean isCreate = false;
		try {
			Set<ConstraintViolation<Combustible>> violations = validator.validate(combustible);
			if (violations.size() > 0) {
				throw new CombustibleException(violations.toString());
			} else {
				isCreate = combustibleDao.crear(combustible);
			}
		} catch (SQLException e) {
			throw new CombustibleException(CombustibleException.EXCEPTION_EXIST);
		}
		return isCreate;
	}

	@Override
	public boolean modificar(Combustible combustible) throws CombustibleException {
		boolean isUpdate = false;
		try {
			Set<ConstraintViolation<Combustible>> violations = validator.validate(combustible);
			if (violations.size() > 0) {
				throw new CombustibleException(violations.toString());
			} else {
				isUpdate = combustibleDao.update(combustible);
			}
		} catch (SQLException e) {
			throw new CombustibleException(CombustibleException.EXCEPTION_EXIST);
		}
		return isUpdate;
	}

	@Override
	public boolean eliminar(int idCombustible) throws CombustibleException {
		boolean isDelete = false;

		try {
			isDelete = combustibleDao.delete(idCombustible);
		} catch (SQLException e) {
			throw new CombustibleException(CombustibleException.EXCEPTION_CONSTRAINT);
		}

		return isDelete;
	}

}
