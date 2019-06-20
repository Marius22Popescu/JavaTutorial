//Bubble Sort
//Created by: Marius Popescu
//Date: December 16, 2018
package SortingAndSearching;

public class BubbleSort {
		public static void main (String arg[]) {
			int [] arr = { 5, 3, 7, 9, 2, 4, 8, 1, 6};
			System.out.println("The initial unsorted array is: ");
			for (int x: arr) {
				System.out.print(x+ " ");			
			}
			System.out.println(" ");
			bubbleSort(arr);
			System.out.println("The sorted array is: ");
			for (int x: arr) {
				System.out.print(x+ " ");			
			}
		}

		private static void bubbleSort(int[] arr) {
			int l = arr.length - 1;
			for (int x = 0; x < arr.length; x++) {
				for (int i = 0; i < l; i++) {
					if (arr[i]>arr[i+1]) {	//if unsorted
						//swap the unsorted elements
						int temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
					}
				}
				l--;  //decrement l because after each iteration the biggest element will be in the last position
			}
		}
}
