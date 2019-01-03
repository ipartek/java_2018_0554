package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import org.apache.log4j.Logger;

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

import com.ipartek.formacion.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.modelo.pojo.Usuario;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class UsuariosController
 */
@WebServlet("/privado/usuarios")
public class UsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(UsuariosController.class);
	private UsuarioDAO dao = null;
	private static final String VIEW_INDEX = "usuarios/index.jsp";
	private static final String VIEW_FORM = "usuarios/form.jsp";
	private String vista;
	
	private ValidatorFactory factory;
    private Validator validator;
	
	private static final String OP_LISTAR = "1";
	private static final String OP_IR_FORMULARIO = "2";
	private static final String OP_GUARDAR = "3"; // id == -1 insert, id > 0 update
	private static final String OP_ELIMINAR = "4";
	
	private String alerta="";
	
	//Parametros
	private String op;
	private String id;
	private String email;
	private String password;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = UsuarioDAO.getInstance();
		//Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
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
	
	/**
	 * Método que procesa las peticiones 
	 * @param request
	 * @param response
	 * @throws IOException Mismas excepciones que el doPost() y el doGet(). Las lanzamos para arriba. 
	 * @throws ServletException Mismas excepciones que el doPost() y el doGet(). Las lanzamos para arriba.
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		vista = VIEW_INDEX;
		alerta = "";
		try {
			//Recoger parámetros
			getParametros(request);
			
			//Realizar operación
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
			
			//Enviar atributos
			
	
		}catch (Exception e) {
			LOG.error(e);
			alerta = "Error inesperado, sentimos las molestias";
		}finally {
			//Mensaje para el usuario
			request.setAttribute("alerta", alerta);
			//Ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}
		
	}
	
	
	private void listar(HttpServletRequest request) {
		
		// alerta = "Lista de Usuarios";
		request.setAttribute("usuarios", dao.getAll());
		
	}
	
	
	private void eliminar(HttpServletRequest request) {
		Long identificador = Long.parseLong(id);
		
		Usuario u = dao.getById(identificador);
		HttpSession session = request.getSession();
		
		Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario_logueado");
		
		if (usuarioLogueado.getEmail().equals(u.getEmail())) {
			alerta="No puedes eliminar el usuario con el que estás logueado";
		}else {
			try {
				dao.delete(identificador);
				alerta="El usuario ha sido eliminado correctamente";
			} catch (SQLException e) {
				alerta = "No ha sido posible eliminar el usuario";
				LOG.error(e.getMessage() + "[ID user: " + identificador + "]");
			}
		}
		
		listar(request);
	}
	
	
	private void guardar(HttpServletRequest request) throws SQLException {
		
		Usuario u = new Usuario();
		Long identificador = Long.parseLong(id);
		u.setEmail(email);
		u.setPassword(password);
		
		//TODO Validar POJO (Email y Password)
		Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
		
		//Si validación no correcta
		if (violations.size() > 0) {
			LOG.error("Se han encontrado " + violations.size() + " violaciones en la validación");
			alerta = "<ul>";
			for (ConstraintViolation<Usuario> violation : violations) {
				alerta += String.format("<li> %s : %s </li>", violation.getPropertyPath(), violation.getMessage());
			}
			alerta += "</ul>";
			
			//Alerta al usuario
			request.setAttribute("alerta", alerta);
			//Volver al formulario (conservando los valores)
			request.setAttribute("usuario", u);
			vista = VIEW_FORM;
		}else {
			try {
				//Si validación correcta
				if (identificador > 0) {
					Usuario usuario = dao.getById(identificador);
					
					if (usuario!=null) {
						u.setId(identificador);
						dao.update(u);
						alerta="Update Usuario: " + usuario.toString() + " >> " + u.toString();
						LOG.info(usuario.toString() + " cambiado a " + u.toString());
						
						HttpSession session = request.getSession();
						Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario_logueado");
						
						if (usuario.getEmail().equals(usuarioLogueado.getEmail())) {
							session.setAttribute("usuario_logueado", u);
							alerta = "Has actualizado el usuario con el que estás logueado.";
						}
						
					}else {
						vista = VIEW_FORM;
						LOG.error("El usuario con ID: " + identificador + " no existe en la DB");
					}
					
				}else {
					alerta="Crear un nuevo Usuario";
					
					Usuario usuario = dao.getById(identificador);
					
					if (usuario!=null) {
						vista = VIEW_FORM;
						LOG.error("El usuario ya existe en la DB");
					}else {
					
					dao.insert(u);
					
					}
				}
			}catch (MySQLIntegrityConstraintViolationException e) {
				alerta = "El email introducido ya está registrado, por favor, introduzca uno nuevo.";
				//u.setId(-1L);
				request.setAttribute("usuario", u);
				vista=VIEW_FORM;
			}catch (Exception e) {
				alerta = "Lo sentimos, error inesperado";
				LOG.error(e.getMessage());
			}
		}
		
		listar(request);
		
	}
	
	
	private void irFormulario(HttpServletRequest request) {

		vista = VIEW_FORM;
		Usuario u = new Usuario();
		
		Long identificador = Long.parseLong(id);
		if (identificador > 0) {
			u = dao.getById(identificador);
		}else {
			alerta="Crear un nuevo Usuario";
		}
		request.setAttribute("usuario", u);		
	}
	
	
	private void getParametros(HttpServletRequest request) {
		
		op = request.getParameter("op");
		if (op==null) {
			op = OP_LISTAR;
		}
		
		id = request.getParameter("id");
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		LOG.debug(String.format("Parametros: op=%s id=%s email=%s password=%s", op, id, email, password));
		
	}

}
