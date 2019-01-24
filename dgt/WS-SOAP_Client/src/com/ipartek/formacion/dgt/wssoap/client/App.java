package com.ipartek.formacion.dgt.wssoap.client;

import java.rmi.RemoteException;

import com.ipartek.appMultas.modelo.pojo.Coche;
import com.ipartek.formacion.dgt.wssoap.WSVehiculoProxy;

public class App {

	public static void main(String[] args) throws RemoteException  {
		
		WSVehiculoProxy cliente = new WSVehiculoProxy();
		
		Coche cNoExiste =cliente.obtenerDatos("No_Valida");
		System.out.println(cNoExiste);
		
		Coche cSiExiste =cliente.obtenerDatos("3548MKZ");
		System.out.println(cSiExiste.toString());
	}

}
