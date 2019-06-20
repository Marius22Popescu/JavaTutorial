package Hackerrank;

import java.util.Stack;

public class BalancedBrakets {
	public static void main(String[] args) {
		String brakets1 = "{}";
		String brakets2 = "}([[{)[]))]{){}[";
		String brakets3 = "{]] {()}{])";
		
		System.out.println(isBalanced(brakets1));
		System.out.println(isBalanced(brakets2));
		System.out.println(isBalanced(brakets3));
	}
	public static String isBalanced(String s) {
		String ans = "";
		Boolean balanced = true;
		Stack<Character> stack = new Stack <Character>();
		for (int i = 0; i< s.length(); i++) {
			if (!balanced) break;  //if become unbalanced break
			//if open brackets push to stack
			else if (s.charAt(i) == '{') stack.push('{');
			else if (s.charAt(i) == '[') stack.push('[');
			else if (s.charAt(i) == '(') stack.push('(');
			//if close brackets, stack not empty and pick is open bracket => pop
			else if (s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{') stack.pop();
			else if (s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[') stack.pop();
			else if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(') stack.pop();
			else balanced = false; //else is no more balanced
		}
		
		if (!stack.empty()) balanced = false;
		if (balanced) ans = "YES";
		else ans = "NO";
		return ans;

//		Stack<Character> stack = new Stack<>();
//        char upperElement = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (!stack.isEmpty()) {
//                upperElement = stack.peek();
//            }
//            stack.push(s.charAt(i));
//            if (!stack.isEmpty() && stack.size() > 1) {
//                if ((upperElement == '[' && stack.peek() == ']') || (upperElement == '{' && stack.peek() == '}') ||
//                        (upperElement == '(' && stack.peek() == ')')) {
//                    stack.pop();
//                    stack.pop();
//                }
//            }
//        }
//        return stack.isEmpty() ? "YES" : "NO";
		
		
	}
}
