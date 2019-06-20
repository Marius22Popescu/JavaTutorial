//Program that is checking if a given number is palindrome
//Created by: Marius Popescu
//Date: December 14, 2018
import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeNumber {
	public static void main (String args[]) {
		Scanner console = new Scanner(System.in); 
		int nr;
		//Prompting the user for a number in order to find the factorial
		System.out.print("Please enter a number to find if is palindrome:");
		nr = console.nextInt(); 
		if(isPalindrome(nr))
			System.out.println("The number "+nr+" is a palindrome!");
		else
			System.out.println("The number " + nr +" is NOT a palindrome!");
	}
	//this method will check if the number is a palindrome
	static boolean isPalindrome(int x) {
		int comparable = 0;
		int reminder;
		int n = x;
		while (n > 0) {
			reminder = n % 10; //get the remainder
			comparable = (comparable*10)+ reminder;	//recreate the number backwards
			n = n/10; //get rid of last digit
		}
		if (x == comparable) //compare the numbers
			return true;
		else
			return false;		
	}
}
