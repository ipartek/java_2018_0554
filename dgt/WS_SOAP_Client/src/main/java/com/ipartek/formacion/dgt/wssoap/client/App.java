package com.ipartek.formacion.dgt.wssoap.client;

import java.rmi.RemoteException;

import com.ipartek.formacion.dgt.wssoap.WSVehiculoProxy;
import com.ipartek.formacion.modelo.pojo.Coche;

public class App {

	public static void main(String[] args) throws RemoteException {
		WSVehiculoProxy cliente = new WSVehiculoProxy();
		Coche cNoExiste = cliente.obtenerDatos("no");
		System.out.println(cNoExiste);
		
		Coche cExiste = cliente.obtenerDatos("3548MKZ");
		System.out.println(cExiste);

	}

}
