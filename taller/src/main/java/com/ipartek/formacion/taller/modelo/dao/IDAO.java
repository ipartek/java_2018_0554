package com.ipartek.formacion.taller.modelo.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz para que los DAOs implementen las operaciones basicas de CRUD
 * 
 * @author ur00
 *
 */
public interface IDAO<P> {

	P getById(int id);

	List<P> getAll();

	boolean insert(P pojo) throws SQLException;

	boolean delete(int id) throws SQLException;

	boolean update(P pojo) throws SQLException;

}
