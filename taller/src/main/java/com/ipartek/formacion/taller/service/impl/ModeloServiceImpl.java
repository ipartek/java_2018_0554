package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.ModeloDAO;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.ipartek.formacion.taller.service.ModeloService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

@Service
public class ModeloServiceImpl implements ModeloService {

	private final static Logger LOG = Logger.getLogger(ModeloServiceImpl.class);
	@Autowired
	ModeloDAO modeloDAO;

	@Autowired
	private Validator validator;

	@Override
	public List<Modelo> listarCombustible() {
		return modeloDAO.getAll();
	}

	@Override
	public Modelo detalle(int idModelo) {
		return modeloDAO.getById(idModelo);
	}

	@Override
	public Boolean eliminar(int idModelo) throws CombustibleException {
		boolean resul = false;
		try {
			resul = modeloDAO.delete(idModelo);
		} catch (SQLException e) {
			LOG.debug(e);
			LOG.debug(CombustibleException.EXCEPTION_CONSTRAINT);
			throw new CombustibleException(CombustibleException.EXCEPTION_CONSTRAINT);
		}
		return resul;
	}

	@Override
	public Boolean crear(Modelo modelo) throws CombustibleException {
		boolean resul = false;
		Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
		if (violations.size() > 0) {
			for (ConstraintViolation<Modelo> violation : violations) {
				// Mensaje general, se podria sacar cada mensaje de error de los atributos de
				// Combustible validados
				throw new CombustibleException("Validaciones incorrectas");
			}
		} else {
			try {
				resul = modeloDAO.insert(modelo);
			} catch (SQLException e) {
				LOG.debug(e);
				LOG.debug(CombustibleException.EXCEPTION_EXIST);
				throw new CombustibleException(CombustibleException.EXCEPTION_EXIST);
			}
		}
		return resul;
	}

	@Override
	public Boolean modificar(Modelo modelo) throws CombustibleException {
		boolean resul = false;
		Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
		if (violations.size() > 0) {
			for (ConstraintViolation<Modelo> violation : violations) {
				// Mensaje general, se podria sacar cada mensaje de error de los atributos de
				// Combustible validados
				throw new CombustibleException("Validaciones incorrectas");
			}
		} else {
			try {
				resul = modeloDAO.update(modelo);
			} catch (SQLException e) {
				LOG.debug(e);
				LOG.debug(CombustibleException.EXCEPTION_EXIST);
				throw new CombustibleException(CombustibleException.EXCEPTION_EXIST);
			}
		}
		return resul;
	}
}
