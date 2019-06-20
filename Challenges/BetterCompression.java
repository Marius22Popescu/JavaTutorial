package Challenges;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

// Consider a string, S that is a series of characters, each followed by its frequency as an integer. The string is not 
// compressed correctly, so there may be many occurrence of the same character. A properly compressed string will consist
// of one instance of each character in alphabetical order followed by the total count of two character within the string.  
public class BetterCompression {
	
	public static String betterCompression (String s) {
		String newString = "";
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();		
		Queue <Character> cha = new LinkedList <Character> ();
		Queue <Integer> occ = new LinkedList <Integer> ();
		LinkedList <Character> c = new LinkedList <Character> ();
			
		char [] arr = s.toCharArray(); //convert the string in a char array
		int i = 0;
		int l = 0;
		
		while (i < arr.length) {  //split the string in two queue one for characters, one for occurrences
			if (arr[i] >= '0' && arr[i] <= '9') { // if number
			String nr = "";
				while (i < arr.length && arr[i] >= '0' && arr[i] <= '9') { //get the all number if many digits
					nr += arr[i];	
					i++;
				}
				occ.add(Integer.parseInt(nr));
			}
			else {
				cha.add(arr[i]);
				i++;
				l++;
			}
		}
		
		for (int j = 0; j < l; j++) {
			if (ht.get(cha.peek()) == null) { // if there is first occurrence of a character add to list and hash table
				c.add(cha.peek());
				ht.put(cha.remove(), occ.remove());			
			}
			else { 	//else if the character is already in the key set update the value in the hash
				int x = ht.get(cha.peek());
				ht.put(cha.remove(), occ.remove()+ x);
			}
		}

		c = sort(c); //sort the c array
		
		for (int k = 0; k < c.size(); k++) {	// build the new string
			newString += String.valueOf(c.get(k)) + ht.get(c.get(k));
		}
	
		return newString;
	}	
	// Method that will sort a LinkedList of Character
	private static LinkedList<Character> sort(LinkedList<Character> input) {
		LinkedList <Character> sorted = new LinkedList <Character> ();
		Character temp [] = new Character [input.size()];
		for (int i = 0; i<temp.length; i++) {
			temp[i] = input.get(i);
		}
		Arrays.sort(temp);
		for (int i = 0; i<temp.length; i++) {
			sorted.add(temp[i]);
		}
		return sorted;
	}

	public static void main (String [] args) {
		String s1 = "a12b56c1d3u89r2";
		String s2 = "a3c9b2c1";
		System.out.println(betterCompression(s1));
		System.out.println(betterCompression(s2));
	}
}