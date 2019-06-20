package BitManipulation;
//You have an integer and you can flip exactly one bit from 0 to a 1. Write code to find the length of the longest 
//sequence of 1s you could create
public class FlipBitToWin {
	public static void main (String[] args) {
		int n = 1775;
		String binaryN = Integer.toBinaryString(n);		//Convert to binary string
		System.out.println("The number " + n+" in binary is: "+ binaryN);
		//Find the max starting from 0 first time
		int max = getMax(0, binaryN, 0);
		//Find the max after each 01 sequence
		for (int i = 0; i < binaryN.length(); i++) {
			if(binaryN.charAt(i) == '0' && binaryN.charAt(i+1) == '1' && i < binaryN.length()-1) {
				int tempMax = getMax(i+1, binaryN, max);
				if (tempMax > max) max = tempMax; //update the max if a bigger max found
			}
		}
		System.out.println("The max is: "+ max);
	}
	//This method will find the max
	private static int getMax(int i, String binaryN, int max) {
		int count = 0;
		int negCount = 0;
		while (negCount < 2 && i < binaryN.length()) { //finish if more like one 0 that can be updated
			if (binaryN.charAt(i) == '0') 	negCount++;
			if (negCount < 2) count++;  //update the count, just if we have one 0
			if (count > max) max = count;
			i++;
		}
		return max;
	}
}