package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.api.pojo.Mensaje;
import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

@Service
public class CombustibleServiceImpl implements CombustibleService {

	private final static Logger LOG = Logger.getLogger(CombustibleServiceImpl.class);
	@Autowired
	CombustibleDAO combustibleDAO;

	@Autowired
	private Validator validator;

	@Override
	public List<Combustible> listarCombustible() {
		return combustibleDAO.getAll();
	}

	@Override
	public Combustible detalle(int idCombustible) {
		return combustibleDAO.getById(idCombustible);
	}

	@Override
	public Boolean eliminar(int idCombustible) throws CombustibleException {
		boolean resul = false;
		try {
			resul = combustibleDAO.delete(idCombustible);
		} catch (SQLException e) {
			LOG.debug(e);
			LOG.debug(CombustibleException.EXCEPTION_CONSTRAINT);
			throw new CombustibleException(CombustibleException.EXCEPTION_CONSTRAINT);
		}
		return resul;
	}

	@Override
	public Boolean crear(Combustible combustible) throws CombustibleException {
		boolean resul = false;
		Set<ConstraintViolation<Combustible>> violations = validator.validate(combustible);
		if (violations.size() > 0) {
			for (ConstraintViolation<Combustible> violation : violations) {
				// Mensaje general, se podria sacar cada mensaje de error de los atributos de
				// Combustible validados
				throw new CombustibleException("Validaciones incorrectas");
			}
		} else {
			try {
				resul = combustibleDAO.insert(combustible);
			} catch (SQLException e) {
				LOG.debug(e);
				LOG.debug(CombustibleException.EXCEPTION_EXIST);
				throw new CombustibleException(CombustibleException.EXCEPTION_EXIST);
			}
		}
		return resul;
	}

	@Override
	public Boolean modificar(Combustible combustible) throws CombustibleException {
		boolean resul = false;
		Set<ConstraintViolation<Combustible>> violations = validator.validate(combustible);
		if (violations.size() > 0) {
			for (ConstraintViolation<Combustible> violation : violations) {
				// Mensaje general, se podria sacar cada mensaje de error de los atributos de
				// Combustible validados
				throw new CombustibleException("Validaciones incorrectas");
			}
		} else {
			try {
				resul = combustibleDAO.update(combustible);
			} catch (SQLException e) {
				LOG.debug(e);
				LOG.debug(CombustibleException.EXCEPTION_EXIST);
				throw new CombustibleException(CombustibleException.EXCEPTION_EXIST);
			}
		}
		return resul;
	}
}
