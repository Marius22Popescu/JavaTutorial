package Exceptions;
//Using throws
public class ThrowVsThrowsExceptions2 {  
		   int division(int a, int b) throws ArithmeticException, NullPointerException{  
			int t = a/b;
			return t;
		   }  
		   public static void main(String args[]){  
			   ThrowVsThrowsExceptions2 obj = new ThrowVsThrowsExceptions2();
			try{
			   System.out.println(obj.division(15,0));
			}
			catch(ArithmeticException e){
			   System.out.println("You shouldn't divide number by zero");
			}
		   }  
}
//NullPointerException is not needed I put here just to show that you can handle multiple exceptions by declaring them using throws keyword.