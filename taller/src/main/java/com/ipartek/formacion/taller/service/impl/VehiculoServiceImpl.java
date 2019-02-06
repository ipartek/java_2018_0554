package com.ipartek.formacion.taller.service.impl;

import java.util.List;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.taller.modelo.dao.VehiculoDAO;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.service.VehiculoService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;
import com.ipartek.formacion.taller.service.exception.VehiculoException;

public class VehiculoServiceImpl implements VehiculoService{

	@Autowired
	VehiculoDAO vehiculoDAO;

	@Autowired
	private ValidatorFactory factory;
	@Autowired
	private Validator validator;
	
	
	@Override
	public List<Vehiculo> listar() {
		return vehiculoDAO.getAll();
	}

	@Override
	public Vehiculo detalleId(int idVehiculo) {
		return vehiculoDAO.getById(idVehiculo);
	}

	@Override
	public boolean eliminar(int idVehiculo) throws VehiculoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crear(Vehiculo vehiculo) throws VehiculoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Vehiculo vehiculo) throws VehiculoException {
		// TODO Auto-generated method stub
		return false;
	}


}
