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
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.modelo.pojo.validactions.VehiculosPostCheck;
import com.ipartek.formacion.taller.service.VehiculoService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;
import com.ipartek.formacion.taller.service.exception.VehiculoException;

@Service
public class VehiculoServiceImpl implements VehiculoService{

	@Autowired
	VehiculoDAO vehiculoDAO;
	
	@Autowired
	CombustibleDAO combustibleDAO;
	
	@Autowired
	PersonaDAO personaDAO;
	
	@Autowired
	ModeloDAO modeloDAO;
	
	@Autowired
	private Validator validator;
	
	@Override
	public List<Vehiculo> listar() {
		
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();		
		vehiculos = (ArrayList<Vehiculo>) vehiculoDAO.getAll();	
		for ( Vehiculo v : vehiculos ) {
			
			v.setCombustible( combustibleDAO.getByIdVehiculo( v.getId() ) );   
			v.setPersona( personaDAO.getByIdVehiculo( v.getId() ) );  
		// pongo la id y el nombre del combustible en el dao de un coche cuya id pongo con @patch varible del controller  
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

	
	
	
	
	// CON VALIDACIONES POR GRUPOS
	@Override
	public boolean crear(Vehiculo vehiculo) throws VehiculoException  {
		
		boolean isCreado = false;
		
		Set<ConstraintViolation<Vehiculo>>violations =validator.validate(vehiculo, VehiculosPostCheck.class);
		
	if (violations.isEmpty()) {
		try {
				
				isCreado = vehiculoDAO.insert(vehiculo);				
			if (isCreado) {
				
			}
		}catch ( Exception e) {			
			throw new VehiculoException(e.getMessage());
		}
		
	}else {
		throw new VehiculoException ("Validacion INcorecta");
	}
		return isCreado;
	}

	
	
	
	
	@Override
	public boolean modificar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return false;
	}

}
