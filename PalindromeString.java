
public class PalindromeString {
	public static void main (String[] args) {
		String s1 = "abcdddcba";
		String s2 = "abccbade";
		
		System.out.println(howManyPalindrome(s1));
		System.out.println(howManyPalindrome(s2));
	
	}
	//this method will return the number of palindrome that can be created from a given string
	private static int howManyPalindrome(String st) {
		int palNr = 0;		
		// build all the possible substrings in a string buffer
		for (int i = 0; i < st.length(); i ++) { //increase the beginning of string
			StringBuffer sb = new StringBuffer ();
			for (int j = i; j < st.length(); j++) { //increase the end of the string
				sb.append(st.charAt(j)); // create the string
				if (isPalindrome(sb)) palNr ++; // check if the string is palindrome
			}	
			
		}
		return palNr;
	}
	// this method will return true if a string is palindrome, false if it's not
	private static boolean isPalindrome(StringBuffer sb) {
		int l = sb.length()-1;
		boolean palindrome = true;
		for (int i = 0; i < sb.length()/2; i++) {
			if (sb.charAt(i) != sb.charAt(l)) {
				palindrome = false;
				break;
			}
			l --;
		}
		return palindrome;
	}
}
