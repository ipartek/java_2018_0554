package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.jboss.logging.Logger;

import com.ipartek.formacion.modelo.daos.DiscoDAO;
import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Alerta;
import com.ipartek.formacion.modelo.pojos.Disco;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class DiscoController
 */
@WebServlet("/privado/disco")
public class DiscoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(UsuariosController.class);
    
	private static final String VIEW_INDEX = "discos/index.jsp";
	private static final String VIEW_FORM = "discos/form.jsp";
	private String vista;

	public static final String OP_LISTAR = "1";
	public static final String OP_IR_FORMULARIO = "2";
	public static final String OP_GUARDAR = "3"; // id==-1 insert, id>0 update
	public static final String OP_ELIMINAR = "4";

	private Alerta alerta;

	// parametros
	private String op;
	private String id;
	private String titulo;
	private String artista;
	private String portada;
	private String year;
	
	//parametros alerta
	private String texto;
	private String tipo;

	private static DiscoDAO dao = null;
	
	private ValidatorFactory factory;
	private Validator validator;

	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		dao = DiscoDAO.getInstance(); 
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
		
		
	}
		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		vista= VIEW_INDEX;
		//reseteamos alerta a vacio
		//alerta = "";
		alerta = null;
		try {

			// recoger parametros
			getParametros(request);
			// realizar operacion
			switch (op) {
			case OP_IR_FORMULARIO:
				irFormulario(request);
				break;
			case OP_GUARDAR:
				guardar(request);
				break;
			case OP_ELIMINAR:
				eliminar(request);
				break;
			default:
				listar(request);
				break;
			}

			// enviar atributos

		} catch (Exception e) {
			LOG.error(e);
			
		 alerta = new Alerta(Alerta.TIPO_DANGER, "Error inesperado, sentimos las molestias"); //rojo
		} finally {

			// mensaje para el usuario
			request.setAttribute("alerta", alerta);
			// ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}
		
		
	}
	
	private void listar(HttpServletRequest request) {
		// alerta = "Lista de Usuarios";
				request.setAttribute("disco", dao.getAll());
	}
	
	private void eliminar(HttpServletRequest request) throws SQLException {
		int identificador = Integer.parseInt(id);
		
		
		if(dao.eliminar(identificador)) {
			alerta = new Alerta(Alerta.TIPO_SUCCESS,"Disco eliminado con exito"); //verde
		}else {
			alerta = new Alerta(Alerta.TIPO_DANGER,"Disco NO eliminado");  //rojo
		}
		listar(request);
	}

	private void guardar(HttpServletRequest request) {
		Disco d = new Disco();
		int identificador = Integer.parseInt(id);
		//crear usuario con los parametros
				d.setId((long)identificador);
				d.setTitulo(titulo);
				d.setArtista(artista);
				d.setPortada(portada);
				d.setYear(year);
				
				// validar disco
				
				Set<ConstraintViolation<Disco>> violations = validator.validate(d);
				
				
				
				//if(!violations.isEmpty())
				if(violations.size() > 0) { //si validacion NO correcta
					
				
				  
				  // alerta al usuario
					alerta = new Alerta(Alerta.TIPO_DANGER, "Los campos introducidos no son correctos, por favor intentelo de nuevo"); //rojo
				   vista = VIEW_FORM;
				  // volver al formulario, cuidado que no se pierdan los valores en el form
				request.setAttribute("disco", d);
				}else {// Si validacion correcta				
				   
				try {
				if ( identificador > 0 ) {
					
					
					dao.update(d);
										
				}else {
					dao.insert(d);
				}
				alerta = new Alerta(Alerta.TIPO_SUCCESS, "Registro guardado con exito");  //verde
				listar(request);
				
			}catch ( SQLException e) {
				alerta = new Alerta(Alerta.TIPO_WARNING,"Lo sentimos pero el DISCO ya existe"); //warning
				vista = VIEW_FORM;
				request.setAttribute("disco", d);
			}	
		}	
		
	}

	private void irFormulario(HttpServletRequest request) {
		vista = VIEW_FORM;
		
		Disco d = new Disco();
		
		int identificador = Integer.parseInt(id);
		if(identificador > 0) {
			//alerta = "Detalle de un Usuario"+ identificador;
			d = dao.getById(identificador);
			
		}else {
			alerta = new Alerta(Alerta.TIPO_PRIMARY,"Crear nuevo Disco") ;
		}
		
		request.setAttribute("disco", d);
		
	}

	private void getParametros(HttpServletRequest request) {
		op= request.getParameter("op");
		if(op == null) {
			op= OP_LISTAR;
		}
		
		id = request.getParameter("id");
		titulo = request.getParameter("titulo");
		artista = request.getParameter("artista");
		portada = request.getParameter("portada");
		year = request.getParameter("year");
		
			
		LOG.debug(String.format("parametros: op=%s id=%s titulo=%s artista=%s portada=%s year=%s ", op, id, titulo, artista, portada, year));
		
	}
}
