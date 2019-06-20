package JavaBasics;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpresions {
	public static void main(String[] args) {
		//way 1
		Pattern pattern = Pattern.compile("h..s");
		Matcher matcher = pattern.matcher("hors");
		System.out.println("way1: " + matcher.matches());
		
		//way 2
		System.out.println(Pattern.compile("...se").matcher("torse").matches());
		
		//way3
		System.out.println(Pattern.matches(".er", "omer"));
		System.out.println(Pattern.matches("..er", "omer"));
		System.out.println(Pattern.matches(".*er", "omer"));
		//email pattern capital letters
		System.out.println(Pattern.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", "MY@EMAIL.COM"));
		//email pattern 
		System.out.println(Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", "7.blabla@gmail.com"));
		//phone pattern
		System.out.println(Pattern.matches("0(([7][456728])|([23]51)).*", "0744831864"));
		System.out.println("test: " + Pattern.matches(".*", "sfsfsfsfserevwt 5657 735765"));
		System.out.println("test: " + Pattern.matches("([a-zA-Z]\\s*)*", "Happy new year"));
	}

}
