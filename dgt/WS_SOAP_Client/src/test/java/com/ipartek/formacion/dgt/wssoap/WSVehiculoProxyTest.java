package com.ipartek.formacion.dgt.wssoap;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import com.ipartek.formacion.modelo.pojo.Coche;

public class WSVehiculoProxyTest {

	@Test
	public void test() throws RemoteException {
		
		WSVehiculoProxy cliente = new WSVehiculoProxy();
		
		Coche cNoExiste = cliente.obtenerDatos("NO_VALIDA");		
		assertNull(cNoExiste);
		
		Coche cExiste = cliente.obtenerDatos("3548MKZ");
		assertNotNull(cExiste);
		assertEquals("3548MKZ", cExiste.getMatricula());		
		assertEquals("500", String.valueOf(cExiste.getKm()));
		
		
		
	}

}
