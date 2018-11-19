package javase;

// import java.lang.*;

/**
 * Clase de ejemplo de inicio de Java
 * @author JavierLete
 *
 */
public class HolaMundo {
	/**
	 * Método que se ejecutará cuando se inicie la aplicación
	 * @param args Argumentos de consola recibidos en un array
	 */
	public static void main(String[] args) {
		System.out.println("Hola Mundo"); // Muestra "Hola Mundo" por pantalla
		
		// Comentario
		// de
		// varias
		// líneas
		
		// CTRL-MAY-7 ó CTRL-7
		
		/* Comentario
		 * multilínea
		 * mucho más cómodo
		 */
		
		// TIPOS PRIMITIVOS
		
		// Enteros TODOS CON SIGNO
		@SuppressWarnings("unused")
		byte b; // 8 bits -128 a 127
		@SuppressWarnings("unused")
		short s;// 16 bits -32768 a 32767
		int i;  // 32 bits ~-4000M a ~4000M
		@SuppressWarnings("unused")
		long l; // 64 bits (trillones)
		
		i = 5;
		
		System.out.println("El valor de i es " + i);
		
		// COMA FLOTANTE | SIGNO | EXPONENTE | MANTISA (signo * mantisa * 2 ^ exponente)
		@SuppressWarnings("unused")
		float f;  // 32 bits
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
	}

}


// javase.HolaMundo.main()