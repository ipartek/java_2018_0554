package com.ipartek.formacion.poo;

public class UsuarioExtendidoPruebas {
	public static void main(String[] args) {
		UsuarioExtendido ue = new UsuarioExtendido("Nuevo Nuevito");
		
		System.out.println(ue.datosCompletos());
		
		ue.setNombre("Nuevo Nuevez");
		ue.setEmail("nuevo@nuevez.es");
		ue.setPassword("yepa");
		
		System.out.println(ue.datosCompletos("corchetes"));
		System.out.println(ue.datosCompletos());
	}
}
