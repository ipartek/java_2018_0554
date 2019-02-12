package com.ipartek.formacion.cervezas.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.cervezas.modelo.dao.CervezaDAO;
import com.ipartek.formacion.cervezas.modelo.dao.ClienteDAO;
import com.ipartek.formacion.cervezas.modelo.dao.TipoDAO;
import com.ipartek.formacion.cervezas.modelo.pojo.Cerveza;
import com.ipartek.formacion.cervezas.service.CervezaService;
import com.ipartek.formacion.cervezas.service.exception.CervezaException;

@Service
public class CervezaServiceImpl implements CervezaService { // AQUI EN SERVICE IMPLEMENT SE VALIDA

	@Autowired
	CervezaDAO cervezaDAO;

	@Autowired
	TipoDAO tipoDAO;

	@Autowired
	ClienteDAO clienteDAO;

	@Autowired
	private Validator validator; // Para validar

	@Override
	public List<Cerveza> listar() {

		ArrayList<Cerveza> cervezas = new ArrayList<Cerveza>(); // Creo un arraylista para guardar los datos del DAO
		cervezas = (ArrayList<Cerveza>) cervezaDAO.getAll(); // Guardo en el arrylist los datos del metodo GET_ALL del
																// DAO

		for (Cerveza c : cervezas) {
			c.setTipo(tipoDAO.getByIdTipoCerveza(c.getId()));
			// IMPORTANTE: obtengo la id del Cerveza del que quiero coger los datos Y le
			// introduzco a ese Cerveza los datos del combustible. PARA ESTO UTILIZO OTRO
			// METODO DAO. GET_BY_ID_Cerveza.
		}

		return cervezas;
	}

	// LLAMAR A DAO PARA DETALLE (GETBYID)
	@Override
	public Cerveza detalle(int id) {
		Cerveza cerveza = cervezaDAO.getById(id);
		cerveza.setTipo(tipoDAO.getByIdTipoCerveza(cerveza.getId())); // con el dao obtengo los datos de tipo y con el set los meto en el objeto cerveza
		return cerveza;
	}

	@Override
	public boolean eliminar(int idCerveza) throws CervezaException {		
		boolean isDelete = false;
		try {
			isDelete = cervezaDAO.delete(idCerveza);
		}catch ( SQLException e) {			
			throw new CervezaException( CervezaException.EXCEPTION_CONSTRAINT );
		}			
		return isDelete;
	}

	
	@Override
	public boolean crear(Cerveza cerveza) throws CervezaException {
		boolean isCreado = false;
		try {

			Set<ConstraintViolation<Cerveza>> violations = validator.validate(cerveza);
			if (violations.isEmpty()) {
				isCreado = cervezaDAO.insert(cerveza);

				cerveza.setTipo(tipoDAO.getByIdTipoCerveza(cerveza.getId()));

			} else {
				throw new CervezaException(CervezaException.EXCEPTION_VIOLATIONS, violations);
			}

		} catch (SQLException e) {
			throw new CervezaException(CervezaException.EXCEPTION_CONSTRAINT);
		}
		return isCreado;
	}

	@Override
	public boolean modificar(Cerveza cerveza) throws CervezaException {
		boolean isModificado = false;
		try {
			
			Set<ConstraintViolation<Cerveza>> violations = validator.validate(cerveza);
			if ( violations.isEmpty() ) {			
				isModificado = cervezaDAO.update(cerveza);	
				cerveza.setTipo(tipoDAO.getByIdTipoCerveza(cerveza.getId()));
			}else {
				throw new CervezaException( CervezaException.EXCEPTION_VIOLATIONS, violations );
			}	

		}catch ( SQLException e) {			
			throw new CervezaException( CervezaException.EXCEPTION_CONSTRAINT );
		}			
		return isModificado;
	}
}
