package Hackerrank;

import java.util.Hashtable;
//We consider two strings to be anagrams of each other if the first string's letters can be 
//rearranged to form the second string. In other words, both strings must contain the same 
//exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but 
//bacdc and dcbad are not. Given two strings, a and b, that may or may not be of the same length,
//determine the minimum number of character deletions required to make  and  anagrams. 
//Any characters can be deleted from either of the strings. For example, a = cde if  and
//b = dcf, we can delete e from string a and f from string b so that both remaining strings are
//cd and dc which are anagrams.
public class MakingAnagrams {

	static int makeAnagram(String a, String b) {
        int nr = 0;
        Hashtable<Character, Integer> counter = new Hashtable<Character, Integer>();
        for (int i = 0; i < a.length(); i++){ // add string a to the counter
            if (counter.get(a.charAt(i))==null) counter.put(a.charAt(i), 1);
            else counter.put(a.charAt(i), counter.get(a.charAt(i))+1);
        }
        for (int j = 0; j < b.length(); j++) { // add string b to the counter with the negative value
            if (counter.get(b.charAt(j)) == null) counter.put(b.charAt(j), -1);
            else counter.put(b.charAt(j), counter.get(b.charAt(j))- 1);
        }
        for (Character s: counter.keySet()){ //sum up the total no. char that need to be  deleted
            nr += Math.abs(counter.get(s));
        }
        return nr;
    }
	
	public static void main(String[] args) {
		String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String b = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
		String a1 = "fcrxzwscanmligyxyvym";
		String b1 = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
		System.out.println(makeAnagram(a, b));
		
		
	}
}
