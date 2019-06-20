package Challenges;

public class SubstringsOfAString {
	// Function to print all sub strings 
    static void subString(char str[], int length) {   	
        for (int len = 1; len <= length; len++) { // Pick the length of the string          
            for (int start = 0; start <= length - len; start++) { // Pick starting point    
                int end = start + len - 1; // Pick ending point  
                //  Print characters from current starting point to current ending point.
                for (int i = start; i <= end; i++) { 
                    System.out.print(str[i]); 
                } 
                System.out.println(); 
            } 
        } 
    }   
    // Driver program to test above function 
    public static void main(String[] args) { 
        char str[] = {'a', 'b', 'c', 'd'}; 
        subString(str, str.length);   
    } 
}