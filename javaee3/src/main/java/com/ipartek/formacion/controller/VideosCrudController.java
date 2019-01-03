package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojo.Alerta;

/**
 * Servlet implementation class VideosCrudController
 */
@WebServlet("/privado/cvideo")
public class VideosCrudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//LOG
	private final static Logger LOG = Logger.getLogger(UsuarioController.class);
	
	private ValidatorFactory factory;
	private Validator validator;
	
	//VISTAS
	private static final String VIEW_INDEX = "videos/index.jsp";
	private static final String VIEW_FORM = "videos/form.jsp";
	private String vista;
 
	//OPERACIONES
		public static final String OP_LISTAR = "1";
		public static final String OP_IR_FORMULARIO = "2";
		public static final String OP_GUARDAR = "3"; // id == -1 insert , id > 0 update
		public static final String OP_ELIMINAR = "4";
		
		private Alerta alerta;
		
		//parametros	
		private String op;
		private String id;
		private String email;
		private String password;
		
	    private static VideoDAO dao = null;
	
	    @Override
	    public void init(ServletConfig config) throws ServletException {    
	    	super.init(config);
	    	dao = VideoDAO.getInstance();
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
		listar(request);
		request.getRequestDispatcher(vista).forward(request, response);
					
			
	}


	private void listar(HttpServletRequest request) {

		// alerta = "Lista de Usuarios";
		request.setAttribute("videos", dao.getAll());		
		
	}



	


	

	
	private void getParametros(HttpServletRequest request) {

		op = request.getParameter("op");
		if( op == null ) {
			op = OP_LISTAR;
		} 
		
		
		id = request.getParameter("id");
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		LOG.debug( String.format("parametros: op=%s id=%s email=%s password=%s", op, id, email, password ));
		
	}
	
	

}

	
	
	
	
	
	
