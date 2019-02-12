package com.ipartek.formacion.animales.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.animales.modelo.dao.ClienteDAO;
import com.ipartek.formacion.animales.modelo.dao.CompraDAO;
import com.ipartek.formacion.animales.modelo.dao.EmpleadoDAO;
import com.ipartek.formacion.animales.modelo.dao.StockDAO;
import com.ipartek.formacion.animales.modelo.dao.TipoDAO;
import com.ipartek.formacion.animales.modelo.pojo.Compra;
import com.ipartek.formacion.animales.service.CompraService;
import com.ipartek.formacion.animales.service.exception.AnimalException;
import com.ipartek.formacion.animales.service.exception.CompraException;

@Service
public class CompraServiceImp implements CompraService {

	@Autowired
	CompraDAO compraDAO;

	@Autowired
	StockDAO stockDAO;

	@Autowired
	EmpleadoDAO empleadoDAO;

	@Autowired
	ClienteDAO clienteDAO;

	@Autowired
	private Validator validator;

	// Eliminar
	@Override
	public boolean eliminar(int idCompra) throws CompraException {
		boolean isDelete = false;
		try {
			isDelete = compraDAO.delete(idCompra);
		} catch (SQLException e) {
			throw new CompraException(CompraException.EXCEPTION_CONSTRAINT);
		}
		return isDelete;
	}

	// crear
	@Override
	public boolean crear(Compra compra) throws CompraException {
		boolean isCreado = false;
		try {

			Set<ConstraintViolation<Compra>> violations = validator.validate(compra);
			if (violations.isEmpty()) {

				isCreado = compraDAO.insert(compra);

				compra.setStock(stockDAO.getByIdStock(compra.getId()));
				compra.setEmpleado(empleadoDAO.getByIdEmpleado(compra.getId()));
				compra.setCliente(clienteDAO.getByIdCliente(compra.getId()));

			} else {
				throw new CompraException(CompraException.EXCEPTION_VIOLATIONS, violations);
			}

		} catch (SQLException e) {
			throw new CompraException(CompraException.EXCEPTION_CONSTRAINT);
		}
		return isCreado;
	}

	@Override
	public List<Compra> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compra detalle(int idCompra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Compra compra) throws CompraException {
		// TODO Auto-generated method stub
		return false;
	}

}
