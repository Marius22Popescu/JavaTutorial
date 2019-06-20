package JavaBasics;
public class StringLecture {
	public static void main (String [] ards) {
		String s = "Omer";
		String s2 = "Omer";
		String s3 = "Omer";
		String s4 = "Muhammad";
	//compare	
		System.out.println("compare: " + s.compareTo(s2));
		System.out.println("compare: " +s.compareTo(s3));
		System.out.println("compare: " +s.compareTo(s4));
		System.out.println("compare: " +s3.compareTo(s));
		System.out.println("compare: " +s2.compareTo(s3));
		
		String s5 = "Pmer";
		System.out.println("compare: " +s.compareTo(s5));
	//Get one char from a string
		System.out.println("The caracter at index 3 is: " + s2.charAt(3));
	//Contains		
		System.out.println("contains: " +s.contains("Om"));		
	//Concat		
		System.out.println("concat: " +s4.concat(s));		
	//endsWith
		
		System.out.println("endWith: " +s.endsWith("r"));		
	//startsWith
		System.out.println("startWith: " +s.startsWith("O"));
	//equals
		System.out.println("equals: " +s2.equals(s3));
	//equalsIgnorCase	
		System.out.println("equalsIgnoreCase: " +s3.equalsIgnoreCase(s));
	//x == y
		System.out.println("x == y");
		System.out.println(s2 == s3);		
	//trimming
		String s6 = "  Hello";
		s6 = s6.trim();
		System.out.println("triming: " +s6);		
	//to lower cases
		String s7 = "   JOHN_DE@GMAIL";
		s7 = s7.toLowerCase();
		System.out.println(s7);
	//to upper cases	
		String s8 = "java";
		s8 = s8.toUpperCase();
		System.out.println("toUpperCase: " +s8);
	//length
		System.out.println("length: " +s7.length());
		System.out.println("length: " +s7.trim().length());
	//isEmpty
		String s9 = "full";
		String s10 = "";
		String s11 = " ";
		System.out.println("isEmpty: " +s9.isEmpty());
		System.out.println("isEmpty: " +s10.isEmpty());
		System.out.println("isEmpty: " +s11.isEmpty());
	//split	
		String s12 = "This is split";
		String[] arr = s12.split("\\s");
		for(String i: arr) {
			System.out.println("split: "+ i);			
		}
	}
}
