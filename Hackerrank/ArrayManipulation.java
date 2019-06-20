package Hackerrank;

public class ArrayManipulation {
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
		long answers[] = new long[n]; //create the answers array
		for (int j = 0; j < queries.length; j++) { 
			int x = queries[j][0]-1; //get the first index to be updated
			int y = queries[j][1]-1; //get the last index to be updated
			for (int k = x; k <= y; k++) { 
				answers[k] += queries[j][2]; //update values between indexes
				if(max < answers[k]) max = answers[k]; //update max
			}	
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