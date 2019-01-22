package com.ipartek.formacion.ws.cliente;

import java.rmi.RemoteException;

import UASI.WS_GRAL_wsdl.ClaseAlojamiento;
import UASI.WS_GRAL_wsdl.Pub_gralSoapProxy;

public class ClienteGral {

	public static void main(String[] args) throws RemoteException {
		Pub_gralSoapProxy client= new Pub_gralSoapProxy();
		ClaseAlojamiento[] alojamientos= client.wsalojamientos();
		
		for (int i = 0; i < alojamientos.length; i++) {
			System.out.println(alojamientos[i]);
		}
		
	}

}
