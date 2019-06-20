package Challenges;
//multiplication without using the * multiply operator
public class MultiplicationWithoutSighn {
	public static void main (String[] args) {
		int a  = 3;
		int b = 5;
		System.out.println(multiply( a, b));
	}

	private static int multiply(int a, int b) {
		int result = 0;
		for (int i = 0; i < a; i++) {
			result += b;
		}
		return result;
	}
	

}
