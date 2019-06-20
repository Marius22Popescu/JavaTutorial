package com.marius.Test;

public class Generics 
{
//Generic Methods
	public static <E> void printArr(E[] items){
		for (E it: items) {
			System.out.print(" "+it);
		}
	}

//Generic parameters
	 public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;
		if (y.compareTo(max) > 0) max = y;
		if (z.compareTo(max) > 0) max = z;
		
		return max;
	}
	 

	
    public static void main( String[] args )
    {
        Integer [] inte = {1, 2, 3, 4};
        String [] str = {"sfsf", "fsfsf", "fsfsd"};
        Character[] ch = {'a', 'b', 'c'};
        
        printArr(inte);
        printArr(str);
        printArr(ch);
        
        System.out.println();
        
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum( 3, 4, 5 ));
        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ));
        System.out.printf("Max of %s, %s and %s is %s\n","pear", "apple", "orange", maximum("pear", "apple", "orange"));
        
    }
}
