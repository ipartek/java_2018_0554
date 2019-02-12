package com.ipartek.formacion.cervezas.service.impl;


import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.cervezas.modelo.dao.ClienteDAO;
import com.ipartek.formacion.cervezas.modelo.dao.CompraDAO;
import com.ipartek.formacion.cervezas.modelo.dao.TipoDAO;
import com.ipartek.formacion.cervezas.modelo.pojo.Compra;
import com.ipartek.formacion.cervezas.service.CompraService;
import com.ipartek.formacion.cervezas.service.exception.CervezaException;
import com.ipartek.formacion.cervezas.service.exception.CompraException;

@Service
public class CompraServiceImp implements CompraService {   // AQUI EN SERVICE IMPLEMENT SE VALIDA

	@Autowired
	 CompraDAO compraDAO;  

	
	@Autowired
	TipoDAO tipoDAO;
	
	@Autowired
	ClienteDAO clienteDAO;
	

 	@Autowired
	private Validator validator;        // Para validar
	
	

	//Eliminar
	@Override
	public boolean eliminar(int idCompra) throws CompraException {		
		boolean isDelete = false;
		try {
			isDelete = compraDAO.delete(idCompra);
		}catch ( SQLException e) {			
			throw new CompraException( CompraException.EXCEPTION_CONSTRAINT );
		}			
		return isDelete;
	}
	
	// crear
	@Override
	public boolean crear(Compra compra) throws CompraException {
		boolean isCreado = false;
		try {
			
			Set<ConstraintViolation<Compra>> violations = validator.validate(compra);
			if ( violations.isEmpty() ) {			
				
				isCreado = compraDAO.insert(compra);
				
				compra.setCliente(clienteDAO.getByIdCliente(compra.getId()));
						
				compra.setTipo(tipoDAO.getByIdTipoCompra(compra.getId()));
				
			}else {
				throw new CompraException( CompraException.EXCEPTION_VIOLATIONS, violations );
			}	

		}catch ( SQLException e) {			
			throw new CompraException( CompraException.EXCEPTION_CONSTRAINT );
		}			
		return isCreado;
	}




	@Override
	public List<Compra> listar() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Compra detalle(int idCompra) {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public boolean modificar(Compra compra) throws CompraException {
		// TODO Auto-generated method stub
		return false;
	}






}
