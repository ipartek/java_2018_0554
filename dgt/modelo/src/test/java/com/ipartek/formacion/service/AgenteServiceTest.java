package com.ipartek.formacion.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.pojo.Multa;
import com.ipartek.appMultas.modelo.service.AgenteService;
import com.ipartek.appMultas.modelo.service.impl.AgenteServiceImpl;

public class AgenteServiceTest {
	
	private static AgenteService aService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		aService = AgenteServiceImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		aService = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void existe() {
		
		Agente agente = aService.existe("8ws", "asa");
		assertNull("Si no existe el agente deberia ser null", agente);
		
		agente = aService.existe(null, null);
		assertNull("Cuidadin con los null", agente);
		
		agente = aService.existe("admin", "admin");
		assertNotNull(" TODO cambiar numeroPlaca='admin' password='admin' por datos que existan en tu bbdd", agente);
		
	}

	
	@Test
	public void obtenerMultas() {
		
		int idAgente = -1;
		ArrayList<Multa> multas = (ArrayList<Multa>) aService.obtenerMultas(idAgente);
		assertNotNull("Cuidadin Deberia estar la lista inicializada a vacio, no NULL", multas);
		
		//TODO comprobar con un Agente que sepamos que tiene multas
		idAgente = 1;
		multas = (ArrayList<Multa>) aService.obtenerMultas(idAgente);
		assertNotNull("TODO comprobar con un Agente que sepamos que tiene multas", multas);
				
	}	
	
	@Test( expected= Exception.class )
	public void multarExceptionIdCoche() throws Exception {
		
		int idCoche = -1;
		int idAgente = 1;
		String concepto = "Lorem Ipsum";
		float importe = 50;
		
		//esperamos que lance Exception, si no falla Test
		aService.multar(idCoche, idAgente, concepto, importe);
		
	}
	
	@Test( expected= Exception.class )
	public void multarExceptionIdAgente() throws Exception {
		
		int idCoche = 1;
		int idAgente = -1;
		String concepto = "Lorem Ipsum";
		float importe = 50;
		
		//esperamos que lance Exception, si no falla Test
		aService.multar(idCoche, idAgente, concepto, importe);
		
	}
	
	@Test( expected= Exception.class )
	public void multarExceptionConceptoNull() throws Exception {
		
		int idCoche = 1;
		int idAgente = 1;
		String concepto = null;
		float importe = 50;
		
		//esperamos que lance Exception, si no falla Test
		aService.multar(idCoche, idAgente, concepto, importe);
		
	}
	
	@Test( expected= Exception.class )
	public void multarExceptionImporteNegativo() throws Exception {
		
		int idCoche = 1;
		int idAgente = 1;
		String concepto = "Lorem Ipsum....";
		float importe = -50;
		
		//esperamos que lance Exception, si no falla Test
		aService.multar(idCoche, idAgente, concepto, importe);
		
	}
	
	@Ignore
	public void multar() {
		//TODO probar que se puede poner una multa bien
	}
}


