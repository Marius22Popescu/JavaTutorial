package Challenges;

import java.util.HashSet;

//A gene can be representing by a string that is 8 characters long and contains only the characters 'A', 'C', 'G' and 'T'. 
//You want to investigate the numbers of mutations that  it takes to get from startStr to endStr, where one mutation is 
//defined as a change to one single character in the gene string. You also have a bank that contains a listing of all valid 
//gene mutation. A gene must be in the bank in order to be considered a valid gene string mutation. Write a method to determine
//the minimum number of valid mutation needed to obtain ebdStr from startStr.
public class MinimumGeneticMutation {
	
	public static void main (String[] args) {
		String ss1 = "AACCGGTT";
		String se1 = "AACCGGTA";
		String[] b1 = {"AACCGGTA"};
		System.out.println(minimumGeneticMutation(ss1, se1, b1));
		
		String ss2 = "AACCGGTT";
		String se2 = "AAACGGTA";
		String[] b2 = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		System.out.println(minimumGeneticMutation(ss2, se2, b2));
		
		String ss3 = "AAAAACCC";
		String se3 = "AACCCCCC";
		String[] b3 = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
		System.out.println(minimumGeneticMutation(ss3, se3, b3));
		
		String ss4 = "AACCGGTT";
		String se4 = "AACCGGTA";
		String[] b4 = {""};
		System.out.println(minimumGeneticMutation(ss4, se4, b4));
		
		String ss5 = "AACCGGTT";
		String se5 = "AACCGGTA";
		String[] b5 = {"AACCGGTA","AACCGCTA", "AAACGGTA" };
		System.out.println(minimumGeneticMutation(ss5, se5, b5));
		
		String ss6 = "AAAACCCC";
		String se6 = "CCCCCCCC";
		String[] b6 = {"AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC"};
		System.out.println(minimumGeneticMutation(ss6, se6, b6));
		
		String ss7 = "AACCTTGG";
		String se7 = "AATTCCGG";
		String[] b7 = {"AATTCCGG","AACCTGGG", "AACCCCGG", "AACCTACC" };
		System.out.println(minimumGeneticMutation(ss7, se7, b7));
		
		String ss8 = "AACCGGTT";
		String se8 = "AACCGCTA";
		String[] b8 = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		System.out.println(minimumGeneticMutation(ss8, se8, b8));
		
	}
	
	static int minimumGeneticMutation(String startStr, String endStr, String[] bank) {
		int mutations = 0;
		String inp = startStr;
		String evol;
		HashSet <String> bk = new HashSet <String> ();
		for (String s: bank) {
			bk.add(s);
		}
		int c = startStr.length();
		while (!inp.equals(endStr) && c > 0) {
			for (int i = 0; i < inp.length(); i++) {
				if (inp.equals(endStr)) break;
				if (inp.charAt(i) != endStr.charAt(i)){
				evol = inp.substring(0, i) + endStr.charAt(i) + inp.substring(i+1, 8);
					if (bk.contains(evol)) {
						mutations++;
						inp = evol;
					}		
				}
			}
			c --;
		}
		if (mutations == 0) mutations = -1;
		return mutations;
	}
}