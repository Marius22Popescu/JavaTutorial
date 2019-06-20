package BitManipulation;
//You are given two 32 bit numbers, N and M, and two bit positions, i and j. Write a method to insert M into N such that
//M starts at bit j and ands at bit i. You can assume that the bits j through i have enough space to fit all of m.
public class BitInsertion {
	public static void main(String[] args) {
	int n = 1024;  //10000000000
	System.out.println("N is: "+Integer.toBinaryString(n));
	int m = 19; //10011
	System.out.println("M is: "+Integer.toBinaryString(m));
	int i = 2;
	int j = 6;
	//Desired output: 10001001100 that is 1100
	System.out.println("The output is: "+ doInsertion(n, m, i, j));
	}
	
	public static int doInsertion(int num, int m, int i,int j) {
		int answer = 0;
		int maskL = (1 << i) - 1; //create the left side of mask 000111
		int maskR = ~(-1 >>> (31 - j)); //create the right site of the mask 1111000
		int mask = maskL | maskR; //create the mask by AND both sides of mask
		int n = num & mask; // clear the bits between i and j
		int newM = (int) (m * Math.pow(2, i)); // put the m in the right position
		answer = newM | n; // create the answer with OR
		System.out.println("output in binary is: " +Integer.toBinaryString(answer));
		return answer;		
	}
}