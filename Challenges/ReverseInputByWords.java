package Challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//Write a program to take a sentence as user input and reverse it by words(no letters).
//Do not use string functions
public class ReverseInputByWords {
	public static void main (String[] args) throws IOException {
		System.out.println("Please, enter a sentence:"); //prompt the user for a sentence
		BufferedReader is = new BufferedReader(new InputStreamReader(System.in)); 
		String responsLine = is.readLine();
		reverse(responsLine);
	}

	private static void reverse(String respons) {
		Stack<String> stack = new Stack<String>();
		String temp = "";
		for (int i = 0; i < respons.length(); i++) {
			if (respons.charAt(i) != ' ') { 
				temp += respons.charAt(i); 
			}
			else {
				stack.push(temp);
				temp = "";
			}			
		}
		stack.push(temp);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}				
	}
}
