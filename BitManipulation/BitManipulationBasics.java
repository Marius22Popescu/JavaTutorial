package BitManipulation;

public class BitManipulationBasics {
	public static void main(String[] args) {
		int num = 8;
		int i = 2;
		
		System.out.println("getBit: " +getBit(num, i));
		System.out.println("setBit: " +setBit(num, i));
		System.out.println("clearBit: "+clearBit(num, i));
		System.out.println("clearBitsMSBthroughI:"+clearBitsMSBthroughI(num, i));
		System.out.println("clearBitsIthrough0: "+clearBitsIthrough0(num, i));
		System.out.println("updateBit: "+updateBit(num, i, false));
		System.out.println("2 << 1: " + (2 << 1));
	}
	// num = 8 is 001000; 1 << 2 = 000100
	//This method will find if is a bit at i (2 to the power of i if exist). It shifts 1 over by i bits (if i = 2, will 
	//create a value like 000100). By performing an AND with num we clear all bits other than the bit at i. Finally, we
	//compare that if it is not zero. If it's not zero return true and we know that we have an bit on that position
	private static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}
	//setBit shifts 1 over by i bits (if i = 2, will create a value like 000100). By performing OR with num, only the value
	//at bit i will change. All other bits of the mask are 0 and will not affect the num.
	private static int setBit(int num, int i) {
		return num | (1 << i);
	}
	//This method will clear the bit at the required position i. It works in almost the reverse of setBit. First we create
	//the mask that will be the inverse of that from previous method (if i = 2 mask is 111011). Then perform AND with the 
	//num. This will clear the ith bit and leave the reminder unchanged. 
	private static int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}
	//This method will clear all bits from most significant bit to i inclusive. We create a mask with 1 at the ith bit
	//then subtract 1 from it, giving us a sequence of 0s followed by i 1s. (if i = 2, then 1 << 2 = 000100, and 
	//(1 << i) - 1 = 000011). Then clear the bits where are zeros. 
	private static int clearBitsMSBthroughI(int num, int i) {
		int mask = (1 << i) - 1;
		return num & mask;
	}
	//This method will clear all bits from i through 0 inclusive. We take a sequence of all 1s whic is (-1). Exp: 111111
	//Then shift it right by 31 - i. Because we use the logical shift it will move the bits to the right and fill with zeros 
	//in the most significant bits one by one. Our example will become 000011. After we negate in order to invert and 
	//get 111100, then clear the bits were is 0.
	private static int clearBitsIthrough0(int num, int i) {
		int mask = ~(-1 >>> (31 - i));
		return num & mask;
	}
	//The method will update the bit at i wit  1 if "true" is passed, if "false" is passed the method will update the bit
	//at i with 0. First we clear the bit at i the same like at clearBit. value will be 1 if true, 0 if false. 
	//Then we AND the cleared num with the (1 << i) if true, in our example 1 << 2 => 000100 and update the ith element
	//with 1; or with (0 << i) if false that will give 000000 and update ith element with 0.
	private static int updateBit(int num, int i, boolean bitIs1) {
		int value = bitIs1?1 : 0;
		int mask = ~(1 << i);
		System.out.println("value: "+value );
		return (num & mask) | (value << i);
	}
}
