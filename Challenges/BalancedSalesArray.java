package Challenges;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of sales numbers, what is the smallest index element for which the sums of all elements to the
//left and to the right are equal.The array can not be reordered. The function will return the index of the 
//smallest element for which the sum of elements to its left and right are equal
public class BalancedSalesArray {
	private static int balancedSum(List<Integer> s) {
		int index = Integer.MAX_VALUE;
		int sumL = 0;
		int sumR = 0;
		for (int i =0; i<s.size(); i++) {
			for (int j =0; j < i; j++) {
				sumL += s.get(j);
			}
			for (int j =i+1; j <s.size(); j++) {
				sumR += s.get(j);
			}
			if (sumL == sumR && index == Integer.MAX_VALUE) index = i; 
			if (sumL == sumR && s.get(i) < s.get(index)) index = i;
			System.out.println("i is: " + i+" sumL is: "+sumL+" sumR is:"+sumR+" index is: "+index);
			sumL =0;
			sumR =0;
		}
		
		return index;
	}
	public static void main (String[] args) {
		//Adding multiple elements in a List
		List<Integer> sales1 = Arrays.asList(1, - 2, 3, 4, 2, 1, 8);  //1st way	
		List<Integer> sales2 = new ArrayList<>(Arrays.asList(- 2, 3, 4, - 5, 0, 2, 4,- 3, -4, 0));  //2nd way
		List<Integer> sales3 = new ArrayList <Integer>();  //3rd way
		sales3.addAll(Arrays.asList(1 , 2, 3, 3));
		Integer[] array = {- 1,- 2, 3, 0, 0};			//4th way
	    ArrayList<Integer> sales4 = new ArrayList<>(Arrays.asList(array));
	    System.out.println(balancedSum(sales1));
	    System.out.println(balancedSum(sales2));
	    System.out.println(balancedSum(sales3));
	    System.out.println(balancedSum(sales4));
	}
}
