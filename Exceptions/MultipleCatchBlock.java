package Exceptions;

public class MultipleCatchBlock { 
		  public static void main(String args[]){  
		   try{  
		    int a[]=new int[5];  
		    a[5]=30/0;  
		   }  
		   catch(ArithmeticException e){System.out.println("Arithmetic error...");}  
		   catch(ArrayIndexOutOfBoundsException e){System.out.println("Array Index Out of Bound ...");}  
		   catch(Exception e){System.out.println("Exception e...");}  
		  
		   System.out.println("rest of the code...");  
		 }   
}
