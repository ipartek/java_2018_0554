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
import com.ipartek.formacion.modelo.pojo.Mensaje;
import com.ipartek.formacion.modelo.pojo.Video;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class VideosController
 */
@WebServlet("/privado/videos")
public class VideosController extends HttpServlet {
	private static final String ALERTA_SUCCESS = "success";

	private static final String ALERTA_WARNING = "warning";

	private static final String ALERTA_INFO = "info";

	private static final String ALERTA_DANGER = "danger";

	private static final long serialVersionUID = 1L;
	
	private String vista;
	private VideoDAO dao = null;
	private final static Logger LOG = Logger.getLogger(VideosController.class);

	private ValidatorFactory factory;
    private Validator validator;
	
	private static final String VIEW_INDEX = "videos/index.jsp";
	private static final String VIEW_FORM = "videos/form.jsp";
	
	private static final String OP_LISTAR = "1";
	private static final String OP_IR_FORMULARIO = "2";
	private static final String OP_GUARDAR = "3"; // id == -1 insert, id > 0 update
	private static final String OP_ELIMINAR = "4";
	
	private Mensaje alerta;
	
	//Parametros
	private String op;
	private String id;
	private String nombre;
	private String codigo;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = VideoDAO.getInstance();

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
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		vista = VIEW_INDEX;
		alerta = new Mensaje();
		
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

		}catch (Exception e) {
			//Informar del error
			LOG.error(e.getMessage());
			alerta.setAlerta("Error inesperado, sentimos las molestias.");
			alerta.setTipo(ALERTA_DANGER);
		}finally {
			//Mensaje para el usuario
			request.setAttribute("mensaje", alerta);
			//Ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}
		
	}

	private void eliminar(HttpServletRequest request) {
		Long identificador = Long.parseLong(id);
		
		try {
			dao.delete(identificador);
			alerta.setAlerta("El vídeo ha sido eliminado correctamente");
			alerta.setTipo(ALERTA_SUCCESS);
		} catch (SQLException e) {
			alerta.setAlerta("No ha sido posible eliminar el vídeo");
			alerta.setTipo(ALERTA_DANGER);
			LOG.error(e.getMessage() + " [ID vídeo: " + identificador + "]");
		} 
		
		listar(request);
		
	}

	private void guardar(HttpServletRequest request) {
		Video v = new Video();
		Long identificador = Long.parseLong(id);
		//v.setId(identificador);
		v.setNombre(nombre);
		v.setCodigo(codigo);
		
		//Validación del video
		Set<ConstraintViolation<Video>> violations = validator.validate(v);
		//Validación incorrecta
		if (violations.size() > 0) {
			LOG.error("Se han encontrado " + violations.size() + " violaciones en la validación");
			String alertaTexto = "<ul>";
			for (ConstraintViolation<Video> violation : violations) {
				alertaTexto += String.format("<li> %s : %s </li>", violation.getPropertyPath(), violation.getMessage());
			}
			alertaTexto += "</ul>";
			alerta.setAlerta(alertaTexto);
			alerta.setTipo(ALERTA_DANGER);
			
			request.setAttribute("mensaje", alerta);
			request.setAttribute("video", v);
			vista = VIEW_FORM;
		}else {
			//Validación correcta
			try {
				if (identificador > 0) {
					Video video = dao.getById(identificador);
					
					if (video != null) {
						v.setId(identificador);
						if (video.getNombre().equals(v.getNombre()) && video.getCodigo().equals(v.getCodigo())) {
							alerta.setAlerta("No se ha realizado ningún cambio sobre el vídeo " + v.toString());
							alerta.setTipo(ALERTA_WARNING);
						}else {
							dao.update(v);
							alerta.setAlerta("Vídeo modificado: " + video.toString() + " >> " + v.toString());
							alerta.setTipo(ALERTA_SUCCESS);
							LOG.info(video.toString() + " cambiado a " + v.toString());
						}
					}else {
						vista = VIEW_FORM;
						LOG.error("El vídeo con ID: " + identificador + " no existe en la DB.");
					}
				}else {
					alerta.setAlerta("Crear un nuevo Vídeo");
					alerta.setTipo(ALERTA_INFO);
					
					Video video = dao.getById(identificador);
					
					if (video != null) {
						vista = VIEW_FORM;
						LOG.error("El vídeo ya existe en la DB");
					}else {
						dao.insert(v);
					}
				}
			}catch (MySQLIntegrityConstraintViolationException e) {
				alerta.setAlerta("Ya existe un vídeo registrado con el código introducido, por favor, introduzca un código nuevo.");
				alerta.setTipo(ALERTA_DANGER);
				request.setAttribute("video", v);
				vista = VIEW_FORM;
				LOG.error(e.getMessage());
			} catch (SQLException e) {
				alerta.setAlerta("Lo sentimos, error inesperado");
				alerta.setTipo(ALERTA_DANGER);
				LOG.error(e.getMessage());
			}
		}
		listar(request);
	}

	private void irFormulario(HttpServletRequest request) {
		
		vista = VIEW_FORM;
		Video v = new Video();
		
		Long identificador = Long.parseLong(id);
		if (identificador > 0) {
			v = dao.getById(identificador);
		}else {
			alerta.setAlerta("Crear un nuevo Video");
			alerta.setTipo(ALERTA_INFO);
		}
		request.setAttribute("video", v);
	}

	private void listar(HttpServletRequest request) {
		request.setAttribute("videos", dao.getAll());
		
	}

	private void getParametros(HttpServletRequest request) {
		op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}
		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		codigo = request.getParameter("codigo");
		
		LOG.debug(String.format("Parametros: op=%s id=%s nombre=%s codigo=%s", op, id, nombre, codigo));
	}

}
