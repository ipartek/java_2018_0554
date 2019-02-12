package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.daos.ObjetivoDAO;
import com.ipartek.formacion.pojos.Objetivo;



@WebServlet("/privado/objetivos")
public class ObjetivosController extends HttpServlet {
	private static final float OBJETIVO_ANUAL_12000 = 12000F;
	private static final float OBJETIVO_MENSUAL_1000 = 1000F;
	private static final long serialVersionUID = 1L;
	//LOG
		private final static Logger LOG = Logger.getLogger(ObjetivosController.class);

		private ObjetivoDAO objetivoDAO = null;
		private Objetivo objetivo = null;
		private Objetivo objetivo2 = null;
		private ArrayList<Integer> anios = null;
		private ArrayList<Objetivo> historico = null;
		Integer a;
		String estado="";
		String estado2="";
		@Override
	    public void init(ServletConfig config) throws ServletException {    
	    	super.init(config);
	    	objetivoDAO = ObjetivoDAO.getInstance();	
	    }
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);}
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id_agente = request.getParameter("id_agente");
		String anyo = request.getParameter("a");
		
		Long id = Long.parseLong(id_agente);
		
		objetivo = objetivoDAO.objetivoActual(id,1); 
		try {
			estado = color(objetivo.getImporte(),OBJETIVO_MENSUAL_1000);
		}catch(Exception e) {
			estado = color(0F,OBJETIVO_MENSUAL_1000);
		}
		
		request.setAttribute("objetivo", objetivo);	
		request.setAttribute("estado", estado);
		
		objetivo2 = objetivoDAO.objetivoActual(id,2); 
		estado2 = color(objetivo2.getImporte(),OBJETIVO_ANUAL_12000);
		request.setAttribute("objetivo2", objetivo2);	
		request.setAttribute("estado2", estado2);
		anios = objetivoDAO.selectAnyo(id);
		
		Integer maxAnio= objetivoDAO.ultimoAnio(anios);
		
		try {
			  a = Integer.parseInt(anyo);
			  historico = objetivoDAO.historico(id,a); 

			request.setAttribute("historico", historico);	
			request.setAttribute("a", a);	
			LOG.debug("historico año: "+a);
			}catch(Exception e) {
				a=null;
				historico = objetivoDAO.historico(id,maxAnio); 
				request.setAttribute("historico", historico);	
				LOG.debug("historico año actual");
			}
		
		
		
		 
		request.setAttribute("anios", anios);	
		
		request.getRequestDispatcher("objetivos.jsp").forward(request, response);
			
	}
	
	private static String color(Float importe, Float i) {
		String resultado="";
		if(importe>=i) {
			resultado ="success";
		}else if(importe>=(i/2)) {
			resultado ="warning";
		}else {
			resultado ="danger";
		}
		return resultado;
	}
	
}
	
	