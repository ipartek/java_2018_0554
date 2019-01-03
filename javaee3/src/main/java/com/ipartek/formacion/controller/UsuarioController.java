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
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelos.daos.UsuarioDAO;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/privado/usuarios")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(UsuarioController.class);
	
	private static final String VIEW_INDEX="usuario/index.jsp";
	private static final String VIEW_FORM="usuario/form.jsp";
	private String vista;
	private static final String OP_LISTAR="1";
	private static final String OP_IR_FORMULARIO="2";
	private static final String OP_GUARDAR="3"; //id == -1 insert, id> 1 update
	private static final String OP_ELIMINAR="4";
	
	private ValidatorFactory factory;
	private Validator validator;
	
	private String alerta="";
	
	//parametros a recibir
	private String op;
	private String id;
	private String email;
	private String password;
	
    private static UsuarioDAO dao = null;
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = UsuarioDAO.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 vista = VIEW_INDEX;
		alerta="";
		try{
			
			//recoger parametros
			getParametros(request);
			//realizar operacion(lista, eliminar,crear,...)
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
			
			//enviar atributos 	
		}catch (Exception e) {
			LOG.error(e);
			alerta="Error inexperados sentimos las molestias";
			
		}finally {
			//mensaje para el usuario
			request.setAttribute("alerta", alerta);
			//ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}
	
	/**
	 * Metodo que manda el listado de todos los usuarios
	 * @param request
	 */
	private void listar(HttpServletRequest request) {
		//alerta="Lista de Usuarios";
		request.setAttribute("usuarios", dao.getAll());
	}

	private void eliminar(HttpServletRequest request) throws SQLException {
			
		try {
			Long identificador = Long.parseLong(id);
			if(dao.eliminar(identificador)) {
				alerta = "El usuario se ha eliminado correctamente";
			}else {
				alerta = "No se ha podido eliminar correctamente";
			}
			
		}finally {
			listar(request);
		}
		
		
	}

	private void guardar(HttpServletRequest request)  {
		Usuario u = new Usuario();
		int identificador = Integer.parseInt(id);
			//Al crear no hace falta poque la base de datos lo inserta automicamente
		u.setEmail(email);
		u.setPassword(password);
		
		//TODO validar POJO
		Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
		
		
		if(violations.size()>0) {//Si valicion no correcta
			//alerta al usuario
			String errores = "<ul>";
			for (ConstraintViolation<Usuario> violation : violations) {
				errores += String.format("<li> %s : %s </li>", violation.getPropertyPath(), violation.getMessage());
			}
			errores += "</ul>";
			request.setAttribute("mensaje", errores);
			
			//volver al formulario, cuidado que no se pierdan los valores
			request.setAttribute("usuario", u);
		
			vista= VIEW_FORM;
			
		}else {//Si validacion correcta
			
			try {
				if(identificador>0) {
					Usuario userViejo = dao.getById((long)identificador);
					if(userViejo!=null) {
						alerta="Update de un Usuario";
						u.setId((long)identificador);
						dao.update(u);
						HttpSession session = request.getSession();
						Usuario userLogueado = (Usuario) session.getAttribute("usuario");
						if(userViejo.getEmail().equals(userLogueado.getEmail())) {
							session.setAttribute("usuario", u);
						}
					}

			
				}else {
					alerta="Se ha creado el nuevo usuario correctamente";
					dao.insert(u);
					vista= VIEW_INDEX;
				}
			}catch (MySQLIntegrityConstraintViolationException e) {
				//Este try esta por si el email esta duplicado y lanza una exception se capture
				alerta="Email duplicado";
				request.setAttribute("usuario", u);
				vista= VIEW_FORM;
			}catch (Exception e) {
				alerta="Ha ocurrido un error inesperado";
				LOG.trace("Ha ocurrido un error inesperado: " + e);
				request.setAttribute("usuario", u);
				vista= VIEW_FORM;
			}
		}
		listar(request);
	}

	private void irFormulario(HttpServletRequest request) {
		vista = VIEW_FORM;
		Usuario u = new Usuario();
		
		int identificador = Integer.parseInt(id);
		if(identificador>0) {
			//Mostrar datos de un usuario seleccionado
			u= dao.getById((long)identificador);
		}else {
			alerta="Crear un nuevo Usuario";
			LOG.trace("Se ha generado el usuario correctamente");
		}
		
		request.setAttribute("usuario", u);
		
	}

	/**
	 * Metodo que recoge todos los parametros enviados en la peticion
	 * @param request
	 */
	private void getParametros(HttpServletRequest request) {
		op =request.getParameter("op");
		if(op== null) {
			op=OP_LISTAR;
		}
		id= request.getParameter("id");
		email= request.getParameter("email");
		password= request.getParameter("password");
		
		LOG.debug(String.format("parametros: op=%s id =%s email=%s password=%s",op,id,email,password));
	}

}
