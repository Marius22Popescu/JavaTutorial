//Insertion Sort
//Created by: Marius Popescu
//Date: December 16, 2018
package SortingAndSearching;

public class InsertionSort {
	public static void main (String arg[]) {
		int [] arr = { 5, 3, 7, 9, 2, 4, 8, 1, 6};
		System.out.println("The initial unsorted array is: ");
		for (int x: arr) {
			System.out.print(x+ " ");			
		}
		System.out.println(" ");
		insertionSort(arr);
		System.out.println("The sorted array is: ");
		for (int x: arr) {
			System.out.print(x+ " ");			
		}
	}

	public static void insertionSort(int[] arr) {
        for (int x = 1; x < arr.length; x++) {  
            int current = arr[x];  //store the current element
            int comparableIndex = x-1;  //set the comparable index 
            while ( (comparableIndex > -1) && ( arr [comparableIndex] > current ) ) {  
                arr [comparableIndex+1] = arr [comparableIndex];  //swap 1
                comparableIndex--;  //decrease the comparable index
            }  
            arr[comparableIndex+1] = current;  //swap 2
        }  			
	}
}
