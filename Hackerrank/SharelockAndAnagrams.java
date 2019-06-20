package Hackerrank;

import java.util.ArrayList;
import java.util.HashMap;


//Two strings are anagrams of each other if the letters of one string can be rearranged to form the 
//other string. Given a string, find the number of pairs of substrings of the string that are anagrams 
//of each other. For example s = mom, the list of all anagrammatic pairs is [m, m], [mo, om] at positions
//[[0],[2]], [[0,1],[1,2]] respectively.
public class SharelockAndAnagrams {
	
	private static int sherlockAndAnagrams(String s) {
		int anagramNr = 0;
		//Create all possible substrings
		for (int len = 1; len <= s.length(); len++) { // Pick the length of the string   
			ArrayList <ArrayList <Character>> words = new ArrayList <ArrayList <Character>>(); //array that will keep all possible substrings
            for (int start = 0; start <= s.length() - len; start++) { // Pick starting point           	
            	// Array list of char that will hold each word 
            	ArrayList <Character> w = new ArrayList <Character>();
                int end = start + len - 1; // Pick ending point  
                //  add characters from current starting point to current ending point.
                for (int i = start; i <= end; i++) {
                	w.add(s.charAt(i));
                } 
                words.add(w); //add the word in the array of words              
            }            
            // check one by one if is a anagram
            for (int i = 0; i < words.size(); i++) {
    			for (int j = i+1; j < words.size(); j++) {
    			if (compare(words.get(i), words.get(j))) anagramNr++;
    			}
    		}	
        } 
		return anagramNr;	
	}
	
	private static boolean compare(ArrayList<Character> al1, ArrayList<Character> al2) {
		boolean equal = true;
		HashMap <Character, Integer> hm = new HashMap <Character, Integer> (); 
		// insert first array list in the hash map
		for (int i = 0; i < al1.size(); i ++) {
			if (hm.get(al1.get(i)) == null) hm.put(al1.get(i), 1);
			else hm.put(al1.get(i), hm.get(al1.get(i))+1);
		}
		// insert second array list in the hash map
		for (int i = 0; i < al2.size(); i ++) {
			if (hm.get(al2.get(i)) == null) hm.put(al2.get(i), -1);
			else hm.put(al2.get(i), hm.get(al2.get(i))- 1);
		}
		// check if is anagram
		for (Character c: hm.keySet()) {
			if (hm.get(c) != 0) equal = false;
		}
		return equal;
	}
	
	public static void main (String[] args) {
		String s1 = "abba";
		String s2 = "abcd";
		String s3 = "ifailuhkqq";
		String s4 = "kkkk";
		String s5 = "cdcd";
		System.out.println(sherlockAndAnagrams(s1));
		System.out.println(sherlockAndAnagrams(s2));
		System.out.println(sherlockAndAnagrams(s3));
		System.out.println(sherlockAndAnagrams(s4));
		System.out.println(sherlockAndAnagrams(s5));
	}
}
