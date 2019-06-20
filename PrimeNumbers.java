//Program that is printing the prime numbers
//Created by: Marius Popescu
//Date: December 14, 2018

public class PrimeNumbers {
	public static void main (String[] arg) {
		final int UPPER_BOUND = 100;
		for (int i = 1; i <= UPPER_BOUND; i++) {
			if (isPrime(i)) {
				System.out.print(i + " "); //print all prime numbers until the upper bound
			}
		}
	}
	//Method that check if a number is prime
	private static boolean isPrime(int i) {
		for (int x = 2; x*x <= i; x++) {
			if (i%x == 0) { //if is divided by any numbers beside self, then is not prime
				return false;
			}
		}
		return true;
	}
}
