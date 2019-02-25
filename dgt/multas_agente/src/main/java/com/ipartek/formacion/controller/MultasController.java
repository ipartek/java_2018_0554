package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
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

import com.ipartek.formacion.controller.pojo.Mensaje;
import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;

/**
 * Servlet implementation class MultasController
 */
@WebServlet("/privado/multas")
public class MultasController extends HttpServlet {
	private final static Logger LOG = Logger.getLogger(MultasController.class);
	
	// Clase que lleva mensajes de información, peligro u error
	private Mensaje mensaje;
	
	// Constantes que contienen los archivos .jsp. 
	// Aquí se encuentra tanto el contenido visual (html) y la información pertinente sacada de los controladores
	private static final String VISTA_PRAL = "principal.jsp";
	private static final String VISTA_INDEX = "multas/index.jsp";
	private static final String VISTA_FORM = "multas/form.jsp";
	private static final String VISTA_BUSCAR = "multas/buscar.jsp";
	
	private ValidatorFactory factory;
	private Validator validator;
	
	private static final long serialVersionUID = 1L;

	private Calendar fechaActual;
	private MultaDAO daoMulta;
	private CocheDAO daoCoche;

	private String op = null;
	String opm = "";
	String opr = "";
	
	// Parametros
	String importe = "";
	String concepto = "";
	String id_coche = "";
	String vista = "";
	String idMultaStr = "";
	String matricula = "";
	
	// Objectos
	Agente a = null;
	Coche c = null;
	Multa m = null;

	HttpSession session;
	
	/**
	 * Método de inicio de servidor que declara el validador
	 * Declaración de los 'Data Access Object' de los objetos multa y coche
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		fechaActual = Calendar.getInstance();
		daoMulta = MultaDAO.getInstance();
		daoCoche = CocheDAO.getInstance();
	}
	
	/**
	 * Métodos 'doGet' y 'doPost' que llaman al método principal 'doProcess'
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	/**
	 * Método con el proceso principal de la aplicación que llama a los demás métodos
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getParameters(request);
		switch (op) {
		case "ver":
			opVer(request);
			break;
		case "irA":
			opIrA(request);
			break;
		case "buscar":
			opBuscar(request);
			break;
		case "multar":
			opMultar(request);
			break;
		case "anular":
			opAnular(request);
			break;
		default: 
			mensaje = new Mensaje(Mensaje.TIPO_DANGER, "Operación incorrecta");
			vista = VISTA_PRAL;
			LOG.debug(mensaje.getTexto());
			break;
		}
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("op", op);
		request.setAttribute("opm", opm);
		LOG.debug("Mostrando la vista");
		request.getRequestDispatcher(vista).forward(request, response);
	}
	/**
	 * Recoge todos los parámetros al llevarnos a la vista para:
	 * 1. Buscar matrículas
	 * 2. Rellenar la lista de multas de un policía
	 * 3. Rellenar la lista de multas anuladas de un policía
	 * 4. Mostrar el formulario con los datos de una multa sacada de cualquiera
	 * de las 2 listas
	 * 5. Multar a un coche
	 * 6. Anular la multa de un coche
	 * 
	 * Parametros:
	 * 
	 * - a 
	 * Es el objeto agente en session
	 * 
	 * - matricula
	 * Cadena de caracteres que contiene la matricula de un coche seleccionado
	 * 
	 * - op
	 * La variable de operación que se usará para llamar al resto de métodos
	 * 
	 * - opm
	 * Es una variable que se establece a 'baja' cuando se acude al método 'opAnular', el cual
	 * permite hacer esencialmente lo mismo que el método 'opVer' pero permite
	 * ver las multas que se han dado de baja
	 * 
	 * - importe
	 * Importe de la multa
	 * 
	 * - concepto
	 * Razón o concepto de la multa
	 * 
	 * - id_coche
	 * Identificador unívoco del coche que consultamos o al que queremos poner o anular una multa
	 */
	private void getParameters(HttpServletRequest request) {
		session = request.getSession();
		a = (Agente) session.getAttribute("agenteLogueado");
		try {
			op = request.getParameter("op");
			if (op == null) {
				op = "ver";
			}
			opm = request.getParameter("opm");
			opr = request.getParameter("opr");
			idMultaStr = request.getParameter("idmulta");
			matricula = request.getParameter("matricula");
			importe = request.getParameter("importe");
			concepto = request.getParameter("concepto");
			id_coche = request.getParameter("idcoche");
			mensaje=null;
			LOG.debug("Parametros recuperados satisfactoriamente");
		} catch (Exception e) {
			mensaje = new Mensaje(Mensaje.TIPO_DANGER, "Parámetros introducidos incorrectos");
			vista = VISTA_PRAL;
			LOG.error(mensaje.getTexto()+e.getMessage());
		}
	}
	/**
	 * En caso de tener o no una multa almacenada en 'idMultaStr':
	 * - Nos retorna el DAO de las multas que ha puesto un agente identificado por su id
	 * - Si contiene 'baja' en la variable opm, retorna el DAO de las multas anuladas de un agente identificado por su id
	 * - Nos retorna el objeto multa que contiene una multa en concreto
	 * En caso de excepción:
	 * El importeStr o el concepto de la multa son de tipos incorrectos. Siempre se devuelve a al jsp index de multas con el mensaje de error
	 */
	private void opVer(HttpServletRequest request) {
		if (idMultaStr == null) {
			try {
				request.setAttribute("multas", daoMulta.getAllByUser(a.getId(), opm));			
			}
			catch (Exception e) {
				mensaje = new Mensaje(Mensaje.TIPO_DANGER, "No se han puesto multas");
				LOG.error(mensaje.getTexto());
			}
			if(opm == null) {
				request.setAttribute("titulo", "Tus multas | App Multas");
				LOG.info("Buscando todas las multas puestas por el agente");
			}
			else {
				request.setAttribute("titulo", "Tus multas anuladas | App Multas");
				LOG.info("Buscando todas las multas anuladas por el agente");
			}
			vista = VISTA_INDEX;
		} else {
			long idMulta = Long.parseLong(idMultaStr);
			try {
				m = daoMulta.getById(idMulta, opm);
				request.setAttribute("multa", m);
				LOG.info("Información de la multa "+idMulta);
				request.setAttribute("titulo", "Multa nº"+idMulta+". Coche: "+m.getCoche().getMatricula()+" | App Multas");
				mensaje = null;
				vista = VISTA_FORM;
			}
			catch (Exception e) {
				mensaje = new Mensaje(Mensaje.TIPO_DANGER, "La multa que buscas no existe");
				if(opm == null) {
					request.setAttribute("titulo", "Tus multas | App Multas");
					LOG.info("Buscando todas las multas puestas por el agente");
				}
				else {
					request.setAttribute("titulo", "Tus multas anuladas | App Multas");
					LOG.info("Buscando todas las multas anuladas por el agente");
				}
				LOG.error(mensaje.getTexto(), e);
				vista = VISTA_INDEX;
			}
		}
	}
	
	/**
	 * Cuando queramos multar un coche, este método nos conducirá a un buscador de matriculas de coche.
	 * Se compone de un pequeño formulario con un input donde introducir la matrícula
	 * Se trata del método anterior a 'opBuscar'
	 */
	private void opIrA(HttpServletRequest request) {
		vista = VISTA_BUSCAR;
		request.setAttribute("titulo", "Introduzca una matrícula | App Multas");
		LOG.info("Accediendo a la busqueda de matriculas");
	}
	
	/**
	 *  Obtiene la matricula y guarda el objeto del coche en la variable 'c'.
	 *  Nos enviará un mensaje de exito al formulario si existe
	 *  Si no, nos avisará de que no se ha encontrado ninguna matricula en el formulario de búsqueda
	 *  Se trata del método posterior a 'opIrA'
	 */
	private void opBuscar(HttpServletRequest request) {
		c = daoCoche.getByMatricula(matricula);
		if (c != null) {
			request.setAttribute("coche", c);
			request.setAttribute("fecha", new Date());
			request.setAttribute("titulo", "Registra los datos de la multa de "+c.getMatricula()+" | App Multas");
			vista = VISTA_FORM;
			LOG.debug("Matricula conseguida");
		} else {
			mensaje = new Mensaje(Mensaje.TIPO_DANGER, "La matrícula no existe");
			request.setAttribute("matricula", matricula);
			vista = VISTA_BUSCAR;
			request.setAttribute("titulo", "Introduzca una matrícula | App Multas");
			LOG.warn(mensaje.getTexto());
		}
	}
	/**
	 * Se rellenan los datos de la multa al coche seleccionado usando los objetos 'Multa' y 'Coche'
	 * Usamos un validator de la instancia del objeto multa.
	 * Si hay errores se devuelve a la vista de búsqueda y se indican los errores
	 * En caso de no haberlos se inserta la multa en la base de datos usando el metodo insert de daoMulta.
	 * Si hay una excepción en la inserción de la multa, se devuelve la vista del formulario
	 */
	private void opMultar(HttpServletRequest request) {
		m = new Multa();
		c = new Coche();
		try {
			m.setConcepto(concepto);
			c.setId(Long.parseLong(id_coche));
			m.setCoche(c);
			m.setImporte(Double.parseDouble(importe));
			m.setAgente((Agente) session.getAttribute("agenteLogueado"));
			Set<ConstraintViolation<Multa>> violations = validator.validate(m);
			if (violations.size() > 0) {
				String errores = "<ul class='list-unlisted'>";
				for (ConstraintViolation<Multa> violation : violations) {
					errores += "<li>" + violation.getPropertyPath() + ": " + violation.getMessage() + "</li>";
				}
				vista = VISTA_FORM;
				errores += "</ul>";
				request.setAttribute("concepto", concepto);
				request.setAttribute("importe", importe);
				op = "buscar";
				mensaje = new Mensaje(Mensaje.TIPO_DANGER, errores);
				LOG.debug(mensaje.getTexto());
				opBuscar(request);
			}
			else {
				LOG.debug("No hay violaciones. Se procede a crear una multa");
				try {
					if (daoMulta.insert(m)) {
						String minuto = "";
						if (fechaActual.get(Calendar.MINUTE) < 10) {
							minuto = "0";
							minuto += String.valueOf(fechaActual.get(Calendar.MINUTE));
						} else {
							minuto = String.valueOf(fechaActual.get(Calendar.MINUTE));
						}
						mensaje = new Mensaje(Mensaje.TIPO_INFO, "Coche multado. Fecha: "+fechaActual.get(Calendar.YEAR)+"/"+fechaActual.get(Calendar.MONTH)+1+"/"+fechaActual.get(Calendar.DAY_OF_MONTH)+" "+fechaActual.get(Calendar.HOUR_OF_DAY)+":"+minuto+" Matricula: "+m.getCoche().getMatricula()+" Importe: "+m.getImporte()+" Agente: "+a.getNombre());
						LOG.info(mensaje.getTexto());
						idMultaStr = null;
						opVer(request);
					} else {
						request.setAttribute("concepto", concepto);
						request.setAttribute("importe", importe);
						op = "buscar";
						mensaje = new Mensaje(Mensaje.TIPO_WARNING, "No es posible multar al coche revise el importe y el concepto");
						vista = VISTA_FORM;
						LOG.debug(mensaje.getTexto());
						opBuscar(request);
					}
				} catch (SQLException e) {
					request.setAttribute("concepto", concepto);
					request.setAttribute("importe", importe);
					op = "buscar";
					mensaje = new Mensaje(Mensaje.TIPO_DANGER, "Parámetros incorrectos");
					vista = VISTA_FORM;
					LOG.debug(mensaje.getTexto(), e);
					opBuscar(request);
				}
			}
		}
		catch (Exception e) {
			request.setAttribute("concepto", concepto);
			request.setAttribute("importe", importe);
			op = "buscar";
			mensaje = new Mensaje(Mensaje.TIPO_DANGER, "El importe es incorrecto");
			LOG.debug(mensaje.getTexto(), e);
			opBuscar(request);
		}
	}
	/**
	 * Similar al método 'opVer', solo que lleva la variable 'opm'
	 * para ver las multas anuladas. En caso de que la variable 'opr' 
	 * lleve un valor distinto a 'norecuperar', recupera la multa anulada
	 * Para más información, mirar el método 'opVer'.
	 */
	private void opAnular(HttpServletRequest request) {
		try {
			opm = "baja";
			m = daoMulta.getById(Long.parseLong(idMultaStr),opm);
			if (m!=null) {
				if(daoMulta.update(m,opr)) {
					op = "ver";
					if("norecuperar".equals(opr)) {
						opm = "baja";
					}else {
						opm = "nobaja";
					}					
					idMultaStr = null;
					opVer(request);
				}
			}
		} catch (SQLException e) {
			mensaje = new Mensaje(Mensaje.TIPO_WARNING, "No se puede anular la multa");
			LOG.error(mensaje.getTexto(), e);
		}
	}
}
