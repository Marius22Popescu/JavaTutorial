//Program that is printing the Fibonacci series
//Created by: Marius Popescu
//Date: December 14, 2018
public class FibonacciSeries {
	public static void main (String[] args) {

		final int COUNT = 20; //the desired size for the Fibonacci series 
		int nr = 0;
		int nr2 = 1;
		int next;  

		System.out.print(nr);  //printing first number
		for(int i = 2; i <= COUNT; i++)
		{    
			next = nr + nr2;    //calculated next number
			System.out.print(" "+ next);    //printing next number
			nr = nr2;    
			nr2 = next;    
		}    
	}
}
