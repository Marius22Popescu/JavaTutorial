package Challenges;
//Given an array of integers a0, a1, a2, ..ai, aj, .. an-1, and a positive integer k.
//Find and print the number of pairs where i<j and ai+aj is evenly divisible by k.
public class NumberOfPairsDivisibleByK {
	public static void main (String[] args) {
		int[] a = {1, 3, 2, 6, 1, 2};
	//	int[] a = {1, 5, 8, 2, 4, 1, 2};
		int k = 3;
		int pairs = 0;
		
		for (int i = 0; i < a.length; i++) {
			for(int j = i+1; j<a.length; j++) {
				if ((a[i] + a[j])%k == 0) //check if the sum of pairs is divisible by k
					pairs++;		//then, increase the pairs counter
			}	
		}
		System.out.println("Number of pairs: " + pairs);
	}
}
