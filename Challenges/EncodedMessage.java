package Challenges;

import java.util.ArrayList;

public class EncodedMessage {
	public static void main (String[] args) {
		String message = "01001000 01100101 01101100 01101100 01101111 00100001"; // hello!
		String key =     "1001011001100111000111010101";
		String encodedMessage = encodeDecode(message, key);
		System.out.println(encodedMessage);
		String decodedMessage = encodeDecode(encodedMessage, key);
		System.out.println(decodedMessage);
	}
//String builder
	private static String encodeDecode(String message, String key) {
		String encoded = "";
		StringBuffer enc = new StringBuffer();
		String[] words = message.split("\\s"); // split the message by words
		// encode/decode each word with xor
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				if (words[i].charAt(j) == key.charAt(j)) enc.append("0"); // 1^1 = 0 or 0^0 = 0
				else if (words[i].charAt(j) != key.charAt(j)) enc.append("1"); // 1^0 = 1 or 0^1 = 1
			}
			enc.append(" "); //append a space after each word
		}
		encoded = String.valueOf(enc);
		return encoded;
	}
}