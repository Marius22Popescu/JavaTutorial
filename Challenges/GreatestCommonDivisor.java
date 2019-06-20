package Challenges;

import java.util.Arrays;
//Write an algorithm to determine the greatest common divisor (GCD) of N positive numbers
public class GreatestCommonDivisor {
	
	public static void main(String[] args) {
		int[] arr = {95, 45, 60, 85, 30, 35}; 
		//int[] arr = {2, 4, 6, 8, 10};
		//int[] arr = {2, 3, 4, 5, 6};
		System.out.println("The GCD is:" + generalizedGCD(arr.length, arr));
	}
	private static int generalizedGCD(int length, int[] arr) {
		Boolean ans = true;
		Arrays.sort(arr);
		int gcd = arr[0]; //make the gcd the smallest element in the array 
		for (int d = 1; d <= gcd; d++) { //increase the division numerator from 1 (to get the smallest element from the array) 
		//until the smallest elem from the arry (in order to get 1) 
			gcd /= d; //divide the gcd if is not the great
			for (int j= 0; j<length; j++) {
				ans = true;
				if (arr[j]%gcd !=0) { //if gcd is not divisor break
					ans = false;
					break;
				}
			}
			if (ans)   //if gcd found break the loop 
				break;
		}
		return gcd;
	}
}
