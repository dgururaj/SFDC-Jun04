package bootcamp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pattern p = Pattern.compile(".*\\\"(.*)\\\".*");
		Matcher matcher = p.matcher("your \"ddd\" here");
		if(matcher.find()) {
            System.out.println(matcher.group(1));
        }
		}

public void fcase() {
		
		
	}
	
}
