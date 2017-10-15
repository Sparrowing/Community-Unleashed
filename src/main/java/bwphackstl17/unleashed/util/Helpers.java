package bwphackstl17.unleashed.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {
	
	/*
	 * Returns whether or not String match matches the supplied regex pattern
	 */
	public static boolean isRegexMatch(String regex, String match) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(match);
		return matcher.matches();
	}
	
	/*
	 * Returns true if an input field has any content, else false
	 */
	public static boolean isBlankField(String field) {
		return field == null || field == "";
	}

}
