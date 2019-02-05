package com.ipartek.formacion.taller.service;

import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.ipartek.formacion.taller.service.exception.ModeloException;

public interface ModeloService {
	
	/**
	 * 
	 * @return
	 */
	List<Modelo> listar();

	/**
	 * 
	 * @param idModelo
	 * @return
	 */
	Modelo detalle(int idModelo);
	
	/**
	 * 
	 * @param idModelo
	 * @return
	 * @throws ModeloException
	 */
	boolean eliminar(int idModelo) throws ModeloException;
	
	/**
	 * 
	 * @param modelo
	 * @return
	 * @throws ModeloException
	 */
	boolean crear(Modelo modelo) throws ModeloException;
	
	
	/**
	 * 
	 * @param modelo
	 * @return
	 * @throws ModeloException
	 */
	boolean modificar(Modelo modelo) throws ModeloException;

}
