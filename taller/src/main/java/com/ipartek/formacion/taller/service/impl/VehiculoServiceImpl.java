package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.dao.ModeloDAO;
import com.ipartek.formacion.taller.modelo.dao.PersonaDAO;
import com.ipartek.formacion.taller.modelo.dao.VehiculoDAO;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
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

			v.setCombustible((combustibleDAO).getByVehiculoId(v.getId()));
			v.setModelo((modeloDAO).getByVehiculoId(v.getId()));
			v.setPropietario(personaDAO.getByVehiculoId(v.getId()));
		}

		return vehiculos;
	}

	@Override
	public Vehiculo detalle(int idVehiculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(int idVehiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crear(Vehiculo vehiculo) throws VehiculoException {

		boolean resul = false;

		Set<ConstraintViolation<Vehiculo>>  violations = validator.validate(vehiculo, VehiculosPostCheck.class);
		
		if ( violations.isEmpty() ) {

			try {
				resul = vehiculoDAO.insert(vehiculo);
				
				if( resul ) {
					// rellenar con resto de datos
					vehiculo.setPropietario(  personaDAO.getById(vehiculo.getPropietario().getId() ));
					vehiculo.setCombustible(  combustibleDAO.getById(vehiculo.getCombustible().getId()) );
					vehiculo.setModelo( modeloDAO.getById( vehiculo.getModelo().getId() ) );
				}
				
				
			}catch (Exception e) {
				throw new VehiculoException( e.getMessage() );
			}
			
		}else {
			throw new VehiculoException( "Validacion Incorrecta" );
		}
		return resul;
	}

	@Override
	public boolean modificar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return false;
	}

}
