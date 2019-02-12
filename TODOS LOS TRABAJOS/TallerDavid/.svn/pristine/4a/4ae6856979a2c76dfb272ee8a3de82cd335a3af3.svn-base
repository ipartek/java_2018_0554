package com.ipartek.formacion.taller.service;

import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;

public interface VehiculoService {
	
	/**
	 * Listado de todos los vehículos registrados ordenado por ID descendente
	 * @return List<Vehiculo>, Lista vacía si no hay datos 
	 */
	List<Vehiculo> listar();
	
	/**
	 * Detalle de un Vehículo concreto
	 * @param idVehiculo int ID del Vehículo del que se quiere obtener el detalle
	 * @return Vehículo, <b>Null</b> si no existe
	 */
	Vehiculo detalle(int idVehiculo);
	
	/**
	 * Elimina el Vehículo del que se proporcione su ID
	 * @param idVehiculo int ID del Vehículo a eliminar
	 * @return <b>True</b> si elimina, <b>False</b> si no lo encuentra
	 */
	boolean eliminar(int idVehiculo);
	
	/**
	 * Crear un nuevo Vehículo en la BD. Al crear con éxito, actualiza el <b>ID</b>
	 * @param vehiculo Vehículo a crear
	 * @return <b>True</b> si lo crea, <b>False</b> si no lo puede crear, P.E: 
	 * <b>Número de bastido</b> mínimo 1 caracter, máximo 45 y debe ser único
	 * <b>Matrícula</b> mínimo 1 caracter, máximo 10 y debe ser única
	 */
	boolean crear(Vehiculo vehiculo);
	
	/**
	 * Modifica los datos de un Vehículo identificado por su ID.
	 * @param vehiculo Vehículo a modificar
	 * @return <b>True</b> si lo modifica, <b>False</b> si no lo encuentra o no cumple los requisitos de integridad
	 */
	boolean modificar(Vehiculo vehiculo);

}
