package Challenges;
public class RemuveDuplicatesFromAString {
	public static void main (String[] args) {
		String oldString = "abbcd";
		String newString ="";
		
		for (int i = 0; i< oldString.length(); i++) {
			char c = oldString.charAt(i);
			if(!charFound(c, newString))
				newString += c;
		}
		System.out.println(newString);
	}

	private static boolean charFound(char c, String newString) {
		for (int j = 0; j< newString.length(); j++) {
			if (c == newString.charAt(j))
				return true;
		}
		return false;
	}

}
