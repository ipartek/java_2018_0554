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

import com.ipartek.formacion.modelo.dao.VideoDAO;
import com.ipartek.formacion.modelo.pojo.Alerta;
import com.ipartek.formacion.modelo.pojo.Video;

@WebServlet("/privado/videos")
public class VideosController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ValidatorFactory factory;
	private Validator validator;

	private final static Logger LOG = Logger.getLogger(UsuarioController.class);

	private static final String VIEW_INDEX = "videos/index.jsp";
	private static final String VIEW_FORM = "videos/form.jsp";
	private String vista;

	private static final String OP_LISTAR = "1";
	private static final String OP_IR_FORMULARIO = "2";
	private static final String OP_GUARDAR = "3";
	private static final String OP_ELIMINAR = "4";

	Alerta alerta=null;

	private String id;
	private String op;
	private String nombre;
	private String codigo;

	private static VideoDAO dao = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = VideoDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		vista = VIEW_INDEX;

		try {
			getParametros(request);

			switch (op) {
			case OP_IR_FORMULARIO:
				ir_formulario(request);
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
			LOG.debug(e);
			alerta = new Alerta(e.toString(),alerta.KO);
		}
		request.setAttribute("alerta", alerta);
		
		request.getRequestDispatcher(vista).forward(request, response);
	}

	private void guardar(HttpServletRequest request) {
		vista=VIEW_INDEX;
		int ident=Integer.parseInt(id);
		
		Video v =new Video((long)ident,nombre,codigo);
		
		Set<ConstraintViolation<Video>> violations = validator.validate(v);
		
		if(violations.isEmpty()) {
			try {
				if (ident>0) {
					dao.update(v);
				}else {
					dao.insert(v);
				}
				alerta = new Alerta("Guardado correcto",alerta.OK);
				listar(request);
			} catch (SQLException e) {
				LOG.debug(e);
				alerta = new Alerta("Ocurrio algun error con el guardado",alerta.KO);
			}
		}else {
			alerta = new Alerta("Los datos introducidos no son correctos", alerta.KO);
			request.setAttribute("video", v);
			vista=VIEW_FORM;
		}
				
	}

	private void eliminar(HttpServletRequest request) throws SQLException {
		vista=VIEW_INDEX;
		
		int ident=Integer.parseInt(id);
		
		if(ident>0) {
			if(dao.delete(ident)) {
				alerta=new Alerta("Video eliminado correctamente",alerta.OK);
			}else {
				alerta = new Alerta("Error al eliminar video",alerta.KO);
			}
			listar(request);
		}else {
			alerta = new Alerta("Video no encontrado",alerta.KO);
		}
		
	}

	private void listar(HttpServletRequest request) {
		vista=VIEW_INDEX;
		try {
			request.setAttribute("videos", dao.getAll());
		} catch (SQLException e) {
			LOG.debug(e);
			alerta=new Alerta("Error leyendo de la base de datos",alerta.KO);
		}
		
	}

	private void ir_formulario(HttpServletRequest request) {
		vista=VIEW_FORM;
		Video v;
		int ident=Integer.parseInt(id);
		
		try {
			if(ident>0) {
				v= dao.getById(ident);
			}else {
				v= new Video();
			}
			request.setAttribute("video", v);
		} catch (SQLException e) {
			LOG.debug(e.toString());
			alerta=new Alerta("No se encontro el usuario",alerta.KO);
		}
		
	}

	private void getParametros(HttpServletRequest request) {
		op = request.getParameter("op");

		if (op == null) {
			op = OP_LISTAR;
		}
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		codigo = request.getParameter("codigo");

		LOG.debug(String.format("parametros: op=%s id=%s  nombre=%s  codigo=%s", op, id, nombre, codigo));
	}
}
