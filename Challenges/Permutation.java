package Challenges;

public class Permutation {
	public static void main(String[] args) { 
        String str = " +-*"; 
        Permutation permutation = new Permutation(); 
        permutation.permute(str, 0, str.length()-1); 
    } 
  
    private void permute(String str, int l, int r) { 
        if (l == r) 
            System.out.println(str); //print the string
        else{ 
            for (int i = l; i <= r; i++) { 
                str = swap(str,l,i); //swap the string
                permute(str, l+1, r); //permute the new string
                str = swap(str,l,i); //swap the string back, to keep it in order to print when l==r
            } 
        } 
    } 
    //this method will swap two characters in a string
    public String swap(String a, int i, int j) { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; //store one char in a temporary variable
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 	
}
