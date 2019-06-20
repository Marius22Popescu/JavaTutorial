package Challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// You are working on a computer simulation of a mobile robot. The robot moves on an infinite plane(0,0)
// Its movements are described by a command string consisting of one or more of the following letters:
// G - move forward one step; L - turn left; R - turn right. The robot perform the command in a infinite loop
// Find if the robot is move in a never ending circle.
public class Encircular {
	private static List<String> doesCircleExist(List<String> path) {
		List<String>answer = new ArrayList<String>(); 
		int totalX = 0; //initialize the starting point to (0, 0) on (x, y) coordinates 
		int totalY = 0;		
		String direction = "x"; //initialize the direction to x
		int zeroCrossings = 0;
		
		for (String p : path) { //iterate through all list
			for (int j = 0; j < 10000; j++) { //repeat 10000 times (simulate a infinite)
				for (int i = 0; i < p.length(); i++) { //iterate through the string
					// Update the number of crossings through origin
					if (totalX == 0 && totalY == 0) zeroCrossings ++;
					// Right command in the current direction change the direction to:
					else if (p.charAt(i) == 'R' && direction == "x") direction = "-y";
					else if (p.charAt(i) == 'R' && direction == "-y") direction = "-x";
					else if (p.charAt(i) == 'R' && direction == "-x") direction = "y";
					else if (p.charAt(i) == 'R' && direction == "y") direction = "x";
					// Left command in the current direction change the direction to:
					if (p.charAt(i) == 'L' && direction == "x") direction = "y";
					else if (p.charAt(i) == 'L' && direction == "y") direction = "-x";
					else if (p.charAt(i) == 'L' && direction == "-x") direction = "-y";
					else if (p.charAt(i) == 'L' && direction == "-y") direction = "x";
					// Move command changes the position in the given direction 
					if (p.charAt(i) == 'G' && direction == "x") totalX++;
					else if (p.charAt(i) == 'G' && direction == "y") totalY++;
					else if (p.charAt(i) == 'G' && direction == "-x") totalX--;
					else if (p.charAt(i) == 'G' && direction == "-y") totalY--;			 
				}
			}
			if (zeroCrossings > 2) answer.add("YES");
			else answer.add("NO");
			totalX = 0; //reset the X and Y coordinates
			totalY = 0;
			zeroCrossings = 0; //reset zeroCrossings counter
		}		
		return answer;
	}
	
	public static void main(String[] args) {
		List<String> path = Arrays.asList("RLGRRGGGLR", "GL", "GG", "GGLGGGRG");
		List<String>answer = doesCircleExist(path);
		for (String s: answer) System.out.println(s);		
	}
}
