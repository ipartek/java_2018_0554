package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.dao.ModeloDAO;
import com.ipartek.formacion.taller.modelo.dao.PersonaDAO;
import com.ipartek.formacion.taller.modelo.dao.VehiculoDAO;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.modelo.pojo.validactions.VehiculosPostCheck;
import com.ipartek.formacion.taller.service.VehiculoService;
import com.ipartek.formacion.taller.service.exception.VehiculoException;

@Service
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	VehiculoDAO vehiculoDAO;

	@Autowired
	CombustibleDAO combustibleDAO;

	@Autowired
	ModeloDAO modeloDAO;

	@Autowired
	PersonaDAO personaDAO;

	@Autowired
	Validator validator;

	@Override
	public List<Vehiculo> listar() {

		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		vehiculos = (ArrayList<Vehiculo>) vehiculoDAO.getAll();

		for (Vehiculo v : vehiculos) {

			v.setCombustible(combustibleDAO.getByVehiculoId(v.getId()));
			v.setModelo(modeloDAO.getByVehiculoID(v.getId()));
			v.setPropietario(personaDAO.getByVehiculoId(v.getId()));
		}

		return vehiculos;
	}

	@Override
	public Vehiculo detalle(int idVehiculo) {
		Vehiculo v = null;
		v = vehiculoDAO.getById(idVehiculo);
		if (v != null) {
			v.setCombustible(combustibleDAO.getByVehiculoId(idVehiculo));
			v.setModelo(modeloDAO.getByVehiculoID(idVehiculo));
			v.setPropietario(personaDAO.getByVehiculoId(idVehiculo));
		}
		return v;
	}

	@Override
	public boolean eliminar(int idVehiculo) throws VehiculoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crear(Vehiculo vehiculo) throws VehiculoException {
		boolean resul = false;
		Set<ConstraintViolation<Vehiculo>> violations = validator.validate(vehiculo, VehiculosPostCheck.class);
		if (violations.isEmpty()) {

			try {
				resul = vehiculoDAO.insert(vehiculo);
				if (resul) {
					vehiculo.setCombustible(combustibleDAO.getByVehiculoId(vehiculo.getId()));
					vehiculo.setModelo(modeloDAO.getByVehiculoID(vehiculo.getId()));
					vehiculo.setPropietario(personaDAO.getByVehiculoId(vehiculo.getId()));
				}
			} catch (SQLException e) {
				throw new VehiculoException(VehiculoException.EXCEPTION_INTEGRITY,violations);
			}

		} else {
			throw new VehiculoException(VehiculoException.EXCEPTION_VIOLATIONS,violations);
		}
		return resul;
	}

	@Override
	public boolean modificar(Vehiculo vehiculo) throws VehiculoException {
		// TODO Auto-generated method stub
		return false;
	}

}
