package com.ipartek.formacion.taller.service;

import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.ipartek.formacion.taller.service.exception.RolException;

public interface RolService {
	
	
	/**
	 * 
	 * @return
	 */
	List<Rol> listar();

	/**
	 * 
	 * @param idRol
	 * @return
	 */
	Rol detalle(int idRol);
	
	/**
	 * 
	 * @param idRol
	 * @return
	 * @throws RolException
	 */
	boolean eliminar(int idRol) throws RolException;
	
	/**
	 * 
	 * @param rol
	 * @return
	 * @throws RolException
	 */
	boolean crear(Rol rol) throws RolException;
	
	/**
	 * 
	 * @param rol
	 * @return
	 * @throws RolException
	 */
	
	boolean modificar(Rol rol) throws RolException;
}
