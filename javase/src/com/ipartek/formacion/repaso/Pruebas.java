package com.ipartek.formacion.repaso;

import java.util.ArrayList;
import java.util.List;

class Pruebas {
	public static void main(String[] args) {
		List<Empleado> empleados = new ArrayList<Empleado>();

		//Un empleado indefinido se puede agregar a una colección de Empleado a secas
		//porque EmpleadoIndefinido define todo lo necesario para poder dar respuesta
		//a todas las necesidades de un Empleado
		EmpleadoIndefinido ef = new EmpleadoIndefinido(
				1L, "Javier", "Lete", //Persona
				"123456789", "12345678Z", //Empleado
				EmpleadoIndefinido.SUELDO_ANUAL_POR_DEFECTO, 14);
		
		System.out.println(Math.E);
		
		//System.out.println(ef.SUELDO_ANUAL_POR_DEFECTO); // Se puede, pero no se debe
		
		empleados.add(ef); //EmpleadoIndefinido
		
		//Iterable<Empleado> conjuntoARecorrer = empleados;
		
		for (Empleado empleado : empleados) {//conjuntoARecorrer) {
			System.out.println(empleado.getClass());
			  
			System.out.println(empleado);
			System.out.println(empleado.getSueldoMensual());
			
			//empleado se ha declarado como un tipo de clase Empleado
			//Desde ese tipo es imposible acceder al número de pagas
			//Para conseguir acceso a ese dato hacemos lo siguiente
			
			//Pregunto si el objeto referenciado por la variable empleado 
			//pertenece a la clase EmpleadoIndefinido
			if(empleado instanceof EmpleadoIndefinido) { 
				//Como ya sabemos seguro que la variable empleado apunta a un objeto
				//que tiene las características de un EmpleadoIndefinido
				//hacemos un casting que sabemos 100% que va a funcionar
				EmpleadoIndefinido empleadoIndefinido = (EmpleadoIndefinido) empleado;
				//Obtenemos el número de pagas sin problema porque ya trabajamos sobre
				//un tipo EmpleadoIndefinido, el cual tiene definido el método que queremos
				System.out.println(empleadoIndefinido.getNumeroDePagas());
			}
		}
	}

}
