package com.ipartek.formacion.taller.service.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.CervezaDAO;
import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.dao.ModeloDAO;
import com.ipartek.formacion.taller.modelo.dao.PersonaDAO;
import com.ipartek.formacion.taller.modelo.pojo.Cerveza;
import com.ipartek.formacion.taller.service.CervezaService;
import com.ipartek.formacion.taller.service.exception.CervezaException;

@Service
public class CervezaServiceImpl implements CervezaService {   // AQUI EN SERVICE IMPLEMENT SE VALIDA

	@Autowired
	private CervezaDAO cervezaDAO;  

	
	@Autowired
	TipoDAO tipoDAO;
	

 	@Autowired
	private Validator validator;        // Para validar
	
	
 	@Override
	public List<Cerveza> listar() {
		
		ArrayList<Cerveza> cervezas = new ArrayList<Cerveza>();				// Creo un arraylista para guardar los datos del DAO  
		cervezas = (ArrayList<Cerveza>) cervezaDAO.getAll();					// Guardo en el arrylist los datos del metodo GET_ALL del DAO
		
		
		for ( Cerveza v : cervezas ) {  										//recorro el array que he creado con los datos del dao para introducirle los datos de la persona y del combustible
			v.setCombustible( combustibleDAO.getByIdCerveza( v.getId() ) );  	// IMPORTANTE: obtengo la id del Cerveza del que quiero coger los datos Y le introduzco a ese Cerveza los datos del combustible. PARA ESTO  UTILIZO OTRO METODO DAO. GET_BY_ID_Cerveza.    
			v.setPersona( personaDAO.getByIdCerveza( v.getId() ) );  																				 
		}
		return cervezas;
	}
	
	// LLAMAR A DAO PARA DETALLE (GETBYID)
	@Override
	public Cerveza detalle(int id) {
		return cervezaDAO.getById(id);
	}


	// LLAMAR A DAO PARA ELIMINAR (DELETE)
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

	
	// LLAMAR A DAO PARA CREAR (INSERT)
	@Override
	public boolean crear(Cerveza cerveza) throws CervezaException {   
		boolean isCreado = false;
		
		//Set<ConstraintViolation<Cerveza>> violations = validator.validate(cerveza);
		//if ( violations.isEmpty() ) {	
		try {
			isCreado = cervezaDAO.create(cerveza);  //SI SE CREA DEVUELVE TRUE
		}catch ( SQLException e) {			
			throw new CervezaException( CervezaException.EXCEPTION_CONSTRAINT );
		}
		//}else {
			//throw new CervezaException( " necesitamos el nombre para crear un nuevo Cerveza" );
		//}
		return isCreado;
	}

	
	// LLAMAR A DAO PARA MODIFICAR (UPDATE)
	
	@Override
	public boolean modificar(Cerveza cerveza) throws CervezaException {
		boolean isModificado = false;
		try {
			
			Set<ConstraintViolationCervezao>> violations = validator.validate(cerveza);
			if ( violations.isEmpty() ) {			
				isModificado = cervezaDAO.update(cerveza);				
			}else {
				throw new CervezaException( CervezaException.EXCEPTION_VIOLATIONS, violations );
			}	

		}catch ( SQLException e) {			
			throw new CervezaException( CervezaException.EXCEPTION_CONSTRAINT );
		}			
		return isModificado;
	}
	
}
