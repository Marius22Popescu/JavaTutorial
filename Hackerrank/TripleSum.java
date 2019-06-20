package Hackerrank;

import java.util.Iterator;
import java.util.TreeSet;
// Given 3 arrays a, b, c of different sizes, find the number of distinct triplets (p, q, r) where  is an element of a, 
//q is an element of b, r is an element of c, satisfying the criteria: p<=q and q >=r.

public class TripleSum {
	public static void main(String[] args) {
//		int a[] = {1, 4, 5};
//		int b[] = {2, 3, 3};
//		int c[] = {1, 2, 3};
	
//		int a[] = {1, 3, 5, 7};
//		int b[] = {5, 7, 9};
//		int c[] = {7, 9, 11, 13};
		
		int a[] = {1, 2, 3};
		int b[] = {7, 8, 9};
		int c[] = {5, 6, 7};
		
		System.out.println("nr of triplets is: "+ triplets(a, b, c));
	}
	static long triplets(int[] a, int[] b, int[]c) {
		a = sort(a);
		b = sort(b);
		c = sort(c);
		long al = 0;
		long bl = 0;
		long cl = 0;
		long answer = 0;
		
		while (bl < b.length) { // for each element in b
			while (al < a.length && a[(int) al] <= b[(int) bl]) al++;
			while (cl < c.length && c[(int) cl] <= b[(int) bl]) cl++;
			bl++;
			answer += al*cl; 
		}
		return answer;
	}
	private static int[] sort(int[] arr) {
		//create a tree set that will automatically sort and remove the duplicates from an given array
		TreeSet <Integer> tree = new TreeSet<Integer> (); //create the tree
		for (int i = 0; i<arr.length; i++) { //add to the tree
			tree.add(arr[i]);
		}
		int arrNew[] = new int[tree.size()];
		int j = 0;
		Iterator <Integer> it = tree.iterator();
		while (it.hasNext()) {
			arrNew[j] = it.next(); //from tree to the array
			j++;
		}
		return arrNew;
	}
}