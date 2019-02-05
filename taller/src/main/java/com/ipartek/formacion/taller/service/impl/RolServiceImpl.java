package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.RolDAO;
import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.ipartek.formacion.taller.service.RolService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;
import com.ipartek.formacion.taller.service.exception.RolException;

@Service
public class RolServiceImpl implements RolService { // AQUI EN SERVICE IMPLEMENT SE VALIDA

	@Autowired
	private RolDAO rolDAO; // para enviar a dao

	@Autowired
	private Validator validator; // Para validar

	// LLAMAR A DAO PARA LISTAR (GETALL)
	@Override
	public List<Rol> listar() {
		return rolDAO.getAll();
	}

	//LLAMAR A DAO PARA DETALLE (GETBYID)
	@Override
	public Rol detalle(int id) {
	return rolDAO.getById(id);
	}

	
	// LLAMAR A DAO PARA ELIMINAR (DELETE)
	@Override
	public boolean eliminar(int idRol) throws RolException {		
		boolean isDelete = false;
		try {
			isDelete = rolDAO.delete(idRol);
		}catch ( SQLException e) {			
			throw new RolException( RolException.EXCEPTION_CONSTRAINT );
		}			
		return isDelete;
	}
	




	@Override
	public boolean crear(Rol rol) throws RolException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Rol rol) throws RolException {
		// TODO Auto-generated method stub
		return false;
	}


}
