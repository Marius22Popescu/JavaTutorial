//Program that is computing the factorial from a given number
//Created by: Marius Popescu
//Date: December 14, 2018
import java.util.Scanner;
public class FactorialNumber {
	public static void main (String args[]) {
		Scanner console = new Scanner(System.in); 
		int nr;
		//Prompting the user for a number in order to find the factorial
		System.out.print("Please enter a number to find the factorial:");
		nr = console.nextInt(); 
		System.out.println("The factorial number for "+ nr +" is: " + getFactorial(nr));
	}
	//This method is computing the factorial
	private static int getFactorial(int nr) {
		int factorial = 1;
			for (int i = 1; i<= nr; i++)
				factorial *= i;
		return factorial;
}
}