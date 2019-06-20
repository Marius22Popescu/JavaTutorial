package Challenges;
// Given a two dimensional array, determine the value of the element at position [row, column]. The array will be presented 
// as string of space-separated integers. The first index contains an integer that denotes the length of each row. The 
// remaining integers are each elements of the array, first of row 1 then row 2 and so on. 
import java.util.ArrayList;

public class TheRestructuredArray {
	public static void main (String[] args) {
		String s1 = "4 98 20 -26 88 75 4 -18 85 23 45 61 95";
		String s2 = "4 1 2 3 4 5 6 7 8 9 10 11 12";
		System.out.println(getValue(s2, 3, 2));
		System.out.println(getValue(s1, 3, 4));
		
	}

	private static int getValue(String s, int y, int x) {
		int value = 0;
		int index = 0;
		String [] arr1 = s.split("\\s"); // split by space and insert in an array
		index = Integer.parseInt(arr1[0]) * (y - 1) + x; //calculate the index in array corresponding to a 2D array
		value = Integer.parseInt(arr1[index]); // get the value value from the array
		return value;
	}
}
