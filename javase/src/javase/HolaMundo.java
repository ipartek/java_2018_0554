package javase;

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
		int i; // 32 bits ~-4000M a ~4000M
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

		// Sentencias de control

		boolean estaArrancado = false;

		if (estaArrancado) {
			System.out.println("Verdadero");
		} else {
			System.out.println("Falso");
		}

		// if, switch, while, do while, for
		bucleprincipal: for (int veces = 1; veces <= 2; veces++) {
			for (int indice = 1; indice <= 10; indice++) {
				if (indice % 3 == 0) {
					continue bucleprincipal; // break;
				}
				System.out.println(indice);
			}
		}

		// break, continue
	}

}

// javase.HolaMundo.main()