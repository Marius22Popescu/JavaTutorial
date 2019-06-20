package SortingAndSearching;

public class ShellSort {
	
	private static void shellSort(int[] arr) {
		int l = arr.length; 
		for (int gap = l/2; gap>0; gap /=2) { //decrease the gap
			for (int i = gap; i < l; i++) { //go throw array in the gap step
				if (((i+1) <= l)&& (arr[i] > arr[i+1])) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i +1] = temp;
				}
//				int temp = arr[i];
//				int j;
//				for (j = i; j >= gap && arr[j - gap]>temp; j -= gap)
//					arr[j] = arr[j - gap];
//				arr[j] = temp;
			}
		}				
	}
	//method that prints an array
	private static void print(int[] arr) {
		for ( int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}	
	}
	public static void main(String[] args) {
		int arr[] = {12, 34, 54, 2, 3};
		System.out.println("Array before sorting:");
		print(arr);
		shellSort(arr);
		System.out.println("\nArray after sorting:");
		print(arr);
	}
}
