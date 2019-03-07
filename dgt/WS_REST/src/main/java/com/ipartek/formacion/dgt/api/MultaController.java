package com.ipartek.formacion.dgt.api;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.AgenteDAO;
import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.daos.VehiculoDAO;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.modelo.pojo.MultaNueva;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.impl.AgenteServiceImpl;

@CrossOrigin
@RestController
public class MultaController {

	private final static Logger LOG = Logger.getLogger(MultaController.class);
	public static MultaDAO multaDao;
	private AgenteService agenteService;
	public VehiculoDAO vehiculoDAO;
	public AgenteDAO agenteDAO;

	public MultaController() {
		super();
		multaDao = MultaDAO.getInstance();
		agenteService = AgenteServiceImpl.getInstance();
		vehiculoDAO = VehiculoDAO.getInstance();
		agenteDAO = AgenteDAO.getInstance();

	}

	/*
	 * @RequestMapping( value= {"/api/agente/{id}/multa"}, method =
	 * RequestMethod.GET) public ResponseEntity<ArrayList<Multa>>
	 * listar(@PathVariable Long id){ ResponseEntity<ArrayList<Multa>> response =
	 * new ResponseEntity<ArrayList<Multa>>(HttpStatus.NOT_FOUND); HashMap<Long,
	 * Multa> hmMultas; try { hmMultas = multaDao.getAllByIdAgente(id);
	 * ArrayList<Multa> multas = new ArrayList<Multa>(hmMultas.values()); if
	 * (multas.size() > 0) { response = new ResponseEntity<ArrayList<Multa>>(multas,
	 * HttpStatus.OK); } } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * return response; }
	 */
	@RequestMapping(value = { "/api/agente/{id}/multas" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Multa>> listar(@PathVariable long id) {
		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.NOT_FOUND);

		try {

			ArrayList<Multa> multas = new ArrayList<Multa>();
			multas = (ArrayList<Multa>) agenteService.listarMultas(id);

			response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error(e);
		}

		return response;
	}

	
	@RequestMapping(value = { "/api/agente/{id}/multasbaja" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Multa>> listarAnuladas(@PathVariable long id) {
		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.NOT_FOUND);

		try {

			ArrayList<Multa> multas = new ArrayList<Multa>();
			multas = (ArrayList<Multa>) agenteService.listarMultasAnuladas(id);

			response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error(e);
		}

		return response;
	}
	
	@RequestMapping(value = { "/api/multa/" }, method = RequestMethod.POST)
	public ResponseEntity<MultaNueva> crear(@RequestBody MultaNueva multa) {

		ResponseEntity<MultaNueva> response = new ResponseEntity<MultaNueva>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		boolean insertado = false;
		
		try {
			
			insertado = agenteService.insertar(multa);

			if (insertado == true) {
				response = new ResponseEntity<MultaNueva>(multa, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			response = new ResponseEntity<MultaNueva>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}
	
	@RequestMapping(value = { "/api/multa/anular/{idMulta}" }, method = RequestMethod.PATCH)
	public ResponseEntity<Multa> anular(@PathVariable int idMulta) {

		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		boolean anulada = false;
		int id = -1;
		try {
			id = (int) idMulta;
		} catch (Exception e1) {
			response = new ResponseEntity<Multa>(HttpStatus.BAD_REQUEST);
		}
		try {
			
			anulada = agenteService.anular(id);
			if (anulada == true) {
				response = new ResponseEntity<Multa>(HttpStatus.OK);
			}
		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Multa>(HttpStatus.NOT_FOUND);
			
		}

		return response;

	}
	
	@RequestMapping(value = { "/api/multa/desanular/{idMulta}" }, method = RequestMethod.PATCH)
	public ResponseEntity<Multa> desanular(@PathVariable int idMulta) {

		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		boolean anulada = false;
		int id = -1;
		try {
			id = (int) idMulta;
		} catch (Exception e1) {
			response = new ResponseEntity<Multa>(HttpStatus.BAD_REQUEST);
		}
		try {
			
			anulada = agenteService.desanular(id);
			if (anulada == true) {
				response = new ResponseEntity<Multa>(HttpStatus.OK);
			}
		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Multa>(HttpStatus.NOT_FOUND);
		}

		return response;

	}
}
