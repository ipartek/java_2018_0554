package javase;

import java.util.Scanner;

// import java.lang.*;

/**
 * Clase de ejemplo de inicio de Java
 * 
 * @author JavierLete
 *
 */
public class HolaMundo {
	/**
	 * Método que se ejecutará cuando se inicie la aplicación
	 * 
	 * @param args Argumentos de consola recibidos en un array
	 */
	public static void main(String[] args) {
		System.out.println("Hola Mundo"); // Muestra "Hola Mundo" por pantalla

		// Comentario
		// de
		// varias
		// líneas

		// CTRL-MAY-7 ó CTRL-7

		/*
		 * Comentario multilínea mucho más cómodo
		 */

		// TIPOS PRIMITIVOS

		// Enteros TODOS CON SIGNO
		@SuppressWarnings("unused")
		byte b; // 8 bits -128 a 127
		@SuppressWarnings("unused")
		short s;// 16 bits -32768 a 32767
		int i; // 32 bits ~-2127M a ~2127M
		@SuppressWarnings("unused")
		long l; // 64 bits (trillones)

		i = 5;

		System.out.println("El valor de i es " + i);

		// COMA FLOTANTE | SIGNO | EXPONENTE | MANTISA (signo * mantisa * 2 ^ exponente)
		@SuppressWarnings("unused")
		float f; // 32 bits
		double d; // 64 bits

		d = 5.3E7; // 5000E-3 != 5 NUNCA COMPARAR IGUALDAD ENTRE NÚMEROS DE COMA FLOTANTE

		System.out.println(d);

		// BOOLEANO SÓLO PUEDEN VALER true O false
		@SuppressWarnings("unused")
		boolean bool;

		bool = true; // false

		// CARACTER
		@SuppressWarnings("unused")
		char c;

		c = 'l';

		// FIN DE TIPOS PRIMITIVOS (8)

		// Clases equivalentes a los tipos primitivos
		// Byte, Short, Integer, Long, Float, Double, Boolean, Character

		// OPERADORES
		// Matemáticos: + - * / %

		int resto = 5 % 3; // El resto de dividir 5 / 3 es 2

		System.out.println(resto);

		// Comparaciones: ==, !=, <, >, <=, >=

		int x = 5;
		System.out.println(x == 3);

		System.out.println(x);

		// Operadores lógicos: &&, ||, !

		System.out.println(!(1 <= x && x <= 10));

		System.out.println(1 > x || x > 10);

		// Operadores a nivel de bits: &, |, ~, ^
		x = 5 | 2; // XOR

		System.out.println(x);

		// Operadores de asignación: =, +=, -=, *=, /= ...

		int y = x = 2;

		y += 5; // y = y + 5

		// Incremento decremento (--, ++)
		y = 1;

		System.out.println(++y); // PREincremento
		System.out.println(y++); // POSTincremento

		//Operador condicional ? :
		boolean datoBooleano = false;
		System.out.println(datoBooleano ? "VERDADERO" : "FALSO");

		if(datoBooleano) {
			System.out.println("VERDADERO");
		} else {
			System.out.println("FALSO");
		}
		
		int num1 = 5, num2 = 10;
		int max = num1 > num2 ? num1: num2;
		
		if(num1 > num2) {
			max = num1;
		} else {
			max = num2;
		}
		
		System.out.println(max);
		
		// Sentencias de control

		boolean estaArrancado = false;

		if (estaArrancado) {
			System.out.println("Verdadero");
		} else {
			System.out.println("Falso");
		}

		// if, switch, while, do while, for, break, continue
		bucleprincipal: for (int veces = 1; veces <= 2; veces++) {
			for (int indice = 1; indice <= 10; indice++) {
				if (indice % 3 == 0) {
					continue bucleprincipal; // break;
				}
				System.out.println(indice);
			}
		}
		
		// Tipos de datos básicos
		String nombreCompleto = "Javier Lete";
		String nombre = "Javier";
		String apellido = "Lete";
		
		System.out.println("Mi nombre es " + nombreCompleto);
		
		String nombreCompuesto = nombre + " " + apellido;
		
		if(nombreCompleto.equals(nombreCompuesto)) { //NUNCA CON ==
			System.out.println("Bienvenido profesor");
		} else {
			System.out.println("Bienvenido desconocido");
		}
		
		System.out.println("hola".toUpperCase());
		
		nombre = null;
		
		System.out.println("Javier".equals(nombre));
		System.out.println(nombre != null && nombre.equals("Javier"));
		
		System.out.println("      ñlajsd ñlkah  ñlkaj dsñl hasd      ".trim());
		
		// ARRAYS
		String[] arr = new String[2];
		
		arr[0] = "Texto1"; arr[1] = "Texto2"; //arr[2] = "Texto3";
		
		for(i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		for(String texto: arr) { //Java5
			System.out.println(texto);
		}
		
		String[] meses = { "Enero", "Febrero" };
		
		char[][] tablero = new char[8][8];
		
		tablero[0][0] = 'T';
		
		for(x = 0; x < tablero.length; x++) {
			System.out.println();
			for(y = 0; y < tablero[x].length; y++) {
				System.out.print(tablero[x][y]);
			}
		}
		
		//Leer de teclado Java 5
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce tu email: ");
		String email = sc.nextLine();
		
		System.out.println(email);
		
		sc.close();
		
		//Conversiones
		String sEntero = "5";
		int entero = Integer.parseInt(sEntero);
		
		String sDoblePrecision = "5.3";
		double doblePrecision = Double.parseDouble(sDoblePrecision);
		
		long largo = 5L;
		String sLargo = String.valueOf(largo);
		
		float fVariable = 5.3F;
		String sVariable = String.valueOf(fVariable);
		
		entero = (int) fVariable;
		
		//Funciones matemáticas
		double seno = Math.sin(5.5);
		
		//Vuelta de marcador
		int grande = Integer.MAX_VALUE;
		System.out.println(grande);
		
		System.out.println(++grande);
	}
}

// javase.HolaMundo.main()