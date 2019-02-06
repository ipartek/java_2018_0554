package com.ipartek.formacion.taller.service;

import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.service.exception.VehiculoException;

public interface VehiculoService {

	List<Vehiculo> listar();
	
	Vehiculo detalleId(int idVehiculo);
	
	boolean eliminar(int idVehiculo) throws VehiculoException;
	
	boolean crear(Vehiculo vehiculo) throws VehiculoException ;
	
	boolean modificar(Vehiculo vehiculo) throws VehiculoException;
	
	
}
