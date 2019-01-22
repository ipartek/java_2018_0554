package com.ipartek.formacion.ws.cliente;

import java.rmi.RemoteException;

import UASI.WS_GRAL_wsdl.ClaseAlojamiento;
import UASI.WS_GRAL_wsdl.Pub_gralSoapProxy;

public class Alojamientos {

	public static void main(String[] args) throws RemoteException {
		System.out.println("Alojamientos de UA");
		Pub_gralSoapProxy cliente = new Pub_gralSoapProxy();
		ClaseAlojamiento[] alojamientos = cliente.wsalojamientos();
		System.out.println("total "+alojamientos.length);
		System.out.println("---------------------------------");
		
		for(int i = 0; i<alojamientos.length;i++) {
			System.out.println( alojamientos[i]);
		}
	}
}
