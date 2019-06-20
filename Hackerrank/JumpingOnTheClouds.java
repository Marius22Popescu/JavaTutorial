package Hackerrank;
//Emma is playing a new mobile game that starts with consecutively numbered clouds. 
//Some of the clouds are thunderheads and others are cumulus. 
//She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus  or . 
//She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting 
//postion to the last cloud. It is always possible to win the game. For each game, Emma will get an array of 
//clouds numbered  if they are safe or  if they must be avoided.

public class JumpingOnTheClouds {
	public static void main (String args[]) {
		int[] c = {0, 0, 1, 0, 0, 0, 0, 0, 1, 0};
		System.out.println(jumpingOnClouds(c));
	}

	private static int jumpingOnClouds(int[] c) {
		int nr = 0;
		int poz = 0; 
		while (poz < c.length -1) {
			if (((poz+2) <= c.length-1) && (c[poz+2] != 1)) {
				poz = poz + 2;
				nr++;
			}
			else 
				if (((poz+1) <= c.length-1) && (c[poz+1] != 1)) {
				poz++;
				nr++;
			}
		}
		return nr;
	}
}
