package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.ModeloDAO;
import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.ipartek.formacion.taller.service.ModeloService;
import com.ipartek.formacion.taller.service.exception.ModeloException;

@Service
public class ModeloServiceImpl implements ModeloService{

	@Autowired
	private ModeloDAO modeloDAO;
	
	@Autowired
	private Validator validator;
	
	@Override
	public List<Modelo> listar() {
		return modeloDAO.getAll();
	}

	@Override
	public Modelo detalle(int id) {
		return modeloDAO.getById(id);
	}

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

	@Override
	public boolean crear(Modelo modelo) throws ModeloException {
		boolean isCreate = false;
		try {

			isCreate = modeloDAO.insert(modelo);

		} catch (SQLException e) {
			throw new ModeloException(ModeloException.EXCEPTION_EXIST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCreate;
	}

	@Override
	public boolean modificar(Modelo modelo) throws ModeloException {
		boolean isModificado = false;
		try {
			
			Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
			if ( violations.isEmpty() ) {			
				isModificado = modeloDAO.update(modelo);
				
			}else {
				throw new ModeloException( "" );
			}	

		}catch ( SQLException e) {			
			throw new ModeloException( ModeloException.EXCEPTION_CONSTRAINT );
		}			
		return isModificado;
	}

}
