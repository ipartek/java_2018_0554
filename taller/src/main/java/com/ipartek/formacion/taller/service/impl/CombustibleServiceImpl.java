package com.ipartek.formacion.taller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

@Service
public class CombustibleServiceImpl implements CombustibleService {

	@Autowired
	CombustibleDAO combustibleDAO;
	
	@Override
	public List<Combustible> listar() {		
		return combustibleDAO.getAll();
	}

	@Override
	public Combustible detalle(int idCombustible) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(int idCombustible) throws CombustibleException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crear(Combustible combustible) throws CombustibleException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Combustible combustible) throws CombustibleException {
		// TODO Auto-generated method stub
		return false;
	}

}
