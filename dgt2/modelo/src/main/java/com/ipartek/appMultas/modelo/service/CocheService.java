package com.ipartek.appMultas.modelo.service;

import java.util.List;

import com.ipartek.appMultas.modelo.pojo.Coche;

public interface CocheService {
	
	/**
	 * Listado de coches ordenado por ID descendente
	 * @return List<Coche>, Lista vacía si no hay datos
	 */
	List<Coche> listar();
	
	/**
	 * Obtiene el detalle de un coche especificado
	 * @param id Long identificador del coche
	 * @return Si lo encuentra: <b>Coche</b>; Si no: <b>null</b>
	 */
	Coche detalle(Long id);
	
	/**
	 * Elimina un Coche por su identificador
	 * @param id Long identificador del coche
	 * @return <b>True</b> si elimina, <b>False</b> si no lo encuentra
	 */
	boolean eliminar(Long id);
	
	boolean crear(Coche coche);
	
	boolean modificar(Coche coche);

}
