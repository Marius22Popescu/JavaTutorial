package Challenges;
//Braces in a string are considered to be balanced if the following criteria are met:
//All braces must be closed. () [] {}
//In any set of nested braces,the braces between any pair must be closed.
//The function must return a array of answers YES or NO if the braces are legal
public class Braces {
	
	private static String[] braces(String[] b) {
		String[] ans = new String[b.length];
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		boolean legal = true;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length(); j++) {
				if (b[i].charAt(j) == '{') count1++;
				if (b[i].charAt(j) == '}') count1--;
				if (b[i].charAt(j) == '[') count2++;
				if (b[i].charAt(j) == ']') count2--;
				if (b[i].charAt(j) == '(') count3++;
				if (b[i].charAt(j) == ')') count3--;
				if (count1 < 0 || count2 < 0 || count3 < 0) legal = false; //cannot start with },] or )
			}
			for (int j = 0; j < b[i].length()-1; j++) {
				//cannot close with a different braces
				if (b[i].charAt(j) == '{' && b[i].charAt(j+1) == ')') legal = false; 
				if (b[i].charAt(j) == '{' && b[i].charAt(j+1) == ']') legal = false;
				if (b[i].charAt(j) == '[' && b[i].charAt(j+1) == ')') legal = false;
				if (b[i].charAt(j) == '[' && b[i].charAt(j+1) == '}') legal = false; 
				if (b[i].charAt(j) == '(' && b[i].charAt(j+1) == ']') legal = false;
				if (b[i].charAt(j) == '(' && b[i].charAt(j+1) == '}') legal = false;
			}
			if (count1 != 0 || count2 != 0 || count3 != 0) legal = false; //cannot have odd number of braces
			//add the answers to the answer array
			if(legal) ans[i] = "YES";
			else ans[i] = "NO";
			//reset the counters
			count1 = 0;
			count2 = 0;
			count3 = 0;
		}
		
		return ans;
	}
	
	public static void main (String[] args) {
		String[] braces = {"{}[]()", "{[][]()}", "{([])}","{[}]()", "{}()[", "({)[]}"};
		String[] answer = braces(braces);
		for (int i=0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
