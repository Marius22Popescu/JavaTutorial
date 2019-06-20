package Challenges;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//An IPv4 address is usually represented in dot-decimal notation, consisting of four decimal numbers separated by dots, 
//each ranging from 0 to 255, such as 172.68.58.63
public class IPAddressValidator {
	public static void main (String[] arg) {
		String ipAddress = "255.128.0.0"; //An IPv4 address 
		if( validateAddress(ipAddress)) {
			System.out.println("You entered a good IPv4 adress!");
		}
		else System.out.println("The entered address is NOT an IPv4 adress!");	
	}
	private static boolean validateAddress(String ipAddress) {
		boolean valid = true;
		Pattern pattern = Pattern.compile("[0-9]*.[0-9]*.[0-9]*.[0-9]*");
		Matcher matcher = pattern.matcher(ipAddress);
		valid = matcher.matches(); // Check if the address match the pattern
		if (valid) {
			int no = 0;
			for (int i = 0; i<ipAddress.length(); i++) {
				if (ipAddress.charAt(i) != '.') {
					no = no*10 + Character.getNumericValue(ipAddress.charAt(i)); // get the number
					if (no > 255) valid = false; //check if the numbers are greater than 255
				}
				else no = 0;	 //reset the number after the '.'
			}
		}	
		return valid;
	}
}