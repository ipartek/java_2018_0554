package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.Usuario;

@WebServlet("/privado/usuarios")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(UsuarioController.class);

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
				break;
			}
		} catch (Exception e) {
			LOG.error(e);
			alerta = "Error inesperado. Sentimos las molestias";
		} finally {
			// Mensaje para el usuario
			request.setAttribute("alerta", alerta);
			// Ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}

	private void listar(HttpServletRequest request) {
		alerta = "Lista de usuarios";
		request.setAttribute("usuarios", dao.getAll());
	}

	private void guardar(HttpServletRequest request) throws SQLException {
		Usuario u = new Usuario();
		int identificador = Integer.parseInt(id);
		u.setEmail(email);
		u.setPassword(password);
		if (identificador > 0) {
			alerta = "Actualizar un usuario";
			// TODO dao.update(u);
		} else {
			alerta = "Crear un nuevo usuario";
			dao.insert(u);
		}
		listar(request);
	}

	private void eliminar(HttpServletRequest request) {
		vista = VIEW_INDEX;
		Usuario u = new Usuario();
		int identificador = Integer.parseInt(id);
		boolean eliminado = dao.delete((long)identificador);
		if (eliminado) {
			alerta = "Usuario eliminado";
		}
		listar(request);
	}

	private void irFormulario(HttpServletRequest request) {
		vista = VIEW_FORM;
		Usuario u = new Usuario();
		int identificador = Integer.parseInt(id);
		if (identificador > 0) {
			alerta = "Detalle de un usuario";
			u = dao.getById((long)identificador);
		} else {
			alerta = "Crear un nuevo usuario";
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
