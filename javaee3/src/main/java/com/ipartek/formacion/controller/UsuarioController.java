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

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.Mensaje;
import com.ipartek.formacion.modelo.pojos.Usuario;

@WebServlet("/privado/usuarios")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidatorFactory factory;
	private Validator validator;
	private final static Logger LOG = Logger.getLogger(UsuarioController.class);
	
	// Objeto de mensaje de alerta
	private Mensaje mensaje;
	
	// Constantes mensajes de alerta

	// Vistas
	private String vista;
	private static final String VIEW_INDEX = "usuarios/index.jsp";
	private static final String VIEW_FORM = "usuarios/form.jsp";

	// Operaciones
	public static final String OP_LISTAR = "1";
	public static final String OP_IR_FORMULARIO = "2";
	public static final String OP_GUARDAR = "3"; // id == -1 insert, id > 1 update
	public static final String OP_ELIMINAR = "4";

	// Parámetros
	private String id;
	private String email;
	private String password;
	private String op;

	private String alerta;

	UsuarioDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		dao = UsuarioDAO.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Recoger parámetros
		// 2. Realizar lista
		// 3. Enviar atributos
		// 4. Ir a una vista

		vista = VIEW_INDEX;
		alerta = "";

		try {
			getParametros(request);
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
				mensaje = new Mensaje(mensaje.MENSAJE_INFO, "Lista de usuarios");
				break;
			}
		} catch (Exception e) {
			LOG.error(e);
			mensaje = new Mensaje(mensaje.MENSAJE_DANGER, e.getMessage());
		} finally {
			// Mensaje para el usuario
			request.setAttribute("mensaje", mensaje);
			// Ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}

	private void listar(HttpServletRequest request) {
		request.setAttribute("usuarios", dao.getAll());
	}

	private void guardar(HttpServletRequest request) {
		Usuario u = new Usuario();
		int identificador = Integer.parseInt(id);
		u.setEmail(email);
		u.setPassword(password);
		u.setId((long) identificador);
		Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
		if (violations.isEmpty()) {
			try {
				if (identificador > 0) {
					dao.update(u);
					mensaje = new Mensaje(mensaje.MENSAJE_SUCCESS, "Usuario actualizado");
				} else {
					dao.insert(u);
					mensaje = new Mensaje(mensaje.MENSAJE_SUCCESS, "Usuario introducido");
				}
			} catch (SQLException e) {
				mensaje = new Mensaje(mensaje.MENSAJE_WARNING, "Lo sentimos pero el email ya existe");
				request.setAttribute("usuario", u);
				vista = VIEW_FORM;
			}
		} else {
			alerta = "<ul class='list-unstyled'>";
			for (ConstraintViolation<Usuario> violation : violations) {

				alerta += "<li>" + violation.getPropertyPath() + ": " + violation.getMessage() + "</li>";

			}
			alerta += "</ul>";
			vista = VIEW_FORM;
			mensaje = new Mensaje(mensaje.MENSAJE_DANGER, alerta);
			request.setAttribute("usuario", u);
		}
		listar(request);
	}

	private void eliminar(HttpServletRequest request) {
		vista = VIEW_INDEX;
		int identificador = Integer.parseInt(id);
		if (dao.delete((long) identificador)) {
			mensaje = new Mensaje(mensaje.MENSAJE_SUCCESS, "Usuario eliminado");
		} else {
			Usuario u = new Usuario();
			u.setEmail(email);
			u.setPassword(password);
			mensaje = new Mensaje(mensaje.MENSAJE_DANGER, "No se pudo eliminar el usuario");
			request.setAttribute("usuario", u);
			vista = VIEW_FORM;
		}
		listar(request);
	}

	private void irFormulario(HttpServletRequest request) {
		vista = VIEW_FORM;
		Usuario u = new Usuario();
		int identificador = Integer.parseInt(id);
		if (identificador > 0) {
			mensaje = new Mensaje(mensaje.MENSAJE_INFO, "Detalle de un usuario");
			u = dao.getById((long) identificador);
		} else {
			mensaje = new Mensaje(mensaje.MENSAJE_INFO, "Crear un nuevo usuario");
			u.setId((long) identificador);
			u.setEmail(email);
		}
		request.setAttribute("usuario", u);
	}

	protected void getParametros(HttpServletRequest request) {
		op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}
		id = request.getParameter("id");
		email = request.getParameter("email");
		password = request.getParameter("password");

		LOG.debug(String.format("parametros: op=%s id=%s email=%s password=%s", op, id, email, password));
	}
}
