package Challenges;
//Find the smallest "Zero-One" positive integer which is the multiples of a given number.
import java.util.Scanner;

public class ZeroOneMultiple {
	public static void main (String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int nr;
		System.out.println("Enter a number in order to find the zero-one multiple: " );
		nr = sc.nextInt();
		int multiple = 0;
		int mult = 2;
		boolean done = false; //will return true if the multiple is found
		while(done == false) {		
			multiple = mult * nr;
			done = foundMultiples(multiple);
			mult++;
		}
		System.out.println("The smallest Zero-One positive multiple is: " + multiple);		
	}
// this method will check if it is a Zero-One multiple
	private static boolean foundMultiples(int multiple) {
		boolean answer = true;
		while (multiple > 0) {
			if ((multiple%10 != 1)&&(multiple%10 != 0)){ //check the last digit
				answer = false;
			}
			multiple /= 10; //get rid of last digit
	}
		return answer;
  }
}
