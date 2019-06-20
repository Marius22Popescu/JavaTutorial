package Hackerrank;

public class ArrayManipulationInprouved {
	public static void main(String[] args) {
		int queries[][]= new int [3][3];
		queries[0][0]= 1;
		queries[0][1]= 5;
		queries[0][2]= 3;
		queries[1][0]= 4;
		queries[1][1]= 8;
		queries[1][2]= 7;
		queries[2][0]= 6;
		queries[2][1]= 9;
		queries[2][2]= 1;
		
		int queries2 [][] = { { 1, 2, 100},
							  { 2, 5, 100},
							  { 3, 4, 100} };
		
		print(queries);
		print(queries2);
		System.out.println(arrayManipulation(10, queries));
		System.out.println(arrayManipulation(10, queries2));
	}
	static long arrayManipulation(int n, int[][] queries) {
		long max = 0;
		int x = 0; //first index to be updated by queries
		int y = 0; //last index to be updated by queries
		int val = 0; //the value that need to be added
		long sum = 0; //the sum at each index
		long answers[] = new long[n+1]; //create the answers array
		
		for (int j = 0; j < queries.length; j++) { 
			x = queries[j][0]; //get the start index
			y = queries[j][1]; //get the end index
			val = queries[j][2]; //get the value
			answers[x-1] += val; //mark the beginning of interval
			if (y < (n+1)) answers[y] -= val; //mark the end of interval
		}
		
		for (int i =0; i < answers.length; i++) {
			sum += answers[i]; // calculate sum at each index
			if (max < sum) max = sum; // update the max
		}
		return max;
	}
	private static void print(int[][] queries) {
		for (int i =0; i < queries.length; i++) {
			for (int j =0; j < queries.length; j++) {
				System.out.print(queries[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
