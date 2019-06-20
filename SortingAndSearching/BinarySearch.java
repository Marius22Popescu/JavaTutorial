//Binary Search
//Created by: Marius Popescu
//Date: December 16, 2018
package SortingAndSearching;

public class BinarySearch {
	public static void main (String args[]) {
		int arr[] = {2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 15, 17, 20, 22, 27};
		final int TARGET = 7;
		int left = 0;
		int right = arr.length -1;
		int index = binarySearch(arr, left , right, TARGET);
		if (index == -1)
			System.out.println("The desired number was not found in the array!");
		else
			System.out.println("The desired number was found at index: "+index );
	}

		static int binarySearch(int arr[], int left, int right, int target) 
		{ 
		    while (left <= right) { 
		        int middle = left + (right - left) / 2; 		  
		        // Check if the target is present at mid 
		        if (arr[middle] == target) 
		            return middle; 		  
		        // If target greater, go to right half 
		        if (arr[middle] < target) 
		            left = middle + 1; 		  
		        // If target is smaller, go to left half
		        else
		            right = middle - 1; 
		    } 
		    return -1; 
		} 
	}

