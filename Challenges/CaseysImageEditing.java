package Challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaseysImageEditing {
	public static int largestMatrix(List<List<Integer>> arr) {
		int largestSize = 0;	
		for (int y = 0; y < arr.size(); y++) { // for all elements in the array
			for (int x = 0; x < arr.size(); x++) {
				if (arr.get(y).get(x) == 1) {  // if the element is 1 (pixel) proceed
					int size = 0; // create a temp size, never update to 0, just increase in order to check for a bigger size					
					while (size < arr.size()) {
						boolean pixel = true;
						for (int i = 0; i <= size; i++) {
							for (int j = 0; j <= size; j++) {
								if(arr.get(i).get(j) == 0) {
									pixel = false;
									break;
								}
							}
						}
						if (pixel) largestSize = size + 1; //if all square has pixels update the largest size
						size++;
					}
				}
			}
		}
		return largestSize;
	}
	
	public static void main (String [] args) {
		List <List<Integer>> a = new ArrayList <List<Integer>> ();
		a.add(Arrays.asList(1, 1, 1, 1, 1));
		a.add(Arrays.asList( 1, 1, 1, 0, 0));
		a.add(Arrays.asList( 1, 1, 1, 0, 0));
		a.add(Arrays.asList( 1, 1, 1, 0, 0));
		a.add(Arrays.asList( 1, 1, 1, 1, 1));
		System.out.println(largestMatrix(a));
		
		List <List<Integer>> a1 = new ArrayList <List<Integer>> ();
		a1.add(Arrays.asList( 1, 1, 1));
		a1.add(Arrays.asList( 1, 1, 0));
		a1.add(Arrays.asList( 1, 0, 1));
		System.out.println(largestMatrix(a1));
		}
}
