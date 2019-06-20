package BitManipulation;
//Write a program to swap odd and even bits in an integer with a few instructions as possible eg. bit 0 an 1 are swapped
//bit 2 and 3 are swapped and so on.
public class PairwiseSwap {
	public static void main (String[] args) {
		int n = 1621;
		System.out.println(n+" in binary is: "+Integer.toBinaryString(n));
		System.out.println(swapOddEvenBits(n)+" in binary is: "+Integer.toBinaryString(swapOddEvenBits(n)));
	}
	static int swapOddEvenBits(int x) {
		return ( ((x & 0xaaaaaaaa) << 1)|((x & 0x55555555) >>> 1));
		//that hexadecimal 0xaaaaaaaa represents binary with even positions set as 1.- 01010101, then & will pick just
		//even bits, and << 1 will shift left by one them
		//0x55555555 represents binary with odd positions set as 1. - 10101010, then & will pick just odd bits, and
		// >>>1 will logical right shift instead of arithmetical because we want sign bit to be filled with 0
		// finally merge both masks with AND
	}
}
