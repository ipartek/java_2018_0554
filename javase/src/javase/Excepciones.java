package javase;

public class Excepciones {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		int a = 5, b = 0;
		int div;
		
		try {
			String s = null;
			
			System.out.println(s.toUpperCase());
			
			System.out.println("Vamos a mostrar el resultado de " + a + "/" + b);
			
			int[] arr = new int[2];
			
			arr[2] = 5;
			
			div = a / b;
		} catch (ArithmeticException ae) {
			System.out.println("Ha fallado la división");
			System.out.println("Damos como valor el mayor posible");
			div = Integer.MAX_VALUE;
			//e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("Te has salido del array, majete");
			return;
		} catch(Exception e) {
			System.out.println("Error no esperado");
			System.out.println(e);
			System.out.println(e.getMessage());
			return;
		} finally {
			System.out.println("Aprovecho para cerrar (.close() ) incondicionalmente todos los elementos que estén abiertos");
		}
		
		System.out.println("El resultado es " + div);
		System.out.println("CONTINUACIÓN DEL PROGRAMA");
	}

}
