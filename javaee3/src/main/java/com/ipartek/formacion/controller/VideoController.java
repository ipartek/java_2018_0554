package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;
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

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.modelo.dao.VideoDAO;
import com.ipartek.formacion.modelo.pojo.Alerta;
import com.ipartek.formacion.modelo.pojo.Video;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/privado/videos")
public class VideoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(VideoController.class);
	
	private ValidatorFactory factory;
	private Validator validator;
	
	private static final String VIEW_INDEX = "videos/index.jsp";
	private static final String VIEW_FORM = "videos/form.jsp";
	private String vista;
	
	public static final String OP_LISTAR = "1";
	public static final String OP_IR_FORMULARIO = "2";
	public static final String OP_GUARDAR = "3"; // id == -1 insert , id > 0 update
	public static final String OP_ELIMINAR = "4";
	
	private Alerta alerta;
	
	//parametros	
	private String op;
	private String id;
	private String nombre;
	private String codigo;
	
    private static VideoDAO daoVideo = null;   
    private static UsuarioDAO daoUsuario = null;
	
	
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	daoVideo = VideoDAO.getInstance();
    	daoUsuario = UsuarioDAO.getInstance();
    	factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
    }
    
   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);		
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		vista = VIEW_INDEX;
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
			
			
		}catch (Exception e) {
			LOG.error(e);		
			alerta = new Alerta( Alerta.TIPO_DANGER, "Error inexesperado sentimos las molestias.");
			
		}finally {
			// mensaje para el usuario
			request.setAttribute("alerta", alerta);
			// ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}	
	}


	private void listar(HttpServletRequest request) {
		
		request.setAttribute("videos", daoVideo.getAll());		
		
	}


	private void eliminar(HttpServletRequest request) throws SQLException {
	
		int identificador = Integer.parseInt(id);		
		
		if ( daoVideo.delete(identificador) ) {
			alerta = new Alerta( Alerta.TIPO_SUCCESS, "Registro eliminado con exito");
		}else {
			alerta = new Alerta( Alerta.TIPO_WARNING, "Registro NO eliminado, sentimos las molestias");
		}
				
		listar(request);		
	}


	private void guardar(HttpServletRequest request) {

		//crear video mediante parametros del formulario
		Video v = new Video();
		int identificador = Integer.parseInt(id);	
		v.setId( (long)identificador);
		v.setCodigo(codigo);
		v.setNombre(nombre);
		
		//validar usuario		
		Set<ConstraintViolation<Video>> violations = validator.validate(v);
		
		
		if ( violations.size() > 0 ) {              // validacion NO correcta
		 
		  alerta = new Alerta( Alerta.TIPO_WARNING, "Los campos introduciodos no son correctos, por favor intentalo de nuevo");		 
		  vista = VIEW_FORM; 
		  // volver al formulario, cuidado que no se pierdan los valores en el form
		  request.setAttribute("video", v);	
		  
		}else {									  //  validacion correcta
		
			try {
				if ( identificador > 0 ) {
					daoVideo.update(v);				
				}else {				
					daoVideo.insert(v);
				}
				alerta = new Alerta( Alerta.TIPO_SUCCESS, "Registro guardado con exito");
				listar(request);
				
			}catch ( SQLException e) {
				alerta = new Alerta( Alerta.TIPO_WARNING, "Lo sentimos pero el EMAIL ya existe");
				vista = VIEW_FORM;
				request.setAttribute("video", v);
			}	
		}	
		
	}


	private void irFormulario(HttpServletRequest request) {
		
		vista = VIEW_FORM; 
		Video v = new Video();
		
		int identificador = Integer.parseInt(id);
		if ( identificador > 0 ) {			
			v = daoVideo.getById(identificador);
		}
		request.setAttribute("video", v);
		request.setAttribute("usuarios", daoUsuario.getAll() );
		
				
	}

	
	private void getParametros(HttpServletRequest request) {

		op = request.getParameter("op");
		if( op == null ) {
			op = OP_LISTAR;
		} 
		
		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		codigo = request.getParameter("codigo");
		
		//TODO nuevo parametro para id_usuario
		
	}
	
	

}
