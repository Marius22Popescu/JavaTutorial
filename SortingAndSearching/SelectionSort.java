//Selection Sort
//Created by: Marius Popescu
//Date: December 16, 2018
package SortingAndSearching;

public class SelectionSort {
	public static void main (String arg[]) {
		int [] arr = { 5, 3, 7, 9, 2, 4, 8, 1, 6};
		System.out.println("The initial unsorted array is: ");
		for (int x: arr) {
			System.out.print(x+ " ");			
		}
		System.out.println(" ");
		selectionSort(arr);
		System.out.println("The sorted array is: ");
		for (int x: arr) {
			System.out.print(x+ " ");			
		}
	}

	private static void selectionSort(int[] arr) {
		    //move forward in the unsorted array
	        for (int i = 0; i < arr.length; i++) { 
	            // Find the minimum element in unsorted array 
	            int minIndex = i; 
	            for (int j = i+1; j < arr.length; j++) {
	                if (arr[j] < arr[minIndex]) 
	                    minIndex = j; 
	            }
	            // Swap the minimum element found with the first element 
	            int temp = arr[i];
	            arr[i] = arr[minIndex];
	            arr[minIndex] = temp;
		}
	}		
}
	

