//Program that is checking if a given number is an Amstrong Number
//Created by: Marius Popescu
//Date: December 14, 2018
import java.lang.Math;
public class AmstrongNumber {
	public static void main(String args[]) {
		int nr = 371;
		int last, newNr = 0, n;
		n = nr;
		
		while (n > 0) {
			last = n%10; //get the last digit each time
			newNr += Math.pow(last, 3); //create the sum of the cubes
			n /= 10; //get rid of last digit
		}

		if (newNr == nr) //compare the numbers
			System.out.println("The number " + nr + " is an Amstrong number!");
		else
			System.out.println("The number " + nr + " is NOT an Amstrong number!");	
	}

}
