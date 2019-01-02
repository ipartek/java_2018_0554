package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelo.pojos.Disco;

/**
 * Servlet implementation class DiscoController
 */
@WebServlet("/disco")
public class DiscoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ArrayList<Disco> disco;	
	private ValidatorFactory factory;
	private Validator validator;

	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
		
		
		disco = new  ArrayList<Disco>();
		disco.add(new Disco(1L, "Trapped!","Rage", "https://images-na.ssl-images-amazon.com/images/I/718mNFu5jfL._SY355_.jpg", "1992"));
		disco.add(new Disco(2L, "Firepower","Judas Priest", "https://diablorock.com/wp-content/uploads/2018/03/firepower_portada.jpg", "2018"));
		disco.add(new Disco(3L, "01011001","Ayreon", "https://upload.wikimedia.org/wikipedia/en/a/ae/Ayreon_-_01011001.jpg", "2008"));
		disco.add(new Disco(4L, "The Bottom Deep","Communic", "https://upload.wikimedia.org/wikipedia/en/thumb/f/f1/Communic-2011.jpg/220px-Communic-2011.jpg", "2011"));
		disco.add(new Disco(5L, "Apocalypse","Primal Fear", "https://i2.wp.com/rockangels.com/web/wp-content/uploads/2018/08/primalfearapocalypsecd.jpg", "2018"));
		disco.add(new Disco(6L, "Voyage", "The Vintage Caravan","https://rockthebestmusic.com/wp-content/uploads/2014/01/the-vintage-caravan-voyage.png","2014"));
		disco.add(new Disco(7L, "Killing The Dragon", "Dio", "https://upload.wikimedia.org/wikipedia/en/c/cd/DioKillingTheDragon.jpg", "2002"));
		disco.add(new Disco(7L, "Dehumanizer", "Black Sabbath", "https://upload.wikimedia.org/wikipedia/en/1/12/Black-sabbath-dehumanizer.jpg", "1992"));
	}
	
	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("disco", disco);
		
		request.getRequestDispatcher("discos.jsp").forward(request, response);
	}

}
