package Challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Write down all pairs of numbers from the array
//Compute the product of each pair
//find the sum of all the products
public class PairsOfArray {
	public static void main(String[] args) {
	int[] a  = {7, 2, -1, 2};
	ArrayList<Integer[]> pairs = new ArrayList<Integer[]>();
	ArrayList<Integer> products = new ArrayList<Integer>(); 
	pairs = getPairs(a);
	products = productOfPairs(pairs);
	printSumOfProducts(products);
	}
	//This method will display the sum of products
	private static void printSumOfProducts(ArrayList<Integer> products) {
		int sum = 0;
		for(int e: products) {
			sum += e;
		}
		System.out.print("Sum of the products: "+sum );	
	}
	//this method will compute and print the product of the pairs
	private static ArrayList<Integer> productOfPairs(ArrayList<Integer[]> pairs) {
		System.out.print("Products of the pairs are: ");
		ArrayList<Integer> prod = new ArrayList<Integer>();
		for (Integer[] e: pairs) {
			prod.add(e[0]*e[1]);
		}
		for (int el: prod) {
			System.out.print(el+ ", ");
		}
		System.out.println("");
		return prod;
	}
	private static ArrayList<Integer[]> getPairs(int[] a) {
		System.out.print("Pairs: ");
		ArrayList<Integer[]> p = new ArrayList<Integer[]>();	
		//store the pairs
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				Integer[] element = {0, 0};
				element[0]= a[i];
				element[1]= a[j];
				p.add(element);
			}
		}//print the pairs
		for (int i = 0; i < p.size(); i++) {
			System.out.print("(" + p.get(i)[0] + ", " + p.get(i)[1] + " )");
		}
		System.out.println("");
		return p;
	}
}
