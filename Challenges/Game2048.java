package Challenges;
//2048 is played on gray 4x4 grid with numbered tiles that slide smoothly when a player moves them using one of the four
// arrows: U - up, D - down, L - left or R - right. After a key is pressed, the tiles slide as far as possible in the chosen 
// direction until they are stopped either by another tile or by edge of the grid. If two tiles with the same number collide
// while moving, they merge into a tile with this number doubled. You can't merge an already merged tile in the same turn.
//If there are more than 2 tiles in the same row (column) that can merge, the farthest (closest to an edge) pair will be
//merged first. Find the final state of the board from the given one after a defined set of key pressed. You are given a
//matrix 4X4 wich corresponds to the 2048 game grid and a sequence of key presses as a string path.
public class Game2048 {
	
	static int[][] game2048(int[][] grid, String path){
		int answer [][] = new int [4][4];
		answer = grid;		
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == 'R') {
				answer = slideRight(answer); //slide all elements right
				for (int y = 0; y < 4; y++) {  //for each row
					for (int x = 3; x > 0; x--) {  //for each element in the row
						if (answer[y][x-1] == answer[y][x] && answer[y][x] != 0) { // if both have the same value
							answer[y][x] = answer[y][x-1] + answer[y][x]; //merge elements
							answer[y][x-1] = 0;  // update the merged value
							answer = slideRight(answer); //slide all elements right again
						}
					}	
				}
			}
			if (path.charAt(i) == 'L') {
				answer = slideLeft(answer);  //slide all elements left
				for (int y = 0; y < 4; y++) {	//for each row
					for (int x = 0; x < 3; x++) {	//for each element in the row
						if (answer[y][x+1] == answer[y][x] && answer[y][x] != 0) {	// if both have the same value
							answer[y][x] = answer[y][x+1] + answer[y][x];	//merge elements
							answer[y][x+1] = 0;	// update the merged value
							answer = slideLeft(answer);	//slide all elements left again
						}
					}	
				}
			}
			if (path.charAt(i) == 'U') {
				answer = slideUp(answer);  //slide all elements up
				for (int x = 0; x < 4; x++) {	//for each element in the row
					for (int y = 0; y < 3; y++) {	//for each row					
						if (answer[y+1][x] == answer[y][x] && answer[y][x] != 0) {	// if both have the same value			
							answer[y][x] = answer[y+1][x] + answer[y][x];	//merge elements
							answer[y+1][x] = 0;	// update the merged value
							answer = slideUp(answer);	//slide all elements up again
						}
					}	
				}
			}
			if (path.charAt(i) == 'D') {
				answer = slideDown(answer);  //slide all elements down
				for (int x = 0; x < 4; x++) {	//for each element in the row
					for (int y = 3; y > 0; y--) {	//for each row							
						if (answer[y-1][x] == answer[y][x] && answer[y][x] != 0) {	// if both have the same value	
							answer[y][x] = answer[y-1][x] + answer[y][x];	//merge elements
							answer[y-1][x] = 0;	// update the merged value
							answer = slideDown(answer);	//slide all elements down again
						}
					}	
				}
			}
		}
		return answer;
	}
	private static int[][] slideDown(int[][] ar) {
		for (int y = 3; y >= 0; y--) {	//for each row
			for (int x = 0; x < 4; x++) {	//for each element in the row
				if (ar[y][x] == 0) {	// if current element is zero
					if ((y - 1) >= 0 && ar[y-1][x] != 0) { //slide previous element
						ar[y][x] = ar[y-1][x];
						ar[y-1][x] = 0;
					}
					else if ((y - 2) >=0 && ar[y-2][x] != 0) { //else slide second element
						ar[y][x] = ar[y-2][x];
						ar[y-2][x] = 0;
					}
					else if ((y - 3) >= 0 && ar[y-3][x] != 0) { //else slide third element
						ar[y][x] = ar[y-3][x];
						ar[y-3][x] = 0;
					}
				}
			}
		}
		return ar;
	}
	private static int[][] slideUp(int[][] ar) {
		for (int y = 0; y < 3; y++) {	//for each row
			for (int x = 0; x < 4; x++) {	//for each element in the row
				if (ar[y][x] == 0) {	// if current element is zero
					if ((y + 1) < 4 && ar[y+1][x] != 0) { //slide previous element
						ar[y][x] = ar[y+1][x];
						ar[y+1][x] = 0;
					}
					else if ((y + 2) < 4 && ar[y+2][x] != 0) { //else slide second element
						ar[y][x] = ar[y+2][x];
						ar[y+2][x] = 0;
					}
					else if ((y + 3) < 4 && ar[y+3][x] != 0) { //else slide third element
						ar[y][x] = ar[y+3][x];
						ar[y+3][x] = 0;
					}
				}
			}
		}
		return ar;
	}
	private static int[][] slideLeft(int[][] ar) {
		for (int y = 0; y < 4; y++) {	//for each row
			for (int x = 0; x < 3; x++) {	//for each element in the row
				if (ar[y][x] == 0) {	// if current element is zero
					if ((x + 1) < 4 && ar[y][x+1] != 0) { //slide previous element
						ar[y][x] = ar[y][x+1];
						ar[y][x+1] = 0;
					}
					else if ((x + 2) < 4 && ar[y][x+2] != 0) { //else slide second element
						ar[y][x] = ar[y][x+2];
						ar[y][x+2] = 0;
					}
					else if ((x + 3) < 4 && ar[y][x+3] != 0) { //else slide third element
						ar[y][x] = ar[y][x+3];
						ar[y][x+3] = 0;
					}
				}
			}
		}
		return ar;
	}
	private static int[][] slideRight(int[][] ar) {
		for (int y = 0; y < 4; y++) {	//for each row
			for (int x = 3; x > 0; x--) {	//for each element in the row
				if (ar[y][x] == 0) {	// if current element is zero
					if ((x - 1) >= 0 && ar[y][x-1] != 0) { //slide previous element
						ar[y][x] = ar[y][x-1];
						ar[y][x-1] = 0;
					}
					else if ((x - 2) >= 0 && ar[y][x-2] != 0) { //else slide second element
						ar[y][x] = ar[y][x-2];
						ar[y][x-2] = 0;
					}
					else if ((x - 3) >= 0 && ar[y][x-3] != 0) { //else slide third element
						ar[y][x] = ar[y][x-3];
						ar[y][x-3] = 0;
					}
				}
			}
		}
		return ar;
	}
	static void print (int [][] a) {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				System.out.print( a[y][x]);
			}
			System.out.println();
		}
	}
	public static void main (String [] args) {
		int a [][] = {{ 0, 0, 0, 0},
				      { 0, 0, 2, 2},
				      { 0, 0, 2, 4},
				      { 2, 2, 4, 8}};
		
		int a1 [][] = {{ 0, 0, 0, 0},
		      	   	   { 2, 0, 2, 2},
		      	       { 0, 0, 0, 0},
		      	       { 0, 0, 0, 0}};
		
		int a2 [][] = {{ 0, 0, 0, 2},
			      	   { 0, 0, 4, 2},
			      	   { 0, 0, 4, 2},
			      	   { 0, 0, 4, 2}};
		
//		System.out.println("***********RIGHT************");
//		String r = "R";
//		print(game2048(a, r));
//		System.out.println();
//		print(game2048(a, r));
//		System.out.println();
//		print(game2048(a, r));
//		System.out.println();
//		print(game2048(a1, r));
//		System.out.println("***********LEFT************");
//		String l = "L";
//		print(game2048(a, l));
//		System.out.println();
//		print(game2048(a, l));
//		System.out.println();
//		print(game2048(a, l));
//		System.out.println();
//		print(game2048(a1, l));
//		System.out.println("***********UP************");
//		String u = "U";
//		print(game2048(a, u));
//		System.out.println();
//		print(game2048(a, u));
//		System.out.println();
//		print(game2048(a1, u));
//		System.out.println("***********DOWN************");
//		String d = "D";
//		print(game2048(a, d));
//		System.out.println();
//		print(game2048(a, d));
//		System.out.println();
//		print(game2048(a1, d));
//		System.out.println();
//		print(game2048(a2, d));
//		System.out.println();
//		print(game2048(a2, d));
		System.out.println("***********MIX************");
		String m = "DRUL";
		print(game2048(a, m));
		System.out.println();
		String n = "DRRLLD";
		print(game2048(a2, n));
		System.out.println();
	}
}
