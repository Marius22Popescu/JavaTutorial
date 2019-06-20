package Challenges;
//Write a program to find the Second largest number in a given array. You should not sort or modify the array.
public class SecondLargestNumber {
	public static void main (String[] args) {
		int []a = {29, 33, 12, 3, 17, 55, 22, 88, 6, 73, 45, 44, 99, 21, 15, 79, 77, 51};
		//int []a = {-343, -23, -35, -6765, -345};
		int largest = getLargest(a); //get the index of the largest element
		int secondLargest = getSecondLargest(a, largest); //get the second largest element
		System.out.println("The Second Largest element in the array is: " + secondLargest);
	}

	private static int getSecondLargest(int[] a, int largest) {
		int sl = 0;
		if (largest != 0)
			sl = 0;
		else
			sl = 1;
		for (int j = 0; j < a.length; j++) {
			if ((a[sl] < a[j]) && (a[j] < a[largest]))
				sl = j;
		}
		return a[sl]; //return the second largest element
	}

	private static int getLargest(int[] a) {
		int l= 0; //assign first index to the largest element
		for (int i = 0; i < a.length; i++) {
			if (a[l] < a[i]) {
				l = i;
			}
		}
		return l; //return the index of the largest element
	}
}
