package javase;

public class Recursividad {
	public static void main(String[] args) {
		System.out.println(factorial(20));
	}

	private static long factorial(long num) {
		if(num == 1) {
			return 1;
		}
		
		return num * factorial(num-1);
	}
}
