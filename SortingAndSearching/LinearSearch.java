//Linear Search
//Created by: Marius Popescu
//Date: December 16, 2018
package SortingAndSearching;

public class LinearSearch {
	public static void main (String arg[]) {
		int arr[] = {0, 1, 3, 5, 6, 7, 8, 9 , 10 , 12};
		final int TARGET = 7;
		linearSearch(TARGET, arr);
		
	}

	private static void linearSearch(int target, int[] arr) {
		boolean found = false;
		for (int i = 0; i<arr.length-1; i++) {
			if(target == arr[i]) {
				System.out.println("The number: " + target+ " was found at index no: " + i);
				found = true;
			}
		}
		if (found == false)
			System.out.println("The number is not in the array!");
	}
}
