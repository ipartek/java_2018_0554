package com.ipartek.formacion.taller.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.dao.ModeloDAO;
import com.ipartek.formacion.taller.modelo.dao.PersonaDAO;
import com.ipartek.formacion.taller.modelo.dao.VehiculoDAO;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.service.VehiculoService;
import com.ipartek.formacion.taller.service.exception.PersonaException;

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

	@Override
	public List<Vehiculo> listar() {
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();		
		vehiculos = (ArrayList<Vehiculo>) vehiculoDAO.getAll();
		
		for ( Vehiculo v : vehiculos ) {
			
			v.setCombustible( (combustibleDAO).getByVehiculoId( v.getId() ) );
			v.setModelo( (modeloDAO).getByVehiculoId( v.getId() ) );
			v.setPropietario( personaDAO.getByVehiculoId( v.getId() ) );			
		}
		
		return vehiculos;
	}

	@Override
	public Vehiculo detalle(int idVehiculo) {
		Vehiculo vehiculo = vehiculoDAO.getById(idVehiculo);
		return vehiculo;
	}

	@Override
	public boolean eliminar(int idVehiculo){
		boolean eliminado = false;
		try {
			eliminado = vehiculoDAO.delete(idVehiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eliminado;

	}

	@Override
	public boolean crear(Vehiculo vehiculo)  {
				
		boolean resul = false;
		try {
			resul = vehiculoDAO.insert(vehiculo);
		}catch (Exception e) {
			e.printStackTrace();
			// throw new Exception("ME va a apedir que ele metodo haga thorws");
		}
		
		return resul;
	}

	@Override
	public boolean modificar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return false;
	}

}
