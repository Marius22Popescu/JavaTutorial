package BitManipulation;
//Write a function to determine the number of bits you would need to flip to convert integer A to integer B
public class Conversion {
	public static void main (String[] args) {
		int a = 17, b = 32;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(bitSwapRequired(a, b));
	}
	static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}		
		return count;
	}
}
