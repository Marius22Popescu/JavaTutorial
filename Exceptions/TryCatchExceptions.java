package Exceptions;

public class TryCatchExceptions {
	public static void main (String args[]) {
		int[] array = new int[3];
		try {
			array[0]= 10;
			array[1] = 3;
		//	array[5] = 2; //code that will throw an exception, array index out of bounds	
			array[2] = 7;
			array[7] = 9; //code that will throw an exception, array index out of bounds
		}
		catch (ArrayIndexOutOfBoundsException e) {
		    //runs this instead of crashing the program
		    System.out.println("Array index is out of bounds!"); 
		}
		finally {
			
		    System.out.println("The array is of size " + array.length);
		    for (int i = 0; i < array.length; i++) {
		    		System.out.println("The element "+ i+" is: "+array[i]);
		    	
		    }
		}

	}
	
}
