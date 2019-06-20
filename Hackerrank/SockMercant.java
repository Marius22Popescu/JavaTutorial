package Hackerrank;
//John works at a clothing store. He has a large pile of socks that he must pair by color for sale. 
//Given an array of integers representing the color of each sock, determine how many pairs of socks with
//matching colors there are.


import java.util.ArrayList;

public class SockMercant {
	public static void main(String[] args) {
		int[] ar = {1, 2, 1, 2, 1, 3, 2};
		int n = ar.length;
		int x = sockMerchant(n, ar);
		System.out.println("The number of socks is: " + x);
	}

	private static int sockMerchant(int n, int[] ar) {
		ArrayList <Integer> unpaired = new ArrayList<Integer>();
		int pairs = 0;
		for (int i = 0; i< n-1; i++) {
			if (found(ar[i], unpaired)) {
				pairs++;
				unpaired.remove(ar[i]);
			}
			else {
				unpaired.add(ar[i]);
			}
		}
		return pairs;
	}

	private static boolean found(int i, ArrayList<Integer> unpaired) {
		boolean found = false;
		for (int s: unpaired) {
			if (i == s)
				found = true;
		}
		return found;
	}
}
