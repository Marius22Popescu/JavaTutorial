package Hackerrank;

import java.util.Hashtable;
//Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through 
//his handwriting. He found a magazine and wants to know if he can cut out whole words from it and use them 
//to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use
//only whole words available in the magazine. He cannot use substrings or concatenation to create the words he 
//needs. Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his 
//ransom note exactly using whole words from the magazine; otherwise, print No.

public class RansomNote {
	
	private static void checkMagazine(String[] magazine, String[] note) {
		boolean answer = true;
        Hashtable<String, Integer> noteHT = new Hashtable<String, Integer>();
        Hashtable<String, Integer> magazineHT = new Hashtable<String, Integer>();
        if (magazine.length >= note.length) { //if the magazine is bigger than note check forward, else is not possible
            //copy the note array in a hash table
            for (int j = 0; j < note.length; j++) { 
                if (noteHT.get(note[j]) == null) noteHT.put(note[j], 1); //if no value, put one in hash    
                else noteHT.put(note[j], noteHT.get(note[j])+1); //if value in hash, add one
            }
            //copy the note array in a hash table
            for (int j = 0; j < magazine.length; j++) { 
                if (magazineHT.get(magazine[j]) == null) magazineHT.put(magazine[j], 1); //if no value, put one in hash   
                else magazineHT.put(magazine[j], magazineHT.get(magazine[j])+1); //if value in hash, add one
            }
            //check if words from note are in magazine	
            for (String s: noteHT.keySet()) { //for each word in note
            	for (int x = noteHT.get(s); x >= 1; x--) { //for each occurrence of that word
           			if(magazineHT.get(s) != null) { //if word found
           				if (magazineHT.get(s) == 1) magazineHT.remove(s); //remove the key (remove the word)
           				else  magazineHT.put(s, magazineHT.get(s)-1); //decrease the value
           			}
           			else {  //if word not in magazine break because is no more possible
           				answer = false;
           				break; 
           			}
           		}
            	if(!answer) break; //break if we know that is no more possible
           	}
        } 
        else answer = false; 
        if(answer) System.out.println("Yes");
        else System.out.println("No");
	}
	public static void main (String[] args) {
		String magazine[] = {"give", "me", "one", "grand", "today", "night"};
		String note[] = {"give", "one", "grand", "today"};
		String magazine1[] = { "two", "times", "three", "is", "not", "four"};
		String note1[] = {"two", "times", "two", "is", "four"};
		checkMagazine(magazine, note);
	}
}
