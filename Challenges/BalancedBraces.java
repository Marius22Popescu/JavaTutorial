package Challenges;

public class BalancedBraces {

	public static void main (String [] args) {
		String s1  = "((()()";
		String s2  = "((()()))";
		String s3  = "())(";
		String s4  = "(())()()";
		isBalanced(s1);
		isBalanced(s2);
		isBalanced(s3);
		isBalanced(s4);
	}

	private static void isBalanced(String s) {
		boolean legal = true;
		boolean balanced = true;
		int count1 = 0;
		int l = s.length();
		for (int i = 0; i < l; i++) {
			if (count1 < 0) legal = false;
			if (s.charAt(i) == '(') count1++;
			if (s.charAt(i) == ')') count1--;	
		}
		for (int j = 0; j < l/2; j++) {
			if (s.charAt(j) == s.charAt(s.length()-1-j)) balanced = false;
		}
		if (legal && count1 == 0 && balanced)
			System.out.println("Ballanced");
		else 
			System.out.println("Not ballanced");		
	}
}
