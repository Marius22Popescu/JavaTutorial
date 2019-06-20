package Hackerrank;

public class MinimumSwaps {
	public static void main(String[] args) {
		int arr[] = {7, 1, 3, 2, 4, 5, 6};
		System.out.println(minimumSwaps(arr));
	}

	private static int minimumSwaps(int[] arr) {
		int swaps = 0;
		int temp = 0;
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i+1) {
				temp = arr[i];
				swaps++; //increment the no of swaps
				//search for the index of i+1 value
				for (int j = i+1; j < arr.length; j++) {
					if (arr[j] == i+1) {
						index = j;
						break; //break the for loop if index is found
					}
				}//swap 
				arr[i]= arr[index];
				arr[index]=temp;
			}
		}	
		return swaps;
	}
}
